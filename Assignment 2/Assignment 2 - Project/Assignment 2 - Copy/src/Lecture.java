import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Lecture {

    private String topic;
    private int numSlides;
    private String video;
    private static HashMap<String,ArrayList<String>> topicToSlides;
    private static HashMap<String,ArrayList<String>> topicToVideo;

    public ArrayList<String> getVideo() {
        return topicToVideo.get(this.topic);
    }

    public void setVideo(String video) {
        if(topicToVideo.get(this.topic)==null){
            ArrayList<String> videoArr=new ArrayList<>();
            videoArr.add(video);
            topicToSlides.put(this.topic,videoArr);
        }else{
            topicToSlides.get(this.topic).add(video);
        }
    }



    public ArrayList<String> getSlides() {
        return topicToSlides.get(this.topic);
    }

    public void setSlides(String content) {

        if(topicToSlides.get(this.topic)==null){
            ArrayList<String> slideArr=new ArrayList<>();
            slideArr.add(content);
            topicToSlides.put(this.topic,slideArr);
        }else{
            topicToSlides.get(this.topic).add(content);
        }

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
