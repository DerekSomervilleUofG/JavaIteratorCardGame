package CardGame;


import CardGame.Card;

import java.util.*;

public class Hand implements Iterator{
    protected ArrayList<Card> handOfCards;

    protected int position = 0;

    public Hand(){
        this.handOfCards = new ArrayList<Card>();
    }

    public Hand(String[] listOfCards){
        this.handOfCards = new ArrayList<Card>();
        for (String card : listOfCards){
            this.handOfCards.add(new Card(card));
        }
    }

    public Hand(String listOfCards){
        this.handOfCards = new ArrayList<Card>();
        for (String card : listOfCards.split(",")){
            this.handOfCards.add(new Card(card));
        }
    }

    public Card next(){
        Card card = handOfCards.get(position);
        position ++;
        return card;
    }

    public boolean hasNext(){
        return position < handOfCards.size();
    }

    public void setPosition(int position){
        this.position = position;
    }

    public Card getFirstCard() {
        return handOfCards.get(0);
    }

    public Boolean playACard(Card card){
        return handOfCards.remove(card);
    }


    public Card playACard(String cardShortCode){
        Card card;
        if (cardShortCode.length() == 1) {
            int indexOfCard = Integer.parseInt(cardShortCode);
            card = playACard(indexOfCard);
        } else {
            card = new Card(cardShortCode);
            if (!playACard(card)) {
                card = null;
            }
        }
        return card;
    }

    public Card playACard(){
        return handOfCards.remove(handOfCards.size()-1);
    }

    public Card playACard(int userCard){
        return handOfCards.remove(userCard);
    }

    public void add(Card card){
        handOfCards.add(card);
    }

    public void set(int index, Card card){
        handOfCards.set(index,card);
    }

    public Hand copy(){
        Hand newHand = new Hand();
        for (Card card : handOfCards){
            newHand.add(card);
        }
        return newHand;
    }

    public boolean isEmpty(){
        boolean result = false;
        if (handOfCards.size() == 0 ){
            result = true;
        }
        return result;
    }

    public void remove(Card card){
        handOfCards.remove(card);
    }

    public void clear(){
        handOfCards.clear();
    }

    public Integer size(){
        return handOfCards.size();
    }

    public void sortHand(){
        Collections.sort(handOfCards, Comparator.comparing(Card::toString));
    }

    public void sortHandByFace(){

        try {
            Collections.sort(handOfCards, Comparator.comparing(Card::getRank));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public String toString(){
        String display = "";
        String prefix = "";
        for (Card card : handOfCards){
            display += prefix + card;
            prefix = ", ";
        }
        return display;
    }
}
