package org.ieselcaminas.daniel.tictactoe;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.R.attr.button;
import static android.R.attr.colorAccent;
import static android.R.attr.text;

public class MainActivity extends AppCompatActivity {

    private Button[] buttons;
    private Button restartButton;
    private TextView textViewName;
    private final int NUM_BUTTONS = 9;
    private int turn = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttons = new Button[NUM_BUTTONS];
        buttons[0] = (Button) findViewById(R.id.button1);
        buttons[1] = (Button) findViewById(R.id.button2);
        buttons[2] = (Button) findViewById(R.id.button3);
        buttons[3] = (Button) findViewById(R.id.button4);
        buttons[4] = (Button) findViewById(R.id.button5);
        buttons[5] = (Button) findViewById(R.id.button6);
        buttons[6] = (Button) findViewById(R.id.button7);
        buttons[7]= (Button) findViewById(R.id.button8);
        buttons[8] = (Button) findViewById(R.id.button9);
        restartButton = (Button) findViewById(R.id.restartButton);
        textViewName = (TextView) findViewById(R.id.textView);
        textViewName.setTypeface(Typeface.createFromAsset(getAssets(), "Bubble3D.ttf"));
        restartButton.setTypeface(Typeface.createFromAsset(getAssets(), "Bubble3D.ttf"));

        textViewName.setText("Turn of player 1 -X-");

        for (int i=0; i<NUM_BUTTONS; i++) {
            buttons[i].setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {

                    Button button = (Button) view;
                    button.setTypeface(Typeface.createFromAsset(getAssets(), "Bubble3D.ttf"));

                    if (turn % 2 == 0) {
                            button.setText("X");
                            button.setTextColor(getResources().getColor(R.color.colorX));
                            textViewName.setText("Turn of player 2 -O-");
                    } else {
                            button.setText("O");
                        button.setTextColor(getResources().getColor(R.color.colorO));
                        textViewName.setText("Turn of player 1 -X-");
                    }

                    turn++;
                    button.setEnabled(false);
                    checkAll();
                }
            });
        }

        restartButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                textViewName.setText("Turn of player 1 -X-");
                turn=0;

                for(int i=0; i<NUM_BUTTONS; i++) {
                    buttons[i].setText("");
                    buttons[i].setEnabled(true);
                }

            }
        });


    }

    public void checkHorizontal() {
        if (buttons[0].getText() == buttons[1].getText() && buttons[0].getText() == buttons[2].getText() && buttons[0].getText() != "") {
            win();
        } else if (buttons[3].getText() == buttons[4].getText() && buttons[3].getText() == buttons[5].getText() && buttons[3].getText() != "") {
            win();
        } else if (buttons[6].getText() == buttons[7].getText() && buttons[6].getText() == buttons[8].getText() && buttons[6].getText() != "") {
            win();
        }
    }

    public void checkVertical() {
        if (buttons[0].getText() == buttons[3].getText() && buttons[0].getText() == buttons[6].getText() && buttons[0].getText() != "") {
            win();
        } else if (buttons[1].getText() == buttons[4].getText() && buttons[1].getText() == buttons[7].getText() && buttons[1].getText() != "") {
            win();
        } else if (buttons[2].getText() == buttons[5].getText() && buttons[8].getText() == buttons[2].getText() && buttons[2].getText() != "") {
            win();
        }
    }

    public void checkDiagonal() {
        if (buttons[0].getText() == buttons[4].getText() && buttons[0].getText() == buttons[8].getText() && buttons[0].getText() != "") {
            win();
        } else if (buttons[2].getText() == buttons[4].getText() && buttons[2].getText() == buttons[6].getText() && buttons[2].getText() != "") {
            win();
        }
    }

    public void checkAll() {
        checkVertical();
        checkDiagonal();
        checkHorizontal();
    }


    public void win() {
        for (int i = 0; i < NUM_BUTTONS; i++) {
            buttons[i].setEnabled(false);
        }
        if (turn % 2 == 0) {
            textViewName.setText("YOU WIN PLAYER 2!!!");
        } else {
            textViewName.setText("YOU WIN PLAYER 1!!");
        }
    }


}
