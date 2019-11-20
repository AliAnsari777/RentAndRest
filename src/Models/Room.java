package Models;

public class Room {
    private String number;
    private String title;
    private String description;
    private String imageUrl;
    private float price;

    public Room(){

    };

    public Room(String number, String title, String description, String imgUrl, float price) {
        this.number = number;
        this.title = title;
        this.description = description;
        this.imageUrl = imgUrl;
        this.price = price;
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
}
