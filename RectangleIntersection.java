
public class RectangleIntersection {
	public static void main(String args[]) {
		int x1 = 4, y1 = 5, h1 = 5, w1 = 8;
		int x2 = 7, y2= 9, h2 = 6, w2 = 6;
		
		
		
		/* One solution */
		if(x1 < x2 && x2 < x1+w1 && y1 < y2 && y2 < y1+ h1) {
			System.out.println("intersect");
		}
		if(x2 < x1 && x1 < x2+w2 && y2 < y1 && y1 < y2+ h2) {
			System.out.println("intersect");
		}
		
		if(x1 < x2 && x2 < x1+w1 && y2+h2 < y1 && y2+ h2 < y1+h1 ) {
			System.out.println("intersect");
		}
		
		if(x2+w2 > x1 && x2 < x2+w2 && y2 < y1 && y2 < y1+h1 ) {
			System.out.println("intersect");
		}
		
		/* Second solution */
		if(x2 > x1 + w1 || x1 > x2+w2 || y1 > y2 +h2 || y2 > x1 +h1 ) {
			System.out.println("do not intersect");
		} else {
			System.out.println("intersect");
		}
		
	}
}
