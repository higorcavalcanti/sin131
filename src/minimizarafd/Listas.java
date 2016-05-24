package minimizarafd;

import java.util.ArrayList;

public class Listas {
    private ArrayList<Lista> lista;

    public Listas() {
        this.lista = new ArrayList<>();
    }    
    
    public void add(ElementoLista cabecalho, ElementoLista conteudo) {
        for(Lista l : this.lista) {
            if(l.compararCabecalho(cabecalho)) {
                l.getConteudo().add(conteudo);
                return;
            } 
        }
        this.lista.add( new Lista(cabecalho, conteudo) );
    }
    
    public void marcar( Tabela tabela, ElementoLista cabecalho ) {
        for(Lista l : this.lista) {
            if(l.compararCabecalho(cabecalho)) {
                tabela.marcar(l.getCabecalho().getEstado1(), l.getCabecalho().getEstado2());
            }
        }
    }
}
