package Classes;

import java.io.*;
import java.util.*;

/**
 * Created by Niels Verheijen on 27/02/2018.
 */
public class Application {

    //The quick brown fox jumps over the lazy dog
    public static void main(String[] args){
        Manager manager = new Manager();
        FileManager fileManager = new FileManager();
        File file = new File("../Huffman.txt");

        try {
            System.out.println("Enter 1 to enter a text, enter anything else to read");
            if(new BufferedReader(new InputStreamReader(System.in)).readLine().equals("1")) {
                BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Please, enter a sentence: ");
                String input = bufferReader.readLine();
                Node tree = manager.getHoffmanTree(input);
                BitSet set = manager.getBitString(tree, input);
                System.out.println("bitstring: " + set);
                fileManager.writeToFile(set, tree, file);
            }
            else {
                Object[] test = fileManager.readFromFile(file);
                Node tree = (Node)test[0];
                BitSet encodedMessage = (BitSet)test[1];

                StringBuilder result = manager.decodeBitString(encodedMessage,tree);
                String endResult = result.toString().substring(0, result.length()-1);

                System.out.println("Result: " + endResult);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
