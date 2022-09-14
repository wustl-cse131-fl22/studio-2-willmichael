package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		double currentAmount;
		double winChance;
		double winLimit;
		int totalSimulationTimes;
		double expectedRuin;
		
		System.out.println("What is your starting money?");
		currentAmount = scan.nextDouble();
		double onHand = currentAmount;
		
		System.out.println("What is the win chance of the casino?");
		winChance = scan.nextDouble();
		winChance= winChance/100;
		
		System.out.println("How much money do you want to reach?");
		winLimit = scan.nextDouble();
		
		System.out.println("How many times do you want to simulate?");
		totalSimulationTimes = scan.nextInt();
		double a = (1-winChance)/winChance;
		
		boolean win = false;
		String winlose = "";
		int numWins = 0;
		int numLoses = 0;
		for(int i=0;i<=totalSimulationTimes;i++) {
			
			int count = 0;
			onHand = currentAmount;
			
			while(onHand<winLimit && onHand > 0) {
				double rand = Math.random();
				if(rand<=winChance) {
					onHand++;
					
				
				
				} else {
					onHand--;
				}
				count++;
				//System.out.println("onHand: " +onHand);
				if(onHand == winLimit) {
					win = true;
					
				} else 
					win = false;
					
			}
			//System.out.println("count: " + count);
			if (win) {
				winlose = "win";
			} else 
				winlose = "lose";
			if(!win) {
				numLoses++;
			}
			
			System.out.println("Simulation " + i + ": " + count + " " + winlose);
		}
		if (winChance == 50) {
		expectedRuin= 1-(currentAmount/winLimit);
		} else
		expectedRuin= (Math.pow(a,currentAmount)-Math.pow(a, winLimit))/(1-(Math.pow(a, winLimit)));
		double ruinRate = ((double)numLoses/(double)totalSimulationTimes);
		System.out.println("Losses: " + numLoses + " Simulations: " + totalSimulationTimes);
		System.out.println("Ruin rate from simulation: " + ruinRate + " expected ruin rate: " + expectedRuin);
	}
}
	//System.out.println("Simulation " + i +":"+ )

//if (winChance == 50) {
//expectedRuin= 1-(currentAmount/winLimit);
//} else
//expectedRuin= (Math.pow(a,currentAmount)-Math.pow(a, winLimit))/(1-(Math.pow(a, winLimit)));

//for(int i=0;i<=totalSimulationTimes;i++) {
//while(currentAmount<=winLimit || currentAmount <=0);{