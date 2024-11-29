package com.muralis.api_restful.dto;

public record ClienteRequestDTO(
    String nome,
    ContatoRequestDTO contato) {

}
