package com.leetcode.two;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * leetcode 20题，有效的括号
 * 思路：
 * 栈后入先出特点，LinkedList push(0) pop ()  入出
 * 结合HashMap减少判断
 */
public class TwentyOne {

    public static boolean idValid(String s) {
        char[] chars = s.toCharArray();

        if (chars.length % 2 == 1) {
            return false;
        }

        Map<Character, Character> characterMap = new HashMap<Character, Character>() {
            {
                put(']', '[');
                put('}', '{');
                put(')', '(');
            }
        };

        LinkedList stalk = new LinkedList();
        for (int i = 0; i < chars.length; i++) {
            if (characterMap.containsKey(chars[i])) {
                // 空栈 || 栈最上面一个 和 反括号对应的正括号对应，不相等就是错误的
                if (stalk.isEmpty() || stalk.peek() != characterMap.get(chars[i])) {
                    return false;
                }
                //相同出栈，
                stalk.pop();

            } else {
                //正向括号入栈。最后入的在第一个。
                stalk.push(chars[i]);
            }
        }
        return stalk.isEmpty();
    }


    public static void main(String[] args) {
        boolean b = idValid("{([])}");
        boolean b1 = idValid("{([)]}");
        boolean b2 = idValid("{{()}}");

        System.out.println(b);
        System.out.println(b1);
        System.out.println(b2);
    }
}
