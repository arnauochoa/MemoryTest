package com.ochoa.arnau.memorytest;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.material.joanbarroso.flipper.CoolImageFlipper;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import butterknife.BindDrawable;
import butterknife.BindViews;

import static java.util.Collections.addAll;

public class MainActivity extends AppCompatActivity{

    Boolean isFirst = true;
    Boolean[] isFaceDown = new Boolean[16];

    int size = 8;

    CoolImageFlipper flipper;

    //@BindDrawable(R.drawable.back_card) Drawable backCard; //drawable carta al reves

    Drawable backCard;

    Drawable img0;
    Drawable img1;
    Drawable img2;
    Drawable img3;
    Drawable img4;
    Drawable img5;
    Drawable img6;
    Drawable img7;

    Drawable[] images; //array amb totes les imatges

    Drawable[] card = new Drawable[size*2]; //array amb totes les imatges duplicades

    @BindViews({R.id.card0, R.id.card1, R.id.card2, R.id.card3, R.id.card4, R.id.card5, R.id.card6,
            R.id.card7, R.id.card8, R.id.card9, R.id.card10, R.id.card11, R.id.card12, R.id.card13,
            R.id.card14, R.id.card15})
    List<ImageView> cardsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flipper = new CoolImageFlipper(this);

        backCard = getResources().getDrawable(R.drawable.back_card);

        img0 = getResources().getDrawable(R.drawable.ic_black_jack);
        img1 = getResources().getDrawable(R.drawable.ic_diamonf);
        img2 = getResources().getDrawable(R.drawable.ic_gambler);
        img3 = getResources().getDrawable(R.drawable.ic_playing_cards);
        img4 = getResources().getDrawable(R.drawable.ic_black_jack);
        img5 = getResources().getDrawable(R.drawable.ic_diamonf);
        img6 = getResources().getDrawable(R.drawable.ic_gambler);
        img7 = getResources().getDrawable(R.drawable.ic_playing_cards);

        images = new Drawable[]{img0, img1, img2, img3, img4, img5, img6, img7,
                                img0, img1, img2, img3, img4, img5, img6, img7,};

        for(int i = 0; i < 16; i++){
            isFaceDown[i] = true;
        }

        shuffleCards();
    }

    private void shuffleCards() {
        List<Drawable> imagesList = Arrays.asList(images);
        Collections.shuffle(imagesList);
        imagesList.toArray(card);
    }

    public void clicked(View v) {
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

    private void clickImage (View view, int img){
        if (isFaceDown[img]) {
            if(isFirst) {
                flip(view, img);
                isFaceDown[img] = false;
                isFirst = false;
            }else {
                flip(view, img);
                isFirst = true;
                isFaceDown[img] = false;
            }
        }
    }

    private void flip(View view, int img) {
        if(isFaceDown[img]){
            flipper.flipImage( card[img], ((ImageView) view));

        }else{
            flipper.flipImage(backCard, ((ImageView) view));
        }
        isFaceDown[img] = !isFaceDown[img];
    }
}

