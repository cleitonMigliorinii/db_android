package com.example.cleiton.livroleitura;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import vo.BookVO;

/**
 * Created by Cleiton on 18/03/2016.
 */
public class BookAdapter extends BaseAdapter {

    private Context context;
    private List<BookVO> list;

    public BookAdapter(Context context, List<BookVO> list){

        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return list.size();
    }

    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return list.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return list.get(arg0).getId();
    }

    @Override
    public View getView(int position, View arg1, ViewGroup arg2) {
        final int auxPosition = position;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final RelativeLayout layout = (RelativeLayout) inflater.inflate(R.layout.book_layout, null);

        TextView name = (TextView) layout.findViewById(R.id.layout_name);
        name.setText(list.get(position).getName());

        TextView author = (TextView) layout.findViewById(R.id.layout_author);
        author.setText(list.get(position).getAuthor());

        TextView publishingCompany = (TextView) layout.findViewById(R.id.layout_publishingCompany);
        publishingCompany.setText(list.get(position).getPublishingCompany());


        return layout;
    }

}
