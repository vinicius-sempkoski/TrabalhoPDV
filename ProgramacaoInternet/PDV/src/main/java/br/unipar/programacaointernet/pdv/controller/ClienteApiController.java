package br.unipar.programacaointernet.pdv.controller;

import br.unipar.programacaointernet.pdv.model.Cliente;
import br.unipar.programacaointernet.pdv.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteApiController {
    private final ClienteService clienteService;

    public ClienteApiController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping(path = "/api/clientes")
    @Operation(summary = "Obter todos os clientes", description = "Retorna uma lista")
    public ResponseEntity<List<Cliente>> getAll() {
        return ResponseEntity.ok(this.clienteService.getAll());
    }

    @PostMapping(path = "/api/clientes")
    @Operation(summary = "Salvar cliente", description = "Salva um novo cliente")
    public ResponseEntity<Cliente> save(@RequestBody Cliente cliente) {
        return ResponseEntity.ok(this.clienteService.save(cliente));
    }

    @GetMapping(path = "/api/clientes/{id}")
    @Operation(summary = "Obter cliente por ID", description = "Retorna um cliente pelo ID")
    public ResponseEntity<Cliente> getById(@PathVariable Integer id) {
        return this.clienteService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/api/clientes/{id}")
    @Operation(summary = "Deletar cliente por ID", description = "Deleta um cliente pelo ID")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (this.clienteService.delete(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(path = "/api/clientes/{id}")
    @Operation(summary = "Atualizar cliente", description = "Atualiza um cliente pelo ID")
    public ResponseEntity<Cliente> update(@PathVariable Integer id, @RequestBody Cliente cliente) {
        return this.clienteService.update(id, cliente)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
