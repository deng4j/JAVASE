package dzh.com.JavaSE.com.characteristic.stream.domain;

public class SocialSecurityExp {

    private String entryName;

    private Integer afterCardinality;

    public SocialSecurityExp( String entryName, Integer afterCardinality) {
        this.entryName = entryName;
        this.afterCardinality = afterCardinality;
    }

    public SocialSecurityExp() {
    }

    public String getEntryName() {
        return entryName;
    }

    public void setEntryName(String entryName) {
        this.entryName = entryName;
    }

    public Integer getAfterCardinality() {
        return afterCardinality;
    }

    public void setAfterCardinality(Integer afterCardinality) {
        this.afterCardinality = afterCardinality;
    }
}
