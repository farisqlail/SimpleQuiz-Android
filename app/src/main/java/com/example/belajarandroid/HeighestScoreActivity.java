package com.example.belajarandroid;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class HeighestScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highest_score);

        TextView txtScore = (TextView)findViewById(R.id.textScore);
        TextView txtHightScore = (TextView)findViewById(R.id.textHighScore);

        Intent intent = getIntent();
        int score = intent.getIntExtra("score", 0);
        txtScore.setText("Your Score " + score);

        SharedPreferences mypref = getPreferences(MODE_PRIVATE);
        int highscore = mypref.getInt("highscore", 0);
        if(highscore >= score) {
            txtHightScore.setText("High Score "+highscore);
        } else {
            txtHightScore.setText("New highscore "+score);
            SharedPreferences.Editor editor = mypref.edit();
            editor.putInt("highscore", score);
            editor.commit();
        }
    }

        public void onClick(View view) {
            Intent intent = new Intent(HeighestScoreActivity.this, QuizActivity.class);
            startActivity(intent);
        }

        public void exit(View view) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(HeighestScoreActivity.this);
            alertDialogBuilder
                    .setMessage("Apa anda ingin keluar ?")
                    .setCancelable(false)
                    .setPositiveButton("Coba Lagi",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    startActivity(new Intent(getApplicationContext(),QuizActivity.class));
                                    finish();
                                }
                            })
                    .setNegativeButton("KELUAR",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    moveTaskToBack(true);
                                    android.os.Process.killProcess(android.os.Process.myPid());
                                    System.exit(1);
                                }
                            });
                    AlertDialog alertDialog= alertDialogBuilder.create();
                    alertDialog.show();

        }
}
