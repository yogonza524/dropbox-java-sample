package com.dropbox.downloaddropbox.service.implementations;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.downloaddropbox.service.interfaces.DropboxService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;

@Service
public class DropboxDefaultService implements DropboxService {

    private static final String ACCESS_TOKEN = "W5fFi5lAQOUAAAAAAAAac1sMqqfepzLizih3-9ljDnQBIs2AmFDAGcw9GcDD1cDj";
    private DbxClientV2 dropbox;

    private final Logger log = LoggerFactory.getLogger(DropboxDefaultService.class);

    @PostConstruct
    public void init() {
        DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/fletz").build();
        dropbox = new DbxClientV2(config, ACCESS_TOKEN);
    }


    @Override
    public File readFile(String foldername, String filename)
    {
        File result = null;
        try
        {
            String rutaImagenAbsoluta = "/home/gonzalo/Escritorio/pepe.jpg";
            //output file for download --> storage location on local system to download file
            FileOutputStream downloadFile = new FileOutputStream(rutaImagenAbsoluta);
            log.warn("Se buscara descargar: " + foldername + "/" + filename);
            try {
                FileMetadata metadata = dropbox.files()
//                        .downloadBuilder(foldername + "/" + filename)
                        .downloadBuilder("/Imagenes/sanmartin.jpg")
                        .download(downloadFile);
                if (new File(rutaImagenAbsoluta).exists()) {
                    result = new File(rutaImagenAbsoluta);
                }

            } catch (DbxException e) {
                e.printStackTrace();
            } finally
            {
                downloadFile.close();
            }
        }
        //exception handled
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return result;
    }

    private String currentPath() {
        try {
            return new File(DropboxDefaultService.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getPath();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return "/";
    }
}
