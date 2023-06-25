import java.util.ArrayList;
import java.util.List;

public class LeetcodeGenerateParentheses {
    static List<String> generateParentheses(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        generateBrackets(result, n, 0, 0, sb);
        return result;
    }

    static void generateBrackets(List<String> result, int n, int opening, int closing, StringBuilder output){
        //terminationcase
        if(output.length()==n*2){
            result.add(output.toString());
            return;
        }

        //can i place opening
        if(opening<n){
            output.append("("); //place opening bracket
            generateBrackets(result, n, opening+1, closing, output);

            output.deleteCharAt(output.length()-1); //revoming the previous generated value for storing the new values
        }

        //can i place closing
        if(closing<opening){
            output.append(")");
            generateBrackets(result, n, opening, closing+1, output);
            //stack fall
            output.deleteCharAt(output.length()-1);

        }
    }

    public static void main(String[] args) {
        int n=3;
        System.out.println(generateParentheses(n));
	}
}

