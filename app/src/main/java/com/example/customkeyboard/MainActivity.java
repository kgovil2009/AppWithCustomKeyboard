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

        // pass the InputConnection from the EditText to the keyboard
        InputConnection ic = editText.onCreateInputConnection(new EditorInfo());
        keyboard.setInputConnection(ic);

        ImageButton startButton;
        ImageButton endButton;
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


        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTime[0] = System.currentTimeMillis();
            }
        });
        endButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                endTime[0] = System.currentTimeMillis();
                timeTaken[0] = endTime[0] - startTime[0];
                dataToBeDisplayed[0] = "Time Taken: " + timeTaken[0] + "ms";
                finalData.setVisibility(View.VISIBLE);
                finalData.setText(dataToBeDisplayed[0]);
                finalErrorData.setVisibility(View.VISIBLE);
            }
        });

    }

}