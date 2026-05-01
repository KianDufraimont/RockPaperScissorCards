
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class CardLabel extends JLabel{
    private final Card card;

    public CardLabel(Type type, boolean hidden){
        super();
        setText(type);
        card = new Card(type);

        if (hidden) this.setText("Enemy");

        this.setPreferredSize(new Dimension(100,200));
        this.setBackground(new Color(0, 0, 139));
        this.setOpaque(true);
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setFont(new Font("Arial", Font.BOLD, 20));
        this.setForeground(Color.black);

    }

    public void showCard(){
        setText(card.getType());
    }

    public Card getCard(){
        return card;
    }

    private void setText(Type type){
        switch (type) {
            case ROCK -> this.setText("Rock");
            case PAPER -> this.setText("Paper");
            case SCISSORS -> this.setText("Scissors");
        }
    }

    public boolean isWin(Card otheCard){
        return card.isWin(otheCard);
    }

    public boolean isDraw(Card otheCard){
        return card.isDraw(otheCard);
    }

    public void updateColor(Card otheCard){
        if (isWin(otheCard)) win();
        else if (isDraw(otheCard)) draw();
        else lose();
    }

    private void win(){
        setBackground(Color.yellow);
    }
    private void draw(){
        setBackground(Color.cyan);
    }
    private void lose(){
        setBackground(Color.gray);
    }

}
