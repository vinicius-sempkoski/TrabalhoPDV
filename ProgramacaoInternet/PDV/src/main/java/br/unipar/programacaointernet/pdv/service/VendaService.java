package br.unipar.programacaointernet.pdv.service;

import br.unipar.programacaointernet.pdv.model.Venda;
import br.unipar.programacaointernet.pdv.repository.VendaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendaService {
    private final VendaRepository vendaRepository;

    public VendaService(VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    public List<Venda> getAll() {
        return this.vendaRepository.findAll();
    }

    public Venda save(Venda venda) {
        return this.vendaRepository.save(venda);
    }

    public Optional<Venda> getById(Integer id) {
        return this.vendaRepository.findById(id);
    }

    public boolean delete(Integer id) {
        if (this.vendaRepository.existsById(id)) {
            this.vendaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Venda> update(Integer id, Venda venda) {
        if (this.vendaRepository.existsById(id)) {
            venda.setId(id);
            return Optional.of(this.vendaRepository.save(venda));
        }
        return Optional.empty();
    }
}
