package com.example.sasha.lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    TextView tvInfo, valuesInfo;
    EditText etInput;
    Button bControl;

    int guess;
    int times = 0;
    boolean gameFinished;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInfo = (TextView)findViewById(R.id.textView);
        etInput = (EditText)findViewById(R.id.editText);
        bControl = (Button)findViewById(R.id.button);
        valuesInfo = (TextView)findViewById(R.id.textView2);

        guess = (int)(Math.random()*100);
        gameFinished = false;
    }

    public void onClick(View v){
        if(etInput.getText().toString().length()==0 && !gameFinished )
        {
            Toast toast = Toast.makeText(getApplicationContext(), getResources().getString(R.string.errorInput), Toast.LENGTH_SHORT);
            toast.show();
        }
        else
        {
            if (!gameFinished){
            int inp=Integer.parseInt(etInput.getText().toString());
            if (inp > 100 || inp < 1)
            {
                Toast toast = Toast.makeText(getApplicationContext(),getResources().getString(R.string.errorNumber), Toast.LENGTH_SHORT);
                toast.show();
            }
            else
            {
                times++;
                valuesInfo.setText(valuesInfo.getText() + etInput.getText().toString() + " ");
                if (inp > guess)
                    tvInfo.setText(getResources().getString(R.string.ahead));
                else
                {
                if (inp < guess)
                    tvInfo.setText(getResources().getString(R.string.behind));

                tvInfo.setText(getResources().getString(R.string.hit) + getResources().getString(R.string.attempt) + times);
                bControl.setText(getResources().getString(R.string.play_more));
                gameFinished = true;
                valuesInfo.setText(getResources().getString(R.string.lastvalues));
                }

            }
        }
        else
        {
            guess = (int)(Math.random()*100);
            bControl.setText(getResources().getString(R.string.input_value));
            tvInfo.setText(getResources().getString(R.string.try_to_guess));
            gameFinished = false;
        }
        etInput.setText("");

        }
    }
    public void onClose(View v){
        this.finish();
    }

}
