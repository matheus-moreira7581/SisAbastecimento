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

import br.abastecimento.entity.Pluviometria;
import br.abastecimento.entity.Represa;
import br.abastecimento.entity.SisAbastecimento;
import br.abastecimento.entity.VolumeArmazenado;
import br.abastecimento.service.PluviometriaService;
import br.abastecimento.service.RepresaService;
import br.abastecimento.service.SisAbastecimentoService;
import br.abastecimento.service.VolumeArmazenadoService;

@Controller
public class ManterAbastecimentoController {
	private RepresaService represaService;
	private SisAbastecimentoService sisAbsService;
	private VolumeArmazenadoService volArmazenadoService;
	private PluviometriaService pluviometriaService;
	
	@Autowired
	public ManterAbastecimentoController(RepresaService rs, SisAbastecimentoService sas, VolumeArmazenadoService vas, 
			PluviometriaService ps) {
		represaService = rs;
		sisAbsService = sas;
		volArmazenadoService = vas;
		pluviometriaService = ps;
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
	
	public float calcularIndice1(float volArmazenado, float volUtil) {
		float indice1 = volArmazenado / volUtil * 100;
		System.out.println("Resultado do Indice 1: " + indice1);
		return indice1;
	}
	
	public float calcularIndice2(float volUtil, float volReservaTecnica, float volArmazenado) {
		float volTotal = volUtil + volReservaTecnica;
		float indice2 = volArmazenado / volTotal * 100;
		System.out.println("Resultado do Indice 2: " + indice2);
		return indice2;
	}
	
	public float calcularIndice3(float volArmazenado, float volReservaTecnica, float volUtil) {
		float indice3 = (volArmazenado - volReservaTecnica) / volUtil * 100;
		System.out.println("Resultado do Indice 3: " + indice3);
		return indice3;
	}
	
	@RequestMapping("exibirRepresa")
	public String selecionarRepresa(@RequestParam int id, Model model) {
		try {
			Represa represa = represaService.selecionarRepresa(id);
			List<VolumeArmazenado> volArmList = volArmazenadoService.listarVolArmazenado(represa);
			if (!volArmList.isEmpty()) {
				model.addAttribute("indice1", calcularIndice1(volArmList.get(0).getVolumeArmazenado(), represa.getVolumeUtil()));
				model.addAttribute("indice2", calcularIndice2(represa.getVolumeUtil(), represa.getVolumeReservaTecnica(), 
						volArmList.get(0).getVolumeArmazenado()));
				model.addAttribute("indice3", calcularIndice3(volArmList.get(0).getVolumeArmazenado(), represa.getVolumeReservaTecnica(), 
						represa.getVolumeUtil()));
			}
			model.addAttribute("represa", represaService.selecionarRepresa(id));
			model.addAttribute("volArmazenado", volArmList);
			model.addAttribute("pluviometriaList", pluviometriaService.listarPluviometria(represa));
			return "represa/represamostrar";
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}
	
	@RequestMapping("registrarVolArmazenado")
	public String registrarVolArmazenado(@RequestParam int id, @RequestParam int volumeArmazenado, Model model) {
		VolumeArmazenado volArmazenado = new VolumeArmazenado();
		try {
			Represa represa = represaService.selecionarRepresa(id);
			volArmazenado.setVolumeArmazenado(volumeArmazenado);
			volArmazenado.setRepresa(represa);
			volArmazenadoService.registrarVolArmazenado(volArmazenado);
			return "redirect:/exibirRepresa?id=" + id;
		} catch (IOException e) {
			e.printStackTrace();
			return "Erro";
		}
	}
	
	@RequestMapping("registrarPluviometria")
	public String registrarPluviometria(@RequestParam int id, @RequestParam int pluviometria, Model model) {
		Pluviometria pluviometriaObj = new Pluviometria();
		try {
			Represa represa = represaService.selecionarRepresa(id);
			pluviometriaObj.setPluviometria(pluviometria);
			pluviometriaObj.setRepresa(represa);
			pluviometriaService.registrarPluviometria(pluviometriaObj);
			return "redirect:/exibirRepresa?id=" + id; 
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
