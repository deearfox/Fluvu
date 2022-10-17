package br.com.fiap.fluvu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.fiap.fluvu.model.Poste;
import br.com.fiap.fluvu.service.PosteService;

@Controller
public class PosteController{

	private PosteService posteService;

	public PosteController(PosteService posteService){
		super();
		this.posteService = posteService;
	}

	@GetMapping("/postes")
	public String listarPostes(Model model){
		model.addAttribute("postes", posteService.getAllPostes());
		return "postes.html";
	}

	@GetMapping("/postes/cadastro")
	public String cadastrarPosteViaForm(Model model){
		Poste poste = new Poste();
		model.addAttribute("poste", poste);
		return "cadastrarPoste.html";
	}

	@PostMapping("/postes")
	public String salvarPoste(@ModelAttribute("poste") Poste poste){
		posteService.salvarPoste(poste);
		return "redirect:/postes.html";
	}

	@GetMapping("/postes/editar/{id}")
	public String editarPosteViaForm(@PathVariable Long id, Model model){
		model.addAttribute("poste", posteService.getPosteById(id));
		return "atualizarPoste.html";
	}

	@PostMapping("postes/{id}")
	public String atualizarPoste(@PathVariable long id, @ModelAttribute ("poste") Poste poste, Model model){
		Poste existenciaDePoste = posteService.getPosteById(id);
		existenciaDePoste.setId(id);
		existenciaDePoste.setRecepecaoEnergia(poste.getRecepecaoEnergia());
		posteService.atualizarPoste(existenciaDePoste);
		return "redirect:/postes";
	}

	@GetMapping("/postes/excluir/{id}")
	public String excluirPosteViaForm(@PathVariable Long id){
		posteService.excluirPosteById(id);
		return "redirect:/postes.html";
	}



}
