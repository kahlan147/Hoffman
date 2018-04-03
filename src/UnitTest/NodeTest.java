package UnitTest;

import Classes.CharNotFoundException;
import Classes.IntPointer;
import Classes.NoNodeException;
import Classes.Node;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.BitSet;

import static org.junit.Assert.*;

/**
 * Created by Niels Verheijen on 03/04/2018.
 */
public class NodeTest {

    private Node tree;
    private Node rightNode;

    @Before
    public void setUp() throws Exception {
        Node leftLeftNode = new Node('a',2);
        Node rightLeftNode = new Node('b',4);
        Node leftNode = new Node(leftLeftNode,rightLeftNode);
        rightNode = new Node('c',6);
        tree = new Node(leftNode,rightNode);
        /*
                ()
               /  \
             (c)  ()
                 /  \
               (a)  (b)
         */
    }

    @Test
    public void getCharacter() {
        Assert.assertEquals(rightNode.getCharacter(),new Character('c'));
    }

    @Test
    public void getFrequency() {
        Assert.assertEquals(rightNode.getFrequency(),6);
    }

    @Test
    public void findCharacter() throws CharNotFoundException {
            Assert.assertEquals(tree.findCharacter('a',""), "11");
            Assert.assertEquals(tree.findCharacter('b',""), "10");
            Assert.assertEquals(tree.findCharacter('c',""),"0");
            Assert.assertEquals(tree.findCharacter(null,""),"");
            Assert.assertEquals(tree.findCharacter('a', null),"null11");
        try{
            tree.findCharacter('d',"");
            Assert.assertTrue(false);
        }
        catch(CharNotFoundException exception){
            Assert.assertTrue(true);
        }
    }

    @Test
    public void findCharacterByBitSet() {

        BitSet a = new BitSet();
        a.set(0);
        a.set(1);

        BitSet b = new BitSet();
        b.set(0);
        b.set(2);

        BitSet c = new BitSet();
        c.set(1);

        BitSet d = new BitSet();
        d.set(0);
        d.set(1);
        d.set(2);
        d.set(3);


        Assert.assertEquals(tree.findCharacter(a,new IntPointer(0)),new Character('a'));
        Assert.assertEquals(tree.findCharacter(b,new IntPointer(0)),new Character('b'));
        Assert.assertEquals(tree.findCharacter(c,new IntPointer(0)),new Character('c'));
        Assert.assertNotEquals(tree.findCharacter(d,new IntPointer(0)), new Character('d'));

    }
}