package dzh.com.tools.utils;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.text.StrBuilder;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;

import java.util.ArrayList;
import java.util.List;

public class BuildSQL {
    public static void main(String[] args) {
        ExcelReader reader = ExcelUtil.getReader(FileUtil.file("D:\\temp\\work\\常用------.xlsx"), 0);

        List<List<Object>> readAll = reader.read();

        readAll.remove(0);
        System.out.println(readAll);

        List<String> tableList= new ArrayList<>();
        for (List<Object> objects : readAll) {
            tableList.add(objects.get(1).toString());
        }
        System.out.println(tableList);

        StrBuilder builder = new StrBuilder();

        System.out.println("------------------------------------------------------------");
        for (String s : tableList) {
            String sql = "SELECT '"+s+"',count(*) FROM  "+s+" t  WHERE t.pubts >= '2024-06-25 23:00:00'"+"\n" +
                    "union all\n";
            builder.append(sql);
        }
        System.out.println(builder);
    }
}
