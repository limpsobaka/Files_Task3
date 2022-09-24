import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class GameProgress implements Serializable {
  private static final long serialVersionUID = 1L;

  private int health;
  private int weapons;
  private int lvl;
  private double distance;

  public GameProgress(int health, int weapons, int lvl, double distance) {
    this.health = health;
    this.weapons = weapons;
    this.lvl = lvl;
    this.distance = distance;
  }

  public static void saveGame(String path, GameProgress gp) {
    try (FileOutputStream fos = new FileOutputStream(path);
         ObjectOutputStream oos = new ObjectOutputStream(fos)) {
      oos.writeObject(gp);
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
  }

  public static void zipFiles(String path, String[] saves) throws IOException {
    ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(path));
    File save;
    for (String s : saves) {
      save = new File(s);
      try (FileInputStream fis = new FileInputStream(save)) {
        ZipEntry entry = new ZipEntry(save.getName());
        zout.putNextEntry(entry);
        byte[] buffer = new byte[fis.available()];
        fis.read(buffer);
        zout.write(buffer);
        zout.closeEntry();
      } catch (Exception ex) {
        System.out.println(ex.getMessage());
      }
    }
    zout.close();

    for (String s : saves) {
      save = new File(s);
      try {
        save.delete();
      } catch (Exception ex) {
        System.out.println(ex.getMessage());
      }
    }
  }

  @Override
  public String toString() {
    return "GameProgress{" +
            "health=" + health +
            ", weapons=" + weapons +
            ", lvl=" + lvl +
            ", distance=" + distance +
            '}';
  }
}