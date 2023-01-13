package Cote;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.stream.IntStream;

public class FailureRate {
    // N=5 / Stages = {2,1,2,6,2,4,3,3} / answer = {3,4,2,1,5}
    // N=4 / Stages = {4,4,4,4} / answer = {4,1,2,3}
    // N번 스테이지 실패율 = N번 스테이지 유저수 / 스테이지에 도달한 유저 수
    // └ N번 스테이지 유저 수 / 전체 유저 수 - (N번 이전까지의 유저 수)
    //
    public int[] solution(int N, int[] stages) {
        int[] UsersInStage = new int[N+1];

        IntStream.rangeClosed(1,N).boxed().forEach(fe ->{
            UsersInStage[fe] = (int)Arrays.stream(stages).filter(fl -> fl == fe).count();
        });

        HashMap<Integer, Double> maps = new HashMap<>();

        IntStream.rangeClosed(1,N).boxed().forEach(fe->{
            Double garbage = usersToX(UsersInStage, fe, stages.length) == 0 ? maps.put(fe, 0.0) : maps.put(fe, (double) UsersInStage[fe] / (double) usersToX(UsersInStage, fe, stages.length));
        });

        return maps.keySet().stream().sorted(Comparator.comparingDouble(maps::get).reversed()).mapToInt(mp->mp).toArray();
    }

    public int usersToX(int[] array, int x, int stagelength){
        return stagelength - IntStream.rangeClosed(1,x-1).map(mp->array[mp]).sum();
    }
}

