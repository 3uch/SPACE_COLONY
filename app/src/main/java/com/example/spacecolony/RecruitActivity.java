package com.example.spacecolony;
import android.content.*; import android.os.*; import android.widget.*;
import androidx.appcompat.app.AppCompatActivity; import java.util.*;
public class RecruitActivity extends AppCompatActivity {
    CrewMember a,b;
    @Override protected void onCreate(Bundle s){
        super.onCreate(s); setContentView(R.layout.activity_recruit);
        Button b1=findViewById(R.id.btnRecruitEngineer); Button b2=findViewById(R.id.btnRecruitPilot);
        a=randomRecruit(); b=randomRecruit(); while(a.getRole().equals(b.getRole())) b=randomRecruit();
        b1.setText(label(a)); b2.setText(label(b));
        b1.setOnClickListener(v->{pick(a);}); b2.setOnClickListener(v->{pick(b);});
    }
    void pick(CrewMember c){
        MainActivity.crewManager.addMember(c);
        MainActivity.phaseInFloor=2;
        startActivity(new Intent(this,BattleActivity.class));
    }
    String label(CrewMember c){return c.getRole()+" M"+c.getMight()+" T"+c.getTech()+" L"+c.getLuck();}
    CrewMember randomRecruit(){
        List<String> o=new ArrayList<>(); for(CrewMember c:MainActivity.crewManager.getTeam()) o.add(c.getRole());
        List<Integer> p=new ArrayList<>(); if(!o.contains("Soldier"))p.add(0); if(!o.contains("Medic"))p.add(1); if(!o.contains("Engineer"))p.add(2); if(!o.contains("Scientist"))p.add(3); if(!o.contains("Pilot"))p.add(4);
        int k=p.get(new Random().nextInt(p.size()));
        if(k==0)return new Soldier("R2"); if(k==1)return new Medic("N2"); if(k==2)return new Engineer("B2"); if(k==3)return new Scientist("E2"); return new Pilot("S2");
    }
}