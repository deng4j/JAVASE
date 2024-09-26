package dzh.com.tools.utils;

import cn.hutool.core.io.FileUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;

import java.util.ArrayList;
import java.util.List;

// 找第一列数据在第二列中不存在的数据
public class DataNotFind {

    public static void main(String[] args) {
        ExcelReader reader = ExcelUtil.getReader(FileUtil.file("D:\\temp\\work\\xadsa.XLSX"), 0);

        List<List<Object>> readAll = reader.read();

        System.out.println(readAll);

        List<String> dataA = new ArrayList<>();
        List<String> dataD = new ArrayList<>();
        for (List<Object> objects : readAll) {
            dataA.add(objects.get(0).toString());
            dataD.add(objects.get(1).toString());
        }

        List<String> notFindList = new ArrayList<>();

        for (String a : dataA) {
            boolean flag = false;
            for (String d : dataD) {
                if (a.equals(d)){
                    flag=true;
                    break;
                }
            }
            if (Boolean.FALSE.equals(flag)){
                notFindList.add(a);
            }
        }

        System.out.println("---------------------------");
        System.out.println(notFindList);

    }
}
