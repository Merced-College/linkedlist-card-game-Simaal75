//Simaal Belgaumi
//CPSC 39
//Linked List

import java.util.ArrayList;
import java.util.Random;

public class LinkList
{
    private Link first;    // first card in the list

    public LinkList()
    {
        first = null;
    }

    public void insertFirst(Card card)
    {
        Link newLink = new Link(card);
        newLink.next = first;
        first = newLink;
    }

    public void add(Card card)
    {
        Link newLink = new Link(card);
        newLink.next = first;
        first = newLink;
    }

    public Link find(Card cardToFind)
    {
        Link current = first;

        while (current != null && !current.cardLink.equals(cardToFind))
            current = current.next;

        return current;
    }

    public Link delete(Card cardToFind)
    {
        Link current = first;
        Link previous = null;

        while (current != null && !current.cardLink.equals(cardToFind))
        {
            previous = current;
            current = current.next;
        }

        if (current == null) return null;

        if (current == first)
            first = first.next;
        else
            previous.next = current.next;

        return current;
    }

    public void displayList()
    {
        Link current = first;

        while (current != null)
        {
            current.displayLink();
            current = current.next;
        }
    }

    public Card getFirst()
    {
        if (first == null) return null;

        Card c = first.cardLink;
        first = first.next;
        return c;
    }


    // improvement: shuffle the linked list
    // moved cards into an array, shuffled it, rebuilt the list
    public void shuffle()
    {
        ArrayList<Card> cards = new ArrayList<>();
        Link cur = first;

        // move linked list into array
        while (cur != null)
        {
            cards.add(cur.cardLink);
            cur = cur.next;
        }

        // shuffle the array
        Random r = new Random();
        for (int i = 0; i < cards.size(); i++)
        {
            int j = r.nextInt(cards.size());
            Card temp = cards.get(i);
            cards.set(i, cards.get(j));
            cards.set(j, temp);
        }

        // rebuild linked list
        first = null;
        for (Card c : cards)
            insertFirst(c);
    }


}  // end class LinkList
////////////////////////////////////////////////////////////////
/*class LinkedLists
{
    public static void main(String[] args)
    {
        LinkList theList = new LinkList();  // make list

        theList.insertFirst(new Card("heart", "ace", 11,"ah.gif"));      // insert 4 items
        theList.insertFirst(new Card("Spade", "ace", 11,"as.gif"));
        //theList.insertFirst(66, 6.99);
        //theList.insertFirst(88, 8.99);

        theList.displayList();              // display list

        Link f = theList.find(new Card("heart", "ace", 11,"ah.gif"));          // find item
        if( f != null)
            System.out.println("Found link with key " + f.cardLink);
        else
            System.out.println("Can't find link");

        Link d = theList.delete(new Card("heart", "ace", 11,"ah.gif"));        // delete item
        if( d != null )
            System.out.println("Deleted link with key " + d.cardLink);
        else
            System.out.println("Can't delete link");

        theList.displayList();              // display list
    }  // end main()
}  // end class LinkList2App
////////////////////////////////////////////////////////////////
/// */
