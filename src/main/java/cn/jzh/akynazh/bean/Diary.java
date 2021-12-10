package cn.jzh.akynazh.bean;
/*
create table t_diary(
  diary_text text,
  create_date datetime,
  user_id int,
  foreign key(user_id) references td_user(id)
);
*/
public class Diary {
    private Integer user_id;
    private String create_date;
    private String diary_text;

    @Override
    public String toString() {
        return "Diary{" +
                "user_id=" + user_id +
                ", create_date='" + create_date + '\'' +
                ", diary_text='" + diary_text + '\'' +
                '}';
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public String getDiary_text() {
        return diary_text;
    }

    public void setDiary_text(String diary_text) {
        this.diary_text = diary_text;
    }

    public Diary(Integer user_id, String create_date, String diary_text) {
        this.user_id = user_id;
        this.create_date = create_date;
        this.diary_text = diary_text;
    }

    public Diary() {
    }
}
