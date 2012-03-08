import java.util.Scanner;
import java.util.Random;
public class LemonadeStand2 {

	public static void main(String[] args) {
//declare any variables
	Scanner stdIn = new Scanner(System.in);
	int money, unitsOfLemons, unitsOfSugar, day, lemonCost, sugarCost, possibleCups;
	int lemonPurchase, sugarPurchase, totalPurchase, weather, customers, cupsSold, profit, n, seed;
	money = 1000;
	Random rand = new Random();
	unitsOfLemons = 0;
	unitsOfSugar = 0;
	day = 1;

	//get seed value from user for creating random number generator
	while (day <= 14) {
		System.out.println("Please enter a number to randomize the game: ");
		n = stdIn.nextInt();
		seed = rand.nextInt(n);
	
	//begin day loop
	
			//print daily report
	
		System.out.println("This is day " + day + " of Lemonade Stand. You have:");
		System.out.println("Money: " + money);
		System.out.println("Lemons: " + unitsOfLemons);
		System.out.println("Sugar: " + unitsOfSugar);
	
			//generate cost of lemons and sugar
	
		lemonCost = rand.nextInt(21) + 15;
		sugarCost = rand.nextInt(11) + 15;
		System.out.println("The cost of lemons is " + lemonCost);
		System.out.println("The cost of sugar is " + sugarCost);
	
			//buy lemons
	
		System.out.println("Enter the amount of lemons you would like. The cost" +
				" is " + lemonCost + " per lemon.");
		lemonPurchase = stdIn.nextInt();
	
			//update money and lemon supply
	
		unitsOfLemons = unitsOfLemons + lemonPurchase;
		money = money - (lemonCost * lemonPurchase);
	
			//print money supply
	
		System.out.println("After purchasing lemons, you have " + money + " in money.");
	
			//buy sugar
	
		System.out.println("Enter the amount of sugar you would like. The cost" +
				" is " + sugarCost + " per unit of sugar.");
		sugarPurchase = stdIn.nextInt();
	
			//update money and sugar supply
	
		unitsOfSugar = unitsOfSugar + sugarPurchase;
		money = money - (sugarCost * sugarPurchase);
	
			//print money supply
	
		System.out.println("After purchasing sugar, you have " + money + " in money.");
	
			
			//measure supplies and print number of cups possible
		if (unitsOfSugar <= unitsOfLemons){
			possibleCups = unitsOfSugar;
		}
		else {
			possibleCups = unitsOfLemons;
		}
			//generate random weather
	weather = rand.nextInt(4);
		switch (weather) {
		case 0: System.out.println("Today's weather is cool.");
 				customers = 10; break;
		case 1: System.out.println("Today's weather is average.");
 				customers = 20; break;
		case 2: System.out.println("Today's weather is warm.");
 				customers = 30; break;
		case 3: System.out.println("Today's weather is hot.");
 				customers = 40; break;
 		default: customers = 0; break;
		}
	
		
			//calculate cups sold
		if (possibleCups <= customers){
			cupsSold = possibleCups;
			profit = customers * cupsSold;
			money = money + profit;
		}
		else {
			cupsSold = customers;
			profit = customers * cupsSold;
			money = money + profit;
		}
			//update lemon and sugar supply based on cups sold
		
			unitsOfLemons = unitsOfLemons - cupsSold;
			unitsOfSugar = unitsOfSugar - cupsSold;
		
			
			//report cups sold and money made
		
			System.out.println("Today you sold " + cupsSold + " cups of lemonade and" +
					" made " + profit + " in money.");
		
			//update money supply
		
			System.out.println("You have " + money + " in money after day " + day + ".");
		
			
			//compute supply of lemons spoiled, print message and update supply
		if (unitsOfLemons != 0){
			unitsOfLemons = (unitsOfLemons / 4);
			System.out.println("Due to spoilage, you know have " + unitsOfLemons + " lemons" +
					" remaining.");
		}
		else {
			System.out.println("You have no lemons left, therefore no spoilage has occured.");
		}
			//end day loop
		if (day < 14) {
			day++;
		}
		//print end-of-game report
		else {
			day = 15;
			System.out.println("After 2 weeks of sales, you have " + money + " in money remaining" +
					", " + unitsOfLemons + " lemons remaining, and " + unitsOfSugar + " units of sugar remaining.");
		}
	}  //End while
	}

}
