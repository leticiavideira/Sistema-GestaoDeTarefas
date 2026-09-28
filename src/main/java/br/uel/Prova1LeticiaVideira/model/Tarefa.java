package br.uel.Prova1LeticiaVideira.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity 
public class Tarefa {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descricao;
    private boolean concluida; //True = concluida, False = não concluida
    private LocalDate prazo;

    public Long getId (){
        return id;
    }
    public void setId (Long id){
        this.id = id;
    }

    public String getTitulo(){
        return titulo;
    }
    public void setTitulo (String titulo){
        this.titulo = titulo;
    }

    public String getDescricao (){
        return descricao;
    }
    public void setDescricao (String descricao){
        this.descricao = descricao;
    }

    public boolean getConcluida (){
        return concluida;
    }
    public void setConcluida (boolean concluida){
        this.concluida = concluida;
    }

    public LocalDate getPrazo (){
        return prazo;
    }
    public void setPrazo (LocalDate prazo){
        this.prazo = prazo;
    }

}
