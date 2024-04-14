package com.tarefa.monitor.service;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tarefa.monitor.DTO.TarefaDTO;
import com.tarefa.monitor.DTO.TaskResponseDTO;
import com.tarefa.monitor.model.Tarefa;
import com.tarefa.monitor.model.Usuario;
import com.tarefa.monitor.repository.TarefaRepository;
import com.tarefa.monitor.repository.UsuarioRepository;

@Service
public class TarefaService {


    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;



    public TaskResponseDTO CriarTarefa(Tarefa tarefa,String usuarioid){
        
        var user = this.usuarioRepository.findById(UUID.fromString(usuarioid)).get();
        tarefa.setResponsavel(user);
        Optional<Tarefa> task = this.tarefaRepository.findAll().stream()
        .filter(n -> 
            n.getResponsavel().getNome()
            .equals(tarefa.getResponsavel().getNome()) && n.getDescricao()
            .equals(tarefa.getDescricao()) && n.getDeadline().equals(tarefa.getDeadline())
        ).findAny();
    if (!task.isEmpty()) {
      throw new RuntimeException("Ja existe a tarefa");
    }  
    Tarefa tf = this.tarefaRepository.save(tarefa);
     TaskResponseDTO resp = new TaskResponseDTO();
     resp.setUsuario(user);
     resp.setTarefa(tf);
     return resp;
    }

    public List<TaskResponseDTO> ListarTarefa(){
        List<TaskResponseDTO> resp = new ArrayList<>();
        for (Tarefa taskO : this.tarefaRepository.findAll()) {
            TaskResponseDTO task = new TaskResponseDTO();
            task.setTarefa(taskO);
            task.setUsuario(taskO.getResponsavel());
            resp.add(task);
        }
        return resp;
    }

    public Tarefa RemoverTarefa(String titulo){
        Tarefa taf =this.tarefaRepository.findByTitulo(titulo);
      if (taf==null) {
        throw new RuntimeException("Não existe essa tarefa");
      }
      this.tarefaRepository.delete(taf);
      return taf; 
    }

    public TaskResponseDTO AtualizarTarefa(String titulo, TarefaDTO tarefa){
        Tarefa task = this.tarefaRepository.findByTitulo(titulo);
        if (tarefa.isConcluido()) {
            task.setConcluido(tarefa.isConcluido());
        }
        if (tarefa.getDescricao()!=null) {
            task.setDescricao(tarefa.getDescricao());
        }
        if (tarefa.getResponsavel()!=null) {
            Usuario usuario= this.usuarioRepository.findById(UUID.fromString(tarefa.getResponsavel())).get();
            task.setResponsavel(usuario);
        }
        Tarefa taref = this.tarefaRepository.save(task);
        TaskResponseDTO taskResponseDTO = new TaskResponseDTO();
        taskResponseDTO.setTarefa(taref);
        taskResponseDTO.setUsuario(task.getResponsavel());
        return taskResponseDTO;
    }

    public Tarefa pesquisarTarefa(String titulo){
         return this.tarefaRepository.findByTitulo(titulo);
    }
   
    public Tarefa concluiTarefa(String titulo){
        Tarefa tarefa = this.pesquisarTarefa(titulo);
        tarefa.setConcluido(true);
        return this.tarefaRepository.save(tarefa);
    }
    
}
