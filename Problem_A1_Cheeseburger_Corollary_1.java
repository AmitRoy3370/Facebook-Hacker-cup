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

		ans.append("Case #").append(t).append(": ");

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

		/*for(long i : a) {

			ans.append(i).append(" ");

		}

		ans.append("\n");*/

		Collections.sort(list);

		int index = 0;

		for(long y : list) {

			a[index++] = y;

		}

		Map<Integer, Integer> connection = new HashMap<>();

		Map<Long, Integer> map = new HashMap<>();

		long answer = -1L;
		int back = n - 1;
		long last = 0L;

		for(int i = 1; i <= n / 2; ++i) {

			connection.put(i, back);
			connection.put(back, i);

			long element = a[i] + a[back];

			if(map.containsKey(element)) {

				map.put(element, map.get(element) + 1);

				last = element;

			} else {

				map.put(element, 1);
				last = element;

			}

			--back;

		}

		if(map.size() == 1) {

			for(long y : map.keySet()) {

				last = y;
				break;

			}

			long answer_ = last - a[0];

			if(answer_ > 0L) {

				answer = answer_;

			}

		}

		for(int i = 1; i < n; ++i) {

			long temp = a[i] + a[(int)connection.get(i)];

			if(map.containsKey(temp)) {

				map.put(temp, map.get(temp) - 1);

				if(map.get(temp) <= 0) {

					map.remove(temp);

				}

			}

			if(!map.containsKey(temp)) {

				//map.remove(temp);

			}

			int start = i, end = connection.get((int)i);

			connection.put((i - 1), end);
			connection.put(end, i - 1);

			long pair = a[i - 1] + a[end];

			if(!map.containsKey(pair)) {

				map.put(pair, 1);

			} else {

				map.put(pair, 1 + map.get(pair));

			}

			if(map.size() == 1) {

				long first = 0;

				for(long i1 : map.keySet()) {

					first = i1;
					break;

				}

				long diff = first - a[i];

				if(diff > 0) {

					if(answer == -1) {

						answer = diff;

					} else {

						answer = Math.min(answer, diff);

					}

				}

			}

		}

		ans.append(answer);

		if(t != testCases) {

			ans.append("\n");

		}

	}

	static void solve(int t) {

		ans.append("Case #").append(t).append(": ");

		long only_one = C / A;

		long only_two = 2L * (C / B) - 1L;

		long one_single_max_double = (2L * (((C - A)) / B)) + 1L;

		long two_single_max_double = 2L + (2L * (((C - 2L * A)) / B));

		long final_ans = Math.max(only_two, only_one);

		if(C > A) {

			final_ans = Math.max(final_ans, one_single_max_double);

		} 

		if(C > 2L * A) {

			final_ans = Math.max(final_ans, two_single_max_double);

		}

		ans.append(final_ans);

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

					A = Long.parseLong(s1[0]);
					B = Long.parseLong(s1[1]);
					C = Long.parseLong(s1[2]);

					solve(t);

					/*n = Integer.parseInt(line.trim());

					n = 2 * n - 1;

					a = new long[n];

					line = br.readLine();

					String s1[] = line.trim().split(" ");

					for(int i = 0; i < n; ++i) {

						a[i] = Long.parseLong(s1[i]);

					}

					C(t);*/

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