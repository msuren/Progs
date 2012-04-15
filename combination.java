class combination {
    public static String res = "";
    public static void main(String args[]) {
        String str = args[0];
        char arr[] = str.toCharArray();
        int r = Integer.parseInt(args[1]);
        combinate(arr, 0, r);
    }
    public static void combinate( char[] arr, int pos, int len) {
        if(res.length() == len) {
            System.out.println("R => " + res);
            return;
        }
        for(int i=pos; i< arr.length; i++) {
            res += Character.toString(arr[i]);
            combinate(arr,i+1,len);
            res = res.substring(0, res.length() - 1);
        }
    }
}
