package br.uel.Prova1LeticiaVideira.controller;

import br.uel.Prova1LeticiaVideira.model.Tarefa;
import br.uel.Prova1LeticiaVideira.repository.TarefaRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    public String adicionarTarefa (@ModelAttribute Tarefa tarefa){
        tarefaRepository.save(tarefa);

        return "redirect:/";
    }
}
