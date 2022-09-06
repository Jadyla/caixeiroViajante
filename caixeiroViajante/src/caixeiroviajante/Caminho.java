package caixeiroviajante;

import java.util.ArrayList;
/**
 *
 * @author jadyl
 */
public class Caminho {
    private int qtdeVerticesCaminho;
    private int caminho[];
    private int esforco;
    private ArrayList<Caminho> listaDeCaminhos = new ArrayList();
    Vertice aux = new Vertice();
    
    public Caminho(){
        this.esforco = esforco;
        this.caminho = caminho;
    }
    
    public void adicionaCaminho(){
        Caminho novoCaminho = new Caminho();
        novoCaminho.esforco = esforco;
        novoCaminho.caminho = caminho;
        this.listaDeCaminhos.add(novoCaminho);
    }
    
    public void escolheMelhor(){
        System.out.println(getListaDeCaminhos().size());
        int menorEsforco = getListaDeCaminhos().get(0).esforco;
        int menorCaminho[] = getListaDeCaminhos().get(0).caminho;
        
        for (int i = 1; i < getListaDeCaminhos().size(); i++) {
            if (getListaDeCaminhos().get(i).esforco <= menorEsforco){
                menorEsforco = getListaDeCaminhos().get(i).esforco;
                menorCaminho = getListaDeCaminhos().get(i).caminho;
            }
        }
        
        System.out.println("Melhor caminho:");
        for (int i = 0; i < qtdeVerticesCaminho; i++) {
            System.out.println(menorCaminho[i]);
        }
        System.out.println("Esforço= " + menorEsforco);
    }
    
    //*********************MÉTODOS SETs E GETs*********************
    public ArrayList<Caminho> getListaDeCaminhos(){
        return listaDeCaminhos;
    }
    public void setCaminho(int[] caminho){
        this.caminho = caminho;
    }
    public int[] getCaminho(){
        return caminho;
    }
    public void setEsforco(int esforco){
        this.esforco = esforco;
    }
    public int getEsforco(){
        return esforco;
    }
    public void setQtdeVerticesCaminho(int qtde){
        this.qtdeVerticesCaminho = qtde;
    }
    public int getQtdeVerticesCaminho(){
        return qtdeVerticesCaminho;
    }
}
