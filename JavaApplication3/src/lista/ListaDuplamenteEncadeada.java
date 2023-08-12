/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lista;

/**
 *
 * @author kaua
 */
public class ListaDuplamenteEncadeada<T> {
    private No<T> inicio;
    private No<T> fim;
    private int tamanho = 0;
    
    public int getTamanho(){
        return this.tamanho;
    }
    
    public void inserir(T elemento){
        No<T> no = new No<T>(elemento);
        if(this.tamanho == 0)
            this.inicio = no;
        else{
            this.fim.setProximo(no);
            no.setAnterior(this.fim);
        }
        this.fim = no;
        this.tamanho++;
    }
    
    
}
