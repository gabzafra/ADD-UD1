package actividad2;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

public class Main {

  public static void main(String[] args) {
    dirList("D:\\DAM\\2022-2023\\");
  }

  private static void dirList(String path) {
    File directory = new File(path);
    File[] lista = directory.listFiles();
    Arrays.stream(lista).forEach(Main::printFileDetail);
  }

  private static void printFileDetail(File file) {
    String timestamp = new SimpleDateFormat("dd/MM/yyyy  HH:mm").format(new Date(file.lastModified()));
    System.out.print(timestamp);
    System.out.print("    ");
    System.out.print(file.isDirectory() ? "<DIR>" : "     ");
    System.out.print("    ");
    System.out.printf(Locale.US, "%,15d", file.length());
    System.out.print("     ");
    System.out.print(file.getName());
    System.out.println();
  }
}
