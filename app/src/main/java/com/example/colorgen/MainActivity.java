package com.example.colorgen;

import static android.graphics.Color.rgb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ConstraintLayout screen = findViewById(R.id.Screen);
        // called at the beginning so a color will be generated upon launching the app
        changeColor(screen);
    }

    public void changeColor(View view){
        // called when the random color button is pressed

        // create random rgb values
        Random rand = new Random();
        int red = rand.nextInt(256);
        int green = rand.nextInt(256);
        int blue = rand.nextInt(256);
        int color = rgb(red,green,blue);

        // adds the values to the screen
        EditText redText = findViewById(R.id.red);
        String redString = String.valueOf(red);
        redText.setText(redString);

        EditText greenText = findViewById(R.id.green);
        String greenString = String.valueOf(green);
        greenText.setText(greenString);

        EditText blueText = findViewById(R.id.blue);
        String blueString = String.valueOf(blue);
        blueText.setText(blueString);

        // changes the screen color
        ConstraintLayout screen = findViewById(R.id.Screen);
        screen.setBackgroundColor(color);

        // checks the color values to make sure the text is visible
        visibleText(red,green,blue);
    }

    public void manuelColor(View view){
        // called upon clicking one of the color values

        EditText red = findViewById(R.id.red);
        EditText green = findViewById(R.id.green);
        EditText blue = findViewById(R.id.blue);

        int currentRed;
        int currentGreen;
        int currentBlue;

        // the try statements check if the user has entered something into the value boxes
        // if the user deleted the value but not replaced it then the value will be set to 0
        try {
            currentRed = Integer.parseInt(red.getText().toString());
        } catch (Exception e) {
            currentRed = 0;
            String currentRedString = String.valueOf(currentRed);
            red.setText(currentRedString);
        }

        try {
            currentGreen = Integer.parseInt(green.getText().toString());
        } catch (Exception e) {
            currentGreen = 0;
            String currentGreenString = String.valueOf(currentGreen);
            green.setText(currentGreenString);
        }

        try {
            currentBlue = Integer.parseInt(blue.getText().toString());
        } catch (Exception e){
            currentBlue = 0;
            String currentBlueString = String.valueOf(currentBlue);
            blue.setText(currentBlueString);
        }


        // if the user enters a value greater than 255(the highest rgb value) then the value will be set to 100
        if (currentRed > 255){
            currentRed = 255;
            String currentRedString = String.valueOf(currentRed);
            red.setText(currentRedString);
        }
        if (currentGreen > 255){
            currentGreen = 255;
            String currentGreenString = String.valueOf(currentGreen);
            green.setText(currentGreenString);
        }
        if (currentBlue > 255){
            currentBlue = 255;
            String currentBlueString = String.valueOf(currentBlue);
            blue.setText(currentBlueString);
        }

        // changes the rgb value to something android can use
        int color = rgb(currentRed,currentGreen,currentBlue);

        // changes the screen color
        ConstraintLayout screen = findViewById(R.id.Screen);
        screen.setBackgroundColor(color);

        // checks the color values to make sure the text is visible
        visibleText(currentRed,currentGreen,currentBlue);
    }

    public void visibleText(int red, int green, int blue){
        // finding all the text
        EditText redText = findViewById(R.id.red);
        EditText greenText = findViewById(R.id.green);
        EditText blueText = findViewById(R.id.blue);

        TextView letterR = findViewById(R.id.LetterR);
        TextView letterG = findViewById(R.id.LetterG);
        TextView letterB = findViewById(R.id.LetterB);

        // the color of the text will be black unless changed by the if statement
        int color = rgb(0,0,0);

        // if at least two of the color values are less than 100 go to next if statement
        if( red < 100 && green < 100 || red < 100 && blue < 100 || green < 100 && blue < 100){
            // if none of the values are greater than or equal to 150 the color of the text will be white
            if (!(red >= 150 || green >= 150 || blue >= 150)) {
                color = rgb(255, 255, 255);
            }
        }

        // setting the text color
        redText.setTextColor(color);
        greenText.setTextColor(color);
        blueText.setTextColor(color);

        letterR.setTextColor(color);
        letterG.setTextColor(color);
        letterB.setTextColor(color);
    }
}