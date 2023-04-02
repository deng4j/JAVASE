package demos.AreaToTree.domain;


import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@Accessors(chain = true)
public class AreaVo implements Serializable {

    private Integer id;

    private Integer pid;

    private String name;

    private List<AreaVo> children;

}
