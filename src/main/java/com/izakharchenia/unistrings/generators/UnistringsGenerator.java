package com.izakharchenia.unistrings.generators;

import com.izakharchenia.unistrings.exceptions.ParametersDataException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UnistringsGenerator {

    public Set<String> generate(String str, int min, int max, int quantity) {
        try {
            this.checkIfPossible(str, quantity, min, max);
        } catch (ParametersDataException e) {
            this.errMessage = e.getMessage();
            return this.resultSet;
        }
        this.buildUniqueSet(str, min, max, quantity);
        return this.resultSet;
    }

    public void clearResultSet() {
        resultSet.clear();
    }

    public String getErrMessage() {
        return errMessage;
    }

    //only for using in objects of this class
    //
    private String errMessage;

    private Set<String> resultSet = new HashSet<>();

    private void buildUniqueSet(String str, int min, int max, int quantity) {
        for (int i = min; i <= max; i++)
            this.buildCombinations(str.toCharArray(), str.length(),
                    i, 0, new char[i], 0, this.resultSet, quantity);
    }

    private void checkIfPossible(String str, int quantity, int min, int max) {
        if (min > max) {
            throw new ParametersDataException("Min size of requested strings is bigger then max");
        }
        String ustr = buildUniqueCharsSequence(str);
        if (ustr.length() < max) {
            throw new ParametersDataException("Max size of requested strings " +
                    "is bigger then unique char sequence length");
        }
        int maxuperms = calculatePermutations(ustr, min, max);
        if (maxuperms < quantity) {
            throw new ParametersDataException("Max quantity of permutations of the unique char sequence " +
                    "from requested string < requested quantity");
        }

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

    private int calculatePermutations(String str, int min, int max) {
        int res = 0;
        for (int i = min; i <= max; i++) {
            res+=factorial(str.length())/(factorial(i)*factorial(str.length()-i));
        }

        return res;
    }

    private void buildCombinations(char[] arr, int n, int r,
                                        int index, char[] data, int i,
                                            Set<String> resultset, int quantity) {
        if (index == r) {
            resultset.add(Arrays.toString(data));
            return;
        }
        if (resultset.size()==quantity) return;
        if (i >= n) return;
        data[index] = arr[i];
        buildCombinations(arr, n, r, index + 1,
                data, i + 1, resultset, quantity);
        buildCombinations(arr, n, r, index, data, i + 1, resultset, quantity);
    }
}
