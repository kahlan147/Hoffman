package Classes;

import java.io.*;
import java.util.BitSet;

/**
 * Created by Niels Verheijen on 02/04/2018.
 */
public class FileManager {

    public FileManager(){

    }

    public void writeToFile(BitSet encodedText, Node codeTree, File outputFile)
    {
        if (codeTree == null)
        {
            return;
        }

        try (FileOutputStream fos = new FileOutputStream(outputFile);
             ObjectOutputStream oos = new ObjectOutputStream(fos))
        {
            oos.writeObject(codeTree);
            oos.writeObject(encodedText);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    public Object[] readFromFile(File inputFile)
    {
        Object[] output = new Object[2];

        try (FileInputStream fis = new FileInputStream(inputFile);
             ObjectInputStream ois = new ObjectInputStream(fis))
        {
            output[0] = ois.readObject();
            output[1] = ois.readObject();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        return output;
    }
}
