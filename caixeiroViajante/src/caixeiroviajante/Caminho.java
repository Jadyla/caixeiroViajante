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
    
    //CONSTRUTOR
    public Caminho(){
        this.esforco = esforco;
        this.caminho = caminho;
    }
    
    
    //*********************MÉTODOS**********************
    public void adicionaCaminho(Caminho novoCaminho){
        listaDeCaminhos.add(novoCaminho);
    }
    
    public void mostraLista(){ //apenas para auxiliar a ver as respostas (debug), nem está sendo chamado no código final
        //System.out.println("**********CAMINHO*************");
            for (int j = 0; j < qtdeVerticesCaminho; j++) {
                System.out.println(getListaDeCaminhos().get(0).caminho[j]); //nesse caso vai mostrar o melhor caminho, mostrando se está certo
            }
    }
    
    public void escolheMelhor(){
        System.out.println("Quantidade de caminhos possíveis: " + getListaDeCaminhos().size());
        int menorEsforco = getListaDeCaminhos().get(0).esforco;
        int[] menorCaminho = getListaDeCaminhos().get(0).caminho;
    
        for (int i = 1; i < getListaDeCaminhos().size(); i++) {
            if (getListaDeCaminhos().get(i).esforco < menorEsforco){
                menorEsforco = getListaDeCaminhos().get(i).esforco;
                menorCaminho = getListaDeCaminhos().get(i).caminho;
            }
            //para PRINTAR todas as opções de caminho, DESCOMENTAR abaixo e comentar linha 32, que printa a quantiadde de caminhos possíveis (apenas para não ficar muito no topo e acabar por não ficar acessível)
            //NÃO APAGAR
            /*System.out.println("*************************");
            System.out.println("CAMINHO " + i);
            System.out.print("caminho: ");
            for (int j = 0; j < qtdeVerticesCaminho; j++) {
                System.out.print(getListaDeCaminhos().get(i).caminho[j] + " ");
            }
            System.out.println(" ");
            System.out.print("esforço: ");
            System.out.print(getListaDeCaminhos().get(i).esforco);
            System.out.println(" ");
            System.out.println(" ");*/
            
        }
        
        //System.out.println(" ");
        //System.out.println(" ");
        System.out.println("Melhor caminho:");
        for (int i = 0; i < qtdeVerticesCaminho; i++) {
            System.out.print(menorCaminho[i] + " ");
        }
        System.out.println(" ");
        System.out.println("Esforço= " + menorEsforco);
    }
    
    
    //*********************MÉTODOS SETs E GETs**********************
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
