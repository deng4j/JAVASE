package dzh.com.tools.Alibaba.fastJson.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

@NoArgsConstructor
@Accessors(chain = true)
@Builder
@Data
@AllArgsConstructor
public class SocialSecurityExp implements Serializable {

    private static final long serialVersionUID = 1L;

    private String entryName;

    private BigDecimal cardinality;

}
