package sharedpref.jxw.com.sharedpref;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences dataStore;
    EditText nameIputField;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataStore = getSharedPreferences(getString(R.string.share_preference_key), Context.MODE_PRIVATE);
        sayHi();
    }

    public void saveData(View v) {
        nameIputField = findViewById(R.id.nameInput);
        String name = nameIputField.getText().toString();

        SharedPreferences.Editor editor = dataStore.edit();
        editor.putString("name", name);
        editor.apply();

        Intent intent = new Intent(this, DetailActivity.class);
        startActivity(intent);
    }

    public void sayHi() {
        String name = dataStore.getString("name", "User");
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
        }, 5000);
    }
}
