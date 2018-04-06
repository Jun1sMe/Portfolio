import java.util.Map;
import java.util.HashMap;

class Calculate{
	
	private static Calculate instance;
	private Map<Character, Integer> priority;
	private Calculate(){}
	
//	private int priority(char c) {
//		switch(c) {
//		case '+':
//		case '-':
//			return 1;
//		case '*':
//		case '/':
//			return 2;
//		default:
//			return 0;
//		}
//	}
	public static Calculate getInstance() {
		if(instance == null)
			instance = new Calculate();
		if(instance.priority == null) {
			instance.priority = new HashMap<Character, Integer>();
			instance.priority.put('+', 1);
			instance.priority.put('-', 1);
			instance.priority.put('*', 2);
			instance.priority.put('/', 2);
		}
		return instance;
	}
	public static int count(String infix) {
		String postfix = toPostfix(infix);
		Stack stack = new Stack(postfix.length());
		for(char c : postfix.toCharArray()) {
			if(instance.priority.containsKey(c)) {
				int b = stack.pop() - '0', // Earlier is last
						a = stack.pop() - '0';
				switch(c) {
				case '+':
					stack.push((char)(a + b));
					break;
				case '-':
					stack.push((char)(a - b));
					break;
				case '*':
					stack.push((char)(a * b));
					break;
				case '/':
					stack.push((char)(a / b));
					break;
				}
			}
			else
				stack.push(c);
		}
		return stack.pop();
	}
	public static String toPostfix(String infix) {
		return getInstance().toPostfix(infix, true);
	}
	public static String toPrefix(String infix) {
		return getInstance().toPostfix(infix, false);
	}
	private String toPostfix(String infix, boolean isToPostfix) {
		String tmp = isToPostfix ? infix : new StringBuilder(infix).reverse().toString();
		Stack stack = new Stack(infix.length());
		StringBuilder result = new StringBuilder();
		char toPush = isToPostfix ? '(' : ')',
				toPop = isToPostfix ? ')' : '(';
		
		for(char c : tmp.toCharArray()) {
			if(c == toPush)
				stack.push(c);
			else if(c == toPop) {
				while(stack.peep() != toPush) // Until find the pair 
					result.append(stack.pop());
				stack.pop(); // remove the pair
			}
			else if(priority.containsKey(c)) {
				// stack exists a value which is not digit
				while(!stack.isEmpty() && priority.containsKey(stack.peep()) &&
						priority.get(stack.peep()) >= priority.get(c)) {
					result.append(stack.pop());
				}
				stack.push(c);
			}
			else
				result.append(c);
		}
		while(!stack.isEmpty())
			result.append(stack.pop());		
		return isToPostfix ? result.toString() : result.reverse().toString();
	}
}
