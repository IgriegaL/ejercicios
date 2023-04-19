package com.springbootform.form.app.services;

import com.springbootform.form.app.models.domain.Pais;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PaisServiceImpl implements PaisService {

    //Se crea la List<Pais> y Añadimos un atributo desde PaisServiceImpl
    private List<Pais> lista;

    // Con este constructor inicializamos nuestra lista
    public PaisServiceImpl() {
        // traemos nuestra lista
        this.lista = Arrays.asList(
                new Pais(1, "ES", "España"),
                new Pais(2, "MX", "México"),
                new Pais(3, "CL", "Chile"),
                new Pais(4, "AR", "Argentina"),
                new Pais(5, "PE", "Perú"),
                new Pais(6, "CO", "Colombia"),
                new Pais(7, "VE", "Venezuela"));
    }

    @Override
    public List<Pais> listar() {
        return lista; // Retorna la lista de países
    }

    /*
     * Con el siguiente método, buscamos con un for cada pais
     * y si conincide con el numero que se está preguntando
     * */

    @Override
    public Pais obtenerPorId(Integer id) {
        Pais resultado = null;
        // luego traemos la lista de PaisServiceImpl y la recorremos con un for each
        for (Pais pais : this.lista) {
            // id == id dentro de pais
            if (id == pais.getId()) {
                resultado = pais;
                break;
            }

        }
        return resultado;
    }
}
