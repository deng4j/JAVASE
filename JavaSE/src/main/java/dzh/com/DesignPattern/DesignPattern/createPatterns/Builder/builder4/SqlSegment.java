package dzh.com.DesignPattern.DesignPattern.createPatterns.Builder.builder4;

import java.util.List;

public class SqlSegment {

    private String fromSql;
    private String rangeSql;
    private List<String> filterSql;
    private String groupSql;

    @Override
    public String toString() {
        return "SqlSegment{" +
                "fromSql='" + fromSql + '\'' +
                ", rangeSql='" + rangeSql + '\'' +
                ", filterSql=" + filterSql +
                ", groupSql='" + groupSql + '\'' +
                '}';
    }

    private SqlSegment(Builder builder) {
        this.fromSql = builder.fromSql;
        this.rangeSql = builder.rangeSql;
        this.filterSql = builder.filterSql;
        this.groupSql = builder.groupSql;
    }

    public static Builder builder(){
        return new Builder();
    }

    static class  Builder{
        private String fromSql;
        private String rangeSql;
        private List<String> filterSql;
        private String groupSql;

        public SqlSegment build(){
            return new SqlSegment(this);
        }

        public Builder fromSql(String fromSql) {
            this.fromSql = fromSql;
            return this;
        }

        public Builder rangeSql(String rangeSql) {
            this.rangeSql = rangeSql;
            return this;
        }

        public Builder filterSql(List<String> filterSql) {
            this.filterSql = filterSql;
            return this;
        }

        public Builder groupSql(String groupSql) {
            this.groupSql = groupSql;
            return this;
        }
    }

    public static void main(String[] args) {
        SqlSegment segment = SqlSegment.builder()
                .fromSql("f")
                .rangeSql("da")
                .filterSql(List.of("aa", "bb"))
                .build();
        System.out.println(segment);
    }

}
