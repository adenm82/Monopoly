import java.util.*;
public class Chance{
    public static ArrayList<String> messages = new ArrayList<>();
    public static ArrayList<Integer> moneys = new ArrayList<>();
    public static ArrayList<Integer> positions = new ArrayList<>();
    public static ArrayList<Property> properties = new ArrayList<>();
    public static void init()
    {
        messages.add("Advance to Boardwalk");
        moneys.add(0);
        positions.add(39);
        properties.add(Game.propList.get(39));
        messages.add("Advance to Go. Collect $200");
        moneys.add(0);
        positions.add(0);
        properties.add(Game.propList.get(0));
        messages.add("Advance to Illinois Avenue");
        moneys.add(0);
        positions.add(24);
        properties.add(Game.propList.get(24));
        messages.add("Bank pays you divdend of $50");
        moneys.add(50);
        positions.add(-1);
        properties.add(new Property());
        messages.add("Go To Jail");
        moneys.add(0);
        positions.add(10);
        properties.add(new Property());
        messages.add("Take a trip to Reading Railroad. If you pass Go, collect $200.");
        moneys.add(0);
        positions.add(5);
        properties.add(Game.propList.get(5));
        messages.add("Your building loan matures. Collect $150");
        moneys.add(150);
        positions.add(-1);
        properties.add(new Property());
        messages.add("Advance to St. Charles Place. If you pass Go, collect $200.");
        moneys.add(0);
        positions.add(11);
        properties.add(Game.propList.get(11));
        messages.add("Advance token to nearest Utility. If unowned, you may buy it from the Bank. If owned, throw dice and pay owner a total ten times amount thrown.");
        moneys.add(0);
        positions.add(-1);
        properties.add(new Property());
        messages.add("Advance token to nearest Railroad. If unowned, you may buy it from the Bank. If owned, pay owner a total twice the amount owed.");
        moneys.add(0);
        positions.add(-1);
        properties.add(new Property());
        messages.add("Make general repairs on all your property. For each house pay $25. For each hotel pay $100.");
        moneys.add(0);
        positions.add(-1);
        properties.add(new Property());
    }
    public int money(int i)
    {
        return moneys.get(i);
    }
    public String message(int i){return messages.get(i);}
    public int position(int i)
    {
        return positions.get(i);
    }
    public void doChance(Player p)
    {
        Random rand = new Random();
        int num = rand.nextInt(messages.size());
        System.out.println(messages.get(num));
        if(moneys.get(num)!=0)
        {
            p.money+=moneys.get(num);
        }
        else if(positions.get(num)==10){
            p.inJail=true;
            p.position=10;
            if(Game.temp!=Game.playerNum){Game.playerNum=Game.temp;}
        }
        else if(positions.get(num)==0)
        {
            p.money+=200;
            p.position=0;
        }
        else if(num==8)
        {
            boolean elec=false;
            String ent="";
            Scanner scan = new Scanner(System.in);
            Dice dice = new Dice();
            Property currProp = new Property();
            if(p.position>=0 && p.position>12)
            {
                elec=true;
            }
            else if(p.position>=28)
            {
                elec=true;
                p.money+=200;
                System.out.println("Passed GO");
            }
            if(elec){currProp=Game.propList.get(12); System.out.println("You advanced to Electric Company");}
            else{currProp=Game.propList.get(28); System.out.println("You advanced to Water Works");}
            if(currProp.isOwned)
            {
                if(currProp.owner!=p)
                {
                    Game.owe(p,currProp,10);
                }
            }
            else{
                Game.propBuy(p,currProp);
            }
        }
        else if(num==9)
        {
            int n=p.position;
            Property currProp = new Property();
            while(n!=5 && n!=15 && n!=25 && n!=35)
            {
                n++;
                if(n>=40){System.out.println("Passed GO"); p.money+=200; n=0;}
            }
            p.position=n;
            if(n==5){System.out.println("You advanced to Reading Railroad"); currProp=Game.propList.get(5);}
            else if(n==15){System.out.println("You advanced to Pennslyvania Railroad"); currProp=Game.propList.get(15);}
            else if(n==25){System.out.println("You advanced to B and O Railroad"); currProp=Game.propList.get(25);}
            else{System.out.println("You advanced to Short Line Railroad"); currProp=Game.propList.get(35);}
            if(currProp.isOwned)
            {
                if(currProp.owner!=p)
                {
                    Game.owe(p,currProp,2);
                }
            }
            else{
                Game.propBuy(p, currProp);
            }
        }
        else if(num==10)
        {
            p.money-=(25*p.numHouses);
            p.money-=(100*p.numHotels);
        }
        else{
            Property currProp = properties.get(num);
            int pos = positions.get(num);
            if(p.position>=pos)
            {
                System.out.println("Passed GO");
                p.money+=200;
            }
            p.position=positions.get(num);
            if(currProp.isRailroad)
            {
                if(currProp.isOwned)
                {
                    if(currProp.owner!=p)
                    {
                        Game.owe(p,currProp,1);
                    }
                }
                else{
                    Game.propBuy(p, currProp);
                }
            }
            else{
                if(currProp.isOwned)
                {
                    if(currProp.owner!=p)
                    {
                        Game.owe(p,currProp,1);
                    }
                }
                else{
                    Game.propBuy(p,currProp);
                }
            }
        }
    }
}
