// Noah Monroe
//CS248-01
// Jan. 18, 2022

import java.io.*;
import java.util.*;

class GuessingGame
{
	public static void main(String [] args)
	{
		Scanner cin=new Scanner(System.in); //creates new gate to read in user
		System.out.println("** Welcome to the Guessing Game!! **");
		
		int r; 
		r = (int)(1+100*Math.random()); // generates the random number
		
		System.out.println("I have a number between 1 and 100, can you guess it?");
		System.out.println("Please enter your guess: ");
		
		int g;
		g=cin.nextInt(); // reads first user input
		
		while (g != r) //loop will continue asking for guesses until correct number is guessed
		{
			if (g > r)
			{
				System.out.println("Too high goofball!");
				System.out.println("Enter your next guess: ");
				g=cin.nextInt(); //inputs new value for g
			}
			else if (g < r)
			{
				System.out.println("Too low you silly goose!");
				System.out.println("Enter your next guess: ");
				g=cin.nextInt(); //inputs new value for g
			}
		}
		
		System.out.println("Congrats! You win!");
	}
}