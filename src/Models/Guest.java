package Models;

public class Guest  {
    private int id;
    private String firstName;
    private String lastName;
    private String docType;
    private String docNumber;
    private float rating;
    private String procedence;
    private String language;
    private String note;
    private String guestName;

    public Guest(){}

    public Guest(int id, String  firstName){
        this.id = id;
        this.firstName = firstName;
    }

    public Guest(String firstName, String lastName, String docType, String docNumber,
                 String procedence, String language, String note) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.docType = docType;
        this.docNumber = docNumber;
        this.procedence = procedence;
        this.language = language;
        this.note = note;
    }

    public Guest(int id,String firstName, String lastName, String docType, String docNumber,
                 String procedence, String language, String note,String guestName) {
        this.id=id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.docType = docType;
        this.docNumber = docNumber;
        this.procedence = procedence;
        this.language = language;
        this.note = note;
        this.guestName=guestName;
    }
    public Guest(String firstName, String lastName, String docType, String docNumber,
                 float rating,String procedence, String language, String note,String guestName) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.docType = docType;
        this.docNumber = docNumber;
        this.procedence = procedence;
        this.language = language;
        this.rating=rating;
        this.note = note;
        this.guestName=guestName;
    }
    public Guest(int id,String guestName,float rating, String procedence, String language, String notes){
        this.id = id;
        this.rating = rating;
        this.procedence = procedence;
        this.language = language;
        this.note = notes;
        this.guestName=guestName;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getProcedence() {
        return procedence;
    }

    public void setProcedence(String procedence) {
        this.procedence = procedence;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
