/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fila;
import ClassePadrao.T;
/**
 *
 * @author kaua
 */
public class Application {
    public static void main(String[] args){
        T t = new T("kaua", 14);
        Fila filaD = new Fila(t);
        
        T t2 = new T("Pedro", 16);
        filaD.inserir(t2);
        
        T t3 = new T("Lucas", 16);
        filaD.inserir(t3);
        
        T t4 = new T("Gabriel", 14);
        filaD.inserir(t4);
        
        filaD.imprimir();
        System.out.println("===========");
        filaD.remover();
        filaD.imprimir();
    }
}