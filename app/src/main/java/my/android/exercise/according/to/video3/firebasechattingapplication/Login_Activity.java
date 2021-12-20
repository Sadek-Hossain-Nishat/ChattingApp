package my.android.exercise.according.to.video3.firebasechattingapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login_Activity extends AppCompatActivity {
    EditText userETlogin,passETlogin;
    Button loginBtn,registerBtn;

    //Firebase
    FirebaseAuth auth;
    FirebaseUser firebaseUser;

    //register button


    @Override
    protected void onStart() {
        super.onStart();
        firebaseUser=FirebaseAuth.getInstance().getCurrentUser();

        //checking for users existance : saving the current user
        if (firebaseUser!=null){
            Intent i=new Intent(Login_Activity.this,MainActivity.class);
            startActivity(i);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userETlogin=findViewById(R.id.editTextTextPersonName);
        passETlogin=findViewById(R.id.editTextTextPassword);
        loginBtn=findViewById(R.id.buttonLogin);
        registerBtn=findViewById(R.id.registerBtn);

        //firebase auth
        auth=FirebaseAuth.getInstance();


        //register button
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Login_Activity.this,RegisterActivity.class);
                startActivity(i);
            }
        });



        //login Button
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email_text=userETlogin.getText().toString();
                String pass_text=passETlogin.getText().toString();


                //checking if it is empty
                if (TextUtils.isEmpty(email_text) || TextUtils.isEmpty(pass_text)){
                    Toast.makeText(Login_Activity.this, "Please fill the Fields", Toast.LENGTH_SHORT).show();

                }else {
                    auth.signInWithEmailAndPassword(email_text,pass_text)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Intent i=new Intent(Login_Activity.this,MainActivity.class);
                                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(i);
                                finish();
                            }
                            else {
                                Toast.makeText(Login_Activity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

    }
}