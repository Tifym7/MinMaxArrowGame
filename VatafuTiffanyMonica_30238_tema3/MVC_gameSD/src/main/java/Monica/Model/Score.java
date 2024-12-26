package Monica.Model;

public class Score {
    private int id;
    private int value;
    private int level;
    private int id_user;

    public Score() {
    }

    public Score(int id_score) {
        this.id = id_score;
    }

    public Score(int value, int id_user,int level) {
        this.value = value;
        this.level = level;
        this.id_user = id_user;

    }

    public Score(int id_score, int value, int id_user,int level) {
        this.id = id_score;
        this.value = value;
        this.id_user = id_user;
        this.level = level;
    }

    public void setId(int id_score) {
        this.id = id_score;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_user() {
        return id_user;
    }

    public int getId() {
        return id;
    }

    public int getValue() {
        return value;
    }

    public int getLevel() {
        return level;
    }
}
