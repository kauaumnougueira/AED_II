/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package automacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author 20221SI0033
 */
class FileHandler {
    /*
    
    lista 
    REMOVER; bola
    IMPRIMIR
    INSERIR; casa
    IMPRIMIR;
    BUSCAR; colher
    
    */
    String path = "../Exec.txt";
    
    public String readingFile(){
       String lineSave = "";
 
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            //line = lista
            lineSave = line + "#";
            while(line != null){
                line = br.readLine();// remover; bola
                if(line != null){
                    lineSave += line + "#";
                }
            }
        } catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
        //retorna em String para funcionar no Label Text
        return lineSave;
    }
}