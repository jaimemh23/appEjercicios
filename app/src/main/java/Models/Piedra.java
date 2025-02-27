package Models;

public class Piedra extends Jugada {
    @Override
    public String comparar(Jugada otraJugada) {
        if(otraJugada instanceof Piedra)
            return "Empate";
        else if(otraJugada instanceof Papel)
            return "Perdiste";
        else
            return "Ganaste";

    }
}
