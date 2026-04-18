package com.example.spacecolony;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BattleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle b){

        super.onCreate(b);

        setContentView(
                R.layout.activity_battle
        );


        TextView t=
                findViewById(
                        R.id.battleText
                );

        Button statusBtn=
                findViewById(
                        R.id.btnStatus
                );

        Button nextBtn=
                findViewById(
                        R.id.btnNext
                );



        boolean boss=
                (
                        MainActivity
                                .phaseInFloor==4
                );


        Enemy enemy=

                Enemy.generate(

                        MainActivity
                                .floorLevel,

                        boss

                );



        String res=

                CombatEngine
                        .calculateCombat(

                                MainActivity
                                        .crewManager
                                        .getTeam(),

                                enemy,

                                MainActivity
                                        .floorLevel

                        );



        String info=

                "Floor "
                        +MainActivity.floorLevel

                        +"\n"

                        +"Phase "
                        +MainActivity.phaseInFloor

                        +"\n";


        for(
                CrewMember c:
                MainActivity
                        .crewManager
                        .getTeam()
        ){

            info+=
                    c.getRole()
                            +" HP:"
                            +c.getHp()
                            +"\n";

        }



        t.setText(
                info
                        +"\nEnemy: "
                        +enemy.getType()
                        +"\n"
                        +res
        );



        for(
                int i=0;

                i<
                        MainActivity
                                .crewManager
                                .getTeam()
                                .size()

                        &&

                        i<
                                CombatEngine
                                        .pendingDamage
                                        .length;

                i++
        ){

            MainActivity
                    .crewManager
                    .getTeam()
                    .get(i)

                    .takeDamage(
                            CombatEngine
                                    .pendingDamage[i]
                    );

        }



        MainActivity
                .crewManager
                .removeDead();



        if(
                MainActivity
                        .crewManager
                        .getTeam()
                        .isEmpty()
        ){

            t.setText(
                    t.getText()
                            +"\nGAME OVER"
            );

            nextBtn.setVisibility(
                    View.GONE
            );

            return;

        }



        statusBtn.setOnClickListener(v->{

            String s=
                    "Crew Status\n";

            for(
                    CrewMember c:
                    MainActivity
                            .crewManager
                            .getTeam()
            ){

                s+=
                        c.getRole()

                                +" HP:"
                                +c.getHp()

                                +" M:"
                                +c.getMight()

                                +" T:"
                                +c.getTech()

                                +" L:"
                                +c.getLuck()

                                +"\n";

            }

            t.setText(
                    s
                            +"\nEnemy: "
                            +enemy.getType()
                            +"\n"
                            +res
            );

        });




        nextBtn.setOnClickListener(v->{


            if(
                    MainActivity
                            .phaseInFloor==-1
            ){
                return;
            }



            if(
                    boss
            ){


                if(

                        MainActivity
                                .floorLevel==3

                                &&

                                CombatEngine
                                        .lastVictory

                ){

                    MainActivity
                            .phaseInFloor=-1;


                    t.setText(

                            "YOU DEFEATED\n"

                                    +"THE FINAL BOSS!"

                    );


                    nextBtn.setEnabled(
                            false
                    );


                    nextBtn.setVisibility(
                            View.GONE
                    );


                    return;

                }



                if(
                        MainActivity
                                .floorLevel<3
                ){

                    MainActivity
                            .floorLevel++;

                }


                MainActivity
                        .phaseInFloor=0;


                startActivity(

                        new Intent(

                                this,

                                BattleActivity.class

                        )

                );

                return;

            }




            if(
                    MainActivity
                            .phaseInFloor==0
            ){

                MainActivity
                        .phaseInFloor=1;

                startActivity(

                        new Intent(

                                this,

                                RecruitActivity.class

                        )

                );

                return;

            }




            if(
                    MainActivity
                            .phaseInFloor==2
            ){

                MainActivity
                        .phaseInFloor=3;

                startActivity(

                        new Intent(

                                this,

                                UpgradeActivity.class

                        )

                );

            }



        });


    }

}