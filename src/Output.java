public class Output {
    public static void mensajeIntroducirMaxFila(){
              System.out.println("selecciona numero de filas para el tablero");
    }
    public static void mensajeIntroducirMaxColumna(){
        System.out.println("selecciona numero de columnas para el tablero");
    }
    public static void mensajeDimInvalida(int minRowV,int minColV,int maxRowV,int maxColV){
        System.out.printf("minima dimension = fila : %d columna : %d | maxima dimension = fila : %d columna : %d \n",minRowV,minColV,maxRowV,maxColV);
    }
    public static void mensajeCheckValidRange(int maxCol){
        int minCol=1;
            System.out.printf("columna invalida, columna minima : %d | columna maxima : %d\n", minCol,maxCol);
    }
    public static void mensajeCheckFreeRowTab(){
            System.out.println("columnas llenas seleciona otra fila");
    }
    public static void mensajeInfoIntrodFicha(int turno,int row,int col,char valorC){
        System.out.printf("turno : %d | fila introducida : %d columna introducida :%d jugador : %c\n",turno,row+1,col+1,valorC);
    }
    public static void mensajeIntroducirFicha(){
        System.out.println("selecciona columna para introducir la ficha");
    }
    public static void mensaje4EnLinea(char valor){
        System.out.printf("jugador : %c ha ganado la partida",valor);
    }
    public static void mensajeMaxTurno(){
        System.out.println("maximo turno alcanzado");
    }
}
