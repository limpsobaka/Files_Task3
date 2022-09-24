import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

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

  public static void openZip(String path, String zip) {
    try (ZipInputStream zin = new ZipInputStream(new FileInputStream(zip))) {
      ZipEntry entry;
      String name;
      while ((entry = zin.getNextEntry()) != null) {
        name = entry.getName();
        FileOutputStream fout = new FileOutputStream(path + name);
        for (int c = zin.read(); c != -1; c = zin.read()) {
          fout.write(c);
        }
        fout.flush();
        zin.closeEntry();
        fout.close();
      }
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
  }

  public static GameProgress openProgress(String path) {
    try (FileInputStream fis = new FileInputStream(path);
         ObjectInputStream ois = new ObjectInputStream(fis)) {
      return (GameProgress) ois.readObject();
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
      return null;
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