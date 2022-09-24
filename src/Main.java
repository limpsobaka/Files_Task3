public class Main {
  static final String SAVEGAME_PATH = "D://Game//savegames//";

  public static void main(String[] args) {
    GameProgress.openZip(SAVEGAME_PATH, SAVEGAME_PATH + "zip.zip");
    GameProgress gp = GameProgress.openProgress(SAVEGAME_PATH + "save2.dat");
    System.out.println(gp);
  }
}