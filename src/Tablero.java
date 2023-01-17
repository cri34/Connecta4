public class  Tablero  implements Input{
    Output out= new Output();
    private final int minRowV = 8;
   private final int minColV = 8;
   private int maxRow;
   private int maxCol;
   private int rowInsert = 0;
   private int colInsert = 0;
   private int turno=0;
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
    public void insertarFicha(){
        out.mensajeIntroducirFicha();
        colInsert = s.nextInt()-1;
        char valorC = (turno % 2 == 0)?'o':'x';
        while(!checkValidPosition(rowInsert,colInsert)){
            out.mensajeIntroducirFicha();
            colInsert = s.nextInt()-1;
        }
        rowInsert = retFreeRowTab(colInsert);
        tab[rowInsert][colInsert] = valorC;
        printTablero();
        out.mensajeInfoIntrodFicha(turno,rowInsert,colInsert,valorC);
    }

    private boolean checkValidPosition(int row,int col){
        if (!checkValidRange(row,col)) {
            out.mensajeCheckValidRange(maxCol);
            return false;
        }
        if (!checkFreeRowTab(col)){
            out.mensajeCheckFreeRowTab();
            return false;
        }
        return true;
    }
    public boolean checkValidRange(int row,int col){
        final int minPos = 0;
        boolean colRange = col < maxCol && col >= minPos;
        boolean rowRange = row < maxRow && row >= minPos;
        return colRange && rowRange;
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
    public int getMaxRow(){
        return maxRow;
    }
    public int getMaxCol(){
        return maxCol;
    }
    public void setTurno (int turno){
        this.turno = turno;
    }
    public boolean check4Raya(){
        int [] dirRow={+0,+1,-1,+1};
        int [] dirCol={+1,+1,+0,-1};
        final int maxRec=7, difPosIni=-3, maxValCons=4;
        int valCons = 0, row, col, difRow, difCol;
        char valorC = (turno % 2 == 0)?'o':'x';
        for (int indDir = 0; indDir < dirCol.length; indDir++){
            row = dirRow[indDir] * difPosIni + rowInsert;
            col = dirCol[indDir] * difPosIni + colInsert;
            for (int intPosAct = 0 ;intPosAct <= maxRec; intPosAct++){
                difRow = dirRow[indDir] * intPosAct;
                difCol = dirCol[indDir] * intPosAct;
                if (!checkValidRange(row + difRow,col + difCol))
                    continue;
                if (tab[row + difRow][col + difCol] != valorC){
                    valCons = 0;
                    continue;
                }
                    valCons++;
                if (valCons == maxValCons)
                    return true;
            }
        }
        return false;
    }
}
