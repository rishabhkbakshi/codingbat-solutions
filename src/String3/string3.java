package String3;

public class string3 {

	// Given a string, count the number of words ending in 'y' or 'z' -- so the
	// 'y' in "heavy" and the 'z' in "fez" count, but not the 'y' in "yellow"
	// (not case sensitive). We'll say that a y or z is at the end of a word if
	// there is not an alphabetic letter immediately following it. (Note:
	// Character.isLetter(char) tests if a char is an alphabetic letter.)
	//
	//
	// countYZ("fez day") => 2
	// countYZ("day fez") => 2
	// countYZ("day fyyyz") => 2
	public int countYZ(String str) {
		int count = 0;
		str = str.toLowerCase();
		for (int i = 1; i < str.length(); i++) {
			if (!Character.isLetter(str.charAt(i))) {
				if (str.charAt(i - 1) == 'y' || str.charAt(i - 1) == 'z') {
					count++;
				}
			}
		}
		if (str.charAt(str.length() - 1) == 'y' || str.charAt(str.length() - 1) == 'z') {
			count++;
		}
		return count;
	}

	// Given two strings, base and remove, return a version of the base string
	// where all instances of the remove string have been removed (not case
	// sensitive). You may assume that the remove string is length 1 or more.
	// Remove only non-overlapping instances, so with "xxx" removing "xx" leaves
	// "x".
	//
	//
	// withoutString("Hello there", "llo") => "He there"
	// withoutString("Hello there", "e") => "Hllo thr"
	// withoutString("Hello there", "x") => "Hello there"
	public String withoutString(String base, String remove) {
		int baseLen = base.length();
		int removelen = remove.length();
		String lowbase = base.toLowerCase();
		String lowrem = remove.toLowerCase();
		String result = "";
		for (int i = 0; i <= baseLen; i++) {
			if (i <= baseLen - removelen) {
				String temp1 = lowbase.substring(i, i + removelen);
				if (!temp1.equals(lowrem)) {
					result = result + base.substring(i, i + 1);
				} else {
					i = i + removelen - 1;
				}
			} else {
				String temp2 = lowbase.substring(i, i + 1);
				if (!temp2.equals(lowrem)) {
					result = result + base.substring(i, i + 1);
				}
			}
		}
		return result;
	}

	// Given a string, return true if the number of appearances of "is" anywhere
	// in the string is equal to the number of appearances of "not" anywhere in
	// the string (case sensitive).
	//
	//
	// equalIsNot("This is not") => false
	// equalIsNot("This is notnot") => true
	// equalIsNot("noisxxnotyynotxisi") => true
	public boolean equalIsNot(String str) {
		int count = 0;
		int count2 = 0;
		for (int i = 0; i < str.length(); i++) {
			if (i < str.length() - 1) {
				if (str.charAt(i) == 'i' && str.charAt(i + 1) == 's') {
					count++;
				}
			}
			if (i < str.length() - 2) {
				if (str.charAt(i) == 'n' && str.charAt(i + 1) == 'o' && str.charAt(i + 2) == 't') {
					count2++;
				}
			}
		}
		return count == count2;
	}

	// We'll say that a lowercase 'g' in a string is "happy" if there is another
	// 'g' immediately to its left or right. Return true if all the g's in the
	// given string are happy.
	//
	//
	// gHappy("xxggxx") => true
	// gHappy("xxgxx") => false
	// gHappy("xxggyygxx") => false
	public boolean gHappy(String str) {
		boolean result = false;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == 'g') {
				if (i < str.length() - 1) {
					if (str.charAt(i) == 'g' && str.charAt(i + 1) == 'g') {
						result = true;
					}
				}
				if (str.charAt(i) == 'g' && str.charAt(i - 1) == 'g') {
					result = true;
				} else {
					result = false;
				}
			}
		}
		return str.length() == 0 ? true : result;
	}

	// We'll say that a "triple" in a string is a char appearing three times in
	// a row. Return the number of triples in the given string. The triples may
	// overlap.
	//
	//
	// countTriple("abcXXXabc") => 1
	// countTriple("xxxabyyyycd") => 3
	// countTriple("a") => 0
	public int countTriple(String str) {
		int count = 0;
		for (int i = 0; i < str.length() - 2; i++) {
			if (str.substring(i, i + 1).equals(str.substring(i + 1, i + 2))
					&& str.substring(i + 1, i + 2).equals(str.substring(i + 2, i + 3))) {
				count++;
			}
		}
		return count;
	}

	// Given a string, return the sum of the digits 0-9 that appear in the
	// string, ignoring all other characters. Return 0 if there are no digits in
	// the string. (Note: Character.isDigit(char) tests if a char is one of the
	// chars '0', '1', .. '9'. Integer.parseInt(string) converts a string to an
	// int.)
	//
	//
	// sumDigits("aa1bc2d3") => 6
	// sumDigits("aa11b33") => 8
	// sumDigits("Chocolate") => 0
	public int sumDigits(String str) {
		int result = 0;
		for (int i = 0; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i))) {
				// result = result + Integer.parseInt(str.charAt(i)+"");
				result = result + Integer.parseInt(str.substring(i, i + 1));
			}
		}
		return result;
	}

	// Given a string, return the longest substring that appears at both the
	// beginning and end of the string without overlapping. For example,
	// sameEnds("abXab") is "ab".
	//
	//
	// sameEnds("abXYab") => "ab"
	// sameEnds("xx") => "x"
	// sameEnds("xxx") => "x"
	public String sameEnds(String string) {
		int len = string.length();
		String result = "";
		String temp = "";

		for (int i = 0; i <= len; i++) {
			temp = temp + string.charAt(i);
			if (i < len / 2 && temp.equals(string.substring(len - temp.length(), len))) {
				result = temp;
			}
		}
		return result;
	}

	// Given a string, look for a mirror image (backwards) string at both the
	// beginning and end of the given string. In other words, zero or more
	// characters at the very begining of the given string, and at the very end
	// of the string in reverse order (possibly overlapping). For example, the
	// string "abXYZba" has the mirror end "ab".
	//
	//
	// mirrorEnds("abXYZba") => "ab"
	// mirrorEnds("abca") => "a"
	// mirrorEnds("aba") => "aba"
	public String mirrorEnds(String string) {
		int len = string.length();
		String result = "";
		String temp1 = "";
		String temp2 = "";

		for (int i = 0; i <= len; i++) {
			temp1 += string.substring(i, i + 1);
			temp2 = "";
			for (int j = temp1.length() - 1; j >= 0; j--) {
				temp2 += temp1.substring(j, j + 1);
				if (temp2.equals(string.substring(len - i - 1, len))) {
					result = temp1;
				}
			}
		}
		return result;
	}

	// Given a string, return the length of the largest "block" in the string. A
	// block is a run of adjacent chars that are the same.
	//
	//
	// maxBlock("hoopla") => 2
	// maxBlock("abbCCCddBBBxx") => 3
	// maxBlock("") => 0
	public int maxBlock(String str) {
		int count = 0;
		int tempCount = 1;

		for (int i = 0; i <= str.length(); i++) {
			if (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
				tempCount++;
			} else {
				tempCount = 1;
			}

			if (tempCount > count) {
				count = tempCount;
			}
		}
		return str.length() == 0 ? 0 : count;
	}

	// Given a string, return the sum of the numbers appearing in the string,
	// ignoring all other characters. A number is a series of 1 or more digit
	// chars in a row. (Note: Character.isDigit(char) tests if a char is one of
	// the chars '0', '1', .. '9'. Integer.parseInt(string) converts a string to
	// an int.)
	//
	//
	// sumNumbers("abc123xyz") => 123
	// sumNumbers("aa11b33") => 44
	// sumNumbers("7 11") => 18
	public int sumNumbers(String str) {
		int result = 0;
		String temp = "";
		for (int i = 0; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i))) {
				temp = temp + str.charAt(i);
			} else {
				result = result + Integer.parseInt(temp == "" ? "0" : temp);
				temp = "";
			}
		}
		result = result + Integer.parseInt(temp == "" ? "0" : temp);
		return result;
	}

	// Given a string, return a string where every appearance of the lowercase
	// word "is" has been replaced with "is not". The word "is" should not be
	// immediately preceeded or followed by a letter -- so for example the "is"
	// in "this" does not count. (Note: Character.isLetter(char) tests if a char
	// is a letter.)
	//
	//
	// notReplace("is test") => "is not test"
	// notReplace("is-is") => "is not-is not"
	// notReplace("This is right") => "This is not right"
	public String notReplace(String str) {
		String result = "";
		str = " " + str + "  ";
		for (int i = 0; i < str.length() - 2; i++) {
			if (str.substring(i, i + 2).equals("is") && !Character.isLetter(str.charAt(i - 1))
					&& !Character.isLetter(str.charAt(i + 2))) {
				result = result + "is not";
				i = i + 1;
			} else {
				result = result + str.charAt(i);
			}
		}
		return result.substring(1, result.length() - 1);
	}
}
