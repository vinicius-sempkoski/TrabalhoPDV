package br.unipar.programacaointernet.pdv.service;

import br.unipar.programacaointernet.pdv.model.Produto;
import br.unipar.programacaointernet.pdv.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> getAll() {
        return this.produtoRepository.findAll();
    }

    public Produto save(Produto produto) {
        return this.produtoRepository.save(produto);
    }

    public Optional<Produto> getById(Integer id) {
        return this.produtoRepository.findById(id);
    }

    public boolean delete(Integer id) {
        if (this.produtoRepository.existsById(id)) {
            this.produtoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Produto> update(Integer id, Produto produto) {
        if (this.produtoRepository.existsById(id)) {
            produto.setId(id);
            return Optional.of(this.produtoRepository.save(produto));
        }
        return Optional.empty();
    }

}
