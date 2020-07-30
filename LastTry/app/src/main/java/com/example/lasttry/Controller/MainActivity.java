package com.example.lasttry.Controller;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.example.lasttry.Model.ListTrip;
import com.example.lasttry.Model.Trip;
import com.example.lasttry.R;

import java.util.Arrays;


@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class MainActivity extends AppCompatActivity {
    private Trip Amazigh = new Trip("Amazigh","Description de trip amazigh atecdf azfhhfak aegdsghdj  ddfdf",R.drawable.amzigh);
    private Trip Carthage = new Trip("Carthage","Description de trip amazigh atecdf azfhhfak aegdsghdj  ddfdf",R.drawable.carthage);
    private Trip Bay = new Trip("Bay","Description de trip amazigh atecdf azfhhfak aegdsghdj  ddfdf",R.drawable.beyet);
    private ListTrip mListTrip=new ListTrip(Arrays.asList(Amazigh,Carthage,Bay));
    ConstraintLayout mConstraintLayout;
    Button mPrevious;
    Button mNext;
    private TextView title;
    private TextView description;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mConstraintLayout=(ConstraintLayout) findViewById(R.id.Trips);
        mPrevious=(Button) findViewById(R.id.precedent);
        mNext=(Button) findViewById(R.id.suivant) ;
        title=(TextView) findViewById(R.id.textView44) ;
        description = (TextView) findViewById(R.id.textView45);
        mPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Trip onClickTrip = mListTrip.GetPreviousTrip();
                description.setText(onClickTrip.getDescription());
                title.setText(onClickTrip.getTitle());
                mConstraintLayout.setBackground(getDrawable(onClickTrip.getImage()));
            }
        });
        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Trip onClickTrip = mListTrip.GetNextTrip();
                title.setText(onClickTrip.getTitle());
                description.setText(onClickTrip.getDescription());
                mConstraintLayout.setBackground(getDrawable(onClickTrip.getImage()));

            }
        });
        {

        }



    }
}