package actividad4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
//    URLs de los archivos de ejemplo
//    String file1Path = "D:\\DAM\\2022-2023\\_repos\\ADD-UD1\\src\\actividad4\\files\\doc1.txt";
//    String file2Path = "D:\\DAM\\2022-2023\\_repos\\ADD-UD1\\src\\actividad4\\files\\doc2.txt";

    Scanner input = new Scanner(System.in);
    System.out.println("Introduzca la URL del primer archivo");
    String file1Path = input.nextLine();
    System.out.println("Introduzca la URL del segundo archivo");
    String file2Path = input.nextLine();

    //URL del archivo dif
    String difPath = "D:\\DAM\\2022-2023\\_repos\\ADD-UD1\\src\\actividad4\\files\\dif.txt";

    File file1 = new File(file1Path);
    File file2 = new File(file2Path);

    BufferedReader doc1 = null;
    BufferedReader doc2 = null;
    try {
      doc1 = new BufferedReader(new FileReader(file1));
    } catch (FileNotFoundException e) {
      System.out.println("No se encontró el primer archivo");
    }
    try {
      doc2 = new BufferedReader(new FileReader(file2));
    } catch (FileNotFoundException e) {
      System.out.println("No se encontró el segundo archivo");
    }

    BufferedWriter dif = null;
    try {
      dif = new BufferedWriter(new FileWriter(difPath, true));
    } catch (IOException e) {
      System.out.println("No se encontró el archivo de resultados");
    }

    String line1;
    String line2;

    try {
      int lineCount = 1;
      do {
        line1 = doc1.readLine();
        line2 = doc2.readLine();
        if ((line1 == null && line2 != null) || (line1 != null && line2 == null)) {
          dif.write("" + lineCount);//Conversion a String de los int
          dif.newLine();
        } else if (line1 != null) {
          if (!line1.equals(line2)) {
            dif.write("" + lineCount);//Conversion a String de los int
            dif.newLine();
          }
        }
        lineCount++;
      } while (line1 != null & line2 != null);
    } catch (Exception e) {
      System.out.println("No se puede proceder sin todos los archivos");
    } finally {
      try {
        dif.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
