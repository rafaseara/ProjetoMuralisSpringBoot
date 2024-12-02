package com.muralis.api_restful.dto;

public record ClienteRequestDTO(
    String nome,
    String dataCadastro,
    ContatoRequestDTO contato) {

}
