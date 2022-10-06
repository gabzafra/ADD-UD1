package actividad6;

public class Contact {

  private String name;
  private String surname;
  private int phone;

  public Contact() {
    this("", "", 0);
  }

  public Contact(String name, String surname, int phone) {
    this.name = name;
    this.surname = surname;
    this.phone = phone;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public int getPhone() {
    return phone;
  }

  public void setPhone(int phone) {
    this.phone = phone;
  }
}
