class permutation {
    public static void main(String args[]) {
        String str = args[0];
        char arr[] = str.toCharArray();
        permutate(arr, 0);
    }
    public static void permutate( char[] arr, int pos) {
        if(pos == arr.length - 1) {
            System.out.println("R => " +new String(arr));
            return;
        }

        for(int i=pos; i< arr.length; i++) {
            char t = arr[pos];
            arr[pos] = arr[i];
            arr[i] = t;
            permutate(arr,pos+1);
            t = arr[pos];
            arr[pos] = arr[i];
            arr[i] = t;

        }

    }
}
