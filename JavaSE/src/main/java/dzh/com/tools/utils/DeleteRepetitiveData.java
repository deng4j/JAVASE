package dzh.com.tools.utils;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 查找唯一的数据
public class DeleteRepetitiveData {
    public static void main(String[] args) {
        ExcelReader reader = ExcelUtil.getReader(FileUtil.file("D:\\temp\\work\\repetitive.XLSX"), 0);

        List<List<Object>> readAll = reader.read();

        System.out.println(readAll);

        List<String> dataA1 = new ArrayList<>();
        for (List<Object> objects : readAll) {
            String str = objects.get(0).toString();
            if (StrUtil.isEmpty(str)) continue;
            dataA1.add(str);
        }

        Map<String, Integer> map = new HashMap<>();
        for (String v : dataA1) {
            map.merge(v, 1, Integer::sum);
        }
        System.out.println("-----------------统计------------------");
        System.out.println(map);
        List<String> result = new ArrayList<>();
        map.keySet().forEach(key -> {
            if (map.get(key) ==1) {
                result.add(key);
            }
        });
        System.out.println("----------------结果-------------------");
        System.out.println(result);
    }
}
