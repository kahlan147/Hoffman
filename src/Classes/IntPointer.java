package Classes;

/**
 * Created by Niels Verheijen on 13/03/2018.
 */
public class IntPointer {

    public int location;

    public IntPointer(int location){
        this.location = location;
    }

    public void increase(){
        location++;
    }
}
