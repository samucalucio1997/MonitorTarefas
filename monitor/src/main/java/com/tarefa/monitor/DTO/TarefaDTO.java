package com.tarefa.monitor.DTO;

import lombok.Setter;

import lombok.Getter;

public class TarefaDTO {
    @Getter
    @Setter
    private String titulo;
    @Getter
    @Setter
    private String descricao;
    @Getter
    @Setter
    private String prioridade;
    @Getter
    @Setter
    private boolean concluido;
    @Getter
    @Setter
    private String data;
    @Getter
    @Setter
    private String responsavel;
}
