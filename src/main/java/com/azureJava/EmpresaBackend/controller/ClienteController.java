package com.azureJava.EmpresaBackend.controller;


import com.azureJava.EmpresaBackend.entity.Cliente;
import com.azureJava.EmpresaBackend.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<Page<Cliente>> listar(

            @RequestParam(value = "pagina", defaultValue = "0") int pagina,
            @RequestParam(value = "tamano", defaultValue = "2") int tamano

    ){
        Page<Cliente> resultado = clienteService.listar(pagina,tamano);
        return ResponseEntity.ok(resultado);
    }

    @GetMapping("/{id}")
    public ResponseEntity <Cliente> obtenerPorId(@PathVariable Long id){
        return clienteService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Cliente> crear (@Valid @RequestBody Cliente cliente){
        Cliente creado = clienteService.crear(cliente);
        return ResponseEntity.created(URI.create("/api/clientes/" + creado.getId())).body(creado);
    }

    @PutMapping
    public ResponseEntity<Cliente> actualizar(@PathVariable Long id, @Valid @RequestBody Cliente cliente){
        try {
            return ResponseEntity.ok(clienteService.actualizar(id, cliente));
        } catch (IllegalArgumentException ex){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        try {
            clienteService.eliminar(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException ex){
            return ResponseEntity.noContent().build();
        }
    }

}
