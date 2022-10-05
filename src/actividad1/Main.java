package actividad1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    //Creación del directorio
    File directory = new File("src" + File.separator + "actividad1");
    directory.mkdir();

    System.out.println("Introduzca su nombre de usuario.");
    Scanner input = new Scanner(System.in);
    String userName = input.nextLine();

    //Creación del archivo
    File userFile = new File(directory.getAbsolutePath() + File.separator + userName);
    try {
      userFile.createNewFile();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
