import java.util.*;
import java.io.*;

public class StackWithMax {
	class FastScanner {
		StringTokenizer tok = new StringTokenizer("");
		BufferedReader in;

		FastScanner() {
			in = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (!tok.hasMoreElements())
				tok = new StringTokenizer(in.readLine());
			return tok.nextToken();
		}

		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}

	public void solve() throws IOException {
		FastScanner scanner = new FastScanner();
		int queries = scanner.nextInt();
		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> max = new Stack<Integer>();
		int maxTemp = 0;
		for (int qi = 0; qi < queries; ++qi) {
			String operation = scanner.next();
			if ("push".equals(operation)) {
				int value = scanner.nextInt();
				stack.push(value);
				if (stack.peek() > maxTemp) {
					maxTemp = stack.peek();
					max.push(stack.peek());
				}
				if (max.isEmpty()) {
					max.push(stack.peek());
				}
			} else if ("pop".equals(operation)) {
				if (max.isEmpty()) {
					max.push(stack.peek());
				} else {
					if (stack.peek() > max.peek()) {
						max.push(stack.peek());
					} else {
						max.push(max.peek());
					}
				}
				stack.pop();
			} else if ("max".equals(operation)) {
				System.out.println(max.peek());
				//System.out.println(Collections.max(stack));
			}
		}
	}

	static public void main(String[] args) throws IOException {
		new StackWithMax().solve();
	}
}
