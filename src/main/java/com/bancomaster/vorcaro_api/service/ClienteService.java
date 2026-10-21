package com.bancomaster.vorcaro_api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bancomaster.vorcaro_api.dto.ClienteDTO;
import com.bancomaster.vorcaro_api.model.Cliente;
import com.bancomaster.vorcaro_api.repository.ClienteRepository;

@Service
public class ClienteService {
  // Injeção de dependência
  private final ClienteRepository repository;

  // Construtor
  public ClienteService(ClienteRepository clienteRepository) {
    this.repository = clienteRepository;
  }

  // Busca todos os clientes
  public List<ClienteDTO> listarTodos() {
    return repository
        .findAll()
        .stream()
        .map(c -> new ClienteDTO(c.getId(), c.getNome(), c.getCpf(), c.getSaldo())).toList();
  }

  // Criar um cliente
  public ClienteDTO salvar(ClienteDTO dto) {
    Cliente novoCliente = new Cliente(dto.nome(), dto.cpf(), dto.saldo());

    Cliente clienteSalvo = repository.save(novoCliente);

    return new ClienteDTO(clienteSalvo.getId(), clienteSalvo.getNome(), clienteSalvo.getCpf(), clienteSalvo.getSaldo());
  }
}
