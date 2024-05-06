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

        // Initialize a new User object
        Userr user = new Userr("MAD PRACTICAL", "MAD Developer", 1, false);

        // Get the TextViews and Button from the layout
        TextView tvName = findViewById(R.id.textView);
        TextView tvDescription = findViewById(R.id.textView3);
        Button btnFollow = findViewById(R.id.button);
        Button btnMessage = findViewById(R.id.button2); // Ensure this ID matches your layout XML

        // Display the name with the random integer
        tvName.setText(user.name + " " + randomInt);
        tvDescription.setText(user.description);
        btnFollow.setText(user.followed ? "Unfollow" : "Follow");

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
