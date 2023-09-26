import java.io.*;
import java.util.*;

public class Problem_A1_Cheeseburger_Corollary_1 {

	static int testCases, n;
	static long A, B, C, R;

	static long a[];

	static StringBuilder ans = new StringBuilder();

	static Map<Long, Long> map = new HashMap<>();

	static long nim_Sum(long A, long B) {

		return A ^ B;

	}

	static long mex(Set<Long> set) {

		long i = 0L;

		while(set.contains(i)) {

			++i;

		}

		return i;

	}

	static long calculate_grandy(long n, long max_move) {

		if(max_move >= n) {

			return n;

		}

		long cycle = n / (max_move + 1);

		long remaining_budget = n % (max_move + 1);

		if(cycle % 2 == 0) {

			return remaining_budget;

		}
		
		return max_move + 1 - remaining_budget;

	}

	static void B(int t) {

		ans.append("Case #").append(t).append(": ");

		/*map = new HashMap<>();

		long x_or = nim_Sum(calculate_grandy(R, A), calculate_grandy(C, B));

		if(x_or != 0L) {

			ans.append("YES");

		} else {

			ans.append("NO");

		}*/

		if(R > C) {

			ans.append("YES");

		} else {

			ans.append("NO");

		}

		if(t != testCases) {

			ans.append("\n");

		}

	}

	static boolean can_build(long cost_) {

		long num_single = cost_;
		long num_double = cost_;

		long remaining_budget = C;

		long remaining_single_cheeseburger = C - 2 * cost_ * A;
		long remaining_double_cheeseburger = C - B * cost_;

		while(remaining_budget >= A && (num_double > 0 || num_single > 0)) {

			if(remaining_double_cheeseburger >= B && num_double > 0) {

				remaining_double_cheeseburger -= B;
				--num_double;
				remaining_budget -= B;

			} else if(remaining_single_cheeseburger >= A && (num_single > 0)) {

				remaining_single_cheeseburger -= A;
				--num_single;
				remaining_budget -= A;

			} else {

				break;

			}

		}

		return num_single == 0;

	}

	static void C(int t) {

		if(n == 1) {

			ans.append(1);

			if(t != testCases) {

				ans.append("\n");

			}

			return;

		}

		List<Long> list = new ArrayList<>();

		//System.out.println(n);

		for(long i : a) {

			list.add(i);

		}

		Collections.sort(list);

		long sum = 0L;

		for(long i : list) {

			sum += i;

		}

		long L = 1L, R = sum * 2L;

		while(R > L) {

			long mid = (L + R) / 2L;

			boolean find = true;

			long mis_matched_element = -1L;

			boolean visit[] = new boolean[n];

			int mis_matched_count = 0;

			for(int i = 0; i < n; ++i) {

				int l = 0, r = n;

				long element = a[i];

				visit[i] = true;

				find = false;

				while(r > l) {

					int mid_ = (l + r) / 2;

					if(a[mid_] + element == mid && !visit[mid_]) {

						find = true;
						visit[mid_] = true;
						break;

					} else if(a[mid_] + element == mid) {

						L = mid_;

					} else if(a[mid_] + element > mid) {

						r = mid_ - 1;

					} else {

						l = mid_ + 1;

					}

				}

				if(!find) {

					++mis_matched_count;

					mis_matched_element = a[i];

					if(mis_matched_count > 1) {

						break;

					}

				}

			}

			if(mis_matched_count <= 1) {

				System.out.println(mid);

				ans.append(Math.abs(mis_matched_element - mid));

				if(t != testCases) {

					ans.append("\n");

				}

				return;

			}

			//L = mid + 1;
			R = mid - 1;

		}

		ans.append(-1);

		if(t != testCases) {

			ans.append("\n");

		}

	}

	static void solve(int t) {

		ans.append("Case #").append(t).append(": ");

		if(A > C && B > C) {

			ans.append(0);

		} else if(A > C) {

			long buns = (C / B) * 2L;

			ans.append(--buns);

		} else if(B > C) {

			long buns = (C / A);

			ans.append(--buns);

		} else {

			long max_buns = (C / (A + B)) * 4L;

			max_buns = Math.max(max_buns, (C / A) * 2L);

			max_buns = Math.max(max_buns, (C / B) * 2L);

			long max_crims = (C / (A + B)) * 3L;

			max_crims = Math.max(max_crims, (C / A) * 1L);

			max_crims = Math.max(max_crims, (C / B) * 2L);

			ans.append(Math.min(max_crims, --max_buns));

		}

		if(t != testCases) {

			ans.append("\n");

		}

	}

	public static void main(String[] args) throws IOException {

		fileIO();
		writeFile();
		
	}

	private static void fileIO() throws IOException {

		FileReader fr = new FileReader(new File("Problem_A1_Cheeseburger_Corollary_1.in"));

		BufferedReader br = new BufferedReader(fr);

		String line;

		int t = 0;

		while((line = br.readLine()) != null) {

			if(t == 0) {

				testCases = Integer.parseInt(line.trim());

			} else {

				for(; t <= testCases; ++t) {

					String s1[] = line.trim().split(" ");

					R = Long.parseLong(s1[0]);
					C = Long.parseLong(s1[1]);
					A = Long.parseLong(s1[2]);
					B = Long.parseLong(s1[3]);
					//C = Long.parseLong(s1[2]);

					B(t);

					line = br.readLine();

				}

			}

			++t;

			if(t > testCases) {

				break;

			}

		}

	}

	private static void writeFile() throws IOException {

		FileWriter fw = new FileWriter(new File("Problem_A1_Cheeseburger_Corollary_1.out"));

		fw.write(ans.toString());

		fw.close();

	}

	static class element implements Comparable<element> {

		long element;

		int index;

		public element(long element, int index) {

			this.element = element;
			this.index = index;

		}

		public int compareTo(element e) {

			return 0;

		}

	}

}