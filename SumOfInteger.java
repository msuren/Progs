class SumOfInteger {
    public static void main(String args[]) {
        System.out.println(findSum(5,4));
        System.out.println(findSum(6,5));
        System.out.println(findSum(7,6));
    }

    public static int findSum(int sum, int max) {
        if(sum == 0) {
            return 1;
        }
        if( sum < 0 ) {
            return 0;
        }
        if(max <=0) {
        	return 0;
        }
        return findSum(sum,max-1) + findSum(sum-max,max);
    }
}
