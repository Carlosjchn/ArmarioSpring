package com.dam.armario.servicios;
import java.io.*;
import java.util.Date;

public class ServiciosLogs {

        Date fecha = new Date();

        public void logError(String error) {
            File f = new File(Constantes.rutaError);
            FileWriter fw;
            try {
                fw = new FileWriter(f, true);
                BufferedWriter bw = new BufferedWriter(fw); 

                bw.write("\n" + fecha + " [ERROR] " + error);
                bw.close(); 
                fw.close(); 
            } catch (IOException e) {
                e.printStackTrace();
            } 
        }

        public void logInfo(String mensaje) {
            File f = new File(Constantes.rutaInfo);
            FileWriter fw;
            try {
                fw = new FileWriter(f, true);
                BufferedWriter bw = new BufferedWriter(fw); 
                bw.write("\n " + fecha + " [INFO] " + mensaje);
                bw.close(); 
                fw.close(); 
            } catch (IOException e) {
                e.printStackTrace();
            } 
        }
    }


