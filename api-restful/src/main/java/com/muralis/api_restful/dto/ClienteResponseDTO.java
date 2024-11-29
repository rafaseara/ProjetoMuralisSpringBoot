package com.muralis.api_restful.dto;

import com.muralis.api_restful.entity.Cliente;

public record ClienteResponseDTO(
    Long id,
    String nome,
    String dataCadastro,
    ContatoResponseDTO contato
) {
    public ClienteResponseDTO(
        Cliente cliente
    ) {
        this(
            cliente.getId(),
            cliente.getNome(),
            cliente.getDataCadastro(),
            new ContatoResponseDTO(cliente.getContato())
        );
    }
} 
