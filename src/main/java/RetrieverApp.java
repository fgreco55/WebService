import java.util.Scanner;

/*
    RetrieverApp - simple app to retrieve web information based on user input from the console
 */
public class RetrieverApp {

    public static void main(String[] args) {
        RetrieverApp rp = new RetrieverApp();
        String command = null;              // initialize to null string, ie, nothing
        String subcommand = null;           // same thing...
        ServiceCommunicator sc = null;      // initialize obj ref to null reference

        while (true) {
            System.out.print("Cmd> ");
            command = rp.getUserInput();
            if (!rp.validateInput(command)) {
                System.out.println("I'm sorry.  [" + command + "] is an invalid service.");
                continue;
            }
            System.out.print("Argument> ");
            switch (command) {
                case "zipcode":
                    subcommand = rp.getUserInput();
                    sc = new Zip(subcommand);
                    break;
                case "music":
                    subcommand = rp.getUserInput();
                    sc = new iTunes(subcommand);
                    break;
                case "television":
                    subcommand = rp.getUserInput();
                    sc = new Tv(subcommand);
                    break;
            }
            System.out.println(sc.get());
        }
    }

    /*
        getUserInput() - get a String token from the user
     */
    public String getUserInput() {
        Scanner scan = new Scanner(System.in);
        return scan.next();
    }

    /*
       validateInput() - make sure only valid commands are used
     */
    public boolean validateInput(String input) {
        String[] services = {"zipcode", "music", "television"};

        for (int i = 0; i < services.length; i++) {
            if (services[i].equals(input))
                return true;
        }
        return false;
    }
}
