package com.dropbox.downloaddropbox.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class Glosario implements Serializable {

    private static final long serialVersionUID = -7520742585547626791L;

    private String clave;
    private String definicion;
}
