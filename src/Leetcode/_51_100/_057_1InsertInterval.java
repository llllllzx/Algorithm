package Leetcode._51_100;

import java.util.ArrayList;
import java.util.List;
//Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
//You may assume that the intervals were initially sorted according to their start times.
//Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//Output: [[1,2],[3,10],[12,16]]
//Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

public class _057_1InsertInterval {

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
		Interval interval1 = new Interval(1, 5);
		Interval interval2 = new Interval(6, 8);
		intervals.add(interval1);
		intervals.add(interval2);
		// Interval newInterval = new Interval(2, 5);
		Interval newInterval = new Interval(0, 9);
		List<Interval> insertRes = new _057_1InsertInterval().insert(intervals, newInterval);
		System.out.println(insertRes);
	}

	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		if (intervals.size() == 0 || intervals == null) {
			intervals.add(newInterval);
			return intervals;
		}

		for (int i = 0; i < intervals.size(); i++) {
			if (newInterval.start <= intervals.get(0).start) {
				intervals.add(0,newInterval);
				break;
			}
			if (i != intervals.size() - 1) {
				if (newInterval.start >= intervals.get(i).start) {
					if (newInterval.start <= intervals.get(i + 1).start) {
						intervals.add(i + 1, newInterval);
						break;
					}
				}
			} else {
				if (newInterval.start >= intervals.get(i).start) {
					intervals.add(newInterval);
					break;
				} else {
					intervals.add(i, newInterval);
					break;
				}
			}
		}

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
}
