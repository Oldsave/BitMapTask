package BitMapTask.ueberarbeitet;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/*
    Show 4 Bitmaps with Color Values as Bitmaps on GUI
    Wol 2018 Java 1.8 MacOS 10.11
    vers. 0.2
    programm expects four 2-dim int arrays of SIZExSIZE
    see method showImages(...)
    possible values for each int is BLACK or WHITE
*/

public class ShowArrayAsPicture
        extends JFrame {

    public static final int SIZE = 200;
    public static int BLACK = 0;
    public static int WHITE = 0xFFFFFF;
    //public static int BLUE = 0x0000FF;

    private BufferedImage convertArrayToImage(int[][] my2DimArray){
        BufferedImage img = new BufferedImage(SIZE, SIZE, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                img.setRGB(i, j, my2DimArray[i][j]);
            }
        }
        return img;
    }

    /*
    do the work
     */
    public void showImages(int[][] origB, int copyB1[][], int copyB2[][], int copyB3[][]) {
        BufferedImage img = convertArrayToImage(origB);
        BufferedImage changedImg1 = convertArrayToImage(copyB1);
        BufferedImage changedImg2 = convertArrayToImage(copyB2);
        BufferedImage changedImg3 = convertArrayToImage(copyB3);

        Container mypane = getContentPane();
        JPanel jp = new JPanel(new FlowLayout(FlowLayout.CENTER,20,20));
        JPanel jp1 = new JPanel(new FlowLayout(FlowLayout.CENTER,20,20));
        jp.add(new JLabel(new ImageIcon(img)));
        jp.add(new JLabel(new ImageIcon(changedImg1)));
        jp1.add(new JLabel(new ImageIcon(changedImg2)));
        jp1.add(new JLabel(new ImageIcon(changedImg3)));
        mypane.add(jp, BorderLayout.NORTH);
        mypane.add(jp1, BorderLayout.CENTER);

        setSize(2*SIZE + 50, 2*SIZE + 100);
        setLocation(100, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

}