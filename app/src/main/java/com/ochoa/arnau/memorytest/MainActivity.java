package com.ochoa.arnau.memorytest;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.material.joanbarroso.flipper.CoolImageFlipper;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadFactory;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int size = 16;
    Boolean isFirst = true;
    Boolean[] isFaceDown = new Boolean[size];

    int turn = 0;
    int cardsFaceUp = 0;

    CoolImageFlipper flipper;

    View layout;

    //@BindDrawable(R.drawable.back_card) Drawable cardBack; //drawable carta al reves

    Drawable cardBack;

    Integer[] cardImages = new Integer[size/2];
    Integer[] cardFaces = new Integer[size];

    int lastCard;

    Drawable img0, img1, img2, img3, img4, img5, img6, img7;

    Drawable[] images; //array amb totes les imatges duplicades

    Drawable[] card = new Drawable[size]; //array amb totes les imatges duplicades i desordenades

    ImageView card0, card1, card2, card3, card4, card5, card6, card7, card8, card9, card10,
            card11, card12, card13, card14, card15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.activity_main);
        flipper = new CoolImageFlipper(this);

        setCards();
        shuffleCards();
    }

    private void setCards(){
        cardBack = getResources().getDrawable(R.drawable.back_card);

        for(int i = 0; i < size; i++){
            isFaceDown[i] = true;
        }

        cardImages[0] = R.drawable.ic_black_jack;
        cardImages[1] = R.drawable.ic_diamonf;
        cardImages[2] = R.drawable.ic_gambler;
        cardImages[3] = R.drawable.ic_playing_cards;
        cardImages[4] = R.drawable.ic_black_jack;
        cardImages[5] = R.drawable.ic_diamonf;
        cardImages[6] = R.drawable.ic_gambler;
        cardImages[7] = R.drawable.ic_playing_cards;

        for (int i = 0; i < (size/2); i++){
            cardFaces[i*2] = cardImages[i];
            cardFaces[(i*2)+1] = cardImages[i];
        }

        card0 = (ImageView) findViewById(R.id.card0);
        card1 = (ImageView) findViewById(R.id.card1);
        card2 = (ImageView) findViewById(R.id.card2);
        card3 = (ImageView) findViewById(R.id.card3);
        card4 = (ImageView) findViewById(R.id.card4);
        card5 = (ImageView) findViewById(R.id.card5);
        card6 = (ImageView) findViewById(R.id.card6);
        card7 = (ImageView) findViewById(R.id.card7);
        card8 = (ImageView) findViewById(R.id.card8);
        card9 = (ImageView) findViewById(R.id.card9);
        card10 = (ImageView) findViewById(R.id.card10);
        card11 = (ImageView) findViewById(R.id.card11);
        card12 = (ImageView) findViewById(R.id.card12);
        card13 = (ImageView) findViewById(R.id.card13);
        card14 = (ImageView) findViewById(R.id.card14);
        card15 = (ImageView) findViewById(R.id.card15);

        card0.setOnClickListener(this);
        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);
        card5.setOnClickListener(this);
        card6.setOnClickListener(this);
        card7.setOnClickListener(this);
        card8.setOnClickListener(this);
        card9.setOnClickListener(this);
        card10.setOnClickListener(this);
        card11.setOnClickListener(this);
        card12.setOnClickListener(this);
        card13.setOnClickListener(this);
        card14.setOnClickListener(this);
        card15.setOnClickListener(this);
    }

    private void shuffleCards() {
        List<Integer> imagesList = Arrays.asList(cardFaces);
        Collections.shuffle(imagesList);
        imagesList.toArray(cardFaces);
    }

    private void clickImage (View view, int img){
        if (isFaceDown[img]) {
            if(isFirst) {
                flip(view, img);
                lastCard = img;
                isFaceDown[img] = false;
                isFirst = false;
            }else {
                flip(view, img);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                turn++;
                if (lastCard != cardFaces[img]){
                    flip(view, lastCard);
                    flip(view, img);
                }else{
                    cardsFaceUp += 2;
                    if (cardsFaceUp == size){
                        View.OnClickListener myOnClickListener = new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(i);
                            }
                        };
                        Snackbar.make(layout, "Congratulations!! You've done it in:" + String.valueOf(cardsFaceUp/2), Snackbar.LENGTH_LONG)
                                .setAction("RETRY", myOnClickListener)
                                .show();
                    }
                }

                isFirst = true;
                isFaceDown[img] = false;
            }
        }
    }

    private void flip(View view, int img) {
        if(isFaceDown[img]){
            flipper.flipImage( getResources().getDrawable(cardFaces[img]), ((ImageView) view));

        }else{
            flipper.flipImage(cardBack, ((ImageView) view));
        }
        isFaceDown[img] = !isFaceDown[img];
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.card0:
                clickImage(v, 0);
                break;
            case R.id.card1:
                clickImage(v, 1);
                break;
            case R.id.card2:
                clickImage(v, 2);
                break;
            case R.id.card3:
                clickImage(v, 3);
                break;
            case R.id.card4:
                clickImage(v, 4);
                break;
            case R.id.card5:
                clickImage(v, 5);
                break;
            case R.id.card6:
                clickImage(v, 6);
                break;
            case R.id.card7:
                clickImage(v, 7);
                break;
            case R.id.card8:
                clickImage(v, 8);
                break;
            case R.id.card9:
                clickImage(v, 9);
                break;
            case R.id.card10:
                clickImage(v, 10);
                break;
            case R.id.card11:
                clickImage(v, 11);
                break;
            case R.id.card12:
                clickImage(v, 12);
                break;
            case R.id.card13:
                clickImage(v, 13);
                break;
            case R.id.card14:
                clickImage(v, 14);
                break;
            case R.id.card15:
                clickImage(v, 15);
                break;
        }

    }
}

