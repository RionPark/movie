package test;

import java.util.ArrayList;
import java.util.List;

public class Loop {

	public static void main(String[] args) {
		int[][] numss = new int[3][3];
		numss[0] = new int[]{1,2,3};
		numss[1] = new int[]{4,5,6};
		numss[2] = new int[]{7,8,9};
		for(int i=0;i<numss.length;i++) {
			if(i%2!=1) {
				int[] nums = numss[i];
				for(int num:nums) {
					System.out.println(num);
				}
			}
		}
	}
}
