package sg.edu.np.mad.madpractical3;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Receive the random integer passed from ListActivity
        int randomInt = getIntent().getIntExtra("randomInt", -1); // Default to -1 if no data passed

        // Get the TextViews and Button from the layout
        TextView tvRandom = findViewById(R.id.textView2); // Assuming textView2 displays "Hello World!"
        Button btnMessage = findViewById(R.id.button2); // Ensure this ID matches your layout XML

        // Replace "Hello World!" with the random integer
        tvRandom.setText(String.valueOf("MAD" + "" + randomInt));

        // Setting up the event listener for the Message button
        btnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch the MessageGroup activity
                Intent intent = new Intent(MainActivity.this, MessageGroup.class);
                startActivity(intent);
            }
        });
    }
}
