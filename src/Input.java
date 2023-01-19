import java.util.Scanner;

public interface Input {
    Scanner s = new Scanner(System.in);
    static int inpDim(){
        return s.nextInt();
    }
    static int inpFicha(){
        return s.nextInt()-1;
    }


}
