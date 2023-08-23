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
    }
    
    public void imprimir(){
        if(tamanho == 0){
            System.out.println("[]");
            return;
        }
        No<T> no = inicio;
        while(no != null){
            System.out.println(no.getElemento().toString());
            no = no.getProximo();
        }
    }
    
    public void remover(){
        if(inicio != null){
            inicio = inicio.getProximo();
            tamanho--;
        }
    }
    
    public String buscar(T elemento){
        No<T> no = inicio;
        while(no != null){
            if(no.getElemento().equals(elemento)){
                return no.getElemento().toString();
            }
            no = no.getProximo();
        }
        return "[]";
    }
    
}
