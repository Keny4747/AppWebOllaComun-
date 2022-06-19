package com.sistema.olla.voluntario;
import java.util.List;
import java.util.Map;


import com.sistema.olla.detalleGrupo.DetalleGrupoRepository;
import com.sistema.olla.servicio.DetalleGrupoService;
import com.sistema.olla.servicio.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.sistema.olla.servicio.VoluntarioService;

import com.sistema.olla.tipo.Tipo;
import com.sistema.olla.tipo.TipoRepository;
import com.sistema.olla.util.paginacion.PageRender;

@Controller
public class VoluntarioController {
	@Autowired
	private VoluntarioRepository voluntarioRepository;

	@Autowired
	private TipoRepository tipoRepository;
	
	@Autowired
	private VoluntarioService voluntarioService;

	@Autowired
	private DetalleGrupoService detalleGrupoService;

	@Autowired
	private DetalleGrupoRepository detalleGrupoRepository;

	@Autowired
	private GrupoService grupoService;


	@GetMapping("/voluntarios")
	public String listarVoluntarios(@RequestParam(name = "page",defaultValue = "0")int page, Model modelo) {
		
		
		
		Pageable pageRequest = PageRequest.of(page, 8);			
		Page<Voluntario> listaVoluntarios = voluntarioService.findAll(pageRequest);
		PageRender<Voluntario> pageRender = new PageRender<>("/voluntarios", listaVoluntarios);
		modelo.addAttribute("listaVoluntarios", listaVoluntarios);
		modelo.addAttribute("page", pageRender);		
		return "voluntarios";
	}

	@GetMapping("/voluntarios/nuevo")
	public String mostrarFormularioDeNuevoVoluntario(Model modelo) {

		List<Tipo> listaTipo = tipoRepository.findAll();

		modelo.addAttribute("voluntario", new Voluntario());
		modelo.addAttribute("listaTipo", listaTipo);
		return "voluntario_formulario";
	}

	@PostMapping("/voluntarios/guardar")
	public String guardarVolunatario(Voluntario voluntario,RedirectAttributes redirect) {
		voluntarioRepository.save(voluntario);
		redirect.addFlashAttribute("msgExito","El voluntario ha sido agregado con exito");
		return "redirect:/voluntarios";
	}

	@GetMapping("/voluntarios/editar/{id}")
	public String mostrarFormularioDeModificarVoluntario(@PathVariable("id") Integer id, Model modelo) {
		Voluntario voluntario = voluntarioRepository.findById(id).get();
		modelo.addAttribute("voluntario", voluntario);

		List<Tipo> listaTipo = tipoRepository.findAll();
		modelo.addAttribute("listaTipo", listaTipo);

		return "voluntario_formulario";
	}
	
	@GetMapping("/voluntarios/eliminar/{id}")
	public String eliminarVoluntario(@PathVariable("id") Integer id, Model modelo) {
		voluntarioRepository.deleteById(id);
		return "redirect:/voluntarios";
	}
	
	
	@GetMapping("/ver/{id}")
	public String verDetallesDelVoluntario(@PathVariable(value = "id")Integer id, Map<String,Object>modelo, RedirectAttributes flash){
		Voluntario voluntario = voluntarioService.findOne(id);
		if(voluntario == null) {
			flash.addFlashAttribute("error","El empleado no existe en la base de datos");
			return "redirect:/listar";
		}
		modelo.put("voluntario", voluntario);
		modelo.put("titulo","Detalles del voluntario: "+voluntario.getDni());
		return "/recursos/ver";
	}





}
