package Leetcode._51_100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//Given a collection of intervals, merge all overlapping intervals.
//
//Example 1:
//
//Input: [[1,3],[2,6],[8,10],[15,18]]
//Output: [[1,6],[8,10],[15,18]]
//Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
/**
 * 1.首先将输入中的Interval按照start属性进行排序。(此操作可以极大地减少程序的编写程度)
 * 2.
 * @author X6S
 *
 */
public class _056_MergeIntervals_write {

	static class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}

		@Override
		public String toString() {
			return "[ start=" + start + ", end=" + end + "]";
		}
	}

	// 看着这组数据来写：[1,5][2,3][9,10][11,14][13,16]
	// 最后的输出结果为：[1,5][9,10][11,16]
	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<>();
		Interval interval1 = new Interval(1, 3);
		Interval interval2 = new Interval(2, 6);
		Interval interval3 = new Interval(8, 10);
		Interval interval4 = new Interval(15, 18);
		intervals.add(interval1);
		intervals.add(interval2);
		intervals.add(interval3);
		intervals.add(interval4);
		List<Interval> merge = new _056_MergeIntervals_write().merge(intervals);
		System.out.println(merge);
	}

	public List<Interval> merge(List<Interval> intervals) {
		if (intervals.size() <= 1) {
			return intervals;
		}
		Collections.sort(intervals, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				if (o1.start > o2.start) {
					return 1;
				}
				if (o1.start < o2.start) {
					return -1;
				}
				return 0;
			}

		});
		List<Interval> res = new ArrayList<>();
		int start = intervals.get(0).start;
		int end = intervals.get(0).end;
		for (Interval in : intervals) {
			if (in.start <= end) {
				end = Math.max(in.end, end);
			} else {
				res.add(new Interval(start, end));
				start = in.start;
				end = in.end;
			}
		}
		res.add(new Interval(start, end));

		return res;
	}
}
