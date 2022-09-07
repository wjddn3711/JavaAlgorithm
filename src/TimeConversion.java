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

class ResultTimeConversion {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        // Write your code here
        String apm = s.substring(s.length()-2,s.length());
        // time without am/pm
        String real = s.substring(0, s.length()-2);
        int hours = Integer.parseInt(s.substring(0,2));

        // check rather its am or pm
        if(apm.equals("AM")){
            if(hours == 12){
                // if am and hours are 12 then should be 00
                return String.format("00%s", real.substring(2));
            }
        }
        else{
            if(hours <12){
                // if pm and hours are more than 12 then should add 12
                return String.format("%d%s", hours+12, real.substring(2));
            }
        }
        return real;
    }

}

public class TimeConversion {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = ResultTimeConversion.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();

    }
}
