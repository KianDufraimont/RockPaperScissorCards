
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Main {
    private static JFrame frame;
    private static int winCount = 0, drawCount = 0, loseCount = 0;
    public static void main(String[] args) {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setPreferredSize(new Dimension(900,700));
        frame.setVisible(true);
        
        frame.setTitle(String.format("Win: %d Draw: %d Lose: %d", winCount,drawCount,loseCount));
        frame.setContentPane(new GameScreen());

        frame.pack();
    }

    /**
     * Resets the game after an 4 second delay
     */
    public static void Reset(boolean win, boolean draw){
        Timer timer = new Timer(4000, (ActionEvent e) -> {
            frame.setContentPane(new GameScreen());
            frame.revalidate();
            frame.repaint();
        });
        timer.setRepeats(false);
        timer.start();

        if (win) winCount++;
        else if (draw) drawCount++;
        else loseCount++;
        frame.setTitle(String.format("Win: %d Draw: %d Lose: %d", winCount,drawCount,loseCount));
    }

}
