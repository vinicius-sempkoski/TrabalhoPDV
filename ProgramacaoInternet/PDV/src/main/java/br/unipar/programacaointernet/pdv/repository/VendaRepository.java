package br.unipar.programacaointernet.pdv.repository;

import br.unipar.programacaointernet.pdv.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Integer> {
}
