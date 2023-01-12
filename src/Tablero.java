public class  Tablero  implements Input{
    Output out= new Output();
    private final int minRowV = 8;
   private final int minColV = 8;
   private int maxRow;
   private int maxCol;
   private char [][] tab;
   private boolean [][] posOcupadas;

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
        maxRow = r;
        maxCol = c;
    }

    public void initTablero(){
        setDimension();
        inicializarTab();
    }
    private boolean checkValidDimensionToTablero(int row, int col){
        boolean validDim = row >= minRowV && col >= minColV;
        if (!validDim)
            out.mensajeDimInvalida(minRowV, minColV);
       return validDim ;
    }
    private void inicializarTab(){
        final char vacio='-';
        tab = new char[maxRow][maxCol];
        for (int i = 0; i < maxRow;i++){
            for  (int e = 0; e < maxCol;e++){
                tab[i][e] = vacio;
            }
        }
    }



}
