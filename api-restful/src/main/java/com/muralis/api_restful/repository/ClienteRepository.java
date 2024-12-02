package com.muralis.api_restful.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.muralis.api_restful.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    @Query("SELECT c FROM Cliente c LEFT JOIN c.contato ct WHERE c.nome LIKE %:nome% OR ct.texto LIKE %:contato%")
    List<Cliente> findByNomeOrContato(@Param("nome") String nome, @Param("contato") String contato);
}
