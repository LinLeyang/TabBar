package com.wuba.tabbar;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * 2016-10-8 ViewPager+Fragment实现底部tab切换
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.vp);

        final List<String> list = new ArrayList();
        list.add("页面1");
        list.add("页面2");
        list.add("页面3");

        final List<View> viewList = new ArrayList();

        View view1 = LayoutInflater.from(this).inflate(R.layout.page1, null);
        View view2 = LayoutInflater.from(this).inflate(R.layout.page1, null);
        View view3 = LayoutInflater.from(this).inflate(R.layout.page1, null);
        View view4 = LayoutInflater.from(this).inflate(R.layout.page1, null);

        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);
        viewList.add(view4);

        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return viewList.size();
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                //String content = viewList.get(position);

//                View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.page1, null);
//                TextView textView = (TextView) view.findViewById(R.id.tv_content);
//                textView.setText(content);

                container.addView(viewList.get(position));
                return viewList.get(position);
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            public void destroyItem(ViewGroup container, int position,
                                    Object object) {
                container.removeView(viewList.get(position));
            }

        });

        viewPager.setCurrentItem(2);



    }


}
