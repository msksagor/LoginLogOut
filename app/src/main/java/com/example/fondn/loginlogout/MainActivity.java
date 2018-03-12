package com.example.fondn.loginlogout;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    MydatabaseHelper mydatabaseHelper;
    private  EditText userName,password;
    private Button login,SignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName = (EditText) findViewById(R.id.userNameID);
        password = (EditText) findViewById(R.id.passwordID);
        login = (Button) findViewById(R.id.loginButtonID);
        SignUp = (Button) findViewById(R.id.createAccountButtonID);

        mydatabaseHelper = new MydatabaseHelper(this);
        SQLiteDatabase database = mydatabaseHelper.getWritableDatabase();

        login.setOnClickListener(this);
        SignUp.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String userNameString = userName.getText().toString();
        String userPasswordString = password.getText().toString();

        if(v.getId()==R.id.loginButtonID){
          Boolean result = mydatabaseHelper.findpasswordanduserName(userNameString,userPasswordString);
          if(result==true){
              Intent i = new Intent(MainActivity.this,Result.class);
              startActivity(i);
          }else{
              Toast.makeText(this, "Not Match....", Toast.LENGTH_SHORT).show();
          }


        }else if(v.getId()==R.id.createAccountButtonID){
            Intent i = new Intent(MainActivity.this,SignupActivity.class);
            startActivity(i);
        }
    }
}
