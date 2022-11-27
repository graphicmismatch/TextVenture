import java.util.Scanner;
import java.io.*;
public class Main extends Game
{
  public static void main(String[] argv) throws IOException 
  {
    Game.slowType("     ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄       ▄  ▄▄▄▄▄▄▄▄▄▄▄\n    ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░▌     ▐░▌▐░░░░░░░░░░░▌\n     ▀▀▀▀█░█▀▀▀▀ ▐░█▀▀▀▀▀▀▀▀▀  ▐░▌   ▐░▌  ▀▀▀▀█░█▀▀▀▀\n         ▐░▌     ▐░▌            ▐░▌ ▐░▌       ▐░▌\n         ▐░▌     ▐░█▄▄▄▄▄▄▄▄▄    ▐░▐░▌        ▐░▌\n         ▐░▌     ▐░░░░░░░░░░░▌    ▐░▌         ▐░▌\n         ▐░▌     ▐░█▀▀▀▀▀▀▀▀▀    ▐░▌░▌        ▐░▌\n         ▐░▌     ▐░▌            ▐░▌ ▐░▌       ▐░▌\n         ▐░▌     ▐░█▄▄▄▄▄▄▄▄▄  ▐░▌   ▐░▌      ▐░▌\n         ▐░▌     ▐░░░░░░░░░░░▌▐░▌     ▐░▌     ▐░▌\n          ▀       ▀▀▀▀▀▀▀▀▀▀▀  ▀       ▀       ▀\n\n\n          __      __        _                  \n          \\ \\    / /       | |                 \n           \\ \\  / /__ _ __ | |_ _   _ _ __ ___ \n            \\ \\/ / _ \\ '_ \\| __| | | | '__/ _ \\\n             \\  /  __/ | | | |_| |_| | | |  __/\n              \\/ \\___|_| |_|\\__|\\__,_|_|  \\___|", 2);

    System.out.println("======================================================================\n");
    Scanner get = new Scanner(System.in);
    System.out.println("Press Enter to Continue:");
    get.nextLine();
    System.out.println("Select Difficulty:\n->(E)asy\n->(M)edium\n->(H)ard\n\n\n\nWrong input will start a Hard Game.");
    char opt = Character.toUpperCase(get.nextLine().charAt(0));
    Game.slowType("Enter Username:",10);
    String u = get.nextLine();
    Game nothang = new Game(opt,u);
    nothang.cls();    
    nothang.main();
    get.close();
  }
}


