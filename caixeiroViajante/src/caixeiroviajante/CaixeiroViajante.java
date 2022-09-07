package caixeiroviajante;
import java.util.ArrayList;
/**
 *
 * @author jadyl
 */
public class CaixeiroViajante {
    public static void main(String[] args) {
        int qtdeVertices, peso, vertice, qtdeArestas;
        int matrizAdj[][] = null;
        String caminhos;
        
        //*****************LEITURA*********************
        FileManager fileManager = new FileManager();
        ArrayList<String> text = fileManager.stringReader("./Teste_1.txt");
        //printando texto da entrada
        //System.out.println(text);
        
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
                //System.out.println(semPontoEVirgula[0]);

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
        
        System.out.println("****MATRIZ****");
        for (int i = 0; i < qtdeVertices; i++) {
            for (int j = 0; j < qtdeVertices; j++) {
                System.out.print(matrizAdj[i][j] + "    ");
            }
            System.out.println("  ");
        }
        System.out.println("*************");
        System.out.println(" ");
        
        
        //************INICIANDO VÉRTICE RAIZ**************
        Vertice aux = new Vertice();
        Caminho aux2 = new Caminho();
        
        aux.setQtdeVertices(qtdeVertices);
        aux.setMatrizAdj(matrizAdj);
        aux.setVisitados(aux.reiniciaVisitados()); //coloca 'false' em todos 
        aux.getVisitados()[0] = true;
        aux.iniciaOpcaoCaminho();
        aux.getOpcaoCaminho()[0] = 0;
        aux.setNumVertice(0);
        
        aux2.setQtdeVerticesCaminho(qtdeVertices);
        
        
        //************CHAMADA FUNÇÃO RECURSIVA**************
        visitaVertice(aux, aux.getNumVertice(), aux2);
        
        
        //************MÉTODO PARA ANALISAR MELHOR CAMINHO************** (saída será printada lá)
        aux2.escolheMelhor();
    }
    
    
    //*****************ARVORE********************* (função recursiva)
    public static void visitaVertice(Vertice vertice, int i, Caminho aux2){
        
        int cont = 0;
        for (int j = 0; j < vertice.getQtdeVertices(); j++) {
           if (vertice.getVisitados()[j] == false){
               cont = 1;
           }
        }
        if (cont == 0 && vertice.getMatrizAdj()[vertice.getNumVertice()][0] != -1){ //verificando se volta para o início
            int soma = 0;
            for (int j = 0; j < vertice.getQtdeVertices()-1; j++) {
                //System.out.println(soma);
                soma = soma + vertice.getMatrizAdj()[vertice.getOpcaoCaminho()[j]][vertice.getOpcaoCaminho()[j+1]];
            }
            soma = soma + vertice.getMatrizAdj()[vertice.getNumVertice()][0];
            //System.out.println(soma);
            Caminho aux3 = new Caminho();
            aux3.setQtdeVerticesCaminho(vertice.getQtdeVertices());
            aux3.setEsforco(soma);
            aux3.setCaminho(vertice.getOpcaoCaminho());
            aux2.adicionaCaminho(aux3);
            //aux2.escolheMelhor();
        }
        
        for (int j = 0; j < vertice.getQtdeVertices(); j++) {
            
            if (vertice.getMatrizAdj()[i][j] != -1){
                if (!vertice.getVisitados()[j]){ //verifica se eh falso (não visitou)
                    Vertice novoVertice = new Vertice();

                    //COMEÇANDO A ALTERAR
                    novoVertice.setNumVertice(j);
                    novoVertice.setQtdeVertices(vertice.getQtdeVertices());
                    novoVertice.setMatrizAdj(vertice.copiaMatrizAdj());
                    
                    novoVertice.setVisitados(vertice.copiaVisitados());
                    novoVertice.getVisitados()[j] = true;
                    
                    novoVertice.setOpcaoCaminho(vertice.copiaOpcaoCaminho());
                    novoVertice.adicionaVertice(j);
                        
                    novoVertice.setVerticePai(vertice);

                    visitaVertice(novoVertice, j, aux2);
                }
            }
        }
    }
}
