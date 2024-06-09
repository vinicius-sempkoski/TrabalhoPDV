package br.unipar.programacaointernet.pdv.repository;

import br.unipar.programacaointernet.pdv.model.ItemVenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemVendaRepository extends JpaRepository<ItemVenda, Integer> {
}
