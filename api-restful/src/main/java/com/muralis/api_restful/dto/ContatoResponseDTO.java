package com.muralis.api_restful.dto;

import com.muralis.api_restful.entity.Contato;

public record ContatoResponseDTO(
    String tipo,
    String texto
) {
    public ContatoResponseDTO(Contato contato) {
        this(contato.getTipo(), contato.getTexto());
    }
}
