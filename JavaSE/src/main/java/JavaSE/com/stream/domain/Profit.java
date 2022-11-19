package JavaSE.com.stream.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 *
 * @author 舒澳
 * @since 2022-02-15
 */
@Data
@NoArgsConstructor
public class Profit implements Serializable {

    private Integer pid;

    private Integer id;



    public Profit(Integer pid, Integer id) {
        this.id = id;
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "Profit{" + "pid=" + pid + ", id=" + id + '}'+"\n";
    }
}