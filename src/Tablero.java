import java.util.*;

public class Tablero {

    public int MINIMO;

    public int numeroMinas;

    public int numeroFilas;

    public int numeroColumnas;

    private ArrayList<Coordenada> coordenadas;

    public Tablero(int numeroFilas, int numeroColumnas) {

        coordenadas = new ArrayList();
        numeroMinas = numeroColumnas - 1;
        this.numeroColumnas = numeroColumnas;
        this.numeroFilas = numeroFilas;


    }

    void inicializarTablero() {
        for (int i = 0; i < numeroFilas; i++) {
            for (int j = 0; j < numeroColumnas; j++) {
                this.getCoordenadas().add(new Coordenada(i, j));
            }
        }
        int i = 0;
        int fila;
        int columna;
        while (i < numeroMinas) {
            fila = (int) (Math.random() * (numeroFilas - MINIMO + 1) + MINIMO);
            columna = (int) (Math.random() * (numeroColumnas - MINIMO + 1) + MINIMO);
            for (Coordenada coordenada : this.getCoordenadas()) {
                if (coordenada.getFila() == fila && coordenada.getColumna() == columna && !coordenada.isMina()) {
                    ponerMina(coordenada);
                    i++;
                }
            }

        }

    }

    private void cambiarEstado(Coordenada coordenada, int estado) {

        for (Coordenada coordenada1 : this.getCoordenadas()) {
            if (coordenada1.equals(coordenada)) {
                coordenada1.setEstado(estado);

            }
        }

    }

    boolean contieneMina(Coordenada coordenada) {
        for (Coordenada coordenada1 : getCoordenadas()) {
            if (coordenada1.equals(coordenada)) {
                return coordenada1.isMina();
            }
        }
        return false;

    }

    void actualizarTablero(Coordenada coordenada) {
        for (Coordenada coordenada1 : getCoordenadas()) {
            if (coordenada1.equals(coordenada)) {
                if (coordenada1.getMinasCercas() == 0 && !coordenada1.isMina()) {
                    coordenada1.setEstado(coordenada1.ESTADO_BOCA_ARRIBA);
                } else {
                    cambiarEstado(coordenada1, 999);
                }
            }
            if (coordenada1.getFila() == coordenada.getFila() && coordenada1.getColumna() == coordenada.getColumna() - 1) {
                if (coordenada1.getMinasCercas() == 0 && !coordenada1.isMina()) {
                    coordenada1.setEstado(coordenada1.ESTADO_BOCA_ARRIBA);
                } else {
                    cambiarEstado(coordenada1, 999);
                }
            }
            if (coordenada1.getFila() == coordenada.getFila() && coordenada1.getColumna() == coordenada.getColumna() + 1) {
                if (coordenada1.getMinasCercas() == 0 && !coordenada1.isMina()) {
                    coordenada1.setEstado(coordenada1.ESTADO_BOCA_ARRIBA);
                } else {
                    cambiarEstado(coordenada1, 999);
                }
            }
            if (coordenada1.getFila() == coordenada.getFila() - 1 && coordenada1.getColumna() == coordenada.getColumna() - 1) {
                if (coordenada1.getMinasCercas() == 0 && !coordenada1.isMina()) {
                    coordenada1.setEstado(coordenada1.ESTADO_BOCA_ARRIBA);
                } else {
                    cambiarEstado(coordenada1, 999);
                }
            }

            if (coordenada1.getFila() == coordenada.getFila() - 1 && coordenada1.getColumna() == coordenada.getColumna()) {
                if (coordenada1.getMinasCercas() == 0 && !coordenada1.isMina()) {
                    coordenada1.setEstado(coordenada1.ESTADO_BOCA_ARRIBA);
                } else {
                    cambiarEstado(coordenada1, 999);
                }
            }


            if (coordenada1.getFila() == coordenada.getFila() - 1 && coordenada1.getColumna() == coordenada.getColumna() + 1) {
                if (coordenada1.getMinasCercas() == 0 && !coordenada1.isMina()) {
                    coordenada1.setEstado(coordenada1.ESTADO_BOCA_ARRIBA);
                } else {
                    cambiarEstado(coordenada1, 999);
                }
            }

            if (!coordenada1.equals(coordenada)) {
                if (coordenada1.getFila() == coordenada.getFila() + 1 && coordenada1.getColumna() == coordenada.getColumna() - 1) {
                    if (coordenada1.getMinasCercas() == 0 && !coordenada1.isMina()) {
                        coordenada1.setEstado(coordenada1.ESTADO_BOCA_ARRIBA);
                    } else {
                        cambiarEstado(coordenada1, 999);
                    }
                }
            }
            if (coordenada1.getFila() == coordenada.getFila() + 1 && coordenada1.getColumna() == coordenada.getColumna()) {
                if (coordenada1.getMinasCercas() == 0 && !coordenada1.isMina()) {
                    coordenada1.setEstado(coordenada1.ESTADO_BOCA_ARRIBA);
                } else {
                    cambiarEstado(coordenada1, 999);
                }
            }

            if (coordenada1.getFila() == coordenada.getFila() + 1 && coordenada1.getColumna() == coordenada.getColumna() + 1) {
                if (coordenada1.getMinasCercas() == 0 && !coordenada1.isMina()) {
                    coordenada1.setEstado(coordenada1.ESTADO_BOCA_ARRIBA);
                } else {
                    cambiarEstado(coordenada1, 999);
                }
            }

        }
    }

    public ArrayList<Coordenada> coordenadasEnDiagonalDescendienteHaciaDerecha(Coordenada coordenada) {
        ArrayList<Coordenada> coordenadasEnDiagonalDescendienteHaciaDerecha = new ArrayList();
        for (int i = 0; i < this.numeroFilas; i++) {
            for (Coordenada coordenada1 : getCoordenadas()) {
                if (coordenada1.getFila() == (coordenada.getFila() + i) && coordenada1.getColumna() == (coordenada.getColumna() + i)) {
                    coordenadasEnDiagonalDescendienteHaciaDerecha.add(coordenada1);
                }
            }

        }

        return coordenadasEnDiagonalDescendienteHaciaDerecha;
    }

    public ArrayList<Coordenada> coordenadasEnDiagonalDescendienteHaciaIzquierda(Coordenada coordenada) {
        ArrayList<Coordenada> coordenadasEnDiagonalDescendienteHaciaAbajo = new ArrayList();
        for (int i = 0; i < this.numeroFilas; i++) {
            for (Coordenada coordenada1 : getCoordenadas()) {
                if (coordenada1.getFila() == (coordenada.getFila() + i) && coordenada1.getColumna() == (coordenada.getColumna() - i)) {
                    coordenadasEnDiagonalDescendienteHaciaAbajo.add(coordenada1);
                }
            }

        }

        return coordenadasEnDiagonalDescendienteHaciaAbajo;
    }

    public ArrayList<Coordenada> coordenadasEnDiagonalAscendenteHaciaIzquierda(Coordenada coordenada) {
        ArrayList<Coordenada> coordenadasEnDiagonalAscendenteHaciaIzquierda = new ArrayList();
        for (int i = 0; i < this.numeroFilas; i++) {
            for (Coordenada coordenada1 : getCoordenadas()) {
                if (coordenada1.getFila() == (coordenada.getFila() - i) && coordenada1.getColumna() == (coordenada.getColumna() - i)) {
                    coordenadasEnDiagonalAscendenteHaciaIzquierda.add(coordenada1);
                }
            }

        }

        return coordenadasEnDiagonalAscendenteHaciaIzquierda;
    }

    public ArrayList<Coordenada> coordenadasEnDiagonalAscendenteHaciaDerecha(Coordenada coordenada) {
        ArrayList<Coordenada> coordenadasEnDiagonalAscendenteHaciaDerecha = new ArrayList();
        for (int i = 0; i < this.numeroFilas; i++) {
            for (Coordenada coordenada1 : getCoordenadas()) {
                if (coordenada1.getFila() == (coordenada.getFila() - i) && coordenada1.getColumna() == (coordenada.getColumna() + i)) {
                    coordenadasEnDiagonalAscendenteHaciaDerecha.add(coordenada1);
                }
            }

        }

        return coordenadasEnDiagonalAscendenteHaciaDerecha;
    }

    public ArrayList<Coordenada> coordenadasEnMismaFila(Coordenada coordenada) {
        ArrayList<Coordenada> coordenadasEnMismaFila = new ArrayList();
        for (Coordenada coordenada1 : getCoordenadas()) {
            if (coordenada1.getFila() == coordenada.getFila()) {
                coordenadasEnMismaFila.add(coordenada1);
            }
        }
        return coordenadasEnMismaFila;
    }

    public ArrayList<Coordenada> coordenadasEnMismaColumna(Coordenada coordenada) {
        ArrayList<Coordenada> coordenadasEnMismaColumna = new ArrayList();
        for (Coordenada coordenada1 : getCoordenadas()) {
            if (!coordenada1.equals(coordenada) && coordenada1.getColumna() == coordenada.getColumna()) {
                coordenadasEnMismaColumna.add(coordenada1);
            }
        }
        return coordenadasEnMismaColumna;
    }


    public void ponerMina(Coordenada coordenada) {
        coordenada.ponerMina();
        for (Coordenada coordenada1 : this.getCoordenadas()) {
            if (!coordenada.equals(coordenada1) && !coordenada1.isMina()) {
                //Numero arriba izquierda de la mina
                if (coordenada1.getFila() == (coordenada.getFila() - 1)
                        && coordenada1.getColumna() == (coordenada.getColumna() - 1)) {
                    coordenada1.setMinasCercas(coordenada1.getMinasCercas() + 1);
                }
                //Numero arriba centro de la mina
                if (coordenada1.getFila() == (coordenada.getFila() - 1)
                        && coordenada1.getColumna() == (coordenada.getColumna())) {
                    coordenada1.setMinasCercas(coordenada1.getMinasCercas() + 1);
                }
                //Numero arriba derecha de la mina
                if (coordenada1.getFila() == (coordenada.getFila() - 1)
                        && coordenada1.getColumna() == (coordenada.getColumna() + 1)) {
                    coordenada1.setMinasCercas(coordenada1.getMinasCercas() + 1);
                }
                //Numero misma fila a la izquierda de la mina
                if (coordenada1.getFila() == (coordenada.getFila())
                        && coordenada1.getColumna() == (coordenada.getColumna() - 1)) {
                    coordenada1.setMinasCercas(coordenada1.getMinasCercas() + 1);
                }
                //Numero misma fila a la derecha de la mina
                if (coordenada1.getFila() == (coordenada.getFila())
                        && coordenada1.getColumna() == (coordenada.getColumna() + 1)) {
                    coordenada1.setMinasCercas(coordenada1.getMinasCercas() + 1);
                }
                //Numero debajo a la izquierda de la mina
                if (coordenada1.getFila() == (coordenada.getFila() + 1)
                        && coordenada1.getColumna() == (coordenada.getColumna() - 1)) {
                    coordenada1.setMinasCercas(coordenada1.getMinasCercas() + 1);
                }
                //Numero debajo en el centro de la mina
                if (coordenada1.getFila() == (coordenada.getFila() + 1)
                        && coordenada1.getColumna() == (coordenada.getColumna())) {
                    coordenada1.setMinasCercas(coordenada1.getMinasCercas() + 1);
                }
                //Numero debajo a la derecha de la mina
                if (coordenada1.getFila() == (coordenada.getFila() + 1)
                        && coordenada1.getColumna() == (coordenada.getColumna() + 1)) {
                    coordenada1.setMinasCercas(coordenada1.getMinasCercas() + 1);
                }
            }
        }
    }

    public void mostrarTablero() {
        int fila = 0;
        int columna = 0;
        for (int i = 1; i <= this.numeroColumnas; i++) {
            System.out.print("\t" + "\t" + i);
        }

        System.out.println();
        System.out.println();
        for (Coordenada coordenada : this.getCoordenadas()) {
            if (coordenada.getColumna() == 0) {
                System.out.print(coordenada.getFila() + 1);
            }
            if (coordenada.getColumna() != (numeroColumnas - 1)) {
                System.out.print("\t" + "\t" + coordenada);
            } else {
                System.out.println("\t" + "\t" + coordenada);

            }
        }
    }

    public int getCeldasDisponibles() {
        int celdasDisponibles = 0;
        for (Coordenada coordenada : coordenadas) {
            if (coordenada.getEstado() == coordenada.ESTADO_BOCA_ABAJO && !coordenada.isMina()) {
                celdasDisponibles++;
            }
        }
        return celdasDisponibles;
    }

    public ArrayList<Coordenada> getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(ArrayList<Coordenada> coordenadas) {
        this.coordenadas = coordenadas;
    }

    public boolean tieneMinaCerca(Coordenada coordenada) {
        boolean salida = false;
        for (Coordenada coordenada1 : this.getCoordenadas()) {
            if (!coordenada.equals(coordenada1) && coordenada1.isMina()) {
                //Numero arriba izquierda de la mina
                if (coordenada1.getFila() == (coordenada.getFila() - 1)
                        && coordenada1.getColumna() == (coordenada.getColumna() - 1)) {
                    salida = true;
                }
                //Numero arriba centro de la mina
                if (coordenada1.getFila() == (coordenada.getFila() - 1)
                        && coordenada1.getColumna() == (coordenada.getColumna())) {
                    salida = true;
                }
                //Numero arriba derecha de la mina
                if (coordenada1.getFila() == (coordenada.getFila() - 1)
                        && coordenada1.getColumna() == (coordenada.getColumna() + 1)) {
                    salida = true;
                }
                //Numero misma fila a la izquierda de la mina
                if (coordenada1.getFila() == (coordenada.getFila())
                        && coordenada1.getColumna() == (coordenada.getColumna() - 1)) {
                    salida = true;
                }
                //Numero misma fila a la derecha de la mina
                if (coordenada1.getFila() == (coordenada.getFila())
                        && coordenada1.getColumna() == (coordenada.getColumna() + 1)) {
                    salida = true;
                }
                //Numero debajo a la izquierda de la mina
                if (coordenada1.getFila() == (coordenada.getFila() + 1)
                        && coordenada1.getColumna() == (coordenada.getColumna() - 1)) {
                    salida = true;
                }
                //Numero debajo en el centro de la mina
                if (coordenada1.getFila() == (coordenada.getFila() + 1)
                        && coordenada1.getColumna() == (coordenada.getColumna())) {
                    coordenada1.setMinasCercas(coordenada1.getMinasCercas() + 1);
                }
                //Numero debajo a la derecha de la mina
                if (coordenada1.getFila() == (coordenada.getFila() + 1)
                        && coordenada1.getColumna() == (coordenada.getColumna() + 1)) {
                    coordenada1.setMinasCercas(coordenada1.getMinasCercas() + 1);
                }
            }
        }
        return salida;
    }

    public void desvelarMinas() {
        for (Coordenada coordenada : getCoordenadas()) {
            if (coordenada.isMina()) {
                coordenada.setEstado(coordenada.ESTADO_ES_MINA);
            }
        }
    }

}
