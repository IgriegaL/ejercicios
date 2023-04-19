package com.springbootform.form.app.editors;

import java.beans.PropertyEditorSupport;

public class NombreMayusculaEditor extends PropertyEditorSupport {
    /*
    Llamamos para sobre escribir el método que recibe un String y
    lo devuelve con mayus y sin espacios
    */
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(text.toUpperCase().trim());
    }
}
