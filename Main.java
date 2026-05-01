
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Main {
    private static JFrame frame;
    public static void main(String[] args) {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setPreferredSize(new Dimension(900,700));
        frame.setVisible(true);
        
        
        frame.setContentPane(new GameScreen());

        frame.pack();
    }

    /**
     * Resets the game after an 8 second delay
     */
    public static void Reset(){
        Timer timer = new Timer(8000, (ActionEvent e) -> {
            frame.setContentPane(new GameScreen());
            frame.revalidate();
            frame.repaint();
        });
        timer.setRepeats(false);
        timer.start();
    }

}
