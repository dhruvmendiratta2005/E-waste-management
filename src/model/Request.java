package model;

public class Request {
    private int id;
    private int userId;
    private int itemId;
    private String status;

    public Request(int id, int userId, int itemId, String status) {
        this.id = id;
        this.userId = userId;
        this.itemId = itemId;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public int getItemId() {
        return itemId;
    }

    public String getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "model.Request{" +
                "id=" + id +
                ", userId=" + userId +
                ", itemId=" + itemId +
                ", status='" + status + '\'' +
                '}';
    }
}
