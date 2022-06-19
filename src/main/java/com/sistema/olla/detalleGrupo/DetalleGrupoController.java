package com.sistema.olla.detalleGrupo;

import com.sistema.olla.grupo.Grupo;
import com.sistema.olla.servicio.DetalleGrupoService;
import com.sistema.olla.servicio.GrupoService;
import com.sistema.olla.servicio.VoluntarioService;
import com.sistema.olla.voluntario.Voluntario;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
public class DetalleGrupoController {

    @Autowired
    private DetalleGrupoService detalleGrupoService;

    @Autowired
    private DetalleGrupoRepository detalleGrupoRepository;

    @Autowired
    private GrupoService grupoService;

    @Autowired
    private VoluntarioService voluntarioService;

 

    @GetMapping("/detallegrupo/listavoluntario/{id}")
    public String listaVoluntarios(@PathVariable(value = "id")Integer id, Model modelo){

        Grupo grupo = grupoService.findOne(id);
        List<DetalleGrupo> listavoluntarios = detalleGrupoService.buscarPorGrupo(id);
        modelo.addAttribute("listavoluntarios", listavoluntarios);
        modelo.addAttribute("grupo", grupo);

        return "/recursos/listavoluntarios";
    }

    @GetMapping("/detallegrupo/eliminarv/{id}/{idv}")
    public String eliminarVoluntario(@PathVariable("id") Integer id,@PathVariable("idv") Integer idv, Model modelo, RedirectAttributes redirect) {
        Integer idDetalle = detalleGrupoService.eliminarVoluntario(id, idv);
        detalleGrupoRepository.deleteById(idDetalle);
        return "redirect:/detallegrupo/listavoluntario/"+id;
    }

    @GetMapping("/detallegrupo/listagrupos/{id}")
    public String listaGrupos(@PathVariable(value = "id")Integer id, Model modelo){

        Voluntario voluntario = voluntarioService.findOne(id);
        List<DetalleGrupo> listagrupos = detalleGrupoService.buscarPorVoluntario(id);
        modelo.addAttribute("listagrupos", listagrupos);
        modelo.addAttribute("voluntario", voluntario);

        return "/recursos/listagrupos";
    }

    @GetMapping("/detallegrupo/eliminarg/{id}/{idv}")
    public String eliminarGrupo(@PathVariable("id") Integer id,@PathVariable("idv") Integer idv, Model modelo, RedirectAttributes redirect) {
        Integer idDetalle = detalleGrupoService.eliminarVoluntario(id, idv);
        detalleGrupoRepository.deleteById(idDetalle);
        return "redirect:/detallegrupo/listagrupos/"+idv;
    }

    @GetMapping("/detallegrupo/nuevo/{id}")
    public String nuevoGrupo(@PathVariable("id") Integer id,Model modelo){

        List<Grupo> lista = grupoService.findAll();
        List<Voluntario> listav = voluntarioService.findAll();

        modelo.addAttribute("detallegrupo", new DetalleGrupo());
        modelo.addAttribute("lista", lista);
        modelo.addAttribute("listav", listav);

        return "detallegrupo_formulario";
    }

    @PostMapping("/detallegrupo/grabar")
    public String grabarGrupo(DetalleGrupo detalleGrupo ,RedirectAttributes redirect){
        detalleGrupoRepository.save(detalleGrupo);
        return "redirect:/voluntarios";

    }

}
