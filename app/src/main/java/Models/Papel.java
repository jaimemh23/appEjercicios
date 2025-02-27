package Models;

public class Papel extends Jugada{
    @Override
    public String comparar(Jugada otraJugada) {
        if(otraJugada instanceof Papel)
            return "Empata";
        else if(otraJugada instanceof Tijera)
            return "Perdiste";
        else
            return "Ganaste";

    }
}
