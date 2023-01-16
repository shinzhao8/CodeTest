package Cote;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SecretMap {
    //arr1 = {9, 20, 28, 18, 11} , arr2 = {30, 1, 21, 17, 28}
    //arr1 = {01001, 10100, 11100, 10010, 01011} , arr2 = {11110, 00001, 10101, 10001, 11100}
    // □■□□■       ■■■■□       ■■■■■
    // ■□■□□       □□□□■       ■□■□■
    // ■■■□□   +   ■□■□■   =   ■■■□■
    // ■□□■□       ■□□□■       ■□□■■
    // □■□■■       ■■■□□       ■■■■■
    public String[] solution(int n, int[] arr1, int[] arr2) {

        int[] newBinaryArray = IntStream
                .range(0,n)
                .map(fl-> arr1[fl]|arr2[fl])
                .toArray();

        //이진수 array로 변환
        return Arrays
                .stream(newBinaryArray)
                .mapToObj(mp->toBlankOrSharp(nthString(Integer.toBinaryString(mp),n)))
                .toArray(String[]::new);

    }

    public String nthString(String str, int n){
        if(str.length() == n) return str;
        return "0".repeat(n-str.length()) + str;
    }

    public String toBlankOrSharp(String str){
        return str.replace("1", "#").replace("0", " ");
    }

}
