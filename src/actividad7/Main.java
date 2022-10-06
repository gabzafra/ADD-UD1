package actividad7;

public class Main {

  public static void main(String[] args) {
    String pathOrigin = "D:\\DAM\\2022-2023\\_repos\\ADD-UD1\\src\\actividad7\\files\\origin.zip";
    String pathDestiny = "D:\\DAM\\2022-2023\\_repos\\ADD-UD1\\src\\actividad7\\files\\destiny.zip";

    boolean success = Copia.copiar(pathOrigin, pathDestiny);
    System.out.println("La copia" + (success ? "" : " no") + " ha tenido éxito");
  }
}
