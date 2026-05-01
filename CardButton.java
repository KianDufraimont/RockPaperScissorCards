
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class CardButton extends JPanel{
    private JButton button;
    private CardLabel label;

    public CardButton(Type type){
        super();
        label = new CardLabel(type, false);
        button = new JButton();
        switch (type) {
            case ROCK -> button.setText("Confirm Rock");
            case PAPER -> button.setText("Confirm Paper");
            case SCISSORS -> button.setText("Confirm Scissors");
        }
        
        this.setLayout(new BorderLayout());
        this.add(label);
        this.add(button, BorderLayout.PAGE_END);
    }

    public JButton getButton(){
        return button;
    }

    public CardLabel getCardLabel(){
        return label;
    }

    public Card getCard(){
        return label.getCard();
    }
}
