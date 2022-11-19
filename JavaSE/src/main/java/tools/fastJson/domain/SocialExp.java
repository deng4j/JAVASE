package tools.fastJson.domain;


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
public class SocialExp implements Serializable {

    private static final long serialVersionUID = 1L;

    private String entryName;

    private Long sums;

    private String code;

    private BigDecimal cardinality;

}
