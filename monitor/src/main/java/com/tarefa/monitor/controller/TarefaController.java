package com.tarefa.monitor.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tarefa.monitor.DTO.TarefaDTO;
import com.tarefa.monitor.DTO.TaskResponseDTO;
import com.tarefa.monitor.model.Tarefa;
import com.tarefa.monitor.model.Usuario;
import com.tarefa.monitor.service.TarefaService;

@RestController
@RequestMapping("/task")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping(value = "/cadastrarTarefa",consumes = "application/json")
    public ResponseEntity<TaskResponseDTO> CadastrarTarefa(@RequestBody TarefaDTO task,@RequestParam("nome") String nome_usuario){
        try {
            Tarefa tarefa = new Tarefa();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date dt = sdf.parse(task.data());
            tarefa.setDeadline(dt);
            tarefa.setConcluido(false);
            tarefa.setDescricao(task.descricao());
            tarefa.setPrioridade(task.prioridade());
            tarefa.setTitulo(task.titulo());
            var tarefaR = this.tarefaService.CriarTarefa(tarefa, nome_usuario);
            return ResponseEntity.status(200).body(tarefaR);
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<TaskResponseDTO>> ListarTarefa(){
         return ResponseEntity.status(200).body(this.tarefaService.ListarTarefa());
    }
    
    @PatchMapping("/atualizar")
    public ResponseEntity<TaskResponseDTO> AtualizarTarefa(@RequestBody Tarefa tarefa,@RequestParam("titulo") String titulo){
          try {
            return ResponseEntity.status(200).body(this.tarefaService.AtualizarTarefa(titulo, tarefa));
          } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.badRequest().build();
          }
    }

    @DeleteMapping("/removerTarefa")
    public ResponseEntity<Tarefa> DeleteTarefa(@RequestParam("tituto") String titulo){
         try {
            return ResponseEntity.status(200).body(this.tarefaService.RemoverTarefa(titulo));
         } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.badRequest().build();
         } 
    }

}