package com.muralis.api_restful.entity;

import org.apache.coyote.BadRequestException;

import com.muralis.api_restful.dto.ContatoRequestDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor

public class Contato {
    public static final String TABLE_NAME = "contato";  

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String tipo;

    @Column(nullable = false, length = 100)
    private String texto;

    public Contato(ContatoRequestDTO contatoRequestDTO) throws BadRequestException {
        this.setTipo(contatoRequestDTO.tipo());
        this.setTexto(contatoRequestDTO.texto());
    }

     public void setId(Long id) {
        this.id = id;
    }
    public void setTipo(String tipo) throws BadRequestException {
        if (tipo == null || tipo.isBlank()) {
            throw new BadRequestException("Tipo não pode ser nulo ou vazio");
        }
        this.tipo = tipo;
    }
    public void setTexto(String texto) throws BadRequestException {
        if (texto == null || texto.isBlank()) {
            throw new BadRequestException("Texto não pode ser nulo ou vazio");
        }
        this.texto = texto;
    }
}
