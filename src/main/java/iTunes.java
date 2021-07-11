public class iTunes extends ServiceCommunicator{
    /*
         iTunes - contacts iTunes server and returns artist information.
                Note the "limit=1"... that's the max number of entries returned.
                It makes this project easier because we don't have to break apart multiple entries.
                It also doesn't impact the Apple server too much... have to be nice.  :)
    */
    public iTunes (String artist) {
        super("https://itunes.apple.com/search?term=" + artist + "\\&limit=1");
    }

    /*
        Main method - just tests this class in isolation.  Normally you would have another class call iTunesTool
    */
        public static void main(String[] argv) {
            System.out.println(new iTunes("beyonce").get());
            System.out.println(new iTunes("ladygaga").get());
        }
}
