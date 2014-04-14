/**
 * Created by Raymon on 2014-04-10.
 */
import java.util.ArrayList;

public class MarchMadnessBrackets {

    public static void main(String[] args) {

        String inputArgument="";

        for (int i=0; i < args.length; i++) {
            inputArgument += args[i] + " ";
        }

        System.out.println("Input String: " + inputArgument);

        /*
        Bracket Algorithm starts here
         */

        char[] openBrackets = {'[', '{', '('};
        char[] endBrackets = {']', '}', ')'};
        ArrayList<String> detectedStartBrackets = new ArrayList<String>();
        ArrayList<String> detectedEndBrackets = new ArrayList<String>();
        int counter = 0, k = 0;
        ArrayList<String> toPrint = new ArrayList<String>();
        String stringInBetween = "";

        for (int i = 0; i < inputArgument.length(); i++) {

            for (int j = 0; j < openBrackets.length; j++) {

                if (inputArgument.charAt(i) == openBrackets[j] ) {

                    // Save the detected open bracket
                    detectedStartBrackets.add(String.valueOf(inputArgument.charAt(i)));
                    if (inputArgument.charAt(i) == '{') {
                        detectedEndBrackets.add("}");
                    } else if (inputArgument.charAt(i) == '(') {
                        detectedEndBrackets.add(")");
                    } else if (inputArgument.charAt(i) == '[') {
                        detectedEndBrackets.add("]");
                    }
                    // Reset strings in between
                    toPrint.add(stringInBetween);
                    stringInBetween = "";
                    // Increment counter
                    counter++;

                } else if (inputArgument.charAt(i) == endBrackets[j]) {

                    k = detectedStartBrackets.size();
                    if (!(String.valueOf(inputArgument.charAt(i)).equals(detectedEndBrackets.get(k-1)))) {
                        System.out.println("Mismatched bracket " + inputArgument.charAt(i) + " instead of "
                                + detectedStartBrackets.get(k-1));
                        //Mismatched brackets found
                        System.exit(1);
                    }
                    toPrint.add(stringInBetween);
                    detectedStartBrackets.remove(k-1);
                }
            }
            stringInBetween += String.valueOf(inputArgument.charAt(i));
        }

        if (detectedStartBrackets.size() > 0) {
            System.out.println("Missing closing bracket for " + detectedEndBrackets.toString());
        } else {
            for (int i = 0; i < toPrint.size(); i++) {
                System.out.println(toPrint.get(i).toString());
            }
        }
    }
}
