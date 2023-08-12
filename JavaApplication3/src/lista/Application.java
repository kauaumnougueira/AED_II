/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lista;

/**
 *
 * @author kaua
 */
class T{
    private String name;
    private int idade;
    
    public T(String name, int idade){
        this.name = name;
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "T{" + "name=" + name + ", idade=" + idade + '}';
    }
}
public class Application {
    public static void main(String[] args){
        T t = new T("kaua", 14);
        ListaDuplamenteEncadeada listaDE = new ListaDuplamenteEncadeada(t);
        
        T t2 = new T("Pedro", 16);
        listaDE.inserir(t2);
        
        T t3 = new T("Lucas", 16);
        listaDE.inserir(t3);
        
        T t4 = new T("Gabriel", 14);
        listaDE.inserir(t4);
        
        System.out.println(listaDE.imprimir());
    }
}
