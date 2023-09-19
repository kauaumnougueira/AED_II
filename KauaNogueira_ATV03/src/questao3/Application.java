package questao3;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import lista.Lista;
import lista.No;

/**
 *
 * @author kaua
 */
public class Application<T extends Comparable> {
    public void quicksort(Lista lista) {
        quicksortRecursivo(lista.getInicio(), lista.getFim());
    }

    private void quicksortRecursivo(No<T> esquerda, No<T> direita) {
        if (esquerda != null && direita != null && esquerda != direita && esquerda.getAnterior() != direita) {
            No<T> pivot = particionar(esquerda, direita);
            
            quicksortRecursivo(esquerda, pivot.getAnterior());
            quicksortRecursivo(pivot.getProximo(), direita);
        }
    }

    private No<T> particionar(No<T> esquerda, No<T> direita) {
        T pivot = direita.getElemento();
        No<T> i = esquerda.getAnterior();

        for (No<T> j = esquerda; j != direita; j = j.getProximo()) {
            if (j.getElemento().compareTo(pivot) <= 0) {
                i = (i == null) ? esquerda : i.getProximo();
                trocar(i, j);
            }
        }

        i = (i == null) ? esquerda : i.getProximo();
        trocar(i, direita);

        return i;
    }

    private void trocar(No<T> a, No<T> b) {
        T temp = a.getElemento();
        a.setElemento(b.getElemento());
        b.setElemento(temp);
    }

    public T encontrarMediana(Lista lista) {
        quicksort(lista);
        int meio = lista.getTamanho() / 2;
        No<T> atual = lista.getInicio();

        for (int i = 0; i < meio; i++) {
            atual = atual.getProximo();
        }

        return atual.getElemento();
    }
    public static void main(String[] args) {
        Lista numeros = new Lista(null);
        try{
            File arquivo = new File("src\\questao3\\dadosQ3.txt");
            Scanner sc = new Scanner(arquivo);
            String linha_dados = sc.nextLine();
            
            String[] dados = linha_dados.split(",");
            for(String dado : dados){
                numeros.inserir(Integer.parseInt(dado));
            }
        }catch(FileNotFoundException e){
            
        }
        Application<Integer> app = new Application<>(); 
        Integer mediana = app.encontrarMediana(numeros);

        System.out.println(mediana);
        
    }
    
    
}
