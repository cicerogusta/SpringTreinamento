package com.ciceropinheiro.conductor.Spring.mapper;

import com.ciceropinheiro.conductor.Spring.dto.request.LancamentoRequest;
import com.ciceropinheiro.conductor.Spring.dto.response.LancamentoResponse;
import com.ciceropinheiro.conductor.Spring.model.LancamentoVenda;
import org.mapstruct.Mapper;

@Mapper
public interface LancamentoMapper extends GenericMapper <LancamentoVenda, LancamentoRequest, LancamentoResponse> {
}
