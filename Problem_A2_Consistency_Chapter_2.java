import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.PriorityQueue;

public class Problem_A2_Consistency_Chapter_2  {

	static int testCases, n, query;

	static char x[];

	static String s[];

	static boolean find = false;

	static char ch[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

	static StringBuilder ans = new StringBuilder();

	static void makeGraph(List<Character> list[]) {

		for(int i = 0; i < 26; ++i) {

			list[i] = new ArrayList<>();

		}

		for(int i = 0; i < query; ++i) {

			s[i] = s[i].toLowerCase();

			//System.out.println(s[i]);

			char a = s[i].charAt(0);
			char b = s[i].charAt(1);

			//ans.append(a).append(" ").append(b).append("\n");

			list[(a - 'a')].add(b);
			//list[(b - 'a')].add(a);

		}

	}

	static int bfs(char source, char target, List<Character> list[]) {

		Queue<Character> queue = new PriorityQueue<>();

		queue.add(source);

		int count = 0;

		boolean visited[] = new boolean[26];

		long distance[] = new long[26];

		find = false;

		visited[(source - 'a')] = true;

		for(int i = 0; i < 26; ++i) {

			distance[i] = Integer.MAX_VALUE;

		}

		distance[(source - 'a')] = 0;

		while(!queue.isEmpty()) {

			char c = queue.poll();

			++count;

			for(char i : list[(c - 'a')]) {

				if(visited[(i - 'a') ]) {

					continue;

				}

				visited[(i - 'a')]  = true;

				if(distance[(c - 'a')] != Integer.MAX_VALUE &&  
			         distance[(c - 'a')] + 1 < distance[(i - 'a')]) {

					distance[(i - 'a')] = distance[(c - 'a')] + 1;

				} else {

					//distance[(i - 'a')] = distance[(c - 'a')] + 1;

				}

				queue.add(i);

				if(i == target) {

					//ans.append("reached here " + count).append("\n");

					find = true;

				}

			}

		}

		//find = false;

		if(distance[(target - 'a')] == Integer.MAX_VALUE) {

			return Integer.MIN_VALUE;

		}

		return (int)distance[(target - 'a')];

	}

	static void solve(int t) {

		//ans.append("come here").append("\n");

		List<Character> list[] = new ArrayList[26];

		makeGraph(list);

		long min_step = Integer.MAX_VALUE;

		long distance[][] = new long[26][26];

		for(int i = 0; i < 26; ++i) {

			for(int j = 0; j < 26; ++j) {

				distance[i][j] = min_step;

				distance[i][i] = 0L;

			}

		}

		for(int i = 0; i < 26; ++i) {

			if(list[i].size() == 0) {

				continue;

			}

			for(char j : list[i]) {

				distance[i][j - 'a'] = 1L;

			}

		} 

		for(int k = 0; k < 26; ++k) {

			for(int i = 0; i < 26; ++i) {

				for(int j = 0; j < 26; ++j) {

					distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
				}

			}

		}

		for(int make = 0; make < 26; ++make) {

			long way = 0;

			for(char i : x) {

				way += distance[i - 'a'][make];

			}

			min_step = Math.min(way, min_step);

		}

		if(min_step == Integer.MAX_VALUE) {

			min_step = -1;
			
		}

		ans.append("Case #").append(t).append(": ").append(min_step).append("\n");

	}
	
	public static void main(String[] priya) throws IOException, FileNotFoundException, NullPointerException {
		
		fileIO();
		writeFile();

	}

	private static void fileIO() throws IOException, FileNotFoundException, NullPointerException {

		FileReader fr = new FileReader(new File("Problem_A2_Consistency_Chapter_2.in"));

		BufferedReader br = new BufferedReader(fr);

		String line;

		int i = 0, count = 1;

		long t = 0L;

		while((line = br.readLine()) != null) {

			if(t == 0L) {

				testCases = Integer.parseInt(line.toLowerCase().trim());

			} else if(t == 1L) {

				x = line.toLowerCase().trim().toCharArray();

				//ans.append(new String(x)).append("\n");

				n = x.length;

				line = br.readLine();

				query = Integer.parseInt(line.toLowerCase().trim());

				//System.out.println(query);

				s = new String[query];

				for(i = 0; i < query; ++i) {

					line = br.readLine();

					s[i] = line.toLowerCase().trim();

					//System.out.println(s[i]);

					if(line != null) {

						line = line.toLowerCase();

					}

				}

				//System.out.println(s[query - 1]);

				/*for(String j : s) {

					System.out.print(j +" ");

				}

				System.out.println();*/

				solve(count++);

			}

			t = 1;

			if(count > testCases) {

				break;

			}

		}

	}

	private static void writeFile() throws IOException, FileNotFoundException, NullPointerException {

		FileWriter fr = new FileWriter(new File("Problem_A2_Consistency_Chapter_2.out"));

		fr.write(ans.toString());

		fr.close();

	}

}