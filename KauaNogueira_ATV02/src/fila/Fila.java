/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fila;

/**
 *
 * @author kaua
 */
public class Fila<T> {
    private No<T> inicio;
    private No<T> fim;
    private int tamanho = 0;
    
    public Fila(T elemento){
        if(elemento != null)
            inserir(elemento);
    }
    
    public void inserir(T elemento){
        No<T> no = new No<T>(elemento);
        if(tamanho == 0)
            inicio = no;
        else
            fim.setProximo(no);
        fim = no;
        tamanho++;
        System.out.println("Elemento inserido: " + elemento.toString());
    }
    
    public void imprimir(){
        System.out.print("Impressao: ");
        if(tamanho == 0){
            System.out.println("Fila vazia");
            return;
        }
        No<T> no = inicio;
        while(no != null){
            System.out.print(no.getElemento().toString() +" ");
            no = no.getProximo();
        }
        System.out.println();
    }
    
    public void remover(){
        if(inicio != null){
            System.out.println("Primeiro elemento removido: " + this.inicio.getElemento().toString());
            inicio = inicio.getProximo();
            tamanho--;
        }
    }
    
    public String buscar(T elemento){
        if(this.tamanho != 0){
            No<T> no = inicio;
            while(no != null){
                if(no.getElemento().equals(elemento)){
                    return no.getElemento().toString();
                }
                no = no.getProximo();
            }
            return "nao encontrado";
        }
        
        return "Fila vazia";
    }
    
}
