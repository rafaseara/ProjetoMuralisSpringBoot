package com.muralis.api_restful.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.muralis.api_restful.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByNomeContainingIgnoreCase(String nome);
    List<Cliente> findByContato_TextoContainingIgnoreCase(String contato);
}