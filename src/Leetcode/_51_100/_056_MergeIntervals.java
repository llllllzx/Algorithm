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
public class _056_MergeIntervals {

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
		List<Interval> merge = new _056_MergeIntervals().merge(intervals);
		System.out.println(merge);
	}

	public List<Interval> merge(List<Interval> intervals) {
		// 如果<=1直接返回。
		if (intervals.size() <= 1) {
			return intervals;
		}
		// 将intervals中的元素按照start属性从小到大排序。
		Collections.sort(intervals, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				// JDK 8中,大于、小于、等于 需要返回不同的值。否则会报运行时错误。
				if (o1.start > o2.start) {
					return 1;
				}
				if (o1.start < o2.start) {
					return -1;
				}
				return 0;

			}

		});
		// System.out.println(intervals);
		List<Interval> res = new ArrayList<>();
		int start = intervals.get(0).start;
		int end = intervals.get(0).end;
		for (Interval interval : intervals) {
			// 如果元素的star属性<=已经存在的end属性，就更行end属性的值。
			if (interval.start <= end) {
				end = Math.max(end, interval.end);
			} else {
				// 否则将start与end这一Interval存到结果集中。
				// 并重新对start和end进行赋值。
				res.add(new Interval(start, end));
				start = interval.start;
				end = interval.end;
			}
		}
		// 添加最后一个。
		res.add(new Interval(start, end));
		return res;
	}
}
