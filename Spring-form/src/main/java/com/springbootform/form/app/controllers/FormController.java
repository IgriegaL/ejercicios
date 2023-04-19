package com.springbootform.form.app.controllers;

import com.springbootform.form.app.editors.NombreMayusculaEditor;
import com.springbootform.form.app.editors.PaisPropertyEditor;
import com.springbootform.form.app.models.domain.Pais;
import com.springbootform.form.app.models.domain.Usuario;
import com.springbootform.form.app.services.PaisService;
import com.springbootform.form.app.validation.UsuarioValidador;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@SessionAttributes("usuario")
public class FormController {

    @Autowired
    private UsuarioValidador validador;

    @Autowired
    private PaisService paisService;

    @Autowired
    private PaisPropertyEditor paisEditor;

    // Inyectamos el validador a binder, con esto todas las validaciones se harán en iniBinder.
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(validador);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, "fechaNacimiento", new CustomDateEditor(dateFormat, false));
        binder.registerCustomEditor(String.class, new NombreMayusculaEditor());

        binder.registerCustomEditor(Pais.class, "pais", paisEditor);
    }

    @ModelAttribute("listaPaises")
    public List<Pais> listaPaises() {
        return paisService.listar();
    }

    //Creamos esta lista y la pudemos usar donde queremos dentro del controlador
    // Además retorna una lista de tipo String
    @ModelAttribute("paises")
    public List<String> paises() {
        return Arrays.asList("España", "México", "Chile", "Argentina", "Perú", "Colombia", "Venezuela");
    }

    @ModelAttribute("paisesMap")
    public Map<String, String> paisesMap() {
        // Creamos el map, el map de Java, es una lista disociativa, guardamos datos que están asociados a un nombre
        // y luego podemos obtener estos datos accediendo al nombre o llave
        // Map es la interfaz y Hasmap es la implementación
        Map<String, String> paises = new HashMap<String, String>();
        // Agregamos con el put a la lista paises
        paises.put("ES", "España");
        paises.put("MX", "México");
        paises.put("CL", "Chile");
        paises.put("AR", "Argentina");
        paises.put("PE", "Perú");
        paises.put("CO", "Colombia");
        paises.put("VE", "Venezuela");

        return paises;
    }

    @GetMapping({"/form", "", "/"})
    public String form(Model model) {
        Usuario usuario = new Usuario();
        usuario.setNombre("John");
        usuario.setApellido("Doe");
        usuario.setIdentificador("13.124.674-k");
        model.addAttribute("titulo", "Formulario Usuario");
        // Para evitar el null y el error si ya estamos pidiendo el usuario
        model.addAttribute("usuario", usuario);
        return "form";
    }


    // Con request param podemos capturar los datos enviados por formulario:
    // También podemos usar @RequestParam(name = "usename") String username
    @PostMapping("/form")
    public String procesar(@Valid Usuario usuario,
                           BindingResult result,
                           Model model,
                           SessionStatus status) {
        /*
        Validamos inyectando validador con
        el objeto usuario y result para
        registrar los errores
        */
        model.addAttribute("titulo", "Resultado Form");
        if (result.hasErrors()) {
            return "form";
        }
        // Mostramos en la platilla resultado de nuestro usuario creado
        model.addAttribute("usuario", usuario);
        status.setComplete();
        return "resultado";
    }


}
