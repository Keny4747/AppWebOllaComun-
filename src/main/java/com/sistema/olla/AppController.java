package com.sistema.olla;

import com.sistema.olla.beneficiario.Olla;
import com.sistema.olla.distrito.Distrito;
import com.sistema.olla.distrito.DistritoRepository;
import com.sistema.olla.servicio.*;
import com.sistema.olla.usuario.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AppController {

	@Autowired
	private Ollaservice ollaservice;

	@Autowired
	private EncargadoService encargadoService;

	@Autowired
	private VoluntarioService voluntarioService;

	@Autowired
	private GrupoService grupoService;

	@Autowired
	private DistritoRepository distritoRepository;

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/")
	public String principal(){
		return "principal";
	}

	@GetMapping("/dashboard")
	public String verPagDeInicio(Model modelo) {
		modelo.addAttribute("cOlla",ollaservice.contarOllas());
		modelo.addAttribute("cEncargado", encargadoService.contarEncargado());
		modelo.addAttribute("cVoluntario", voluntarioService.contarVoluntario());
		modelo.addAttribute("cGrupo", grupoService.contarGrupo());
		return "index";
	}

	@GetMapping("/reporteform")
	public String reporte(Model modelo){

		List<Distrito> lista = distritoRepository.findAll();

		modelo.addAttribute("olla", new Olla());
		modelo.addAttribute("lista", lista);
		return "reporte";
	}

	@GetMapping("/reporte")
	public String buscarOlla(@RequestParam Integer id, Model modelo, @ModelAttribute("olla") Olla olla){
		List<Distrito> lista = distritoRepository.findAll();
		modelo.addAttribute("listaollas", ollaservice.listaOllas(id));
		modelo.addAttribute("lista", lista);
		return "reporte";
	}

	@GetMapping("/cerrar")
	public String cerrarSesion(HttpSession session, RedirectAttributes redirect){
		session.removeAttribute("name");
		return "redirect:/";
	}

	@GetMapping("/login")
	public String loginn(Model modelo){
		modelo.addAttribute("usuario", new Usuario());
		return "login";
	}

	@PostMapping("/login/ingresar")
	public String ingresar(@ModelAttribute("usuario") Usuario usuario){

		Usuario usuario1 = usuarioService.loggin(usuario.getUser());

		if (usuario1.getUser() != null){
			if (usuario1.getPassword().equals(usuario.getPassword())){
				return "redirect:/dashboard";
			}else{
				return "redirect:/login";
			}
		}else{
			return "redirect:/login";
		}

	}
}
