package service;

import model.CollectionCenter;
import java.util.ArrayList;
import java.util.List;

public class CollectionCenterService {
    private List<CollectionCenter> centers = new ArrayList<>();

    public void addCenter(CollectionCenter center) {
        centers.add(center);
    }

    public List<CollectionCenter> getAllCenters() {
        return centers;
    }

    public CollectionCenter getCenterById(int id) {
        return centers.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }
}
