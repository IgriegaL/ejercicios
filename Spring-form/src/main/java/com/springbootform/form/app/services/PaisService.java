package com.springbootform.form.app.services;

import com.springbootform.form.app.models.domain.Pais;

import java.util.List;

public interface PaisService {
    // Creamos 2 métodos uno par alistar paises
    public List<Pais> listar();

    // Y el segundo buscar para obtener un país
    public Pais obtenerPorId(Integer id);
}
