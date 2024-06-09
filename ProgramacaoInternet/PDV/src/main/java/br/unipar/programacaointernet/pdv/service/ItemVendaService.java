package br.unipar.programacaointernet.pdv.service;

import br.unipar.programacaointernet.pdv.model.ItemVenda;
import br.unipar.programacaointernet.pdv.repository.ItemVendaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemVendaService {
    private final ItemVendaRepository itemVendaRepository;

    public ItemVendaService(ItemVendaRepository itemVendaRepository) {
        this.itemVendaRepository = itemVendaRepository;
    }

    public List<ItemVenda> getAll() {
        return this.itemVendaRepository.findAll();
    }

    public ItemVenda save(ItemVenda itemVenda) {
        return this.itemVendaRepository.save(itemVenda);
    }

    public Optional<ItemVenda> getById(Integer id) {
        return this.itemVendaRepository.findById(id);
    }

    public boolean delete(Integer id) {
        if (this.itemVendaRepository.existsById(id)) {
            this.itemVendaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<ItemVenda> update(Integer id, ItemVenda itemVenda) {
        if (this.itemVendaRepository.existsById(id)) {
            itemVenda.setId(id);
            return Optional.of(this.itemVendaRepository.save(itemVenda));
        }
        return Optional.empty();
    }

}
