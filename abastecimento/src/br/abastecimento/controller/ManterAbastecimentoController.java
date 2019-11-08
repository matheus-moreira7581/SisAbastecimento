package br.abastecimento.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.abastecimento.entity.Represa;
import br.abastecimento.entity.SisAbastecimento;
import br.abastecimento.service.RepresaService;
import br.abastecimento.service.SisAbastecimentoService;

@Controller
public class ManterAbastecimentoController {
	private RepresaService represaService;
	private SisAbastecimentoService sisAbsService;
	
	@Autowired
	public ManterAbastecimentoController(RepresaService rs, SisAbastecimentoService sas) {
		represaService = rs;
		sisAbsService = sas;
	}
	
	@RequestMapping("index")
	public String inicio() {
		return "index";
	}
	
	private List<SisAbastecimento> listarAbastecimentos() throws IOException {
		return sisAbsService.selecionarTodosSisAbastecimento();
	}
	
	@RequestMapping("listarSisAbsExibir")
	public String listarSisAbsExibir(Model model) {
		try {
			model.addAttribute("SisAbs", listarAbastecimentos());
			return "SisAbsListarExibir";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}
	
	@RequestMapping("listarAbastecimentoExibir")
	public String listarAbastecimento(Model model) {
		try {
			model.addAttribute("SisAbs", listarAbastecimentos());
			return "RepresaListar";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}
	
	@RequestMapping("ListarRepresasExibir")
	public String listarRepresas(@Valid SisAbastecimento sisAbs, BindingResult result, Model model) {
		try {
			if(result.hasFieldErrors("id")) {
				model.addAttribute("SisAbs", listarAbastecimentos());
				System.out.println("Deu erro:" + result.toString());
				return "RepresaListar";
			}
			sisAbs = sisAbsService.selecionarSisAbastecimento(sisAbs.getId());
			model.addAttribute("Sis", sisAbs);
			
			List<Represa> represas = represaService.listarTodasRepresas(sisAbs);
			model.addAttribute("represas", represas);
			return "RepresaListarExibir";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}
	
	@RequestMapping("exibirRepresa")
	public String selecionarRepresa(@RequestParam int id, Model model) {
		try {
			model.addAttribute("represa", represaService.selecionarRepresa(id));
			return "represa/represamostrar";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}
	
	@RequestMapping("exibirSisAbs")
	public String selecionarSisAbs(@RequestParam int id, Model model) {
		try {
			model.addAttribute("sAbs", sisAbsService.selecionarSisAbastecimento(id));
			return "SisAbs/SisAbsmostrar";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}
	
	@RequestMapping("novoSisAbs")
	public String novoSisAbs() {
		return "SisAbs/cadastroSisAbs";
	}
	
	@RequestMapping("cadastrarSisAbs")
	public String cadastrarSisAbs(@Valid SisAbastecimento sisAbs, BindingResult result) {
		try {
			sisAbsService.novoSisAbastecimento(sisAbs);
			return "redirect:/listarSisAbsExibir";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}
	
	@RequestMapping("excluirSisAbs")
	public String excluirSisAbs(@RequestParam int id) {
		try {
			sisAbsService.excluirSisAbastecimento(id);
			return "redirect:/listarSisAbsExibir";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}
	
	@RequestMapping("atualizarSisAbsExibir")
	public String atualizarSisAbsExibir(@RequestParam int id, Model model) {
		try {
			model.addAttribute("sAbs", sisAbsService.selecionarSisAbastecimento(id));
			return "SisAbs/atualizarSisAbs";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}
	
	@RequestMapping("atualizarSisAbs")
	public String atualizarSisAbs(SisAbastecimento sisAbs, Model model) {
		try {
			sisAbsService.atualizarSisAbastecimento(sisAbs);
			return "redirect:/listarSisAbsExibir";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}
	
	@RequestMapping("novaRepresa")
	public String novaRepresa(Model model) {
		try {
			List<SisAbastecimento> sisAbs = listarAbastecimentos();
			model.addAttribute("SisAbs", sisAbs);
			return "represa/novaRepresa";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
		
	}
	
	@RequestMapping("cadastrarRepresa")
	public String cadastrarSisAbs(@Valid Represa represa) {
		try {
			represaService.novaRepresa(represa);
			return "redirect:/listarAbastecimentoExibir";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}
	
	@RequestMapping("atualizarRepresaExibir")
	public String atualizarRepresaExibir(@RequestParam int id, Model model) {
		try {
			model.addAttribute("represa", represaService.selecionarRepresa(id));
			model.addAttribute("SisAbs", listarAbastecimentos());
			return "represa/atualizarRepresa";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}
	
	@RequestMapping("atualizarRepresa")
	public String atualizarRepresa(Represa represa, Model model) {
		try {
			represaService.atualizarRepresa(represa);
			return "redirect:/ListarRepresasExibir?id="+ represa.getSisAbs().getId();
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}
	
	@RequestMapping("excluirRepresa")
	public String excluirRepresa(@RequestParam int id) {
		try {
			Represa represa = represaService.selecionarRepresa(id);
			represaService.excluirRepresa(id);
			return "redirect:/ListarRepresasExibir?id=" + represa.getSisAbs().getId();
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}
}
