import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Lecture {
    private String id;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String topic;
    private int numSlides;
    private String video;
    private String timeAndDate;

    public String getTimeAndDate() {
        return this.timeAndDate;
    }

    public void setTimeAndDate(String timeAndDate) {
        this.timeAndDate = timeAndDate;
    }

    private String videoFileName;
//    private static HashMap<String,ArrayList<String>> topicToSlides;
//    private static HashMap<String,ArrayList<String>> topicToVideo;
    private ArrayList<String> slides=new ArrayList<>();

    public Lecture(){
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






    public void setLectureInstructor(String id){
        this.id=id;
    }

    public String getVideo() {
        return this.video;
    }

    public void setVideo(String video) {
        this.video=video;
//        if(topicToVideo.get(this.topic)==null){
//            ArrayList<String> videoArr=new ArrayList<>();
//            videoArr.add(video);
//            topicToSlides.put(this.topic,videoArr);
//        }else{
//            topicToSlides.get(this.topic).add(video);
//        }
    }



    public ArrayList<String> getSlides() {
        return slides;
    }

    public void setSlides(String content) {

        slides.add(content);
//        if(topicToSlides.get(this.topic)==null){
//            ArrayList<String> slideArr=new ArrayList<>();
//            slideArr.add(content);
//            topicToSlides.put(this.topic,slideArr);
//        }else{
//            topicToSlides.get(this.topic).add(content);
//        }

    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getNumSlides() {
        return numSlides;
    }

    public void setNumSlides(int numSlides) {
        this.numSlides = numSlides;
    }


}
