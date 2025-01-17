package lambdasinaction.chap5;

import java.util.Arrays;
import java.util.List;

/**
 * Created by raoul-gabrielurma on 14/01/2014.
 */
public class Laziness {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        numbers.stream()
               .filter(n -> {
                   System.out.println("filtering " + n); return n % 2 == 0;
               })
               .map(n -> {
                   System.out.println("mapping " + n);
                   return n * n;
               })
               .limit(2)
               .forEach(System.out::println);

        /**
         * Think the result order
         * result:
         *
         * filtering 1
         * filtering 2
         * mapping 2
         * 4
         * filtering 3
         * filtering 4
         * mapping 4
         * 16
         */

    }


}
