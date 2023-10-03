package com.example.carousel_img_app;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    Button prevButton, nextButton;
    TextView overReviewText;
    private int[] imageIds = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5};
    public int[] OverviewIds = {R.string.overview_1, R.string.overview_2, R.string.overview_3, R.string.overview_4, R.string.overview_5};
    int currentImageIndex = 0;
    int currentOverviewIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();
        imageView.setImageResource(imageIds[currentImageIndex]);
        overReviewText.setText(OverviewIds[currentOverviewIndex]);
        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currentImageIndex > 0 && currentOverviewIndex > 0){
                    currentImageIndex--;
                    currentOverviewIndex--;
                    imageView.setImageResource(imageIds[currentImageIndex]);
                    overReviewText.setText(OverviewIds[currentOverviewIndex]);
                }
                else{
                    Toast.makeText(MainActivity.this, "This is the first car", Toast.LENGTH_SHORT).show();
                }
            }
        });
        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (currentImageIndex < imageIds.length - 1 && currentOverviewIndex < OverviewIds.length - 1) {
                    currentImageIndex++;
                    currentOverviewIndex++;
                    imageView.setImageResource(imageIds[currentImageIndex]);
                    overReviewText.setText(OverviewIds[currentOverviewIndex]);
                }
                else {
                    Toast.makeText(MainActivity.this, "This is the last car", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    protected void mapping(){
        imageView = (ImageView)findViewById(R.id.imageView);
        prevButton = (Button)findViewById(R.id.prevButton);
        nextButton = (Button)findViewById(R.id.nextButton);
        overReviewText = (TextView)findViewById(R.id.overReviewText);
    }
}