// EWasteItem.java
public class EWasteItem {
    private int id;
    private String name;
    private String type;
    private String condition;

    // Constructors, Getters, and Setters
    public EWasteItem(int id, String name, String type, String condition) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.condition = condition;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "EWasteItem [id=" + id + ", name=" + name + ", type=" + type + ", condition=" + condition + "]";
    }
}
