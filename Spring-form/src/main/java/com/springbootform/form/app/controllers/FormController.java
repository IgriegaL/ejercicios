package com.springbootform.form.app.controllers;

import com.springbootform.form.app.models.domain.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {
    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("titulo","Formulario Usuario");
        return "form";
    }
    // Con request param podemos capturar los datos enviados por formulario:
    // También podemos usar @RequestParam(name = "usename") String username
    @PostMapping("/form")
    public String procesar(Usuario usuario, Model model){
        model.addAttribute("titulo","Resultado Form");
        // Mostramos en la platilla resultado de nuestro usuario creado
        model.addAttribute("usuario",usuario);
        return "resultado";
    }

}
