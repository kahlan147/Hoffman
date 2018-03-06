package Classes;

/**
 * Created by Niels Verheijen on 27/02/2018.
 */
public class LetterOccurance {
    private String letter;
    private int amount;

    public LetterOccurance(String letter, int amount){
        this.letter = letter;
        this.amount = amount;
    }

    public String getLetter(){
        return letter;
    }

    public int getAmount(){
        return amount;
    }
}
