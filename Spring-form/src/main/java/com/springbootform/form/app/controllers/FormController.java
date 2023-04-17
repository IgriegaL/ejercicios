package com.springbootform.form.app.controllers;

import com.springbootform.form.app.models.domain.Usuario;
import com.springbootform.form.app.validation.UsuarioValidador;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("usuario")
public class FormController {

    @Autowired
    private UsuarioValidador validador;

    @GetMapping({"/form","","/"})
    public String form(Model model){
        Usuario usuario = new Usuario();
        usuario.setNombre("John");
        usuario.setApellido("Doe");
        usuario.setIdentificador("13.124.674-k");
        model.addAttribute("titulo","Formulario Usuario");
        // Para evitar el null y el error si ya estamos pidiendo el usuario
        model.addAttribute("usuario",usuario);
        return "form";
    }


    // Con request param podemos capturar los datos enviados por formulario:
    // También podemos usar @RequestParam(name = "usename") String username
    @PostMapping("/form")
    public String procesar(@Valid Usuario usuario,
                           BindingResult result,
                           Model model,
                           SessionStatus status){
        /*
        Validamos inyectando validador con
        el objeto usuario y result para
        registrar los errores
        */

        validador.validate(usuario,result);

        model.addAttribute("titulo","Resultado Form");
        if(result.hasErrors()){
             return "form";
        }
        // Mostramos en la  platilla resultado de nuestro usuario creado
        model.addAttribute("usuario",usuario);
        status.setComplete();
        return "resultado";
    }



}
