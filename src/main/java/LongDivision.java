import java.util.Arrays;

/**
 * Created by Figli on 17.02.2017.
 */
public class LongDivision {

    private int dividend;
    private int divider;
    private StringBuffer result = new StringBuffer("");
    private StringBuffer print = new StringBuffer("");
    private StringBuffer dividendSB;

    public static void main(String[] args) {

        LongDivision longDivision = new LongDivision(78459, 4);
        longDivision.division();
        System.out.println(longDivision.print.toString());

//        int a = 10 / 3;
//        int b = 10 % 3;
//        System.out.println(a);
//        System.out.println(b);
    }

    public LongDivision(int dividend, int divider) {
        this.dividend = dividend;
        this.divider = divider;
        this.result = result;
        this.dividendSB = new StringBuffer(Integer.toString(this.dividend));
    }

    /*public int getLeftDividendNumber() {

        return null;
    }*/

    public StringBuffer division() {
        print.append(dividendSB + "|" + divider + "\n");
        printSomeCharSomeTimes(" ", dividendSB.length());
//        printSomeCharSomeTimes("|", Integer.toString(divider).length());
        printSomeCharSomeTimes("-", Integer.toString(divider).length() + 1);
        return result;
    }

    public void printSomeCharSomeTimes(String s, int n) {
        for (int i = 0; i < n; i++) {
            print.append(s);
        }
    }

}
