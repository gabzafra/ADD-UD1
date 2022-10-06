package actividad5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    //URL del archivo de contactos
    String contactsPath = "D:\\DAM\\2022-2023\\_repos\\ADD-UD1\\src\\actividad5\\files\\contactos.txt";

    BufferedWriter contactsFile = null;
    try {
      contactsFile = new BufferedWriter(new FileWriter(contactsPath, true));
    } catch (IOException e) {
      System.out.println("No se encontró el archivo de contactos");
    }

    Scanner input = new Scanner(System.in);

    System.out.println("¿Cuantos contactos desea añadir?");
    int numContacts = input.nextInt();

    if (contactsFile != null) {
      for (int i = 0; i < numContacts; i++) {
        insertFormattedContact(contactsFile, createContact());
      }
    } else {
      System.out.println("No hay un archivo de contactos válido");
    }

    try {
      if (contactsFile != null) {
        contactsFile.close();
      } else {
        System.out.println("No hay un archivo de contactos válido");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void insertFormattedContact(BufferedWriter contactsFile, Contact contact) {
    String formattedString =
        contact.getName() + "#" + contact.getSurname() + "#" + contact.getPhone();
    try {
      if (contactsFile != null) {
        contactsFile.write(formattedString);
        contactsFile.newLine();
      } else {
        System.out.println("No hay un archivo de contactos válido");
      }

    } catch (IOException e) {
      System.out.println("Ha fallado la escritura de " + contact.getName());
    }
  }


  private static Contact createContact() {
    Scanner input = new Scanner(System.in);

    Contact contact = new Contact();
    System.out.println("Introduzca el nombre del nuevo contacto");
    contact.setName(input.nextLine());
    System.out.println("Introduzca el apellido del nuevo contacto");
    contact.setSurname(input.nextLine());
    System.out.println("Introduzca el teléfono del nuevo contacto");
    contact.setPhone(input.nextLine());

    return contact;
  }
}
