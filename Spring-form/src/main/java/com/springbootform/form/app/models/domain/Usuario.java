package com.springbootform.form.app.models.domain;

import java.util.Date;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
//import org.springframework.format.annotation.DateTimeFormat;

import com.springbootform.form.app.validation.IdentificadorRegex;
import com.springbootform.form.app.validation.Requerido;

public class Usuario {

    @IdentificadorRegex
    private String identificador;
    private String nombre;
    @Requerido
    private String apellido;

    @NotEmpty
    @Size(min = 3, max = 8)
    private String username;
    @NotEmpty
    private String password;
    @Requerido
    @Email
    private String email;

    @NotNull(message = "Campo no puede quedar vacío, Ingrese número entero")
    @Min(5)
    @Max(5000)
    private Integer cuenta;

    @Past
    @NotNull
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaNacimiento;
    // Como es un string, se usa notEmpty
    @NotNull
    private Pais pais;

    // G & S

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public Integer getCuenta() {
        return cuenta;
    }

    public void setCuenta(Integer cuenta) {
        this.cuenta = cuenta;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
