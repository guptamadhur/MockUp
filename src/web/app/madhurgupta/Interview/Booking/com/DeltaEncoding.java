package web.app.madhurgupta.Interview.Booking.com;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: Java MockUp
 */

/*
Problem : Delta Encoding
        Given a list of numbers, e.g.:

        25626 25757 24367 24267 16 100 2 7277
        Output a delta encoding for the sequence. In a delta encoding, the first element is reproduced as is. Each subsequent element is represented as the numeric difference from the element before it. E.g. for the sequence above, the delta encoding would be:

        25626 131 -1390 -100 -24251 84 -98 7275
        However, if a difference value does not fit in a single signed byte, i.e. -127 <= x <= 127, then, instead of the difference, we would like to use an escape token, printing it.

        This will denote that the value following the escape token is a full four-byte difference value, rather than a one-byte different value.

        For this exercise, we'll declare -128 as the escape token.

        Following the same example above, the final result would be:

        25626 -128 131 -128 -1390 -100 -128 -24251 84 -98 -128 7275
*/


class Result {

    /*
     * Complete the 'delta_encode' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY numbers as parameter.
     */

    public static List<Integer> delta_encode(List<Integer> numbers) {
        // Write your code here
        List<Integer> outputNumbers = new ArrayList<Integer>();
        outputNumbers.add(numbers.get(0));
        for (int num = 1; num < numbers.size(); num++) {
            int temp = numbers.get(num) - numbers.get(num - 1);
            if (temp >= -127 && temp <= 127) {
                outputNumbers.add(temp);
            } else {
                outputNumbers.add(-128);
                outputNumbers.add(temp);
            }
        }
        return outputNumbers;
    }
}

public class DeltaEncoding {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int numbersCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> numbers = IntStream.range(0, numbersCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.delta_encode(numbers);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
