
public class InPlaceShuffle {
	/** this program shuffle the array given a1,a2,a3,b1,b2,b3 => a1,b1,a2,b2,a3,b3 **/

	public static void main(String args[]) {
	       String input = "1234567abcdefg";
	       char arr[] = input.toCharArray();
	       int j = 1;
	       int count=0;
	       int i=1;
	       int start = i;
	       int  N= arr.length -1;
	       char temp = arr[1];
	       while(count<(N-1)){//to keep track of no:re-arranges which is N-1 in total
	               int newpos = 2*i  % N;
	               //System.out.println("\n swamping " + i +" and " + newpos );
	               char t=arr[newpos];
	               arr[newpos] = temp;
	               temp  = t;
	               i=newpos;
	               if( i == start) {
	            	   //  in case if it struck in a look
                       //THIS IS WRONG AND COMPUTING NEXT CYCLE IS MORE COMPLICATED THE YOU THINK
	            	   start = start+1;
                       
                       temp = arr[start];
	               }
	               count++;
	       }
           for(int m=0;m<arr.length; m++) {
               System.out.print(arr[m]+",");
           }

	}
	
}

/*
C implementation of the in-place perfect shuffle permutation

http://spellscroll.com/viewquestions/?tag=shuffle
http://fayaa.com/code/view/612/

This C code was slightly modified by spellscroll@gmail.com from the original C code posted by
'shyx' in the following post:

(Originaly copied from the url
http://www.mitbbs.com/article_t1/JobHunting/31168039_0_1.html 
which is now invalid!)

ansonyy (ansonyy):
Suppose we have an array
a1,a2,... ,an, b1,b2,..., bn

How to change this array to
a1,b1,a2,b2, ..., an,bn in O(n) time and in O(1) space.


shyx (shyx):

Here's a more detailed explanation of my code. I am not sure if it is the
simplest or the most elegant way to solve the problem but it is the best
result I am aware of. I hope it helps.

For convenience I'll denote the input as a 1D array of 2n numbers: "a[2*n]"
Here a[0] is the "a1" and a[2*n-1] is the "bn" in Ansonyy's original post.

First you will notice that among the 2*n numbers in the array, the 2 numbers
a[0] and a[2*n-1] are never moved. The rest 2*n-2 numbers are moved in an
interleaving pattern:

a[1] --> entry n
a[2] --> entry 1
a[3] --> entry n+1
a[4] --> entry 2
...
a[2*n-3] --> entry 2*n-2
a[2*n-2] --> entry n-1

To summarize, here's a formula for where each a[i] is moved to:

a[i] --> entry ((i*n) % (2*n-1))

For example, let n=6. Here's how each entries are moved (I'm omitting
entries 0 and 11 because they're not moved)

1->6, 2->1, 3->7, 4->2, 5->8, 6->3, 7->9, 8->4, 9->10, 10->5

To achieve O(1) space, you can't have a temp buffer to hold numbers,
so you can only swap a pair of numbers at a time, or shift them in
a circle. Here's how you can reorder the numbers in a circle:

1->6->3->7->9->10->5->8->4->2->1

Easy, right? You just start at a[1] and move the numbers around the
circle. It will be O(n) time.

Unfortunately not all values of n results in such easy patterns. For
example let's try n=23. Here's the circles you'll have to deal with:

1->23->34->17->31->38->19->32->16->8->4->2->1 (12 numbers)
3->24->12->6->3 (4 numbers)
5->25->35->40->20->10->5 (6 numbers)
7->26->13->29->37->41->43->44->22->11->28->14->7 (12 numbers)
9->27->36->18->9 (4 numbers)
15->30->15 (2 numbers)
21->33->39->42->21 (4 numbers)

You can try some larger n but you'll realize that things can get messy.
The reason behind the mess is: 2*n-1 = 45 is not a prime number. It is
divisible by 3 and 5, which means if you start a circle with a number
that is also divisible by 3 or 5, the circle will be "short" because
there aren't that many numbers divisible by 3 or 5 between 1 and 44!

But wait. Even if 2*n-1 is a prime number, there's no guarantee that
you only have 1 big circle to deal with. For example let n=16, then
2*n-1 = 31 is a prime number. But here's the circles:

1->16->8->4->2->1 (4 numbers)
3->17->24->12->6->3 (4 numbers)
5->18->9->20->10->5 (4 numbers)
7->19->25->28->14->7 (4 numbers)
11->21->26->13->22->11 (4 numbers)
15->23->27->29->30->15 (4 numbers)

In general, for values of n such that 2*n-1 is a prime number, you'll
expect to deal with x circles where each circle contains (2*n-2)/x
numbers, but x can be a fairly large value. However, notice that value
(2*n-2) must be divisible by x. Therefore if (n-1) is also a prime
number, then x can only be either 1 or 2. (Note that x will never be
(n-1) or (2*n-2) because that would mean each circle only has 1 or 2
numbers, which is impossible unless n <= 2). When that is the case,
you just need to start a circle from a[1] and shift the numbers while
keeping counting until you're back to a[1]. If you have moved all the
numbers, then you're done; otherwise you'll need to start another circle
from a[2*n-2] and do it again, then you'll be done.

There are plenty of n such that both (n-1) and (2*n-1) are prime numbers.
It is estimated that the reciprocal of their density is O(log(n)^2). Thus
if n doesn't satisfy the requirement, we can always search for a value m
that is almost as large as n and do the reordering on the 2*m numbers
first: a[0], a[1], ..., a[m-1]; a[n], a[n+1], ..., a[n+m-1]. After that
we'll move the 2*m numbers to the front of the array, and reorder the rest
2*(n-m) numbers.
*/
