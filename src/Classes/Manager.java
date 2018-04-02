package Classes;

import java.util.*;

/**
 * Created by Niels Verheijen on 27/02/2018.
 */

// "Verheijen": 9 1 23 33 1 13 18 1 5

public class Manager {

    public Manager(){

    }

    private Character[] splitString(String string){
        char[] charred = string.toCharArray();
        Character[] stringedChars = new Character[charred.length];
        int x = 0;
        for(char letter : charred){
            stringedChars[x] = letter;
            x++;
        }
        return stringedChars;
    }

    private HashSet frequencyWords(String input) {
        Character[] charredString = splitString(input);
        HashMap<Character, Integer> occurrences = new HashMap<>();
        for (Character word : charredString) {
            if (occurrences.containsKey(word)) {
                occurrences.replace(word, occurrences.get(word) + 1);
            }
            else {
                occurrences.put(word, 1);
            }
        }
        HashSet<Node> letterOccurances = new HashSet<>();
        occurrences.forEach((k,v) -> letterOccurances.add(new Node(k,v)));
        return letterOccurances;
    }

    public Node getHoffmanTree(String input){
        HashSet<Node> set = frequencyWords(input);
        TreeSet<Node> huffmanTree = new TreeSet(new HoffmanComparator());
        huffmanTree.addAll(set);

        Node tree = createHuffmanTree(huffmanTree);

        return tree;
    }

    private Node createHuffmanTree(TreeSet<Node> huffmanTree){

        TreeSet<Node> tree = huffmanTree;
        PriorityQueue<Node> nodeQueue = new PriorityQueue(tree);

        while(nodeQueue.size() > 1) {
            Node firstNode = nodeQueue.remove();
            Node secondNode = nodeQueue.remove();
            Node branchNode = new Node(firstNode,secondNode);
            nodeQueue.add(branchNode);
        }
        return nodeQueue.remove();

    }

    public BitSet getBitString(Node tree, String input){
        String bitString = "";
        int x = 0;
        int y = 1;
        try {
            for (char character : input.toCharArray()) {
                bitString += tree.findCharacter(character, "");
                x++;
                if(x >= 12000 * y){
                    y++;
                    System.out.println("countCheck " + x);
                }
            }
        }
        catch(CharNotFoundException e){
            System.out.println("Error, character was not found. Tree went wrong?");
        }
        return enCodeBitString(bitString);
    }

    private BitSet enCodeBitString(String bitString) {

        BitSet set = new BitSet();
        int x = 0;
        for(char character : bitString.toCharArray()){
            if(character == '1'){
                set.set(x);
            }
            x++;
        }
        set.set(x);
        return set;

    }

    public StringBuilder decodeBitString(BitSet encodedMessage, Node tree) {
        StringBuilder result = new StringBuilder();
        try {
            IntPointer intPointer = new IntPointer(0);
            while (encodedMessage.nextSetBit(0) >= 1) {
                result.append(String.valueOf(tree.findCharacter(encodedMessage, intPointer)));
            }
        } catch (NoNodeException e) {
            System.out.println("NoNodeDetected");
        }
        return result;
    }
}
