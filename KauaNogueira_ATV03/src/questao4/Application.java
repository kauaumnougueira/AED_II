/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package questao4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import lista.Lista;
import questao2.Produto;

/**
 *
 * @author kaua
 */
public class Application {
    public void bubbleSort(ArrayList<Integer> lista) {
        int tamanho = lista.size();
        boolean trocou;

        for (int i = 0; i < tamanho - 1; i++) {
            trocou = false;

            for (int j = 0; j < tamanho - i - 1; j++) {
                if (lista.get(j) > lista.get(j + 1)) {
                    // Trocar os elementos se estiverem fora de ordem
                    Collections.swap(lista, j, j + 1);
                    trocou = true;
                }
            }

            // Se não houve trocas nesta passagem, a lista já está ordenada
            if (!trocou) {
                break;
            }
        }
    }
    public void bubbleSortDecrescente(ArrayList<Integer> lista) {
        int n = lista.size();
        boolean trocado;

        do {
            trocado = false;

            for (int i = 0; i < n - 1; i++) {
                if (lista.get(i) < lista.get(i + 1)) { // Compare para ordem decrescente
                    // Troca os elementos
                    int temp = lista.get(i);
                    lista.set(i, lista.get(i + 1));
                    lista.set(i + 1, temp);

                    trocado = true;
                }
            }
        } while (trocado);
    }
    
    public void divisao(ArrayList<Integer> lista){
        ArrayList<Integer> pares = new ArrayList<>();
        ArrayList<Integer> impares = new ArrayList<>();

        for (Integer numero : lista) {
            if (numero % 2 == 0) {
                pares.add(numero);
            } else {
                impares.add(numero);
            }
        }
        
        bubbleSortDecrescente(impares);
        bubbleSort(pares);
        lista.clear();
        for (Integer impar : impares) {
            lista.add(impar);
        }

        for (Integer par : pares) {
            lista.add(par);
        }     
    }
    
    public static void main(String[] args){
        ArrayList<Integer> numeros = new ArrayList<>();
        try{
            File arquivo = new File("src\\entradas\\dadosQ4.txt");
            Scanner sc = new Scanner(arquivo);
            String linha_dados = sc.nextLine();
            
            String[] dados = linha_dados.split(",");
            for(String dado : dados){
                numeros.add(Integer.parseInt(dado));
            }
        }catch(FileNotFoundException e){
            
        }
        questao4.Application app = new questao4.Application();
        app.divisao(numeros);
        for (int i = 0; i < numeros.size(); i++) {
            System.out.println(numeros.get(i));
        }
    }
}
