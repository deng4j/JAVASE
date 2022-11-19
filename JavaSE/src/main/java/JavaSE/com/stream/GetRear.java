package JavaSE.com.stream;

import JavaSE.com.stream.domain.Profit;
import cn.hutool.core.collection.CollUtil;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

public class GetRear {

    public static void main(String[] args) {

        List<Profit> profitList=new ArrayList<>();
        profitList.add(new Profit(0,5));
        profitList.add(new Profit(0,6));
        profitList.add(new Profit(0,7));
        profitList.add(new Profit(0,8));
        profitList.add(new Profit(0,9));
        profitList.add(new Profit(222,222));

        profitList.add(new Profit(5,10));
        profitList.add(new Profit(5,20));
        profitList.add(new Profit(5,21));
        profitList.add(new Profit(6,11));
        profitList.add(new Profit(7,12));
        profitList.add(new Profit(8,13));
        profitList.add(new Profit(9,14));

        profitList.add(new Profit(10,15));
        profitList.add(new Profit(11,16));
        profitList.add(new Profit(12,17));
        profitList.add(new Profit(13,18));
        profitList.add(new Profit(14,19));


        List<Profit> tree = CollUtil.newLinkedList();

        Map<Integer, List<Profit>> map = profitList.stream().collect(Collectors.groupingBy(Profit::getPid));

        map.remove(0);

        profitList.stream().filter(vo -> vo.getPid() != null).forEach(province -> {
            List<Profit> cityList = map.get(province.getId());
            map.remove(province.getId());
            if (CollUtil.isNotEmpty(cityList)) {
                cityList.forEach(city -> {
                    List<Profit> profitList1 = map.get(city.getId());
                    if (profitList1!=null){
                        tree.addAll(profitList1);
                    }else {
                        tree.add(city);
                    }
                });
            }else {
                tree.add(province);
            }
        });
        ArrayList<Profit> distanceSocialSecurityExp = tree.stream()
            .collect(collectingAndThen(toCollection(() -> new TreeSet<>(Comparator.comparing(Profit::getId))), ArrayList::new));
        System.out.println(distanceSocialSecurityExp);
    }
}
