import java.util.*;

/**
 * Created by frankamente on 25/02/2017.
 */
public class Tablero {

    public int MAXIMO = 0;

    public int MINIMO = 0;

    public int numeroMinas = 0;

    public int numeroFilas;

    public int numeroColumnas;

    private ArrayList<Coordenada> coordenadas;

    public Tablero(int dimensionTablero) {

        coordenadas = new ArrayList();
        MAXIMO = dimensionTablero - 1;
        numeroMinas = dimensionTablero;
        numeroColumnas = dimensionTablero;
        numeroFilas = dimensionTablero;


    }

    public void inicializarTablero() {
        for (int i = 0; i < numeroFilas; i++) {
            for (int j = 0; j < numeroColumnas; j++) {
                this.getCoordenadas().add(new Coordenada(i, j));
            }
        }
        int i = 0;
        int fila;
        int columna;
        while (i < numeroMinas) {
            fila = (int) (Math.random() * (MAXIMO - MINIMO + 1) + MINIMO);
            columna = (int) (Math.random() * (MAXIMO - MINIMO + 1) + MINIMO);
            for (Coordenada coordenada : this.getCoordenadas()) {
                if (coordenada.getFila() == fila && coordenada.getColumna() == columna && !coordenada.isMina()) {
                    coordenada.ponerMina();
                    i++;
                }
            }

        }

    }

    public void desvelarCelda(Coordenada coordenada) {

    }

    public boolean contieneMina(Coordenada coordenada) {
        return false;
    }

    public void actualizarTablero(Coordenada coordenada) {

    }

    public void ponerMina(int fila, int columna) {


    }

    public void mostrarTablero() {
        int fila = 0;
        int columna = 0;
        for (Coordenada coordenada : this.getCoordenadas()) {
            if (coordenada.getColumna() != (numeroColumnas - 1)) {
                System.out.print(coordenada);
            } else {
                System.out.println(coordenada);
            }
        }
    }

    public int getCeldasDisponibles() {
        return 0;
    }

    public ArrayList<Coordenada> getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(ArrayList<Coordenada> coordenadas) {
        this.coordenadas = coordenadas;
    }
}
