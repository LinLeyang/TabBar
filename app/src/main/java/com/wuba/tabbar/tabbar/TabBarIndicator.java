package com.wuba.tabbar.tabbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wuba.tabbar.BarItemBean;
import com.wuba.tabbar.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linyueyang on 10/8/16.
 * <p/>
 * 主页面Tab控制器
 */
public class TabBarIndicator extends LinearLayout {

    Context context;
    List<BarItemBean> barItemBeanList = new ArrayList<>();
    LayoutInflater layoutInflater;
    OnItemClickListener onItemClickListener;

    public TabBarIndicator(Context paramContext) {
        this(paramContext, null);
        layoutInflater = LayoutInflater.from(paramContext);
        context = paramContext;
        //initView(paramContext);
    }

    public TabBarIndicator(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        layoutInflater = LayoutInflater.from(paramContext);
        context = paramContext;
        //initView(paramContext);
    }

    public void setBarItemList(List<BarItemBean> barItemBeanList) {
        this.barItemBeanList = barItemBeanList;
        if (null != barItemBeanList) {
            int i = 0;
            for (BarItemBean barItemBean : barItemBeanList) {
                addBarItem(barItemBean, i);
                i++;
            }
        }
    }

    public void setItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    /**
     * 点击tab图标时 当前被点击的变成选中状态，其他的变成未选中状态
     *
     * @param paramInt
     */
    public void setCurrentTab(int paramInt) {
        int count = getChildCount(); //获取TabBarIndicator子View数
        if (paramInt < 0 || paramInt >= count) {
            return;
        }
        for (int i = 0; i < count; i++) {
            Object localObject = getChildAt(i).getTag();
            ViewHolder localViewHolder;
            if ((localObject != null) && ((localObject instanceof ViewHolder))) {
                localViewHolder = (ViewHolder) localObject;
                if ((localViewHolder.barItemBean != null) && (localViewHolder.tabIcon != null)) {
                    if (localViewHolder.index != paramInt) {
                        if (localViewHolder.barItemBean.getImage() > 0) {
                            localViewHolder.tabIcon.setImageResource(localViewHolder.barItemBean.getImage());
                        }
                        localViewHolder.tabTitle.setTextColor(context.getResources().getColor(R.color.home_tab_text_normal_color, null));
                    } else {
                        if (localViewHolder.barItemBean.getImage_selected() > 0) {
                            localViewHolder.tabIcon.setImageResource(localViewHolder.barItemBean.getImage_selected());
                        }
                        localViewHolder.tabTitle.setTextColor(context.getResources().getColor(R.color.home_tab_text_selected_color, null));
                    }
                }
            }
        }
    }

    private void addBarItem(BarItemBean barItemBean, final int position) {
        ViewHolder viewHolder = new ViewHolder();
        View itemView = layoutInflater.inflate(R.layout.bar_item, null);
        viewHolder.barItemBean = barItemBean;
        viewHolder.index = position;
        viewHolder.tabIcon = (ImageView) itemView.findViewById(R.id.iv_bar_item);
        viewHolder.tabTitle = (TextView) itemView.findViewById(R.id.tv_bar_item);
        itemView.setTag(viewHolder);

        if (barItemBean.getImage() > 0) {
            viewHolder.tabIcon.setImageResource(barItemBean.getImage());
        } else {
            viewHolder.tabIcon.setVisibility(GONE);
        }
        viewHolder.tabTitle.setText(barItemBean.getText());
        itemView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.click(position);
            }
        });

        addView(itemView, new LayoutParams(-1, -1, 1.0F));//weight设为1
    }


    private static class ViewHolder {
        public BarItemBean barItemBean;
        public int index;
        public ImageView tabIcon;
        public TextView tabTitle;
        public TextView tabNewTag;
    }

    public interface OnItemClickListener {
        void click(int index);
    }

}
