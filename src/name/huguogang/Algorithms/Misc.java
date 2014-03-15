package name.huguogang.Algorithms;

/**
 * Miscellaneous small algorithms
 * 
 * @author Guogang Hu
 * 
 */
public class Misc {
    /**
     * Swap two integers without extra storage
     * 
     * @param a
     * @param b
     */
    public static void inPlaceSwap(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    /**
     * Reverse a string in place, with O(1) storage, O(n) time
     */
    public static void reverseString(StringBuffer in) {
        int len = in.length();
        for (int i = 0; i < len / 2; i++) {
            char tmp = in.charAt(i);
            in.setCharAt(i, in.charAt(len - i - 1));
            in.setCharAt(len - i - 1, tmp);
        }
    }

    /**
     * Convert string to integer. 9 ==> 9 -9 ==> -9 9as ==> 9 9.3 ==> 9 0 if
     * illegal format Spec: ignore leading white space ignore content after the
     * non-numeric string
     * 
     * @param in
     * @return
     */
    public static int atoi(String in) {
        if (in == null || in.length() == 0) {
            return 0;
        }

        int ret = 0;
        int i = 0;
        int len = in.length();
        char c = in.charAt(i);

        boolean isNegative = false;
        // skip any leading white space
        while (c == ' ' || c == '\t') {
            ++i;
            if (i >= len)
                return 0;
            c = in.charAt(i);
        }
        if (c == '-') {
            isNegative = true;
            i++;
        } else if (c == '+') {
            i++;
        }

        while (i < len) {
            c = in.charAt(i);

            if (c > '9' || c < '0') {
                break;
            }

            ret = ret * 10 + (c - '0');
            i++;
        }

        if (isNegative) {
            ret = ret * -1;
        }
        return ret;
    }

    /**
     * Brute force algorithm to search substring
     * 
     * @param str
     * @param pattern
     * @return
     */
    public static boolean isSubstring(String str, String pattern) {
        if (pattern == null) {
            return false;
        }
        if (pattern == "") {
            return true;
        }

        int strP, patP;
        boolean match;
        for (strP = 0; strP < str.length(); strP++) {
            match = true;
            for (patP = 0; patP < pattern.length(); patP++) {
                if (str.charAt(strP + patP) != pattern.charAt(patP)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                return true;
            }
        }
        return false;
    }

    /**
     * Given a string, find the logest substring of only two distinct
     * characters. For example, given “aabacccaba”, you would return “accca”
     * 
     * @param in
     * @return
     */
    public static String find2CharSubString(String in) {
        if (in == null || in == "")
            return in;

        int start = 0, lastChange = 0, currentPos = 0;
        int maxLen = 0, maxStart = 0;
        int len = in.length();
        int distinctChars = 0;
        int nCandidates = 0;
        char[] chars = new char[2];

        while (currentPos < len) {
            char c = in.charAt(currentPos);
            boolean isRepeat = false;
            for (int i = 0; i < distinctChars; i++) {
                if (c == chars[i]) {
                    isRepeat = true;
                    break;
                }
            }
            if (!isRepeat) {
                if (distinctChars < 2) {
                    // add distinct char
                    chars[distinctChars] = c;
                    distinctChars++;
                } else {
                    // no longer valid substring
                    nCandidates++;
                    if (currentPos - start > maxLen) {
                        // found new max
                        maxLen = currentPos - start;
                        maxStart = start;
                    }
                    // rewind search to last change
                    start = lastChange;
                    distinctChars = 2;
                    chars[0] = c;
                    chars[1] = in.charAt(lastChange);
                }
            }

            // keep tab on the last char change
            if (currentPos > 0 && c != in.charAt(currentPos - 1)) {
                lastChange = currentPos;
            }
            currentPos++;
        }
        if (nCandidates == 0) {
            // indication, whole string is in
            maxStart = 0;
            maxLen = len;
        }
        return in.substring(maxStart, maxStart + maxLen);
    }

    /**
     * Given two integers, a and b, find the smallest square integer in the
     * range (or return -1, if there is no such square).
     * 
     * @param a
     * @param b
     * @return
     */
    public static int findSquare(int a, int b) {
        // corner cases
        int ab = a * b;
        if (ab == 0) {
            return 0;
        } else if (ab < 0) {
            return 0;
        } else if (a < 0 && b < 0) {
            return -1;
        }
        // a,b both non-negative
        if (a > b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        int sqA = (int) Math.ceil(Math.sqrt(a));
        int sq = sqA * sqA;
        if (sq < b) {
            return sq;
        }
        return -1;
    }
}
