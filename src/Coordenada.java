/**
 * Created by frankamente on 26/02/2017.
 */
public class Coordenada {

    private int fila;

    private int columna;

    private int estado;

    private int minasCercas;

    private boolean mina;

    public final int ESTADO_BOCA_ABAJO = 0;

    public final int ESTADO_BOCA_ARRIBA = 1;


    public Coordenada(int fila, int columna) {
        this.columna = columna;
        this.fila = fila;
        mina = false;
        estado = ESTADO_BOCA_ABAJO;
        minasCercas = 0;
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
        return pintarMina() + getMinasCercas() + ", ";
    }

    private String pintarMina() {
        return mina ? "x" : pintarTipo();
    }

    private String pintarTipo() {
        return estado == ESTADO_BOCA_ABAJO ? "-" : estado == ESTADO_BOCA_ARRIBA ? "_" : "" + estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordenada)) return false;

        Coordenada that = (Coordenada) o;

        if (fila != that.fila) return false;
        return columna == that.columna;
    }

    @Override
    public int hashCode() {
        int result = fila;
        result = 31 * result + columna;
        return result;
    }

    public int getMinasCercas() {
        return minasCercas;
    }

    public void setMinasCercas(int minasCercas) {
        this.minasCercas = minasCercas;
    }
}
