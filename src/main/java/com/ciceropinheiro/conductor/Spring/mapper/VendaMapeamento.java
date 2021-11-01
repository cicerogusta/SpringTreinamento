package com.ciceropinheiro.conductor.Spring.mapper;


import com.ciceropinheiro.conductor.Spring.dto.request.VendaRequest;
import com.ciceropinheiro.conductor.Spring.dto.response.VendaResponse;
import com.ciceropinheiro.conductor.Spring.model.Venda;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VendaMapeamento extends GenericMapper<Venda, VendaRequest, VendaResponse>{

    @Mapping(source = "idCliente", target = "cliente.id")
    Venda requestForEntity (VendaRequest vendaRequest);
}
