
public class MinMaxCurve {
	public static void main(String args[]) {
		int arr[] = {7,4,8,2,22,8,22,64,36,23};
		int start = 0,maxstart = 0;
		int  maxend = 0;
		int maxsum = 0;
		int sum = 0;
		for(int i = 1; i< arr.length; i++) {
			int change = arr[i] - arr[i-1];
			if(sum + change > maxsum) {
				maxsum = sum + change;
				maxstart = start;
				maxend = i;
			}
			if(sum + change <= 0) {
				start = i;
				sum = 0;
			} else {
				sum = sum + change;
			}
		}
		
		System.out.println(" start => " + arr[maxstart] +" end => " + arr[maxend]);
		
		
	}
}
