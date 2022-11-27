import java.util.Scanner;
import java.io.IOException;
import java.util.Random;
public class Game extends FightMechanics {
    static String choice = "";
    static String user = "";
    static int[] stats = new int[10];
    // level, exp, maxhealth, charisma, atk, def, wisdom, intelligence, speed,
    // evasion
    static String inventory = "";
    final static String[][] itemDictionary = {
            { "Apple(u)","Banana(u)","MRE(2u)","Axe(un)","Shield(un)","Armor(un)","Amulet(un)","Potion(u)","Book(u)","Painkillers(3u)","First-Aid Kit(3u)","Ring(un)","Lucky-coin(u)","Lockpicks(7u)","Key(u)","Helmet(un)","Skateboard(un)","Folding Bicycle(un)","Care-Package(u)","Cake(4u)","Bed(un)","Milk(u)" },{ "Recovers 10hp.","Recovers 5hp.","Recovers 30hp. Can be used twice.","Shield. Effect depends on item level and type.", "Armor. Effect depends on item level and type.","Magical Amulet. Effect depends on item level and type. Can either curse or bless you.","Random effect.","Heightens both Intelligence and Wisdom.", "Recovers 70hp. Can be used thrice.","Recovers all hp, regardless of current hp. Can be used thrice. Can be sold for insane amounts of money.","Magical Ring. Effect depends on item level and type. Can either curse or bless you.","Gives you a random amount of exp. A maximum of 100,000 exp points can be gained.","Universal Keys. Can be used on any door. Small chance of encounter. Can be used 7 times.","Can be used to open a door.", "Armor. Effect depends on item level and type.","Increases speed greatly. (Equipable)","Increases speed greatly. (Equipable)","Gives a random healing item, some coins, and some exp. May give a lucky coin.","Heals 30hp. Can be used four times.","Increases speed and evasion temporarily. Has a cool-down of 100 walk-cycles. Effects last for 25 turns.","Removes all temporary negative stat changes." },{"Apple(u)","Bananna(u)","MRE(2u)","Axe(un)","Sword(un)","Shield(un)","Armor(un)","Amulet(un)","Potion(u)","Book(u)","Painkillers(3u)","First-Aid Kit(3u)","Katana(un)","Ring(un)","Lucky-coin(u)","Lockpicks(7u)","Key(u)","Helmet(un)","Dagger(un)","Skateboard(un)","Folding Bicycle(un)","Pen(un)","Care-Package(u)","Cake(4u)","Bed(un)","Milk(u)"} };

    static String equipped = "";
    static boolean dead = false;
    static Scanner get = new Scanner(System.in);
    static double health;
    static Random rand = new Random();
    public Game() {}

    public Game(char dif, String u){
        user = u;
        if (dif == 'E') {
            stats[0] = 1;
            stats[1] = 0;
            stats[2] = 30;
            stats[3] = 10;
            stats[4] = 25;
            stats[5] = 15;
            stats[6] = 10;
            stats[7] = 25;
            stats[8] = 20;
            stats[9] = 15;
            health = stats[2];
        }
        else if(dif == 'M'){
            stats[0] = 1;
            stats[1] = 0;
            stats[2] = 25;
            stats[3] = 5;
            stats[4] = 15;
            stats[5] = 10;
            stats[6] = 5;
            stats[7] = 15;
            stats[8] = 15;
            stats[9] = 10;
            health = stats[2];
        }
        else{
            stats[0] = 1;
            stats[1] = 0;
            stats[2] = 10;
            stats[3] = 5;
            stats[4] = 10;
            stats[5] = 5;
            stats[6] = 5;
            stats[7] = 10;
            stats[8] = 15;
            stats[9] = 5;
            health = stats[2];
        }
    }

    public static void main() throws IOException {
        while (true) {
            if(stats[1]>= stats[0]*7.5)
            {
              slowType("Goddamn, do you have no life? Anyways, you leveled up to → lv."+(stats[0]+1)+"!\n\nTip: Level ups are still the best way to gain stats(because the developer was too lazy to add another way)!\n\n\n",10);
              int temp = (int)Math.rint((stats[0]*7.5)-stats[1]);
              stats[0]++;
              stats[1] = temp;
              stats[2] += (int)Math.rint(Math.ceil(rand.nextInt(5)+((Math.random()+1)*stats[0])));
              stats[3] += (int)Math.rint(Math.ceil(rand.nextInt(3)+((Math.random()+1)*stats[0])));
              stats[4] += (int)Math.rint(Math.ceil(rand.nextInt(2)+((Math.random()+1)*stats[0])));
              stats[5] += (int)Math.rint(Math.ceil(rand.nextInt(5)+((Math.random()+1)*stats[0])));
              stats[6] += (int)Math.rint(Math.ceil(rand.nextInt(6)+((Math.random()+1)*stats[0])));
              stats[7] += (int)Math.rint(Math.ceil(rand.nextInt(2)+((Math.random()+1)*stats[0])));
              stats[8] += (int)Math.rint(Math.ceil(((Math.random()+1)*stats[0])));
              stats[9] += (int)Math.rint(Math.ceil(rand.nextInt(7)+((Math.random()+1)*stats[0]))); 
              health = stats[2];
            }
            String opt = "";
            System.out.println("Stats: ");
            System.out.println("Health: " + health + "/" + stats[2]);
            System.out.println("Menu: \n1. Walk\n2. Inventory \n3. Options \n4. Credits\n5. Stats \n6. Die");
            System.out.println("IMPORTANT: Please only enter the option number or else your game would likely crash.");
            choice = get.next();
            switch (choice) {
                case "":
                System.out.println("Seriously?");
                break;
                case "1":
                System.out.println("You Walk\n\n");
                eventHandler(1, 30);
                eventHandler(2, 20);
                break;
                case "2":
                System.out.println("Inventory:");
                System.out.println("What do you want to do?");
                System.out.println("1. Use an item\n2. Eat\n3. Equip Items\n4. View Inventory\n5. View Equipped");
                opt = get.next();
                switch (opt) {
                    case "1":
                    System.out.print("What item do you wish to use?");
                    opt = get.nextLine();
                }
                arrayDisplay(true, inventoryToArray(inventory));
                break;
                case "3":
                System.out.println("Options are currently not available");
                break;
                case "4":
                Game.slowType("Credits:",10);
                break;
                case "5":
                Game.slowType("STATS:\n->Level: "+stats[0]+"\n->Exp: "+stats[1]+"/"+(stats[0]*7.5)+"\n->Max Health: "+stats[2]+"\nCharisma: "+stats[3]+"\nAttack: "+stats[4]+"\nDefense: "+stats[5]+"\nWisdom: "+stats[6]+"\nIntelligence: "+stats[7]+"\nSpeed: "+stats[8]+"\nEvasion: "+stats[9],5);    
                break;
                case "6":
                dead = true;
                default:
                System.out.println("ig it would be better if u followed the rules");
            }
            if (dead == true) {
                Game.slowType(user +" died.",20);
                break;
            }
            choice = "";
            System.out.println("Press Enter to Continue:");
            get.nextLine();
            get.nextLine();
            cls();
        }
    }

    public static String[] inventoryToArray(String s) {
        if (s != "") {
            int found = 0;
            for (int i = 0; i < s.length(); i++) {
                if (Character.toString(s.charAt(i)).equals("|")) {
                    found++;
                }
            }
            found++;
            String[] ar = new String[found];
            for (int i = 0; i < ar.length; i++) {
                ar[i] = "";
            }
            int j = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '|') {
                    j++;
                    continue;
                }
                ar[j] += Character.toString(s.charAt(i));
            }
            return ar;
        }
        else {
            String[] ar = { "" };
            return ar;
        }
    }

    public static String arrayToInventory(String[] s) {
        String inv = "";
        for (int i = 0; i > s.length - 1; i++) {
            if (s[i] != "") {
                inv = inv + s[i] + "|";
            }
        }
        return inv;
    }

    public static String[] sorting(String y[]) {
        for (int count = 0; count < y.length - 1; count++) {
            String temp = "";
            for (int i = y.length - 1; i > count; i--) {
                if ((y[count].toLowerCase()).compareTo(y[i].toLowerCase()) > 1) {
                    temp = y[i];
                    y[i] = y[count];
                    y[count] = temp;
                }
            }
        }
        return y;
    }

    public static void arrayDisplay(boolean numbered, String[] ar) {
        if (numbered) {
            for (int i = 0; i <= ar.length - 1; i++) {
                System.out.println((i + 1) + ". " + ar[i]);
            }
        } else {
            for (int i = 0; i <= ar.length - 1; i++) {
                System.out.println("-->" + ar[i]);
            }
        }
    }

    public static void eventHandler(int eno, float pro) {
        switch (eno) {
            case 1:
            if (rand.nextInt(100) >= pro) {
                if(!FightMechanics.initBattle(spawnMonster()))
                {
                  dead = true;
                }
            }

        }
    }

    public static String spawnMonster() {
        String[] montype = { "Skelly####", "Zombo#####", "Drac######", "Bot#######", "Gnome#####", "RickAstely",
                "Stickbug##", "Doge######", "Dwarf#####", "Dragon####", "Snek######", "SnekV#####" };
        int min = (stats[0] <= 20) ? 1 : (stats[0] - 10);
        int max = (stats[0] <= 20) ? (stats[0] + 5) : (int) Math.ceil(stats[0] + (stats[0] / 2));
        String monlv = Integer.toString(rand.nextInt(max) + min);
        String[] monchar = { "Angry####", "Confident", "Annoying#", "Calm#####", "Enerjetic", "Friendly#", "Edgy#####" };
        String monster = monchar[rand.nextInt(6)] + montype[rand.nextInt(11)] + monlv;
        return monster;
    }

    public static void cls() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void slowType(String s, long t) {
        try {
            for (int i = 0; i < s.length(); i++) {
                Thread.sleep(t);
                System.out.print(s.charAt(i));
            }
            System.out.println();
        } catch (InterruptedException ex) {
            System.out.print("please restart the game. an error occurred. please report this error.");
            Thread.currentThread().interrupt();
        }
    }

    public static void delay(long t) {
        try {
            Thread.sleep(t);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public static int ternSearch(String[] x, String target) {
        x = sorting(x);
        if ((target.toLowerCase()).compareTo(x[0].toLowerCase()) == 0) {
            return 0;
        }
        if ((target.toLowerCase()).compareTo(x[x.length - 1].toLowerCase()) == 0) {
            return x.length - 1;
        }
        int mid1 = (int) Math.ceil(x.length / 3);
        if ((target.toLowerCase()).compareTo(x[mid1].toLowerCase()) == 0) {
            return mid1;
        }
        int mid2 = (int) Math.ceil(x.length * 2 / 3);
        if ((target.toLowerCase()).compareTo(x[mid2].toLowerCase()) == 0) {
            return mid2;
        }
        if ((target.toLowerCase()).compareTo(x[0].toLowerCase()) > 0
        && (target.toLowerCase()).compareTo(x[mid1].toLowerCase()) < 0) {
            for (int i = 1; i < mid1; i++) {
                if ((target.toLowerCase()).compareTo(x[i].toLowerCase()) == 0) {
                    return i;
                }
            }
        } else if ((target.toLowerCase()).compareTo(x[mid1].toLowerCase()) > 0
        && (target.toLowerCase()).compareTo(x[mid2].toLowerCase()) < 0) {
            for (int i = mid1 + 1; i < mid2; i++) {
                if ((target.toLowerCase()).compareTo(x[i].toLowerCase()) == 0) {
                    return i;
                }
            }
        } else if ((target.toLowerCase()).compareTo(x[mid2].toLowerCase()) > 0
        && (target.toLowerCase()).compareTo(x[x.length - 1].toLowerCase()) < 0) {
            for (int i = mid2 + 1; i < x.length - 2; i++) {
                if ((target.toLowerCase()).compareTo(x[i].toLowerCase()) == 0) {
                    return i;
                }
            }
        }
        return -1;
    }
}