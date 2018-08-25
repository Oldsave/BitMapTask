package BitMapTask.ueberarbeitet;

import BitMapTask.ueberarbeitet.Exceptions.ParameterError;


public class Main {

    public static void main(String[] args) throws ParameterError {
        ShowArrayAsPicture s = new ShowArrayAsPicture();
        final int SIZE = 200;
        int[][] origB = new int[SIZE][SIZE];
        int[][] copyB1 = new int[SIZE][SIZE];
        int[][] copyB2 = new int[SIZE][SIZE];
        int[][] copyB3 = new int[SIZE][SIZE];
        int[][] copyB4 = new int[SIZE][SIZE];
        copyB4 = DoIt.makePoint(100, 100, copyB4, SIZE, 0xFFFFFF);
        copyB3 = DoIt.kreis(copyB3, SIZE);
        int [] punkt1 = {150,100};
        int [] punkt2 = {100,150};
        copyB2 = DoIt.viereck(punkt1,punkt2,copyB2,SIZE);
        copyB1 = DoIt.viereck(punkt1,punkt2,copyB1,SIZE,DoIt.getColor("green"));
        copyB4 = DoIt.horizontaleLinie(copyB4,100,200,50,0x0ddddd);
        copyB4 = DoIt.verticaleLinie(copyB4,50,60,110,0x0dddddd);
        copyB1 = DoIt.diagonale(copyB1,100,40,50,100,0xABCDEF);
        copyB1 = DoIt.rotateRight(copyB1,SIZE);
        copyB1 = DoIt.rotateLeft(copyB1,SIZE);
        int[] punkt1_ = {20,20};
        int [] punkt2_ = {40,40};
        copyB3 = DoIt.viereck(punkt1_,punkt2_,copyB3,SIZE,DoIt.getColor("green"));
        s.showImages(copyB1, copyB2, copyB3, copyB4);
    }

    public static void userInput(){
        ShowArrayAsPicture s = new ShowArrayAsPicture();
        final int SIZE = 200;
        int[][] origB = new int[SIZE][SIZE];
        int[][] copyB1 = new int[SIZE][SIZE];
        int[][] copyB2 = new int[SIZE][SIZE];
        int[][] copyB3 = new int[SIZE][SIZE];
        int[][] copyB4 = new int[SIZE][SIZE];
    }
}
