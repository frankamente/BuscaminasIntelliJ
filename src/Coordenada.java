/**
 * Created by frankamente on 26/02/2017.
 */
public class Coordenada {

    private int fila;

    private int columna;

    private int tipo;

    private boolean mina;

    private final int TIPO_BOCA_ABAJO = 0;

    private final int TIPO_BOCA_ARRIBA = 1;


    public Coordenada(int fila, int columna) {
        this.columna = columna;
        this.fila = fila;
        mina = false;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public boolean isMina() {
        return mina;
    }

    public void setMina(boolean mina) {
        this.mina = mina;
    }

    public void ponerMina() {
        this.setMina(true);
    }

    @Override
    public String toString() {
        return pintarMina() + ", ";
    }

    private String pintarMina() {
        return mina ? "x" : pintarTipo();
    }

    private String pintarTipo() {
        return tipo == TIPO_BOCA_ABAJO ? "-" : "0";
    }
}
