public class  Tablero  implements Input{
    Output out= new Output();
    private final int minRow = 8;
   private final int minCol = 8;
   private int maxRow;
   private int maxCol;
   private char [][] tablero ;

    public Tablero(){
        initTablero();
    }
    private void setDimension(){
        int r = 0;
        int c = 0;
        while(!checkValidDimensionToTablero(r,c)){
            out.mensajeIntroducirMaxFila();
            r = s.nextInt();
            out.mensajeIntroducirMaxColumna();
            c = s.nextInt();
        }
    }

    public void initTablero(){
        setDimension();
    }
    private boolean checkValidDimensionToTablero(int row, int col){
        boolean validDim = row >= minRow && col >= minCol;
        if (!validDim)
            out.mensajeDimInvalida(minRow,minCol);
       return validDim ;
    }



}
