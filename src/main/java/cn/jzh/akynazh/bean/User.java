package cn.jzh.akynazh.bean;
/*
create table td_user(
    id int auto_increment,
    username varchar(255),
    password varchar(255),
    description text,
    primary key(id)
);
*/
public class User {
    private Integer id;
    private String username;
    private String password;
    private String description;

    public User(Integer id, String username, String password, String description) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.description = description;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
