package com.example.customkeyboard;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MyKeyboard extends LinearLayout implements View.OnClickListener {
    private boolean caps = false;


    // constructors
    public MyKeyboard(Context context) {
        this(context, null, 0);
    }

    public MyKeyboard(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyKeyboard(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }




    // keyboard keys (buttons)
    private Button mButton1;
    private Button mButton2;
    private Button mButton3;
    private Button mButton4;
    private Button mButton5;
    private Button mButton6;
    private Button mButton7;
    private Button mButton8;
    private Button mButton9;
    private Button mButton10;
    private Button mButton11;
    private Button mButton12;
    private Button mButton13;
    private Button mButton14;
    private Button mButton15;
    private Button mButton16;
    private Button mButton17;
    private Button mButton18;
    private Button mButtonNumPadSwitch;
    private Button mButton20;
    private Button mButton21;
    private Button mButton22;
    private Button mButton23;
    private Button mButton24;
    private Button mButton25;
    private Button mButton26;
    private Button mButton27;
    private Button mButtonDelete;
    private Button mButtonEnter;



    //buttons for numpad

    private Button mButtonNum1;
    private Button mButtonNum2;
    private Button mButtonNum3;
    private Button mButtonNum4;
    private Button mButtonNum5;
    private Button mButtonNum6;
    private Button mButtonNum7;
    private Button mButtonNum8;
    private Button mButtonNum9;
    private Button mButtonNum10;
    private Button mButtonNumtoChar;
    private Button mButtonSym1;
    private Button mButtonSym2;
    private Button mButtonSym3;
    private Button mButtonSym4;
    private Button mButtonSym5;
    private Button mButtonSym6;
    private Button mButtonSym7;
    private Button mButtonSym8;
    private Button mButtonSym9;
    private Button mButtonSym10;
    private Button mButtonSym11;

    //buttons for text

    private Button mButtonText1;
    private Button mButtonText2;
    private Button mButtonText3;
    private Button mButtonText4;
    private Button mButtonText5;
    private Button mButtonText6;
    private Button mButtonText7;
    private Button mButtonText8;
    private Button mButtonText9;
    private Button mButtonText10;
    private Button mButtonText11;
    private Button mButtonText12;
    private Button mButtonText13;
    private Button mButtonText14;
    private Button mButtonText15;
    private Button mButtonText16;

    //bottom bar new buttons
    private Button mButtonSpace;
    private Button mButtonBottomBarSym1;
    private Button mButtonBottomBarSym2;
    private Button mButtonBottomBarSym3;
    private Button mButtonBottomBarSym4;
    private Button mButtonBottomBarSym5;

    private TextView finalErrorData;
    

    // This will map the button resource id to the String value that we want to
    // input when that button is clicked.
    SparseArray<String> keyValues = new SparseArray<>();

    // Our communication link to the EditText
    InputConnection inputConnection;

    private void init(Context context, AttributeSet attrs) {

        // initialize buttons

        LayoutInflater.from(context).inflate(R.layout.keyboard, this, true);
        mButton1 = (Button) findViewById(R.id.button_1);
        mButton2 = (Button) findViewById(R.id.button_2);
        mButton3 = (Button) findViewById(R.id.button_3);
        mButton4 = (Button) findViewById(R.id.button_4);
        mButton5 = (Button) findViewById(R.id.button_5);
        mButton6 = (Button) findViewById(R.id.button_6);
        mButton7 = (Button) findViewById(R.id.button_7);
        mButton8 = (Button) findViewById(R.id.button_8);
        mButton9 = (Button) findViewById(R.id.button_9);
        mButton10 = (Button) findViewById(R.id.button_10);
        mButton11 = (Button) findViewById(R.id.button_11);
        mButton12 = (Button) findViewById(R.id.button_12);
        mButton13 = (Button) findViewById(R.id.button_13);
        mButton14 = (Button) findViewById(R.id.button_14);
        mButton15 = (Button) findViewById(R.id.button_15);
        mButton16 = (Button) findViewById(R.id.button_16);
        mButton17 = (Button) findViewById(R.id.button_17);
        mButton18 = (Button) findViewById(R.id.button_18);
        mButtonNumPadSwitch = (Button) findViewById(R.id.button_symbolPadSwitch);
        mButton20 = (Button) findViewById(R.id.button_20);
        mButton21 = (Button) findViewById(R.id.button_21);
        mButton22 = (Button) findViewById(R.id.button_22);
        mButton23 = (Button) findViewById(R.id.button_23);
        mButton24 = (Button) findViewById(R.id.button_24);
        mButton25 = (Button) findViewById(R.id.button_25);
        mButton26 = (Button) findViewById(R.id.button_26);
        mButton27 = (Button) findViewById(R.id.button_27);
        mButtonDelete = (Button) findViewById(R.id.button_delete);
        mButtonEnter = (Button) findViewById(R.id.button_enter);


        //numpad buttons
        mButtonNum1 = (Button) findViewById(R.id.button_num1);
        mButtonNum2 = (Button) findViewById(R.id.button_num2);
        mButtonNum3 = (Button) findViewById(R.id.button_num3);
        mButtonNum4 = (Button) findViewById(R.id.button_num4);
        mButtonNum5 = (Button) findViewById(R.id.button_num5);
        mButtonNum6 = (Button) findViewById(R.id.button_num6);
        mButtonNum7 = (Button) findViewById(R.id.button_num7);
        mButtonNum8 = (Button) findViewById(R.id.button_num8);
        mButtonNum9 = (Button) findViewById(R.id.button_num9);
        mButtonNum10 = (Button) findViewById(R.id.button_num0);
        mButtonNumtoChar = (Button) findViewById(R.id.button_switchToType);
        mButtonSym1 = (Button) findViewById(R.id.button_sym1);
        mButtonSym2 = (Button) findViewById(R.id.button_sym2);
        mButtonSym3 = (Button) findViewById(R.id.button_sym3);
        mButtonSym4 = (Button) findViewById(R.id.button_sym4);
        mButtonSym5 = (Button) findViewById(R.id.button_sym5);
        mButtonSym6 = (Button) findViewById(R.id.button_sym6);
        mButtonSym7 = (Button) findViewById(R.id.button_sym7);
        mButtonSym8 = (Button) findViewById(R.id.button_sym8);
        mButtonSym9 = (Button) findViewById(R.id.button_sym9);
        mButtonSym10 = (Button) findViewById(R.id.button_sym10);
        mButtonSym11 = (Button) findViewById(R.id.button_sym11);


        //text buttons
        mButtonText1 = (Button) findViewById(R.id.wordbutton_1);
        mButtonText2 = (Button) findViewById(R.id.wordbutton_2);
        mButtonText3 = (Button) findViewById(R.id.wordbutton_3);
        mButtonText4 = (Button) findViewById(R.id.wordbutton_4);
        mButtonText5 = (Button) findViewById(R.id.wordbutton_5);
        mButtonText6 = (Button) findViewById(R.id.wordbutton_6);
        mButtonText7 = (Button) findViewById(R.id.wordbutton_7);
        mButtonText8 = (Button) findViewById(R.id.wordbutton_8);
        mButtonText9 = (Button) findViewById(R.id.wordbutton_9);
        mButtonText10 = (Button) findViewById(R.id.wordbutton_10);
        mButtonText11 = (Button) findViewById(R.id.wordbutton_11);
        mButtonText12 = (Button) findViewById(R.id.wordbutton_12);
        mButtonText13 = (Button) findViewById(R.id.wordbutton_13);
        mButtonText14 = (Button) findViewById(R.id.wordbutton_14);
        mButtonText15 = (Button) findViewById(R.id.wordbutton_15);
        mButtonText16 = (Button) findViewById(R.id.wordbutton_16);
        mButtonSpace = (Button) findViewById(R.id.button_space);

        //bottom bar symbols
        mButtonBottomBarSym1 = (Button) findViewById(R.id.button_primarySym1);
        mButtonBottomBarSym2 = (Button) findViewById(R.id.button_primarySym2);
        mButtonBottomBarSym3 = (Button) findViewById(R.id.button_primarySym3);
        mButtonBottomBarSym4 = (Button) findViewById(R.id.button_primarySym4);
        mButtonBottomBarSym5 = (Button) findViewById(R.id.button_primarySym5);
        finalErrorData = (TextView) findViewById(R.id.final_data2);




        // set button click listeners
        mButton1.setOnClickListener(this);
        mButton2.setOnClickListener(this);
        mButton3.setOnClickListener(this);
        mButton4.setOnClickListener(this);
        mButton5.setOnClickListener(this);
        mButton6.setOnClickListener(this);
        mButton7.setOnClickListener(this);
        mButton8.setOnClickListener(this);
        mButton9.setOnClickListener(this);
        mButton10.setOnClickListener(this);
        mButton11.setOnClickListener(this);
        mButton12.setOnClickListener(this);
        mButton13.setOnClickListener(this);
        mButton14.setOnClickListener(this);
        mButton15.setOnClickListener(this);
        mButton16.setOnClickListener(this);
        mButton17.setOnClickListener(this);
        mButton18.setOnClickListener(this);
        mButtonNumPadSwitch.setOnClickListener(this);
        mButton20.setOnClickListener(this);
        mButton21.setOnClickListener(this);
        mButton22.setOnClickListener(this);
        mButton23.setOnClickListener(this);
        mButton24.setOnClickListener(this);
        mButton25.setOnClickListener(this);
        mButton26.setOnClickListener(this);
        mButton27.setOnClickListener(this);
        mButtonDelete.setOnClickListener(this);
        mButtonEnter.setOnClickListener(this);
        mButtonNum1.setOnClickListener(this);
        mButtonNum2.setOnClickListener(this);
        mButtonNum3.setOnClickListener(this);
        mButtonNum4.setOnClickListener(this);
        mButtonNum6.setOnClickListener(this);
        mButtonNum7.setOnClickListener(this);
        mButtonNum8.setOnClickListener(this);
        mButtonNum9.setOnClickListener(this);
        mButtonNum10.setOnClickListener(this);
        mButtonNumtoChar.setOnClickListener(this);
        mButtonSym1.setOnClickListener(this);
        mButtonSym2.setOnClickListener(this);
        mButtonSym3.setOnClickListener(this);
        mButtonSym4.setOnClickListener(this);
        mButtonSym5.setOnClickListener(this);
        mButtonSym6.setOnClickListener(this);
        mButtonSym7.setOnClickListener(this);
        mButtonSym8.setOnClickListener(this);
        mButtonSym9.setOnClickListener(this);
        mButtonSym10.setOnClickListener(this);
        mButtonSym11.setOnClickListener(this);
        mButtonText1.setOnClickListener(this);
        mButtonText2.setOnClickListener(this);
        mButtonText3.setOnClickListener(this);
        mButtonText4.setOnClickListener(this);
        mButtonText5.setOnClickListener(this);
        mButtonText6.setOnClickListener(this);
        mButtonText7.setOnClickListener(this);
        mButtonText8.setOnClickListener(this);
        mButtonText9.setOnClickListener(this);
        mButtonText10.setOnClickListener(this);
        mButtonText11.setOnClickListener(this);
        mButtonText12.setOnClickListener(this);
        mButtonText13.setOnClickListener(this);
        mButtonText14.setOnClickListener(this);
        mButtonText15.setOnClickListener(this);
        mButtonText16.setOnClickListener(this);
        mButtonSpace.setOnClickListener(this);
        mButtonBottomBarSym1.setOnClickListener(this);
        mButtonBottomBarSym2.setOnClickListener(this);
        mButtonBottomBarSym3.setOnClickListener(this);
        mButtonBottomBarSym4.setOnClickListener(this);
        mButtonBottomBarSym5.setOnClickListener(this);








        // map buttons IDs to input strings
        keyValues.put(R.id.button_1, "e");
        keyValues.put(R.id.button_2, "s");
        keyValues.put(R.id.button_3, "c");
        keyValues.put(R.id.button_4, "p");
        keyValues.put(R.id.button_5, "q");
        keyValues.put(R.id.button_6, "k");
        keyValues.put(R.id.button_7, "f");
        keyValues.put(R.id.button_8, "d");
        keyValues.put(R.id.button_9, "o");
        keyValues.put(R.id.button_10, "t");
        keyValues.put(R.id.button_11, "h");
        keyValues.put(R.id.button_12, "w");
        keyValues.put(R.id.button_13, "b");
        keyValues.put(R.id.button_14, "z");
        keyValues.put(R.id.button_15, "x");
        keyValues.put(R.id.button_16, "y");
        keyValues.put(R.id.button_17, "l");
        keyValues.put(R.id.button_18, "i");
        keyValues.put(R.id.button_20, "a");
        keyValues.put(R.id.button_21, "r");
        keyValues.put(R.id.button_22, "m");
        keyValues.put(R.id.button_23, "v");
        keyValues.put(R.id.button_24, "j");
        keyValues.put(R.id.button_25, "g");
        keyValues.put(R.id.button_26, "u");
        keyValues.put(R.id.button_27, "n");
        keyValues.put(R.id.button_enter, "\n");

        //numpad keys
        keyValues.put(R.id.button_num1, "1");
        keyValues.put(R.id.button_num2, "2");
        keyValues.put(R.id.button_num3, "3");
        keyValues.put(R.id.button_num4, "4");
        keyValues.put(R.id.button_num5, "5");
        keyValues.put(R.id.button_num6, "6");
        keyValues.put(R.id.button_num7, "7");
        keyValues.put(R.id.button_num8, "8");
        keyValues.put(R.id.button_num9, "9");
        keyValues.put(R.id.button_num0, "0");
        keyValues.put(R.id.button_sym1, "?");
        keyValues.put(R.id.button_sym2, ".");
        keyValues.put(R.id.button_sym3, ",");
        keyValues.put(R.id.button_sym4, "_");
        keyValues.put(R.id.button_sym5, "&");
        keyValues.put(R.id.button_sym6, "%");
        keyValues.put(R.id.button_sym7, "$");
        keyValues.put(R.id.button_sym8, "*");
        keyValues.put(R.id.button_sym9, "@");
        keyValues.put(R.id.button_sym10, "/");
        keyValues.put(R.id.button_sym11, "!");

        //text buttons
        keyValues.put(R.id.wordbutton_1, "the");
        keyValues.put(R.id.wordbutton_2, "be");
        keyValues.put(R.id.wordbutton_3, "of");
        keyValues.put(R.id.wordbutton_6, "he");
        keyValues.put(R.id.wordbutton_8, "with");
        keyValues.put(R.id.wordbutton_9, "you");
        keyValues.put(R.id.wordbutton_10, "this");
        keyValues.put(R.id.wordbutton_11, "but");
        keyValues.put(R.id.wordbutton_4, "that");
        keyValues.put(R.id.wordbutton_5, "have");
        keyValues.put(R.id.wordbutton_7, "for");
        keyValues.put(R.id.wordbutton_12, "his");
        keyValues.put(R.id.wordbutton_13, "by");
        keyValues.put(R.id.wordbutton_14, "from");
        keyValues.put(R.id.wordbutton_15, "they");
        keyValues.put(R.id.wordbutton_16, "we");

        keyValues.put(R.id.button_space, " ");
        keyValues.put(R.id.button_primarySym1, "?");
        keyValues.put(R.id.button_primarySym2, "@");
        keyValues.put(R.id.button_primarySym3, "_");
        keyValues.put(R.id.button_primarySym4, ".");
        keyValues.put(R.id.button_primarySym5, "-");


    }

    @Override
    public void onClick(View v) {

        int errorCount = Integer.parseInt((String) finalErrorData.getText());
        String dataToBeDisplayed;
        long startTime = 0;
        long endTime = 0;
        long timeTaken;

        LinearLayout symbolPad = (LinearLayout) findViewById(R.id.symbolPad);
        LinearLayout characterPad = (LinearLayout) findViewById(R.id.characterPad);

        // do nothing if the InputConnection has not been set yet
        if (inputConnection == null) return;

        // Delete text or input key value
        // All communication goes through the InputConnection
        if (v.getId() == R.id.button_delete) {
            errorCount = errorCount + 1;
            CharSequence selectedText = inputConnection.getSelectedText(0);
            if (TextUtils.isEmpty(selectedText)) {
                // no selection, so delete previous character
                inputConnection.deleteSurroundingText(1, 0);
            } else {
                // delete the selection
                inputConnection.commitText("", 1);
            }
        } else {

            if (v.getId() == R.id.button_symbolPadSwitch)
            {
                characterPad.setVisibility(v.GONE);
                symbolPad.setVisibility(v.VISIBLE);
            }
            else if (v.getId() == R.id.button_switchToType)
            {
                characterPad.setVisibility(v.VISIBLE);
                symbolPad.setVisibility(v.GONE);
            }

            else{
            String value = keyValues.get(v.getId());
            inputConnection.commitText(value, 1);}
        }
        finalErrorData.setText(Integer.toString(errorCount));
    }


    // The activity (or some parent or controller) must give us
    // a reference to the current EditText's InputConnection
    public void setInputConnection(InputConnection ic) {
        this.inputConnection = ic;
    }
}