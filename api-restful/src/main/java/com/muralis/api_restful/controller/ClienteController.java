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

    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> getAll(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String contato) {
        List<Cliente> clientes = clienteService.findByNomeOrContato(
                nome != null ? nome : "", 
                contato != null ? contato : "");
        return ResponseEntity.ok(clientes.stream().map(ClienteResponseDTO::new).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> getById(@PathVariable Long id) {
        Cliente cliente = clienteService.findById(id);
        return ResponseEntity.ok(new ClienteResponseDTO(cliente));
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
