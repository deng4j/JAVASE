package dzh.com.tools.hutools.excel;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import cn.hutool.poi.excel.StyleSet;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddressList;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class API {

    /**
     * 方法描述: 设置基础字体样式字体 这里保留最基础的样式使用
     *
     * @param workbook 工作簿
     * @param bold     是否粗体
     * @param fontName 字体名称
     * @param fontSize 字体大小
     * @return org.apache.poi.ss.usermodel.Font
     * @author wqf
     * @date 2021/5/19 15:58
     */
    public static Font setBaseFont(Workbook workbook, boolean bold, boolean italic, String fontName, int fontSize) {
        Font font = workbook.createFont();
        //设置字体名称 宋体 / 微软雅黑 /等
        font.setFontName(fontName);
        //设置是否斜体
        font.setItalic(italic);
        //设置字体高度
        //font.setFontHeight((short) fontHeight);
        //设置字体大小 以磅为单位
        font.setFontHeightInPoints((short)fontSize);
        //设置是否加粗
        font.setBold(bold);
        //默认字体颜色
        // font.setColor(Font.COLOR_NORMAL);
        //红色
        //font.setColor(Font.COLOR_RED);
        //设置下划线样式
        //font.setUnderline(Font.ANSI_CHARSET);
        //设定文字删除线
        //font.setStrikeout(true);
        return font;
    }

    private static StyleSet GlobalStyleSet(ExcelWriter writer, Workbook workbook, Font font) {
        //全局样式设置，对使用了其他样式的单元格不会生效
        StyleSet styleSet = writer.getStyleSet();
        CellStyle cellStyle = styleSet.getCellStyle();

        //设置全局文本居中
        styleSet.setAlign(HorizontalAlignment.CENTER, VerticalAlignment.CENTER);
        //设置全局字体样式
        styleSet.setFont(font, false);
        //设置背景颜色 第二个参数表示是否将样式应用到头部
        styleSet.setBackgroundColor(IndexedColors.WHITE, true);
        //设置自动换行 当文本长于单元格宽度是否换行
        styleSet.setWrapText();
        // 设置全局边框样式
        styleSet.setBorder(BorderStyle.THIN, IndexedColors.BLACK);

        //设置头部标题样式
        CellStyle headCellStyle = styleSet.getHeadCellStyle();
        //水平居中
        headCellStyle.setAlignment(HorizontalAlignment.CENTER);
        //垂直居中
        headCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        //设置字体样式
        headCellStyle.setFont(setBaseFont(workbook, true, false, "宋体", 12));

        //示例：将单元格背景填充为黄色
        cellStyle.setFillForegroundColor(IndexedColors.YELLOW.index);
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        // 内容水平居中
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        // 内容垂直居中
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        // 设置边框
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);

        // 保留两位小数
        CellStyle cellStyleForNumber = styleSet.getCellStyleForNumber();
        cellStyleForNumber.setDataFormat((short)2);

        CellStyle cellStyleForDate = styleSet.getCellStyleForDate();
        //14 代表的时间格式是 yyyy/MM/dd
        cellStyleForDate.setDataFormat((short)14);

        writer.setStyleSet(styleSet);
        return styleSet;
    }


    public void cell() {
        //获取输出构造器 设置工作簿名称
        ExcelWriter writer = ExcelUtil.getWriterWithSheet("sheetName");
        Workbook workbook = writer.getWorkbook();
        Sheet sheet = writer.getSheet();

        int rowIndex = 1;
        Row row = sheet.getRow(rowIndex);
        if (sheet.getRow(rowIndex) == null) {
            //rowIndex 表示的是第几行，例：创建第二行，rowIndex=1
            sheet.createRow(rowIndex);
        }
        //创建样式
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyle.setAlignment(HorizontalAlignment.LEFT);
        cellStyle.setFont(setBaseFont(workbook, true, false, "宋体", 12));
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);
        cellStyle.setBorderTop(BorderStyle.THIN);
        //应用样式到某一行（
        row.setRowStyle(cellStyle);

        //表示 第一列的列宽是15
        writer.setColumnWidth(0, 15);

        //跳过当前行
        writer.passCurrentRow();

        //定位到最后一行，常用于在末尾追加数据
        writer.passCurrentRow();
    }

   public void headerAlias(){
       ExcelWriter writer = ExcelUtil.getWriterWithSheet("sheetName");
       //设置head
       writer.writeHeadRow(new ArrayList<>());
       //LinkedHashMap 中的数据是根据put先后顺序来的，HashMap数据时无序的。
       //使用方法 writer.setHeaderAlias(headerAlias); 时如果使用HashMap 可能展示的数据顺序会错乱
       Map<String, String> headerAlias = new LinkedHashMap<>();
       headerAlias.put("字段名1", "列名1");
       headerAlias.put("字段名2", "列名2");
       writer.setHeaderAlias(headerAlias);
       //或者一项一项设置列的别名 列别名顺序会跟代码中addHeaderAlias顺序一致
       writer.addHeaderAlias("字段名1","列名1");
       writer.addHeaderAlias("字段名2","列名2");
   }

    /**
     * excel 添加下拉框
     */
   public void x(){
       ExcelWriter writer = ExcelUtil.getWriterWithSheet("sheetName");
       Sheet sheet = writer.getSheet();

       CellRangeAddressList addressList = new CellRangeAddressList(2, 2, 5, 5);
       DataValidationHelper helper = sheet.getDataValidationHelper();
       // 设置下拉框数据
       String[] str = new String[]{"男", "女","阴阳人"};
       DataValidationConstraint constraint = helper.createExplicitListConstraint(str);
       DataValidation dataValidation = helper.createValidation(constraint, addressList);
       writer.addValidationData(dataValidation);
   }

}
