package Cote;

import java.util.Stack;
public class Hamburger {
    //{1231}
    //{123112311231} -> 3개
    //{123121231312} -> {2312} -> 2개
    //{2, 1, 1, 2, 3, 1, 2, 3, 1} ->2개
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (var ingredients: ingredient) {
            stack.push(ingredients);

            if(stack.size()>3){
                int fourth = stack.pop();
                int third = stack.pop();
                int second = stack.pop();
                int first = stack.pop();

                if(first==1 && second==2 && third==3 && fourth==1){
                    answer++;
                }else {
                    stack.push(first);
                    stack.push(second);
                    stack.push(third);
                    stack.push(fourth);
                }
            }
        }
        return answer;

    }
}
