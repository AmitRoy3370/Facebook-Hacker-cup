import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Problem_B1_Second_Friend {

	static int testCases, r, c;

	static char board[][];

	static StringBuilder ans = new StringBuilder();

	static void solve(int t) {

		ans.append("Case #").append(t).append(":");

		if(r == 1 && c == 1) {

			ans.append(" Impossible");

		} else {

			for(int i = 0; i < r; ++i) {

				for(int j = 0; j < c; ++j) {

					if(board[i][j] == '^') {

						continue;

					}

					board[i][j] = '^';

				}

			}

			boolean ok = true;

			for(int i = 0; i < r; ++i) {

				for(int j = 0; j < c; ++j) {

					int friends = 0;

					if(i - 1 >= 0) {

						++friends;

					}

					if(i + 1 < r) {

						++friends;

					}

					if(j + 1 < c) {

						++friends;

					}

					if(j - 1 >= 0) {

						++friends;

					}

					if(friends >= 2) {

						ok = true;

					} else {

						ok = false;
						break;

					}

				}

				if(!ok) {

					break;

				}

			}

			if(ok) {

				ans.append("Possible").append("\n");

				for(int i = 0; i < r; ++i) {

					for(int j = 0; j < c; ++j) {

						ans.append(board[i][j]);

					}

					if(i != r - 1) {

						ans.append("\n");

					}

				}
			} else {

				ans.append("Impossible");

			}

		}

		if(t != testCases) {

			ans.append("\n");

		}

	}

	public static void main(String[] amit) throws IOException, FileNotFoundException {
		
		fileIO();
		writeFile();

	}

	private static void fileIO() throws IOException, FileNotFoundException {

		FileReader fr = new FileReader(new File("Problem_B1_Second_Friend.in"));

		BufferedReader br = new BufferedReader(fr);

		int t = 0;

		String line;

		while((line = br.readLine()) != null) {

			if(t == 0) {

				testCases = Integer.parseInt(line.trim());

			} else {

				for(t = 1; t <= testCases; ++t) {

					String s[] = line.trim().split(" ");

					r = Integer.parseInt(s[0]);
					c = Integer.parseInt(s[1]);

					//System.out.println(r + " " + c);

					board = new char[r][c];

					int empty_space = 0;

					for(int i = 0; i < r; ++i) {

						line = br.readLine();

						String s1 = line.trim();

						for(int j = 0; j < c; ++j) {

							board[i][j] = s1.charAt(j);

							if(board[i][j] == '.') {

								++empty_space;

							}

						}

					}

					if(empty_space == r * c) {

						ans.append("Case #").append(t).append(":").append("Possible").append("\n");

						for(int i = 0; i < r; ++i) {

							for(int j = 0; j < c; ++j) {

								ans.append(board[i][j]);

							}

							if(i != r - 1) {

								ans.append("\n");

							}

						}

						if(t != testCases) {

							ans.append("\n");

						}

					} else {

					    solve(t);

				    }

					line = br.readLine();

				}

			}

			++t;

			if(t >= testCases) {

				break;

			}

		}

	}

	private static void writeFile() throws IOException, FileNotFoundException {

		FileWriter fw = new FileWriter(new File("Problem_B1_Second_Friend.out"));

		fw.write(ans.toString());

		fw.close();

	}

}