package dzh.com.tools.Alibaba.fastJson.Alibaba.fastJson;

import com.alibaba.fastjson.JSON;
import dzh.com.tools.Alibaba.fastJson.Alibaba.fastJson.domain.SocialExp;
import dzh.com.tools.Alibaba.fastJson.Alibaba.fastJson.domain.SocialSecurityExp;

import java.math.BigDecimal;
import java.util.List;

public class FastJsonTest {

    public static void main(String[] args) {

        SocialExp securityExp = new SocialExp().setEntryName("短视").setCardinality(new BigDecimal(100)).setCode("12").setSums(12L);
        String jsonString = JSON.toJSONString(securityExp);
        System.out.println(jsonString);
        SocialSecurityExp socialSecurityExps = JSON.parseObject(jsonString, SocialSecurityExp.class);
        System.out.println(socialSecurityExps);

        List<SocialSecurityExp> securityExpList = JSON.parseArray(
            "[{\"status\": \"1\", \"accountId\": \"91\", \"entryCode\": \"1\", \"entryName\": \"养老保险\", " + "\"accountName\": \"中国测试\", \"cardinality\": 100, \"takeEffectDate\": 1648742400000}, {\"status\": " + "\"1\", \"accountId\": \"91\", \"entryCode\": \"2\", \"entryName\": \"医疗保险\", \"accountName\":" + " \"中国测试\", \"cardinality\": 100, \"takeEffectDate\": 1648742400000}]",
            SocialSecurityExp.class);
        System.out.println(securityExpList);
    }

}
