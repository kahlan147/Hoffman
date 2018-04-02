package Classes;

import java.util.Comparator;

/**
 * Created by Niels Verheijen on 27/02/2018.
 */
public class HoffmanComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        if(o1 instanceof Node && o2 instanceof Node){
            Node l1 = (Node) o1;
            Node l2 = (Node) o2;

            if(l1.getFrequency() > l2.getFrequency()){
                return 1;
            }
            else if (l1.getFrequency() < l2.getFrequency()){
                return -1;
            }
            else{
                if(l1.getCharacter() == null || l2.getCharacter() == null){
                    return 0;
                }
                return (l1.getCharacter().compareTo(l2.getCharacter()));
            }
        }
        return 0;
    }
}
