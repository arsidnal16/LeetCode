package arraysAndString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * 
 * Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].


 * 
 */

public class MergeIntervals {

	public class Interval {
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

	}

	public List<Interval> merge(List<Interval> intervals) {
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval obj0, Interval obj1) {
				return obj0.start - obj1.start;
			}
		});

		List<Interval> result = new ArrayList<>();
		Interval prev = null;
		for (Interval inter : intervals) {
			if (prev == null || inter.start > prev.end) {
				result.add(inter);
				prev = inter;
			} else if (inter.end > prev.end) {
				// Modify the element already in list
				prev.end = inter.end;
			}
		}
		return result;
	}

	/*
	 * Given a set of non-overlapping intervals, insert a new interval into the
	 * intervals (merge if necessary).
	 * 
	 * You may assume that the intervals were initially sorted according to their
	 * start times.
	 * 
	 * Example 1: Given intervals [1,3],[6,9], insert and merge [2,5] in as
	 * [1,5],[6,9].
	 * 
	 * Example 2: Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in
	 * as [1,2],[3,10],[12,16].
	 * 
	 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
	 * 
	 */

	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		int i = 0;
		while (i < intervals.size() && intervals.get(i).end < newInterval.start)
			i++;
		while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
			newInterval = new Interval(Math.min(intervals.get(i).start, newInterval.start),
					Math.max(intervals.get(i).end, newInterval.end));
			intervals.remove(i);
		}
		intervals.add(i, newInterval);
		return intervals;
	}

}
