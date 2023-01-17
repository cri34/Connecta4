public class Partida {
    private  Tablero t = new Tablero();
    private  final int maxTurno= t.getMaxCol() * t.getMaxRow();
    private int turno = 0;

    public Partida(){
        initPartida();
    }
    private void initPartida(){
        while(turno!= maxTurno){
            turno++;
            t.setTurno(turno);
            t.insertarFicha();
        }
    }

}
