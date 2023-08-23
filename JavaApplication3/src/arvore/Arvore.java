/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arvore;

/**
 *
 * @author kaua
 * @param <T>
 */
public class Arvore<T extends Comparable> {
    private No<T> raiz;
    private int tamanho = 0;
    
     public void inserir(T elem){
        No<T> aux = new No<>(elem);
        if(this.raiz == null){
            this.raiz = aux;
            this.tamanho++;
        }else{
            No<T> atual = this.raiz;
            while(true){
                if( aux.getElemento().compareTo(atual.getElemento()) == -1 ){
                    if(atual.getEsquerda() != null ){
                        atual = atual.getEsquerda();
                    }else{
                        atual.setEsquerda(aux);
                        this.tamanho++;
                        break;
                    }
                }else{
                    if(atual.getDireita() != null){
                        atual = atual.getDireita();
                        
                    }else{
                        atual.setDireita(aux);
                        this.tamanho++;
                        break;
                    }
                }
            }
        }
    }
}
