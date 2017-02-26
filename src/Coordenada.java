/**
 * Created by frankamente on 26/02/2017.
 */
public class Coordenada {

    private int fila;

    private int columna;

    private int estado;

    private boolean mina;

    public final int ESTADO_BOCA_ABAJO = 0;

    public final int ESTADO_BOCA_ARRIBA = 1;


    public Coordenada(int fila, int columna) {
        this.columna = columna;
        this.fila = fila;
        mina = false;
        estado = ESTADO_BOCA_ABAJO;
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

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
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
        return estado == ESTADO_BOCA_ABAJO ? "-" : estado == ESTADO_BOCA_ARRIBA ? "_" : "" + estado;
    }
}
