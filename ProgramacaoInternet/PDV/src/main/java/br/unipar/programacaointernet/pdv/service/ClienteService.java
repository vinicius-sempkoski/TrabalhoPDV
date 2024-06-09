package br.unipar.programacaointernet.pdv.service;

import br.unipar.programacaointernet.pdv.model.Cliente;
import br.unipar.programacaointernet.pdv.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> getAll() {
        return this.clienteRepository.findAll();
    }

    public Cliente save(Cliente cliente) {
        return this.clienteRepository.save(cliente);
    }

    public Optional<Cliente> getById(Integer id) {
        return this.clienteRepository.findById(id);
    }

    public boolean delete(Integer id) {
        if (this.clienteRepository.existsById(id)) {
            this.clienteRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Cliente> update(Integer id, Cliente cliente) {
        if (this.clienteRepository.existsById(id)) {
            cliente.setId(id);
            return Optional.of(this.clienteRepository.save(cliente));
        }
        return Optional.empty();
    }
}
