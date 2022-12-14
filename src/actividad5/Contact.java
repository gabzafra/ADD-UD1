package actividad5;

public class Contact {

  private String name;
  private String surname;
  private String phone;

  public Contact() {
    this("", "", "");
  }

  public Contact(String name, String surname, String phone) {
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

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }
}
