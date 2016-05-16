package minimizarafd;

public class Transicao {
    
    private int origem;
    private int terminal;
    private int destino;

    public Transicao(int origem, int terminal, int destino) {
        this.origem = origem;
        this.terminal = terminal;
        this.destino = destino;
    }

    public int getOrigem() {
        return origem;
    }

    public void setOrigem(int origem) {
        this.origem = origem;
    }

    public int getTerminal() {
        return terminal;
    }

    public void setTerminal(int terminal) {
        this.terminal = terminal;
    }

    public int getDestino() {
        return destino;
    }

    public void setDestino(int destino) {
        this.destino = destino;
    }
    
    
    public boolean destinoIgual( Transicao other ) {
        return ( 
            other.getDestino() == this.getDestino()
        );
    }
}
