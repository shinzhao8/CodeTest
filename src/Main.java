import Cote.FailureRate;
import Cote.Hamberger;
import Cote.SecretMap;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        hamberger();

    }

    public static void failureRate(){

        FailureRate failureRate = new FailureRate();
        int[] stages = {2,1,2,6,2,4,3,3};

        System.out.println(Arrays.toString(failureRate.solution(5, stages)));
    }
    public static void secretMap(){

        SecretMap secretMap = new SecretMap();
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};

        System.out.println(Arrays.toString(secretMap.solution(5, arr1, arr2)));
    }
    public static void hamberger(){

        Hamberger hamberger = new Hamberger();
        int[] array = {2, 1, 1, 2, 3, 1, 2, 3, 1};

        System.out.println(hamberger.solution(array));
    }
}