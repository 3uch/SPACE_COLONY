package com.example.spacecolony;
public class Enemy {
    private String type; private double difficulty; private double techNeed;
    public Enemy(String t,double d,double tn){type=t;difficulty=d;techNeed=tn;}
    public String getType(){return type;}
    public double getDifficulty(){return difficulty;}
    public double getTechNeed(){return techNeed;}
    public static Enemy generate(int floor, boolean boss){
        if(boss){
            if(floor==1) return new Enemy("Floor1 Boss",14,10);
            if(floor==2) return new Enemy("Floor2 Boss",20,15);
            return new Enemy("Final Boss",28,21);
        }
        int r=(int)(Math.random()*4);
        if(floor==1){
            if(r==0) return new Enemy("Pirate Raider",8,6);
            if(r==1) return new Enemy("System Virus",7,8);
            if(r==2) return new Enemy("Asteroid Storm",8,7);
            return new Enemy("Alien Drone",8,6);
        }
        if(floor==2){
            if(r==0) return new Enemy("Pirate Raider+",12,10);
            if(r==1) return new Enemy("System Virus+",11,12);
            if(r==2) return new Enemy("Asteroid Storm+",12,11);
            return new Enemy("Alien Hunter",12,10);
        }
        if(r==0) return new Enemy("War Cruiser",18,16);
        if(r==1) return new Enemy("Omega Virus",17,18);
        if(r==2) return new Enemy("Meteor Swarm",18,17);
        return new Enemy("Void Hunter",18,16);
    }
}