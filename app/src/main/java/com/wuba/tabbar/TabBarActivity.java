package com.wuba.tabbar;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.wuba.tabbar.tabbar.TabBarIndicator;
import com.wuba.tabbar.tabbar.TabBarUtil;

import java.util.ArrayList;

public class TabBarActivity extends AppCompatActivity {


    ViewPager viewPager;
    TabBarIndicator tabBarIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        viewPager = (ViewPager) findViewById(R.id.vp);
        tabBarIndicator = (TabBarIndicator) findViewById(R.id.tbi);




        final ArrayList<Fragment> mFragmentList = new ArrayList();
        mFragmentList.add(new BlankFragment());
        mFragmentList.add(new BlankFragment2());
        mFragmentList.add(new BlankFragment3());

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragmentList.get(position);
            }

            @Override
            public int getCount() {
                return mFragmentList.size();
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //Toast.makeText(TabBarActivity.this, "onPageScrolled" + position, Toast.LENGTH_SHORT).show();111
            }

            @Override
            public void onPageSelected(int position) {
                tabBarIndicator.setCurrentTab(position);
                //Toast.makeText(TabBarActivity.this, "onPageSelected" + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        tabBarIndicator.setBarItemList(TabBarUtil.creatBarData());
        tabBarIndicator.setItemClickListener(new TabBarIndicator.OnItemClickListener() {
            @Override
            public void click(int index) {
                viewPager.setCurrentItem(index);
            }
        });
        tabBarIndicator.setCurrentTab(0);

    }


}
