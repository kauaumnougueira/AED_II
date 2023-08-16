/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arvore;

/**
 *
 * @author kaua
 */
public class ArvoreBinaria<T> {
    private No<T> raiz;
    private int tamanho = 0;
    
    public void inserir(T elemento){
        No<T> no = new No<T>(elemento);
        if(tamanho == 0)
            raiz = no;
        else{
            No<T> raiz_aux = raiz;
            inserir_recursao(raiz_aux, no);
        }
        
    }
    private void inserir_recursao(No<T> raiz, No<T> no){
        if(raiz == null){
            raiz = no;
        }else{
            if(raiz.getEsquerda() == null)
                raiz.setEsquerda(no);
            else if(raiz.getDireita() == null)
                raiz.setDireita(no);
            else{
                raiz = raiz.getEsquerda();
                inserir_recursao(raiz, no);
            }
        }
    }
}
