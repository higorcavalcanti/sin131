package minimizarafd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class IO {
    
    public static Automato lerAutomato() {
        return IO.lerAutomato(null);
    }
    
    public static Automato lerAutomato(String file) {
        try {
            BufferedReader in = new BufferedReader(new FileReader( file ));
        }
        catch(Exception e) {
            
        }
        
        ArrayList<Transicao> transicoes = new ArrayList();
        transicoes.add( new Transicao(0, 0, 1) );
        transicoes.add( new Transicao(0, 1, 2) );
        transicoes.add( new Transicao(1, 0, 3) );
        transicoes.add( new Transicao(1, 1, 2) );
        transicoes.add( new Transicao(2, 0, 1) );
        transicoes.add( new Transicao(2, 1, 3) );
        transicoes.add( new Transicao(3, 0, 3) );
        transicoes.add( new Transicao(3, 1, -1) );
        
        ArrayList<Integer> finais = new ArrayList();
        finais.add(3);
        
        //return new Automato();
        Automato a = new Automato();
        a.setTipo("AFD");
        a.setQntEstados(4);
        a.setQntTerminais(2);
        a.setTransicoes( transicoes );
        a.setInicial(0);
        a.setQntFinais(1);
        a.setFinais( finais );
        
        return a;
    }
    
    
    public static Automato lerAutomato2(String file) {
        try {
            BufferedReader in = new BufferedReader(new FileReader( file ));
        }
        catch(Exception e) {
            
        }
        
        ArrayList<Transicao> transicoes = new ArrayList();
        transicoes.add( new Transicao(0, 0, 2) );
        transicoes.add( new Transicao(0, 1, 1) );
        transicoes.add( new Transicao(1, 0, 1) );
        transicoes.add( new Transicao(1, 1, 0) );
        transicoes.add( new Transicao(2, 0, 4) );
        transicoes.add( new Transicao(2, 1, 5) );
        transicoes.add( new Transicao(3, 0, 5) );
        transicoes.add( new Transicao(3, 1, 4) );
        transicoes.add( new Transicao(4, 0, 3) );
        transicoes.add( new Transicao(4, 1, 2) );
        transicoes.add( new Transicao(5, 0, 2) );
        transicoes.add( new Transicao(5, 1, 3) );
        
        ArrayList<Integer> finais = new ArrayList();
        finais.add(0);
        finais.add(4);
        finais.add(5);
        
        //return new Automato();
        Automato a = new Automato();
        a.setTipo("AFD");
        a.setQntEstados(6);
        a.setQntTerminais(2);
        a.setTransicoes( transicoes );
        a.setInicial(0);
        a.setQntFinais(3);
        a.setFinais( finais );
        
        return a;
    }
    
}
