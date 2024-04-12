package com.tarefa.monitor.DTO;

import com.tarefa.monitor.model.Tarefa;
import com.tarefa.monitor.model.Usuario;

import lombok.Getter;
import lombok.Setter;

public class TaskResponseDTO {
  @Getter
  @Setter
  private Tarefa tarefa;

  @Getter
  @Setter
  private Usuario usuario;
}
