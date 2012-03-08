///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            Lemonade Stand
// Files:            LemonadeStand.java
// Semester:         Fall 2010
//
// Author:           Erin Rasmussen ejrasmussen2@wisc.edu
// CS Login:         rasmusse
// Lecturer's Name:  Jim Skrentny
// Lab Section:      313
//
//////////////////////////// 80 columns wide //////////////////////////////////


import java.util.Scanner;
import java.util.Random;
/**
 * This class performs a two week simulation of a lemonade stand
 * prompting the user to choose supplies based on prices and
 * daily sales are simulated based on weather.
 *
 * <p>Bugs: none known, not robust against non-integer input
 *
 * @author Erin Rasmussen
 */
public class LemonadeStand {
	/**
	  * Since this is a one method program, this method performs everything
	  * listed in the comment on the class.
	  */
	public static void main(String[] args) {
		
		//declare any variables
		Scanner stdIn = new Scanner(System.in);
		int money, unitsOfLemons, unitsOfSugar, lemonCost, sugarCost, possibleCups, seed;
		int lemonPurchase, sugarPurchase, spoiled, weather, customers, cupsSold, profit;
		/* money: the amount of money a player has, starts at 1000, always >= 0
		 * unitsOfLemons: total supply of lemons, >= 0
		 * unitsOfSugar: total supply of sugar, >= 0
		 * lemonCost: cost of lemons determined randomly, 15 to 35
		 * sugarCost: cost of sugar determined randomly, 15 to 25
		 * possibleCups: maximum cups based on lemon and sugar supply, >= 0
		 * seed: the seed obtained from the user to randomize the game
		 * lemonPurchase: amount of lemons purchased each day, >= 0
		 * sugarPurchase: amount of sugar purchased each day, >= 0
		 * spoiled: the amount of lemons spoiled (1/4 of remaining), >= 0
		 * weather: random integer to assign specific weather for a day, [0-3]
		 * customers: maximum amount of customers based on weather, 10, 20, 30, or 40
		 * cupsSold: amount of cups sold each day, 0 to 40
		 * profit: the amount of money made during each day of sales, >= 0
		 */
		money = 1000;
		unitsOfLemons = 0;
		unitsOfSugar = 0;


		//get seed value from user for creating random number generator
		System.out.println("Please enter a number to randomize the game: ");
		seed = stdIn.nextInt();
		Random rand = new Random(seed);

		//begin day loop
		for (int day = 1; day <= 14; day++){
			System.out.println("Day " + day);
			
			//print daily report
			System.out.println("Money: " + money);
			System.out.println("Lemons: " + unitsOfLemons);
			System.out.println("Sugar: " + unitsOfSugar + "\n");
			
			//generate cost of lemons and sugar
			lemonCost = rand.nextInt(21) + 15;
			sugarCost = rand.nextInt(11) + 15;
			System.out.println("The cost of lemons is " + lemonCost);
			System.out.println("The cost of sugar is " + sugarCost);

			//buy lemons
			System.out.println("Enter the amount of lemons you would like. The cost" +
					" is " + lemonCost + " per lemon.");
			lemonPurchase = stdIn.nextInt();
			while (money - (lemonPurchase * lemonCost) < 0 || lemonPurchase < 0) {
				//Previous statement was used to stop invalid input, negative money or supplies
				
				System.out.println("You can't purchase this many, please choose again.");
				lemonPurchase = stdIn.nextInt();
			}
			
			//update money and lemon supply
			unitsOfLemons = unitsOfLemons + lemonPurchase;
			money = money - (lemonCost * lemonPurchase);

			//print money supply
			System.out.println("After purchasing lemons, you have " + money + " in money.");

			//buy sugar
			System.out.println("Enter the amount of sugar you would like. The cost" +
					" is " + sugarCost + " per unit of sugar.");
			sugarPurchase = stdIn.nextInt();
			while (money - (sugarPurchase * sugarCost) < 0 || sugarPurchase < 0) {
				//Previous statement was used to stop invalid input, negative money or supplies
				
				System.out.println("You can't purchase this much, please choose again.");
				sugarPurchase = stdIn.nextInt();
			}
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
			//1 unit of sugar and lemons are required, the max. possible cups is the min. of the two
			
			//generate random weather
			weather = rand.nextInt(4);
			switch (weather) 
			{
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
				profit = 50 * cupsSold;
				money = money + profit;
			}
			else {
				cupsSold = customers;
				profit = customers * 50;
				money = money + profit;
			}
			//amount of cups sold is the minimum between possibleCups and customers
			
			
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
				spoiled = (unitsOfLemons / 4);
				unitsOfLemons = unitsOfLemons - spoiled;
				System.out.println("Due to spoilage, you lost " + spoiled + " lemons." + "\n");
			}
			else {
				System.out.println("You have no lemons left, therefore no spoilage has occured." + "\n");
			}
			//end day loop
		} //End for
		
		//print end-of-game report
		System.out.println("After 2 weeks of sales, you have " + money + " in money remaining" +
				", " + unitsOfLemons + " lemons remaining, and " + unitsOfSugar + " units of sugar remaining.");

	}

}
