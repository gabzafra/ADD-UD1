package actividad6;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    //URL del archivo de contactos
    String contactsPath = "D:\\DAM\\2022-2023\\_repos\\ADD-UD1\\src\\actividad6\\files\\contactos.dat";

    File file = initDataFile(contactsPath);
    initAgenda(file);

    boolean haTerminado = false;
    while (!haTerminado) {
      System.out.println("Elija la opción deseada:");
      System.out.println("1.Buscar contacto");
      System.out.println("2.Añadir contacto");
      System.out.println("3.Eliminar contacto");
      System.out.println("0.Terminar");
      switch (input.nextInt()) {
        case 1 -> findContact(file);
        case 2 -> addNewContact(file);
        case 3 -> deleteContact(file);
        case 0 -> haTerminado = true;
        default -> System.err.println("Debe elegir una opción del menu.");
      }
    }


  }

  private static void findContact(File file) {
    HashMap<String, Contact> contactList = getContactList(file);

    contactList.keySet().forEach(System.out::println);

    Scanner input = new Scanner(System.in);
    System.out.println("Escriba el usuario del cual desea ver sus detalles");
    Contact contact = contactList.get(input.nextLine());
    if (contact != null){
      printContact(contact);
    }else {
      System.err.println("El contacto no existe");
    }
  }

  private static HashMap<String, Contact> getContactList(File file) {
    //No hay verificación de sí el contacto existe así que puede
    //haber problemas con el HashMap supondremos que los nombres son únicos
    HashMap<String, Contact> contactList = new HashMap<>();

    boolean EOF = false;

    try {
      DataInputStream contactData = new DataInputStream(
          new BufferedInputStream(new FileInputStream(file)));
      while (!EOF) {
        Contact contact = new Contact();
        contact.setName(contactData.readUTF());
        contact.setSurname(contactData.readUTF());
        contact.setPhone(contactData.readInt());
        contactList.put(contact.getName(), contact);
      }
    } catch (EOFException e) {
      EOF = true;
    } catch (IOException e) {
      System.out.println("No existe el archivo de contactos");
    }
    return contactList;
  }

  private static void printContact(Contact contact) {
    System.out.println(
        contact.getName() + " " + contact.getSurname() + " > " + contact.getPhone());
  }

  private static void addNewContact(File file) {
    //Ojo! no se verifica si el contacto ya existe!!!
    Contact newContact = createContact();

    DataOutputStream dataFile = null;
    try {
      dataFile = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file,true)));

      dataFile.writeUTF(newContact.getName());
      dataFile.writeUTF(newContact.getSurname());
      dataFile.writeInt(newContact.getPhone());
    } catch (FileNotFoundException e) {
      System.out.println("El archivo de contactos no existe");
    } catch (IOException e) {
      System.out.println("Se ha producido un error al intentar escribir los datos");
    } finally {
      try {
        if (dataFile != null) {
          dataFile.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  private static void deleteContact(File file) {

  }

  private static void initAgenda(File file) {
    DataOutputStream dataFile = null;
    try {
      dataFile = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));

      dataFile.writeUTF("Adam");
      dataFile.writeUTF("Allgood");
      dataFile.writeInt(616554433);
      dataFile.writeUTF("Betty");
      dataFile.writeUTF("Bean");
      dataFile.writeInt(626112233);
      dataFile.writeUTF("Cecil");
      dataFile.writeUTF("Carson");
      dataFile.writeInt(636223322);

    } catch (FileNotFoundException e) {
      System.out.println("El archivo de contactos no existe");
    } catch (IOException e) {
      System.out.println("Se ha producido un error al intentar escribir los datos");
    } finally {
      try {
        if (dataFile != null) {
          dataFile.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  private static File initDataFile(String contactsPath) {
    File file = new File(contactsPath);
    if (!file.exists()) {
      try {
        file.createNewFile();
      } catch (IOException e) {
        System.out.println("No se ha podido crear el archivo de contactos");
      }
    }
    return file;
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
    contact.setPhone(input.nextInt());

    return contact;
  }
}
