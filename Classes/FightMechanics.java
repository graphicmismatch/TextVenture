import java.util.Scanner;
import java.util.Random;
public class FightMechanics {
    public static Scanner get =  new Scanner(System.in);
    static Random rand = new Random();

    public static boolean initBattle(String title) {
        return fight(title);
    }

    public static String[] interpret(String specs) {
        String cha = specs.substring(0, 9);
        String typ = specs.substring(9, 19);
        String lvl = specs.substring(19, specs.length());
        String[] datpack = { cha, typ, lvl };
        return datpack;
    }

    public static boolean fight(String title)
    {
        boolean cont = true;
        while(cont)
        {
            Game.cls();
            msgDisp(interpret(title));
            System.out.println("\n");
            System.out.println("Select Action: \n1.Attack\n2.Charm\n3.Settle It Like Those Bruhssians\n4.Yeet Yourself Out Of Battle");
            String opt = get.nextLine();
            System.out.println("\n\n\n\n\n\n");
            switch(opt)
            {
                case "1":
                if(attackHit())
                {
                    Game.slowType("The Attack Hits. The Monster is killed", 10);
                    cont = false;
                }
                else
                {
                    Game.slowType("The Attack Fails. The Monster Attacks You", 10);
                    monAtk(title);

                }
                break;

                case "2":
                if(Next(0, Game.stats[3]+Next(0, 20)-5)>Next(100.0+Game.stats[3]))
                {
                    cont = false;
                    Game.slowType("You successfully charm the Monster. It lets you go.", 10);
                }
                else
                {
                    Game.slowType("You fail to charm the Monster. It Attacks you.", 10);
                    monAtk(title);
                }
                case "3":
                Game.slowType("Are you sure you want to continue? (y/n)", 10);
                opt = get.nextLine();
                switch(opt)
                {
                    case "y":
                    String n = "";
                    for(int i = 0; i<interpret(title)[1].length();i++)
                    {
                        if(interpret(title)[1].charAt(i) == '#')
                        {
                            break;
                        }
                        n+= interpret(title)[1].charAt(i)+"";
                    }
                    cont = rRoulette(Game.user, "The Lv."+interpret(title)[2]+" "+n);  if(!cont)
                    {
                        Game.health = 0;
                    }  
                    break;
                    case "n":
                    Game.slowType("The Monster pities your indescision. It waits.", 10);
                    break;
                    default:
                    Game.slowType("Dude, follow the instructions. :\\",10); 
                }
                break;
                case "4":
                if(Game.stats[8]*Next(2)>Next(100.0+Game.stats[3]))
                {
                    Game.slowType("You successfully escape the Monster.", 10);
                    System.out.println("Press Enter to Continue:");
                    get.nextLine();
                    return true;
                }
                else
                {
                    Game.slowType("You fail to escape the Monster. It Attacks you.", 10);
                    monAtk(title);
                }
            }
            if(Game.health <= 0)
            {
                cont = false;
                return false;
            }
            System.out.println("Press Enter to Continue:");
            get.nextLine();
        }
        int xpgain = (int)Math.ceil(Math.abs(Next(0,5)*Integer.parseInt(interpret(title)[2])-(Game.stats[0]*Next(2.7))))+2;
        Game.slowType("You gained "+ xpgain +"xp!",10);
        Game.stats[1]+=xpgain;
        return true;
    }

    public static void monAtk(String title)
    {
        if(Game.stats[9]<Next(100+Game.stats[9]))
        {
            Game.slowType("The Monster Hits", 10);
            Game.health -= Math.ceil((Next(20.0) *Integer.parseInt(interpret(title)[2]))/Game.stats[5]-Next(1.2)+2) ;
            Game.slowType("You now have "+Game.health+"hp left.",10);
        }
        else
        {
            Game.slowType("The Monster Misses", 10);
        }
    }

    public static boolean attackHit()
    { 
        int o = Next(0,2);
        if(o==0)
        {
            int a = OVkRand()>>2;
            int b = OVkRand()>>2;
            int c = OVkRand()>>2;
            int d = OVkRand()>>2;
            int correct1 = (OVkRand()%2==0)?a:b;
            int correct2 = (OVkRand()%2==0)?c:d;
            int correct = (OVkRand()%2==0)?correct1:correct2;
            String cor = (correct == a)?"a":(correct == b)?"b":(correct == c)?"c":"d";
            System.out.println("ATTACK\nWhich of the following is the correct binary representation for "+correct+"?\nA) "+optGen(a)+"\nB) "+optGen(b)+"\nC) "+optGen(c)+"\nD) "+optGen(d));
            String opt = get.nextLine();
            return (opt.equalsIgnoreCase(cor));
        }
        else
        {
            int as = OVkRand()>>2;
            int bs = OVkRand()>>2;
            int cs = OVkRand()>>2;
            int ds = OVkRand()>>2;
            int a = as+cs;
            int b = bs+as;
            int c = ds+bs;
            int d = cs+ds;
            int correct1 = (OVkRand()%2==0)?a:b;
            int correct2 = (OVkRand()%2==0)?c:d;
            int correct = (OVkRand()%2==0)?correct1:correct2;
            String cor = (correct == a)?"a":(correct == b)?"b":(correct == c)?"c":"d";
            System.out.println("ATTACK\nWhich of the following is the correct answer  for (both terms are in binary) \""+((correct == a)?optGen(as)+"+"+optGen(cs):(correct == b)?optGen(bs)+"+"+optGen(as):(correct == c)?optGen(ds)+"+"+optGen(bs):optGen(cs)+"+"+optGen(ds)) + "\"?\nA) "+a+"\nB) "+b+"\nC) "+c+"\nD) "+d);
            String opt = get.nextLine();
            return (opt.equalsIgnoreCase(cor));
        }

    }

    public static void msgDisp(String[] data) {
        System.out.print("A ");
        for(int i = 0; i<data[0].length();i++)
        {
            if(data[0].charAt(i) == '#')
            {
                break;
            }
            System.out.print(data[0].charAt(i));
        }
        System.out.print(" Lv."+data[2]+" ");
        for(int i = 0; i<data[1].length();i++)
        {
            if(data[1].charAt(i) == '#')
            {
                break;
            }
            System.out.print(data[1].charAt(i));
        }
        System.out.println(" appears\n");
        System.out.print("\"");
        if (data[1].equals("Skelly####")) {
            System.out.print("I swear they have aimbot");
        } 
        else if (data[1].equals("Zombo#####")) {
            System.out.print("uuuuhhhhhhhhuhuhuhh...");
        } 
        else if (data[1].equals("Drac######")) {
            if(Game.Next(1,1000) != 15)
            {
                System.out.print("I vill suk thine blood!");
            }
            else{
                System.out.print((Next(1,100)%2 == 0?" reference nobody will see":"reference nobody will understand"));
            }
        }
        else if (data[1].equals("Bot#######")) {
            System.out.print("I fear no man... but the captcha? it scares me...");
        } 
        else if (data[1].equals("Gnome#####")) {
            System.out.print("Get Gnomed!");
        } 
        else if (data[1].equals("RickAstely")) {
            System.out.print(
                "Never gonna give you up\nNever gonna let you down\nNever gonna run around and desert you!\nNever gonna make you cry\nNever gonna say goodbye\nNever gonna tell a lie and hurt you!");
        } 
        else if (data[1].equals("Stickbug##")) {
            System.out.print("Get sTickbUgGEd lol");
        } 
        else if (data[1].equals("Doge######")) {
            System.out.print("Such Amaze\nMuch wow");
        } 
        else if (data[1].equals("Dwarf#####")) {
            System.out.print("Nom Nom\nSnom is\nThe best Pokemon");
        } 
        else if (data[1].equals("Dragon####")) {
            System.out.print("But everything changed... when the fire nation attacked");
        } 
        else if (data[1].equals("Snek######")) {
            System.out.print("Good Snek");
        } 
        else if (data[1].equals("SnekV#####")) {
            System.out.print("Danger Noodle");
        } 
        else {
            System.out.print("Oop, something went wrong... Here, fight this placeholder!");
        }
        System.out.print("\"");
    }

    public static boolean rRoulette(String nam, String opp) {
        int ch = rand.nextInt(6) + 1;
        System.out.println("BRUHSSIAN ROULETTE");
        Game.slowType("The game will start in:",10);
        for (int i = 3; i >= 1; i--) {
            Game.delay(1000);
            Game.slowType(i+"",1);
        }
        Game.slowType("The bullet is in the chamber and it is spun.",10);
        Game.delay(2000);
        String name = "";
        for (int i = 1; i <= ch; i++) {
            if (i % 2 == 0)
                name = nam;
            else
                name = opp;
            Game.slowType(name + " picks up the gun, and slowly pulls the trigger...",10);
            Game.delay(4000);
            if (i == ch) {
                Game.slowType("BANG!!",10);
                Game.delay(2000);
                Game.slowType(name + " died.",10);
                break;
            } else {
                Game.slowType("CLICK!!",10);
                Game.delay(1000);
                Game.slowType(name + " puts the gun on the table...",10);
            }
            Game.delay(1000);
        }
        return !(name == nam);
    }

    static int Next(int i, int j) {
        return (int) (Math.random() * j) + i;
    }

    static double Next(double j) {
        return (rand.nextDouble() * j);
    }

    public static String optGen(int n)
    {
        String binrep = "";
        boolean last = n%2 == 0;
        while(true)
        {
            if(n == 0 && last)
            {
                binrep += "0";
                break;
            }

            binrep += Integer.toString(n%2);
            if (n==0)
            {
                break;
            }
            n = n>>1;
        }
        binrep = rev(binrep);
        int cor = binrep.length()%4;
        for(int i = 0; i<cor; i++)
        {
            binrep = "0"+binrep;
        }
        return binrep;
    }

    public static int OVkRand() {
        Random random = new Random();
        int seed1 = Integer.parseInt((""+System.currentTimeMillis()).substring((""+System.currentTimeMillis()).length() - 3)); //seed
        int seed2 = Integer.parseInt((""+System.nanoTime()).substring((""+System.nanoTime()).length()-4));  //seed
        long seedMain = Math.abs((seed1*seed2)-(seed1)-0x5F3);  //wtf
        seedMain = seedMain>>10;   //fast reduction
        seedMain = Math.abs(Integer.parseInt((""+seedMain).substring( Math.abs((""+seedMain).length()-2)))); //random bs
        int x = Math.abs(random.nextInt(Math.abs(seed2-seed1))+seed1);
        seedMain = seedMain>>10;  //fast reduction
        x = x>>5;  //fast reduction
        return random.nextInt(x-Math.abs((int)seedMain))+Math.abs((int)seedMain);
    }

    public static String rev(String s)
    {
        String t = "";
        for (int i =  s.length()-1; i>=0; i--)
        {
            t += ""+s.charAt(i);
        }
        return t;
    }

    public static boolean[] binToBoolArray(String n)
    {
        String s = ""+n;
        boolean[] b = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++)
        {
            b[i] = (s.charAt(i) == '1');
        }
        return b;
    }

    public static String binAdd(String n, String m)
    {       
        boolean[] nb = binToBoolArray(n);
        boolean[] mb = binToBoolArray(m);
        long l = (nb.length>mb.length)?(nb.length+1):(mb.length+1);    
        boolean[] eqnb = new boolean[(int)l];   
        boolean[] eqmb = new boolean[(int)l];  
        for (int i = 0; i < mb.length;i++)
        {
            eqmb[i] = mb[i];
        }
        for (int i = 0; i < nb.length;i++)
        {
            eqnb[i] = nb[i];
        }
        boolean[] b = new boolean[(int)l];
        boolean carry = false;
        boolean t = false;
        for (int i = 0; i<l; i++)
        {
            b[i] = eqnb[i] ^ eqmb[i];
            t = b[i]&&carry;
            b[i] = b[i] ^ carry;
            carry = (eqnb[i] && eqmb[i])||(t);
        }

        return rev(boolArrayToBin(b));
    }  

    public static String boolArrayToBin(boolean[] b)
    {
        String s = "";
        for (int i = 0; i < b.length; i++)
        {
            s += (b[i])?"1":"0";
        }
        int cor = s.length()%4;
        for(int i = 0; i<cor; i++)
        {
            s += "0";
        }
        return s;
    }
}