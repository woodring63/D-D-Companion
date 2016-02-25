package evanwoodring.dd5ecompanion;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class DiceRollActivity extends NavBase {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice_roll);

        Button button = (Button) findViewById(R.id.diceRoll);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText diceNum = (EditText) findViewById(R.id.numDice);
                int diceNumValue = Integer.parseInt(diceNum.getText().toString());
                EditText diceSides = (EditText) findViewById(R.id.diceSides);
                int diceSidesValue = Integer.parseInt(diceSides.getText().toString());
                EditText mod = (EditText) findViewById(R.id.diceTotalMod);
                int modValue = 0;
                if (!(mod.getText().toString().isEmpty())) {
                    modValue = Integer.parseInt(mod.getText().toString());
                }

                EditText diceMod = (EditText) findViewById(R.id.diceMod);
                int diceModValue = 0;
                if (!(diceMod.getText().toString().isEmpty())) {
                    diceModValue = Integer.parseInt(diceMod.getText().toString());
                }

                int total = 0;
                String s = "";
                for (int i = 1; i <= diceNumValue; i++) {
                    int roll = (int) Math.ceil((Math.random() * diceSidesValue));
                    total += roll;
                    total += modValue;
                    s += "Roll " + i + ": " + roll + "\n";

                }
                total += diceModValue;
                s += "\nTotal: " + total + "\n";

                AlertDialog dialog = new AlertDialog.Builder(DiceRollActivity.this).setMessage(s).
                        setPositiveButton("Sure!", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).show();


                TextView textView = (TextView) dialog.findViewById(android.R.id.message);
                textView.setTextSize(20);
                textView.setGravity(Gravity.CENTER_HORIZONTAL);


            }
        });




    }

}
