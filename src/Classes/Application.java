package Classes;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by Niels Verheijen on 27/02/2018.
 */
public class Application {

    //The quick brown fox jumps over the lazy dog
    public static void main(String[] args){
        Manager manager = new Manager();

        try {
            BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please, enter a sentence: ");
            String input = bufferReader.readLine();
            TreeSet tree = manager.getHoffmanTree(input);
            String test = "test";


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
