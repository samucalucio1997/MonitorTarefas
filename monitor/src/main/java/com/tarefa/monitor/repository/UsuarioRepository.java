package com.tarefa.monitor.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tarefa.monitor.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,UUID>{
    Usuario findByNome(String nome);
}
