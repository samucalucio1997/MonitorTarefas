package com.tarefa.monitor.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Tarefa {
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;
    @Getter
    @Setter
    private String titulo;
    @Getter
    @Setter
    private String descricao;
    @Getter
    @Setter
    private String prioridade;
    @Setter
    @Getter
    private Date deadline;

    @Setter
    @Getter
    private boolean concluido;

    @ManyToOne
    @Setter
    @Getter
    @JsonIgnore
    private Usuario responsavel;

    


    public Tarefa() {
    }




    public Tarefa(String titulo, String descricao, String prioridade, Date deadline, Usuario usuario) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.deadline = deadline;
        this.responsavel = usuario;
        this.concluido =false;
    }


    
}
