package br.unipar.programacaointernet.pdv.controller;

import br.unipar.programacaointernet.pdv.model.Venda;
import br.unipar.programacaointernet.pdv.service.VendaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VendaApiController {
    private final VendaService vendaService;

    public VendaApiController(VendaService vendaService) {
        this.vendaService = vendaService;
    }

    @GetMapping(path = "/api/vendas")
    @Operation(summary = "Obter todas as vendas", description = "Retorna uma lista")
    public ResponseEntity<List<Venda>> getAll() {
        return ResponseEntity.ok(this.vendaService.getAll());
    }

    @PostMapping(path = "/api/vendas")
    @Operation(summary = "Salvar venda", description = "Salva uma nova venda")
    public ResponseEntity<Venda> save(@RequestBody Venda venda) {
        return ResponseEntity.ok(this.vendaService.save(venda));
    }
}
