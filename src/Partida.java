public class Partida {
    Tablero t = new Tablero();
    private  final int maxTurno= t.getMaxCol() * t.getMaxRow();
    private int turno = 0;

    public Partida(){
        initPartida();
    }
    private void initPartida(){
        while(turno != maxTurno){
            turno++;
            t.insertarFicha(turno);
        }

    }

}
