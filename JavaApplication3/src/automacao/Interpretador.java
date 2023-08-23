/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package automacao;

import arvore.Arvore;
import fila.Fila;
import lista.Lista;
import pilha.Pilha;

/**
 *
 * @author kaua
 */
public class Interpretador {
    FileHandler fh = new FileHandler();
    String exec = fh.readingFile();
    String[] execA = toArray(exec);
    
    public void separacao(){
        String estrutura = execA[0];
        if(estrutura.equals("lista")){
           Lista lista = new Lista(0);
        }else if(estrutura.equals("fila")){
            Fila fila = new Fila(0);
        }else if(estrutura.equals("pilha")){
            Pilha pilha = new Pilha(0);
        }else if(estrutura.equals("arvore")){
            Arvore arvore = new Arvore(0);
        }
    }
    
    
    public String[] toArray(String string){
        String[] retorno = string.split("#");
        return retorno;
    }
}
