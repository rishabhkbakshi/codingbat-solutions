

public class array3 {

	// Consider the leftmost and rightmost appearances of some value in an
	// array.
	// We'll say that the "span" is the number of elements between the two
	// inclusive. A single value has a span of 1. Returns the largest span found
	// in the given array. (Efficiency is not a priority.)
	//
	//
	// maxSpan([1, 2, 1, 1, 3]) => 4
	// maxSpan([1, 4, 2, 1, 4, 1, 4]) => 6
	// maxSpan([1, 4, 2, 1, 4, 4, 4]) => 6
	public int maxSpan(int[] nums) {
		int span = 0;
		int temp = 0;

		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (nums[i] == nums[j]) {
					temp = j - i + 1;
					if (temp > span) {
						span = temp;
					}
				}
			}
		}
		return span;
	}

	// Return an array that contains exactly the same numbers as the given
	// array, but rearranged so that every 3 is immediately followed by a 4. Do
	// not move the 3's, but every other number may move. The array contains the
	// same number of 3's and 4's, every 3 has a number after it that is not a
	// 3, and a 3 appears in the array before any 4.
	//
	//
	// fix34([1, 3, 1, 4]) => [1, 3, 4, 1]
	// fix34([1, 3, 1, 4, 4, 3, 1]) => [1, 3, 4, 1, 1, 3, 4]
	// fix34([3, 2, 2, 4]) => [3, 4, 2, 2]
	public int[] fix34(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (nums[i] == 4 && nums[j] == 3) {
					int temp = nums[j + 1];
					nums[j + 1] = nums[i];
					nums[i] = temp;
				}
			}
		}
		return nums;
	}

	// (This is a slightly harder version of the fix34 problem.) Return an array
	// that contains exactly the same numbers as the given array, but rearranged
	// so that every 4 is immediately followed by a 5. Do not move the 4's, but
	// every other number may move. The array contains the same number of 4's
	// and 5's, and every 4 has a number after it that is not a 4. In this
	// version, 5's may appear anywhere in the original array.
	//
	//
	// fix45([5, 4, 9, 4, 9, 5]) => [9, 4, 5, 4, 5, 9]
	// fix45([1, 4, 1, 5]) => [1, 4, 5, 1]
	// fix45([1, 4, 1, 5, 5, 4, 1]) => [1, 4, 5, 1, 1, 4, 5]
	public int[] fix45(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 4) {
				for (int j = 0; j < nums.length; j++) {
					if (nums[j] == 5) {
						if ((j > 0 && nums[j - 1] != 4) || (j == 0)) {
							nums[j] = nums[i + 1];
							nums[i + 1] = 5;
						}
					}
				}
			}
		}
		return nums;
	}

	// Given a non-empty array, return true if there is a place to split the
	// array so that the sum of the numbers on one side is equal to the sum of
	// the numbers on the other side.
	//
	//
	// canBalance([1, 1, 1, 2, 1]) => true
	// canBalance([2, 1, 1, 2, 1]) => false
	// canBalance([10, 10]) => true
	public boolean canBalance(int[] nums) {
		int fir = 0;
		for (int i = 0; i < nums.length; i++) {
			fir = fir + nums[i];
			int sec = 0;
			for (int j = nums.length - 1; j > i; j--) {
				sec = sec + nums[j];
			}
			if (sec == fir) {
				return true;
			}
		}
		return false;
	}

	// Given two arrays of ints sorted in increasing order, outer and inner,
	// return true if all of the numbers in inner appear in outer. The best
	// solution makes only a single "linear" pass of both arrays, taking
	// advantage of the fact that both arrays are already in sorted order.
	//
	//
	// linearIn([1, 2, 4, 6], [2, 4]) => true
	// linearIn([1, 2, 4, 6], [2, 3, 4]) => false
	// linearIn([1, 2, 4, 4, 6], [2, 4]) => true
	public boolean linearIn(int[] outer, int[] inner) {
		int count = 0;
		for (int i = 0; i < outer.length; i++) {
			for (int j = count; j < inner.length; j++) {
				if (outer[i] == inner[j]) {
					count++;
					j++;
				}
			}
		}
		return (count == inner.length);
	}

	// Given n>=0, create an array length n*n with the following pattern, shown
	// here for n=3 : {0, 0, 1, 0, 2, 1, 3, 2, 1} (spaces added to show the 3
	// groups).
	//
	//
	// squareUp(3) => [0, 0, 1, 0, 2, 1, 3, 2, 1]
	// squareUp(2) => [0, 1, 2, 1]
	// squareUp(4) => [0, 0, 0, 1, 0, 0, 2, 1, 0, 3, 2, 1, 4, 3, 2, 1]
	public int[] squareUp(int n) {
		int[] arr = new int[n * n];

		if (n == 0) {
			return arr;
		}

		for (int i = n - 1; i < arr.length; i += 4) {
			int temp = i - i / n;
			for (int j = i; j >= temp; j--) {
				arr[j] = i - j + 1;
			}
		}

		return arr;
	}

	// Given n>=0, create an array with the pattern {1, 1, 2, 1, 2, 3, ... 1, 2,
	// 3 .. n} (spaces added to show the grouping). Note that the length of the
	// array will be 1 + 2 + 3 ... + n, which is known to sum to exactly n*(n +
	// 1)/2.
	//
	//
	// seriesUp(3) => [1, 1, 2, 1, 2, 3]
	// seriesUp(4) => [1, 1, 2, 1, 2, 3, 1, 2, 3, 4]
	// seriesUp(2) => [1, 1, 2]
	public int[] seriesUp(int n) {
		int[] result = new int[n * (n + 1) / 2];
		int count = 0;
		for (int i = 0; i < result.length; i += count) {
			int iCount = count;
			for (int j = i; j <= i + count; j++) {
				result[j] = count + 1 - iCount;
				iCount--;
			}
			count++;
		}
		return result;
	}

	// We'll say that a "mirror" section in an array is a group of contiguous
	// elements such that somewhere in the array, the same group appears in
	// reverse order. For example, the largest mirror section in {1, 2, 3, 8, 9,
	// 3, 2, 1} is length 3 (the {1, 2, 3} part). Return the size of the largest
	// mirror section found in the given array.
	//
	//
	// maxMirror([1, 2, 3, 8, 9, 3, 2, 1]) => 3
	// maxMirror([1, 2, 1, 4]) => 3
	// maxMirror([7, 1, 2, 9, 7, 2, 1]) => 2
	public int maxMirror(int[] nums) {
		int count = 0;
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			count = 0;
			for (int j = nums.length - 1; j >= 0; j--) {
				if (i + count < nums.length) {
					if (nums[i + count] == nums[j]) {
						count++;
					} else {
						if (count > 0) {
							max = count > max ? count : max;
							count = 0;
						}
					}
				}
			}
			max = count > max ? count : max;
		}
		return max;
	}

	// Say that a "clump" in an array is a series of 2 or more adjacent elements
	// of the same value. Return the number of clumps in the given array.
	//
	//
	// countClumps([1, 2, 2, 3, 4, 4]) => 2
	// countClumps([1, 1, 2, 1, 1]) => 2
	// countClumps([1, 1, 1, 1, 1]) => 1
	public int countClumps(int[] nums) {
		boolean match = false;
		int count = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == nums[i + 1]) {
				if (match == false) {
					match = true;
					count++;
				}
			} else if (nums[i] != nums[i + 1]) {
				match = false;
			}
		}
		return count;
	}
}
