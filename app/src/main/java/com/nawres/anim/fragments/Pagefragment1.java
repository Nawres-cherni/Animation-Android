package com.nawres.anim.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.nawres.anim.R;

public class Pagefragment1 extends Fragment {
    private TextView mTextView;
    private ImageView image;
    private CardView card;
    private   Button buttonAnimate ;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        ViewGroup rootView= (ViewGroup)inflater.inflate(R.layout.pager_1,container,false);

        mTextView =(TextView) rootView.findViewById(R.id.text_view);
        image =(ImageView) rootView.findViewById(R.id.img);
        card =(CardView) rootView.findViewById(R.id.card_view);
         buttonAnimate = (Button) rootView.findViewById(R.id.button_animate);
        buttonAnimate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YoYo.with(Techniques.SlideInDown)
                        .duration(1700)
                        .repeat(1)
                        .playOn(card);

                YoYo.with(Techniques.SlideInUp)
                        .duration(1700)
                        .repeat(1)
                        .playOn(mTextView);
            }
        });

        return rootView;
    }
}
