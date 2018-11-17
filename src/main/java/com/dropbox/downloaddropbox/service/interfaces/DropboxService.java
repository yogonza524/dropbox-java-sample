package com.dropbox.downloaddropbox.service.interfaces;

import java.io.File;

public interface DropboxService {

    File readFile(String foldername, String filename);
}
