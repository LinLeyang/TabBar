package com.wuba.tabbar.tabbar;

import com.wuba.tabbar.BarItemBean;
import com.wuba.tabbar.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linyueyang on 10/10/16.
 */
public class TabBarUtil {

    public static List<BarItemBean> creatBarData() {
        List<BarItemBean> barItemBeanList = new ArrayList<>();

        BarItemBean barItemBean = new BarItemBean(R.drawable.main_tab_record_normal, R.drawable.main_tab_record_selected, "首页", R.color.blue, R.color.red);
        barItemBeanList.add(barItemBean);
        barItemBean = new BarItemBean(R.drawable.main_tab_calendar_normal, R.drawable.main_tab_calendar_selected, "日历", R.color.blue, R.color.red);
        barItemBeanList.add(barItemBean);
        barItemBean = new BarItemBean(R.drawable.main_tab_statistical_normal, R.drawable.main_tab_statistical_selected, "统计", R.color.blue, R.color.red);
        barItemBeanList.add(barItemBean);

        return barItemBeanList;
    }

}
