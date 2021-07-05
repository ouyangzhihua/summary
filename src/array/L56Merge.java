package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class L56Merge {
	/*
	 * 56. 合并区间
	 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
	 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
	 */
	 public int[][] merge(int[][] intervals)
	 {
		 if(intervals.length == 0)
		 {
			 return new int[0][2];
		 }
		 Arrays.sort(intervals, new Comparator<int[]>()
				 {
			 		public int compare(int[] interval1, int[] interval2)
			 		{
			 			return interval1[0] - interval2[0];
			 		}
				 });
		 List<int[]> merged = new ArrayList<>();
		 for(int i = 0; i < intervals.length; i ++)
		 {
			 int l = intervals[i][0];
			 int r = intervals[i][1];
			 if(merged.size() == 0 || merged.get(merged.size()-1)[1] < l)
			 {
				 merged.add(new int[] {l, r});
			 }
			 else
			 {
				 merged.get(merged.size()-1)[1] = Math.max(merged.get(merged.size()-1)[1], r);
			 }
		 }
		 return merged.toArray(new int[merged.size()][]);
	 }
}
