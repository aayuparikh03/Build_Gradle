package com.example.build_gradle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText e1=findViewById(R.id.editTextText);
        EditText e2=findViewById(R.id.editTextText2);
        Button b=findViewById(R.id.button);
        SharedPreferences sp=getSharedPreferences("first", Context.MODE_PRIVATE);
        //SharedPreferences.Editor =sp.edit();

        Intent in=new Intent(MainActivity.this,MainActivity2.class);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=e1.getText().toString();
                String pass= e2.getText().toString();

                if(name.equals("Aryan") && pass.equals("aayu"))
                {
                    if(sp.contains("n") && sp.contains("p"))
                    {
                        Toast.makeText(MainActivity.this, "Logged in Succesfully", Toast.LENGTH_SHORT).show();
                        startActivity(in);
                    }
                    else
                    {
                        SharedPreferences.Editor ed=sp.edit();
                        ed.putString("n",name);
                        ed.putString("p",pass);
                        ed.commit();
                        Toast.makeText(MainActivity.this, "Sign in Succesfully", Toast.LENGTH_SHORT).show();
                        startActivity(in);
                    }
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Wrong CredentiAals", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}