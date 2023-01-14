package Cote;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Hamberger {
    //{1231}
    //{123112311231} -> 3개
    //{123121231312} -> {2312} -> 2개
    //{2, 1, 1, 2, 3, 1, 2, 3, 1} ->2개
    public int solution(int[] ingredient) {
        String x = Arrays.stream(ingredient).boxed().map(Object::toString).collect(Collectors.joining());
        int ans = 0;
        while(x.contains("1231")){
            ans++;
            x = x.replaceFirst("1231","");
        }

        return ans;
    }
}
