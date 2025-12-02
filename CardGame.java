
//Simaal Belgaumi
//CPSC 39
//Linked List
// //package linkedLists;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
import java.util.Scanner;



public class CardGame {
    
    private static LinkList cardList = new LinkList();  // make list

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // File name to read from
        String fileName = "cards.txt";

        // Read the file and create Card objects
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] details = line.split(",");
                if (details.length == 4) {
                    String suit = details[0].trim();
                    String name = details[1].trim();
                    int value = Integer.parseInt(details[2].trim());
                    String pic = details[3].trim();

                    Card card = new Card(suit, name, value, pic);
                    cardList.add(card);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file");
        }


        String play = "yes";

        while (play.equalsIgnoreCase("yes")) {

            cardList.shuffle();

            // player cards
            Card p1 = cardList.getFirst();
            Card p2 = cardList.getFirst();
            int playerTotal = p1.getCardValue() + p2.getCardValue();

            System.out.println("\n======================");
            System.out.println("     NEW ROUND");
            System.out.println("======================");

            System.out.println("\nYour cards:");
            System.out.println(" - " + p1);
            System.out.println(" - " + p2);
            System.out.println("Your total: " + playerTotal);

            // dealer cards
            Card d1 = cardList.getFirst(); // shown
            Card d2 = cardList.getFirst(); // hidden
            int dealerTotal = d1.getCardValue() + d2.getCardValue();

            System.out.println("\nDealer shows:");
            System.out.println(" - " + d1);
            System.out.println(" - [hidden card]");

            // player turn
            boolean playerTurn = true;

            while (playerTurn && playerTotal < 21) {
                System.out.print("\nDo you want to HIT or STAND? (hit/stand): ");
                String choice = input.nextLine().trim();

                if (choice.equalsIgnoreCase("hit")) {
                    Card newCard = cardList.getFirst();
                    System.out.println("You draw: " + newCard);

                    playerTotal += newCard.getCardValue();
                    System.out.println("Your total: " + playerTotal);

                    if (playerTotal >= 21) {
                        playerTurn = false;
                    }
                } 
                else {
                    playerTurn = false;
                }
            }

            // show dealer hidden card
            System.out.println("\nDealer reveals:");
            System.out.println(" - " + d1);
            System.out.println(" - " + d2);
            System.out.println("Dealer total: " + dealerTotal);

            // dealer hits until at least 16
            while (dealerTotal < 16) {
                Card newD = cardList.getFirst();
                System.out.println("Dealer draws: " + newD);
                dealerTotal += newD.getCardValue();
                System.out.println("Dealer total: " + dealerTotal);
            }

            // winner
            System.out.println("\n======== RESULT ========");

            if (playerTotal > 21)
                System.out.println("You bust. Dealer wins.");
            else if (dealerTotal > 21)
                System.out.println("Dealer busts. You win!");
            else if (playerTotal > dealerTotal)
                System.out.println("You win!");
            else if (dealerTotal > playerTotal)
                System.out.println("Dealer wins.");
            else
                System.out.println("Tie.");

            // ask again
            System.out.print("\nPlay again? (yes/no): ");
            play = input.nextLine();
        }

        System.out.println("\nThanks for playing.");
    }

}//end class
