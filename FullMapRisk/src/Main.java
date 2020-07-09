import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_PURPLE = "\u001B[35m";


    public static void showImageFromURL(String url) throws IOException {
        BufferedImage img = ImageIO.read(new URL(
                url));
        ImageIcon icon = new ImageIcon(img);
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setSize(1000, 750);
        JLabel lbl = new JLabel();
        lbl.setIcon(icon);
        frame.add(lbl);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public static Map GameIntro(Map inmap) throws IOException {
        showImageFromURL("https://cf.geekdo-images.com/imagepagezoom/img/iN66zcT0ojnEChKiGSc4SbPfZjw=/fit-in/1200x900/filters:no_upscale()/pic365731.jpg");
        // printing out risk retrieved from https://stackoverflow.com/questions/7098972/ascii-art-java
        System.out.println("Welcome to...");
        BufferedImage image = new BufferedImage(144, 32, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setFont(new Font("Dialog", Font.PLAIN, 24));
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics.drawString("Risk", 6, 17);

        for (int y = 0; y < 32; y++) {
            StringBuilder sb = new StringBuilder();
            for (int x = 0; x < 144; x++)
                sb.append(image.getRGB(x, y) == -16777216 ? " " : image.getRGB(x, y) == -1 ? "#" : "*");
            if (sb.toString().trim().isEmpty()) continue;
            System.out.println(sb);
        }

        System.out.println("The game of Global domination!");
        pressEnter("Press enter to begin");
        System.out.println("How many players do you have? (2 - 4)");
        Scanner sc = new Scanner(System.in);
        int numberplayers;
        do {
            while (!sc.hasNextInt()) {
                System.out.println("That's not a valid number!");
                sc.next();
            }
            numberplayers = sc.nextInt();
        } while (!(numberplayers < 5) || !(numberplayers > 1));
        System.out.println("Thank you! Got " + numberplayers + " players.");
        System.out.println(ANSI_RED + "Player 1 is red." + ANSI_RESET);
        System.out.println(ANSI_BLUE + "Player 2 is blue." + ANSI_RESET);
        if (numberplayers > 2)
            System.out.println(ANSI_GREEN + "Player 3 is green." + ANSI_RESET);
        if (numberplayers > 3)
            System.out.println(ANSI_PURPLE + "Player 4 is purple." + ANSI_RESET);

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 42; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        if (numberplayers == 2) {
            for (int i = 0; i < 20; i++)
                inmap.countryList.get(list.get(i)).setTeam("red");
            for (int i = 4; i < 41; i++)
                inmap.countryList.get(list.get(i)).setTeam("blue");
        }
        if (numberplayers == 3) {
            for (int i = 0; i < 14; i++)
                inmap.countryList.get(list.get(i)).setTeam("red");
            for (int i = 14; i < 28; i++)
                inmap.countryList.get(list.get(i)).setTeam("blue");
            for (int i = 28; i < 41; i++)
                inmap.countryList.get(list.get(i)).setTeam("green");
        }
        if (numberplayers == 4) {
            for (int i = 0; i < 10; i++)
                inmap.countryList.get(list.get(i)).setTeam("red");
            for (int i = 10; i < 20; i++)
                inmap.countryList.get(list.get(i)).setTeam("blue");
            for (int i = 20; i < 30; i++)
                inmap.countryList.get(list.get(i)).setTeam("green");
            for (int i = 30; i < 41; i++)
                inmap.countryList.get(list.get(i)).setTeam("purple");
        }

        String redOut = "After randomly assigning, " + ANSI_RED + "Red has countries: ";
        String blueOut = ANSI_BLUE + "Blue has countries ";
        String greenOut = ANSI_GREEN + "Green has countries ";
        String purpleOut = ANSI_PURPLE + "Purple has countries ";

        for (int i = 0; i < inmap.countryList.size(); i++) {
            if (inmap.countryList.get(i).getTeam().equals("red"))
                redOut += inmap.countryList.get(i).getName() + ", ";
            else if (inmap.countryList.get(i).getTeam().equals("blue"))
                blueOut += inmap.countryList.get(i).getName() + ", ";
            else if (inmap.countryList.get(i).getTeam().equals("green"))
                greenOut += inmap.countryList.get(i).getName() + ", ";
            else if (inmap.countryList.get(i).getTeam().equals("purple"))
                purpleOut += inmap.countryList.get(i).getName() + ", ";
        }
        System.out.println(redOut);
        System.out.println(blueOut);
        if (numberplayers > 2)
            System.out.println(greenOut);
        if (numberplayers > 3)
            System.out.println(purpleOut);
        System.out.println(ANSI_RESET + "you will all get 3 troops per country");
        for (int i = 0; i < inmap.countryList.size(); i++) {
            inmap.countryList.get(i).setNumTroops(3);
        }
        showImageFromURL("https://cf.geekdo-images.com/imagepagezoom/img/iN66zcT0ojnEChKiGSc4SbPfZjw=/fit-in/1200x900/filters:no_upscale()/pic365731.jpg");
        yesOrNo("press enter to begin");
        return inmap;
    }


    public static Map redTurn(Map map) {
        System.out.println(ANSI_RED + "Red team's turn. \nYour countries are:\n");
        int numCountries = 0;
        for (int i = 0; i < map.countryList.size(); i++) {
            if (map.countryList.get(i).getTeam().equals("red")) {
                map.countryList.get(i).printforplayer();
                numCountries++;
            }
        }
        int numTroopsToAdd = numCountries / 3;
        if (numTroopsToAdd < 3)
            numTroopsToAdd = 3;
        map = addTroops(numTroopsToAdd, map, "red");
        boolean answer = yesOrNo("would you like to attack?");
        while (answer == true) {
            if (answer == true) {
                map = attack(map, "red");
                answer = yesOrNo("would you like to attack again?");
            }
        }
        System.out.println(ANSI_RESET);
        return map;
    }


    public static Map blueTurn(Map map) {
        System.out.println(ANSI_BLUE + "Blue team's turn. \nYour countries are:\n");
        int numCountries = 0;
        for (int i = 0; i < map.countryList.size(); i++) {
            if (map.countryList.get(i).getTeam().equals("blue")) {
                map.countryList.get(i).printforplayer();
                numCountries++;
            }
        }
        int numTroopsToAdd = numCountries / 3;
        if (numTroopsToAdd < 3)
            numTroopsToAdd = 3;
        map = addTroops(numTroopsToAdd, map, "blue");
        boolean answer = yesOrNo("would you like to attack?");
        while (answer == true) {
            if (answer == true) {
                map = attack(map, "blue");
                answer = yesOrNo("would you like to attack again?");
            }
        }
        System.out.println(ANSI_RESET);

        return map;
    }

    public static Map genericTurn(Map map, String team) {
        if (team.equals("red"))
            System.out.print(ANSI_RED);
        else if (team.equals("blue"))
            System.out.print(ANSI_BLUE);
        else if (team.equals("green"))
            System.out.print(ANSI_GREEN);
        else if (team.equals("purple"))
            System.out.print(ANSI_PURPLE);
        System.out.println(team + " team's turn. \nYour countries are:\n");
        int numCountries = 0;
        for (int i = 0; i < map.countryList.size(); i++) {
            if (map.countryList.get(i).getTeam().equals(team)) {
                map.countryList.get(i).printforplayer();
                numCountries++;
            }
        }
        int numTroopsToAdd = numCountries / 3;
        if (numTroopsToAdd < 3)
            numTroopsToAdd = 3;
        map = addTroops(numTroopsToAdd, map, team);
        boolean answer = yesOrNo("would you like to attack?");
        while (answer) {
            if (answer) {
                map = attack(map, team);
                answer = yesOrNo("would you like to attack again?");
            }
        }
        System.out.println(ANSI_RESET);
        return map;
    }


    public static Map attack(Map map, String team) {
        System.out.println("Where would you like to attack from? Type cancel to go back");
        Scanner sc = new Scanner(System.in);
        String input;
        input = sc.nextLine();
        if (input.equals("cancel"))
            return map;
        for (int i = 0; i < map.countryList.size(); i++) {
            if (map.countryList.get(i).getTeam().equals(team) && map.countryList.get(i).getName().equals(input) && (map.countryList.get(i).getNumTroops() > 1)) {
                int attackingCountryNumber = map.countryList.get(i).getNumber();
                LinkedList<Country> adjacentCountries = map.adjacencyMatrix.getAllConnected(map.countryList.get(i));
                System.out.println("where do you want to attack? Your options are: ");
                for (int j = 0; j < adjacentCountries.size(); j++) {
                    if (!(adjacentCountries.get(j).team.equals(team))) {
                        System.out.print(adjacentCountries.get(j).getName() + ", ");
                    }
                }
                input = sc.nextLine();
                for (int k = 0; k < adjacentCountries.size(); k++) {
                    if (adjacentCountries.get(k).getName().equals(input)) {
                        int defendingCountryNumber = adjacentCountries.get(k).getNumber();
                        pressEnter("attacker, press enter to roll your dice");
                        int attack1 = map.rollDie();
                        int attack2 = map.rollDie();
                        int attack3 = map.rollDie();
                        int largestAttackRoll = 0;
                        if (attack1 > attack2 && attack1 > attack3)
                            largestAttackRoll = attack1;
                        else if (attack2 > attack3)
                            largestAttackRoll = attack2;
                        else
                            largestAttackRoll = attack3;
                        System.out.println("you rolled a " + attack1 + ", " + attack2 + ", " + "and " + attack3);
                        pressEnter("defender, press enter to roll your dice");
                        int largestDefendRoll = 0;
                        int defend1 = map.rollDie();
                        int defend2 = map.rollDie();
                        if (defend1 > defend2)
                            largestDefendRoll = defend1;
                        else
                            largestDefendRoll = defend2;
                        System.out.println("you rolled a " + defend1 + " and " + defend2);
                        if (largestAttackRoll > largestDefendRoll) {
                            System.out.println("Attacker wins!");
                            map.countryList.get(defendingCountryNumber).setNumTroops(map.countryList.get(defendingCountryNumber).getNumTroops() - 1);
                            System.out.println(map.countryList.get(defendingCountryNumber).getName() + " has " + map.countryList.get(defendingCountryNumber).getNumTroops() + " troops.");
                        } else {
                            System.out.println("Defender wins!");
                            map.countryList.get(attackingCountryNumber).setNumTroops(map.countryList.get(attackingCountryNumber).getNumTroops() - 1);
                            System.out.println(map.countryList.get(attackingCountryNumber).getName() + " has " + map.countryList.get(attackingCountryNumber).getNumTroops() + " troops.");
                        }
                        if(map.countryList.get(defendingCountryNumber).getNumTroops() == 0) {
                            System.out.println("You conquered the country! Moving your troops in.");
                            map.countryList.get(defendingCountryNumber).setTeam(team);
                            map.countryList.get(defendingCountryNumber).setNumTroops(map.countryList.get(attackingCountryNumber).getNumTroops() - 1);
                            map.countryList.get(attackingCountryNumber).setNumTroops(1);


                        }

                    }
                }
            }
        }
        return map;
    }


    public static Map addTroops(int numTroopsToAdd, Map map, String team) {
        while (numTroopsToAdd != 0) {
            System.out.println("you get to add " + numTroopsToAdd + " troops. please enter where you would like to put each one.");
            Scanner sc = new Scanner(System.in);
            String input;
            input = sc.nextLine();
            for (int i = 0; i < map.countryList.size(); i++) {
                if (map.countryList.get(i).getTeam().equals(team) && map.countryList.get(i).getName().equals(input)) {
                    map.countryList.get(i).setNumTroops(map.countryList.get(i).getNumTroops() + 1);
                    numTroopsToAdd--;
                    System.out.println("added, " + map.countryList.get(i).getName() + " has " + map.countryList.get(i).getNumTroops() + " troops.");
                }
            }

        }
        return map;
    }


    public static boolean yesOrNo(String message) {
        Scanner sc = new Scanner(System.in);
        String input;
        System.out.println(message);
        while (!sc.hasNextLine()) {
            System.out.println("That's not a valid input!");
            sc.next();
        }
        input = sc.nextLine();
        if (input.equals("yes"))
            return true;
        else if (input.equals("no"))
            return false;
        return false;
    }

    public static void pressEnter(String message) {
        Scanner sc = new Scanner(System.in);
        String input;
        System.out.println(message);
        while (!sc.hasNextLine()) {
            System.out.println("That's not a valid input!");
            sc.next();
        }
        input = sc.nextLine();
    }


    public static void main(String[] args) throws IOException {
        Map map = new Map();
        map.adjacencyMatrix.printMatrix();
        map = GameIntro(map);
        while (!map.gameWon(map)) {
            map = genericTurn(map, "red");
            map.printGameStatus(map);
            pressEnter("Press enter to continue.");
            if (map.gameWon(map))
                break;
            map = genericTurn(map, "blue");
            map.printGameStatus(map);
            pressEnter("Press enter to continue.");
            if (map.gameWon(map))
                break;
            map = genericTurn(map, "green");
            map.printGameStatus(map);
            pressEnter("Press enter to continue.");
            if (map.gameWon(map))
                break;
            map = genericTurn(map, "purple");
            pressEnter("Press enter to continue.");
            map.printGameStatus(map);
        }
        System.out.println("Congratulations" + map.countryList.get(0).team + " you have conquered the world!!!!");

    }
}
