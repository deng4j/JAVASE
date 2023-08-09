package dzh.com.DesignPattern.DesignPattern.Builder.builder3;

import lombok.Data;

/**
 * 角色类：复杂产品
 */
@Data
public class Actor {
    private String type; //角色类型
    private String sex; //性别
    private String face; //脸型
    private String costume; //服装
    private String hairstyle; //发型
}
