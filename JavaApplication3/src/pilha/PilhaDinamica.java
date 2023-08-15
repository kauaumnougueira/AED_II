/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pilha;

/**
 *
 * @author kaua
 */
public class PilhaDinamica<T> {
    private No<T> topo;
    private int tamanho = 0;
    
    public PilhaDinamica(T elemento){
        inserir(elemento);
    }
    
    public void inserir(T elemento){
        No<T> no = new No<T>(elemento);
        if(this.tamanho != 0)
            no.setProximo(this.topo);
        this.topo = no;
        this.tamanho++;
        
    }
    
    public void imprimir(){
        if(tamanho == 0)
            System.out.println("[]");
        
        No<T> impresso = topo;
        while(impresso != null){
            System.out.println(impresso.getElemento().toString());
            impresso = impresso.getProximo();
        }
    }
    
    public void remover(){
        if (topo != null) {
            topo = topo.getProximo();
            tamanho--;
        }
    }
    
    
    public String buscar(T elemento){
        No<T> atual = topo;
        while(atual != null){
            if(atual.getElemento().equals(elemento))
                return atual.getElemento().toString();
            
            atual = atual.getProximo();
        }
        
        return "[]";
    }
}
