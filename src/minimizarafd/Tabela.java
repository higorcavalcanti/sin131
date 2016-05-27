package minimizarafd;

import java.util.ArrayList;

public class Tabela {
    
    private Automato automato;
    private int estados;
    private int tabela[][];
    private Listas listas;

    public Tabela(Automato automato, int estados) {
        this.automato = automato;
        this.estados = estados;
        this.tabela = new int[estados][estados];
        this.listas = new Listas();
    }
    
    public void marcar(int linha, int coluna) {
        this.tabela[linha][coluna] = 1;
        //this.tabela[coluna][linha] = 1;
        this.listas.marcar( this, new ElementoLista(linha, coluna) );
        //this.listas.marcar( this, new ElementoLista(coluna, linha) );
    }
    
    public boolean isMarcado(int linha, int coluna) {
        return (this.tabela[linha][coluna] == 1);
    }
    
    public boolean isFinal(int estado) {
        for( int i : automato.getFinais() ) {
            if(i == estado) {
                return true;
            }
        }
        return false;
    }
    
    public boolean trivialmenteNaoEquivalentes(int linha, int coluna) {
        if( isFinal(linha) && !isFinal(coluna) )
            return true;
        
        if( !isFinal(linha) && isFinal(coluna) )
            return true;
        
        return false;
    }
    
    public void marcarTrivialmenteEquivalentes() {
        for(int i = 0; i < this.estados; i++) {
            for(int j = 0; j < this.estados; j++) {
                /*
                if(i == j) {
                    //Termina a linha, pois a tabela é simetrica, não precisa agir em cima tbm
                    break;
                }
                */
                if( trivialmenteNaoEquivalentes(i, j) ) {
                    marcar(i, j);
                }
            }
        }
    }
    
    
    public void marcarEquivalentes() {
        for(int i = 0; i < this.estados; i++) {
            for(int j = 0; j < this.estados; j++) {
                if(i == j) break;
                //if(i == j) continue;
                if( isMarcado(i, j) ) continue;
                
                this.compararTransicoes(i, j);
                System.out.println(this);
            }
        }        
    }
    
    public void compararTransicoes( int e1, int e2 ) {
        for( int j = 0; j < this.automato.getQntTerminais(); j++ ) {
            Transicao t1 = this.automato.getTransicao(e1, j);
            Transicao t2 = this.automato.getTransicao(e2, j);
            
            System.out.println("S(q" + e1 + ", " + j + ") = " + t1.getDestino());
            System.out.println("S(q" + e2 + ", " + j + ") = " + t2.getDestino());
            
            //Destino igual, não marcar
            if(t1.destinoIgual(t2)) {
                System.out.println(t1.getDestino() + " e " + t2.getDestino() + " sao iguais!\n");
            }
            else //Destino diferente
            {
                System.out.print(t1.getDestino() + " e " + t2.getDestino() + " sao diferentes!");
                if( !isMarcado(t1.getDestino(), t2.getDestino()) )  //Se não estiverem marcados
                {
                    //t1 e t2 entram na lista encabeçada por seus destinos
                    this.listas.add( new ElementoLista(t1.getDestino(), t2.getDestino()), new ElementoLista(e1, e2) );
                    System.out.println(" e nao marcados (vai pra lista)");
                }
                else //Se estiverem marcados
                {
                    System.out.println(" e marcados (marca a lista)");
                    marcar(e1, e2);
                }
            }
        }
    }
    
    public ArrayList<ElementoLista> getIguais() {
        ArrayList<ElementoLista> iguais = new ArrayList<>();
        for(int i = 0; i < this.estados; i++) {
            for(int j = 0; j < this.estados; j++) {
                if(i == j) break;
                if(this.tabela[i][j] == 0) {
                    iguais.add( new ElementoLista(i, j) );
                }
            }
        }
        return iguais;
    }
    
    
    @Override
    public String toString() {
        
        String t = new String();
        t = "Tabela: \n";
        for(int i = 0; i < this.estados; i++) {
            t += "q" + i + ": ";
            for(int j = 0; j < this.estados; j++) {
                if(i == j) break;
                t += this.tabela[i][j] + "  ";
            }
            t += "\n";
        }
        t += "   ";
        for(int i = 0; i < this.estados; i++) 
            t += "q" + i + " ";
        
        t += "\n";
        t += this.listas;
        
        return t;
    }
}
