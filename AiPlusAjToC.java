
/*  find Ai + Aj = target  */
public class AiPlusAjToC {
	public static void main(String args[]) {
		int arr[] = {-13,-8,3,5,6,8,12,23};
		int target = 20;
		int start = 0;
		int end = arr.length -1;
		while( start < end) {
			if( arr[end] + arr[start] == target ) {
				break;
			} else if(arr[end] + arr[start] > target ) {
				end--;
			} else if(arr[end] + arr[start] < target ) {
				start++;
			}
		}
		if( start < end ) {
			System.out.println(" start => " + start + " end => " +end);
		} else {
			System.out.println(" no such pairs");
		}
		
	}
}
