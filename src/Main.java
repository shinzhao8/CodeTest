import Cote.FailureRate;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        FailureRate failureRate = new FailureRate();
        int[] stages = {2,1,2,6,2,4,3,3};

        System.out.println(Arrays.toString(failureRate.solution(5, stages)));
    }
}