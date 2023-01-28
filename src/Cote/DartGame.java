package Cote;

import java.util.Stack;

public class DartGame {

    public int solution(String dartResult) {
        int answer = 0;
        var stack = new Stack<String>();
        while (dartResult.length()>0){
            if (dartResult.startsWith("*") || dartResult.startsWith("#")) {
                stack.push(dartResult.substring(0, 1));
                dartResult = dartResult.substring(1);
                if (dartResult.length() == 0) break;
                if(dartResult.startsWith("10")){
                    stack.push(stringToInt(dartResult.substring(0, 3)));
                    dartResult = dartResult.substring(3);
                }else{
                    stack.push(stringToInt(dartResult.substring(0, 2)));
                    dartResult = dartResult.substring(2);
                }

            } else {
                if(dartResult.startsWith("10")){
                    stack.push(stringToInt(dartResult.substring(0, 3)));
                    dartResult = dartResult.substring(3);
                }else{
                    stack.push(stringToInt(dartResult.substring(0, 2)));
                    dartResult = dartResult.substring(2);
                }
            }
        }
        while (!stack.empty()){
            if(stack.peek().equals("*")){
                stack.pop();
                int lastItem = Integer.parseInt(stack.pop())*2;
                if(stack.empty()){
                    stack.push(String.valueOf(lastItem));
                    continue;
                }
                if(stack.peek().equals("*") || stack.peek().equals("#")){
                    String str = stack.pop();
                    stack.push(String.valueOf(Integer.parseInt(stack.pop())*2));
                    stack.push(str);
                    stack.push(String.valueOf(lastItem));
                }
                else {
                    stack.push(String.valueOf(Integer.parseInt(stack.pop())*2));
                    stack.push(String.valueOf(lastItem));
                }
            }
            else if(stack.peek().equals("#")){
                stack.pop();
                stack.push(String.valueOf(Integer.parseInt(stack.pop())*-1));
            }
            else {
                answer += Integer.parseInt(stack.pop());
            }
        }

        return answer;
    }

    public String stringToInt(String str){
        int i = Integer.parseInt(str.substring(0,str.length() - 1));
        return str.endsWith("T") ? String.valueOf((int)Math.pow(i,3)) :
                str.endsWith("D") ? String.valueOf((int)Math.pow(i,2)) :
                        String.valueOf(i);
    }

}
