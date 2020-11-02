import java.util.*;
import java.io.*;

/*Created By: Robert Johns Jr.
 * This program, when inputted correctly will let the user push, pop, and 
 * get max values of a stack. 
 */
public class StackWithMax {
	private Stack<Integer> mainStacker;
	private Stack<Integer> maxValues;

	public StackWithMax() {
		mainStacker = new Stack<Integer>();
		maxValues = new Stack<Integer>();
	}

	//allows user to see top value in mainStacker
	public int peek() {
		return mainStacker.peek();
	}
	
	//allows user to get max value in stack
	public int maxValue() {
		return maxValues.peek();
	}
	
	//pushes last value in the main stacker and checks if it needs to add
	//that value in max values
	public void push(int val) {
		mainStacker.push(val);
		if (maxValues.empty() || val >= maxValue())
			maxValues.push(val);
	}

	//pops the last value in main stacker
	public int pop() {
		if (mainStacker.peek() == maxValue())
			maxValues.pop();
		return mainStacker.pop();
	}

	//the main part of the program
	static public void main(String[] args) throws IOException {
		FastScanner scanner = new FastScanner();
		int queries = scanner.nextInt();
		StackWithMax stack = new StackWithMax();
		for (int qi = 0; qi < queries; ++qi) {
			String operation = scanner.next();
			if ("push".equals(operation)) {
				int value = scanner.nextInt();
				stack.push(value);
			} else if ("pop".equals(operation)) {
				stack.pop();
			} else if ("max".equals(operation)) {
				System.out.println(stack.maxValue());
			}
		}
	}
}

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