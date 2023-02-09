package stack;

import java.util.Stack;

/**
 * @author 沈浩
 * @date 2023/2/9 16:02
 */
public class DecodeString {
    //    数字存放在数字栈，字符串存放在字符串栈，遇到右括号时候弹出一个数字栈，字母栈弹到左括号为止。就是逆波兰式那种题。
    public String decodeString(String s) {
        int k = 0;
        StringBuilder res = new StringBuilder();
        Stack<Integer> kstack = new Stack<>();
        Stack<StringBuilder> restack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '[') {
                //碰到括号，记录K和当前res，归零。
                kstack.push(k);
                restack.push(res);
                k = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                //出最近的一个左括号入的k,当前res进行计算不入栈
                int curk = kstack.pop();
                StringBuilder temp = new StringBuilder();
                for (int i = 0; i < curk; i++) {
                    temp.append(res);
                }
                //与括号外合并
                res = restack.pop().append(temp);
//c >= '0' && c <= '9'
            } else if (Character.isDigit(c)) {
                k = c - '0' + k * 10;
                //如果k是多位数需要x10
            } else {
                res.append(c);
                //如果是字母则缓慢添加
            }
        }
        return res.toString();


    }

    public String decodeString2(String s) {
        return dfs(s, 0)[0];
    }

    private String[] dfs(String s, int i) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        while (i < s.length()) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9')
                multi = multi * 10 + Integer.parseInt(String.valueOf(s.charAt(i)));
            else if (s.charAt(i) == '[') {
                String[] tmp = dfs(s, i + 1);
                i = Integer.parseInt(tmp[0]);
                while (multi > 0) {
                    res.append(tmp[1]);
                    multi--;
                }
            } else if (s.charAt(i) == ']')
                return new String[]{String.valueOf(i), res.toString()};
            else
                res.append(String.valueOf(s.charAt(i)));
            i++;
        }
        return new String[]{res.toString()};
    }

}

