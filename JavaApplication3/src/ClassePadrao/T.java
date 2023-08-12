/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassePadrao;

/**
 *
 * @author kaua
 */
public class T{
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
