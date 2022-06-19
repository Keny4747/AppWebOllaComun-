package com.sistema.olla.detalleOllaGrupo;

import com.sistema.olla.beneficiario.Olla;

import com.sistema.olla.grupo.Grupo;
import com.sistema.olla.servicio.DetalleOllaGrupoService;
import com.sistema.olla.servicio.GrupoService;
import com.sistema.olla.servicio.Ollaservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class DetalleOllaGrupoController {

    @Autowired
    private Ollaservice ollaservice;

    @Autowired
    private DetalleOllaGrupoService detalleOllaGrupoService;

    @Autowired
    private DetalleOllaGrupoRepository detalleOllaGrupoRepository;

    @Autowired
    private GrupoService grupoService;


    @GetMapping("/detalleolla/listaollas/{id}")
    public String listaOllas(@PathVariable(value = "id")Integer id, Model modelo){

        Grupo grupo = grupoService.findOne(id);
        List<DetalleOllagrupo> listaollas = detalleOllaGrupoService.buscarPorGrupo(id);
        modelo.addAttribute("listaollas", listaollas);
        modelo.addAttribute("grupo", grupo);

        return "/recursos/listaollas";
    }


    @GetMapping("/detalleolla/eliminaro/{id}/{idv}")
    public String eliminarVoluntario(@PathVariable("id") Integer id,@PathVariable("idv") Integer idv, Model modelo, RedirectAttributes redirect) {
        Integer idDetalle = detalleOllaGrupoService.eliminarOlla(id, idv);
        detalleOllaGrupoRepository.deleteById(idDetalle);
        return "redirect:/detalleolla/listaollas/"+id;
    }

    @GetMapping("/detalleolla/listagrupos/{id}")
    public String listaGrupos(@PathVariable(value = "id")Integer id, Model modelo){

        Olla olla = ollaservice.findOne(id);
        List<DetalleOllagrupo> listagrupos = detalleOllaGrupoService.buscarPorOlla(id);
        modelo.addAttribute("listagrupos", listagrupos);
        modelo.addAttribute("olla", olla);

        return "/recursos/listagruposo";
    }


    @GetMapping("/detalleolla/eliminarg/{id}/{idv}")
    public String eliminarGrupoo(@PathVariable("id") Integer id, @PathVariable("idv") Integer idv, Model modelo, RedirectAttributes redirect) {
        Integer idDetalle = detalleOllaGrupoService.eliminarOlla(id, idv);
        System.out.println("El id es: "+idDetalle);
        detalleOllaGrupoRepository.deleteById(idDetalle);
        return "redirect:/detalleolla/listagrupos/"+idv;
    }

    @GetMapping("/detalleolla/nuevo/{id}")
    public String nuevoGrupo(@PathVariable("id") Integer id,Model modelo){

        List<Grupo> lista = grupoService.findAll();
        List<Olla> listao = ollaservice.findAll();

        modelo.addAttribute("detalleolla", new DetalleOllagrupo());
        modelo.addAttribute("lista", lista);
        modelo.addAttribute("listao", listao);

        return "detalleolla_formulario";
    }

    @PostMapping("/detalleolla/grabar")
    public String grabarOlla(DetalleOllagrupo detalleOllagrupo ,RedirectAttributes redirect){
        detalleOllaGrupoRepository.save(detalleOllagrupo);
        return "redirect:/ollas";

    }

}
