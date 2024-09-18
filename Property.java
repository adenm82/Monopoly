import java.util.*;
public class Property{
    public String name;
    public String color="";
    public int price;
    public int pos;
    public int housePrice;
    public boolean isOwned;
    public int playerOwned=0;
    public int houses=0;
    public int rent;
    public int house1;
    public int house2;
    public int house3;
    public int house4;
    public int hotel;
    public Player owner;
    public boolean isRailroad=false;
    public boolean isTax=false;
    public boolean isUtility=false;
    public Property(String name, int pos, int rent, int price, int house1, int house2, int house3, int house4,
	                int hotel, String color) {
		this.rent = rent;
		this.house1 = house1;
		this.house2 = house2;
		this.house3 = house3;
		this.house4 = house4;
		this.hotel = hotel;
		this.price = price;
		owner = new Player(null);
		houses=0;
		this.pos = pos;
		this.name = name;
		this.color=color;
		isOwned = false;
		if(pos%5==0 && pos%10!=0){isRailroad=true;}
		if(pos==4 || pos==38){isTax=true;}
		if(pos==12 || pos==28){isUtility=true;}
		if(color=="Purple" || color=="Light Blue"){housePrice=50;}
		else if(color=="Pink" || color=="Orange"){housePrice=100;}
		else if(color=="Red" || color=="Yellow"){housePrice=150;}
		else if(color=="Green" || color=="Blue"){housePrice=200;}
		else{housePrice=0;}
	}
	public Property()
	{
	    name="Hello this is not a real property. How did you get here?";
	}
}
