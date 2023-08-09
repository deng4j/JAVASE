package dzh.com.tools.hutools.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
public class StudentVO {
    private int id;
    private String name;
    private Date createDate;
}
