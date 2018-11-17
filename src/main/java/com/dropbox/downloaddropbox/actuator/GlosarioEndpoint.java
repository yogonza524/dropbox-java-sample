package com.dropbox.downloaddropbox.actuator;

import com.dropbox.downloaddropbox.model.Glosario;
import org.springframework.boot.actuate.endpoint.Endpoint;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GlosarioEndpoint implements Endpoint<List<Glosario>> {

    @Override
    public String getId() {
        return "glosario";
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean isSensitive() {
        //Respetar o no las mayusculas de manera restrictiva
        return false;
    }

    @Override
    public List<Glosario> invoke() {
        // Custom logic to build the output
        List<Glosario> diccionario = new ArrayList<Glosario>();

        diccionario.add(Glosario.builder().clave("facility")
                .definicion("servicios que ofreecen los centros deportivos, que son independientes de las canchas que " +
                        "no hacen a la experiencia directa del deporte que vaya a practicar. " +
                        "Ejemplo: wifi, parrilla, duchas")
                .build());

        return diccionario;
    }
}