package com.example.spacecolony;
import java.util.*;
public class CombatEngine {
    public static boolean lastVictory;
    public static int[] pendingDamage;
    public static String calculateCombat(List<CrewMember> team,Enemy enemy,int floor){
        double might=0,tech=0,luck=0;
        for(CrewMember c:team){might+=c.getMight(); tech+=c.getTech(); luck+=c.getLuck();}
        luck/=team.size();
        boolean pass=(might>=enemy.getDifficulty() && tech>=enemy.getTechNeed());
        if(pass){lastVictory=true; pendingDamage=new int[team.size()];
            for(int i=0;i<team.size();i++) pendingDamage[i]=(int)Math.max(2,floor*2 + (i%2));
            return "Victory (costly attrition)";
        }
        if(Math.random()<luck*0.015){lastVictory=true; pendingDamage=new int[team.size()]; for(int i=0;i<team.size();i++) pendingDamage[i]=floor; return "Lucky Victory (rare)";}
        lastVictory=false;
        double teamScore=might*0.55+tech*0.45;
        double diff=Math.max(2,enemy.getDifficulty()-teamScore+2);
        double mult=(floor==1?1.6:(floor==2?2.1:2.8));
        int base=(int)Math.ceil(diff*mult);
        pendingDamage=new int[team.size()];
        Random r=new Random();
        for(int i=0;i<team.size();i++){
            CrewMember c=team.get(i);
            int mitig=(c.getMight()/7)+(c.getTech()/10);
            int dmg=Math.max(2, base + r.nextInt(6)-mitig);
            pendingDamage[i]=dmg;
        }
        return "Defeat. Heavy damage incoming.";
    }
}