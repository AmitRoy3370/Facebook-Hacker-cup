import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

public class Problem_A_Leapfrog_Ch_1 {

	static int testCases, n;

	static char x[];

	static StringBuilder ans = new StringBuilder();

	static void solve(int t) {

		ans.append("Case #").append(t).append(": ");

		char canWin = 'Y';

		int count[] = new int[2];

		for(char i: x) {

			if(i == '.') {

				continue;
				
			}

			count[i - 'A']++;

		}

		if(count[1] >= n / 2 && n - 2 >= count[1]) {

			canWin = 'Y';

		} else {

			canWin = 'N';

		}

		ans.append(canWin);

		if(t != testCases) {

			ans.append("\n");

		}

	}

	public static void main(String [] amit) throws IOException, FileNotFoundException {

		input();
		writeFile();

	}

	private static void input() throws FileNotFoundException {

		File file = new File("Problem_A_Leapfrog_Ch_1.txt");

		Scanner reader = new Scanner(file);

		testCases = 0;

		int t = 0;

		while(reader.hasNextLine()) {

			if(testCases == 0) {

				testCases = Integer.parseInt(reader.nextLine().trim());

			} else {

				++t;

				x = reader.nextLine().trim().toCharArray();
				n = x.length;
				solve(t);

			}

		}

	}

	private static void writeFile() throws IOException{

		FileWriter fw = new FileWriter("Problem_A_Leapfrog_Ch_1_out.txt");

		BufferedWriter bw = new BufferedWriter(fw);

		bw.write(ans.toString().trim());

		bw.close();

	}

}