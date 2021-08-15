//https://www.codewars.com/kata/the-wrong-way-cow
//
//Task
//Given a field of cows find which one is the Wrong-Way Cow and return her position.
//
//Notes:
//
//There are always at least 3 cows in a herd
//There is only 1 Wrong-Way Cow!
//Fields are rectangular
//The cow position is zero-based [x,y] of her head (i.e. the letter c)
//Examples
//Ex1
//
//cow.cow.cow.cow.cow
//cow.cow.cow.cow.cow
//cow.woc.cow.cow.cow
//cow.cow.cow.cow.cow
//Answer: [6,2]
//
//Ex2
//
//c..........
//o...c......
//w...o.c....
//....w.o....
//......w.cow
//Answer: [8,4]
//
//Notes
//The test cases will NOT test any situations where there are "imaginary" cows, so your solution does not need to worry about such things!
//
//To explain - Yes, I recognize that there are certain configurations where an "imaginary" cow may appear that in fact is just made of three other "real" cows.
//In the following field you can see there are 4 real cows (3 are facing south and 1 is facing north). There are also 2 imaginary cows (facing east and west).
//
//...w...
//..cow..
//.woco..
//.ow.c..
//.c.....

package extras.the_wrong_way_cow;

import java.util.ArrayList;

public class TheWrongWayCow {

    public static int[] findWrongWayCow(final char[][] field) {
        // Fill in the code to return the x,y coordinate position of the
        // head (letter 'c') of the wrong way cow!
    	int oneWay = 0;
    	int anotherWay = 0;
    	int count = 0;
    	int oneX = 0;
    	int oneY = 0;
    	int anotherX = 0;
    	int anotherY = 0;
    	int[] xy = new int[2];
        for(int i = 0;i < field.length;i++) {
        	for(int j = 0;j < field[i].length;j++) {
        		if(field[i][j] == 'c') {
        			try {
	        			if(field[i][j+1] == 'o' && field[i][j+2] == 'w') {
	        				oneWay++;
	        				oneX = j;
	        				oneY = i;
	        			}
	        			else {
	        				anotherWay++;
	        				anotherX = j;
	        				anotherY = i;
	        			}
        			}
        			catch (Exception e) {
        				anotherWay++;
        				anotherX = j;
        				anotherY = i;
        			}
        			if(oneWay >= 1 && anotherWay >= 1) {
        				if(oneWay > anotherWay) {
        					xy[0] = anotherX;
        					xy[1] = anotherY;
        					break;
        				}
        				else {
        					xy[0] = oneX;
        					xy[1] = oneY;
        					break;
        				}
        			}
        		}
        		
        	}
        }
        return xy;
    }
}
