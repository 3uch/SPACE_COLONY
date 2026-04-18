package com.example.spacecolony;

public abstract class CrewMember {

    protected String name;
    protected String role;

    protected int hp;
    protected int maxHp;

    protected int might;
    protected int tech;
    protected int luck;

    protected int level;

    public CrewMember(
            String name,
            String role,
            int hp,
            int might,
            int tech,
            int luck
    ){

        this.name=name;
        this.role=role;

        this.hp=hp;
        this.maxHp=hp;

        this.might=might;
        this.tech=tech;
        this.luck=luck;

        this.level=1;

    }


    public void train(
            String statType
    ){

        if(
                statType.equals(
                        "might"
                )
        ) might++;

        if(
                statType.equals(
                        "tech"
                )
        ) tech++;

        if(
                statType.equals(
                        "luck"
                )
        ) luck++;

    }


    public void takeDamage(
            int dmg
    ){

        hp-=dmg;

        if(
                hp<0
        ){
            hp=0;
        }

    }


    public boolean isAlive(){

        return hp>0;

    }


    public int getHp(){

        return hp;

    }

    public String getName(){
        return name;
    }

    public String getRole(){
        return role;
    }

    public int getMight(){
        return might;
    }

    public int getTech(){
        return tech;
    }

    public int getLuck(){
        return luck;
    }

}