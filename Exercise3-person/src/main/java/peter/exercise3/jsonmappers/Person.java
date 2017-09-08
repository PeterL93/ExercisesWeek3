package peter.exercise3.jsonmappers;

public class Person {

    private int id;

    private String fName;
    private String lName;
    private int Phone;

    public Person(String fName, String lName, int Phone,int id) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.Phone = Phone;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public int getPhone() {
        return Phone;
    }

    public void setPhone(int Phone) {
        this.Phone = Phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Entity.Entity[ id=" + id + " ]";
    }

}
