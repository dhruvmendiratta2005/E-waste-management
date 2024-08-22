// Request.java
public class Request {
    private int id;
    private User user;
    private EWasteItem item;
    private String status;

    // Constructors, Getters, and Setters
    public Request(int id, User user, EWasteItem item, String status) {
        this.id = id;
        this.user = user;
        this.item = item;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public EWasteItem getItem() {
        return item;
    }

    public void setItem(EWasteItem item) {
        this.item = item;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Request [id=" + id + ", user=" + user + ", item=" + item + ", status=" + status + "]";
    }
}
