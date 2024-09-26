package dzh.com.tools.gzmpc;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.poi.ss.usermodel.*;

import java.util.List;

public class SeniorExcel {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Sheet8Statistic {
        /** 地区 */
        private Object area;
        /** 本期 */
        private Object bq;
        /** 上期 */
        private Object sq;
        /** 本期增长率 */
        private Object bqRate;
        /** 去年同期 */
        private Object qntq;
        /** 去年同期增长率 */
        private Object qntqRate;
        /** 今年以来 */
        private Object jnyl;
        /** 今年以来增长率 */
        private Object jnylRate;
    }

    public static void main(String[] args) {
        Long name=System.currentTimeMillis();
        String filePath = "D:\\window\\temp\\"+name+".xlsx";
        doWrite(filePath);
    }

    private static void doWrite(String newFilePath) {
        ExcelWriter writer = ExcelUtil.getWriter(newFilePath);

        writeSheet1(writer);
        //改sheet名称
        writer.renameSheet(0, "sheet1");

        writer.setSheet("表2");
        writeSheet2(writer);

        //如果有用了公式，用这个来使公式生效
        Workbook workbook = writer.getWorkbook();
        workbook.setForceFormulaRecalculation(true);
        writer.close();
    }

    private static void writeSheet1(ExcelWriter writer) {
        //设置字体
        Font font = writer.createFont();
        font.setFontName("黑体");
        font.setFontHeightInPoints((short) 12);
        //设置头样式。去除背景setFillPattern
        CellStyle headCellStyle = writer.getHeadCellStyle();
        headCellStyle.setFillPattern(FillPatternType.NO_FILL);
        headCellStyle.setFont(font);
        headCellStyle.setBorderTop(BorderStyle.NONE);
        headCellStyle.setBorderRight(BorderStyle.NONE);
        headCellStyle.setAlignment(HorizontalAlignment.LEFT);
        List<Sheet8Statistic> data1 = CollUtil.newArrayList();
        //跳过前的几行
        writer.passRows(4);
        //写入表1的内容
        writer.write(data1);
        //表1写完了，再跳一行
        writer.passRows(1);
        //生成第一张表的表头信息。合并单元格
        writer.merge(5, 5 , 0, 7, "（三）标题", true);
        writer.merge(6, 7 , 0, 0, "", false);
        writer.merge(6, 7 , 1, 1, "本期", false);
        writer.merge(6, 6 , 2, 3, "上期", false);
        writer.merge(6, 6 , 4, 5, "去年同期", false);
        writer.merge(6, 6 , 6, 7, "今年以来", false);
        //跳过刚刚的表头信息行
        writer.passRows(2);
        List<Sheet8Statistic> data2 = CollUtil.newArrayList();
        data2.add(0, new Sheet8Statistic("x", "xx", "2件", "+10%", "3件", "20%", "4件", "4%"));
        writer.write(data2);
    }


    private static void writeSheet2(ExcelWriter writer) {
        //设置字体
        Font font = writer.createFont();
        font.setFontName("黑体");
        font.setFontHeightInPoints((short) 12);
        //设置头样式。去除背景setFillPattern
        CellStyle headCellStyle = writer.getHeadCellStyle();
        headCellStyle.setFillPattern(FillPatternType.NO_FILL);
        headCellStyle.setFont(font);
        headCellStyle.setBorderTop(BorderStyle.NONE);
        headCellStyle.setBorderRight(BorderStyle.NONE);
        headCellStyle.setAlignment(HorizontalAlignment.LEFT);
        List<Sheet8Statistic> data1 = CollUtil.newArrayList();

        //写入表1的内容
        writer.write(data1);
        //生成第二张表的表头信息。合并单元格
        writer.merge(0,  0, 0, 7, "雇主责任险", true);
        writer.merge(1 , 1, 0, 1, "份数", false);
        writer.merge(1 , 1, 2, 3, "金额", false);
        writer.merge(1 , 1, 4, 5, "变动原因", false);
        writer.merge(1 , 1, 6, 7, "备注", false);
        //跳过刚刚的表头信息行
        writer.passRows(2);
        List<Sheet8Statistic> data2 = CollUtil.newArrayList();
        data2.add(0, new Sheet8Statistic("x", "xx", "2件", "+10%", "3件", "20%", "4件", "4%"));
        writer.write(data2);
    }
}
