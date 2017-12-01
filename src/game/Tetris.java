package game;
import javax.swing.*;


/**
 * Created by zu on 2015/3/30.
 */

public class Tetris
{
    public static void main(String args[])
    {
        MainWindowFrame mainWindow=new MainWindowFrame();
        mainWindow.setTitle("Tetris");
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setVisible(true);

    }


}