import java.util.Scanner;

public class TextAdventureA {
    //    All the variables (requirements) are set to be false. Which will be set as true once you find the items while playing the game.
    static boolean foundBatteries, foundPincode, foundPortalGun, foundKey = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Your Name :: ");
        String UserName = scanner.nextLine();
        System.out.println("Hello " + UserName + " Welcome to the Text Adventure Game. Good Luck!!");
        MainMenu();
    }

    public static String Room(String a, String b, String c, String d, String e) {
        System.out.println("1." + a + "   " + "2." + b + "   " + "3." + c + "   " + "4." + d + "    " + "5." + e);
        Scanner ro = new Scanner(System.in);
        return ro.next();
    }

    //    Main menu is the method where all the instructions for the game are.
    //    player can choose which room (case) they want to proceed with.
    public static void MainMenu() {
        System.out.println("-----------------------------------------");
        System.out.println("Choose one of the following option:");
        while (true) {
            switch (Room("Room1", "Room2", "Room3", "Room4", "Room5")) {
                case "1":
                    Room1();
                case "2":
                    Room2();
                case "3":
                    Room3();
                case "4":
                    Room4();
                case "5":
                    Room5();
            }
        }
    }

    public static void Room1() {
        System.out.println("-----------------------------------------");
        System.out.println("***** Welcome to the Room 1 *****");
        Scanner scanner = new Scanner(System.in);

        while (foundBatteries) {
            System.out.println("You already found the hints.");
            MainMenu();

        }
        while (!foundBatteries) {
            System.out.println("Type 'look' to look around the room and 'get' to pick up any object");
            String action = scanner.nextLine();

            if (action.equals("look")) {
                System.out.println("You are in Room 1. There is a locked safe here and two batteries lying on the floor");
            } else if (action.equals("get")) {
                System.out.println("To pick up the batteries (type 'batteries')");
                String item = scanner.nextLine();

                if (item.equals("batteries")) {
                    System.out.println("Hurray!! You've picked up the batteries for portal gun");
                    foundBatteries = true;
                    MainMenu();
                } else {
                    System.err.println("Invalid command. Type 'look' or 'get'.");
                }
            }
        }
        MainMenu();
    }

    public static void Room2() {
        System.out.println("----------------------------------------- ");
        System.out.println("***** Welcome to the Room 2 *****");
        Scanner scanner = new Scanner(System.in);
        while (foundPortalGun) {
            System.out.println("You already found the hints.");
            MainMenu();

        }
        label:
        while (!foundPortalGun) {
            System.out.println("There are a few things you can see. Enter the number of the option you want to choose.");
            System.out.println("1 : A picture hanging opposite the door you entered through.");
            System.out.println("2 : An oddly spaced rug, take a look at what is under there.");
            System.out.println("3 : A bottle of wine. Maybe the label says you what to look for.");
            System.out.println("4 : You walk out the door.");

            String action = scanner.nextLine();

            switch (action) {
                case "1":
                    System.out.println("You inspect the picture and notice something behind it. Good job, you find a safe behind it. To open the safe you need Pin");
                    System.out.println("Do you have the Pin? yes or no?");
                    String question = scanner.nextLine();

                    if (question.equals("yes")) {
                        System.out.println("Please enter the pin code here: ");
                        int pincode = scanner.nextInt();

                        if (pincode == 7802) {
                            System.out.println("Hurray, you've already found the pin code and can unlock the safe. " +
                                    "There is a portal gun in it.");
                            foundPortalGun = true;
                            MainMenu();
                        }
                    } else {
                        System.err.println("You will find the pin code in some other room. Keep exploring XD ");
                        MainMenu();
                    }
                    break;
                case "2":
                    System.out.println("You take the rug and to your misfortune there is nothing under it :(.");
                    MainMenu();
                    break;
                case "3":
                    System.out.println("The wine bottle was a good guess but you aren´t able to read anything for the label " +
                            "is faded. Any hint on there is gone and with the means you have, there is no way to restore it.");
                    MainMenu();
                    break label;
                case "4":
                    MainMenu();
                    break;
                default:
                    System.err.println("Invalid command. Write 1, 2, 3 or 4");
                    break;
            }
        }
        MainMenu();
    }

    public static String Wahl(String a, String b) {
        System.out.println("1." + a + "   " + "2." + b + "   ");
        Scanner in = new Scanner(System.in);
        return in.next();
    }

    public static void Room3() {
        System.out.println("----------------------------------------- ");
        System.out.println("***** Welcome to the Room 3 *****");
        new Scanner(System.in);
        while (foundKey) {
            System.out.println("You already found the hints.");
            MainMenu();

        }
        while (!foundKey) {
            switch (Wahl("Look around", "Leave")) {
                case "1" : {
                    System.out.println("Which direction you want to search?");
                    switch (Wahl("left", "right")) {
                        case "1" : {
                            System.out.println("Congrats! you found the Key for the safe");
                            foundKey = true;
                            MainMenu();
                        }
                        case "2" : {
                            System.out.println("There is an enemy in front of you");
                            switch (Wahl("fight", "fly")) {
                                case "1" : {
                                    System.out.println("You died! Game Over :/");
                                    MainMenu();
                                }
                                case "2" : {
                                    System.out.println("You leave Room3");
                                    MainMenu();
                                }
                            }
                        }
                    }
                }
                case "2" : {
                    System.out.println("You leave Room3");
                    MainMenu();
                }
            }
        }
        MainMenu();
    }


    public static void Room4() {
        System.out.println("----------------------------------------- ");
        System.out.println("***** Welcome to the Room 4 *****");
        Scanner scanner = new Scanner(System.in);
        while (foundPincode) {
            System.out.println("You already found the hints.");
            MainMenu();

        }
        while (!foundPincode) {
            System.out.println("Type 'look' to look around the room and 'get' to pick up any object");
            String action = scanner.nextLine();

            if (action.equals("look")) {
                System.out.println("There is a gadget here and a letter with something written on it.");
            } else if (action.equals("get")) {
                System.out.println("What would you like to get? (type 'letter')");
                String item = scanner.nextLine();

                if (item.equals("letter")) {
                    System.out.println("The number written on the letter '7802' Remember this number you might need it later ;) ");
                    System.out.println("Awesome!! You've found the pincode to open the safe.");
                    foundPincode = true;
                    MainMenu();
                }
            } else {
                System.err.println("Invalid command. Type 'look' or 'get'.");
            }
        }
        MainMenu();
    }

    // Room5 method checks if all the requirements are meet. If yes, you win the game. If not you are redirected to main menu to proceed with the game further.
    public static void Room5() {
        if (foundBatteries && foundPincode && foundPortalGun && foundKey) {
            System.out.println(" Cheers !!! You've opened a portal to wonderland! We wish you a lot of joy in your life. Remember you are a Champion ;)");
            System.out.println(" You have won the game! Had Fun? XD");
            System.exit(0);
        } else {
            System.err.println("You don't have the required items to win the game and enter wonderland. Keep going you are doing good!");
            MainMenu();
        }
    }

}


