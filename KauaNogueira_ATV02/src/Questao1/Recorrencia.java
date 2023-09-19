/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Questao1;

import lista.Lista;
import lista.No;

/**
 *
 * @author kaua
 */
public class Recorrencia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FileHandler fh = new FileHandler();
        String linhas = fh.readingFile();
        String linhasA[] = linhas.split(">");
        Lista lista = new Lista(0);
        for(String linha : linhasA){
            int num = Integer.parseInt(linha);
            lista.inserir(num);
        }
        System.out.println(conta1s(lista.getInicio()));
    }

    public static int conta1s(No<Integer> no) {
        if (no != null) {
            if (no.getElemento() == 1) {
                return 1 + conta1s(no.getProximo());
            } else {
                return conta1s(no.getProximo());
            }
        }
        
        return 0;
    }
}
