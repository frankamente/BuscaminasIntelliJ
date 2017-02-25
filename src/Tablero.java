import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by frankamente on 25/02/2017.
 */
public class Tablero {

    public int MAXIMO = 0;

    public int MINIMO = 0;

    public int numeroMinas = 0;
    private int[][] coordenadas;

    public Tablero(int dimensionTablero) {

        coordenadas = new int[dimensionTablero][dimensionTablero];
        MAXIMO = dimensionTablero - 1;
        numeroMinas = dimensionTablero;

    }

    public void inicializarTablero() {
        int[][] coordenada = new int[][];
        int i = 0;
        while (i < numeroMinas) {
            coordenada = ((int) (Math.random() * (MAXIMO - MINIMO + 1) + MINIMO), (int) (Math.random() * (MAXIMO - MINIMO + 1) + MINIMO))
            ;
            if (!contieneMina(coordenada)) {
                coordenada.ponerMina();
                i++;
            }
        }

    }

    public void desvelarCelda(int[][] coordenada) {

    }

    public boolean contieneMina(int[][] coordenada) {
        return false;
    }

    public void actualizarTablero(int[][] coordenada) {

    }

    public void ponerMina(int fila, int columna) {
        coordenadas[fila][columna] = 1;
    }

    public void mostrarTablero() {

    }

    public int getCeldasDisponibles() {
        return 0;
    }


}
