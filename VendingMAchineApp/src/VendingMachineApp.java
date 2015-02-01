import java.util.Scanner;
public class VendingMachineTest 
{
	public static void main(String[]args)
	{
		System.out.println("Here is the list of products and their prices");
		System.out.println("1. Gum.	Value: 41 cents");
		System.out.println("2. Cheetos.	Value: 52 cents");
		System.out.println("3. Twinkie.  Value: 76 cents");
		System.out.println("4. Pretzels.  Value: 87 cents");
		System.out.println("5. Poptarts.  Value: 135 cents");
		System.out.println();
		
		payment();
		buy();
		change();
		info();
		
	}
	static int balance = 0, coins, item, bills, cost = 0, change = 0, options;
	static Scanner keyboard = new Scanner(System.in);
	public static void payment()
	{
		
		do
		{
			System.out.println("Please select payment method");
			System.out.println("Enter 1 to pay by coins.");
			System.out.println("Enter 2 to pay by bills.");
			System.out.printf("Total Balance: %d cents %n", balance);
			System.out.println("To finish payment, enter 0");
			options = keyboard.nextInt();
			
			if (options == 0)
			{
				break;
			}
			else if (options == 1)
			{
				System.out.println("You have chosen to pay by coins.");
				System.out.println("If you don't want to pay by coins, then press 0 and select appropriate payment method.");
				System.out.println("Only numbers (25, 10, 5, or 1) are valid inputs for coins.");
				System.out.println("Please enter amount");
					do
					{
						coins = keyboard.nextInt();
						switch(coins)
						{
						case 0:
							break;
						case 1:
							balance += 1;
							System.out.printf("Total Balance: %d cents %n", balance);
							System.out.println("Enter 0 when you are done paying.");
							break;
						case 5:
							balance += 5;
							System.out.printf("Total Balance: %d cents %n", balance);
							System.out.println("Enter 0 when you are done paying.");
							break;
						case 10:
							balance += 10;
							System.out.printf("Total Balance: %d cents %n", balance);
							System.out.println("Enter 0 when you are done paying.");
							break;
						case 25:
							balance += 25;
							System.out.printf("Total Balance: %d cents %n", balance);
							System.out.println("Enter 0 when you are done paying.");
							break;
							default:
								System.out.println("Only numbers (25, 10, 5, or 1) are valid inputs.");
						}
					} while(coins != 0);
				
			}
			else if (options == 2)
			{
				System.out.println("You have chosen to pay by bills.");
				System.out.println("If you don't want to pay by bills, then press 0 and select appropriate payment method.");
				System.out.println("Only enter the bills value in coins (Only 5 dollar and 1 dollar bills are accepted).");
				System.out.println("Please enter amount");
				do
				{
					bills = keyboard.nextInt();
					switch(bills)
					{
					case 0:
						break;
					case 100:
						balance += 100;
						System.out.printf("Total Balance: %d cents %n", balance);
						System.out.println("Enter 0 when you are done paying.");
						break;
					case 500:
						balance += 500;
						System.out.printf("Total Balance: %d cents %n", balance);
						System.out.println("Enter 0 when you are done paying.");
						break;
						default:
							System.out.println("Only numbers (500 and 100) are valid inputs.");
					}
				}while(bills != 0);
				
			}
		}while(options != 0);
	}
	public static void buy ()
	{
		System.out.println("Here is the list of items and their prices");
		System.out.println("Enter 1 for Gum. Value: 41 cents");
		System.out.println("Enter 2 for Cheetos. Value: 52 cents");
		System.out.println("Enter 3 for Twinkie. Value: 76 cents");
		System.out.println("Enter 4 for Pretzels. Value: 87 cents");
		System.out.println("Enter 5 for Poptarts. Value: 135 cents");
		System.out.println();
		System.out.printf("Total Balance: %d cents %n", balance);
		System.out.println("Select the item you would like to purchase (Enter 0 to end purchase).");
		item = keyboard.nextInt();
		
		switch(item)
		{
		case 0:
			System.out.println("You have cancelled purchase");
			break;
		case 1:
			cost += 41;
			break;
		case 2:
			cost += 52;
			break;
		case 3:
			cost += 76;
			break;
		case 4:
			cost += 87;
			break;
		case 5:
			cost += 135;
			break;
			default:
				System.out.println("Error");
				break;
		}
	}
	public static String CoinCalculator(int coinsleft)
	{
		String changeLeft = "";
		int quarters, quartersLeft=0;
		int dimes, dimesLeft=0;
		int nickels, nickelsLeft=0;
		int pennies;
		
		quarters = change/25;
		quartersLeft = change%25;
		changeLeft += quarters + " quarter(s)\n";
		
		if(quartersLeft !=0)
		{
			dimes = quartersLeft/10;
			dimesLeft = quartersLeft%10;
			changeLeft += dimes +" dime(s)\n";
		}
		if(dimesLeft !=0)
		{
			nickels = dimesLeft/5;
			nickelsLeft = dimesLeft%5;
			changeLeft += nickels + " nickel(s)\n";
		}
		if(nickelsLeft != 0)
		{
			pennies = nickelsLeft/1;
			changeLeft += pennies + " penny{ies)\n";
		}
		return changeLeft;
		
	}
	public static String change()
	{
		String changeLeft="";
		if (balance >= cost)
		{
			change = balance - cost;
			changeLeft = CoinCalculator(change);
		}
		else
		{
			changeLeft = "You need more money in order to purchase this item.";
		}
		return changeLeft;
	}
	public static void info()
	{
		System.out.printf("Balance: %s cents %n", balance);
		System.out.printf("Cost: %d cents %n", cost);
		System.out.printf("Change: %n%s %n", change());
	}	
}
