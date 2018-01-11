
/**
 * @(#)Text3.java
 *
 *
 * @author 
 * @version 1.00 2016/9/20
 */

import java.util.Scanner;

import java.util.ArrayList;

public class Bat {
	// total of the deck
	int total = 0;
	// tells which is supposed to go up or down
	boolean upDown = true;
	// tells you which player is going
	int current = 0;
	// tells you where you are in the deck
	int where = 0;
	// players
	Player[] players;
	// check
	boolean check = false;

	public Bat(int n) {
		this.players = new Player[n];
	}

	public void pickUpCard(Deck pick, ArrayList discard, Card c1, int where, Player p1, int answer) {
		while (true){
			if (Game.where <=52){
				discard.add(c1);
				p1.playerHand.cards[answer] = new Card(pick.cards[where].suit, pick.cards[where].rank);
				System.out.println("this is place in deck: " + where);
				break;
			}
			else {
				Game.where = 0;
				pick.shuffleDeck;
			}
		}

	}

	public int playCard(int oldTotal, Player p1, Deck discard, ArrayList play, int where) {
		System.out.println("These are your cards: \n What card would you like to play?: ");
		// Card[] hands = new Card[this.playerHand.cards.length];

		p1.playerHand.printDeck();

		int newTotal = 0;
		// When done put all into 1 code try catch - since all have same code
		int answer = new Scanner(System.in).nextInt();
		while (true) {
			if (answer == 1 || answer == 2 || answer == 3) {
				newTotal = checkCard(p1.playerHand.cards[answer - 1], oldTotal);
				pickUpCard(discard, play, p1.playerHand.cards[answer - 1], this.where, p1, answer - 1);
				break;
			} else {
				System.out.println("Please enter valid number");
				answer = new Scanner(System.in).nextInt();
			}
		}
		System.out.println("The total is now: " + newTotal);
		return newTotal;
	}

	public int checkCard(Card aCard, int total) {
		total += aCard.rank;
		System.out.println(aCard.toString());

		if (aCard.rank == 12) {
			total = 99;
			System.out.println(total);
		} else if (aCard.rank == 1) {
			System.out.println("Would you like to play a 1 or an 11?");
			int a1 = new Scanner(System.in).nextInt();
			while (true) {
				if (a1 == 11) {
					total += 10;
					break;
				} else {
					if (a1 == 1) {
						break;
					} else {
						System.out.println("Please enter a number 1 or 11");
					}
				}
				a1 = new Scanner(System.in).nextInt();
			}
		} else if (aCard.rank == 11) {
			if (total >= 21)
				total -= 21;
			else
				total = 0;
		} else if (aCard.rank == 13) {
			total += 7;
		} else if (aCard.rank == 9) {
			total -= 9;
			upDown = !upDown;
			System.out.println(upDown);
		} else if (aCard.rank == 4) {
			total -= 4;
			if (this.upDown)
				this.current += 1;
			else
				this.current--;
		}
		// Realize that at top need to make sure certain things don't add before
		// you check it - i.e queen + queen = still in game
		return total;

	}

	public static void main(String[] args) {

		// this is the deck that holds cards that you pick cards from and
		Deck discard = new Deck();
		// shuffles it
		discard.shuffleDeck();

		// players
		ArrayList<Card> play = new ArrayList<Card>();

		// this deck holds the cards players put down
		int answer = 0;
		while (true) {
			System.out.println("How many players (1 - 4)?");
			answer = new Scanner(System.in).nextInt();
			if (answer > 0 && answer < 5) {
				break;
			} else {
				System.out.println("Invalid input, please try again.")
			}
		}
		Bat Game = new Bat(answer);
		// Player[] players = new Player[Integer.parseInt(answer)];
		for (int i = 0; i < answer; i++) {
			Game.players[i] = new Player(Game.where, discard);
			Game.where += 3;
			// gives them cards
		}
		Game.upDown = true;
		// System.out.println("The rules of the game are: Every player .....)"

		while (!Game.checkCase()) {
			while (Game.total < 100) {
				if (Game.upDown) {
					if (Game.current < Game.players.length) {
						Game.current++;
					} else {
						Game.current = 1;
					}
				} else {
					if (Game.current > 0) {
						Game.current--;
					} else {
						Game.current = Game.players.length;
					}
				}
				System.out.println("current player is: " + Game.current);
				if (Game.current <= Game.players.length && Game.current > 0) {
					if (Game.players[Game.current - 1].status < 2) {
						System.out.println("Player " + (Game.current) + " your turn");
						Game.total = Game.playCard(Game.total, Game.players[Game.current - 1], discard, play, Game.where);
						Game.where++;
					}
				} else {
					if (Game.upDown) {
						Game.current = 0;
					} else {
						Game.current = Game.players.length - 1;
					}
				}
			}
			char letter = 'O';
			if (Game.players[Game.current - 1].status == 0) {
				letter = 'B';
			} else if (Game.players[Game.current - 1].status == 1) {
				letter = 'A';
			}
			Game.players[Game.current - 1].status++;
			if (Game.players[Game.current - 1].status < 2) {
				System.out.println("Player " + Game.current + ", you lose this round add a " + letter + " to your total");
			} else {
				System.out.println("Sorry Player " + Game.current + ", you lose; you added a T to your total");
			}
			if (Game.checkCase()) {
				System.out.println("The game is over; Player " + Game.current + ", you win, Congradulations!");
			}
			Game.NewGame(discard, play);
		}
	}

	public void NewGame(Deck discard, ArrayList play) {
		discard.shuffleDeck();
		play.clear();
		this.upDown = true;
		this.where = 0;
		this.current = 0;
		this.total = 0;
		this.check = false;
	}

	public boolean checkCase() {
		// check if all the players' status == 2
		int count = 0;
		for (int i = 0; i < this.players.length; i++) {
			if (this.players[i].status == 2)
				count++;
		}
		if (count == this.players.length - 1)
			check = true;
		return check;
	}
}