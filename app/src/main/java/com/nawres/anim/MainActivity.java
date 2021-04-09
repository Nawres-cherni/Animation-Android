package com.nawres.anim;





import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.nawres.anim.fragments.Pagefragment1;
import com.nawres.anim.fragments.Pagefragment2;
import com.nawres.anim.fragments.Pagefragment3;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
   private ViewPager pager;
   private PagerAdapter pagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        List<Fragment> list = new ArrayList<>();
        list.add(new Pagefragment1());
        list.add(new Pagefragment2());
        list.add(new Pagefragment3());
        pager=findViewById(R.id.pager);
        pagerAdapter=new  SiderPageAdapter(getSupportFragmentManager(),list);
        pager.setAdapter(pagerAdapter);


        backgroundDesign();

    }


    private void backgroundDesign(){
        LinearLayout ll=findViewById(R.id.layout);
        AnimationDrawable animated = (AnimationDrawable) ll.getBackground();
        animated.setEnterFadeDuration(2000);
        animated.setExitFadeDuration(4000);
        animated.start();
    }

}