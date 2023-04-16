package com.springbootform.form.app.controllers;

import com.springbootform.form.app.models.domain.Usuario;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class FormController {
    @GetMapping({"/form","","/"})
    public String form(Model model){

        Usuario usuario = new Usuario();
        usuario.setNombre("John");
        usuario.setApellido("Doe");
        model.addAttribute("titulo","Formulario Usuario");
        // Para evitar el null y el error si ya estamos pidiendo el usuario
        model.addAttribute("usuario",usuario);
        return "form";
    }


    // Con request param podemos capturar los datos enviados por formulario:
    // También podemos usar @RequestParam(name = "usename") String username
    @PostMapping("/form")
    public String procesar(@Valid Usuario usuario,  BindingResult result, Model model){

        model.addAttribute("titulo","Resultado Form");
        if(result.hasErrors()){
             return "form";
        }
        // Mostramos en la platilla resultado de nuestro usuario creado
        model.addAttribute("usuario",usuario);
        return "resultado";
    }

}
