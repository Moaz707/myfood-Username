package nyc.muaadh_melhi_develpoer.shared_usernameandpassword;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class UserInput extends AppCompatActivity {
    EditText food;
    Button save, check;
    SharedPreferences favoriteUserFood;
    String thingWeNeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_input);


        food = (EditText) findViewById(R.id.register_favorite_edittext);
        save = (Button) findViewById(R.id.save_button);
        check = (Button) findViewById(R.id.check_button);
        Intent intent = getIntent();
        thingWeNeed = intent.getStringExtra("userfood");
        favoriteUserFood = getApplicationContext().getSharedPreferences(thingWeNeed, MODE_PRIVATE);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = favoriteUserFood.edit();
                    editor.putString(food.getText().toString(), food.getText().toString());
                    editor.commit();
                    food.setText("");
            }
        });

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(UserInput.this, UserCheck.class);
                intent1.putExtra("testing", thingWeNeed);
                startActivity(intent1);

            }
        });






    }
}
