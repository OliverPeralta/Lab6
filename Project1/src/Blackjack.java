/** * * * * * * * * * * * * * * *
  *    Project 1: Blackjack     *
  *                             *
  *       Oliver Peralta        *
  *   Instructor: Lisha Zhou    *
  *       UFID: 93594226        *
  *                             *
  * * * * * * * * * * * * * * * */

import java.util.Scanner;

public class Blackjack{

    public static void main(String[] args) {

        String playerDecision = "";     // - This variable is in string to be able to discern from the 1-4 input and invalid input
        int playerHand = 0;             // - Will track value of their hands
        int dealerHand = 0;             // - ^
        int gameCount = 0;
        int cardDealt = 0;              // - This variable temporarily stores the random value of the card dealt
        int playerWins = 0;
        int dealerWins = 0;
        int tieGames = 0;
        double winRate = 0;
        boolean flag = true;            // - Flag variable is used to hop out of second while loop

        Scanner scan = new Scanner(System.in);
        P1Random rng = new P1Random();      // - Uses the "random" values

        while (!playerDecision.equals("4")) {    // This while loop will make sure the games keep going

            gameCount++;
            flag = true;
            System.out.println("START GAME #" + gameCount + "\n");

            cardDealt = rng.nextInt(13) + 1;

            if (cardDealt == 13) {
                playerHand += 10;
                System.out.println("Your card is a KING!");
                System.out.println("Your hand is: " + playerHand + "\n");
            }
            else if (cardDealt == 12) {
                playerHand += 10;
                System.out.println("Your card is a QUEEN!");
                System.out.println("Your hand is: " + playerHand + "\n");
            }
            else if (cardDealt == 11) {                                      // The many if statements are to catch the
                playerHand += 10;                                            // random 11's, 12's, 13's and 1's
                System.out.println("Your card is a JACK!");
                System.out.println("Your hand is: " + playerHand + "\n");
            }
            else if (cardDealt == 1) {
                playerHand++;
                System.out.println("Your card is a ACE!");
                System.out.println("Your hand is: " + playerHand + "\n");
            }
            else {
                playerHand += cardDealt;
                System.out.println("Your card is a " + cardDealt + "!");
                System.out.println("Your hand is: " + playerHand + "\n");
            }

            while (flag) {                                  // This second while loop is for the sequence of hitting, holding,
                                                            // and printing statistics. when flag variable is false, it will
                System.out.println("1. Get another card");  // it will hop out of the loop back into the first one
                System.out.println("2. Hold hand");
                System.out.println("3. Print statistics");
                System.out.println("4. Exit\n");
                System.out.print("Choose an option: ");
                playerDecision = scan.next();

                if (playerDecision.equals("1")) {

                    cardDealt = rng.nextInt(13) + 1;

                    if (cardDealt == 13) {
                        playerHand += 10;
                        System.out.println("\nYour card is a KING!");
                        System.out.println("Your hand is: " + playerHand + "\n");
                    }
                    else if (cardDealt == 12) {
                        playerHand += 10;
                        System.out.println("\nYour card is a QUEEN!");              // More if statements for the K, Q,
                        System.out.println("Your hand is: " + playerHand + "\n");   // J, and Ace values
                    }
                    else if (cardDealt == 11) {
                        playerHand += 10;
                        System.out.println("\nYour card is a JACK!");
                        System.out.println("Your hand is: " + playerHand + "\n");
                    }
                    else if (cardDealt == 1) {
                        playerHand++;
                        System.out.println("\nYour card is a ACE!");
                        System.out.println("Your hand is: " + playerHand + "\n");
                    }
                    else {
                        playerHand += cardDealt;
                        System.out.println("\nYour card is a " + cardDealt + "!");
                        System.out.println("Your hand is: " + playerHand + "\n");

                    }

                    if (playerHand == 21) {                                 // This code is put to make sure
                        System.out.println("BLACKJACK! You win!\n");        // the game ends as soon as a
                        flag = false;                                       // blackjack happens or they "bust"
                        playerWins++;

                    } else if (playerHand > 21) {
                        System.out.println("You exceeded 21! You lose.\n");
                        dealerWins++;
                        flag = false;
                    }
                }
                else if (playerDecision.equals("2")) {
                    dealerHand = rng.nextInt(11) + 16;                // random function for dealer's hand

                    System.out.println("\nDealer's hand: " + dealerHand);
                    System.out.println("Your hand is: " + playerHand + "\n");
                                                                           // Flag is false here to hop out of the
                    if (dealerHand < playerHand || dealerHand > 21) {      // second while loop
                        System.out.println("You win!\n");
                        playerWins++;
                    }
                    else if (playerHand == dealerHand){
                        System.out.println("It's a tie! No one wins!\n");
                        tieGames++;
                    }
                    else if (dealerHand > playerHand) {
                        System.out.println("Dealer wins!\n");
                        dealerWins++;
                    }
                    flag = false;                                          // Jumps out of second while loop
                }
                else if (playerDecision.equals("3")) {                                 // This prints the statistics
                    System.out.println("\nNumber of Player wins: " + playerWins);      // without interrupting the loop
                    System.out.println("Number of Dealer wins: " + dealerWins);        // and the random function
                    System.out.println("Number of tie games: " + tieGames);
                    System.out.println("Total # of games played is: " + (gameCount-1));
                    System.out.println("Percentage of Player wins: " + winRate + "%\n");
                }
                else if (playerDecision.equals("4")) {
                    flag = false;
                }
                else {                                                                 // Catches input that is invalid
                    System.out.println("\nInvalid input!");
                    System.out.println("Please enter an integer value between 1 and 4.\n");
                }

            }

            if (!(playerDecision.equals("4"))) {             // If statement is to make sure the game is exited
                playerHand = 0;                              // and marks the end of a game, being able to
                dealerHand = 0;                              // calculate win rate of the player and reset values
                playerDecision = "0";
                winRate = (((double) playerWins/gameCount)*100);
            }
        }
    }
}



