import java.util.*;
public class Dice{
    private boolean doubles=false;
    private int rollVal;
    public void roll(){
        doubles=false;
        Random rand = new Random();
        int dice1=rand.nextInt(6)+1;
        int dice2=rand.nextInt(6)+1;
        rollVal=dice1+dice2;
        if(dice1==dice2){doubles=true;}
        System.out.println("You rolled a " + dice1 + " and a " + dice2);
    }
    public boolean getDoubles()
    {
        return doubles;
    }
    public int getVal()
    {
        return rollVal;
    }
}
