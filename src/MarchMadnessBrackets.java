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

        ArrayList<String> toPrintArray = new ArrayList<String>();
        String toPrint = "";
        String brackets = "";
        int layer = 0;

        // Traverse through the input argument
        for (int i = 0; i < inputArgument.length(); i++) {
            // If the character is an opening bracket, save it to brackets
            if(isOpenBracket(inputArgument.charAt(i))) {
                if (inputArgument.charAt(i) == '[') {
                    brackets += "]";
                } else if (inputArgument.charAt(i) == '{') {
                    brackets += "}";
                } else if (inputArgument.charAt(i) == '(') {
                    brackets += ")";
                }
                layer++;
            } // Else if the character is a closing bracket, check opening bracket
            else if (isCloseBracket(inputArgument.charAt(i))) {
                // If character is equal the last added end bracket
                if (inputArgument.charAt(i) == brackets.charAt(brackets.length()-1)) {
                    // Delete the last bracket in brackets string
                    brackets = removeLastChar(brackets);
                } else { // Else the closing bracket does not match, print error
                    System.out.println("Missing bracket " +brackets.charAt(brackets.length()-1) + "instead of "
                            + inputArgument.charAt(i) + " found");
                    System.exit(1);
                }
            } // Else concatenate the string
            else {
                toPrint += inputArgument.charAt(i);
            }
        }

        System.out.println(toPrintArray);

    }

    private static boolean isOpenBracket(char input) {
        char[] startBracket = {'{','[','('};

        for (int i = 0; i < 3; i++) {
            if (input == startBracket[i]) {
                return true;
            }
        }
        return false;
    }

    private static boolean isCloseBracket(char input) {
        char[] endBracket = {'}',']',')'};

        for (int i = 0; i < 3; i++) {
            if (input == endBracket[i]) {
                return true;
            }
        }
        return false;
    }

    private static String removeLastChar(String str) {
        return str.substring(0,str.length()-1);
    }
}
