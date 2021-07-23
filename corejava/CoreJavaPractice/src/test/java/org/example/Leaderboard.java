package org.example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Leaderboard {
    List<Integer> ranked = new ArrayList<>(Arrays.asList(100 ,90, 90 ,80, 75 ,60));
    List<Integer> player= new ArrayList<>(Arrays.asList(50 ,65, 77, 90, 102));
    List<Integer> finalList = new ArrayList<>();
    @Test
    public void calc(){
      // Collections.sort(player,Collections.reverseOrder());
        Integer lastNum =0;
        Integer rank=1;
        int k=0;
        int j=0;
        Integer cRank;
        Integer p;
        for(int i=player.size()-1;i>=0;i--){
        p= player.get(i);
        for( j=k; j< ranked.size();j++){
            cRank = ranked.get(j);
            if(! (lastNum.intValue()== cRank.intValue())){

                if(p < cRank){
                    rank++;
                }else{
                    break;
                }
                lastNum = cRank;
            }

        }
        k =j;
        finalList.add(rank);
        lastNum=0;

    }
        Collections.sort(finalList,Collections.reverseOrder());

        System.out.println(finalList);
    }

}
