import java.io.IOException;

public class Main {
  static final String SAVEGAME_PATH = "D://Game//savegames//";

  public static void main(String[] args) throws IOException {
    GameProgress gp1 = new GameProgress(100, 5, 2, 25.65);
    GameProgress gp2 = new GameProgress(80, 10, 6, 254.65);
    GameProgress gp3 = new GameProgress(86, 16, 10, 325.24);

    GameProgress.saveGame(SAVEGAME_PATH + "save1.dat", gp1);
    GameProgress.saveGame(SAVEGAME_PATH + "save2.dat", gp2);
    GameProgress.saveGame(SAVEGAME_PATH + "save3.dat", gp3);

    String[] saveList = {SAVEGAME_PATH + "save1.dat", SAVEGAME_PATH + "save2.dat", SAVEGAME_PATH + "save3.dat"};
    GameProgress.zipFiles(SAVEGAME_PATH + "zip.zip", saveList);
  }
}
