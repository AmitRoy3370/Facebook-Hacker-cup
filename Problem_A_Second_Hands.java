import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Problem_A_Second_Hands {

	static int testCases, n, k;

	static long a[];

	static StringBuilder ans = new StringBuilder();

	static void solve(int t) {

		if(k * 2 < n) {

			ans.append("Case #").append(t).append(": ").append("NO");
		
		} else {

			Map<Long, Integer> map = new HashMap<>();

			for(long i : a) {

				map.put(i, map.getOrDefault(i, 0) + 1);

			}

			boolean fnd = false;

			for(long i : map.keySet()) {

				if(map.get(i) >= 3) {

					ans.append("Case #").append(t).append(": ").append("NO");
					
					fnd = true;

					break;

				}

			}

			if(!fnd){

			  ans.append("Case #").append(t).append(": ").append("YES");

			}

		}

		if(t != testCases) {

			ans.append("\n");

		}

	} 

	public static void main(String[] priya) throws IOException, FileNotFoundException {
		
		fileIO();
		writeFile();

	}

	private static void fileIO() throws IOException, FileNotFoundException {

		FileReader fr = new FileReader(new File("Problem_A_Second_Hands.in"));

		BufferedReader br = new BufferedReader(fr);

		String line;

		int t = 0, cases = 1;

		while((line = br.readLine()) != null) {

			if(t == 0) {

				testCases = Integer.parseInt(line.trim());

				//System.out.println("here");

			} else {

				for(t = 0; t < testCases; ++t) {

					//System.out.println("come here");

				   String s[] = line.trim().split(" ");

				   n = Integer.parseInt(s[0]);
				   k = Integer.parseInt(s[1]);

				   a = new long[n];

				   line = br.readLine();

				   s = line.trim().split(" ");

				   for(int i = 0; i < n; ++i) {

					  a[i] = Long.parseLong(s[i]);

				   }

				   solve(t + 1);

				   line = br.readLine();

				}

				//System.out.println(n + " " + k);

			}

			++t;

		}

	}

	private static void writeFile() throws IOException {

		FileWriter fw = new FileWriter(new File("Problem_A_Second_Hands.out"));

		fw.write(ans.toString());

		fw.close();

	}

}