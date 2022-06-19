package com.sistema.olla.grupo;

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

import com.sistema.olla.encargado.Encargado;
import com.sistema.olla.encargado.EncargadoRepository;
import com.sistema.olla.servicio.GrupoService;
import com.sistema.olla.util.paginacion.PageRender;

@Controller
public class Grupocontroller {
	@Autowired
	private GrupoRepository grupoRepository;

	@Autowired
	private EncargadoRepository encargadoRepository;
	
	@Autowired
	private GrupoService grupoService;
	
	
	@GetMapping("/grupos")
	public String listarGrupo(@RequestParam(name = "page",defaultValue = "0")int page, Model modelo) {
		Pageable pageRequest = PageRequest.of(page, 8);			
		Page<Grupo> listaGrupos = grupoService.findAll(pageRequest);
		PageRender<Grupo> pageRender = new PageRender<>("/grupos", listaGrupos);
		modelo.addAttribute("listaGrupos", listaGrupos);
		modelo.addAttribute("page", pageRender);
		
		return "grupos";
	}

	@GetMapping("/grupos/nuevo")
	public String mostrarFormularioDeNuevoGrupo(Model modelo) {

		List<Encargado> listaEncargado = encargadoRepository.findAll();

		modelo.addAttribute("grupo", new Grupo());
		modelo.addAttribute("listaEncargado", listaEncargado);
		return "grupo_formulario";
	}

	@PostMapping("/grupos/guardar")
	public String guardarGrupo(Grupo grupo, RedirectAttributes redirect) {
		grupoRepository.save(grupo);
		redirect.addFlashAttribute("msgExito","El Grupo ha sido agregado con exito");
		return "redirect:/grupos";
	}

	@GetMapping("/grupos/editar/{id}")
	public String mostrarFormularioDeModificarGrupo(@PathVariable("id") Integer id, Model modelo) {
		Grupo grupo = grupoRepository.findById(id).get();
		modelo.addAttribute("grupo", grupo);

		List<Encargado> listaEncargado = encargadoRepository.findAll();
		modelo.addAttribute("listaEncargado", listaEncargado);

		return "grupo_formulario";
	}
	
	@GetMapping("/grupos/eliminar/{id}")
	public String eliminarGrupo(@PathVariable("id") Integer id, Model modelo) {
		grupoRepository.deleteById(id);
		return "redirect:/grupos";
	}
}
