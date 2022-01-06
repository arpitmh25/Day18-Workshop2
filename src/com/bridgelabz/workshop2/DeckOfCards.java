package com.bridgelabz.workshop2;

import java.util.ArrayList;
import java.util.Scanner;

public class DeckOfCards {
    public static ArrayList<String> deckCards = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);
    private static int player;

    //Uc1
    public void welcome() {
        System.out.println("Welcome to the Deck of Card DashBoard");
    }

    public void deckOfCard() {
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "King", "Queen", "Ace"};
        int numOfCards = suits.length * ranks.length;
        System.out.println("\nNumber of cards in the deck:" + numOfCards);
        for (int i = 0; i < ranks.length; i++) {
            for (int j = 0; j < suits.length; j++) {
                deckCards.add(ranks[i] + "->" + suits[j]);
            }
        }
        toDisplay(deckCards);
    }

    public static void toDisplay(ArrayList<String> cardsDeck) {
        System.out.println("\nCards in Deck:");
        for (String element : cardsDeck) {
            System.out.println(element);
        }
        System.out.println();
    }

    //Uc2
    public void noOfPlayers() {
        System.out.print("\nEnter number of players minimum 2 , maximum 4 : ");
        int player = scanner.nextInt();
        if (player >= 2 && player <= 4) {
            System.out.println("\n" + player + " players will play the game");
        } else {
            System.out.println("Please enter number of players in the Range");
            this.noOfPlayers();
            scanner.close();
        }
    }

    //Uc3
    public void seqOfPlayer(int player) {
        System.out.println("\nSequence of cards are below : ");
        for (int i = 1; i <= player; i++) {
            System.out.println("\nPlayer " + i + " Getting card.............");
        }
    }

    //Uc4
    public static void shuffleCard() {
        System.out.println("shuffling the cards before Distribution");
        ArrayList<String> temp = new ArrayList<String>();
        while (!deckCards.isEmpty()) {
            int sufCard = (int) (Math.random() * deckCards.size());
            temp.add(deckCards.get(sufCard));
            deckCards.remove(sufCard);
        }
        deckCards = temp;
        toDisplay(deckCards);
    }

    //Uc5
    public static void cardDistribution() {
        for (int i = 0; i < player; i++) {
            System.out.print("\nPlayer " + (i + 1) + " got cards:\n");
            for (int j = 0; j < 9; j++) {
                System.out.print("\t" + deckCards.get(i + j * player));
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DeckOfCards deckOfCardsGame = new DeckOfCards();
        deckOfCardsGame.welcome();
        deckOfCardsGame.deckOfCard();
        deckOfCardsGame.noOfPlayers();
        deckOfCardsGame.seqOfPlayer(4);
        deckOfCardsGame.shuffleCard();
        deckOfCardsGame.cardDistribution();
    }
}
