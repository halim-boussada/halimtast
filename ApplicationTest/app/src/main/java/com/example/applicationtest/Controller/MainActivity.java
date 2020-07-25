package com.example.applicationtest.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.applicationtest.Model.User;
import com.example.applicationtest.R;

public class MainActivity extends AppCompatActivity {
    private TextView mGreetingText;
    private EditText mNameInput;
    private Button mPlayButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mGreetingText = (TextView) findViewById(R.id.tex);
        mNameInput = (EditText) findViewById(R.id.nom);
        mPlayButton = (Button) findViewById(R.id.buttonPlay);
        mPlayButton.setEnabled(false);
        mNameInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mPlayButton.setEnabled(mNameInput.length()>0);

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstname = mNameInput.getText().toString();
                User A = new User();
                A.setFirstname(firstname);
                final Intent intent = new Intent();
                intent.setClass(MainActivity.this, activity2.class);
                startActivity(intent);
            }
        });
    }

}