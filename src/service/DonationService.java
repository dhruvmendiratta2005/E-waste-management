package service;

import model.Donation;
import java.util.ArrayList;
import java.util.List;

public class DonationService {
    private final List<Donation> donations = new ArrayList<>();
    private int nextId = 1;

    public void addDonation(Donation donation) {
        donation.setId(nextId++);
        donations.add(donation);
        System.out.println("Donation Center added successfully: " + donation);
    }

    public List<Donation> getAllDonations() {
        return new ArrayList<>(donations);
    }

    public Donation getDonationById(int id) {
        return donations.stream()
                .filter(donation -> donation.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void updateDonation(Donation updatedDonation) {
        for (int i = 0; i < donations.size(); i++) {
            if (donations.get(i).getId() == updatedDonation.getId()) {
                donations.set(i, updatedDonation);
                System.out.println("Donation Center updated successfully.");
                return;
            }
        }
        System.out.println("Donation Center not found.");
    }

    public void deleteDonation(int id) {
        if (donations.removeIf(donation -> donation.getId() == id)) {
            System.out.println("Donation Center deleted successfully.");
        } else {
            System.out.println("Donation Center not found.");
        }
    }
}
