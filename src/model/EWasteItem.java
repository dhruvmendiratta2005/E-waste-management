package model;

public class EWasteItem {
    private int id;
    private String name;
    private String type;
    private String itemCondition;

    public EWasteItem(int id, String name, String type, String itemCondition) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.itemCondition = itemCondition;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getItemCondition() {
        return itemCondition;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setItemCondition(String itemCondition) {
        this.itemCondition = itemCondition;
    }

    @Override
    public String toString() {
        return "model.EWasteItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", itemCondition='" + itemCondition + '\'' +
                '}';
    }
}
