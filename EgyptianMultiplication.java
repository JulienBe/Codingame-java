import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EgyptianMultiplication {

    /**
     * You have to multiply two integers (a&b) by means of a method used in Ancien Egypt, described in Rhind’s hieratic papyrus written circa −1650 by Ahmes. This method is still used in Russia.
     * <p>
     * First, sort the two numbers.
     * Then follow the steps below, the algorithm uses base-2 decomposition of the biggest number.
     * We multiply 12 by 5, here is what you have to print, excepted the comments after hashes.
     * <p>
     * 12 * 5
     * = 12 * 4 + 12 # Divide 5 by 2, the remain is 1 and 5=2×2+1, thus 12*5=12*(2*2+1)=12*2*2+12=24*2+12
     * = 24 * 2 + 12 # Divide 2 by 2, 2=1*2+0 and 12*5=24*(1*2+0)+12=48*1+12
     * = 48 * 1 + 12 # Divide 1 by 2, 1=0*2+1 and 12*5=48*(0*2+1)+12=12+48
     * = 48 * 0 + 12 + 48 # End of the algorithm
     * = 60
     **/

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Pair initialInputs = new Pair(in.nextInt(), in.nextInt());

        String l1 = initialInputs.high + " * " + initialInputs.low;
        String last = "= " + (initialInputs.high * initialInputs.low);
        int currentSecond = initialInputs.low;
        List<String> between = new ArrayList<>();
        int currentFirst = initialInputs.high;
        StringBuilder plusses = new StringBuilder();

        do {
            int modulo = currentSecond % 2;
            if (modulo == 1) {
                plusses.append(" + ").append(currentFirst);
            }
            currentFirst *= 2 - modulo;
            currentSecond /= 2 - modulo;
            currentSecond -= modulo;
            between.add("= " + currentFirst + " * " + currentSecond + plusses);
        } while (currentSecond > 0);

        System.out.println(l1);
        if (initialInputs.low > 0)
            between.forEach(System.out::println);
        System.out.println(last);
    }

    static class Pair {
        final int high; final int low;
        Pair(int inputA, int inputB) {
            high = Math.max(inputA, inputB);
            low = Math.min(inputA, inputB);
        }
    }
}
