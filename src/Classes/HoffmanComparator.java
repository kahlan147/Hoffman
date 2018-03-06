package Classes;

import java.util.Comparator;

/**
 * Created by Niels Verheijen on 27/02/2018.
 */
public class HoffmanComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        if(o1 instanceof LetterOccurance && o2 instanceof LetterOccurance){
            LetterOccurance l1 = (LetterOccurance) o1;
            LetterOccurance l2 = (LetterOccurance) o2;

            if(l1.getAmount() > l2.getAmount()){
                return -1;
            }
            else if (l1.getAmount() < l2.getAmount()){
                return 1;
            }
            else{
                return -(l1.getLetter().compareTo(l2.getLetter()));
            }
        }
        return 0;
    }
}
