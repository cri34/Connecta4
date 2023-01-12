public class Output {
    public void mensajeIntroducirMaxFila(){
              System.out.println("selecciona numero de filas para el tablero");
    }
    public void mensajeIntroducirMaxColumna(){
        System.out.println("selecciona numero de columnas para el tablero");
    }
    public void mensajeDimInvalida(int minRow,int minCol){
        System.out.printf("minima fila : %d | minima columna : %d \n",minRow,minCol);
    }
}
