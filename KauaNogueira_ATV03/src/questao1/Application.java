/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package questao1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author kaua
 */
public class Application {
    public static void bucketSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        int range = max - min + 1;

        int bucketSize = 10; // Tamanho do balde
        int bucketCount = (range / bucketSize) + 1;

        int[][] buckets = new int[bucketCount][arr.length];
        int[] bucketSizes = new int[bucketCount];

        for (int i = 0; i < bucketCount; i++) {
            bucketSizes[i] = 0;
        }

        for (int num : arr) {
            int bucketIndex = (num - min) / bucketSize;
            buckets[bucketIndex][bucketSizes[bucketIndex]++] = num;
        }

        int index = 0;
        for (int i = 0; i < bucketCount; i++) {
            if (bucketSizes[i] > 0) {
                // Usar o Counting Sort para ordenar o balde atual
                countingSort(buckets[i], bucketSizes[i]);

                // Colocar os elementos ordenados de volta no array original
                for (int j = 0; j < bucketSizes[i]; j++) {
                    arr[index++] = buckets[i][j];
                }
            }
        }
    }

    public static void countingSort(int[] arr, int size) {
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        int range = max - min + 1;

        int[] count = new int[range];
        int[] output = new int[size];

        for (int i = 0; i < size; i++) {
            count[arr[i] - min]++;
        }

        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        for (int i = size - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }

        System.arraycopy(output, 0, arr, 0, size);
    }
    public static void main(String[] args) {
        try{
            
            File arquivo = new File("src\\entradas\\dadosQ1.txt");
            Scanner sc = new Scanner(arquivo);
            String linha_dados = sc.nextLine();
            String[] dados = linha_dados.split(",");
            int[] array = new int[dados.length];
            for(int i = 0; i < dados.length; i++){
                array[i] = Integer.parseInt(dados[i]);
            }
            System.out.println("Array antes da ordenacao: " + Arrays.toString(array));
            bucketSort(array);
            System.out.println("Array depois da ordenacao: " + Arrays.toString(array));
        }catch(FileNotFoundException e){
            
        }
        
        
    }
}
