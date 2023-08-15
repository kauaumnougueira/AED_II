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
        
        if(remover == null)
            return;
        
        if (remover == this.inicio)
            this.inicio = remover.getProximo();
        else
            remover.getAnterior().setProximo(remover.getProximo());

        if (remover == this.fim)
            this.fim = remover.getAnterior();
        else
            remover.getProximo().setAnterior(remover.getAnterior());
    

        this.tamanho--;
        
       
    }
    
    public void imprimir(){
        if(this.tamanho == 0){
            System.out.println("[]");
        }
        
        No<T> impresso = this.inicio;
        
        while(impresso != null){
            System.out.println(impresso.getElemento().toString());
            impresso = impresso.getProximo();
        }
    }
    
    public String buscar(T elemento){
         No<T> encontrado = encontraLista(elemento);
         return encontrado.getElemento().toString();
    }
    
    private No<T> encontraLista(T elemento){
        No<T> noAtual = this.inicio;

        while (noAtual != null) {
            if (noAtual.getElemento().equals(elemento))
                return noAtual;
        
            noAtual = noAtual.getProximo();
        }
        
        return null;
    }
}
