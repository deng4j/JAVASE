package dzh.com.demos.cards;

import dzh.com.demos.cards.domain.Card;

import java.util.*;

public class CardApp2 {
    public static void main(String[] args) {

        TreeSet<Card> u1=new TreeSet<>();
        TreeSet<Card> u2=new TreeSet<>();
        TreeSet<Card> u3=new TreeSet<>();
        TreeSet<Card> lastpork=new TreeSet<>();

        List<Card> cardList = total();
        Collections.shuffle(cardList);

        for (int i = 0; i < 51; i+=3) {
            u1.add(cardList.get(i));
            u2.add(cardList.get(i+1));
            u3.add(cardList.get(i+2));
        }
        lastpork.add(cardList.get(51));
        lastpork.add(cardList.get(52));
        lastpork.add(cardList.get(53));

        System.out.println(u1);
        System.out.println(u2);
        System.out.println(u3);
        System.out.println("底牌"+lastpork);
    }
    private static List<Card> total() {
        List<Card> list=new ArrayList<>();
        List<String> basic=new ArrayList<>(List.of("3","4","5","6","7","8","9","10","J","Q","K","A","2"));
        ArrayList<String> color=new ArrayList<>(List.of("♣","♥","■","♠"));
        ArrayList<String> gost=new ArrayList<>(List.of("小王","大王"));

        for (int i = 0; i < basic.size(); i++) {
            for (int j = 0; j < color.size(); j++) {
                Card card = new Card(basic.get(i),color.get(j),i,j);
                list.add(card);
            }
        }

        for (int i = 0; i < gost.size(); i++) {
            Card card = new Card(gost.get(i),i);
            list.add(card);
        }
        return list;
    }
}
