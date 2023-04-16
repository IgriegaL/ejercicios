package com.udemyuno.app;

import com.udemyuno.models.domain.ItemFactura;
import com.udemyuno.models.domain.Producto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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

    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setPrefix("classpath:/templates/");
        templateResolver.setSuffix(".html");
        return templateResolver;
    }

}
