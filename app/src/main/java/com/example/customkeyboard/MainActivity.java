package com.example.customkeyboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Date;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = (EditText) findViewById(R.id.editText);
        MyKeyboard keyboard = (MyKeyboard) findViewById(R.id.keyboard);

        // prevent system keyboard from appearing when EditText is tapped
        editText.setRawInputType(InputType.TYPE_CLASS_TEXT);
        editText.setTextIsSelectable(true);

        String stringsToType[] = {
                "The quick brown fox jumps over the lazy dog",
                "The plump wizard converted junk boxes to quality feed bags",
                "Jodie very quickly examined and sewed the big fine zippers",
                "The jay, pig, fox, zebra and my wolves quack",
                "A wizard job is to vex chumps quickly in fog",
                "The five boxing wizards jump quickly",
                "Pack my box with five dozen liquor jugs",
                "Two driven jocks help fax my big quiz"

        };

        // pass the InputConnection from the EditText to the keyboard
        InputConnection ic = editText.onCreateInputConnection(new EditorInfo());
        keyboard.setInputConnection(ic);

        ImageButton startButton;
        EditText typedData;
        Button newStringButton;
        ImageButton endButton;
        TextView dataToType;
        TextView finalData;
        TextView finalErrorData;
        final long[] startTime = {0};
        final long[] endTime = {0};
        final long[] timeTaken = {0};
        final String[] dataToBeDisplayed = {""};

        startButton = (ImageButton) findViewById(R.id.startButton);
        endButton = (ImageButton) findViewById(R.id.stopButton);
        finalData = (TextView) findViewById(R.id.final_data);
        finalErrorData = (TextView) findViewById(R.id.final_data2);
        dataToType = (TextView) findViewById(R.id.text_view_id);
        newStringButton = (Button) findViewById(R.id.new_string);
        typedData = (EditText) findViewById(R.id.editText);


        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startTime[0] = System.currentTimeMillis();

                if(dataToType.getVisibility() == View.INVISIBLE)
                {

                    Random random = new Random();
                    int index = random.nextInt(stringsToType.length - 0) + 0;
                    dataToType.setText(stringsToType[index]);
                    dataToType.setVisibility(View.VISIBLE);
                }
            }
        });
        endButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                endTime[0] = System.currentTimeMillis();
                timeTaken[0] = endTime[0] - startTime[0];
                dataToBeDisplayed[0] = "Time Taken: " + timeTaken[0]/1000.0 + "s";
                finalData.setVisibility(View.VISIBLE);
                finalData.setText(dataToBeDisplayed[0]);
                finalErrorData.setVisibility(View.VISIBLE);
                newStringButton.setVisibility(View.VISIBLE);
            }
        });

        newStringButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                typedData.setText("");
                dataToType.setVisibility(View.INVISIBLE);
                finalData.setVisibility(View.INVISIBLE);
                finalErrorData.setVisibility(View.INVISIBLE);
                newStringButton.setVisibility(View.INVISIBLE);
                finalErrorData.setText("0");
            }
        });

    }

}