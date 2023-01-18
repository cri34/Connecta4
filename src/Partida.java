public class Partida {
    private  Tablero t = new Tablero();
    private Output out = new Output();
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
            out.mensajeMaxTurno();
            return false;
        }
        if (t.check4Raya()){
            out.mensaje4EnLinea(valorC);
            return false;
        }
        return true;
    }

}
