package caixeiroviajante;
import java.util.ArrayList;
/**
 *
 * @author jadyl
 */
public class CaixeiroViajante {
    private int esforcoMin;
    private int sequencia[];
    public static void main(String[] args) {
        int qtdeVertices, peso, vertice, qtdeArestas;
        int matrizAdj[][] = null;
        String caminhos;
        
        //*****************LEITURA*********************
        FileManager fileManager = new FileManager();
        ArrayList<String> text = fileManager.stringReader("./Teste.txt");
        //printando texto da entrada
        System.out.println(text);
        
        qtdeVertices = Integer.parseInt(text.get(0));
        //printando quantidade de vertices
        //System.out.println(qtdeVertices);
        matrizAdj = new int[qtdeVertices][qtdeVertices];
        
        ///*****************CRIANDO MATRIZ DE ADJACÊNCIA*********************
        for (int i = 0; i < qtdeVertices; i++) {
            caminhos = text.get(i+1);
            qtdeArestas = (caminhos.split(";")).length;
            String[] semVertice = caminhos.split(" ");
            
            //esse 'for' vai analisar cada aresta a partir no vértice 'i'
            for (int j = 1; j <= qtdeArestas; j++) {
                String[] semHifen = semVertice[j].split("-");
                String[] semPontoEVirgula = semHifen[1].split(";");
                System.out.println(semPontoEVirgula[0]);

                vertice = Integer.parseInt(semHifen[0]);
                peso = Integer.parseInt(semPontoEVirgula[0]);

                matrizAdj[i][vertice] = peso;
            }
            for (int j = 0; j < qtdeVertices; j++) {
                if (matrizAdj[i][j] == 0){
                    matrizAdj[i][j] = -1;
                }
            }
            
            matrizAdj[i][i] = -1;
        }
        
        System.out.println("*******");
        for (int i = 0; i < qtdeVertices; i++) {
            for (int j = 0; j < qtdeVertices; j++) {
                System.out.println(matrizAdj[i][j]);
            }
            System.out.println("*******");
        }
        
        Vertice aux = new Vertice();
        aux.setQtdeVertices(qtdeVertices);
        aux.setMatrizAdj(matrizAdj);
        aux.setVisitados(aux.reiniciaVisitados()); //coloca false em todos 
        aux.getVisitados()[0] = true;
        aux.iniciaOpcaoCaminho();
        aux.getOpcaoCaminho()[0] = 0;
        aux.setNumVertice(0);
        
        System.out.println("quantidade: " + aux.getQtdeVertices());
        System.out.println("visitados: ");
        for (int i = 0; i < aux.getQtdeVertices(); i++) {
            System.out.println(aux.getVisitados()[i]);
        }
        System.out.println("opcaoCaminho: ");
        for (int i = 0; i < aux.getQtdeVertices(); i++) {
            System.out.println(aux.getOpcaoCaminho()[i]);
        }
        visitaVertice(aux, aux.getNumVertice());
        
    }
    
    //*****************ARVORE*********************
    public static void visitaVertice(Vertice vertice, int i){
        int cont = 0;
        for (int j = 0; j < vertice.getQtdeVertices(); j++) {
           if (vertice.getVisitados()[j] == false){
               cont = 1;
           }
        }
        if (cont == 0 && vertice.getMatrizAdj()[vertice.getNumVertice()][0] != -1){
            System.out.println("CAMINHO VÁLIDO");
            int soma = 0;
            for (int j = 0; j < vertice.getQtdeVertices()-1; j++) {
                System.out.println(soma);
                soma = soma + vertice.getMatrizAdj()[vertice.getOpcaoCaminho()[j]][vertice.getOpcaoCaminho()[j+1]];
            }
            soma = soma + vertice.getMatrizAdj()[vertice.getNumVertice()][0];
            System.out.println(soma);
        }
        
        for (int j = 0; j < vertice.getQtdeVertices(); j++) {
            Vertice novoVertice = new Vertice();
            System.out.println("**********ENTROU***********");
            if (vertice.getMatrizAdj()[i][j] != -1){
                if (!vertice.getVisitados()[j]){ //verifica se eh falso (não visitou)
                    vertice.getVisitados()[j] = true;
                    vertice.adicionaVertice(j);
                    
                    
                    novoVertice.setNumVertice(j);
                    novoVertice.setQtdeVertices(vertice.getQtdeVertices());
                    novoVertice.setMatrizAdj(vertice.copiaMatrizAdj());
                    novoVertice.setVisitados(vertice.copiaVisitados());
                    novoVertice.setOpcaoCaminho(vertice.copiaOpcaoCaminho());
                    novoVertice.setVerticePai(vertice);
                    //***APAGAR***aux.adicionaVertice(novoVertice);
                    System.out.println("**********CHAMOU***********");
                    System.out.println("vertice: " + novoVertice.getNumVertice());
                    
                    visitaVertice(novoVertice, j);
                }
            }
        }
    }
    
    
    
    //****************GETS E SETS*****************
    public void setEsforcoMin(int esforcoMin){
        this.esforcoMin = esforcoMin;
    }
    public int getEsforcoMin(){
        return esforcoMin;
    }
    public void setSequencia(int[] sequencia){
        this.sequencia = sequencia;
    }
    public int[] getSequencia(){
        return sequencia;
    }
}
