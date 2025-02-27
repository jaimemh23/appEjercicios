package Models;

public class Tijera extends Jugada{
    @Override
    public String comparar(Jugada otraJugada) {
        if(otraJugada instanceof Tijera)
            return "Empate";
        else if(otraJugada instanceof Piedra)
            return "Perdiste";
        else
            return "Ganaste";
    }
}
