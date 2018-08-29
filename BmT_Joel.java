public class BitMapTask {
    private int SIZE = ShowArrayAsPicture.SIZE;
    private int BLACK = ShowArrayAsPicture.BLACK;
    private int WHITE = ShowArrayAsPicture.WHITE;

    private int[][] anArray1 = new int[SIZE][SIZE];
    private int[][] anArray2 = new int[SIZE][SIZE];
    private int[][] anArray3 = new int[SIZE][SIZE];
    private int[][] anArray4 = new int[SIZE][SIZE];
    private int[][] anArray5 = new int[SIZE][SIZE];
    private int[][] anArray6 = new int[SIZE][SIZE];
    private int[][] anArray7 = new int[SIZE][SIZE];
    private int[][] anArray8 = new int[SIZE][SIZE];

    public int[][] getAnArray1() {
        return anArray1;
    }

    public int[][] getAnArray2() {
        return anArray2;
    }

    public int[][] getAnArray3() {
        return anArray3;
    }

    public int[][] getAnArray4() {
        return anArray4;
    }

    public int[][] getAnArray5() {
        return anArray5;
    }

    public int[][] getAnArray6() {
        return anArray6;
    }

    public int[][] fillA1(int value) { //Ein Diagonaler Strich in der Mitte
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < x; y++) {
                anArray1[x][SIZE - y - 1] = value;
            }
        }
        //anArray1 [0][SIZE-1] = BLACK;
        return anArray1;
    }

    public int[][] fillA2(int value, int steps) { //Diagonale Striche
        for (int i = 200; i > 0; i -= steps) {
            for (int x = 0; x < SIZE; x++) {
                for (int y = i; y < SIZE; y++) {
                    anArray2[y - i][y] = value;
                }
            }
        }

        for (int i = 0; i < SIZE; i += steps) {
            for (int x = i; x < SIZE; x++) {
                anArray2[x][x] = value;
                for (int y = 0; y < SIZE; y++) {
                    anArray2[x][x - i] = value;
                }
            }
        }
        return anArray2;
    }

    public int[][] fillA3(int value) { //Nils Kreis lösung
        int xCenter = 50;
        int yCenter = 50;
        int radius = 50;
        for (int y = 0; y < anArray3.length; y++) {
            for (int x = 0; x < anArray3.length; x++) {
                if (Math.sqrt(Math.pow(xCenter - x, 2) + Math.pow(yCenter - y, 2)) < radius) {
                    anArray3[x][y] = BLACK;
                } else {
                    anArray3[x][y] = WHITE;
                }
            }
        }
        return anArray3;
    }

    public int[][] fillA4(int value) { //Lehrers Kreis Lösung
        for (int x = 0; x < anArray4.length; x++) {
            for (int y = 0; y < anArray4.length; y++) {
                double h1 = (x - 100) / 50.0;
                double h2 = (y - 100) / 50.0;

                double r1 = Math.pow(h1, 2) + Math.pow(h2, 2);
                //System.out.println(h1 + "/" + h2 + "/" + r1);
                if (r1 < 1) {
                    anArray4[x][y] = BLACK;
                } else {
                    anArray4[x][y] = WHITE;
                }

            }
        }
        return anArray4;
    }

    public int[][] fillA5(int value) { //Quadrat
        int xCenter = 190;
        int yCenter = 190;
        int seitenlaenge = 50;
        for (int x = xCenter; x < anArray5.length; x++) {
            for (int y = yCenter; y < anArray5.length; y++) {
                if (x < seitenlaenge + xCenter && y < seitenlaenge + yCenter) {
                    anArray5[x][y] = WHITE;
                } else {
                    anArray5[x][y] = BLACK;
                }

            }
        }
        return anArray5;
    }

    public int[][] fillA6(int value) { //Rechteck
        int xCenter = 50;
        int yCenter = 50;
        int seitenlaengeA = 90;
        int seitenlaengeB = 30;
        for (int x = 0; x < anArray5.length; x++) {
            for (int y = 0; y < anArray5.length; y++) {
                if (x < seitenlaengeB && y < seitenlaengeA) {

                    anArray6[x][y] = BLACK;
                } else {
                    anArray6[x][y] = WHITE;
                }

            }
        }
        return anArray6;
    }


    public int[][] fillA7(int value) { //Dreieck: Value ist die Länge von Kante a/b
        int xCenter = 50;
        int yCenter = 50;
        for (int x = xCenter; x < value + xCenter; x++) {
            for (int y = yCenter; y < (value - x)+ yCenter; y++) {
                anArray7[x][y] = WHITE;
            }
        }
        return anArray7;
    }

    public int[][] fillA8(int value) { //Halbierter Kreis
        int xCenter = 100;
        int yCenter = 100;
        int radius = 50;
        for (int y = 0; y < anArray8.length; y++) {
            for (int x = 0; x < anArray8.length; x++) {
                System.out.println(Math.sqrt(Math.pow(xCenter - x, 2) + Math.pow(yCenter - y, 2)));
                if (Math.sqrt(Math.pow(xCenter - x, 2) + Math.pow(yCenter - y, 2)) < radius && xCenter - x + yCenter - y > 0) {
                    anArray8[x][y] = BLACK;
                } else {
                    anArray8[x][y] = WHITE;
                }
            }
        }
        return anArray8;
    }


    public int[][] createConnection(int[] punkt_1, int[] punkt_2) { // Ferdi's Punktverbindung: So zuweisen, dass p_1 immer links ist, also einen kleineren x-Wert besitzt
        int[] p_1, p_2;
        if (punkt_1[0] < punkt_2[0]) {
            p_1 = punkt_1;
            p_2 = punkt_2;
        } else {
            p_1 = punkt_2;
            p_2 = punkt_1;
        }
        float m = (float) (p_2[1] - p_1[1]) / (p_2[0] - p_1[0]);
        for (int x = 0; x < SIZE; x++){
            for (int y = 0; y < SIZE;y++){
                if (
                           y + m / 2 >= m * (x - p_1[0]) + p_1[1]
                        && y - m / 2 <= m * (x - p_1[0]) + p_1[1]
                        && x >= p_1[0] && x <= p_2[0]){
                    anArray8 [x][y] = WHITE;
                }
            }
        }
        return anArray8;
    }



    public int[][] rotateRight(int[][] aa) {
        int[][] copyaa = new int[aa.length][aa.length];
        for (int x = 0; x < copyaa.length; x++) {
            for (int y = 0; y < copyaa.length; y++) {
                copyaa[x][y] = aa[SIZE - x - 1][y];
            }
        }
        return copyaa;
    }

    public int[][] Stretch(int[][] aa) {
        int[][] copyaa = new int[aa.length][aa.length];
        for (int x = 0; x < copyaa.length; x++) {
            for (int y = 0; y < copyaa.length; y++) {
                System.out.println(x + "/" + y);
                copyaa[x][y] = aa[x][y / 2];
            }
        }
        return copyaa;
    }


    public static void main(String[] args) {
        BitMapTask bmt = new BitMapTask();
        int[][] a = bmt.fillA4(1);
        bmt.rotateRight(bmt.fillA4(1));
        bmt.fillA1(0xFFFFF);
        int[][] b = bmt.fillA3(0xFFFFFF);
        int[] p1 = {50, 50};
        int[] p2 = {80,80};

        ShowArrayAsPicture test1 = new ShowArrayAsPicture();
        test1.showImages(bmt.anArray1, bmt.rotateRight(bmt.fillA1(0xFFFFFF)), a, bmt.fillA7(50));
        /*bmt.anArray1, bmt.anArray2, bmt.anArray3,*/
    }
}
