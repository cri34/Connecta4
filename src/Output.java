public class Output {
    public void mensajeIntroducirMaxFila(){
              System.out.println("selecciona numero de filas para el tablero");
    }
    public void mensajeIntroducirMaxColumna(){
        System.out.println("selecciona numero de columnas para el tablero");
    }
    public void mensajeDimInvalida(int minRowV,int minColV){
        System.out.printf("minima fila : %d | minima columna : %d \n",minRowV,minColV);
    }
    public void mensajeCheckValidRange(int maxCol){
        int minCol=1;
            System.out.printf("columna invalida, columna minima : %d | columna maxima : %d\n", minCol,maxCol);
    }
    public void mensajeCheckFreeRowTab(){
            System.out.println("columnas llenas seleciona otra fila");
    }
    public void mensajeInfoIntrodFicha(int turno,int row,int col,char valorC){
        System.out.printf("turno : %d | fila introducida : %d columna introducida :%d jugador : %c\n",turno,row+1,col+1,valorC);
    }
    public void mensajeIntroducirFicha(){
        System.out.println("selecciona columna para introducir la ficha");
    }
}
