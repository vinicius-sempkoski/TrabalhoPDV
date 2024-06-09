package br.unipar.programacaointernet.pdv.controller;

import br.unipar.programacaointernet.pdv.model.Venda;
import br.unipar.programacaointernet.pdv.service.VendaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class VendaWebController {
    private final VendaService vendaService;

    public VendaWebController(VendaService vendaService) {
        this.vendaService = vendaService;
    }

    @GetMapping(path = "/vendas")
    public String getAllVenda(Model model) {
        List<Venda> vendas = vendaService.getAll();
        model.addAttribute("vendas", vendas);
        return "vendas";
    }

    @GetMapping(path = "/api/vendas/{id}")
    @Operation(summary = "Obter venda por ID", description = "Retorna uma venda pelo ID")
    public ResponseEntity<Venda> getById(@PathVariable Integer id) {
        return this.vendaService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/api/vendas/{id}")
    @Operation(summary = "Deletar venda por ID", description = "Deleta uma venda pelo ID")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (this.vendaService.delete(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(path = "/api/vendas/{id}")
    @Operation(summary = "Atualizar venda", description = "Atualiza uma venda pelo ID")
    public ResponseEntity<Venda> update(@PathVariable Integer id, @RequestBody Venda venda) {
        return this.vendaService.update(id, venda)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
