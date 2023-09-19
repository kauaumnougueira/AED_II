/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package questao3;

import arvore.Arvore;
import arvore.No;

/**
 *
 * @author kaua
 */
public class Application {
    public static void main(String[] args){
        FileHandler fh = new FileHandler();
        String linhas = fh.readingFile();
        String[] linhasA = linhas.split(" ");
        Arvore arvore = new Arvore(Integer.parseInt(linhasA[0]));
        for(int i = 1; i < linhasA.length; i++){
            arvore.inserir(Integer.parseInt(linhasA[i]));
        }
        int menor = menorAltura(arvore.getRaiz());
        System.out.println("menor profundidade:" + menor);
    }
    private static int menorAltura(No<Integer> aux) {
        if(aux == null)
            return 0;
        
        int alturaDir = menorAltura(aux.getDireita());
        int alturaEsq = menorAltura(aux.getEsquerda());
        
        return Math.min(alturaDir, alturaEsq) + 1;
    }

}
