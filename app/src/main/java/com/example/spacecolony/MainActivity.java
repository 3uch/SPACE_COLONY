package com.example.spacecolony;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    public static CrewManager crewManager=new CrewManager();
    public static int floorLevel=1;
    public static int phaseInFloor=0;

    @Override protected void onCreate(Bundle b){
        super.onCreate(b); setContentView(R.layout.activity_main);

        Button s=findViewById(R.id.btnSoldier);
        Button m=findViewById(R.id.btnMedic);
        Button e=findViewById(R.id.btnEngineer);
        Button sc=findViewById(R.id.btnScientist);
        Button p=findViewById(R.id.btnPilot);

        s.setOnClickListener(v->{startRun(new Soldier("Rex"));});
        m.setOnClickListener(v->{startRun(new Medic("Nova"));});
        e.setOnClickListener(v->{startRun(new Engineer("Bolt"));});
        sc.setOnClickListener(v->{startRun(new Scientist("Echo"));});
        p.setOnClickListener(v->{startRun(new Pilot("Sky"));});
    }
    void startRun(CrewMember c){
        crewManager=new CrewManager(); crewManager.addMember(c);
        floorLevel=1; phaseInFloor=0;
        startActivity(new Intent(this,BattleActivity.class));
    }
}