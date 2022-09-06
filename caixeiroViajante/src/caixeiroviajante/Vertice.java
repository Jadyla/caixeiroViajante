package caixeiroviajante;

import java.util.ArrayList;

/**
 *
 * @author jadyl
 */
public class Vertice {
    private int qtdeVertices;
    //***APAGAR***private ArrayList<Vertice> vertices;
    private int matrizAdj[][];
    private Vertice verticePai;
    private boolean visitados[];
    private int opcaoCaminho[];
    private int numVertice;
    
    //CONSTRUTOR
    public Vertice(){
        this.visitados = visitados;
        this.opcaoCaminho = opcaoCaminho;
    }
    
    
    //*********************MÉTODOS*********************
    //***APAGAR***public void adicionaVertice(Vertice novoVertice){
    //***APAGAR***    this.vertices.add(novoVertice);
    //***APAGAR***}
    public boolean[] copiaVisitados(){
        boolean novoVisitados[] = new boolean[qtdeVertices];
        for (int i = 0; i < qtdeVertices; i++) {
            novoVisitados[i] = visitados[i];
        }
        return novoVisitados;
    }
    public boolean[] reiniciaVisitados(){
        boolean visitado[] = new boolean[qtdeVertices];
        for (int i = 0; i < qtdeVertices; i++) {
            visitado[i] = false;
        }
        return visitado;
    }
    public int[] copiaOpcaoCaminho(){
        int novoCaminho[] = new int[qtdeVertices];
        for (int i = 0; i < qtdeVertices; i++) {
            novoCaminho[i] = opcaoCaminho[i];
        }
        return novoCaminho;
    }
    public void iniciaOpcaoCaminho(){
        this.opcaoCaminho = new int[qtdeVertices];
        for (int i = 0; i < qtdeVertices; i++) {
            this.opcaoCaminho[i] = -1;
        }
    }
    public void adicionaVertice(int numVertice){ //adiciona no opcao caminho
        for (int i = 0; i < qtdeVertices; i++) {
            if (opcaoCaminho[i] == -1){
                opcaoCaminho[i] = numVertice;
                break;
            }
        }
    }
    public int[][] copiaMatrizAdj(){ //funcao para copiar a matriz para o proximo filho, e depois acrescentar a proxima jogada
        int matrizNova[][] = new int[qtdeVertices][qtdeVertices];
        for (int i = 0; i < qtdeVertices; i++) {
            for (int j = 0; j < qtdeVertices; j++) {
                matrizNova[i][j] = this.matrizAdj[i][j];
            }
        }
        return matrizNova;
    }
    
    
    //****************MÉTODOS SETs E GETs**************
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
    public void setVisitados(boolean[] visitados){
        this.visitados = visitados;
    }
    public boolean[] getVisitados(){
        return visitados;
    }
    public void setVerticePai(Vertice verticePai){
        this.verticePai = verticePai;
    }
    public Vertice getVerticePai (){
        return verticePai;
    }
    public void setOpcaoCaminho(int[] opcaoCaminho){
        this.opcaoCaminho = opcaoCaminho;
    }
    public int[] getOpcaoCaminho(){
        return opcaoCaminho;
    }
    public void setNumVertice(int numVertice){
        this.numVertice = numVertice;
    }
    public int getNumVertice(){
        return numVertice;
    }
}
