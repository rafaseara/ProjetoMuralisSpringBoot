package com.muralis.api_restful.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.muralis.api_restful.dto.ClienteRequestDTO;
import com.muralis.api_restful.dto.ClienteResponseDTO;
import com.muralis.api_restful.entity.Cliente;
import com.muralis.api_restful.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> getById(@PathVariable Long id) {
        Cliente cliente = clienteService.findById(id);
        return ResponseEntity.ok(new ClienteResponseDTO(cliente));
    }

    @GetMapping("/nome")
    public ResponseEntity<List<Cliente>> findByName(@RequestParam String nome) {
        List<Cliente> clientes = clienteService.findByName(nome);
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/contato")
    public ResponseEntity<List<Cliente>> findByContact(@RequestParam String telefone) {
        List<Cliente> clientes = clienteService.findByContact(telefone);
        return ResponseEntity.ok(clientes);
    }

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> create(@RequestBody ClienteRequestDTO dto) throws BadRequestException {
        Cliente cliente = new Cliente(dto);
        cliente.setDataCadastro(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        return ResponseEntity.ok(new ClienteResponseDTO(clienteService.save(cliente)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> update(@PathVariable Long id, @RequestBody ClienteRequestDTO dto) throws BadRequestException {
        Cliente cliente = new Cliente(dto);
        return ResponseEntity.ok(new ClienteResponseDTO(clienteService.update(id, cliente)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
