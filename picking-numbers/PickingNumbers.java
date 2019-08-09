import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int pickingNumbers(List<Integer> a) {
    // Sort
    Collections.sort(a);
    // Initialize map of freqs
    Map<Integer, Integer> freqs = new HashMap<Integer, Integer>();

    for (Integer n : a) {
        if (freqs.containsKey(n)) freqs.put(n, freqs.get(n) + 1);
        else freqs.put(n, 1);
    }

    // iterate over the map and calc diff between keys and add as a sum of array elements size
    int max = 0;

    for(Integer k : freqs.keySet()) {
        int curr = 0;
        if (freqs.get(k+1) != null) curr = freqs.get(k) + freqs.get(k+1);
        else curr = freqs.get(k);

        if (curr > max) max = curr;
    }
        return max;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] aTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> a = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aTemp[i]);
            a.add(aItem);
        }

        int result = Result.pickingNumbers(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
