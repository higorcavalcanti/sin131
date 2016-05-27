package minimizarafd;

import java.util.ArrayList;

public class Lista {
    private ElementoLista cabecalho;
    private ArrayList<ElementoLista> conteudo;

    public Lista(ElementoLista cabecalho, ElementoLista conteudo) {
        this.cabecalho = cabecalho;
        this.conteudo = new ArrayList<>();
        this.conteudo.add(conteudo);
    }

    public ElementoLista getCabecalho() {
        return cabecalho;
    }

    public void setCabecalho(ElementoLista cabecalho) {
        this.cabecalho = cabecalho;
    }

    public ArrayList<ElementoLista> getConteudo() {
        return conteudo;
    }

    public void setConteudo(ArrayList<ElementoLista> conteudo) {
        this.conteudo = conteudo;
    }
    
    public void remove(ElementoLista e) {
        this.conteudo.remove(e);
    }
    
    public void marcar(Tabela tabela) {
        for(ElementoLista e : this.getConteudo()) {
            tabela.marcar(e.getEstado1(), e.getEstado2());
        }
    }
    
    public boolean compararCabecalho(ElementoLista other) {
        return (
            this.getCabecalho().getEstado1() == other.getEstado1() &&
            this.getCabecalho().getEstado2() == other.getEstado2()
        );
                
    }
    
    @Override
    public String toString() {
        String t = "===[" + this.getCabecalho() + "]===\n";
        for(ElementoLista e : this.getConteudo()) {
            t += e + "\n";
        }
        return t;
    }
}
