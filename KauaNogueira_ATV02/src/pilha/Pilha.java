/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pilha;

/**
 *
 * @author kaua
 */
public class Pilha<T> {
    private No<T> topo;
    private int tamanho = 0;
    
    public Pilha(T elemento){
        if(elemento != null)
            inserir(elemento);
    }
    
    public void inserir(T elemento){
        No<T> no = new No<T>(elemento);
        if(this.tamanho != 0)
            no.setProximo(this.topo);
        this.topo = no;
        this.tamanho++;
        System.out.println("Elemento inserido: " + elemento.toString());
        
    }
    
    public void imprimir(){
        System.out.print("Impressao: ");
        if(tamanho == 0)
            System.out.println("[]");
        
        No<T> impresso = topo;
        while(impresso != null){
            System.out.print(impresso.getElemento().toString() + " ");
            impresso = impresso.getProximo();
        }
        System.out.println();
    }
    
    public void remover(){
        if (topo != null) {
            System.out.println("Primeiro elemento removido: " + this.topo.getElemento().toString());
            topo = topo.getProximo();
            tamanho--;
        }
    }
    
    
    public String buscar(T elemento){
        if(this.tamanho !=0){
            No<T> atual = topo;
            while(atual != null){
                if(atual.getElemento().equals(elemento))
                    return atual.getElemento().toString();

                atual = atual.getProximo();
            }
            return "nao encontrado";
        }
        
        return "Pilha vazia";
    }
}
