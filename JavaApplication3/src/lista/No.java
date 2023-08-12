/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lista;

/**
 *
 * @author kaua
 */
public class No<T> {
    private T elemento;
    private No<T> proximo;
    private No<T> anterior;

    public No(T elemento) {
        this.elemento = elemento;
        this.proximo = null;
        this.anterior = null;
    }

    public No(T elemento, No<T> proximo){
        this.elemento = elemento;
        this.proximo = proximo;
    }
    
    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public No<T> getProximo() {
        return proximo;
    }

    public void setProximo(No<T> proximo) {
        this.proximo = proximo;
    }

    public No<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(No<T> anterior) {
        this.anterior = anterior;
    }
    
    
}
