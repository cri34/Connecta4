public class  Tablero  implements Input{
    Output out= new Output();
    private final int minRowV = 8;
   private final int minColV = 8;
   private int maxRow;
   private int maxCol;
   private char [][] tab;

    public Tablero(){
        initTablero();
    }
    private void setDimension(){
        out.mensajeIntroducirMaxFila();
        int r = s.nextInt();
        out.mensajeIntroducirMaxColumna();
        int c = s.nextInt();
        while(!checkValidDimensionToTablero(r,c)){
            out.mensajeDimInvalida(minRowV, minColV);
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
       return row >= minRowV && col >= minColV;
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
    public void insertarFicha(int turno){
        int firstRowLibre;
        out.mensajeIntroducirFicha();
        int col = s.nextInt()-1;
        char valorC = (turno % 2 == 0)?'o':'x';
        while(!checkValidPosition(col)){
            out.mensajeIntroducirFicha();
            col = s.nextInt()-1;
        }
        firstRowLibre = retFreeRowTab(col);
        tab[firstRowLibre][col] = valorC;
        printTablero();
        out.mensajeInfoIntrodFicha(turno,firstRowLibre,col,valorC);
    }

    private boolean checkValidPosition(int col){
        if (!checkValidRange(col)) {
            out.mensajeCheckValidRange(maxCol);
            return false;
        }
        if (!checkFreeRowTab(col)){
            out.mensajeCheckFreeRowTab();
            return false;
        }
        return true;
    }
    public boolean checkValidRange(int col){
        final int minPos = 0;
        return  col < maxCol && col >= minPos;
    }
    public boolean checkFreeRowTab(int col){
        final int fRow=0;
        for (int row = tab.length-1;row >= fRow;row--){
            if (tab[row][col]=='-')
                return true;
        }
        return false;
    }
    public int retFreeRowTab(int col){
        final int fRow=0;
        int row;
        for (row = tab.length-1;row >= fRow;row--){
            if (tab[row][col]=='-')
                break;
        }
        return row;
    }
    public void printTablero(){
        for (int row = 0;row < maxRow;row++){
            for (int col = 0; col < maxCol; col++){
                System.out.print("|"+tab[row][col]+"|");
            }
            System.out.println();
        }
    }


}
