package dzh.com.JavaSE.com.characteristic.stream.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class UserInfo {
    private String name;
    private Integer age;
    private Integer money;
}
