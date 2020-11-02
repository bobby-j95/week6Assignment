import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

class Bracket {
	Bracket(char type, int position) {
		this.type = type;
		this.position = position;
	}

	boolean Match(char c) {
		if (this.type == '[' && c == ']')
			return true;
		if (this.type == '{' && c == '}')
			return true;
		if (this.type == '(' && c == ')')
			return true;
		return false;
	}
	
	int getPosition() {
		return position;
	}

	char type;
	int position;
}

/*
 * Everything with write code here was written by Robert Johns Jr.
 * 
 */
class check_brackets {
	public static void main(String[] args) throws IOException {
		InputStreamReader input_stream = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(input_stream);
		String text = reader.readLine();
		Boolean test = false;
		int failPosition = 0;
		Stack<Bracket> opening_brackets_stack = new Stack<Bracket>();
		for (int position = 0; position < text.length(); ++position) {
			char next = text.charAt(position);

			if (next == '(' || next == '[' || next == '{') {
				Bracket t = new Bracket(next, position);
				opening_brackets_stack.push(t);
				// Process opening bracket, write your code here
			}

			if (next == ')' || next == ']' || next == '}') {
				if (opening_brackets_stack.isEmpty()) {
					// System.out.println(position);
					failPosition = ++position;
					break;
				} else if (!opening_brackets_stack.lastElement().Match(next)) {
					failPosition = ++position;
					break;
				} else {
					// System.out.println("Success");
					opening_brackets_stack.pop();
					/* if(!opening_brackets_stack.isEmpty() && position == text.length()-1) { test =
					 * false; failPosition = opening_brackets_stack.firstElement().getPosition()+1;
					 * break; }
					 */
				}
				// Process closing bracket, write your code here
			}
		}
		

		if (failPosition ==0 && opening_brackets_stack.isEmpty())
		{
			System.out.println("Success");
		}else {
			if(failPosition == 0) {
				while(opening_brackets_stack.size()>1)
					opening_brackets_stack.pop();
				failPosition = opening_brackets_stack.peek().position+1;
			}
			
			System.out.println(failPosition);
		}
		// Printing answer, write your code here
	}
}
