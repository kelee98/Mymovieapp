package com.example.mymovieapp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CommentItemView extends LinearLayout {
    TextView textView;
    TextView textview2;

    public CommentItemView(Context context) {
        super(context);
        init(context);
    }

    public CommentItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context){
        LayoutInflater inflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.comment_item_view_xml,this,true);

        textView =(TextView)findViewById(R.id.textView);
        textview2=(TextView)findViewById(R.id.textView2);

    }
    public void setUser(String user){
        textView.setText(user);
    }

    public void setcontents(String contents){
        textview2.setText(contents);
    }
}
