/**
 * Created by Figli on 17.02.2017.
 */
public class LongDivision {
    public static void main(String[] args) {
//        LongDivision longDivision = new LongDivision(78459, 4);
//        LongDivision longDivision = new LongDivision(-78459, 4);
//        LongDivision longDivision = new LongDivision(78459, -4);
//        LongDivision longDivision = new LongDivision(-78459, -4);
//        LongDivision longDivision = new LongDivision(-4, 78459);
//        LongDivision longDivision = new LongDivision(4, -78459);
//        LongDivision longDivision = new LongDivision(-4, -78459);
//        LongDivision longDivision = new LongDivision(4, 78459);
//        LongDivision longDivision = new LongDivision(-10001000, -1);
        LongDivision longDivision = new LongDivision(1020, 5);
//        LongDivision longDivision = new LongDivision(12300123, 123);
        longDivision.division();
        longDivision.printResult();
        System.out.println(longDivision.getFinalString());
    }

    private int dividend;
    private int divider;
    private int remainder;
    private String dividendToPrint;
    private String dividerToPrint;
    private StringBuffer dividendSB;
    private StringBuffer resultDivision = new StringBuffer("");
    private StringBuffer printResultDivision = new StringBuffer("");
    private StringBuffer secondSplitedString;
    private StringBuffer print = new StringBuffer("");

    public LongDivision(int dividend, int divider) {
        this.dividend = dividend;
        this.divider = divider;
        this.dividendToPrint = String.valueOf(dividend);
        this.dividerToPrint = String.valueOf(divider);
        resultDivision = new StringBuffer("");
    }

    public void printSomeChar(String someChar, int quantity) {
        for (int i = 0; i < quantity; i++) {
            printResultDivision.append(someChar);
        }
    }

    public void division() {
        StringBuffer oneSpase = new StringBuffer(" ");
        StringBuffer nonSpase = new StringBuffer("");

        checkNegativeAndPositiveNumber();

        dividendSB = new StringBuffer(Integer.toString(dividend));

        for (int i = 0; dividend < divider && dividend >= 0; i++) {
            dividend = Integer.parseInt(dividendSB.append("0").toString());

            if (i > 0) {
                resultDivision.append("0");
            }
        }

        for (int i = 0; dividend >= divider; i++) {
            if (divider == 1) {
                resultDivision.append(dividend);
                break;
            }
            print.append("\n" + nonSpase.toString() + "_" + getLeftDividendNumber());
            count();
            print.append("\n" + nonSpase.toString() + " " + remainder * divider);
            print.append("\n" + oneSpase.toString() + "--");
            if (dividend < divider) {
                print.append("\n" + oneSpase.toString() + dividend);
            }
            oneSpase.append(" ");
            nonSpase.append(" ");
        }

        /*if (dividend != 0) {
            resultDivision.append(".");
        }

        int numberOfDigits = 2;

        while (dividend != 0 && numberOfDigits != 0) {
            for (int i = 0; dividend < divider; i++) {
                dividend = Integer.parseInt(dividendSB.append("0").toString());

                if (i > 0) {
                    resultDivision.append("0");
                }
            }
            print.append("\n" + nonSpase.toString() + "_" + getLeftDividendNumber());
            count();
            print.append("\n" + nonSpase.toString() + " " + remainder * divider);
            print.append("\n" + oneSpase.toString() + "--");
            nonSpase.append(" ");
            oneSpase.append(" ");
            numberOfDigits--;
        }*/

        /*if (dividend < divider) {
            print.append("\n" + nonSpase.toString() + dividend);
        }*/
    }

    private void checkNegativeAndPositiveNumber() {
        if (dividend < divider && dividend > 0) {
            resultDivision.append("0.");
        } else if (dividend < divider && dividend < 0 && divider > 0) {
            resultDivision.append("-");
            dividend = Integer.parseInt(Integer.toString(dividend).substring(1, String.valueOf(dividend).length()));
            if(dividend < divider) {
                resultDivision.append("0.");
            }
        } else if (dividend < divider && dividend < 0 && divider < 0) {
            resultDivision.append("");
            divider = Integer.parseInt(Integer.toString(divider).substring(1, String.valueOf(divider).length()));
            dividend = Integer.parseInt(Integer.toString(dividend).substring(1, String.valueOf(dividend).length()));
        } else if (dividend > divider && dividend > 0 && divider < 0) {
            resultDivision.append("-");
            divider = Integer.parseInt(Integer.toString(divider).substring(1, String.valueOf(divider).length()));
            if(dividend < divider) {
                resultDivision.append("0.");
            }
        }
    }

    public StringBuffer resultDivision() {
        return resultDivision;
    }

    public StringBuffer divisionBalans() {
        return dividendSB;
    }

    public void printResult() {
        printResultDivision.append(" " + dividendToPrint + "|" + dividerToPrint + "\n");
        printSomeChar(" ", dividendToPrint.length() + 1);
        printSomeChar("-", Integer.toString(divider).length() + 1);
        printResultDivision.append("\n");
        printSomeChar(" ", dividendToPrint.length() + 1);
        printResultDivision.append("|");
        printResultDivision.append(resultDivision.toString());
    }

    public String getFinalString() {
        String result = printResultDivision.toString() + print.toString();
        return result;
    }

    public int getLeftDividendNumber() {
        int i = 1;
        while (Integer.parseInt(Integer.toString(dividend).substring(0, i)) < divider) {
            i++;
        }
        StringBuffer firstSplitedString = new StringBuffer(Integer.toString(dividend).substring(0, i));
        secondSplitedString = new StringBuffer(Integer.toString(dividend).substring(i, Integer.toString(dividend).length()));
        return Integer.parseInt(firstSplitedString.toString());
    }

    public void count() {
        remainder = getLeftDividendNumber() / divider;
        resultDivision.append(remainder);
        dividendSB = new StringBuffer(Integer.toString(getLeftDividendNumber() % divider));
//        if(Integer.parseInt(dividendSB.toString()) == 0) {
//            resultDivision.append(dividendSB);
//        }
        dividendSB.append(secondSplitedString);
        dividend = Integer.parseInt(dividendSB.toString());
    }
}
