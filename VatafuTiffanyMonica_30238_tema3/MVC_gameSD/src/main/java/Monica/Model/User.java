package Monica.Model;

public class User {
    private int id;
    private String name_user;
    private String psw_user;

    public User() {
    }

    public User(int id_user) {
        this.id = id_user;
    }

    public User(String name_user, String psw_user) {
        this.name_user = name_user;
        this.psw_user = psw_user;
    }

    public User(int id_user, String name_user, String psw_user) {
        this.id = id_user;
        this.name_user = name_user;
        this.psw_user = psw_user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id_user) {
        this.id = id_user;
    }

    public String getName_user() {
        return name_user;
    }

    public void setName_user(String name_user) {
        this.name_user = name_user;
    }

    public String getPsw_user() {
        return psw_user;
    }

    public void setPsw_user(String psw_user) {
        this.psw_user = psw_user;
    }
}
