package dzh.com.DesignPattern.DesignPattern.ProtoType.weeklyLog;

public class App {
    public static void main(String[] args) throws CloneNotSupportedException {
        Attachment attachment=new Attachment();
        attachment.setName("病毒");

        WeeklyLog weeklyLog =new WeeklyLog();
        weeklyLog.setName("愉快的一周");
        weeklyLog.setContent("我和章鱼哥愉快的一天");
        weeklyLog.setDate("2023-8-9");
        weeklyLog.setAttachment(attachment);

        WeeklyLog weeklyLogClone = (WeeklyLog) weeklyLog.clone();

        System.out.println(weeklyLog);
        System.out.println(weeklyLogClone);
    }
}
