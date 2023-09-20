/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package questao2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import lista.Lista;
import lista.No;

/**
 *
 * @author kaua
 */
public class Application{
    public void selectionSort(Lista lista, String ordem) {
        if (lista.getTamanho() <= 1) {
            // A lista já está ordenada ou vazia
            return;
        }

        No<Produto> atual = lista.getInicio();
        while (atual != null) {
            if(ordem.equals("crescente")){
                No<Produto> menor = encontrarMenor(atual);
                trocar(atual, menor);
            }
            if(ordem.equals("decrescente")){
                No<Produto> maior = encontrarMaior(atual);
                trocar(atual, maior);
            }
            if(ordem.equals("alfabetica")){
                No<Produto> menor = encontrarMenorNome(atual);
                trocar(atual, menor);
            }
            atual = atual.getProximo();
        }
     }

    private No<Produto> encontrarMenor(No<Produto> atual) {
        No<Produto> menor = atual;
        No<Produto> noAtual = atual.getProximo();

        while (noAtual != null) {
            if (noAtual.getElemento().getValor() < menor.getElemento().getValor()) {
                menor = noAtual;
            }
            noAtual = noAtual.getProximo();
        }

        return menor;
    }
    
    private No<Produto> encontrarMaior(No<Produto> atual) {
        No<Produto> maior = atual;
        No<Produto> noAtual = atual.getProximo();

        while (noAtual != null) {
            if (noAtual.getElemento().getValor() > maior.getElemento().getValor()) {
                maior = noAtual;
            }
            noAtual = noAtual.getProximo();
        }

        return maior;
    }
    
    private No<Produto> encontrarMenorNome(No<Produto> atual) {
        No<Produto> menorNome = atual;
        No<Produto> noAtual = atual.getProximo();

        while (noAtual != null) {
            if (noAtual.getElemento().getDescricao().compareTo(menorNome.getElemento().getDescricao()) < 0) {
                menorNome = noAtual;
            }
            noAtual = noAtual.getProximo();
        }

        return menorNome;
    }
    
    private void trocar(No<Produto> a, No<Produto> b) {
        Produto temp = a.getElemento();
        a.setElemento(b.getElemento());
        b.setElemento(temp);
    }
    
    public void crescenteValor(Lista produtos){
        selectionSort(produtos, "crescente");
        produtos.imprimir();
    }
    
    public void decrescenteValor(Lista produtos){
        selectionSort(produtos, "decrescente");
        produtos.imprimir();
    }
    
    public void alfabetica(Lista produtos){
        selectionSort(produtos, "alfabetica");
        produtos.imprimir();
    }
    
    public static void main(String[] args){
        Lista<Produto> produtos = new Lista<>(null);
        try{
            File arquivo = new File("src\\questao2\\dadosQ2.txt");
            Scanner sc = new Scanner(arquivo);
            String linha_dados = sc.nextLine();
            
            String[] dados = linha_dados.split(",");
            for(String dado : dados){
                String separados[] = dado.split("-");
                Produto produto = new Produto(separados[0], Double.parseDouble(separados[1]));
                produtos.inserir(produto);
            }
        }catch(FileNotFoundException e){
            
        }
        Application app = new Application();
        System.out.println("Ordem crescente de valores");
        app.crescenteValor(produtos);
        System.out.println("Ordem decrescente de valores");
        app.decrescenteValor(produtos); 
        System.out.println("Ordem Alfabetica de nomes");
        app.alfabetica(produtos);
    }
}

