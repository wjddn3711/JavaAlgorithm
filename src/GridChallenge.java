
import java.io.*;
import java.lang.reflect.Array;
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

class ResultGridChallenge {

    /*
     * Complete the 'gridChallenge' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING_ARRAY grid as parameter.
     */

    public static String gridChallenge(List<String> grid) {
        for (int i = 0; i < grid.size(); i++) {
            char[] chararray = grid.get(i).toCharArray();
            Arrays.sort(chararray);
            grid.set(i, new String(chararray));
        }

        for (int i = 0; i < grid.get(0).length(); i++) {
            for (int j = 0; j < grid.size() - 1; j++) {
                if (grid.get(j).charAt(i) > grid.get(j + 1).charAt(i)) {
                    return "NO";
                }
            }
        }
        return "YES";
    }

}

public class GridChallenge {
    public static void main(String[] args) throws IOException {
        List<String> t = Arrays.asList("abc", "lmp", "qrt");
        System.out.println(ResultGridChallenge.gridChallenge(t));
    }
}
