package dzh.com.tools.hutools;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.text.StrBuilder;
import cn.hutool.core.util.StrUtil;

import java.util.Date;

public class StrBuilderTest {

    public static void main(String[] args) {
        m1();
    }

    private static void m1() {
        StrBuilder strBuilder=new StrBuilder();
        strBuilder.append("BS20220801-001");
        String string = strBuilder.subString(0,strBuilder.length() - 1);
        System.out.println(string);

        String subString = strBuilder.subString(11);
        System.out.println(subString);
    }

    private static void getNumbers() {

        String num="BS20220801-001";

        StrBuilder oddNumbers =  new StrBuilder();
        oddNumbers.append("BS"+ DateUtil.format(new Date(),"yyyyMMdd")+"-");
        if (StrUtil.isNotBlank(num)){
            String substring = num.substring(11);
            String no = String.valueOf(Integer.valueOf(substring) + 1);
            if (no.length()==1){
                no="00"+no;
            }else if (no.length()==2){
                no="0"+no;
            }
            oddNumbers.append(no);
        }else {
            oddNumbers.append("001");
        }
        System.out.println(oddNumbers);
    }
}
