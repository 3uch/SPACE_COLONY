package com.example.spacecolony;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class UpgradeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle b){

        super.onCreate(b);

        setContentView(
                R.layout.activity_upgrade
        );


        Button m=
                findViewById(
                        R.id.btnMight
                );

        Button t=
                findViewById(
                        R.id.btnTech
                );

        Button l=
                findViewById(
                        R.id.btnLuck
                );


        m.setOnClickListener(v->{

            for(
                    CrewMember c:

                    MainActivity
                            .crewManager
                            .getTeam()

            ){

                c.train("might");

                c.train("might");

            }

            go();

        });



        t.setOnClickListener(v->{

            for(
                    CrewMember c:

                    MainActivity
                            .crewManager
                            .getTeam()

            ){

                c.train("tech");

                c.train("tech");

            }

            go();

        });



        l.setOnClickListener(v->{

            for(
                    CrewMember c:

                    MainActivity
                            .crewManager
                            .getTeam()

            ){

                c.train("luck");

            }

            go();

        });


    }



    void go(){

        MainActivity
                .phaseInFloor=4;

        startActivity(

                new Intent(

                        this,

                        BattleActivity.class

                )

        );

    }

}