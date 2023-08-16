/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pilha;
import ClassePadrao.T;
/**
 *
 * @author kaua
 */
public class Application {
    public static void main(String[] args){
        T t = new T("kaua", 14);
        PilhaDinamica pilhaD = new PilhaDinamica(t);
        
        T t2 = new T("Pedro", 16);
        pilhaD.inserir(t2);
        
        T t3 = new T("Lucas", 16);
        pilhaD.inserir(t3);
        
        T t4 = new T("Gabriel", 14);
        pilhaD.inserir(t4);
        
        pilhaD.imprimir();
        
        pilhaD.remover();
        pilhaD.imprimir();
    }
}
