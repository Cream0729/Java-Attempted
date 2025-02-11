package TheVeryBeginning;

public class Println_2 {
    public static void main(String args[]) {
        if (args.length > 0) {
            StringBuilder fullInput = new StringBuilder();
            for (String arg : args) {
                fullInput.append(arg).append(" ");
            }
            System.out.println(fullInput.toString().trim());
        }
    }
}