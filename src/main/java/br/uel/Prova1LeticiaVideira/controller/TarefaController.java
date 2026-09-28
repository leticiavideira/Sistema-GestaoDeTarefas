package br.uel.Prova1LeticiaVideira.controller;

import br.uel.Prova1LeticiaVideira.model.Tarefa;
import br.uel.Prova1LeticiaVideira.repository.TarefaRepository;
import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller 
public class TarefaController {
    private final TarefaRepository tarefaRepository;

    public TarefaController (TarefaRepository tarefaRepository){
        this.tarefaRepository = tarefaRepository;
    }

    @GetMapping ("/")
    public String listarTarefas(Model model){
        model.addAttribute("tarefas", tarefaRepository.findAll());
        model.addAttribute("tarefa", new Tarefa());
        return "tarefas";
    }

    @PostMapping ("/tarefas")
    public String adicionarTarefa (@Valid @ModelAttribute("tarefa") Tarefa tarefa, BindingResult result, Model model){
        if (result.hasErrors()){
            model.addAttribute("tarefas", tarefaRepository.findAll());
            return "tarefas";
        }

        tarefaRepository.save(tarefa);

        return "redirect:/";
    }

    @PostMapping ("/tarefas/{id}/concluir")
    public String alternarConclusao (@PathVariable Long id){
        Tarefa tarefa = tarefaRepository.findById(id).orElse(null);

            if (tarefa != null){
                tarefa.setConcluida(!tarefa.getConcluida());
                tarefaRepository.save(tarefa);
            }

        return "redirect:/";
    }
}
