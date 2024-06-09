package br.unipar.programacaointernet.pdv.controller;

import br.unipar.programacaointernet.pdv.model.ItemVenda;
import br.unipar.programacaointernet.pdv.service.ItemVendaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemVendaApiController {
    private final ItemVendaService itemVendaService;

    public ItemVendaApiController(ItemVendaService itemVendaService) {
        this.itemVendaService = itemVendaService;
    }

    @GetMapping(path = "/api/itensVenda")
    @Operation(summary = "Obter todos os itens da venda", description = "Retorna uma lista")
    public ResponseEntity<List<ItemVenda>> getAll() {
        return ResponseEntity.ok(this.itemVendaService.getAll());
    }

    @PostMapping(path = "/api/itensVenda")
    @Operation(summary = "Salvar itens da venda", description = "Salva um novo item venda")
    public ResponseEntity<ItemVenda> save(@RequestBody ItemVenda itemVenda) {
        return ResponseEntity.ok(this.itemVendaService.save(itemVenda));
    }

    @GetMapping(path = "/api/itensVenda/{id}")
    @Operation(summary = "Obter item venda por ID", description = "Retorna um item venda pelo ID")
    public ResponseEntity<ItemVenda> getById(@PathVariable Integer id) {
        return this.itemVendaService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/api/itensVenda/{id}")
    @Operation(summary = "Deletar item venda por ID", description = "Deleta um item venda pelo ID")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (this.itemVendaService.delete(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(path = "/api/itensVenda/{id}")
    @Operation(summary = "Atualizar item venda", description = "Atualiza um item venda pelo ID")
    public ResponseEntity<ItemVenda> update(@PathVariable Integer id, @RequestBody ItemVenda itemVenda) {
        return this.itemVendaService.update(id, itemVenda)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
