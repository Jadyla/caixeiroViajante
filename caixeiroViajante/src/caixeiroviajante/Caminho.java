package caixeiroviajante;

import java.util.ArrayList;
/**
 *
 * @author jadyl
 */
public class Caminho {
    private int caminho[];
    private int esforco;
    private ArrayList<Caminho> listaDeCaminhos;
    
    public Caminho(){
        Vertice aux = new Vertice();
        this.esforco = esforco;
        this.caminho = new int[aux.getQtdeVertices()];
    }
    
    public void adicionaCaminho(Caminho novoCaminho){
        this.listaDeCaminhos.add(novoCaminho);
    }
    
    public void escolheMelhor(){
        Vertice aux = new Vertice();
        int menorEsforco = getListaDeCaminhos().get(0).esforco;
        int menorCaminho[] = new int[aux.getQtdeVertices()];
        menorCaminho = getListaDeCaminhos().get(0).caminho;
        
        for (int i = 1; i < getListaDeCaminhos().size(); i++) {
            if (getListaDeCaminhos().get(i).esforco <= menorEsforco){
                menorEsforco = getListaDeCaminhos().get(i).esforco;
                menorCaminho = getListaDeCaminhos().get(i).caminho;
            }
        }
        
        System.out.println("Melhor caminho:");
        for (int i = 0; i < aux.getQtdeVertices(); i++) {
            System.out.println(menorCaminho[i]);
        }
        System.out.println("Esforço= " + menorEsforco);
    }
    
    //*********************MÉTODOS SETs E GETs*********************
    public ArrayList<Caminho> getListaDeCaminhos(){
        return listaDeCaminhos;
    }
    public void setCaminho(int tam){
        this.caminho = new int[tam];
    }
    public int[] getCaminho(){
        return caminho;
    }
}
