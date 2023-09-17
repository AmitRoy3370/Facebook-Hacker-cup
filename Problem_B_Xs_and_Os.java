import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Problem_B_Xs_and_Os {

	static int testCases, n;

	static char board[][];

	static StringBuilder ans = new StringBuilder();

	static void solve(int t) {

		int X_count_for_x[] = new int[n];

		int X_count_for_y[] = new int[n];

		int O_count_for_x[] = new int[n];

		int O_count_for_y[] = new int[n];

		for(int i = 0; i < n; ++i) {

			for(int j = 0; j < n; ++j) {

				if(board[i][j] == 'X') {

					X_count_for_x[i]++;
					X_count_for_y[j]++;

				} else if(board[i][j] == 'O') {

					O_count_for_x[i]++;
					O_count_for_y[j]++;

				}

			}

		}

		int one_ways = 0;

		for(int x_axis = 0; x_axis < n; ++x_axis) {

			for(int y_axis = 0; y_axis < n; ++y_axis) {

				if(board[x_axis][y_axis] != '.') {

					continue;

				}

				if(X_count_for_x[x_axis] == n - 1 || X_count_for_y[y_axis] == n - 1) {

					++one_ways;

				}

			}

		}

		if(one_ways != 0) {

			ans.append("Case #").append(t).append(": ").append(1).append(" ").append(one_ways);

		} else {

			int min_X = n + 1;

			int min_ways = 0;

			for(int i = 0; i < n; ++i) {

				if(O_count_for_x[i] == 0) {

					if(n - X_count_for_x[i] == min_X) {

						++min_ways;

					} else if(n - X_count_for_x[i] < min_X) {

						min_ways = 1;
						min_X = n - X_count_for_x[i];

					}

				}

				if(O_count_for_y[i] == 0) {

					if(n - X_count_for_y[i] == min_X) {

						++min_ways;

					} else if(n - X_count_for_y[i] < min_X) {

						min_ways = 1;
						min_X = n - X_count_for_y[i];

					}

				}

			}

			if(min_X > n) {

				ans.append("Case #").append(t).append(": ").append("Impossible");
			
			} else {

			    ans.append("Case #").append(t).append(": ").append(min_X).append(" ").append(min_ways);

		    }

		}

		if(t != testCases) {

			ans.append("\n");

		}

	}

	public static void main(String[] priya) throws IOException, FileNotFoundException, NullPointerException {
		
		fileIO();
		writeFile();

	}

	private static void fileIO() throws IOException, FileNotFoundException, NullPointerException {

		FileReader fr = new FileReader(new File("Problem_B_Xs_and_Os.in"));

		BufferedReader br = new BufferedReader(fr);

		String line;

		int t = 0;

		while((line = br.readLine()) != null) {

			if(t == 0) {

				testCases = Integer.parseInt(line.trim());

			} else {

				for(; t <= testCases; ++t) {

					n = Integer.parseInt(line.trim());

					board = new char[n][n];

					line = br.readLine();

					for(int i = 0; i < n; ++i) {

						board[i] = line.trim().toCharArray();

						line = br.readLine();

					}

					solve(t);

				}

			}

			++t;

			if(t > testCases) {

				break;

			}

		}

	}

	private static void writeFile() throws IOException, FileNotFoundException, NullPointerException {

		FileWriter fw = new FileWriter(new File("Problem_B_Xs_and_Os.out"));

		fw.write(ans.toString());

		fw.close();

	}

}