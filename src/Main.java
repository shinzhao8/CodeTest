import Cote.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        hamburger();

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
    public static void hamburger(){

        Hamburger hamburger = new Hamburger();
        int[] array = {2, 1, 1, 2, 3, 1, 2, 3, 1};

        System.out.println(hamburger.solution(array));
    }

    public static void dartGame(){
        DartGame dartGame = new DartGame();
        String str = "1S2S*3T";

        System.out.println(dartGame.solution(str));
    }
    public static void foodFight(){
        FoodFight foodFight = new FoodFight();
        int[] ary = {1,3,7,4};

        System.out.println(foodFight.solution(ary));
    }
}