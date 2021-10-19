import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Video {
    private String video;
    private String videoFileName;
    private String timeAndDate;

    public String getTimeAndDate() {
        return this.timeAndDate;
    }

    public void setTimeAndDate(String timeAndDate) {
        this.timeAndDate = timeAndDate;
    }

    private String id;

    public Video(String iden){
        this.id=iden;
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter modifiedTime = DateTimeFormatter.ofPattern("E MMM dd HH:mm:ss yyyy");
        String newTime = time.format(modifiedTime);
        newTime+=" IST";
        this.timeAndDate=newTime;
    }

    public String getVideoFileName() {
        return this.videoFileName;
    }

    public void setVideoFileName(String videoFileName) {
        this.videoFileName = videoFileName;
    }

    public String getVideo() {
        return this.video;
    }

    public void setVideo(String video) {
        this.video=video;

    }

    public String getId(){
        return this.id;
    }
}
