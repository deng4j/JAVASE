package dzh.com.DesignPattern.DesignPattern.createPatterns.ProtoType.weeklyLog;

/**
 * 工作周报
 */
public class WeeklyLog implements Cloneable {
    private Attachment attachment;
    private String name;
    private String date;
    private String content;

    public Attachment getAttachment() {
        return attachment;
    }

    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object obj = null;
        try {
            obj=super.clone();
            return obj;
        } catch (CloneNotSupportedException e) {
            System.out.println("不支持克隆");
        }
        return null;
    }

    @Override
    public String toString() {
        return "WeeklyLog{" +
                "attachment=" + attachment +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
