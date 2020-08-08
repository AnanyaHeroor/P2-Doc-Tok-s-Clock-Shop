/*
* This class helps ensure that Doc Tok isn't making mistakes in his financial transactions
* @author Ananya Heroor
*/
public class Money{
    public static void main (String[] args){
// computeEmployeePaycheck(10, 10.0, 4);
// computeEmployeePaycheck(20, 8.5, 8);

// computeChangeWithFewestCoins(51);
// computeChangeWithFewestCoins(141);
// computeChangeWithFewestCoins(408);
// computeChangeWithFewestCoins(4);

// computeChangeFromSale(2,250,600);
// computeChangeFromSale(2,250,500);
// computeChangeFromSale(3,210,1000);

    }
/** 
* This function determines how much Doc Tok needs to actually pay his employees
* @param int numHours: number of hours they should be paid for
* @param double salary: amount to pay per hour (in dollars)
* @param int tax: percentage of their salary that goes to tax
* @return double equal to amount the employee should be paid based on the inputs
*/
    public static double computeEmployeePaycheck (int numHours, double salary, int tax){
       return((numHours*salary)*(1-((double)tax/100)));
    }
/** 
* This function makes change for a given amount of money in as few coins as possible
* @param int amount: amount of money to make change for (in cents)
* @return int number of coins needed
*/
    public static double computeChangeWithFewestCoins(int amount){
        int amountLeftToMakeChangeFor = amount;
        int numQuarters = amount/25;
        int change = amount%25;
        int numDimes = change/10;
        int newChange = change%10;
        int numNickels = newChange/5;
        int newNewChange = newChange%5;
        int numPennies = newNewChange/1;
        int totalCoins = amount/25 + change/10 + newChange/5 + newNewChange/1;
        System.out.println("Total coins: " + (int)totalCoins);
        System.out.println("Quarters: "+(int)numQuarters);
        System.out.println("Dimes: "+(int)numDimes);
        System.out.println("Nickels: "+(int)numNickels);
        System.out.println("Pennies: "+(int)numPennies+"\n");
        return(totalCoins);
   }
 /** 
* This function uses the change-making function to compute how much change Doc Tok needs to give a customer
* @param int numClocks: number of clocks sold
* @param int clockPrice: price of each clock (in cents)
* @param int amountPaid: amount of money the customer paid (in cents)
* @return int number of coins needed
*/
   public static int computeChangeFromSale (int numClocks, int clockPrice, int amountPaid){
       int difference = (((amountPaid)-(numClocks*clockPrice)));
       return((int)computeChangeWithFewestCoins(difference));
   }
}
