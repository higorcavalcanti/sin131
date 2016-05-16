package minimizarafd;

public class Estado {
    
    private boolean estadoFinal;

    public Estado(boolean estadoFinal) {
        this.estadoFinal = estadoFinal;
    }

    public boolean isEstadoFinal() {
        return estadoFinal;
    }

    public void setEstadoFinal(boolean estadoFinal) {
        this.estadoFinal = estadoFinal;
    }
    
    
}
