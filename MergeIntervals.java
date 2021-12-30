package arrays_450;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
	
	public static int[][] merge(int[][] intervals){
		Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
		
		if(intervals == null || intervals.length == 0)
			return intervals;
		
		int start = intervals[0][0] , end = intervals[0][1];
		List<int[]> ans = new ArrayList<>();
		
		for(int[] item :intervals) {
			
			if(item[0]<=end) {
				end = Math.max(item[1], end);
			}
			else {
				ans.add(new int[] {start, end});
				start = item[0];
				end = item[1];				
			}			
		}
		ans.add(new int[] {start, end});
	       return ans.toArray(new int[0][]);

	}

	public static void main(String[] args) {
		int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
		int [][] ans = merge(intervals);
		
		for(int i=0;i<ans.length;i++) {
			for(int j=0;j<ans[0].length;j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
		

	}

}
