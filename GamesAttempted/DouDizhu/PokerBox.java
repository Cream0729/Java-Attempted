package GamesAttempted.DouDizhu;

import java.util.*;

public class PokerBox {
    static ArrayList<String> porkerBox = new ArrayList<>();
    static Map<String, Integer> pokerValues = new HashMap<>();

    static {
        String[] suits = {"Spades", "Diamonds", "Clubs", "Hearts"};
        String[] ranks = {"3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace", "2"};
        for (String rank : ranks) {
            for (String suit : suits) {
                porkerBox.add(suit + " - " + rank);
            }
        }

        int value = 3;
        for (int i = 0; i < porkerBox.size(); i++) {
            if (i % 4 == 3) {
                pokerValues.put(porkerBox.get(i), value++);
            } else {
                pokerValues.put(porkerBox.get(i), value);
            }
        }
        porkerBox.add("joker");
        porkerBox.add("Joker");
        pokerValues.put("joker", 25);
        pokerValues.put("Joker", 50);

    }

    public static void main(String[] args) {
        int count = 0;
        for (String s : porkerBox) {
            System.out.printf("%-30s", s + " » " + pokerValues.get(s));
            if (count % 4 == 3) System.out.println();
            count++;
        }
    }

    public ArrayList<String> sortPokerPack(ArrayList<String> pokerPack) {
        pokerPack.sort(Comparator.comparingInt(porkerBox::indexOf));
        return pokerPack;
    }
}