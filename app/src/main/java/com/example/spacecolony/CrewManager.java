package com.example.spacecolony;
import java.util.*;
public class CrewManager {
    private List<CrewMember> team=new ArrayList<>();
    public void addMember(CrewMember c){team.add(c);}
    public List<CrewMember> getTeam(){return team;}
    public void removeDead(){
        Iterator<CrewMember> it=team.iterator();
        while(it.hasNext()) if(it.next().getHp()<=0) it.remove();
    }
}