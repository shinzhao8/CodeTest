package Cote;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Couples_Cipher {

    static final String[] Alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u"
            , "v", "w", "x", "y", "z"};
    public String solution(String s, String skip, int index) {
        // a b c d e f g h i j k l m n o p q r s t u v w x y z
        //s = aukks , skip = wbqd , index = 5
        // a-> b c d e f -> -b- -d- c e f g h -> h
        // u -> v w x y z-> -w- v x y z a -> a

        var myAlphabet = Arrays.stream(Alphabet).filter(fl->!eachString(skip).contains(fl)).collect(Collectors.toList());

        return s.chars().mapToObj(Character::toString).map(mp->pushIndex(myAlphabet.indexOf(mp) + index, myAlphabet)).collect(Collectors.joining());
    }

    public ArrayList<String> eachString(String skip){
        return (ArrayList<String>) skip.chars().mapToObj(Character::toString).collect(Collectors.toList());
    }
    public String pushIndex(int listIndex, List<String> myAlphabet){

        while(listIndex>= myAlphabet.size()){
            listIndex -= myAlphabet.size();
        }
        return myAlphabet.get(listIndex);
    }

}
