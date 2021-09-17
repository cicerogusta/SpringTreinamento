package com.ciceropinheiro.conductor.Spring.services;

import com.ciceropinheiro.conductor.Spring.dto.request.LancamentoRequest;
import com.ciceropinheiro.conductor.Spring.dto.response.LancamentoResponse;
import com.ciceropinheiro.conductor.Spring.mapper.LancamentoMapper;
import com.ciceropinheiro.conductor.Spring.model.LancamentoVenda;
import com.ciceropinheiro.conductor.Spring.model.Venda;
import com.ciceropinheiro.conductor.Spring.repository.LancamentoVendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LancamentoVendaService {

    @Autowired
    private LancamentoMapper lancamentoMapper;

    @Autowired
    private LancamentoVendaRepository lancamentoVendaRepository;


    public void gerarLancamentos(Venda venda) {
        Integer diaCorte = venda.getCliente().getDiaCorte();
        Integer diaVencimento = venda.getCliente().getDiaVencimento();
        LocalDate atual = LocalDate.now();
        LocalDate dataVencimento = atual.withDayOfMonth(diaVencimento);
        if (diaCorte < atual.getDayOfMonth()) {
            if (diaVencimento > diaCorte) {
                dataVencimento = dataVencimento.plusMonths(1L);
            } else {
                dataVencimento = dataVencimento.plusMonths(2L);
            }
        } else {
            if (diaCorte > diaVencimento) {
                dataVencimento = dataVencimento.plusMonths(1L);
            }
        }
        List<LancamentoVenda> lancamentos = new ArrayList<>();
        for (int i = 0; i < venda.getQuantidadeParcelas(); i++) {
            LancamentoVenda lancamento = new LancamentoVenda();
            lancamento.setVenda(venda);
            lancamento.setNumeroParcela(i + 1);
            lancamento.setValorParcela(venda.getValor().divide(BigDecimal.valueOf(venda.getQuantidadeParcelas())));
            lancamento.setDataVencimento(dataVencimento);
            dataVencimento = dataVencimento.plusMonths(1L);
            lancamentos.add(lancamento);
        }
        lancamentoVendaRepository.saveAll(lancamentos);
    }

    public List<LancamentoVenda> recuperarLancamentoVenda() {
        return lancamentoVendaRepository.findAll();
    }

    public Optional<LancamentoVenda> recuperarLancamentoVendaById(Long id) {
        return lancamentoVendaRepository.findById(id);

    }

    public LancamentoResponse gerarAtualizacao(Long id, LancamentoRequest lancamentoVenda) {
        LancamentoVenda entidade = lancamentoVendaRepository.getOne(id);
        atualizar(entidade, lancamentoVenda);
        return lancamentoMapper.entityForResponse(lancamentoVendaRepository.save(lancamentoMapper.requestForEntity(lancamentoVenda)));
    }


    public void atualizar(LancamentoVenda entidade, LancamentoRequest lancamentoVenda) {
        entidade.setValor(lancamentoVenda.getValor());
        entidade.setDataVencimento(lancamentoVenda.getDataVencimento());
        entidade.setNumeroParcela(lancamentoVenda.getNumeroParcela());
    }

    public void deletarLancamento(Long id) {
        lancamentoVendaRepository.deleteById(id);
    }


}



