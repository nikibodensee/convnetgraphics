package main.java.Stringhandle;

import java.util.ArrayList;

public class Stringextracter {

    public Stringextracter() {
    }

    public Integer[] findInteger(String a){

        Integer[] res = new Integer[a.length()];
        ArrayList<Character> buffer = new ArrayList<>();
        int b = 0;

        for(int g = 0; g < a.length(); g++){
            if(isDigit(a.charAt(g))) {
                buffer.add(a.charAt(g));
                if(g+1 < a.length() && isDigit(a.charAt(g+1))) {}
                else {
                    res[b] = Integer.parseInt(String.valueOf(getStringRepresentation(buffer)));
                    b++;
                    buffer.clear();
                }
            }
        }

        return res;
    }

    String getStringRepresentation(ArrayList<Character> list)
    {
        StringBuilder builder = new StringBuilder(list.size());
        for(Character ch: list)
        {
            builder.append(ch);
        }
        return builder.toString();
    }

    private boolean isDigit(char ch){

        if(ch >= '0' && ch <= '9') return true;
        else return false;

    }


}
