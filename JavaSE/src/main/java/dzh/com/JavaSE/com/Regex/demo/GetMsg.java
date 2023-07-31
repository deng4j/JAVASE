package dzh.com.JavaSE.com.Regex.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetMsg {
    public static void main(String[] args) {
        String s = "Validation failed for argument [0] in public com.dzh.washcar.common.AjaxResult com.dzh.washcar.controller.UserInfoController.add(com.dzh.washcar.domain.UserInfo) with 3 errors: [Field error in object 'userInfo' on field 'name': rejected value []; codes [NotBlank.userInfo.name,NotBlank.name,NotBlank.java.lang.String,NotBlank]; " +
                "arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [userInfo.name,name]; arguments []; default message [name]]; default message [用户名不能为空]] " +
                "[Field error in object 'userInfo' on field 'phone': rejected value []; codes [NotBlank.userInfo.phone,NotBlank.phone,NotBlank.java.lang.String,NotBlank]; " +
                "arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [userInfo.phone,phone]; arguments []; default message [phone]]; default message [手机号不能为空]] " +
                "[Field error in object 'userInfo' on field 'carNumber': rejected value [null]; codes [NotBlank.userInfo.carNumber,NotBlank.carNumber,NotBlank.java.lang.String,NotBlank]; " +
                "arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [userInfo.carNumber,carNumber]; arguments []; default message [carNumber]]; default message [车牌号不能为空]]";
        String pattern = "(default message \\[).*?(])";
        Pattern r = Pattern.compile(pattern);

        Matcher m = r.matcher(s);
        while (m.find()) {
            System.out.println("Found value: " + m.group(0) );
        }
    }

    private static void m1() {
        String s = "{[1,2,3,4],'aaa',[名字不能为空]}";
        String pattern = "(\\[).*?(])";
        Pattern r = Pattern.compile(pattern);

        Matcher m = r.matcher(s);
        while (m.find()) {
            System.out.println("Found value: " + m.group(0) );
        }
    }
}

