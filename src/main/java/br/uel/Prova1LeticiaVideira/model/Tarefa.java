package br.uel.Prova1LeticiaVideira.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

@Entity 
public class Tarefa {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank (message = "O título é obrigatório.")
    @Size (max = 100, message = "O título deve ter no máximo 100 caracteres")
    @Pattern (
        regexp = " ",
        message = "O título contém caracteres não permitidos"
    )
    private String titulo;

    @Size (max = 500, message = "A descrição deve ter no máximo 500 caracteres.")
    @Pattern(
        regexp = " ",
        message = "A descrição contém caracteres não permitidos"
    )
    private String descricao;

    private boolean concluida; //True = concluida, False = não concluida
    
    @NotNull (message = "O prazo é obrigatório.")
    @FutureOrPresent (message = "O prazo não pode estar no passado")
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
