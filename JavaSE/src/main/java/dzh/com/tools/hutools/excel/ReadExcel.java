package dzh.com.tools.hutools.excel;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.json.JSONUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import lombok.Data;
import lombok.ToString;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@ToString
class Domain {
    // 仓库
    private String k0;

    // 库存货位
    private String k1;

    // 库存货位顺序
    private String k2;

    // SKU码
    private String k3;

    // 货主名称
    private String k4;

    // 统一商品ID
    private String k5;


    // 商品操作码
    private String k6;

    // 商品名称
    private String k7;

    // 商品规格
    private String k8;

    // 批号
    private String k9;

    // 生产企业
    private String k10;

    // 注册证号
    private String k11;


    // SKU码+批号
    private String k12;

}

/**
 * 以sku+批号为唯一标识
 * 按仓库优先级，取一个原件，一个散件
 *
 */
public class ReadExcel {

    private static Boolean flag1 = false; // 原件
    private static Boolean flag2 = false; // 散件

    public static void main(String[] args) {
        ExcelReader reader = ExcelUtil.getReader(FileUtil.file("D:\\temp\\excel\\weipinjie.xlsx"), 0);

        List<List<Object>> readAll = reader.read();

        readAll.remove(0);
        System.out.println(readAll);

        List<Domain> domainList = new ArrayList<>();
        for (List<Object> objects : readAll) {
            Domain domain = new Domain();
            domain.setK0(objects.get(0).toString());
            domain.setK1(objects.get(1).toString());
            domain.setK2(objects.get(2).toString());
            domain.setK3(objects.get(3).toString());
            domain.setK4(objects.get(4).toString());
            domain.setK5(objects.get(5).toString());
            domain.setK6(objects.get(6).toString());
            domain.setK7(objects.get(7).toString());
            domain.setK8(objects.get(8).toString());
            domain.setK9(objects.get(9).toString());
            domain.setK10(objects.get(10).toString());
            domain.setK11(objects.get(11).toString());
            domain.setK12(objects.get(3).toString() + objects.get(9).toString());
            domainList.add(domain);
        }

        System.out.println(domainList);

        // 先按唯一code分组，再按仓分组
        Map<String, Map<String, List<Domain>>> collect = domainList.stream().collect(Collectors.groupingBy(Domain::getK12,
                Collectors.groupingBy(Domain::getK0)));
        System.out.println(collect.get("24955523D20F0000"));


        Map<String, Map<String, List<Domain>>> collect1 = new HashMap<>();
        Map<String, Map<String, List<Domain>>> collect2 = new HashMap<>();
        for (Map.Entry<String, Map<String, List<Domain>>> stringMapEntry : collect.entrySet()) {
            Map<String, List<Domain>> value = stringMapEntry.getValue();
            // 表示只有一个仓库
            if (value.size() == 1) {
                for (Map.Entry<String, List<Domain>> entry : value.entrySet()) {
                    // 且只有一条数据
                    if (entry.getValue().size() == 1) {
                        collect1.put(stringMapEntry.getKey(), stringMapEntry.getValue());
                    } else {
                        collect2.put(stringMapEntry.getKey(), stringMapEntry.getValue());
                    }
                }

            } else {
                collect2.put(stringMapEntry.getKey(), stringMapEntry.getValue());
            }
        }
        System.out.println(collect1); // 唯一仓，且只有一条数据
        System.out.println(collect2); // 多仓

//        System.out.println("---------------------------------------");
//        System.out.println(JSONUtil.toJsonStr(collect2));

        List<String> list = List.of("R003", "R004", "R005", "R006", "R007", "C002", "R013", "C004", "C006", "C006A001");

        List<Domain> listLX = new ArrayList<>();


        for (Map.Entry<String, Map<String, List<Domain>>> entry : collect2.entrySet()) {
            // 唯一码
            String key = entry.getKey();

            // 按仓分组的
            Map<String, List<Domain>> stringListMap = collect2.get(key);

            for (String s : list) {
                List<Domain> domainList1 = stringListMap.get(s);
                if (CollUtil.isEmpty(domainList1)) {
                    continue;
                }

                for (Domain domain : domainList1) {
                    String k2 = domain.getK2();

                    if (k2.equals("原件") && Boolean.FALSE.equals(flag1)) {
                        flag1 = true;
                        listLX.add(domain);
                    }
                    if (k2.equals("散件") && Boolean.FALSE.equals(flag2)) {
                        flag2 = true;
                        listLX.add(domain);
                    }
                    if (k2.equals("散件、原件")) {
                        flag1 = true;
                        flag2 = true;
                        listLX.add(domain);
                        break;
                    }
                }
                if (Boolean.TRUE.equals(flag1) && Boolean.TRUE.equals(flag2)) {
                    break;
                }
            }
            // 重置
            flag1 = false;
            flag2 = false;
        }

        // 组合，剩下的只有原件和散件
        Map<String, List<Domain>> collect3 = listLX.stream().collect(Collectors.groupingBy(Domain::getK12));

        List<Domain> listLX1 = new ArrayList<>();
        for (Map.Entry<String, List<Domain>> entry : collect3.entrySet()) {
            List<Domain> value = entry.getValue();
            if (value.size() == 2) {
                if (value.get(0).getK0().equals(value.get(1).getK0())) {
                    value.get(0).setK1(value.get(0).getK1()+"、"+value.get(1).getK1());
                    value.get(0).setK2("散件、原件");
                    listLX1.add(value.get(0));
                } else {
                    listLX1.addAll(value);
                }
            } else {
                listLX1.addAll(value);
            }
        }

        System.out.println("------------------------------------------");
        System.out.println(JSONUtil.toJsonStr(listLX1));


        List<List<Object>> data = new ArrayList<>();

        for (Map.Entry<String, Map<String, List<Domain>>> entry : collect1.entrySet()) {
            Map<String, List<Domain>> value = entry.getValue();
            for (Map.Entry<String, List<Domain>> listEntry : value.entrySet()) {
                List<Domain> entryValue = listEntry.getValue();
                for (Domain domain : entryValue) {
                    List<Object> list1 = new ArrayList<>();
                    list1.add(domain.getK0());
                    list1.add(domain.getK1());
                    list1.add(domain.getK2());
                    list1.add(domain.getK3());
                    list1.add(domain.getK4());
                    list1.add(domain.getK5());
                    list1.add(domain.getK6());
                    list1.add(domain.getK7());
                    list1.add(domain.getK8());
                    list1.add(domain.getK9());
                    list1.add(domain.getK10());
                    list1.add(domain.getK11().equals("null")?"":domain.getK11());
                    data.add(list1);
                }
            }
        }

        for (Domain domain : listLX1) {
            List<Object> list22 = new ArrayList<>();
            list22.add(domain.getK0());
            list22.add(domain.getK1());
            list22.add(domain.getK2());
            list22.add(domain.getK3());
            list22.add(domain.getK4());
            list22.add(domain.getK5());
            list22.add(domain.getK6());
            list22.add(domain.getK7());
            list22.add(domain.getK8());
            list22.add(domain.getK9());
            list22.add(domain.getK10());
            list22.add(domain.getK11().equals("null")?"":domain.getK11());
            data.add(list22);
        }

        ExcelWriter writer = ExcelUtil.getWriter(FileUtil.file("D:\\temp\\excel\\111111.xlsx"));

        //普通的单元格设置样式
        CellStyle cellStyle = writer.getCellStyle();
        //设置字体
        Font cellFont = writer.createFont();
        cellFont.setColor(Font.ANSI_CHARSET);
        cellFont.setFontHeight((short) 250);
        cellStyle.setFont(cellFont);
        //设置普通单元格自动换行
        cellStyle.setWrapText(true);

        writer.write(data, true);
        writer.close();
    }
}
