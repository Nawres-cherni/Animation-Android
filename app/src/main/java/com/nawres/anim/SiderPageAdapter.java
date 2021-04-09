package com.nawres.anim;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

public class SiderPageAdapter  extends FragmentStatePagerAdapter {
private List<Fragment> fragmentList;
   public SiderPageAdapter(FragmentManager fm,List<Fragment> fragmentList){
   super(fm);
       this.fragmentList=fragmentList;
   }

    //@NonNull
    @Override
    public Fragment getItem(int position)
    {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
      return   fragmentList.size();
    }
}
