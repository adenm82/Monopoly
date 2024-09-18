import java.util.*;
public class Game {
    public static ArrayList<Property> propList = new ArrayList<>();
    public static int[] railroadPrices = {0,25,50,100,200};
    public static String[] cols = {"Purple","Light Blue","Pink","Orange","Red","Yellow","Green","Blue"};
    public static ArrayList<String> colors = new ArrayList<>();
    public static int[] colNums = {2,3,3,3,3,3,3,2};
    public static ArrayList<Integer> colorNumbers = new ArrayList<>();
    public static int playerNum=0;
    public static int temp=0;
    public static void colorMethod()
    {
        for(int i=0;i<cols.length;i++)
        {
            colors.add(cols[i]);
        }
        for(int i=0;i<colNums.length;i++)
        {
            colorNumbers.add(colNums[i]);
        }
    }
    public static void main(String[] Args)
    {
        colorMethod();
        propList.add(new Property("GO",0,0,0,0,0,0,0,0,""));
        propList.add(new Property("Mediterranean Avenue",1,2,60,10,30,90,160,250,"Purple"));
        propList.add(new Property("Community Chest",2,0,0,0,0,0,0,0,""));
        propList.add(new Property("Baltic Avenue",3,4,60,20,60,180,320,450,"Purple"));
        propList.add(new Property("Income Tax",4,0,0,0,0,0,0,0,""));
        propList.add(new Property("Reading Railroad",5,0,200,0,0,0,0,0,""));
        propList.add(new Property("Oriental Avenue",6,6,100,30,90,270,400,550,"Light Blue"));
        propList.add(new Property("Chance",7,0,0,0,0,0,0,0,""));
        propList.add(new Property("Vermont Avenue",8,6,100,30,90,270,400,550,"Light Blue"));
        propList.add(new Property("Connecticut Avenue",9,8,120,40,100,300,450,600,"Light Blue"));
        propList.add(new Property("Jail",10,0,0,0,0,0,0,0,""));
        propList.add(new Property("St. Charles Place",11,10,140,50,150,450,625,750,"Pink"));
        propList.add(new Property("Electric Company",12,0,150,0,0,0,0,0,""));
        propList.add(new Property("States Avenue",13,10,140,50,150,450,625,750,"Pink"));
        propList.add(new Property("Virginia Avenue",14,12,160,60,180,500,700,900,"Pink"));
        propList.add(new Property("Pennslyvania Railroad",15,0,200,0,0,0,0,0,""));
        propList.add(new Property("St. James Place",16,14,180,70,200,550,750,950,"Orange"));
        propList.add(new Property("Community Chest",17,0,0,0,0,0,0,0,""));
        propList.add(new Property("Tennessee Avenue",18,14,180,70,200,550,750,950,"Orange"));
        propList.add(new Property("New York Avenue",19,16,200,80,220,600,800,1000,"Orange"));
        propList.add(new Property("Free Parking",20,0,0,0,0,0,0,0,""));
        propList.add(new Property("Kentucky Avenue",21,18,220,90,250,700,875,1050,"Red"));
        propList.add(new Property("Chance",22,0,0,0,0,0,0,0,""));
        propList.add(new Property("Indiana Avenue",23,18,220,90,250,700,875,1050,"Red"));
        propList.add(new Property("Illinois Avenue",24,20,240,100,300,750,925,1100,"Red"));
        propList.add(new Property("B and O Railroad",25,0,200,0,0,0,0,0,""));
        propList.add(new Property("Atlantic Avenue",26,22,260,110,330,800,975,1150,"Yellow"));
        propList.add(new Property("Ventnor Avenue",27,22,260,110,330,800,975,1150,"Yellow"));
        propList.add(new Property("Water Works",28,0,150,0,0,0,0,0,""));
        propList.add(new Property("Marvin Gardens",29,24,280,120,360,850,1025,1200,"Yellow"));
        propList.add(new Property("Go To Jail",30,0,0,0,0,0,0,0,""));
        propList.add(new Property("Pacific Avenue",31,26,300,130,390,900,1100,1275,"Green"));
        propList.add(new Property("North Carolina Avenue",32,26,300,130,390,900,1100,1275,"Green"));
        propList.add(new Property("Community Chest",33,0,0,0,0,0,0,0,""));
        propList.add(new Property("Pennslyvania Avenue",34,28,320,150,450,1000,1200,1400,"Green"));
        propList.add(new Property("Short Line Railroad",35,0,200,0,0,0,0,0,""));
        propList.add(new Property("Chance",36,0,0,0,0,0,0,0,""));
        propList.add(new Property("Park Place",37,35,350,175,500,1100,1300,1500,"Blue"));
        propList.add(new Property("Luxury Tax",38,0,0,0,0,0,0,0,""));
        propList.add(new Property("Boardwalk",39,50,400,200,600,1400,1700,2000,"Blue"));
        System.out.println("Welcome to Monopoly");
        ArrayList<Player> players = new ArrayList<>();
        int[] propSpaces = {1,3,6,8,9,11,13,14,16,18,19,21,23,24,26,27,29,31,32,34,37,39};
        ArrayList<Integer> spaces = new ArrayList<>();
        for(int i : propSpaces)
        {
            spaces.add(i);
        }
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("How many players? (2-6) ");
        int numPlayers=scan.nextInt();
        scan.nextLine();
        System.out.println("Enter all player names");
        for(int i=0;i<numPlayers;i++)
        {
            players.add(new Player(scan.nextLine()));
        }
        Dice dice = new Dice();
        Chest chest = new Chest();
        chest.init();
        Chance chance = new Chance();
        chance.init();
        Player currPlayer=players.get(0);
        int roll=0;
        int mon=0;
        String input="";
        Property currProp=propList.get(0);
        while(players.size()>1){
            if(playerNum>=players.size()){playerNum=0;}
            currPlayer=players.get(playerNum);
            int position = currPlayer.position;
            temp=playerNum;
            String ent="";
            System.out.println(currPlayer.name + "'s turn");
            System.out.println("Current space: " + propList.get(position).name);
            System.out.println("Your current money is $" + currPlayer.money);
            if(currPlayer.properties.size()==0){System.out.println("No properties owned yet. Get buying!");}
                else{
                    System.out.println("Properties Owned: ");
                    for(int i=0;i<currPlayer.properties.size();i++)
                    {
                        System.out.println(currPlayer.properties.get(i).name);
                    }
                }
            if(currPlayer.colorSets.size()>0){
                System.out.println("To buy houses/hotels, type 'house', else type 'no'");
                if(scan.next().indexOf("h")!=-1){house(currPlayer);}
            }
            if(currPlayer.inJail){jail(currPlayer);}
            else{
                System.out.println("Press any key to roll");
                ent=scan.next();
                dice.roll();
                roll = dice.getVal();
                currPlayer.position+=roll;
                if(dice.getDoubles()){
                    currPlayer.doublesInARow++;
                    if(currPlayer.doublesInARow==3){
                        System.out.println("Three doubles in a row! Go to Jail!");
                        currPlayer.trip=true;
                    }
                    else{System.out.println("Doubles! Extra turn"); playerNum--; currPlayer.trip=false;}
                }
                else{currPlayer.doublesInARow=0; currPlayer.trip=false;}
                if(currPlayer.trip==false){
                    if(currPlayer.position>40){currPlayer.position-=40; currPlayer.money+=200; System.out.println("Passed GO");}
                    if(currPlayer.position==40){currPlayer.position=0; currPlayer.money+=200;}
                    currProp=propList.get(currPlayer.position);
                    System.out.println("You landed on " + currProp.name);
                    if(currPlayer.position==38){currPlayer.money-=75;}
                    if(currPlayer.position==4){
                        if(currPlayer.money<2000)
                        {
                            int t = currPlayer.money/10;
                            System.out.println("You pay a 10% income tax of $" + t);
                            currPlayer.money-=t;
                        }
                        else{System.out.println("You pay an income tax of $200"); currPlayer.money-=200;}
                    }
                    if(currPlayer.position==30)
                    {
                        currPlayer.inJail=true; currPlayer.position=10;
                        if(temp!=playerNum){playerNum=temp;}
                    }
                    if(currProp.isRailroad)
                    {
                        if(currProp.isOwned)
                        {
                            if(currProp.owner!=currPlayer)
                            {
                                owe(currPlayer,currProp,1);
                            }
                        }
                        else{
                            propBuy(currPlayer, currProp);
                        }
                    }
                    if(currProp.isUtility)
                    {
                        if(currProp.isOwned)
                        {
                            if(currProp.owner!=currPlayer)
                            {
                                if(currProp.owner.numUtilities==1)
                                {
                                    owe(currPlayer,currProp,4);
                                }
                                else{
                                    owe(currPlayer,currProp,10);
                                }
                            }
                        }
                        else{
                            propBuy(currPlayer,currProp);
                        }
                    }
                    if(spaces.contains(currPlayer.position))
                    {
                        if(currProp.isOwned)
                        {
                            if(currProp.owner!=currPlayer)
                            {
                                if(currProp.owner.colorSets.contains(currProp.color) && currProp.houses==0)
                                {
                                    owe(currPlayer,currProp,2);
                                }
                                else{
                                    owe(currPlayer,currProp,1);
                                }
                            }
                        }
                        else{
                            propBuy(currPlayer,currProp);
                        }
                    }
                    if(currProp.name=="Chance")
                    {
                        chance.doChance(currPlayer);
                    }
                    if(currProp.name=="Community Chest")
                    {
                        chest.doChest(currPlayer);
                    }
                }
                else{currPlayer.position=10; currPlayer.inJail=true;}
            }
            if(currPlayer.money<0){
                System.out.println(currPlayer.name + " is bankrupt!");
                players.remove(temp);
            }
            else{playerNum++; 
            }
            System.out.println("Your current money is $" + currPlayer.money);
            System.out.println("Press any key to end your turn");
            ent=scan.next();
            System.out.println("------------------------------------------------------------------------------");
        }
        System.out.println("The winner is " + players.get(0).name + "!");
    }
    public static void sortProps(Player p)
    {
        ArrayList<Property> newList = new ArrayList<>();
        for(int i=0;i<propList.size();i++)
        {
            if(p.properties.contains(propList.get(i)))
            {
                newList.add(propList.get(i));
            }
        }
        p.properties=newList;
    }
    public static void house(Player p)
    {
        Scanner scan = new Scanner(System.in);
        int h=0;
        ArrayList<Property> poss = new ArrayList<>();
        Property pr=new Property();
        if(p.colorSets.size()==0){System.out.println("You cannot buy houses, you must obtain a full color set");}
        else{
            for(int i=0;i<propList.size();i++)
            {
                if(p.colorSets.contains(propList.get(i).color)){poss.add(propList.get(i));}
            }
            int i=0;
            String e="";
            while(i<poss.size())
            {
                pr=poss.get(i);
                System.out.println("Type 'yes' to buy houses at " + pr.name + ", else type 'no'");
                e=scan.next();
                if(e.indexOf("y")!=-1)
                {
                    if(pr.houses>=5){System.out.println("You cannot place another house here. There is already a hotel"); i++;}
                    else{
                        if(p.money<pr.housePrice){System.out.println("You are too poor to put a house here"); i++;}
                        else{
                            System.out.println("There are currently " + pr.houses + " houses on " + pr.name);
                            System.out.println("Type the number of houses you wish to put on " + pr.name);
                            h=scan.nextInt();
                            while(pr.houses+h>5 || h<=0 || p.money<(h*pr.housePrice)){h=scan.nextInt(); scan.nextLine();}
                            pr.houses+=h;
                            p.money-=h*pr.housePrice;
                            if(pr.houses==5){System.out.println("There is now a hotel on " + pr.name); pr.rent=pr.hotel; p.numHotels++;}
                            else{
                                System.out.println("There are now " + pr.houses + " houses on " + pr.name);
                                if(pr.houses==1){pr.rent=pr.house1;}
                                else if(pr.houses==2){pr.rent=pr.house2;}
                                else if(pr.houses==3){pr.rent=pr.house3;}
                                else if(pr.houses==4){pr.rent=pr.house4;}
                                p.numHouses+=h;
                            }
                            System.out.println("Current rent on " + pr.name + ": $" + pr.rent);
                            i++;
                        }    
                    }
                }
                else if(e.indexOf("n")!=-1){i++;}
            }
        }
    }
    public static void propBuy(Player p, Property prop){
        Scanner scan = new Scanner(System.in);
        if(p.money>=prop.price){
            System.out.println("Type yes to buy for $" + prop.price + ", else type no");
            String out = scan.nextLine();
            if(out.indexOf("y")!=-1)
            {
                System.out.println("Bought for $" + prop.price);
                p.money-=prop.price;
                p.properties.add(prop);
                sortProps(p);
                prop.owner=p;
                prop.isOwned=true;
                if(prop.pos==5 || prop.pos==15 || prop.pos==25 || prop.pos==35)
                {
                    p.numRailroads++;
                }
                else if(prop.pos==12 || prop.pos==28)
                {
                    p.numUtilities++;
                }
                else{
                    int needColors=colorNumbers.get(colors.indexOf(prop.color));
                    if(prop.color=="Purple")
                    {
                        p.purples++;
                        if(p.purples==needColors)
                        {
                            System.out.println(p.name + " has acquired a full set of purple properties. Rent is double!");
                            p.colorSets.add("Purple");
                        }
                    }
                    else if(prop.color=="Light Blue")
                    {
                        p.lightBlues++;
                        if(p.lightBlues==needColors)
                        {
                            System.out.println(p.name + " has acquired a full set of light blue properties. Rent is double!");
                            p.colorSets.add("Light Blue");
                        }
                    }
                    else if(prop.color=="Pink")
                    {
                        p.pinks++;
                        if(p.pinks==needColors)
                        {
                            System.out.println(p.name + " has acquired a full set of pink properties. Rent is double!");
                            p.colorSets.add("Pink");
                        }
                    }
                    else if(prop.color=="Orange")
                    {
                        p.oranges++;
                        if(p.oranges==needColors)
                        {
                            System.out.println(p.name + " has acquired a full set of orange properties. Rent is double!");
                            p.colorSets.add("Orange");
                        }
                    }
                    else if(prop.color=="Red")
                    {
                        p.reds++;
                        if(p.reds==needColors)
                        {
                            System.out.println(p.name + " has acquired a full set of red properties. Rent is double!");
                            p.colorSets.add("Red");
                        }
                    }
                    else if(prop.color=="Yellow")
                    {
                        p.yellows++;
                        if(p.yellows==needColors)
                        {
                            System.out.println(p.name + " has acquired a full set of yellow properties. Rent is double!");
                            p.colorSets.add("Yellow");
                        }
                    }
                    else if(prop.color=="Green")
                    {
                        p.greens++;
                        if(p.greens==needColors)
                        {
                            System.out.println(p.name + " has acquired a full set of green properties. Rent is double!");
                            p.colorSets.add("Green");
                        }
                    }
                    else{
                        p.blues++;
                        if(p.blues==needColors)
                        {
                            System.out.println(p.name + " has acquired a full set of blue properties. Rent is double!");
                            p.colorSets.add("Blue");
                        }
                    }
                }
            }
        }
        else{
            System.out.println("You do not have enough money to buy this property");
        }
    }
    public static void owe(Player currPlayer, Property currProp, int mult)
    {
        Dice dice = new Dice();
        Scanner scan = new Scanner(System.in);
        if(currProp.isRailroad)
        {
            int mon=0;
            System.out.println("Owned by " + currProp.owner.name);
            System.out.println("Since " + currProp.owner.name + " has " + currProp.owner.numRailroads + " railroads, you must pay $" + mult*railroadPrices[currProp.owner.numRailroads]);
            mon=railroadPrices[currProp.owner.numRailroads];
            currPlayer.money-=mon;
            propList.get(currPlayer.position).owner.money+=mon;
        }
        else if(currProp.isUtility)
        {
            String ent = "";
            System.out.println("Roll 2 dice, pay owner " + mult + "times the value");
            System.out.println("Press any key to roll");
            ent=scan.next();
            dice.roll();
            System.out.println("You owe " + currProp.owner.name + " $" + mult*dice.getVal());
            currPlayer.money-=mult*dice.getVal();
            currProp.owner.money+=mult*dice.getVal();
        }
        else{
            System.out.println("Owned by " + currProp.owner.name);
            System.out.println("You owe $" + currProp.rent*mult);
            currPlayer.money-=currProp.rent*mult;
            currProp.owner.money+=currProp.rent*mult;
        }
    }
    public static void jail(Player p){
        Scanner scan = new Scanner(System.in);
        String op="";
        System.out.println("You are in jail. Type 'roll' to roll three times to get doubles or type 'pay' to pay $50");
        op=scan.nextLine();
        if(op.indexOf("r")!=-1 || p.money<50){
            Dice dice1 = new Dice();
            dice1.roll();
            if(dice1.getDoubles()){System.out.println("You got out of jail!"); p.inJail=false;}
            else{
                Dice dice2 = new Dice();
                dice2.roll();
                if(dice2.getDoubles()){System.out.println("You got out of jail!"); p.inJail=false;}
                else{
                    Dice dice3 = new Dice();
                    dice3.roll();
                    if(dice3.getDoubles()){System.out.println("You got out of jail!"); p.inJail=false;}
                    else{System.out.println("You are still in jail");}
                }
            }
        }
        else{System.out.println("You paid $50 to get out of jail"); p.money-=50; p.inJail=false;}
    }
}
