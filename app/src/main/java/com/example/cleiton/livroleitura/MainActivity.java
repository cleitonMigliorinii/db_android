package com.example.cleiton.livroleitura;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        //remove título desta Activity
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);

        final ImageButton button = (ImageButton) findViewById(R.id.imageButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               startSecondActivity(v);
            }
        });

    }

    public void startSecondActivity(View view) {

        Intent secondActivity = new Intent(this, ListaLivroActivity.class);
        startActivity(secondActivity);
    }
}
