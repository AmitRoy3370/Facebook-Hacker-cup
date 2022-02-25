
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Seat_exchange {

    static int testCases, n, k;

    static long a[];

    static StringBuilder finalAns = new StringBuilder();

    static void solve(int t) {

        finalAns.append("Case #").append(t).append(": ");

        StringBuilder ans = new StringBuilder();

        long another[] = new long[n];

        /*for (int i = 0; i < n; i++) {
            another[i] = i;
        }

        for (int days = 0; days < k; days++) {

            long b[] = new long[n];

            for (int i = 0; i < n; i++) {

                b[(int) a[i]] = another[i];

            }

            another = b;

        }*/
        boolean visited[] = new boolean[n];

        for (int i = 0; i < n; i++) {

            if (visited[i]) {

                continue;

            }

            int node = i;

            List<Integer> list = new ArrayList<>();

            do {

                visited[node] = true;

                list.add(node);

                node = (int) a[node];

            } while (node != i);
            
            int m = list.size();
            
            for(int j=0; j < m; j++){
                
                another[list.get((j+k) % m ) ] = list.get(j);
                
            }

        }

        for (long i : another) {
            ans.append(i).append(" ");
        }

        finalAns.append(ans).append("\n");

    }

    public static void main(String[] amit) throws IOException {

        File input = new File("Seat_exchange_input.txt");

        Scanner in = new Scanner(input);

        int t = 0;

        while (in.hasNextLine()) {

            if (t == 0) {

                testCases = Integer.parseInt(in.nextLine().trim());

            } else {

                n = Integer.parseInt(in.next().trim());

                k = Integer.parseInt(in.nextLine().trim());

                String s[] = in.nextLine().trim().split(" ");

                a = new long[n];

                for (int i = 0; i < n; i++) {

                    a[i] = Long.parseLong(s[i].trim());

                }

                solve(t);

            }

            ++t;

        }

        File output = new File("Seat_exchange_output.txt");

        FileWriter out = new FileWriter(output);

        out.write(finalAns.toString());

        out.flush();
        out.close();

    }

}
