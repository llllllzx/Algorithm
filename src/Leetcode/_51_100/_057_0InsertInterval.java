package Leetcode._51_100;

import java.util.ArrayList;
import java.util.List;
//Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
//You may assume that the intervals were initially sorted according to their start times.
//Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//Output: [[1,2],[3,10],[12,16]]
//Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

public class _057_0InsertInterval {

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
			return "[start=" + start + ", end=" + end + "]";
		}

	}

	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<>();
		Interval interval1 = new Interval(2, 3);
		Interval interval2 = new Interval(5, 5);
		Interval interval3 = new Interval(6, 6);
		Interval interval4 = new Interval(7, 7);
		Interval interval5 = new Interval(8, 11);
		intervals.add(interval1);
		intervals.add(interval2);
		intervals.add(interval3);
		intervals.add(interval4);
		intervals.add(interval5);
		// Interval newInterval = new Interval(2, 5);
		// Interval newInterval = new Interval(0, 9);
		Interval newInterval = new Interval(6, 13);
		List<Interval> insertRes = new _057_0InsertInterval().insert(intervals, newInterval);
		System.out.println(insertRes);
	}

	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		if (intervals.size() == 0 || intervals == null) {
			intervals.add(newInterval);
			return intervals;
		}
		int location = findLocation(intervals, newInterval);

		intervals.add(location, newInterval);

		System.out.println(intervals);
		int start = intervals.get(0).start;
		int end = intervals.get(0).end;
		List<Interval> res = new ArrayList<>();
		for (Interval in : intervals) {
			if (in.start <= end) {
				end = Math.max(end, in.end);
			} else {
				res.add(new Interval(start, end));
				start = in.start;
				end = in.end;
			}
		}
		res.add(new Interval(start, end));
		return res;
	}

	// 通过二分查找法来寻找带插入位置。
	private int findLocation(List<Interval> intervals, Interval newInterval) {
		int low = 0;
		int high = intervals.size() - 1;
		int middle = 0;
		int key = newInterval.start;
		while (low <= high) {
			middle = (low + high) / 2;
			if (intervals.get(middle).start > key) {
				high = middle - 1;
			} else if (intervals.get(middle).start < key) {
				low = middle + 1;
			} else {
				return middle;
			}
		}
		return low;
	}
}
