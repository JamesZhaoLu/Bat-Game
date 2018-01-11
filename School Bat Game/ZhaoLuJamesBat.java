/**
 * @(#)Text3.java
 *
 *
 * @author 
 * @version 1.00 2016/9/20
 */

import java.util.Scanner;

public class ZhaoLuJamesBat {
	static int total=0;
	//total of the deck
	static boolean upDown = true;
	//tells which is supposed to go up or down
	static int direction = 0;
	//tells you which player is going
	static int where =0;
	//tells you where you are in the deck
   	public ZhaoLuJamesBat() {
    }
    public static void checkCard(Card aCard, int total){
   
    	total += aCard.rank;
    	System.out.println (total);
    	System.out.println (aCard.toString());
    	if (aCard.suit == 12){
    		total = 99;
    	}
    	if (aCard.suit == 11){
    		total -=21;
    	}
    	if (aCard.suit == 13){
    		total += 7;
    	}
   
    	
   }
    public static void main (String[] args) {
    	Deck discard = new Deck();
    	discard.shuffleDeck();
    	//this is the deck that holds cards that you pick cards from and shuffles it
    	Deck play = new Deck(52);
    	//this deck holds the cards players put down
    	System.out.println ("How many players?");
    	String answer = new Scanner(System.in).nextLine();
    	Player[] players = new Player[Integer.parseInt(answer)];
    	for (int i = 0; i< Integer.parseInt(answer); i++){
    		players[i] = new Player(where,discard);
    		//gives them cards
    	}
    	
    	//Start Game
    	System.out.println ("Player " + (direction +1) + " your turn" );
    	players[direction].playCard();
    	//Then get them to discard
    	//Then get them to pick up
    	//Then next turn / start over
    	//Whole system of turns is based on integers - matched with array number
    	//Create a method in playCard to check if 99 and then see who is out
    	//Add 1 letter to out
    	//Reset game
    }
    
    
}