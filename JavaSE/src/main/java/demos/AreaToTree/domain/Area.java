package demos.AreaToTree.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 地区对象 area
 *
 * @author ruoyi
 * @date 2021-12-24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Area implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 上级城市
     */
    private Integer pid;

    /**
     * 地区名称
     */
    private String name;
}
