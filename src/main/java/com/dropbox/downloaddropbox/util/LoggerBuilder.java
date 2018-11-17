package com.dropbox.downloaddropbox.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerBuilder {

    private String salida;
    private Logger log;
    private LevelEnum level;

    public LoggerBuilder(Class clazz) {
        this.salida = "";
        log = LoggerFactory.getLogger(clazz);
    }

    public LoggerBuilder level(LevelEnum level) {
        this.level = level;
        return this;
    }

    public LoggerBuilder and(String clave, Object valor) {
        this.salida += clave + "=" + valor + ",";
        return this;
    }

    public void show(LevelEnum level) {
        if (this.salida.length() > 0) {
            this.salida = salida.substring(0, salida.length() - 1);

            if (this.level == null) {
                this.level = LevelEnum.INFO;
            }

            switch (this.level) {
                case INFO: log.info(salida); break;
                case WARN: log.warn(salida); break;
                case ERROR: log.error(salida); break;
            }

            this.salida = ""; //Reset buffer
        }
    }
}
