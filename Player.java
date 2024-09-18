import java.util.*;
public class Player{
    public ArrayList<Property> properties = new ArrayList<>();
    public ArrayList<String> colorSets = new ArrayList<>();
    public String name;
    public boolean inJail = false;
    public int turnsInJail = 0;
    public int doublesInARow = 0;
    public int position=0;
    public int money = 1500;
    public int numUtilities = 0;
    public int numRailroads = 0;
    public boolean trip=false;
    public int numHouses=0;
    public int numHotels=0;
    public int purples=0;
    public int lightBlues=0;
    public int pinks=0;
    public int oranges=0;
    public int reds=0;
    public int yellows=0;
    public int greens=0;
    public int blues=0;
    public Player(String n)
    {
        name=n;
    }
}
