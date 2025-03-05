package model;

import java.util.Date;

public class Donation {
    private int id;
    private int userId;
    private int itemId;
    private Date donationDate;

    public Donation(int i, String name, String location) {}

    public Donation(int id, int userId, int itemId, Date donationDate) {
        this.id = id;
        this.userId = userId;
        this.itemId = itemId;
        this.donationDate = donationDate;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public int getItemId() { return itemId; }
    public void setItemId(int itemId) { this.itemId = itemId; }

    public Date getDonationDate() { return donationDate; }
    public void setDonationDate(Date donationDate) { this.donationDate = donationDate; }
}
