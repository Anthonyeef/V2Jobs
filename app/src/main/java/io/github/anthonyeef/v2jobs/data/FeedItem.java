package io.github.anthonyeef.v2jobs.data;

/**
 * Created by anthonyeef on 8/15/15.
 */
public class FeedItem {
    private int id;
    private String name, avatar, timeStamp;

    public FeedItem() {}

    public FeedItem(int id, String name, String avatar, String timeStamp){
        super();
        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.timeStamp = timeStamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
