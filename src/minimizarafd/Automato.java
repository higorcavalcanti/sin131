package minimizarafd;

import java.util.ArrayList;

public class Automato {
    private String tipo;
    private int qntEstados;
    private int qntTerminais;
    private ArrayList transicoes;
    private int inicial;
    private int qntFinais;
    private ArrayList finais;

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public int getQntEstados() {
        return qntEstados;
    }
    public void setQntEstados(int qntEstados) {
        this.qntEstados = qntEstados;
    }
    public int getQntTerminais() {
        return qntTerminais;
    }
    public void setQntTerminais(int qntTerminais) {
        this.qntTerminais = qntTerminais;
    }
    public ArrayList<Transicao> getTransicoes() {
        return transicoes;
    }
    public void setTransicoes(ArrayList<Transicao> transicoes) {
        this.transicoes = transicoes;
    }
    public int getInicial() {
        return inicial;
    }
    public void setInicial(int inicial) {
        this.inicial = inicial;
    }
    public int getQntFinais() {
        return qntFinais;
    }
    public void setQntFinais(int qntFinais) {
        this.qntFinais = qntFinais;
    }
    public ArrayList<Integer> getFinais() {
        return finais;
    }
    public void setFinais(ArrayList<Integer> finais) {
        this.finais = finais;
    }   
    
    public Transicao getTransicao(int origem, int terminal) {
        for( Transicao t : this.getTransicoes() ) {
            if(t.getOrigem() == origem && t.getTerminal() == terminal) {
                return t;
            }
        }
        return new Transicao(origem, terminal, -1);
    }
    
    public void juntarIguais(Tabela tabela) {
        for(ElementoLista e : tabela.getIguais()) {
            for(Transicao t : this.getTransicoes()) {
                if(t.getDestino() == e.getEstado2()) {
                    t.setDestino(e.getEstado1());
                }
            }
            this.setQntFinais( this.getQntFinais() - 1 );
        }
    }
    
    public void minimizar() {
        //PASSO 1 = Fazer a tabela
        Tabela tabela = new Tabela(this, this.qntEstados);
        
        //PASSO 2 = Marcar trivialmente equivalentes
        tabela.marcarTrivialmenteEquivalentes();
        
        System.out.println(tabela);
        
        //PASSO 3 = Marcar os equivalentes
        tabela.marcarEquivalentes();
        System.out.println(tabela);      
        
        //PASSO 4 = Não marcados são equivalentes
        this.juntarIguais(tabela);
    }
}
