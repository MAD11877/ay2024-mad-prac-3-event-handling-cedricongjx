package sg.edu.np.mad.madpractical3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.app.AlertDialog;
import java.util.Random;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return WindowInsetsCompat.CONSUMED;
        });

        ImageView imageView = findViewById(R.id.imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(ListActivity.this)
                        .setTitle("Profile")
                        .setMessage("Choose an option")
                        .setPositiveButton("View", (dialog, which) -> {
                            // Generate a random integer
                            Random rand = new Random();
                            int randomNumber = rand.nextInt(1000000000);  // Random integer between 0 and 999999999

                            // Start MainActivity and pass the random integer
                            Intent intent = new Intent(ListActivity.this, MainActivity.class);
                            intent.putExtra("randomInt", randomNumber);
                            startActivity(intent);
                        })
                        .setNegativeButton("Close", (dialog, which) -> {
                            dialog.dismiss();
                        })
                        .show();
            }
        });
    }
}
