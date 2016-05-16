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
    
    public boolean compararCabecalho(ElementoLista other) {
        return (
            this.getCabecalho().getEstado1() == other.getEstado1() &&
            this.getCabecalho().getEstado2() == other.getEstado2()
        );
                
    }
}
