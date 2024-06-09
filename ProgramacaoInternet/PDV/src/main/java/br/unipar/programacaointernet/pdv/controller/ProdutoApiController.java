package br.unipar.programacaointernet.pdv.controller;

import br.unipar.programacaointernet.pdv.model.Produto;
import br.unipar.programacaointernet.pdv.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProdutoApiController {
    private final ProdutoService produtoService;

    public ProdutoApiController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping(path = "/api/produtos")
    @Operation(summary = "Obter todos os produtos", description = "Retorna uma lista")
    public ResponseEntity<List<Produto>> getAll() {
        return ResponseEntity.ok(this.produtoService.getAll());
    }

    @PostMapping(path = "/api/produtos")
    @Operation(summary = "Salvar produto", description = "Salva um novo produto")
    public ResponseEntity<Produto> save(@RequestBody Produto produto) {
        return ResponseEntity.ok(this.produtoService.save(produto));
    }

    @GetMapping(path = "/api/produtos/{id}")
    @Operation(summary = "Obter produto por ID", description = "Retorna um produto pelo ID")
    public ResponseEntity<Produto> getById(@PathVariable Integer id) {
        return this.produtoService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/api/produtos/{id}")
    @Operation(summary = "Deletar produto por ID", description = "Deleta um produto pelo ID")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (this.produtoService.delete(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(path = "/api/produtos/{id}")
    @Operation(summary = "Atualizar produto", description = "Atualiza um produto pelo ID")
    public ResponseEntity<Produto> update(@PathVariable Integer id, @RequestBody Produto produto) {
        return this.produtoService.update(id, produto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
