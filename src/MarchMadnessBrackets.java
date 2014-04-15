/**
 * Created by Raymon on 2014-04-10.
 */
import java.util.ArrayList;

public class MarchMadnessBrackets {

    public static void main(String[] args) {

        String inputArgument="";
        int j = 0;

        for (int i=0; i < args.length; i++) {
            inputArgument += args[i] + " ";
        }

        System.out.println("Input String: " + inputArgument);

        /*
        Bracket Algorithm starts here
         */

        ArrayList<String> openBrackets = new ArrayList<String>();
        ArrayList<Integer> openBracketIndex = new ArrayList<Integer>();
        ArrayList<String> closeBrackets = new ArrayList<String>();
        ArrayList<Integer> closeBracketIndex = new ArrayList<Integer>();
        ArrayList<String> listString = new ArrayList<String>();

        // Traverse through the input argument for bracket locations
        for (int i = 0; i < inputArgument.length(); i++) {
            // Get bracket locations
            if (isOpenBracket(inputArgument.charAt(i))) {
                openBrackets.add(String.valueOf(inputArgument.charAt(i)));
                openBracketIndex.add(i);
            } // If open bracket save it to openBrackets arraylist
            else if (isCloseBracket(inputArgument.charAt(i))) {
                closeBrackets.add(String.valueOf(inputArgument.charAt(i)));
                closeBracketIndex.add(i);
            }
        }

        // Check for right amount of brackets
        if (openBrackets.size() > closeBrackets.size()) {
            System.out.println("Missing closing bracket");
            System.exit(1);
        } else if (openBrackets.size() < closeBrackets.size()) {
            System.out.println("Missing open bracket");
            System.exit(1);
        }

        // Check for mismatched brackets
        for (int i = 0; i < openBrackets.size(); i++) {
            if (openBrackets.get(i).equalsIgnoreCase("[")) {
                if (!(closeBrackets.get((closeBrackets.size()-1)-i).equalsIgnoreCase("]"))) {
                    System.out.println("Mismatched bracket " + closeBrackets.get(i) + " instead of ]");
                }
            } else if (openBrackets.get(i).equalsIgnoreCase("(")) {
                if (!(closeBrackets.get((closeBrackets.size()-1)-i).equalsIgnoreCase(")"))) {
                    System.out.println("Mismatched bracket " + closeBrackets.get(i) + " instead of )");
                }
            } else if (openBrackets.get(i).equalsIgnoreCase("{")) {
                if (!(closeBrackets.get((closeBrackets.size()-1)-i).equalsIgnoreCase("}"))) {
                    System.out.println("Mismatched bracket " + closeBrackets.get(i) + " instead of }");
                }
            }
        }

        System.out.println(openBracketIndex);
        System.out.println(closeBracketIndex);

        parseString(listString, 0, inputArgument, 0);

        for (int i = 0; i < listString.size(); i++) {
            System.out.print(listString.get(i));
        }

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

    private static int parseString(ArrayList<String> listString, int listLocation, String inputArgument, int position) {

        StringBuilder temp = new StringBuilder("");

        for (; position < inputArgument.length(); position++) {
            if (isOpenBracket(inputArgument.charAt(position))) {
                position = parseString(listString,++listLocation,inputArgument,++position);
            } else if (isCloseBracket(inputArgument.charAt(position))) {
                listString.add(temp.toString());
                return position;
            }
            if (!isCloseBracket(inputArgument.charAt(position))) {
                temp.append(inputArgument.charAt(position));
            }
        }
        return position;
    }
}
