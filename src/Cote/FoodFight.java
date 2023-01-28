package Cote;

public class FoodFight {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();

        for(int i=1; i<food.length; i++){
            sb.append(food[i]==0||food[i]==1 ? "" :(""+i).repeat(food[i]/2));
        }   


        var string = sb.reverse().toString();

        return sb.reverse().append("0").append(string).toString();
    }

}
