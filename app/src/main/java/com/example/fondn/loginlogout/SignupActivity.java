package com.example.fondn.loginlogout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {
    private EditText emailSG,userNameSG,passwordSG,nameSG;
    private Button signUp;
    UserData userData;
    MydatabaseHelper mydatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        emailSG = (EditText) findViewById(R.id.emailSignUpId);
        userNameSG = (EditText) findViewById(R.id.userNameSignUpId);
        nameSG = (EditText) findViewById(R.id.nameSignUpId);
        passwordSG = (EditText) findViewById(R.id.passwordSignUpId);
        userData = new UserData();
        mydatabaseHelper = new MydatabaseHelper(this);
        signUp  = (Button) findViewById(R.id.signUpButtonID);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = emailSG.getText().toString();
                String userName = userNameSG.getText().toString();
                String name = nameSG.getText().toString();
                String password = passwordSG.getText().toString();

                userData.setName(name);
                userData.setEmail(email);
                userData.setPasword(password);
                userData.setUsername(userName);

                long rowid = mydatabaseHelper.insertData(userData);

                if(rowid>0){
                    Toast.makeText(SignupActivity.this, "Inserted", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(SignupActivity.this, "Not", Toast.LENGTH_SHORT).show();
                }


            }
        });


    }
}
