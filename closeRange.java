class closeRange {
    public static void main(String args[]) {
        System.out.println("Close Range program:");
        int arr1[] = {4,12,23,55,88,99};
        int arr2[] = {8,51,81,91,101};
        int p1 =0, p2 =0, minrange = 9999999;
        int r1 = -1, r2 = -1;
        for(int i=0;i < arr1.length ; i++ ) {
            System.out.println(arr1[i]+",");
        }
        System.out.println();
        for(int i=0;i < arr2.length ; i++ ) {
            System.out.println(arr2[i]+",");
        }
        System.out.println();
        while(!(p1 + 1 == arr1.length && arr2[p2] > arr1[p1]) && !(p2 + 1 == arr2.length && arr1[p1] > arr2[p2])) {
            if(Math.abs(arr1[p1] - arr2[p2]) < minrange) {
                minrange = Math.abs(arr1[p1] - arr2[p2]);
                r1 = p1;
                r2 = p2;
            }
            if(arr1[p1] > arr2[p2]) {
                if(p2+1 < arr2.length) {
                    p2 = p2 + 1;
                }
            } else {
                if(p1+1 < arr1.length) {
                    p1 = p1 + 1;
                }
            }
            if( p1 +1 == arr1.length && p2 + 1 == arr2.length ) {
                if(Math.abs(arr1[p1] - arr2[p2]) < minrange) {
                    minrange = Math.abs(arr1[p1] - arr2[p2]);
                    r1 = p1;
                    r2 = p2;
                }
            }
            System.out.println(" min range => " + minrange + " p1 => " + arr1[p1] + " p2 => " + arr2[p2]);
        }
        System.out.println(" min range => " + minrange + " r1 => " + arr1[r1] + " r2 => " + arr2[r2]);
    }
}

