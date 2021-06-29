package com.ciceropinheiro.conductor.Spring.mapper;

import com.ciceropinheiro.conductor.Spring.dto.request.ClienteRequest;
import com.ciceropinheiro.conductor.Spring.dto.response.ClienteResponse;
import com.ciceropinheiro.conductor.Spring.model.Cliente;
import org.mapstruct.Mapper;

@Mapper
public interface ClienteMapper extends GenericMapper <Cliente, ClienteRequest, ClienteResponse> {
}
