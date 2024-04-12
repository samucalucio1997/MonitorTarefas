package com.tarefa.monitor.DTO;

import com.tarefa.monitor.model.Usuario;

import lombok.Getter;
import lombok.Setter;

public class UsuarioResponseDTO {
    @Getter
    @Setter
    private Usuario usuario;

    @Getter
    @Setter
    private String token;
}
