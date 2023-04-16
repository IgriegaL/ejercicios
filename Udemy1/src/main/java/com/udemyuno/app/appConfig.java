package com.udemyuno.app;

import com.udemyuno.models.domain.ItemFactura;
import com.udemyuno.models.domain.Producto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;

import java.util.Arrays;
import java.util.List;

@Configuration
public class appConfig {

    @Bean("itemsFactura")
    public List<ItemFactura> registrarITems() {
        Producto producto1 = new Producto("Camara Sony", 100);
        Producto producto2 = new Producto("Bicicleta", 200);
        ItemFactura linea1 = new ItemFactura(producto1, 2);
        ItemFactura linea2 = new ItemFactura(producto2, 2);
        return Arrays.asList(linea1, linea2); // Arrays convertir a lista
    }
    @Bean("itemsFacturaOficina ")
    @Primary
    public List<ItemFactura> registrarIremsOficina() {
        Producto producto1 = new Producto("Monitor Lg", 250);
        Producto producto2 = new Producto("Macbook", 500);
        Producto producto3 = new Producto("Impresora Hp", 80);
        Producto producto4 = new Producto("Escritorio Oficina", 70);
        ItemFactura linea1 = new ItemFactura(producto1, 2);
        ItemFactura linea2 = new ItemFactura(producto2, 2);
        ItemFactura linea3 = new ItemFactura(producto3, 1);
        ItemFactura linea4 = new ItemFactura(producto4, 4);
        return Arrays.asList(linea1, linea2, linea3, linea4); // Arrays convertir a lista
    }

    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setPrefix("classpath:/templates/");
        templateResolver.setSuffix(".html");
        return templateResolver;
    }

}
