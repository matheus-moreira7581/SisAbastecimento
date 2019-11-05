package br.abastecimento.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@RequestMapping("listarAbastecimentoExibir")
	public String listarAbastecimento(Model model) {
		try {
//			List<SisAbastecimento> sisAbs = sisAbsService.selecionarTodosSisAbastecimento();
			model.addAttribute("SisAbs", sisAbsService.selecionarTodosSisAbastecimento());
			return "RepresaListar";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}
	
	@RequestMapping("ListarRepresasExibir")
	public String listarRepresas(Model model) {
		try {
//			List<Represa> represas = represaService.listarTodasRepresas();
			model.addAttribute("represas", represaService.listarTodasRepresas());
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
}
