package com.bancomaster.vorcaro_api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bancomaster.vorcaro_api.dto.ClienteDTO;
import com.bancomaster.vorcaro_api.service.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
  
  private final ClienteService service;

  public ClienteController(ClienteService service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<List<ClienteDTO>> listar() {
    return ResponseEntity.ok(service.listarTodos());
  }

  @PostMapping
  public ResponseEntity<ClienteDTO> cadastrar(@RequestBody ClienteDTO dto) {
    ClienteDTO cadastrado = service.salvar(dto);

    return ResponseEntity.status(HttpStatus.CREATED).body(cadastrado);
  }
}
