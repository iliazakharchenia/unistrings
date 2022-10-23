package com.izakharchenia.unistrings.logic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UnistringsGenerator {

    public Set<String> generate(String str, int min, int max, int quan) {
        if (this.checkIfPossible(str, quan, min, max))
            this.buildUniqueSet(str, min, max, quan);

        return this.resultSet;
    }

    public void clearResultSet() {
        resultSet.clear();
    }

    //only for using in objects of this class
    //
    private Set<String> resultSet = new HashSet<>();

    private void buildUniqueSet(String str, int min, int max, int quan) {
        for (int i = min; i <= max; i++)
            this.buildCombinations(str.toCharArray(), str.length(),
                    i, 0, new char[i], 0, this.resultSet, quan);
    }

    private boolean checkIfPossible(String str, int quan, int min, int max) {
        if (min > max) return false; //return exception message
        String ustr = buildUniqueCharsSequence(str);
        if (ustr.length() < max) return false; //return exception message
        int maxuperms = calcPerms(ustr, min, max);
        if (maxuperms < quan) return false; //return exception message

        return true;
    }

    private int factorial(int n) {
        if (n <= 2) return n;

        return n * factorial(n - 1);
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
                                        int index, char[] data, int i,
                                            Set<String> resset, int quan) {
        if (index == r) {
            resset.add(Arrays.toString(data));

            return;
        }

        if (resset.size()==quan) return;

        if (i >= n) return;

        data[index] = arr[i];
        buildCombinations(arr, n, r, index + 1,
                data, i + 1, resset, quan);

        buildCombinations(arr, n, r, index, data, i + 1, resset, quan);
    }
}
