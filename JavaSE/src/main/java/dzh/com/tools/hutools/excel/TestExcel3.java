package dzh.com.tools.hutools.excel;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.poi.excel.ExcelWriter;
import cn.hutool.poi.excel.StyleSet;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.util.List;

public class TestExcel3 {

    public static void main(String[] args) {
        Long name=System.currentTimeMillis();
        String filePath = "D:\\window\\temp\\"+name+".xlsx";
        ExcelWriter writer = cn.hutool.poi.excel.ExcelUtil.getWriter();
        commercialExcel(filePath,writer);

        writer.flush(new File(filePath));
        writer.close();
    }

    private static void commercialExcel(String filePath, ExcelWriter writer) {
        StyleSet styleSet = writer.getStyleSet();
        styleSet.setAlign(HorizontalAlignment.CENTER, VerticalAlignment.CENTER);
        styleSet.setBorder(BorderStyle.THIN, IndexedColors.BLACK);

        List<String> head1 = CollUtil.newArrayList("员工编号", "员工姓名", "协议名称", "结算口名称", "证件类型", "证件号码", "岗位", "性别", "员工状态", "异动性质", "参保日期", "停保日期", "反馈状态",
            "户头名称");

        for (int i = 0; i < head1.size();i++ ) {
            String value = head1.get(i);
            writer.merge(0,1,i,i,value,true);
        }

        List<String> head2 = CollUtil.newArrayList("团意险", "雇主责任险");
        for (int i =0; i < head2.size()*4; i+=4) {
            String value = head2.get(i/4);
            int j=i+head1.size();
            writer.merge(0,0,j,j+3,value,true);

            writer.writeCellValue(j,1,"份数");
            writer.writeCellValue(j+1,1,"保额");
            writer.writeCellValue(j+2,1,"变动原因");
            writer.writeCellValue(j+3,1,"备注");
        }
        CellStyle cellStyle = writer.createCellStyle();
        cellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.index);
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);

        for (int i = 0; i <  head2.size() * 4; i++) {
            writer.setStyle(cellStyle,i+head1.size(),1);
        }
        writer.passRows(2);

        List<String> row1 = CollUtil.newArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14","", "2", "3", "4", "5", "6", "7", "");
        List<String> row2 = CollUtil.newArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14");
        List<List<String>> rows=CollUtil.newArrayList();
        rows.add(row1);
        rows.add(row1);
        rows.add(row2);

        writer.write(rows,true);
    }
}
