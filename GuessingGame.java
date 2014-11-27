/*
This class creates a game in the basic command-line interface. The user will have three options:
They can either play a new game, see the high scores list, or exit out of the program
*/


import java.util.Scanner; 		//allows us to use the scanner 


public class GuessingGame
{	
	
/**
*This class prints the text instructing the user on how to use the menu, as well as printing 
*out the actual menu. 
*@return menu
*the choice of the menu option the user picked 
*/
	
	public static String menuPrint()
	{
		
		Scanner letter = new Scanner (System.in); 		//scan for which option the user picked
		
		System.out.println("----------------------------------------------------");		//print out the menu with instructions on how to use it
		
		System.out.println("Please type the letter you would like to execute followed by the enter key."); 
		
		System.out.println("a) New Game"); 
		
		System.out.println("b) See Highscores List"); 
		
		System.out.println("c) Exit Game"); 
		
		String menu = letter.next();		//save the users choice to a variable called menu
		
		return menu; 		//and return it 
	
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


/**
*This class implements the menuPrint class and actually makes the game which the user will be playing
*/	
	
	public static void main (String[] args)
	{
		
		int score = 0; 		//initialize and declare score
		
		HiScoresDLL hsListADV= new HiScoresDLL();		//create a high scores list for when people play the advanced game
		
		HiScoresDLL hsListNOVICE = new HiScoresDLL(); 	//creates a high scores list for when people play the novice game
		
		String menuChoice = menuPrint();		//print the menu
	
		while (menuChoice.equalsIgnoreCase("b")||menuChoice.equalsIgnoreCase("a"))		//while the user picks a or b
		{
			
			if (menuChoice.equalsIgnoreCase("a"))		//if the user picks a 
			{
				
				Scanner skill = new Scanner(System.in); 		//have the user pick the skill level of game
				
				System.out.println(" "); 
				
				System.out.println("Pick the skill level you would like to play this game in: "); 		//print the skill level menu 

				System.out.println("a) Novice"); 
				
				System.out.println("b) Advanced"); 
				
				System.out.println(" "); 	
				
				String diffLevel = skill.next(); 		//save whatever the user picked to a variable called diffLevel
				
				
				System.out.println("The goal of this game is to try to guess what number I am thinking of.");		//print the instructions
				
				System.out.println( "It will be a number between 0 and a number you choose. It will be an inclusive "); 
				
				System.out.println("set of numbers meaning it will include 0 and whatever number you input."); 
				
				System.out.println("If you picked the novice game then I will tell you if your guess is higher ");
				
				System.out.println("or lower the number I am thinking of. If you are in advanced though,");
				
				System.out.println("you are on your own! The lower the number of guesses it takes you, ");
				
				System.out.println("higher your ranking in the high scores list. The high scores list is in acending "); 
				
				System.out.println("order. So try to get it in one guess you measley human!");
				
				System.out.println(" "); 
				
								
				Scanner compGuess = new Scanner(System.in); 		//scan for what the user wants the top bound to be for the computer's number
				
				System.out.println(" "); 
				
				System.out.println("Please pick the top bound of the range of numbers I will be able to choose from"); 	//print the question
				
				System.out.println("It must be greater than 0."); 
				
				int topbound = compGuess.nextInt();		//saves the topbound the user picks to a variable called topbound
				
				
				Scanner name = new Scanner (System.in); 		//scans for the user's name
				
				System.out.println(" "); 
		
				System.out.println("What is your name for the unlikely chance you make it onto the high scores list?");		//prints the question
		
				String username = name.next();		//save their name as a variable called username
				
				
				int target = (int)(Math.random()*topbound+1);	//picks out a number between 0 and 100 inclusive (the computer "thinks" of a number)
				
				//System.out.println(target); 		TESTING
				
				
				
				Scanner guessScan = new Scanner (System.in); 		//scan for what the user's first guess is
				
				System.out.println(" ");		
				
				System.out.println("Let's get started! What will your first guess be? Choose carfully! Please enter"); 		//print out the question
				
				System.out.println("a valid number (an integer in the appropriate range) and then press enter"); 
				
				int guess = guessScan.nextInt();		//save the users first guess as the variable called guess
				
				
				score = score +1; 		//set the score to one since the user made their first guess
				
				while (guess != target)		//while the user's guess is not equal to the number the computer is thinking of
				{
					
					if (guess <0 || guess >topbound)		//if the guess is out of the bounds
					{
						guessScan = new Scanner (System.in); 		//scan for a new guess
				
						System.out.println("Silly human, that is not in the range I gave you! Pick another number"); 		//let the user know they did something wrong
				
						System.out.println("from the valid range (1 to "+ topbound+ " inclusive)"); 
				
						guess = guessScan.nextInt();		
				
						score = score +1; 		//increase their score since this counts as a guess
						
					}
					
					else 		//if their guess was in the proper bounds but it was not what the computer was thinking of
					{
						System.out.println("NOPE! Guess again ;)"); 		//let the user know it was not the correct number
						
						if (diffLevel.equalsIgnoreCase("a"))		//if the user previously picked the skill level to be novice
						{
							if (guess > target)		//if the number they guesses was bigger than the number the computer thought of
							{
								System.out.println("P.S. Your's was too high!");	//let them know they are too high
								
							}
							
							else 
							{
								System.out.println("P.S. Your's was too low!"); 	//otherwise let them know they were too low
								
							}
							
						}
						
						guessScan = new Scanner (System.in);		//scan for a new guess
						
						guess = guessScan.nextInt(); 
						
						score = score +1; 		//increment their score 
				
					}
				}
				
				System.out.println("Congrats you guessed the number I was thinking of " + username+ "!"); 		//let them know they won and what their score was
				
				System.out.println("It only took you a total of  " + score + " guesses"); 
				
				System.out.println(" ");
				
				
				GameEntry entry = new GameEntry (username, score); 		//make a new game entry with username they inputed and their score
				
				score = 0;		//reset the score to zero incase they want to play again
				
				if (diffLevel.equalsIgnoreCase("a"))		//if they previously picked their skill set as novice
				{
					
					hsListNOVICE.add(entry);		//add their high score to the high scores list for novice players
				
				}
				
				else
				{
					hsListADV.add(entry);		//otherwise add their high score to the advanced players high score list
					
				}				
				
				menuChoice = menuPrint();		//print out the menu
				 
			}
			
			else if (menuChoice.equalsIgnoreCase("b"))		//if the user picked option b on the menu
			{
				
				System.out.println("The high scores are listed from the worst scores to the highest. So the"); 	//let them know what the high scores indicate
				
				System.out.println("highest score will be the last one listed.");
				
				System.out.println(" ");
				
				System.out.println("This is the high scores list for novice humans: ");
				
				hsListNOVICE.display(); 		// display the high scores list for novice
				
				System.out.println(" ");
				
				System.out.println("This is the high scores list for advanced humans: "); 
				
				hsListADV.display(); 			//displays high scores list for advanced
				
				menuChoice = menuPrint();		//print out the menu again
				
			}
					
			
		}
		
		//end class
		
	}
	
}
				
				
				
				
				
				
				
				
				
