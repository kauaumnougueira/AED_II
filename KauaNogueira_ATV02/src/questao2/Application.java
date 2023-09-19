/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package questao2;

import lista.Lista;
import lista.No;

/**
 *
 * @author kaua
 */
public class Application {
    public static void main(String[] args){
        FileHandler fh = new FileHandler();
        String linhas = fh.readingFile();
        String[] linhasA = linhas.split("/");  
        
        int[] pontos = new int[linhasA.length * 2];  

        for (int i = 0; i < linhasA.length; i++) {
            String[] parts = linhasA[i].split(";"); 
            pontos[i * 2] = Integer.parseInt(parts[0]); 
            pontos[i * 2 + 1] = Integer.parseInt(parts[1]);  
        }
        Ponto p1 = new Ponto(pontos[0], pontos[1]);
        Lista lista = new Lista(p1);
        
        for (int i = 2; i < pontos.length; i += 2) {
            Ponto paux = new Ponto(pontos[i], pontos[i + 1]);
            lista.inserir(paux);
        }

        lista.imprimir();
        todasDistancias(lista.getInicio());
        
    }
    public static double distancia(Ponto p1, Ponto p2){
        return Math.sqrt(Math.pow((p1.getX() - p2.getX()), 2) + Math.pow((p1.getY() - p2.getY()), 2));
    }
    
    public static void todasDistancias(No<Ponto> no) {
        if (no == null || no.getProximo() == null) {
            System.out.println("Não há pontos suficientes para calcular distâncias.");
            return;
        }

        No<Ponto> current = no;
        double menorDistancia = distancia(current.getElemento(), current.getProximo().getElemento());

        while (current != null) {
            No<Ponto> next = current.getProximo();
            
            while (next != null) {
                double distanciaAtual = distancia(current.getElemento(), next.getElemento());
                if (distanciaAtual < menorDistancia) {
                    menorDistancia = distanciaAtual;
                }
                next = next.getProximo();
            }
            
            current = current.getProximo();
        }

        System.out.println("A menor distância entre dois pontos é: " + menorDistancia);
    }
}
