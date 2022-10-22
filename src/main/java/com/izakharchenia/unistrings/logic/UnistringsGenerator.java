package com.izakharchenia.unistrings.logic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UnistringsGenerator {
    public static void main(String[] args) {
        UnistringsGenerator generator = new UnistringsGenerator();
        System.out.println(generator.calcPerms("qwrer", 1, 2));
        Set<String> resset = new HashSet<>();
        for (int i = 1; i <= 2; i++) {
            generator.buildCombinations("qwer".toCharArray(),"qwer".length(),
                    i, 0, new char[i], 0, resset);
        }
        System.out.println(resset);
        System.out.println(generator.checkIfPossible("qwer", 5, 1, 2));
    }

    public boolean isReady() {
        return isSetReady;
    }

    //only for using in objects of this class
    //
    private Set<String> resultSet = new HashSet<>();

    private boolean checkIfPossible(String str, int quan, int min, int max) {
        if (min > max) return false; //return exception message
        String ustr = buildUniqueCharsSequence(str);
        if (ustr.length() < max) return false; //return exception message
        int maxuperms = calcPerms(ustr, min, max);
        if (maxuperms < quan) return false; //return exception message

        return true;
    }

    private boolean isSetReady = false;

    private int factorial(int n) {
        if (n <= 2) return n;

        return n * factorial(n - 1);
    }

    private int countChar(char ch, String str) {
        int count = 0;
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            if (aChar == ch) count++;
        }

        return count;
    }

    private String buildUniqueCharsSequence(String str) {
        HashSet<Character> charset = new HashSet<>();
        char[] carr = str.toCharArray();
        for (char c : carr) charset.add(c);
        StringBuilder sb = new StringBuilder();
        for (char c : charset) sb.append(c);

        return sb.toString();
    }

    private int calcPerms(String str, int min, int max) {
        int res = 0;
        for (int i = min; i <= max; i++) {
            res+=factorial(str.length())/(factorial(i)*factorial(str.length()-i));
        }

        return res;
    }

    private void buildCombinations(char[] arr, int n, int r,
                                        int index, char[] data, int i, Set<String> resset) {
        if (index == r) {
            resset.add(Arrays.toString(data));

            return;
        }

        if (i >= n) return;

        data[index] = arr[i];
        buildCombinations(arr, n, r, index + 1,
                data, i + 1, resset);

        buildCombinations(arr, n, r, index, data, i + 1, resset);
    }

    private void buildPermuts(String str, String ans, Set<String> result) {
        if (str.length() == 0) {
            result.add(ans);

            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String ros = str.substring(0, i) +
                    str.substring(i + 1);
            buildPermuts(ros, ans + ch, result);
        }
    }
}
