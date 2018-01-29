package ke.co.sombo.apps.login;

import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PasswordActivity extends AppCompatActivity {
    private TextView email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        email = findViewById(R.id.email_label);
        email.setText(getIntent().getStringExtra("email_text"));
    }

    public void goToMain(View view) {
        Intent i = new Intent(this,MainActivity.class);
        i.putExtra("email_text",email.getText().toString().trim());
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this,email,ViewCompat.getTransitionName(email));
        startActivity(i, optionsCompat.toBundle());
    }
}
