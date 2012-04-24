import java.util.ArrayList;

/*
You are given an unsorted array A of n elements, now construct an array B for which B[i] = A[j]
 where j is the least number such that A[j] > A[i] and j>i if such a j does not exist B[i] = -1 Eg:
A={1,3,5,7,6,4,8}
B = {3 5 7 8 8 8 -1}
*/
public class NextLargeInteger {
	public static void main(String args[]) {
		int A[] = {1,3,5,7,6,4,8};
		ArrayList<Integer> B = new ArrayList<Integer>();
		int max = nextMax(A,0);
		for(int j = 0; j<A.length; j++) {
			if(A[j] >= max) {
				max = nextMax(A,j);
			}
			B.add(j, max);
		}
		System.out.println(B);
		
	}
	public static int nextMax(int A[], int pos) {
		int max = A[pos];
		for(int i=pos+1; i< A.length; i++) {
			if(A[i] > max) {
				max = A[i];
				return max;
			} else if(i == (A.length -1)) {
				return -1;
			}
		}
		return -1;
	}
}
