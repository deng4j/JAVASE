package dzh.com.tools.hutools.excel;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestExcel {

    public static void main(String[] args) {

        Long name=System.currentTimeMillis();
        String filePath = "D:\\window\\temp\\"+name+".xlsx";
        List<List<Object>> data = new ArrayList<>();
        data.add(Arrays.asList("111","222","333","444","555"));
        data.add(Arrays.asList("111","222","333","444","555","666","777"));
        data.add(Arrays.asList("111","222","333","444","555"));
        data.add(Arrays.asList("111","222","333","4444","555","666","777"));

        ExcelWriter writer = ExcelUtil.getWriter(filePath);

        //普通的单元格设置样式
        CellStyle cellStyle = writer.getCellStyle();
        //设置字体
        Font cellFont = writer.createFont();
        cellFont.setColor(Font.ANSI_CHARSET);
        cellFont.setFontHeight((short) 250);
        cellStyle.setFont(cellFont);
        //设置普通单元格自动换行
        cellStyle.setWrapText(true);

        //设置列宽
        writer.setColumnWidth(0, 10);
        writer.setColumnWidth(1, 20);
        writer.setColumnWidth(2, 15);
        writer.setColumnWidth(3, 20);

        //合并单元格后的标题行
        writer.merge(1,"合并索引1前的列",true);
        writer.merge(1,2,2,4,"合并,索引1到2的行,索引2到4的列",false);
        // 跳过前面两行（为了设置merge标题样式）
        writer.passRows(2);
        // 一次性写出内容，使用默认样式，强制输出标题
        writer.write(data,true);
        writer.close();
    }
}
