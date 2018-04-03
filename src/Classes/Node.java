package Classes;

import java.io.Serializable;
import java.util.BitSet;

/**
 * Created by Niels Verheijen on 06/03/2018.
 */
public class Node implements Serializable {
    private int frequency;
    private Character character;

    private Node leftNode;
    private Node rightNode;

    public Node( Character character, int frequency){
        this.frequency = frequency;
        this.character = character;
    }

    public Node(Node leftNode, Node rightNode){
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.frequency = leftNode.getFrequency() + rightNode.getFrequency();
    }

    public Character getCharacter(){
        return character;
    }

    public int getFrequency(){
        return frequency;
    }

    public String findCharacter(Character character, String bitString)throws CharNotFoundException{

        if(this.character == character){
            return bitString;
        }
        if(this.character != null){
            throw new CharNotFoundException();
        }
        try{
            String test = bitString + "1";
            return leftNode.findCharacter(character,test);
        }
        catch(CharNotFoundException e){
            String test = bitString + "0";
            return rightNode.findCharacter(character,test);
        }
    }

    public Character findCharacter(BitSet set, IntPointer location){

        if(character == null) {
            if (set.get(location.location)) {
                set.clear(location.location);
                location.increase();
                return leftNode.findCharacter(set, location);
            }
            else {
                location.increase();
                return rightNode.findCharacter(set, location);
            }
        }
        return this.character;
    }
}
