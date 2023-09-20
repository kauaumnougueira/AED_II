/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package questao5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author kaua
 */
public class Application {
    public int[] insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // Mova os elementos do arr[0..i-1] que são maiores que a chave
            // para uma posição à frente de sua posição atual
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        
        return arr;
    }
    public static void main(String[] args){
        try{
            File arquivo = new File("src\\entradas\\dadosQ5.txt");
            Scanner sc = new Scanner(arquivo);
            String X_linha = sc.nextLine();
            String[] xises = X_linha.split(", ");
            int[] X = new int[xises.length];
            int countZ = 0;
            for(int i = 0; i < xises.length; i++){
                if(xises[i].equals("0"))
                   countZ++; 
                X[i] = Integer.parseInt(xises[i]);
            }
            
            String Y_linha = sc.nextLine();
            String[] yos = Y_linha.split(", ");
            int[] Y = new int[yos.length];
            if(countZ > yos.length){

                for(int i = 0; i < yos.length; i++){
                    Y[i] = Integer.parseInt(yos[i]);
                }


                int j = 0;
                for(int i = 0; i < X.length; i++){
                    if(X[i] == 0){
                        X[i] = Y[j];
                        j++;
                    }
                }
                questao5.Application app = new questao5.Application();
                X = app.insertionSort(X);
                System.out.println("Mesclados e ordenados: ");
                for(int x : X){
                    System.out.print(x + " ");
                }
            }else{
                System.out.println("Tamanho de Y incompatível com quantidade de espaços vazios em X");
            }
        }catch(FileNotFoundException e){
            
        }
        
    }
}
