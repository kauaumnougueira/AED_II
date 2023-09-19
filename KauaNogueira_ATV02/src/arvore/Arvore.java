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
    
    public Arvore(T elemento){
        if(elemento != null)
            inserir(elemento);
    }
    
    public void inserir(T elemento){
       No<T> aux = new No<>(elemento);
       if(this.raiz == null){
           this.raiz = aux;
           this.tamanho++;
           System.out.println("Elemento inserido: " + aux.getElemento().toString());
       }else{
           No<T> atual = this.raiz;
           while(true){
               if( aux.getElemento().compareTo(atual.getElemento()) == -1 ){
                   if(atual.getEsquerda() != null ){
                       atual = atual.getEsquerda();
                   }else{
                       atual.setEsquerda(aux);
                       this.tamanho++;
                       System.out.println("Elemento inserido: " + aux.getElemento().toString());
                       break;
                   }
               }else{
                   if(atual.getDireita() != null){
                       atual = atual.getDireita();

                   }else{
                       atual.setDireita(aux);
                       this.tamanho++;
                       System.out.println("Elemento inserido: " + aux.getElemento().toString());
                       break;
                   }
               }
           }
       }
    }
     
    public String buscar(T elemento){
        if(tamanho != 0){
            No<T> atual = raiz;
            return buscarRecursivamente(atual, elemento).getElemento().toString();
        }
        return "Arvore vazia";
    }
    public No<T> buscarRecursivamente(No<T> atual, T elemento) {
        if (atual == null)
            return null;
        
        if (atual.getElemento().equals(elemento)) 
            return atual;

        return (atual.getEsquerda() != null) ? buscarRecursivamente(atual.getEsquerda(), elemento) : buscarRecursivamente(atual.getDireita(), elemento);
    }   
    public No<T> buscarNo(T elemento){
        if(tamanho != 0)
            return buscarRecursivamente(raiz, elemento);
        return null;
    }
    public void remover(T elemento) {
        if(this.tamanho == 0){
            System.out.println("Lista vazia: elemento " + elemento + " nao removido");
            return;
        }
        raiz = removerRecursivamente(raiz, elemento);
        System.out.println("Elemento removido: " + elemento);
    }

    private No<T> removerRecursivamente(No<T> atual, T elemento) {
        if (atual == null) {
            return null;
        }

        if (elemento.compareTo(atual.getElemento()) < 0) {
            atual.setEsquerda(removerRecursivamente(atual.getEsquerda(), elemento));
        } else if (elemento.compareTo(atual.getElemento()) > 0) {
            atual.setDireita(removerRecursivamente(atual.getDireita(), elemento));
        } else {
            if (atual.getEsquerda() == null) {
                return atual.getDireita();
            } else if (atual.getDireita() == null) {
                return atual.getEsquerda();
            }

            No<T> sucessor = encontrarMenor(atual.getDireita());
            atual.setElemento(sucessor.getElemento());
            atual.setDireita(removerRecursivamente(atual.getDireita(), sucessor.getElemento()));
        }
        return atual;
    }

    private No<T> encontrarMenor(No<T> no) {
        while (no.getEsquerda() != null) {
            no = no.getEsquerda();
        }
        return no;
    }
    
    public void imprimir() {
        System.out.print("Impressao: ");
        imprimirRecursivo(this.raiz);
        System.out.println(); // Pular uma linha após a impressão completa
        
    }

    private void imprimirRecursivo(No<T> no) {
        if (no != null) {
            imprimirRecursivo(no.getEsquerda());
            System.out.print(no.getElemento() + " ");
            imprimirRecursivo(no.getDireita());
        }
    }
}
