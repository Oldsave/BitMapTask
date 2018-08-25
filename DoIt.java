package BitMapTask.ueberarbeitet;

import BitMapTask.ueberarbeitet.Exceptions.OutOfBorder;
import BitMapTask.ueberarbeitet.Exceptions.ParameterError;

/**
 * Diese Klasse beinhaltet Methoden, die bestimmte geometrische Koerper genrieren lassen
 *
 * @author Florian
 * @version 1.1.5
 */
public class DoIt {
    /**
     * Gibt den Hex-Farbwert fuer eine Farbe zurueck
     *
     * @param color Name der Farbe in Englisch
     * @return Hex-Wert der Farbe
     * @throws ParameterError wirft diese Fehlermeldung, wenn die gewünshte Farbe nicht gefunden wurde
     */
    public static int getColor(String color) throws ParameterError {
        switch (color) {
            case "black":
                return 0x000000;

            case "white":
                return 0xFFFFFF;

            case "green":
                return 0x42FF00;

            case "orange":
                return 0xf49e42;

            case "blue":
                return 0x0000FF;

            case "red":
                return 0xf44242;
            default:
                throw new ParameterError("es konnte keine Farbe gefunden werden");
        }

    }


    /**
     * Setzt einen Punkt an der gewünschten Postion (P(xPoint|yPoint)) mit festem Farbwert
     *
     * @param xPoint Wert der X-Koordinate
     * @param yPoint Wert der Y-Koordinate
     * @param field  aktuelle mehrdimensionale Array, das verändert werden soll
     * @param SIZE   die Kantenlaenge des Feldes
     * @return int[][] gibt das bearbeitete Feld zurueck
     */
    public static int[][] makePoint(int xPoint, int yPoint, int[][] field, final int SIZE) {
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                if (x == xPoint && y == yPoint) {
                    field[y][x] = 0xFFFFFF;
                }
            }
        }

        return field;
    }

    /**
     * Setzt einen Punkt an der gewünschten Postion (P(xPoint|yPoint)) mit variablem Farbwert
     *
     * @param xPoint Wert der X-Koordinate
     * @param yPoint Wert der Y-Koordinate
     * @param field  aktuelle mehrdimensionale Array, das verändert werden soll
     * @param SIZE   die Kantenlaenge des Feldes
     * @param color  den Hex-Farbwert
     * @return int[][] gibt das bearbeitete Feld zurueck
     */
    public static int[][] makePoint(int xPoint, int yPoint, int[][] field, final int SIZE, int color) {
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                if (x == xPoint && y == yPoint) {
                    field[y][x] = color;
                }
            }
        }

        return field;
    }

    /**
     * Genriert einen Kreis, wo ein Kreis in der mitte mit dem max. Radius dargestellt wird
     *
     * @param field aktuelle mehrdimensionale Array, das verändert werden soll
     * @param SIZE  groeße des Feldes
     * @return int[][] gibt das bearbeitete Feld zurueck
     */
    public static int[][] kreis(int[][] field, final int SIZE) {
        final int BLACK = 0x000000;
        final int WHITE = 0xFFFFFF;
        int[][] arrs = field;
        int r = SIZE / 2 - 1;
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                boolean isCircle = Math.pow(x - r, 2) + Math.pow(y - r, 2) - Math.pow(r, 2) > 100;
                arrs[x][y] = isCircle ? BLACK : WHITE;
            }
        }
        return arrs;
    }

    /**
     * Genriert einen Kreis, wo ein Kreis in der mitte mit dem max. Radius dargestellt wird
     *
     * @param field aktuelle mehrdimensionale Array, das verändert werden soll
     * @param SIZE  groeße des Feldes
     * @return int[][] gibt das bearbeitete Feld zurueck
     **/
    public static int[][] kreis(int[][] field, final int SIZE, int x_, int y_, int r_) {
        final int BLACK = 0x000000;
        final int WHITE = 0xFFFFFF;
        int[][] arrs = field;
        int r = r_;
        for (int x = x_; x < SIZE; x++) {
            for (int y = y_; y < SIZE; y++) {
                boolean isCircle = Math.pow(x - r, 2) + Math.pow(y - r, 2) - Math.pow(r, 2) > 0;
                arrs[x][y] = isCircle ? BLACK : WHITE;
            }
        }
        return arrs;
    }

    /**
     * Faerbt die Flaeche des Viereckes ein
     *
     * @param field aktuelle mehrdimensionale Array, das verändert werden soll
     * @param y_    Wert des kleinsten Y-Koordinate
     * @param x_    Wert der kleinsten X-Koordinate
     * @param SIZE  groeße des Spielfeldes
     * @param color den Hex-Farbwert
     * @return int[][] gibt das bearbeitete Feld zurueck
     */
    //TODO: Viereck muss überarbeitet werden
    private static int[][] viereckBerechnung(int[][] field, int y_, int x_, final int SIZE, int color) {
        for (int x = x_; x < SIZE; x++) {
            for (int y = y_; y < SIZE; y++) {
                field[x][y] = color;
            }
        }
        return field;
    }

    /**
     * Generiert ein farbiges Viereck
     *
     * @param punkt1 Array mit der X-Koordinate (index:0) und Y-Koordinate (index:1)
     * @param punkt2 Array mit der X-Koordinate (index:0) und Y-Koordinate (index:1)
     * @param field  aktuelle mehrdimensionale Array, das verändert werden soll
     * @param SIZE   groeße des Spielfeldes
     * @return int[][] gibt das bearbeitete Feld zurueck
     */
    public static int[][] viereck(int[] punkt1, int[] punkt2, int[][] field, final int SIZE) {
        int x1 = punkt1[0];
        int y1 = punkt1[1];
        int x2 = punkt2[0];
        int y2 = punkt2[1];
        int color = 0xABCDEF;
        if (y2 < y1) {
            System.out.println("Punkt zwei ist tiefer");
            if (x2 < x1) {
                DoIt.viereckBerechnung(field, y2, x2, SIZE, color);
            } else {
                DoIt.viereckBerechnung(field, y2, x1, SIZE, color);
            }
        } else {
            if (x2 < x1) {
                DoIt.viereckBerechnung(field, y1, x2, SIZE, color);
            } else {
                DoIt.viereckBerechnung(field, y1, x1, SIZE, color);
            }

        }

        return field;
    }

    /**
     * Generiert ein farbiges Viereck
     *
     * @param punkt1 Array mit der X-Koordinate (index:0) und Y-Koordinate (index:1)
     * @param punkt2 Array mit der X-Koordinate (index:0) und Y-Koordinate (index:1)
     * @param field  aktuelle mehrdimensionale Array, das verändert werden soll
     * @param SIZE   groeße des Spielfeldes
     * @param color  den Hex-Farbwert
     * @return int[][] gibt das bearbeitete Feld zurueck
     */
    public static int[][] viereck(int[] punkt1, int[] punkt2, int[][] field, final int SIZE, int color) {
        int x1 = punkt1[0];
        int y1 = punkt1[1];
        int x2 = punkt2[0];
        int y2 = punkt2[1];
        if (y2 < y1) {
            System.out.println("Punkt zwei ist tiefer");
            if (x2 < x1) {
                field = DoIt.viereckBerechnung(field, y2, x2, SIZE, color);
            } else {
                field = DoIt.viereckBerechnung(field, y2, x1, SIZE, color);
            }
        } else {
            if (x2 < x1) {
                field = DoIt.viereckBerechnung(field, y1, x2, SIZE, color);
            } else {
                field = DoIt.viereckBerechnung(field, y1, x1, SIZE, color);
            }

        }

        return field;
    }

    /**
     * Die Methode soll spaeter die Eingaben vom User ueberpruefen
     *
     * @param SIZE groeße des Spielfeldes
     * @param x    Wert fuer die angegebene X-Koordinate
     * @param y    Wert fuer die angegebene Y-Koordinate
     * @throws OutOfBorder wirft diese Fehlermeldung, wenn der Punkt außerhalb des Viereckes ist
     */
    public static void checkXAndY(int x, int y, final int SIZE) throws OutOfBorder {
        if (x > SIZE || y > SIZE) {
            throw new OutOfBorder("Die Punkte liegen außerhalb des Viereckes");
        }
    }
    /*
    public static int[][] viereck(int[] punkt1, int[] punkt2, int punkt3, int punkt4, int[][] field, final int SIZE, int color) {
        return field;
    }*/

    /**
     * Zeichnet eine horizontale Linie von Punkt A nach Punkt B
     *
     * @param field  aktuelle mehrdimensionale Array, das verändert werden soll
     * @param xStart Wert des ersten Punktes fuer x
     * @param xEnde  Wert des zweiten Punktes fuer x
     * @param y_     Wert fuer die Y-Koordinate der Punkte
     * @param color  den Hex-Farbwert
     * @return int[][] gibt das bearbeitete Feld zurueck
     */
    public static int[][] horizontaleLinie(int[][] field, int xStart, int xEnde, int y_, int color) {
        for (int x = xStart; x < xEnde; x++) {
            field[x][y_] = color;
        }
        return field;
    }

    /**
     * Zeichnet eine vertikale Linie von Punkt A nach Punkt B
     *
     * @param field  aktuelle mehrdimensionale Array, das verändert werden soll
     * @param yStart Wert des ersten Punktes fuer y
     * @param yEnde  Wert des zweiten Punktes fuer y
     * @param x_     Wert fuer die X-Koordinate der Punkte
     * @param color  den Hex-Farbwert
     * @return int[][] gibt das bearbeitete Feld zurueck
     */
    public static int[][] verticaleLinie(int[][] field, int yStart, int yEnde, int x_, int color) {
        for (int y = yStart; y < yEnde; y++) {
            field[x_][y] = color;
        }
        return field;
    }

    /**
     * Berechnen einer Diagonlen Linie mit Hilfe der allgemeinen Geradengleichung y = m*x+b
     *
     * @param field  aktuelle mehrdimensionale Array, das verändert werden soll
     * @param xStart Startwert fuer X
     * @param xEnd   Endwert fuer X
     * @param yStart Startwert fuer Y
     * @param yEnd   Endwert fuer Y
     * @param m      Wert fuer die Steigung
     * @param b      Wert fuer dne Y-Achsenabschnitt
     * @param color  den Hex-Farbwert
     * @return int[][] gibt das bearbeitete Feld zurueck
     */
    private static int[][] diagonaleBerechnung(int[][] field, int xStart, int xEnd, int yStart, int yEnd, int m, int b, int color) {
        for (int x = xStart; x < xEnd; x++) {
            int y = Math.abs(m) * x + b;//TODO: überprfen, ob abs unbendingt seien muss, besser wäre wenn nicht
            System.out.println("f(" + x + ")=" + y);
            if (y >= yStart && y <= yEnd) {
                field[x][y] = color;
            }

        }
        return field;
    }

    /**
     * Generieren einer diagonalen Linie
     *
     * @param field aktuelle mehrdimensionale Array, das verändert werden soll
     * @param x1    Wert fuer die X-Koordinate des ersten Punktes
     * @param y1    Wert fuer die Y-Koordinate des ersten Punktes
     * @param x2    Wert fuer die X-Koordinate des zweiten Punktes
     * @param y2    Wert fuer die Y-Koordinate des zweiten Punktes
     * @param color den Hex-Farbwert
     * @return int[][] gibt das bearbeitete Feld zurueck
     */
    public static int[][] diagonale(int[][] field, int x1, int y1, int x2, int y2, int color) {
        int xStart, xEnd, yStart, yEnd;
        if (x1 < x2) {
            xStart = x1;
            xEnd = x2;
        } else {
            xStart = x2;
            xEnd = x1;
        }
        if (y1 < y2) {
            yStart = y1;
            yEnd = y2;
        } else {
            yStart = y2;
            yEnd = y1;
        }
        int m = (y2 - y1) / (x2 - x1);
        System.out.println(m);
        int b = y2 / (x2 * m);
        // TODO: umändern, dass gerpüft wird, was der größere wert von x und y ist
        field = DoIt.diagonaleBerechnung(field, xStart, xEnd, yStart, yEnd, m, b, color);
        return field;
    }

    /**
     * Dreht das Feld nach rechts
     *
     * @param field aktuelle mehrdimensionale Array, das verändert werden soll
     * @param SIZE  groeße des Spielfeldes
     * @return int[][] gibt das bearbeitete Feld zurueck
     */
    public static int[][] rotateRight(int[][] field, final int SIZE) {
        int[][] arrayNew = new int[SIZE][SIZE];
        int i = 0;
        int j = 0;
        for (int x = SIZE - 1; x > -1; x--) {
            for (int y = 0; y < SIZE; y++) {
                arrayNew[x][y] = field[i][j];
                i++;
            }
            i = 0;
            j++;
        }
        return arrayNew;
    }

    /**
     * Dreht das Feld nach links
     *
     * @param field aktuelle mehrdimensionale Array, das verändert werden soll
     * @param SIZE  groeße des Spielfeldes
     * @return int[][] gibt das bearbeitete Feld zurueck
     */
    public static int[][] rotateLeft(int[][] field, int SIZE) {
        int[][] arrayNew = new int[SIZE][SIZE];
        int i = 0;
        int j = 0;
        for (int x = 0; x < SIZE; x++) {
            for (int y = SIZE - 1; y > -1; y--) {
                arrayNew[x][y] = field[i][j];
                i++;
            }
            i = 0;
            j++;
        }
        return arrayNew;
    }
}



