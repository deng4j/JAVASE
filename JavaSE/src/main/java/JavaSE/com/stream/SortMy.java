package JavaSE.com.stream;

import JavaSE.com.stream.domain.Area;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SortMy {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("长沙", "湖南", "株洲");

        Area area1 = new Area("长沙");
        Area area2 = new Area("湖南");
        Area area3 = new Area("长沙");
        Area area4 = new Area("株洲");

        List<Area> areaList = Arrays.asList(area1, area2, area3, area4);
        Map<String, List<Area>> groupbyCar = areaList.stream().collect(Collectors.groupingBy(s -> s.getName()));

        List<Area> newList=new ArrayList<>();
        for (String s: list) {
            List<Area> areas = groupbyCar.get(s);
            newList.addAll(areas);
        }
        System.out.println(newList);

    }
}
