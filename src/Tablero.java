public class  Tablero  implements Input{
    private final int minRowV = 8;
   private final int minColV = 8;
   private final int maxPosRow = 100;
   private final int maxPosCol = 100;
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
        selectDimInsert();
        while(!checkValidDimensionToTablero(maxRow,maxCol)){
            Output.mensajeDimInvalida(minRowV, minColV);
           selectDimInsert();
        }
    }
    private void selectDimInsert(){
        Output.mensajeIntroducirMaxFila();
        maxRow = Input.inpDim();
        Output.mensajeIntroducirMaxColumna();
        maxCol = Input.inpDim();
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
        selecColInsert();
        char valorC = (turno % 2 == 0)?'o':'x';
        while(!checkValidPosition(rowInsert,colInsert)){
            selecColInsert();
        }
        rowInsert = retFreeRowTab(colInsert);
        tab[rowInsert][colInsert] = valorC;
        printTablero();
        Output.mensajeInfoIntrodFicha(turno,rowInsert,colInsert,valorC);
    }
    private void selecColInsert(){
        Output.mensajeIntroducirFicha();
        colInsert = Input.inpFicha();
    }

    private boolean checkValidPosition(int row,int col){
        if (!checkValidRange(row,col)) {
            Output.mensajeCheckValidRange(maxCol);
            return false;
        }
        if (!checkFreeRowTab(col)){
            Output.mensajeCheckFreeRowTab();
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
            System.out.print((row+1) + genSpaces(retLeng(maxRow) - retLeng(row+1)));
            for (int col = 0; col < maxCol; col++){
                System.out.print("|"+tab[row][col]+"|");
            }
            System.out.println();
        }
        System.out.print(genSpaces(retLeng(maxRow)));
        printNCol();
    }
    private void printNCol(){
        final int casL=3;
        for (int i = 0;i < maxCol;i++){
            System.out.print((i+1) + genSpaces(casL - retLeng(i+1) ));
        }
        System.out.println();
    }
    private String genSpaces(int n){
        String es ="";
        for (int i = 0 ; i < n;i++){
            es +=" ";
        }
        return es;
    }
    private int retLeng(int n){
        return Integer.toString(n).length();
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
        final int maxRec=7, difPosIni=-3, maxValCons=4, minValCons=0;
        int valCons = 0, row, col, difRow, difCol;
        char valorC = (turno % 2 == 0)?'o':'x';
        for (int indDir = 0; indDir < dirCol.length; indDir++){
            row = dirRow[indDir] * difPosIni + rowInsert;
            col = dirCol[indDir] * difPosIni + colInsert;
            valCons = minValCons;
            for (int intPosAct = 0 ;intPosAct <= maxRec; intPosAct++){
                difRow = dirRow[indDir] * intPosAct;
                difCol = dirCol[indDir] * intPosAct;
                if (!checkValidRange(row + difRow,col + difCol))
                    continue;
                if (tab[row + difRow][col + difCol] != valorC){
                    valCons = minValCons;
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
