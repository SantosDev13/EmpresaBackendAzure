package com.azureJava.EmpresaBackend.repository;

import com.azureJava.EmpresaBackend.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository <Cliente, Long> {
    Optional <Cliente> findByEmail(String email);
}
