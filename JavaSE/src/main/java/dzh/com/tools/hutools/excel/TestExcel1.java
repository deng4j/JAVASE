package dzh.com.tools.hutools.excel;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import dzh.com.tools.hutools.domain.Student;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class TestExcel1 {

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<Student>() {
            {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                add(new Student("1001", "张三", 23, "男", "陕西西安", "2020-09-01", BigDecimal.valueOf(22.33)));
                add(new Student("1002", "李四", 22, "女", "陕西渭南", "2020-09-01",BigDecimal.valueOf(11.99)));
            }
        };

        // 写入文件
        Long name=System.currentTimeMillis();
        String filePath = "D:\\window\\temp\\"+name+".xlsx";
        ExcelWriter writer = ExcelUtil.getWriter(filePath);

        // 设置标题一样式
        CellStyle cellStyle1 = writer.createCellStyle();
        cellStyle1.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyle1.setAlignment(HorizontalAlignment.CENTER);
        cellStyle1.setBorderTop(BorderStyle.NONE);
        cellStyle1.setBorderBottom(BorderStyle.NONE);
        cellStyle1.setBorderLeft(BorderStyle.NONE);
        cellStyle1.setBorderRight(BorderStyle.NONE);
        Font font = writer.createFont();
        font.setBold(true);
        font.setFontHeightInPoints((short) 12);
        font.setFontName("微软雅黑");
        cellStyle1.setFont(font);

        // 标题一
        writer.merge(0,0,0,11, "BOM报价单", false);
        // 标题二
        writer.merge(1,1,0,3,"您上传的BOM", false);
        writer.merge(1, 1 ,4,9,"商城报价单", true);
        writer.merge(1,1,10,11,"总价（含税）: "+ " 99.99",true);
        // 跳过前面两行（为了设置标题样式）原始的设置标题方法，不可以，例：merge(3, "标题名", false);
        writer.passRows(2);

        // 设置高度（行row）
        writer.setRowHeight(0, 50);
        writer.setRowHeight(1, 30);


        // 设置导出信息的表头
        writer.addHeaderAlias("sno", "学号");
        writer.addHeaderAlias("name", "姓名");
        writer.addHeaderAlias("age", "年龄");
        writer.addHeaderAlias("gender", "性别");
        writer.addHeaderAlias("nativePlace", "籍贯");
        writer.addHeaderAlias("enrollmentTime", "入学时间");
        writer.addHeaderAlias("money", "金钱");

        // 设置列宽（Colum）
        writer.setColumnWidth(5, 20);
        writer.setColumnWidth(10, 10);
        writer.setColumnWidth(11, 10);

        // 设置导出表头样式，但不包括合并单元格
        CellStyle headCellStyle = writer.getHeadCellStyle();
        headCellStyle.setFillForegroundColor(HSSFColor.HSSFColorPredefined.LIME.getIndex());
        headCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        // 写入
        writer.write(studentList, true);

        // 主要针对自定义表头设置 行高（必须要写入完成后才可以设置）
        for (int i = 2; i < studentList.size(); i++) {
            writer.setRowHeight(i,20);
        }
        writer.close();
    }
}
