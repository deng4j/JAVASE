package JavaSE.com.Collection.cards.domain;

public class Card implements Comparable<Card>{

    private String name;

    private String flower;

    private Integer cardSort;

    private Integer flowerSort;

    public Card(String name, String flower, Integer cardSort, Integer flowerSort) {
        this.name = name;
        this.flower = flower;
        this.cardSort = cardSort;
        this.flowerSort = flowerSort;
    }

    public Card(String name, Integer cardSort) {
        this.name = name;
        this.cardSort = cardSort;
    }

    public Integer getCardSort() {
        return cardSort;
    }

    public void setCardSort(Integer cardSort) {
        this.cardSort = cardSort;
    }

    public Integer getFlowerSort() {
        return flowerSort;
    }

    public void setFlowerSort(Integer flowerSort) {
        this.flowerSort = flowerSort;
    }

    @Override
    public String toString() {
        if (null==flower){
            return "[" + name +"]";
        }
        return "[" + name  + ", " + flower +"]";
    }

    @Override
    public int compareTo(Card o) {
        int t;
        if (o.getFlowerSort()==null&&this.flowerSort==null){
            t=this.cardSort.compareTo(o.cardSort);
        }else if (o.getFlowerSort()==null){
            t=-1;
        }else if (this.flowerSort==null){
            t=1;
        }else {
            t= this.cardSort.compareTo(o.cardSort)==0?this.flowerSort.compareTo(o.getFlowerSort()):this.cardSort.compareTo(o.cardSort);
        }

        return t;
    }
}


