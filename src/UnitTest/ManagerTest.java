package UnitTest;

import Classes.IntPointer;
import Classes.Manager;
import Classes.NoNodeException;
import Classes.Node;
import org.junit.Assert;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by Niels Verheijen on 02/04/2018.
 */
public class ManagerTest {

    private Manager manager;

    private String testString = "The quick brown fox jumps over the lazy dog";

    @org.junit.Before
    public void setUp() throws Exception {
        manager = new Manager();
    }

    @org.junit.Test
    public void getHoffmanTree() {
        Node tree = manager.getHoffmanTree(testString);
        Assert.assertEquals(tree.getFrequency(),43);
    }

    @org.junit.Test
    public void getBitString() {
        Node tree = manager.getHoffmanTree(testString);
        BitSet set = manager.getBitString(tree,testString);
        Assert.assertEquals(set.length(),195);
    }

    @org.junit.Test
    public void decodeBitString(){
        Node tree = manager.getHoffmanTree(testString);
        BitSet set = manager.getBitString(tree,testString);
        StringBuilder result = manager.decodeBitString(set,tree);
        Assert.assertEquals(result.toString().substring(0,result.length()-1), testString);

    }


}