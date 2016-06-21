package com.katekit.common.util;

import android.util.SparseArray;
import android.view.View;

/**
 * Project Name: m4399_YouPai
 * File Name:    ViewHolderUtil.java
 * ClassName:    ViewHolderUtil
 * <p>
 * Description: 适配器的getview超简写法.
 *
 * @author HMC
 * @date 2015-4-10 下午9:25:51
 */
public class ViewHolderUtil {
    @SuppressWarnings("unchecked")
    public static <T extends View> T get(View view, int id) {
        SparseArray<View> viewHolder = (SparseArray<View>) view.getTag();
        if (viewHolder == null) {
            viewHolder = new SparseArray<View>();
            view.setTag(viewHolder);
        }
        View childView = viewHolder.get(id);
        if (childView == null) {
            childView = view.findViewById(id);
            viewHolder.put(id, childView);
        }
        return (T) childView;
    }
//	写法
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent)
//    {
//
//	if (convertView == null)
//	{
//	    convertView = LayoutInflater
//		    .from(context)
//		    .inflate(R.layout.banana_phone, parent, false);
//	}
//
//	ImageView bananaView = ViewHolder.get(convertView, R.id.banana);
//	TextView phoneView = ViewHolder.get(convertView, R.id.phone);
//
//	BananaPhone bananaPhone = getItem(position);
//	phoneView.setText(bananaPhone.getPhone());
//	bananaView.setImageResource(bananaPhone.getBanana());
//
//	return convertView;
//    }
}
