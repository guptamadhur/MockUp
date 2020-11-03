package web.app.madhurgupta.Practice.String.Misc;
/*
# Author: Madhur Gupta
# Github: github.com/guptamadhur
# Project: LeetCode Java
# Created on: 25-10-2020 09:32
*/

import java.util.HashMap;
import java.util.Map;

/*
s =1102021222
k =2
 */
public class PerfectSubString {
    public static void main(String[] args) {
        System.out.println(perfectSubstring("1020122", 2));
    }

    public static int perfectSubstring(String s, int k) {
        int len = s.length();
        int rp = 0;
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (rp < len) {
            char st = s.charAt(rp);
            if (!map.containsKey(st)) {
                map.put(st, 1);
            } else {
                map.put(st, map.get(st) + 1);
            }
            boolean flag = true;
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (!(entry.getValue() == k)) {
                    flag = false;
                }
            }
            if (flag) {
                ans += 1;
            }
            rp++;
        }
        return ans;
    }
}
