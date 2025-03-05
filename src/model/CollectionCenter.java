package model;

public class CollectionCenter {
    private int id;
    private String name;
    private String location;
    private String contact;

    public CollectionCenter(int i, String name, String location) {}

    public CollectionCenter(int id, String name, String location, String contact) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.contact = contact;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }
}
