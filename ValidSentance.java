import java.util.HashMap;

/*
Given an input string and a dictionary of words,
segment the input string into a space-separated
sequence of dictionary words if possible. For
example, if the input string is "applepie" and
dictionary contains a standard set of English words,
then we would return the string "apple pie" as output.
		*/

/* USE memoization to optimize this */
public class ValidSentance {

	public static HashMap<String,String> dict = new HashMap<String,String>();
	public static void main(String args[]) {
		
		dict.put("apple", "1");
		dict.put("pie", "1");
		dict.put("a", "1");
		dict.put("sweet", "1");
		System.out.println(findSentance(0,"applepiesweet"));
	}
	
	public static String findSentance(int pos, String str) {
		if(str != null && dict.get(str) != null) {
			return str;
		} 
		for(int i=pos+1; i<= str.length(); i++) {
			String sub = str.substring(pos,i);
			//System.out.println("sub is pos => " + pos + " i => " + i + " sub => " + sub);
			if(sub != null && dict.get(sub) != null) {
				String res = findSentance(i,str);
				if(res == null && i< str.length()) {
					continue;
				} else {
					return sub + " " + res;
				}
			}
		}
		return null;
	}
	
}
