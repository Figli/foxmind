package example2;

/**
 * Created by Figli on 17.02.2017.
 */
public class Ex2_1 {

    private int dividend;
    private int divider;
    private int n;
    private StringBuffer dividendSB;
    private StringBuffer result = new StringBuffer("");
    private StringBuffer firstSplitedString;
    private StringBuffer secondSplitedString;
    private StringBuffer print = new StringBuffer("");

    public Ex2_1(int dividend, int divider) {
        this.dividend = dividend;
        this.divider = divider;
        result = new StringBuffer("");
        this.dividendSB = new StringBuffer(Integer.toString(this.dividend));
    }

    public void printSomeCharSomeTimes(String s, int n) {
        for (int i = 0; i < n; i++) {
            print.append(s);
        }
    }



    public StringBuffer returnResult() {
        printResult();
        StringBuffer t = new StringBuffer("");
        for (int i = 0; this.dividend >= this.divider; i++) {
            print.append("\n" + t.toString() + this.getLeftDividendNumber());
            count();
            print.append("\n" + t.toString() + n * divider);

            if(this.dividend < this.divider) {
                print.append("\n" + t.toString() + "--");
                print.append("\n" + t.toString() + dividend);
            }
            t.append(" ");

        }

       /* if (this.dividend != 0)
            result.append(".");

        int numberOfDigits = 5;

        while (this.dividend != 0 && numberOfDigits != 0) {
            for (int i = 0; dividend < divider; i++) {
                dividend = Integer.parseInt(dividendSB.append("0").toString());

                if (i > 0) {
                    result.append("0");
                }
            }
            print.append("\n" + t.toString() + this.getLeftDividendNumber());
            count();
            print.append("\n" + t.toString() + n * divider);
            t.append(" ");
            numberOfDigits--;
        }
        if(this.dividend < this.divider) {
            print.append("\n" + t.toString() + "--");
            print.append("\n" + t.toString() + dividend);
        }*/
        return result;
    }

    private void printResult() {
        print.append(dividendSB + "|" + divider + "\n");

        printSomeCharSomeTimes(" ", dividendSB.length());
        printSomeCharSomeTimes("-", Integer.toString(divider).length() + 1 );
        print.append("\n");
        printSomeCharSomeTimes(result.toString(), Integer.toString(divider).length() + 1);

    }

    public int getLeftDividendNumber() {
        int i = 1;
        while (Integer.parseInt(Integer.toString(dividend).substring(0, i)) < this.divider) {
            i++;
        }
        this.firstSplitedString = new StringBuffer(Integer.toString(this.dividend).substring(0, i));
        this.secondSplitedString = new StringBuffer(Integer.toString(this.dividend).substring(i, Integer.toString(this.dividend).length()));
        return Integer.parseInt(this.firstSplitedString.toString());
    }

    public void count() {
        this.n = this.getLeftDividendNumber() / divider;
        result.append(n);
        this.dividendSB = new StringBuffer(Integer.toString(this.getLeftDividendNumber() % divider));
        this.dividendSB.append(this.secondSplitedString);
        dividend = Integer.parseInt(this.dividendSB.toString());
    }


    public static void main(String[] args) {
        Ex2_1 l = new Ex2_1(78459, 4);
//        l.printResult();
        l.returnResult();
        System.out.println(l.print.toString());
    }
}

