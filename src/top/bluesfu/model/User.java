package top.bluesfu.model;


/**
 * @author fsy
 */
public class User {
    private String id;
    private String name;
    private String password;
    private String email;

    public String getId() {
        return id;
    }
    public String getName(){
        return name;
    }
    public String getPassword(){
        return password;
    }
    public String getEmail(){
        return email;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email){
        this.email=email;
    }



}
