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
        UsersInStage[0] =0;

        IntStream.rangeClosed(1,N).boxed().forEach(fe ->{
            UsersInStage[fe] = (int)Arrays.stream(stages).filter(fl -> fl == fe).count();
        });

        HashMap<Integer, Double> maps = new HashMap<>();

        for(int i=0; i<=N; i++){
            int UsertoN = stages.length - usersToX(UsersInStage, i-1);
            if(UsertoN==0){
                maps.put(i,0.0);
            }
            else maps.put(i, (double)UsersInStage[i]/(double) UsertoN);
        }

        return maps.keySet().stream().sorted(Comparator.comparingDouble(mp->maps.get(mp)).reversed()).mapToInt(mp->mp).toArray();

    }

    public int usersToX(int[] array, int x){
        int users = 0;
        for(int i=1; i<=x; i++){
            users += array[i];
        }
        return users;
    }
}

