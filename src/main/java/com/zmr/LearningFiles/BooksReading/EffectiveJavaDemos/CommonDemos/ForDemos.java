package com.zmr.LearningFiles.BooksReading.EffectiveJavaDemos.CommonDemos;

import java.util.*;

public class ForDemos {
    enum Suit { CLUB, DIANOND, HEART, SPADE }
    enum Rank { ACE, DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING }

    static Collection<Suit> suits  = Arrays.asList(Suit.values());

    static Collection<Rank> ranks  = Arrays.asList(Rank.values());

    static class Card {
        private Suit suit;
        private Rank rank;

        public Card(Suit suit, Rank rank) {
            this.suit = suit;
            this.rank = rank;
        }

        public Suit getSuit() {
            return suit;
        }

        public void setSuit(Suit suit) {
            this.suit = suit;
        }

        public Rank getRank() {
            return rank;
        }

        public void setRank(Rank rank) {
            this.rank = rank;
        }
    }

    /**
     * 第一个循环案例（使用迭代器）
     */
    public static <E extends Comparable<E>> void forDemo01(Set<E> s) {
        for (Iterator<E> i  = s.iterator(); i.hasNext(); ) {
            E e = i.next();
            System.out.println(e);
        }
    }

    /**
     * 一段包含 bug 的代码片段（使用迭代器的时候存在的问题）
     */
    public static List<Card> aBugCode() {
        List<Card> deck = new ArrayList<>();
        for (Iterator<Suit> i = suits.iterator(); i.hasNext(); ) {
            for (Iterator<Rank> j = ranks.iterator(); j.hasNext(); ) {
                deck.add(new Card(i.next(), j.next()));
            }
        }
        return deck;
    }

    public static void main(String[] args) {
        // Set<Integer> integers = new TreeSet<>();
        // integers.add(1);
        // integers.add(3);
        // integers.add(4);
        // integers.add(7);
        // integers.add(6);
        // forDemo01(integers);
        List<Card> cards = aBugCode();
        for ( Card c : cards ) {
            System.out.println(c);
        }
    }
}
