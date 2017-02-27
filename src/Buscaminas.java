
public class Buscaminas {

    private Tablero tablero;

    private Jugador jugador;

    private int finDeJuego;

    public int NUMERO_FILAS;

    public int NUMERO_COLUMNAS;

    public final int NO_FIN = -1;

    public final int PIERDE_JUGADOR = 0;

    public final int GANA_JUGADOR = 1;

    public Buscaminas() {
        jugador = new Jugador();
        NUMERO_COLUMNAS = 10;
        NUMERO_FILAS = 10;
        tablero = new Tablero(NUMERO_FILAS, NUMERO_COLUMNAS);
        finDeJuego = NO_FIN;
    }

    public static void main(String[] args) {
        Buscaminas buscaminas = new Buscaminas();
        buscaminas.jugar();
    }

    public void jugar() {
        tablero.inicializarTablero();
        Coordenada coordenada;
        do {
            tablero.mostrarTablero();
            coordenada = jugador.elegirPosicion();
            if (tablero.contieneMina(coordenada)) {
                tablero.desvelarMinas();
                setFinDeJuego(PIERDE_JUGADOR);
            } else {
                tablero.actualizarTablero(coordenada);
            }
            if (tablero.getCeldasDisponibles() == 0) {
                finDeJuego = GANA_JUGADOR;
                tablero.desvelarMinas();
            }
        } while (getFinDeJuego() == NO_FIN);
        if (finDeJuego == GANA_JUGADOR) {
            System.out.println("GANA JUGADOR!!");
            tablero.mostrarTablero();
        } else {
            System.out.println("PIERDE JUGADOR!!");
            tablero.mostrarTablero();
        }
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public int getFinDeJuego() {
        return finDeJuego;
    }

    public void setFinDeJuego(int finDeJuego) {
        this.finDeJuego = finDeJuego;
    }
}
