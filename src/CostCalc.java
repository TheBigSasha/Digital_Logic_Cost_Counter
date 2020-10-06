import java.util.Scanner;

public class CostCalc {
    //Cost calculation:
    //Number of gates + inverters + number of inputs per every gate inc. not
    public static void main(String []in){
        Scanner s = new Scanner(System.in);
        System.out.println("Hello there! enter an SOP expression with ABCD... as variable names");
        while(true) {
            String expr = s.nextLine();
            System.out.println(countGates(expr));
        }
        }

    public static int countGates(String sopExpression){
        int counter = 1;        //Or gate
        sopExpression = sopExpression.toLowerCase();
        for(String s : sopExpression.split("[+]")){
            counter+= 1; //This is the and gate
            s = s.replace("(", "").replace(")","");
            s = s.replace("*","");
            String noInverts = s.replace("!","");       //This is the number of inputs to the and
            int numInverts = 0; //Number of inverts
            for(char c : s.toCharArray()){
                if(c == '!'){
                    numInverts++;
                }
            }
            counter += numInverts + noInverts.strip().length();
        }
        return counter;
    }
}
