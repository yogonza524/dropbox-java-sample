package com.dropbox.downloaddropbox.controller;

import com.dropbox.downloaddropbox.service.interfaces.DropboxService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class MvcController {

    private final Logger log = LoggerFactory.getLogger(MvcController.class);

    @Autowired
    private DropboxService dropboxService;

    @Autowired
    ServletContext servletContext;

    @RequestMapping(value = "/image/{nombreConExtension}", method = RequestMethod.GET)
    public void getImageAsByteArray(@PathVariable("nombreConExtension") String nombreImagen,
                                    HttpServletResponse response) throws IOException {

        log.error("Imagen solicitada: " + nombreImagen);

        File imagenDescargada = dropboxService.readFile("Imagenes", nombreImagen);

        if (imagenDescargada != null) {
            log.warn("Imagen descargada! path: " + imagenDescargada.getAbsolutePath());
            InputStream in = new FileInputStream(imagenDescargada);
            response.setContentType(MediaType.IMAGE_JPEG_VALUE);
            log.warn("in: " + in + ". response: " + response);
            IOUtils.copy(in, response.getOutputStream());
        }
        else {
            log.error("No se encontró la imagen");
        }
    }
}
