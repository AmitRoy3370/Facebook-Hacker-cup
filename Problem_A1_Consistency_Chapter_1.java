import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.File;

public class Problem_A1_Consistency_Chapter_1 {

	static int testCases, n;

	static char x[];

	static StringBuilder ans = new StringBuilder();

	static void solve(int t) {

		int min_changes = Integer.MAX_VALUE;

		boolean vowel[] = new boolean[26];

		vowel['a' - 'a'] = true;
		vowel['e' - 'a'] = true;
		vowel['i' - 'a'] = true;
		vowel['o' - 'a'] = true;
		vowel['u' - 'a']  = true;

		char ch[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

		for(int i = 0; i < 26; ++i) {

			int changes = 0;

			for(char j : x) {

				if(j == ch[i]) {

					continue;

				}

				if(vowel[(j - 'a')] == vowel[(ch[i] - 'a')]) {

					changes += 2;

				} else {

					++changes;

				}
				
			}

			min_changes = Math.min(min_changes, changes);

		}

		ans.append("Case #").append(t).append(": ").append(min_changes).append("\n");

	}

	public static void main(String[] priya) throws IOException, FileNotFoundException, NullPointerException {
		
		fileIo();
		writeFile();

	}

	private static void fileIo() throws FileNotFoundException, NullPointerException, IOException {

		FileReader fr = new FileReader(new File("Problem_A1_Consistency_Chapter_1.in"));

		BufferedReader br = new BufferedReader(fr);

		String line;

		int t = 0;

		while((line = br.readLine()) != null) {

			if(t == 0)  {

				testCases = Integer.parseInt(line.trim());

			} else {

				x = line.trim().toLowerCase().toCharArray();

				n = x.length;

				solve(t);

			}

			++t;

			if(t > testCases) {

				break;

			}

		}

	}

	private static void writeFile() throws IOException, FileNotFoundException, NullPointerException {

		FileWriter fw = new FileWriter(new File("Problem_A1_Consistency_Chapter_1.out"));

		fw.write(ans.toString());

		fw.close();

	}
	
}