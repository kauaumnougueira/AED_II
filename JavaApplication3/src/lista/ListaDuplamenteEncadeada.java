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
    
    public ListaDuplamenteEncadeada(T elemento){
        inserir(elemento);
    }
    
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
    
    public void remover(T elemento){
        No<T> remover = encontraLista(elemento);
        remover = null;
        this.tamanho--;
        remover.getAnterior().setProximo(remover.getProximo());
        remover.getProximo().setAnterior(remover.getAnterior());
       
    }
    
    public String imprimir(){
        if(this.tamanho == 0){
            return "[]";
        }
        
        StringBuilder builder = new StringBuilder();
        
        No<T> impresso = this.inicio;
        builder.append(impresso.getElemento()).append('\n');
        
        while(impresso.getProximo() != null){
           builder.append(impresso.getProximo().getElemento()).append('\n'); 
           impresso = impresso.getProximo();
        }
        
        return builder.toString();
    }
    
    public String buscar(T elemento){
         No<T> encontrado = encontraLista(elemento);
         return encontrado.getElemento().toString();
    }
    
    private No<T> encontraLista(T elemento){
        No<T> noAtual = this.inicio;
        
        if(this.tamanho == 1){
            return noAtual;
        }else{
         while(noAtual.getProximo() != null){
            if(noAtual.getElemento().equals(elemento)){
                return noAtual;
            }
            noAtual = noAtual.getProximo();
            }   
        }
        return null;
    }
}
