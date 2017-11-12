package nyc.muaadh_melhi_develpoer.shared_usernameandpassword;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserCheck extends AppCompatActivity {
    EditText findFood;
    Button find;
    Button back;
    SharedPreferences findFoodPref;
    String foodies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_check);
        findFood = (EditText) findViewById(R.id.find_favorite_edittext);
        find = (Button) findViewById(R.id.find_button);
        back = (Button) findViewById(R.id.back_button);
        Intent intent = getIntent();
        foodies = intent.getStringExtra("testing");
        findFoodPref = getApplicationContext().getSharedPreferences(foodies, MODE_PRIVATE);

        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((findFood.getText().toString()).equals(findFoodPref.getString((findFood.getText().toString()), ""))) {
                    Toast.makeText(getApplicationContext(), "it's fovirate food", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "it's not a fovirate food", Toast.LENGTH_LONG).show();
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent1=new Intent(UserCheck.this,UserInput.class);
               startActivity(intent1);
            }
        });

    }

}
