package PerformanceTest;

import Classes.Manager;
import Classes.Node;

import java.util.BitSet;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Niels Verheijen on 02/04/2018.
 */
public class ManagerPerformance {
    private static final Logger logger = Logger.getLogger(Manager.class.getName());

    private Manager manager;
    private String tenThousandSize;
    private String millionSize;

    public ManagerPerformance(){

    }


    public static void main(String[] args){
        ManagerPerformance managerPerformance = new ManagerPerformance();
        managerPerformance.setUp();
    }

    private void setUp(){
        manager = new Manager();
        tenThousandSize = generateString(10000);
        millionSize = generateString(1000000);
        logger.log(Level.INFO,"\n-------------------------- \n Ten thousand words \n--------------------------");
        StartPerformanceTest(tenThousandSize, "Ten thousand");
        logger.log(Level.INFO,"\n-------------------------- \n Million words \n--------------------------");
        StartPerformanceTest(millionSize, "Million");

    }

    private String generateString(int numberOfWords){
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numberOfWords; i++)
        {
            String letter = Character.toString((char) (rnd.nextInt(74)+48));
            if(i%5 == 0){
                letter += " ";
            }
            sb.append(letter);
        }
        System.out.println(sb.length());
        return sb.toString();
    }

    private boolean StartPerformanceTest(String input, String numberOfWords){

        long startTime = System.nanoTime();
        Node tree = manager.getHoffmanTree(input);
        BitSet set = manager.getBitString(tree, input);

        long convertTime = System.nanoTime() - startTime;
        String logMessage = String.format( numberOfWords + " words - create tree and bitstring - Time measured: %d nanoseconds", convertTime);
        logger.log(Level.INFO, logMessage);

        long decodeStartTime = System.nanoTime();
        manager.decodeBitString(set,tree);
        long decodeTime = System.nanoTime() - decodeStartTime;
        logMessage = String.format( numberOfWords + " words - Decode bitstring - Time measured: %d nanoseconds", decodeTime);
        logger.log(Level.INFO, logMessage);

        long resultTime = decodeTime + convertTime;
        logMessage = String.format( numberOfWords + " words - Total time - Time measured: %d nanoseconds", resultTime);
        logger.log(Level.INFO, logMessage);
        return true;
    }
}
