package caixeiroviajante;

import java.util.ArrayList;

/**
 *
 * @author jadyl
 */
public class Vertice {
    private int qtdeVertices;
    private ArrayList<Vertice> vertices;
    private int matrizAdj[][];
    private Vertice verticePai;
    
    //CONSTRUTOR
    public Vertice(){
        this.vertices = new ArrayList();
    }
    
    //MÉTODOS
    public void setQtdeVertices(int qtdeVertices){
        this.qtdeVertices = qtdeVertices;
    }
    public int getQtdeVertices(){
        return qtdeVertices;
    }
    public void setMatrizAdj(int[][] matrizAdj){
        this.matrizAdj = matrizAdj;
    }
    public int[][] getMatrizAdj(){
        return matrizAdj;
    }
    public void adicionaVertice(Vertice novoVertice){
        this.vertices.add(novoVertice);
    }
}
