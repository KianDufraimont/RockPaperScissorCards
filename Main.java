
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Main {
    private static JFrame frame;
    private static int winCount = 0, drawCount = 0, loseCount = 0;
    private static JLabel score;
    private static JButton reset;
    public static void main(String[] args) {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setPreferredSize(new Dimension(900,700));
        frame.setVisible(true);
        
        JPanel formatPanel = new JPanel();
        formatPanel.setLayout(new BorderLayout(10,10));

        score = new JLabel(String.format("Win: %d Draw: %d Lose: %d", winCount,drawCount,loseCount));
        score.setHorizontalAlignment(SwingConstants.CENTER);
        score.setFont(new Font("Arial", Font.BOLD, 20));

        reset = new JButton("Reset");
        reset.setEnabled(false);
        reset.addActionListener((ActionEvent e) -> {
            reset.setEnabled(false);
            formatPanel.remove(((BorderLayout)formatPanel.getLayout()).getLayoutComponent(BorderLayout.CENTER));
            formatPanel.add(new GameScreen(), BorderLayout.CENTER);
            frame.revalidate();
            frame.repaint();
        });
        
        formatPanel.add(new GameScreen(), BorderLayout.CENTER);
        formatPanel.add(score, BorderLayout.PAGE_START);
        formatPanel.add(reset, BorderLayout.PAGE_END);
        formatPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        frame.setContentPane(formatPanel);

        frame.pack();
    }

    /**
     * Resets the game after an 4 second delay
     */
    public static void Reset(boolean win, boolean draw){
        //Depreciated timer
        /*Timer timer = new Timer(4000, (ActionEvent e) -> {
            frame.setContentPane(new GameScreen());
            frame.revalidate();
            frame.repaint();
        });
        timer.setRepeats(false);
        timer.start();*/
        reset.setEnabled(true);

        if (win) winCount++;
        else if (draw) drawCount++;
        else loseCount++;
        score.setText(String.format("Win: %d Draw: %d Lose: %d", winCount,drawCount,loseCount));
    }

}
