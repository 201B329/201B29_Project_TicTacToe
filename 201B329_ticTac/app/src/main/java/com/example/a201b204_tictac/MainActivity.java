package com.example.a201b204_tictac;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.TintableImageSourceView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean isWinner = false;
    int imageClicked = -1;
    int player =1;
    int [][]winningSates = {{0,1,2},{3,4,5},{6,7,8}};
    int []gameSate = {-1,-1,-1,-1,-1,-1,-1,-1,-1};

    public void load(View view)
    {

            ImageView v = (ImageView) view;
            int tag = Integer.parseInt(v.getTag().toString());
            imageClicked = gameSate[tag];
            if(isWinner== false && imageClicked==-1) {
            if (player == 1) {
                v.setImageResource(R.drawable.cross);
                gameSate[tag] = player;
                Toast.makeText(this, tag + "" + "Cross", Toast.LENGTH_SHORT).show();
                player = 0;
            } else {
                v.setImageResource(R.drawable.zero);
                gameSate[tag] = player;
                Toast.makeText(this, tag + "" + "Zero", Toast.LENGTH_SHORT).show();
                player = 1;
            }
            for (int i = 0; i < winningSates.length; i++) {
                if (gameSate[winningSates[i][0]] == gameSate[winningSates[i][1]] && gameSate[winningSates[i][1]] == gameSate[winningSates[i][2]] && (gameSate[winningSates[i][0]] > 1)) {
                    Toast.makeText(this, tag + "" + "Winner is" + (player == 0 ? 1 : 0), Toast.LENGTH_SHORT).show();
                    isWinner= true;

                }
            }
        }
    }
    public void reset(View view){
        GridLayout gridLayout = findViewById(R.id.gridlayout);
        int total_images = gridLayout.getChildCount();
        for(int i =0; i<total_images; i++){
            ImageView v = (ImageView) gridLayout.getChildAt(1);
            v.setImageDrawable(null);
        }
        isWinner = false;
        imageClicked = -1;


    }
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        new AlertDialog.Builder(this)
                //.setIcon(android.R.drawable.ic_dialog_alert)
                .setIcon(R.drawable.thumb)
                .setTitle("Be Alert!")
                .setMessage("Battery is low")
                .setNeutralButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(),"hello", Toast.LENGTH_SHORT).show();
                    }
                }).show();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
