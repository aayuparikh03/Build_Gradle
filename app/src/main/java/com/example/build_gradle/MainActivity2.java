package com.example.build_gradle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView t1=findViewById(R.id.textView);
        TextView t2=findViewById(R.id.textView2);
        Button b=findViewById(R.id.button2);

        SharedPreferences sp=getSharedPreferences("first",MODE_PRIVATE);
        Intent in=new Intent(MainActivity2.this,MainActivity.class);
        t1.setText(t1.getText().toString()+" "+sp.getString("n","no data"));
        t2.setText(t2.getText().toString()+" "+sp.getString("p","no data"));


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(in);
            }
        });
    }
}