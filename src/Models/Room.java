package Models;

public class Room {
    private int id;
    private String number;
    private String title;
    private String description;
    private String imageUrl;
    private float price;
    private int maxNumberOfGuest;

    public Room(){};

    public Room(int id, String title){
        this.id = id;
        this.title = title;
    }

    public Room(int id, String number, String title, String description) {
        this.id = id;
        this.title = title;
        this.number = number;
        this.description = description;
    }

    public Room(int id, String number, String title, String description, float price, int maxGuests) {
        this.id = id;
        this.title = title;
        this.number = number;
        this.description = description;
        this.price = price;
        this.maxNumberOfGuest = maxGuests;
    }

    public Room(String number, String title, String description, String imgUrl, float price, int maxNumberOfGuest) {
        this.number = number;
        this.title = title;
        this.description = description;
        this.imageUrl = imgUrl;
        this.price = price;
        this.maxNumberOfGuest = maxNumberOfGuest;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getMaxNumberOfGuest() {
        return maxNumberOfGuest;
    }

    public void setMaxNumberOfGuest(int maxNumberOfGuest) {
        this.maxNumberOfGuest = maxNumberOfGuest;
    }
}
