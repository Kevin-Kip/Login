package ke.co.sombo.apps.login;

import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String email_text = getIntent().getStringExtra("email_text");

        if (email_text != null){
            email.setText(email_text);
        }

        email = findViewById(R.id.email);
    }

    public void goToPassword(View view) {
        if (email.getText().toString().trim().isEmpty()){
            email.setError(getString(R.string.error));
            return;
        }
        Intent intent = new Intent(this,PasswordActivity.class);
        intent.putExtra("email_text",email.getText().toString().trim());
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this,email, ViewCompat.getTransitionName(email));
        startActivity(intent,optionsCompat.toBundle());
    }
}
