package com.steenpapierschaargame.steenpapierschaargame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btnsteen, btnpapier, btnschaar;
    ImageView iv_cpu, iv_me;

    String mijnkeuze, cpukeuze, resultaat;

    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv_cpu = (ImageView) findViewById(R.id.iv_cpu);
        iv_me = (ImageView) findViewById(R.id.iv_me);

        btnsteen = (Button) findViewById(R.id.steen);
        btnpapier = (Button) findViewById(R.id.papier);
        btnschaar = (Button) findViewById(R.id.schaar);

        random = new Random();

        btnsteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mijnkeuze = "steen";
                iv_me.setImageResource(R.drawable.steen);
                uitrekenen();
            }
        });

        btnpapier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mijnkeuze = "papier";
                iv_me.setImageResource(R.drawable.papier);
                uitrekenen();
            }
        });

        btnschaar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mijnkeuze = "schaar";
                iv_me.setImageResource(R.drawable.schaar);
                uitrekenen();
            }
        });
    }

    public void uitrekenen() {
        int cpu = random.nextInt(3);
        if(cpu == 0){
            cpukeuze = "steen";
            iv_cpu.setImageResource(R.drawable.steen);
        } else if(cpu == 1) {
            cpukeuze = "papier";
            iv_cpu.setImageResource(R.drawable.papier);
        } else if(cpu == 2) {
            cpukeuze = "schaar";
            iv_cpu.setImageResource(R.drawable.schaar);
        }

        if(mijnkeuze.equals("steen") && cpukeuze.equals("papier")) {
           resultaat = "Verloren!";
        } else

        if(mijnkeuze.equals("steen") && cpukeuze.equals("schaar")) {
            resultaat = "Gewonnen!";
        } else

        if(mijnkeuze.equals("papier") && cpukeuze.equals("schaar")) {
            resultaat = "Verloren!";
        } else

        if(mijnkeuze.equals("papier") && cpukeuze.equals("steen")) {
            resultaat = "Gewonnen!";
        } else

        if(mijnkeuze.equals("schaar") && cpukeuze.equals("steen")) {
            resultaat = "Verloren!";
        } else

        if(mijnkeuze.equals("schaar") && cpukeuze.equals("papier")) {
            resultaat = "Gewonnen!";
        } else

        if(mijnkeuze.equals("steen") && cpukeuze.equals("steen")) {
            resultaat = "Gelijk!";
        } else

        if(mijnkeuze.equals("papier") && cpukeuze.equals("papier")) {
            resultaat = "Gelijk!";
        } else

        if(mijnkeuze.equals("schaar") && cpukeuze.equals("schaar")) {
            resultaat = "Gelijk!";
        }

        Toast.makeText(MainActivity.this, resultaat, Toast.LENGTH_SHORT).show();


    }
}
