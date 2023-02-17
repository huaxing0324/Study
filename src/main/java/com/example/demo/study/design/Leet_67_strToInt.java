package com.example.demo.study.design;

import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Leet_67_strToInt {
    public static void main(String[] args) {
        String s = "(])";
        Deque<Character> stack = new LinkedList<Character>();
        for(int i = 0;i< s.length();i ++){
            char c = s.charAt(i);
            if(c == '(' ||c == '[' ||c == '{' ){
                stack.push(c);
            }else{
                if(stack.size() > 0){
                    char pre = stack.peek();
                    if( ( pre == '(' && c == ')')
                            || ( pre == '[' && c == ']')
                            || ( pre == '{' && c == '}')
                    ){
                        stack.pop();
                    }
                }else{
                    return;
                }
            }
        }

    }
    public static int strToInt(String str) {


        char[] chars = str.trim().toCharArray();
        if(chars.length == 0) return 0;
        int res = 0;
        int limit = Integer.MAX_VALUE/10;
        int limit1 = Integer.MAX_VALUE%10;
        int sign = 1;
        int start = 1;
        if(chars[0] == '-'){
            sign = -1;
        }else if(chars[0] != '+'){
            start = 0;
        }
        for(int j = start;j<chars.length;j++){
            if(chars[j] < '0' || chars[j] > '9'){
                break;
            }
            if(res > limit || res == limit && chars[j] > limit1){
                return sign == 1 ? Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            res = res * 10 + (chars[j] - '0');
        }
        return sign * res;
//        char[] c = str.trim().toCharArray();
//        if(c.length == 0) return 0;
//        int res = 0, bndry = Integer.MAX_VALUE / 10;
//        int limit1 = Integer.MAX_VALUE%10;
//        int i = 1, sign = 1;
//        if(c[0] == '-') sign = -1;
//        else if(c[0] != '+') i = 0;
//        for(int j = i; j < c.length; j++) {
//            if(c[j] < '0' || c[j] > '9') break;
//            if(res > bndry || res == bndry && c[j] > '7') return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
//            res = res * 10 + (c[j] - '0');
//        }
//        return sign * res;
    }
}
