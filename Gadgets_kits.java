
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Gadgets_kits {

    static Scanner in = new Scanner(System.in);

    static int n, testCases;

    static long a[];

    static StringBuilder finalAns = new StringBuilder();

    static void solve(int t) {

        long ans = a[0];

        for (int i = 1; i < n; ++i) {

            //System.out.print("lcd of " + ans + " ans " + i + " is: ");
            ans = gcd(ans, a[i]);

            //System.out.println(ans);
        }

        //System.out.println("testCases: " + t + " " + ans);
        long count = 0;

        for (long i = 1; i <= ans; i++) {

            if (ans % i == 0) {
                count++;
            }

        }

        ans = count;

        finalAns.append("Case #").append(t).append(": ").append(ans).append("\n");

    }

    public static void main(String[] amit) throws IOException {

        File file = new File("input_data.txt");

        Scanner scanner = new Scanner(file);

        int t = 0;

        while (scanner.hasNextLine()) {

            if (t == 0) {

                testCases = Integer.parseInt(scanner.nextLine().trim());

            } else {

                n = Integer.parseInt(scanner.nextLine().trim());

                a = new long[n];

                String s[] = scanner.nextLine().split(" ");

                for (int i = 0; i < n; i++) {

                    a[i] = Long.parseLong(s[i].trim());

                }

                solve(t);

            }

            ++t;

        }

        /*Scanner in=new Scanner(System.in);
        
        int testCases = in.nextInt();
        
        for(int t=1;t<=testCases;t++){
            
            n=in.nextInt();
            
            a=new long[n];
            
            for(int i=0;i<n;i++){
                
                a[i] = in.nextLong();
                
            }
            
            solve(t);
            
        }*/
        //System.out.println(finalAns.toString());

        File file1 = new File("output_data.txt");

        FileWriter out = new FileWriter(file1);

        out.write(finalAns.toString());

        out.flush();
        out.close();

    }

    static long gcd(long a, long b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }

    static long lcd(long a, long b) {

        long run = Math.max(a, b);

        for (long i = 2; i * i <= run; i++) {

            if (a % i == 0 && b % i == 0) {

                return i;

            }

        }

        return 1;

    }

}
