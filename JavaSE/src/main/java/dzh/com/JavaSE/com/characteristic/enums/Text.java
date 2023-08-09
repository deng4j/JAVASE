package dzh.com.JavaSE.com.characteristic.enums;

import java.util.EnumSet;
import java.util.Set;

public class Text {
    private enum Style {BOLD,ITALIC}

    public void applyStylee(Set<Style> styles){
        System.out.println(styles);
    }

    public static void main(String[] args) {
        Text text = new Text();
        text.applyStylee(EnumSet.of(Style.BOLD,Style.ITALIC));
        text.applyStylee(Set.of(Style.BOLD,Style.ITALIC));
    }
}
