import java.util.*;
public class Chest{
    public static ArrayList<String> messages = new ArrayList<>();
    public static ArrayList<Integer> moneys = new ArrayList<>();
    public static ArrayList<Integer> positions = new ArrayList<>();
    public static void init()
    {
        messages.add("Advance to Go. Collect $200");
        moneys.add(0);
        positions.add(0);
        messages.add("Bank error in your favor. Collect $200");
        moneys.add(200);
        positions.add(-1);
        messages.add("Doctor's fee. Pay $50");
        moneys.add(-50);
        positions.add(-1);
        messages.add("From sale of stock you get $50");
        moneys.add(50);
        positions.add(-1);
        messages.add("Go To Jail");
        moneys.add(0);
        positions.add(10);
        messages.add("Holiday fund matures. Receive $100");
        moneys.add(100);
        positions.add(-1);
        messages.add("Income tax refund. Collect $20");
        moneys.add(20);
        positions.add(-1);
        messages.add("Life insurance matures. Collect $100");
        moneys.add(100);
        positions.add(-1);
        messages.add("Pay hospital fees of $100");
        moneys.add(-100);
        positions.add(-1);
        messages.add("Pay school fees of $50");
        moneys.add(-50);
        positions.add(-1);
        messages.add("You inherit $100");
        moneys.add(100);
        positions.add(-1);
        messages.add("You are assessed for street repair. $40 per house. $115 per hotel");
        moneys.add(0);
        positions.add(-1);
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
    public void doChest(Player p)
    {
        Random rand = new Random();
        int num = rand.nextInt(messages.size());
        System.out.println(messages.get(num));
        if(moneys.get(num)!=0)
        {
            p.money+=moneys.get(num);
        }
        else{
            if(positions.get(num)==0)
            {
                p.position=0;
                p.money+=200;
            }
            else if(positions.get(num)==10){
                p.inJail=true;
                p.position=10;
                if(Game.temp!=Game.playerNum){Game.playerNum=Game.temp;}
            }
            else{
                p.money-=(40*p.numHouses);
                p.money-=(115*p.numHotels);
            }
        }
    }
}
