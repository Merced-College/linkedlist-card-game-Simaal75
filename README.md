What is this project?
This is a simple card game using a linked list. I made a basic blackjack-style game where you can hit or stand.

What did I add?
I added a shuffle() method to the LinkList class. It moves the cards into an ArrayList, shuffles them, and puts them back. I also added hit/stand choices and the option to play more rounds.

How does the game work?
The game loads cards from cards.txt, shuffles the deck, deals two cards to you and two to the dealer (one is hidden), lets you hit or stand, then shows who wins.

What part uses the linked list?
The whole deck is stored in a linked list. Every time a card is drawn, it uses getFirst() which removes the first card from the list.

How do you play it?
Run CardGame.java and follow what it asks you like hit or stand and if you want to play again.