public class Partida {
    private  Tablero t = new Tablero();
    private  final int maxTurno= t.getMaxCol() * t.getMaxRow();
    private int turno = 0;

    public Partida(){
        initPartida();
    }
    private void initPartida(){
        t.printTablero();
        while(continuaPartida()){
            turno++;
            t.setTurno(turno);
            t.insertarFicha();
        }
    }
    private boolean continuaPartida(){
        char valorC = (turno % 2 == 0)?'o':'x';
        if (turno == maxTurno){
            Output.mensajeMaxTurno();
            return false;
        }
        if (t.check4Raya()){
            Output.mensaje4EnLinea(valorC);
            return false;
        }
        return true;
    }

}
