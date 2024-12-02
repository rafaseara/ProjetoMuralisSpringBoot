package com.muralis.api_restful.entity;

import java.util.Objects;

import org.apache.coyote.BadRequestException;

import com.muralis.api_restful.dto.ClienteRequestDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "clientes")
@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor

public class Cliente {
    public static final String TABLE_NAME = "cliente";  

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;
    
    @Column(nullable = false, length = 100)
    private String dataCadastro;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contato_id", referencedColumnName = "id", nullable = false)
    private Contato contato;

    public Cliente(ClienteRequestDTO clienteRequestDTO) throws BadRequestException {
        setNome(clienteRequestDTO.nome());
        setContato(new Contato(clienteRequestDTO.contato()));
    }

    public void setNome(String nome) throws BadRequestException {
        if (nome.isBlank()) {
            throw new BadRequestException("Nome não pode ser vazio");
        }
        this.nome = nome;
    }

    public void setDataCadastro(String dataCadastro) throws BadRequestException {
        if (dataCadastro != null && !dataCadastro.isEmpty()) {
            if (!dataCadastro.matches("\\d{4}-\\d{2}-\\d{2}")) {
                throw new BadRequestException("Data de cadastro inválida (formato esperado: yyyy-MM-dd)");
            }
            this.dataCadastro = dataCadastro;
        }
    }
    
    public void setContato(Contato contato) throws BadRequestException {
        if (Objects.isNull(contato)) {
            throw new BadRequestException("Contato não pode ser nulo");
        }
        this.contato = contato;
    }
}