package com.tarefa.monitor.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.tarefa.monitor.model.Tarefa;
import java.util.List;


public interface TarefaRepository extends JpaRepository<Tarefa,Integer>{
     Tarefa findByTitulo(String titulo);
}
