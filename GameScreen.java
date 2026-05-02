import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameScreen extends JPanel{
    static final Type[] types = new Type[]{
        Type.ROCK,
        Type.PAPER,
        Type.SCISSORS
    };
    static final Random rand = new Random();

    public GameScreen(){
        super();

        this.setLayout(new GridLayout(2,3,10,10));
        this.setBackground(new Color(255, 253, 208));
        //randomly picks a type for enemy card
        CardLabel enemy = new CardLabel(types[rand.nextInt(3)], true);

        this.add(new JLabel());
        this.add(enemy);
        this.add(new JLabel());
        
        JButton[] buttons = new JButton[3];

        for (int i = 0; i < 3; i++){
            CardButton cardButton = new CardButton(types[i]);
            buttons[i] = cardButton.getButton();
            cardButton.getButton().addActionListener((ActionEvent e) -> {
                enemy.showCard();
                enemy.updateColor(cardButton.getCard());
                cardButton.updateColor(enemy.getCard());
                for (int j = 0; j < 3; j++){
                    buttons[j].setEnabled(false);
                }
                boolean win = cardButton.getCard().isWin(enemy.getCard());
                boolean draw = cardButton.getCard().isDraw(enemy.getCard());
                Main.Reset(win, draw);
            });

            this.add(cardButton);
        }
    }

}
