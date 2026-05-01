public class Card{
    private final Type type;

    public Card(Type type){
        this.type = type;
    }

    public boolean isWin(Card other){
        switch (other.type) {
            case ROCK -> {
                return this.type == Type.PAPER;
            }
            case PAPER -> {
                return this.type == Type.SCISSORS;
            }
            case SCISSORS -> {
                return this.type == Type.ROCK;
            }
        }
        return false;
    }

    public boolean isDraw(Card other){
        return this.type == other.type;
    }

    public Type getType(){
        return this.type;
    }

}