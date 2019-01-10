package sharedpref.jxw.com.sharedpref;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetailActivity extends AppCompatActivity {
    TextView nameField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        SharedPreferences contactSharedPref = getSharedPreferences(getString(R.string.share_preference_key), Context.MODE_PRIVATE);
        String name = contactSharedPref.getString("name", "Not Found");

        nameField = findViewById(R.id.displayName);
        nameField.setText(name);

    }
}
