package com.springbootform.form.app.editors;

import com.springbootform.form.app.models.domain.Pais;
import com.springbootform.form.app.services.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

// usamos componente de spring para poder inyectarlo
@Component
public class PaisPropertyEditor extends PropertyEditorSupport {
    // Traemos a Pais Service
    @Autowired
    private PaisService service;

    // Recibimos el texto, en este caso el id del pais y lo debemos convertir
    @Override
    public void setAsText(String idString) throws IllegalArgumentException {
        /*//lo convertimos
        Integer id = Integer.parseInt(idString);
        // Y lo pasamos como Integer
        this.setValue(service.obtenerPorId(id));
        */
        try {
            // Comprueba si la cadena está vacía antes de convertirla en un entero
            if (idString != null && !idString.isEmpty()) {
                Integer id = Integer.parseInt(idString);
                this.setValue(service.obtenerPorId(id));
            } else {
                // Establece el valor como null si la cadena está vacía
                this.setValue(null);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Error al convertir el ID de país en número entero", e);
        }
    }
}

