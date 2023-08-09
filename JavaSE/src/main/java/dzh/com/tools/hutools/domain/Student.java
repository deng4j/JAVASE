package dzh.com.tools.hutools.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Object sno;

    private Object name;

    private Object age;

    private Object gender;

    private Object nativePlace;

    private Object enrollmentTime;

    private Object money;
}
