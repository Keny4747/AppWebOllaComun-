package com.sistema.olla.encargado;



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

import com.sistema.olla.servicio.EncargadoService;
import com.sistema.olla.util.paginacion.PageRender;




@Controller
public class EncargadoController {
	@Autowired
	private EncargadoRepository encargadoRepository;
	
	@Autowired
	private EncargadoService encargadoService;
	
	@GetMapping("/encargados")
	public String listarEncargados(@RequestParam(name = "page",defaultValue = "0")int page, Model modelo) {
		Pageable pageRequest = PageRequest.of(page, 8);			
		Page<Encargado> listaEncargados = encargadoService.findAll(pageRequest);
		PageRender<Encargado> pageRender = new PageRender<>("/encargados", listaEncargados);
		modelo.addAttribute("listaEncargados", listaEncargados);
		modelo.addAttribute("page", pageRender);
		
		return "encargados";
	}
	
	@GetMapping("/encargados/nuevo")
	public String mostrarFormularioDeNuevoEncargado(Model modelo) {
		modelo.addAttribute("encargado", new Encargado());
		return "encargado_formulario";
	}
	
	@PostMapping("/encargados/guardar")
	public String guardarCategoria(Encargado encargado,RedirectAttributes redirect) {
		encargadoRepository.save(encargado);
		redirect.addFlashAttribute("msgExito","El Encargado ha sido agregado con exito");
		return "redirect:/encargados";
	}
	
	@GetMapping("/encargados/editar/{id}")
	public String mostrarFormularioDeModificarEncargado(@PathVariable("id") Integer id, Model modelo) {
		Encargado encargado = encargadoRepository.findById(id).get();
		modelo.addAttribute("encargado", encargado);

		
		return "encargado_formulario";
	}
	
	@GetMapping("/encargados/eliminar/{id}")
	public String eliminarEncargado(@PathVariable("id") Integer id, Model modelo) {
		encargadoRepository.deleteById(id);
		return "redirect:/encargados";
	}
}
