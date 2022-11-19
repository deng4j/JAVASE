package JavaSE.com.stream;

import JavaSE.com.stream.domain.SocialSecurityExp;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

/**
 * 流可用于单列集合
 * 双列集合，需要使用keyset()方法或entryset()返回一个set集合对象，再使用流
 * 数组
 * 同种类型的多个数据
 */
public class Stream1 {
    public static void main(String[] args) {
        // methad1();
        // methad2();
        // method0();
        Collectors();
    }

    private static void method0() {
        List<Integer> listof =List.of(10,10,12,15,13,18,16);
        ArrayList<Integer> list=new ArrayList<>(listof);

        //map用于映射每个元素对应的结果
        // distinct去除重复,并对数组元素操作
        List<Integer> listmap= list.stream().map(i->i*2).distinct().collect(Collectors.toList());
        System.out.println("map:"+listmap);

        //limit获取指定数量的流
        List<Integer> listlimit= listmap.stream().limit(3).collect(Collectors.toList());
        System.out.println("listlimit:"+listlimit);

        //skip跳过前面几个
        List<Integer> listskip = listmap.stream().skip(3).collect(Collectors.toList());
        System.out.println("skip:"+listskip);

        //concat合并两个流
        Stream<Integer> concatStream = Stream.concat(listmap.stream().limit(3), listmap.stream().skip(3));
        List<Integer> concatlist = Stream.concat(listmap.stream().limit(3), listmap.stream().skip(3)).collect(Collectors.toList());
        System.out.println("concatlist:"+concatlist);

        //collect(Collectors.toList())转化为List
        //collect(Collectors.toSet())转化为Set
        //collect(Collectors.toCollection)将流收集到已创建的Collection集合中
    }

    private static void sortTest() {
        List<Integer> listof =List.of(10,10,12,15,13,18,16);
        ArrayList<Integer> list=new ArrayList<>(listof);
        //sorted(Conparator comp)对流进行排序， 多字段排序 sorted(Comparator.comparing(userInfo::getAge).thenComparing(userInfo::getMoney))
        //null元素排到前面 Collections.sort(list, Comparator.nullsFirst(Comparator.comparing(Object::getName)));
        //null元素排到后面 Collections.sort(list, Comparator.nullsLast(Comparator.comparing(Object::getName)));

        List<Integer> sortedlist = list.stream().sorted().collect(Collectors.toList());
        System.out.println("sorted:"+sortedlist);

        //对象集合以类属性一降序排序 写法一 list.stream().sorted(Comparator.comparing(类::属性一).reversed());
        //对象集合以类属性一降序排序 写法二 list.stream().sorted(Comparator.comparing(类::属性一).reversed());

        //对象集合以类属性一降序 属性二升序 注意两种写法
        //list.stream().sorted(Comparator.comparing(类::属性一).reversed().thenComparing(类::属性二));//先以属性一升序,反转即降序,再进行属性二升序
        //list.stream().sorted(Comparator.comparing(类::属性一,Comparator.reverseOrder()).thenComparing(类::属性二));//先以属性
    }

    private static void methad2() {
        System.out.println("------------------双列集合-----------------");
        //双列集合使用流keyset,values
        Map<String, String> ofEntries = Map.ofEntries(Map.entry("a", "aa"), Map.entry("b", "bb"));
        Map<String,String> map=new HashMap<>(ofEntries);
        map.keySet().stream().filter(s -> s.endsWith("a")).forEach(s -> System.out.println("keyset:"+s));
        map.values().stream().filter(s -> s.startsWith("aa")).forEach(s -> System.out.println("values:"+s));
        //使用entryset
        List<Map.Entry<String,String>> entryListlist= map.entrySet().stream().filter(s->s.getKey().equals("a")).collect(Collectors.toList());
        System.out.println("entry："+entryListlist);
        //toMap
        Map<String, String> tomaplist = map.entrySet().stream().collect(Collectors.toMap(item -> item.getKey(), item -> item.getValue()));
        System.out.println("toMap:"+tomaplist);

    }

    private static void methad1() {
        System.out.println("------------------单列集合------------------");
        //单列集合使用流
        //不可变集合
        List<String> unlist = List.of("张三", "张三狗", "张健康", "大傻傻");
        //集合的批量添加
        ArrayList<String> list = new ArrayList<>(unlist);
        //使用stream方法
        Stream<String> stringStream = list.stream().filter(li -> li.startsWith("张")).filter(li -> li.length() == 3);
        stringStream.forEach(s -> System.out.println(s));
       List<String> stringList = stringStream.collect(Collectors.toList());
        System.out.println("过滤：");

        //收集到map
        List<String> unlist1 = List.of("张三,12", "李四,18", "张健康,79", "王五,18");
        ArrayList<String > list1=new ArrayList<>(unlist1);
        Map<String,String> listtomap= list1.stream().filter(s -> {
            String[] str = s.split(",");
            int i = Integer.parseInt(str[1]);
            return i>12;
        }).collect(Collectors.toMap(s->s.split(",")[0],s->s.split(",")[1]));
        System.out.println("ListToMap:"+listtomap);

        //reduce() :将流中的元素反复结合起来，得到一个值。
        Optional<Integer> reduce = Stream.of(1, 2, 3, 4, 5, 6).reduce((acc, item) -> {
            acc += item;
            return acc;
        });
        System.out.println("reduce累加:"+reduce.get());
    }

    public static void Collectors(){
        List<SocialSecurityExp> socialSecurityExpAll = new ArrayList<>();
        socialSecurityExpAll.add(new SocialSecurityExp("张三",1));
        socialSecurityExpAll.add(new SocialSecurityExp("张三",1));
        socialSecurityExpAll.add(new SocialSecurityExp("李四",2));
        socialSecurityExpAll.add(new SocialSecurityExp("王五",3));

        //根据字段转tree
        ArrayList<SocialSecurityExp> distanceSocialSecurityExp = socialSecurityExpAll.stream()
            .collect(collectingAndThen(toCollection(() -> new TreeSet<>(Comparator.comparing(SocialSecurityExp::getEntryName))), ArrayList::new));
        System.out.println("去重后："+distanceSocialSecurityExp);

        //根据字段获取最大的maxBy
        Optional<SocialSecurityExp> max = socialSecurityExpAll.stream().collect(Collectors.maxBy((s1, s2) -> s1.getAfterCardinality() - s2.getAfterCardinality()));
        SocialSecurityExp exp1 = max.get();
        System.out.println("获取最大值maxBy："+exp1.getAfterCardinality());
        //根据字段获取最小的minBy
        Optional<SocialSecurityExp> min = socialSecurityExpAll.stream().collect(Collectors.minBy((s1, s2) -> s1.getAfterCardinality() - s2.getAfterCardinality()));
        SocialSecurityExp exp2 = min.get();
        System.out.println("最小值minBy："+exp2.getAfterCardinality());
        //求和
        Integer sum = socialSecurityExpAll.stream().collect(Collectors.summingInt(s -> s.getAfterCardinality()));
        System.out.println("求和："+sum);
        //平均值
        Double avg = socialSecurityExpAll.stream().collect(Collectors.averagingDouble(s -> s.getAfterCardinality()));
        System.out.println("平均值："+avg);
        //统计个数
        Long count = socialSecurityExpAll.stream().collect(Collectors.counting());
        System.out.println("统计数量："+count);


        IntSummaryStatistics intSummaryStatistics = socialSecurityExpAll.stream().collect(Collectors.summarizingInt(s -> s.getAfterCardinality()));
        System.out.println("最大值："+intSummaryStatistics.getMax());
        System.out.println("最小值："+intSummaryStatistics.getMin());
        System.out.println("平均值："+intSummaryStatistics.getAverage());


        //按字段分组
        Map<Integer, List<SocialSecurityExp>> groupbyCar = socialSecurityExpAll.stream().collect(Collectors.groupingBy(s -> s.getAfterCardinality()));
        System.out.println("按字段分组："+groupbyCar);
        //条件分组
        Map<String, List<SocialSecurityExp>> groupByCondition = socialSecurityExpAll.stream().collect(Collectors.groupingBy(s -> {
            if (s.getAfterCardinality() <= 2) {
                return "低级";
            } else {
                return "高级";
            }
        }));
        System.out.println("条件分组："+groupByCondition);
        //先按基数，再按名称分组
        Map<Integer, Map<String, List<SocialSecurityExp>>> groupLot = socialSecurityExpAll.stream()
            .collect(Collectors.groupingBy(s -> s.getAfterCardinality(), Collectors.groupingBy(s -> {
                if (s.getAfterCardinality() <= 2) {
                    return "低级";
                } else {
                    return "高级";
                }
            })));
        System.out.println("多级分组："+groupLot);


        //对数据分区
        Map<Boolean, List<SocialSecurityExp>> part = socialSecurityExpAll.stream()
            .collect(Collectors.partitioningBy(s -> s.getAfterCardinality() > 1));
        System.out.println("分区后："+part);

        //数据拼接
        String join = socialSecurityExpAll.stream().map(SocialSecurityExp::getEntryName).collect(Collectors.joining("-","pre-","-suf"));
        System.out.println("数据拼接："+join);

        //根据entryName分组，然后对afterCardinality求和
        Map<String, Integer> integerMap = socialSecurityExpAll.stream()
            .collect(Collectors.groupingBy(SocialSecurityExp::getEntryName, Collectors.summingInt(SocialSecurityExp::getAfterCardinality)));
        System.out.println("根据entryName分组，然后对afterCardinality求和："+integerMap);

        //根据entryName分组，然后将afterCardinality收集成list
        Map<String, List<Integer>> mapping = socialSecurityExpAll.stream()
            .collect(Collectors.groupingBy(SocialSecurityExp::getEntryName,
                Collectors.mapping(SocialSecurityExp::getAfterCardinality, Collectors.toList())));
        System.out.println(mapping);
    }
}
