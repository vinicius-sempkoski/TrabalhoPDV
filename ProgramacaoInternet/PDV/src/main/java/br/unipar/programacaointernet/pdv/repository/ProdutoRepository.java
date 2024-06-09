package br.unipar.programacaointernet.pdv.repository;

import br.unipar.programacaointernet.pdv.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
