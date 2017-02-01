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

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Boolean isFirst = true;
    Boolean isFaceDown = true;

    int size = 8;

    private CoolImageFlipper flipper;

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

        img0 = getResources().getDrawable(R.drawable.ic_adb_black_24dp);
        img1 = getResources().getDrawable(R.drawable.ic_android_black_24dp);
        img2 = getResources().getDrawable(R.drawable.ic_assignment_late_black_24dp);
        img3 = getResources().getDrawable(R.drawable.ic_attach_money_black_24dp);
        img4 = getResources().getDrawable(R.drawable.ic_bug_report_black_24dp);
        img5 = getResources().getDrawable(R.drawable.ic_contacts_black_24dp);
        img6 = getResources().getDrawable(R.drawable.ic_directions_walk_black_24dp);
        img7 = getResources().getDrawable(R.drawable.ic_new_releases_black_24dp);

        images = new Drawable[]{img0, img1, img2, img3, img4, img5, img6, img7};

        shuffleCards();
    }

    /*
    passa array a list i duplica list
     */
    private List<Drawable> setImagesList(Drawable [] images) {
        List<Drawable> imagesList = Arrays.asList(images);
        List<Drawable> cardsList = imagesList;
        cardsList.addAll(imagesList);
        return imagesList;
    }

    private void shuffleCards() {
        List<Drawable> imagesList = setImagesList(images);
        Collections.shuffle(imagesList);
        imagesList.toArray(card);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.card0:
                break;
            case R.id.card1:
                break;
            case R.id.card2:
                break;
            case R.id.card3:
                break;
            case R.id.card4:
                break;
            case R.id.card5:
                break;
            case R.id.card6:
                break;
            case R.id.card7:
                break;
            case R.id.card8:
                break;
            case R.id.card9:
                break;
            case R.id.card10:
                break;
            case R.id.card11:
                break;
            case R.id.card12:
                break;
            case R.id.card13:
                break;
            case R.id.card14:
                break;
            case R.id.card15:
                break;
        }
    }

    private void clickImage (View view, int img){
        if (isFaceDown) {
                flip(view, img);
        }
    }

    private void flip(View view, int img) {
        if(!isFaceDown){
            flipper.flipImage( card[img], ((ImageView) view));

        }else{
            flipper.flipImage(backCard, ((ImageView) view));
        }
    }
}

