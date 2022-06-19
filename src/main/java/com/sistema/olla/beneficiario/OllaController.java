package com.sistema.olla.beneficiario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sistema.olla.distrito.Distrito;
import com.sistema.olla.distrito.DistritoRepository;
import com.sistema.olla.servicio.Ollaservice;
import com.sistema.olla.util.paginacion.PageRender;


@Controller
public class OllaController {
	@Autowired
	private OllaRepository ollaRepository;

	@Autowired
	private DistritoRepository distritoRepository;
	
	@Autowired
	private Ollaservice ollaservice;

	@GetMapping("/ollas")
	public String listarOlla(@RequestParam(name = "page",defaultValue = "0")int page, Model modelo) {
		Pageable pageRequest = PageRequest.of(page, 8);	
		Page<Olla> listaOllas = ollaservice.findAll(pageRequest);
		PageRender<Olla> pageRender = new PageRender<>("/ollas", listaOllas);
		modelo.addAttribute("listaOllas", listaOllas);
		modelo.addAttribute("page", pageRender);
		return "ollas";
	}

	@GetMapping("/ollas/nuevo")
	public String mostrarFormularioDeNuevaOlla(Model modelo) {

		List<Distrito> listaDistrito = distritoRepository.findAll();

		modelo.addAttribute("olla", new Olla());
		modelo.addAttribute("listaDistrito", listaDistrito);
		return "olla_formulario";
	}

	@PostMapping("/ollas/guardar")
	public String guardarOlla(Olla olla,RedirectAttributes redirect) {
		ollaRepository.save(olla);
		redirect.addFlashAttribute("msgExito","La olla comunal ha sido agregada correctamente");
		return "redirect:/ollas";
	}

	@GetMapping("/ollas/editar/{id}")
	public String mostrarFormularioDeModificarProducto(@PathVariable("id") Integer id, Model modelo) {
		Olla olla = ollaRepository.findById(id).get();
		modelo.addAttribute("olla", olla);

		List<Distrito> listaDistrito = distritoRepository.findAll();
		modelo.addAttribute("listaDistrito", listaDistrito);

		return "olla_formulario";
	}
	
	@GetMapping("/ollas/eliminar/{id}")
	public String eliminarOlla(@PathVariable("id") Integer id, Model modelo) {
		ollaRepository.deleteById(id);
		return "redirect:/ollas";
	}

}
