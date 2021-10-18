
public class encapsulation {
    private int score;
    private String name;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}

class Main{
    public static void main(String[] args) {
        encapsulation e=new encapsulation();
        e.setName("Rohan");
        e.setScore(100);
        System.out.println(e.getScore());
        System.out.println(e.getName());
    }
}
