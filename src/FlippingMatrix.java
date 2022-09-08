import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class ResultFlippingMatrix{

    /*
     * Complete the 'flippingMatrix' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
     */

    public static int flippingMatrix(List<List<Integer>> matrix) {
        // given matrix[2n][2n], should find biggest value of matrix[n][n], when reversing rows and columns is allowed
        // Write your code here
        int answer = 0;
        // making max of n*n sum in matrix, in here n eq matrix.size()/2
        int times = matrix.size()/2;
        for (int i = 0; i < times; i++) {
            for (int j = 0; j < times; j++) {
                // every possible numbers are matrix[i][j], matrix[i][n-j-1], matrix[n-i-1][j], matrix[n-i-1][n-j-1]
                // should grab max value in these four possibilities
                int pos1 = matrix.get(i).get((2*times) - j -1);
                int pos2 = matrix.get(i).get(j);
                int pos3 = matrix.get((2*times) - i -1).get(j);
                int pos4 = matrix.get((2*times) - i -1).get((2*times) - j -1);

                answer += Math.max(pos1, Math.max(pos2, Math.max(pos3, pos4)));
            }
        }
        return answer;
    }

}
public class FlippingMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> matrix = new ArrayList<>();

                IntStream.range(0, 2 * n).forEach(i -> {
                    try {
                        matrix.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int result = ResultFlippingMatrix.flippingMatrix(matrix);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
