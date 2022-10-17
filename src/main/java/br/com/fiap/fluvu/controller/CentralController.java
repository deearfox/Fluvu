package br.com.fiap.fluvu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.fiap.fluvu.model.Central;
import br.com.fiap.fluvu.service.CentralService;

@Controller
public class CentralController{

	private CentralService centralService;

	public CentralController(CentralService centralService){
		super();
		this.centralService = centralService;
	}

	@GetMapping("/centrais")
	public String listarCentrais(Model model){
		model.addAttribute("centrais", centralService.getAllCentrais());
		return "centrais.html";
	}

	@GetMapping("/centrais/cadastro")
	public String cadastrarCentralViaForm(Model model){
		Central central = new Central();
		model.addAttribute("central", central);
		return "cadastrarCentral.html";
	}

	@PostMapping("/centrais")
	public String salvarCentral(@ModelAttribute("central") Central central){
		centralService.salvarCentral(central);
		return "redirect:/centrais.html";
	}

	@GetMapping("/centrais/editar/{id}")
	public String editarCentralViaForm(@PathVariable Long id, Model model){
		model.addAttribute("central", centralService.getCentralById(id));
		return "atualizarCentral.html";
	}

	@PostMapping("centrais/{id}")
	public String atualizarCentral(@PathVariable long id, @ModelAttribute ("central") Central central, Model model){
		Central existenciaDeCentral = centralService.getCentralById(id);
		existenciaDeCentral.setId(id);
		existenciaDeCentral.setNome(central.getNome());
		existenciaDeCentral.setCnpj(central.getCnpj());
		existenciaDeCentral.setAcao(central.getAcao());

		centralService.atualizarCentral(existenciaDeCentral);
		return "redirect:/centrais";
	}

	@GetMapping("/centrais/excluir/{id}")
	public String excluirCentralViaForm(@PathVariable Long id){
		centralService.excluirCentralById(id);
		return "redirect:/centrais.html";
	}



}


