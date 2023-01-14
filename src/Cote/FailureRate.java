package Cote;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.stream.Collectors;
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

        var maps2 = IntStream.rangeClosed(1,N)
                .boxed()
                .collect(Collectors
                        .toMap(key->key,
                                values ->usersToX(UsersInStage, values, stages.length) == 0
                                        ? 0.0
                                        :(double) UsersInStage[values] / (double) usersToX(UsersInStage, values, stages.length)));



        asdfghjk;

        return maps2.keySet()
                .stream()
                .sorted(Comparator.comparingDouble(maps2::get).reversed())
                .mapToInt(mp->mp)
                .toArray();
    }

    public int usersToX(int[] array, int x, int stagelength){
        return stagelength - IntStream.rangeClosed(1,x-1).map(mp->array[mp]).sum();
    }
}


