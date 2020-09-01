package android.lab.randomcolorgenerator;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Activity activity; // activity class that instantiates an activity view
    Color clr = new Color(); // color class that instantiates a new color object
    Random rand = new Random(); // random class that instantiates random objects

    private Button colorBtn;
    private TextView counter;
    private int color;
    private int count = 0;

    // Function that generates a random color using the Color class and rgb() method
    public int randColor(){

        color = clr.rgb(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
        return color;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity = this;
        counter = findViewById(R.id.counterView);
        colorBtn = findViewById(R.id.changeColor); // initializes variable to the corresponding id

        // Button click listener
        colorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                count++;
                String countStr = Integer.toString(randColor());
                activity.findViewById(android.R.id.content).setBackgroundColor(randColor()); // finds and binds the main activity view than sets the background color
                counter.setText(countStr);
            }
        });
    }


}
