package Classes;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * Created by Niels Verheijen on 27/02/2018.
 */
public class Manager {

    public Manager(){

    }

    public String[] splitString(String string){
        char[] charred = string.toCharArray();
        String[] stringedChars = new String[charred.length];
        int x = 0;
        for(char letter : charred){
            stringedChars[x] = "" + letter;
            x++;
        }
        return stringedChars;
    }

    public HashSet frequencyWords(String input) {
        String[] charredString = splitString(input);
        HashMap<String, Integer> occurrences = new HashMap<>();
        for (String word : charredString) {
            if (occurrences.containsKey(word)) {
                occurrences.replace(word, occurrences.get(word) + 1);
            }
            else {
                occurrences.put(word, 1);
            }
        }
        HashSet<LetterOccurance> letterOccurances = new HashSet<>();
        occurrences.forEach((k,v) -> letterOccurances.add(new LetterOccurance(k,v)));
        return letterOccurances;
    }

    public TreeSet getHoffmanTree(String input){
        HashSet set = frequencyWords(input);
        TreeSet hoffmanTree = new TreeSet(new HoffmanComparator());
        hoffmanTree.addAll(set);
        return hoffmanTree;
    }
}
