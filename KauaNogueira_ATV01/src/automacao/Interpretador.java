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
    
    public void estruturas(){
        String estrutura = execA[0];
        if(estrutura.equals("lista")){
            Lista lista = new Lista(" ");
            String acoes[] = acoesInterpretadas(execA);
            for(int i = 0; i < acoes.length; i++){
                if(acoes[i] == null){
                    break;
                }
                acaoLista(acaoElemento(acoes[i]), acaoElemento(acoes[i+1]), lista);
                i++;
            }
        }else if(estrutura.equals("fila")){
            Fila fila = new Fila(" ");
            String acoes[] = acoesInterpretadas(execA);
            for(int i = 0; i < acoes.length; i++){
                if(acoes[i] == null){
                    break;
                }
                acaoFila(acaoElemento(acoes[i]), acaoElemento(acoes[i+1]), fila);
                i++;
            }
        }else if(estrutura.equals("pilha")){
            Pilha pilha = new Pilha(" ");
            String acoes[] = acoesInterpretadas(execA);
            for(int i = 0; i < acoes.length; i++){
                if(acoes[i] == null){
                    break;
                }
                acaoPilha(acaoElemento(acoes[i]), acaoElemento(acoes[i+1]), pilha);
                i++;
            }
        }else if(estrutura.equals("arvore")){
            Arvore arvore = new Arvore(" ");
            String acoes[] = acoesInterpretadas(execA);
            for(int i = 0; i < acoes.length; i++){
                if(acoes[i] == null){
                    break;
                }
                acaoArvore(acaoElemento(acoes[i]), acaoElemento(acoes[i+1]), arvore);
                i++;
            }
        }
    }
    
    public void acaoLista(String acao, String elemento, Lista lista){
        if(acao.equals("INSERIR")){
            lista.inserir(elemento);
        }else if(acao.equals("REMOVER")){
            lista.remover(elemento);
        }else if(acao.equals("BUSCAR")){    
            lista.buscar(elemento);
        }else if(acao.equals("IMPRIMIR")){
            lista.imprimir();
        }
    }
    
    public void acaoFila(String acao, String elemento, Fila fila){
        if(acao.equals("INSERIR")){
            fila.inserir(elemento);
        }else if(acao.equals("REMOVER")){
            fila.remover();
        }else if(acao.equals("BUSCAR")){    
            fila.buscar(elemento);
        }else if(acao.equals("IMPRIMIR")){
            fila.imprimir();
        }
    }
        
    public void acaoPilha(String acao, String elemento, Pilha pilha){
        if(acao.equals("INSERIR")){
            pilha.inserir(elemento);
        }else if(acao.equals("REMOVER")){
            pilha.remover();
        }else if(acao.equals("BUSCAR")){    
            pilha.buscar(elemento);
        }else if(acao.equals("IMPRIMIR")){
            pilha.imprimir();
        }
    }  
    
    public void acaoArvore(String acao, String elemento, Arvore arvore){
        if(acao.equals("INSERIR")){
            arvore.inserir(elemento);
        }else if(acao.equals("REMOVER")){
            arvore.remover(elemento);
        }else if(acao.equals("BUSCAR")){    
            arvore.buscar(elemento);
        }else if(acao.equals("IMPRIMIR")){
            arvore.imprimir();
        }
    }
    
    public String[] toArray(String string){ //linhas
        String[] retorno = string.split("#");
        return retorno;
    }
    
    public String[] acoesInterpretadas(String[] exec){
        String[] acao = new String[exec.length*2];
        String[] aux;
        int auxI = 0;
        for(int i = 1; i < exec.length; i++){ //pula a primeira linha
            if(exec[i].contains(";")){
               aux = exec[i].split(";"); //açao = 0, elemento = 1
               for(int j = 0; j <= 1; j++){
                   acao[auxI] = aux[j];
                   auxI++;
            }
               //se nao tem ; entao é simplesmente função
            }else{
                acao[auxI] = exec[i];
                auxI++;
                acao[auxI] = "null";
                auxI++;
            }
        }
        return acao;
    }
    
    public String acaoElemento(String palavra){
            if(Character.isUpperCase(palavra.charAt(0))){
                //acao
                return palavra;
            }else{
                //elemento //pode ser null
                return palavra;
            }
    }
    
}
