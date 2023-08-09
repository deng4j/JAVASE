package dzh.com.tools.hutools.excel;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

public class TestExcel2 {

    public static void main(String[] args) {
        Long name=System.currentTimeMillis();
        String filePath = "D:\\window\\temp\\"+name+".xlsx";

        test2(filePath);
    }
    public static void test2(String file){
        ExcelWriter writer = ExcelUtil.getWriter(true);

        writer.renameSheet("库龄");
        writer.merge(0, 1, 0, 0, "序号", true);
        writer.merge(0, 1, 1, 1,"市场", true);

        writer.merge(0, 0, 2, 3,"库龄>720天", true);
        writer.writeCellValue(2,1,"金额（万元）");
        writer.writeCellValue(3,1,"体积（方）");

        writer.merge(0, 0,4,5,"库龄360-720天", true);
        writer.writeCellValue(4,1,"金额（万元）");
        writer.writeCellValue(5,1,"体积（方）");

        writer.merge(0, 0,6,7,"库龄90-180天", true);
        writer.writeCellValue(6,1,"金额（万元）");
        writer.writeCellValue(7,1,"体积（方）");

        writer.merge(0, 0,8,9,"库龄<90天", true);
        writer.writeCellValue(8,1,"金额（万元）");
        writer.writeCellValue(9,1,"体积（方）");

        writer.merge(0, 0,10,11,"合计", true);
        writer.writeCellValue(10,1,"金额（万元）");
        writer.writeCellValue(11,1,"体积（方）");


        writer.merge(2,2,0,1,"海外商品事业三部合计",true);
        writer.writeCellValue(2,2,"580");
        writer.writeCellValue(3,2,"171");
        writer.writeCellValue(4,2,"171");
        writer.writeCellValue(5,2,"171");
        writer.writeCellValue(6,2,"171");
        writer.writeCellValue(7,2,"171");
        writer.writeCellValue(8,2,"171");
        writer.writeCellValue(9,2,"171");
        writer.writeCellValue(10,2,"171");
        writer.writeCellValue(11,2,"171");

        AtomicInteger integer = new AtomicInteger(1);
        writer.writeCellValue(0,3,integer.getAndIncrement());
        writer.writeCellValue(1,3,"中东及非洲区");
        writer.writeCellValue(2,3,"580");
        writer.writeCellValue(3,3,"171");
        writer.writeCellValue(4,3,"171");
        writer.writeCellValue(5,3,"171");
        writer.writeCellValue(6,3,"171");
        writer.writeCellValue(7,3,"171");
        writer.writeCellValue(8,3,"171");
        writer.writeCellValue(9,3,"171");
        writer.writeCellValue(10,3,"171");
        writer.writeCellValue(11,3,"171");


        CellStyle cellStyle = writer.createCellStyle();
        Font font = writer.createFont();
        //红色字体
        font.setColor(HSSFColor.HSSFColorPredefined.DARK_RED.getIndex());
        //字体加粗
        font.setBold(true);
        cellStyle.setFont(font);

        //垂直居中
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        //水平居中
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        //设置4个边框
        cellStyle.setBorderTop(BorderStyle.NONE);
        cellStyle.setBorderRight(BorderStyle.NONE);
        cellStyle.setBorderBottom(BorderStyle.NONE);
        cellStyle.setBorderLeft(BorderStyle.NONE);

        //设置背景颜色
        cellStyle.setFillForegroundColor(HSSFColor.HSSFColorPredefined.PALE_BLUE.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);


        ;
        //设置头部背景颜色
        writer.getHeadCellStyle().setFillForegroundColor(HSSFColor.HSSFColorPredefined.PALE_BLUE.getIndex());
        writer.getHeadCellStyle().setFillPattern(FillPatternType.SOLID_FOREGROUND);
        Font headerFont = writer.createFont();
        headerFont.setBold(true);
        writer.getHeadCellStyle().setFont(headerFont);
        writer.setDefaultRowHeight(20);

        //设置第一行区域灰色
        CellStyle cellStyle1 = writer.createCellStyle();
        //设置灰色
        cellStyle1.setFillForegroundColor(HSSFColor.HSSFColorPredefined.GREY_25_PERCENT.getIndex());
        cellStyle1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        //设置垂直居中和水平居中
        cellStyle1.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyle1.setAlignment(HorizontalAlignment.CENTER);
        //设置左右边框
        cellStyle1.setBorderLeft(BorderStyle.NONE);
        cellStyle1.setBorderRight(BorderStyle.NONE);
        //设置字体加粗
        Font font1 = writer.createFont();
        font1.setBold(true);
        cellStyle1.setFont(font1);

        for(int i=0;i<=11;i++){

            if( 2<= i && i<=7){
                //第2列到第7列  设置表头部分样式 红色字体
                writer.setStyle(cellStyle,i,0);
                //第2列到第7列 设置表头部分样式 红色字体
                writer.setStyle(cellStyle,i,1);
            }else{
                //设置表头部分样式
                writer.setStyle(writer.getHeadCellStyle(),i,0);
                //设置表头部分样式
                writer.setStyle(writer.getHeadCellStyle(),i,1);
            }
            //设置第一行汇总数据样式
            writer.setStyle(cellStyle1,i,2);
            //设置列宽
            writer.setColumnWidth(i,16);
        }


        writeIP(writer);
        writeExists(writer);
        //ExportUtil.headers(response, true, filename);
        //writer.flush(response.getOutputStream());
        writer.flush(new File(file));
        writer.close();
    }

    //写 ip节庆版权
    public static void writeIP(ExcelWriter writer){
        writer.setSheet("临期版权节庆");

        writer.merge(0, 1, 0, 0, "序号", true);
        writer.merge(0, 1, 1, 1,"市场", true);

        writer.merge(0, 0, 2, 3,"临期（有效期<540天）", true);
        writer.writeCellValue(2,1,"金额（万元）");
        writer.writeCellValue(3,1,"体积（方）");

        writer.merge(0, 0,4,5,"版权（距版权终止期<=270天）", true);
        writer.writeCellValue(4,1,"金额（万元）");
        writer.writeCellValue(5,1,"体积（方）");

        writer.merge(0, 0,6,7,"版权（强圣诞&强万圣）", true);
        writer.writeCellValue(6,1,"金额（万元）");
        writer.writeCellValue(7,1,"体积（方）");

        writer.merge(0, 0,8,9,"合计（去重汇总）", true);
        writer.writeCellValue(8,1,"金额（万元）");
        writer.writeCellValue(9,1,"体积（方）");




        writer.merge(2,2,0,1,"海外商品事业三部合计",true);
        writer.writeCellValue(2,2,"580");
        writer.writeCellValue(3,2,"171");
        writer.writeCellValue(4,2,"171");
        writer.writeCellValue(5,2,"171");
        writer.writeCellValue(6,2,"171");
        writer.writeCellValue(7,2,"171");
        writer.writeCellValue(8,2,"171");
        writer.writeCellValue(9,2,"171");

        AtomicInteger integer = new AtomicInteger(1);
        writer.writeCellValue(0,3,integer.getAndIncrement());
        writer.writeCellValue(1,3,"中东及非洲区");
        writer.writeCellValue(2,3,"580");
        writer.writeCellValue(3,3,"171");
        writer.writeCellValue(4,3,"171");
        writer.writeCellValue(5,3,"171");
        writer.writeCellValue(6,3,"171");
        writer.writeCellValue(7,3,"171");
        writer.writeCellValue(8,3,"171");
        writer.writeCellValue(9,3,"171");


        Font font = writer.createFont();
        //字体加粗
        font.setBold(true);

        //设置头部背景颜色 字体 默认行高
        writer.getHeadCellStyle().setFillForegroundColor(HSSFColor.HSSFColorPredefined.PALE_BLUE.getIndex());
        writer.getHeadCellStyle().setFillPattern(FillPatternType.SOLID_FOREGROUND);
        writer.getHeadCellStyle().setFont(font);
        writer.setDefaultRowHeight(20);

        //设置第一行区域灰色
        CellStyle cellStyle1 = writer.createCellStyle();
        //设置灰色
        cellStyle1.setFillForegroundColor(HSSFColor.HSSFColorPredefined.GREY_25_PERCENT.getIndex());
        cellStyle1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        //设置垂直居中和水平居中
        cellStyle1.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyle1.setAlignment(HorizontalAlignment.CENTER);
        //设置左右边框
        cellStyle1.setBorderLeft(BorderStyle.NONE);
        cellStyle1.setBorderRight(BorderStyle.NONE);

        Font font1 = writer.createFont();
        font1.setBold(true);
        font1.setFontHeightInPoints((short)12);

        cellStyle1.setFont(font1);

        for(int i=0;i<=9;i++){
            //设置表头部分样式
            writer.setStyle(writer.getHeadCellStyle(),i,0);
            //设置表头部分样式
            writer.setStyle(writer.getHeadCellStyle(),i,1);
            //设置第一行汇总数据样式
            writer.setStyle(cellStyle1,i,2);
            //设置列宽
            writer.setColumnWidth(i,16);
        }
    }


    //在库未提
    public static void writeExists(ExcelWriter writer){

        writer.setSheet("在库未提");

        writer.merge(0, 1, 0, 0, "序号", true);
        writer.merge(0, 1, 1, 1,"市场", true);

        writer.merge(0, 0, 2, 3,"A（超交期60天以上）", true);
        writer.writeCellValue(2,1,"金额（万元）");
        writer.writeCellValue(3,1,"体积（方）");

        writer.merge(0, 0,4,5,"B（超交期30-60天）", true);
        writer.writeCellValue(4,1,"金额（万元）");
        writer.writeCellValue(5,1,"体积（方）");

        writer.merge(0, 0,6,7,"C（超交期15-30天）", true);
        writer.writeCellValue(6,1,"金额（万元）");
        writer.writeCellValue(7,1,"体积（方）");

        writer.merge(0, 0,8,9,"D（交期前后15天内）", true);
        writer.writeCellValue(8,1,"金额（万元）");
        writer.writeCellValue(9,1,"体积（方）");

        writer.merge(0, 0,10,11,"E（交期前置15天以上）", true);
        writer.writeCellValue(10,1,"金额（万元）");
        writer.writeCellValue(11,1,"体积（方）");

        writer.merge(0, 0,12,13,"合计", true);
        writer.writeCellValue(12,1,"金额（万元）");
        writer.writeCellValue(13,1,"体积（方）");


        writer.merge(2,2,0,1,"海外商品事业三部合计",true);
        writer.writeCellValue(2,2,"580");
        writer.writeCellValue(3,2,"171");
        writer.writeCellValue(4,2,"171");
        writer.writeCellValue(5,2,"171");
        writer.writeCellValue(6,2,"171");
        writer.writeCellValue(7,2,"171");
        writer.writeCellValue(8,2,"171");
        writer.writeCellValue(9,2,"171");
        writer.writeCellValue(10,2,"171");
        writer.writeCellValue(11,2,"171");
        writer.writeCellValue(12,2,"171");
        writer.writeCellValue(13,2,"171");

        AtomicInteger integer = new AtomicInteger(1);
        writer.writeCellValue(0,3,integer.getAndIncrement());
        writer.writeCellValue(1,3,"中东及非洲区");
        writer.writeCellValue(2,3,"580");
        writer.writeCellValue(3,3,"171");
        writer.writeCellValue(4,3,"171");
        writer.writeCellValue(5,3,"171");
        writer.writeCellValue(6,3,"171");
        writer.writeCellValue(7,3,"171");
        writer.writeCellValue(8,3,"171");
        writer.writeCellValue(9,3,"171");
        writer.writeCellValue(10,3,"171");
        writer.writeCellValue(11,3,"171");
        writer.writeCellValue(12,3,"171");
        writer.writeCellValue(13,3,"171");


        CellStyle cellStyle = writer.createCellStyle();
        Font font = writer.createFont();
        //红色字体
        font.setColor(HSSFColor.HSSFColorPredefined.DARK_RED.getIndex());
        //字体加粗
        font.setBold(true);
        cellStyle.setFont(font);

        //垂直居中
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        //水平居中
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        //设置4个边框
        cellStyle.setBorderTop(BorderStyle.NONE);
        cellStyle.setBorderRight(BorderStyle.NONE);
        cellStyle.setBorderBottom(BorderStyle.NONE);
        cellStyle.setBorderLeft(BorderStyle.NONE);

        //设置背景颜色
        cellStyle.setFillForegroundColor(HSSFColor.HSSFColorPredefined.PALE_BLUE.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);


        //设置头部背景颜色
        writer.getHeadCellStyle().setFillForegroundColor(HSSFColor.HSSFColorPredefined.PALE_BLUE.getIndex());
        writer.getHeadCellStyle().setFillPattern(FillPatternType.SOLID_FOREGROUND);

        Font headerFont = writer.createFont();
        headerFont.setBold(true);
        writer.getHeadCellStyle().setFont(headerFont);
        writer.setDefaultRowHeight(20);

        //设置第一行区域灰色
        CellStyle cellStyle1 = writer.createCellStyle();
        //设置灰色
        cellStyle1.setFillForegroundColor(HSSFColor.HSSFColorPredefined.GREY_25_PERCENT.getIndex());
        cellStyle1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        //设置垂直居中和水平居中
        cellStyle1.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyle1.setAlignment(HorizontalAlignment.CENTER);
        //设置左右边框
        cellStyle1.setBorderLeft(BorderStyle.NONE);
        cellStyle1.setBorderRight(BorderStyle.NONE);
        //设置字体加粗
        Font font1 = writer.createFont();
        font1.setBold(true);
        cellStyle1.setFont(font1);

        for(int i=0;i<=13;i++){

            if( 2<= i && i<=5){
                //第2列到第7列  设置表头部分样式 红色字体
                writer.setStyle(cellStyle,i,0);
                //第2列到第7列 设置表头部分样式 红色字体
                writer.setStyle(cellStyle,i,1);
            }else{
                //设置表头部分样式
                writer.setStyle(writer.getHeadCellStyle(),i,0);
                //设置表头部分样式
                writer.setStyle(writer.getHeadCellStyle(),i,1);
            }
            //设置第一行汇总数据样式
            writer.setStyle(cellStyle1,i,2);
            //设置列宽
            writer.setColumnWidth(i,14);
        }


    }

}
