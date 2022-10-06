package actividad7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Copia {

  public static boolean copiar(String pathOrigin, String pathDestiny) {
    File fileOrigin = new File(pathOrigin);
    File fileDestiny = new File(pathDestiny);

    if (!fileOrigin.exists() || fileOrigin.isDirectory()) {
      return false;
    }
    if (!fileDestiny.exists()) {
      try {
        fileDestiny.createNewFile();
      } catch (IOException e) {
        return false;
      }
    }

    InputStream dataOrigin = null;
    OutputStream dataDestiny = null;
    try {
      dataOrigin = new FileInputStream(fileOrigin);
      dataDestiny = new FileOutputStream(fileDestiny);
      byte[] buffer = new byte[1024];//Está puesto 1024, pero se puede poner el buffer que uno quiera
      int length;
      while ((length = dataOrigin.read(buffer)) > 0) {
        dataDestiny.write(buffer, 0, length);
      }
    } catch (Exception e) {
      return false;
    } finally {
      try {
        assert dataOrigin != null;
        dataOrigin.close();
        assert dataDestiny != null;
        dataDestiny.close();
      } catch (Exception e) {
        System.out.println("No se han podido desbloquear los archivos");
      }
    }
    return true;
  }
}
