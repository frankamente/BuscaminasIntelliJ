public class Jugador {
    public Coordenada elegirPosicion() {
        int fila = ES.leeN("Introduce una fila: ");
        int columna = ES.leeN("Introduce una columna: ");
        return new Coordenada(fila - 1, columna - 1);
    }
}
