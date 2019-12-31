package com.bawei.zhangao1708a20191231.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.zhangao1708a20191231.R;
import com.bawei.zhangao1708a20191231.bean.DateBean;

import java.util.List;

/**
 * author: 张奥
 * data: 2019-12-31
 * function:构造适配器 展示多条慕
 */
public class MyAdapter extends BaseAdapter {
    private List <DateBean.SmsesBean> list;
    int item_layout=0;
    int items_layout=1;
    public MyAdapter(List <DateBean.SmsesBean> list) {

        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get( position );
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return 2;

    }

    @Override
    public int getItemViewType(int position) {
        int isread = list.get( position ).getIsread();
        /*核心）判断接口中的isread字段，
        值是1代表已读不显示图1列表中左侧小圆点，
        2代表未读显示图1列表中左侧小圆点，完成多条目显示效果*/
        if(isread==1){
            return item_layout;
        }else if(isread==2){
            return items_layout;
        }
        return item_layout;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Viewhodles viewhodles = null;
        int type = getItemViewType( position );
        if(type==0){
            if (convertView == null) {
                viewhodles = new Viewhodles();
                convertView= View.inflate(parent.getContext(), R.layout.item_layout,null);
                viewhodles.imageView=convertView.findViewById( R.id.list_img );
                viewhodles.textView=convertView.findViewById( R.id.list_name );
                viewhodles.title=convertView.findViewById( R.id.list_title );
                convertView.setTag( viewhodles );
            }else{
                viewhodles= (Viewhodles) convertView.getTag();
            }
        }else if(type==1){
            if (convertView == null) {
                viewhodles = new Viewhodles();
                convertView= View.inflate(parent.getContext(), R.layout.items_layout,null);
                viewhodles.textView=convertView.findViewById( R.id.list_name );
                viewhodles.title=convertView.findViewById( R.id.list_title );
                convertView.setTag( viewhodles );
            }else{
                viewhodles= (Viewhodles) convertView.getTag();
            }
        }
            viewhodles.title.setText( list.get( position ).getFrom() );
            viewhodles.textView.setText( list.get( position ).getContent() );

        return convertView;
    }

    private class Viewhodles {
        TextView textView;
        TextView title;
        ImageView imageView;
    }
}
