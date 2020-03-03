package com.example.mymovieapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.BundleCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.mymovieapp.R;

import org.w3c.dom.Text;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button likeButton;
    Button dislikeButton;
    Button writeButton;
    RatingBar ratingBar;

    TextView likeCountView;
    TextView dislikeCountView;

    ListView listView;

    int likeCount = 1;
    int dislikeCount=1;
    boolean likeState = false;
    boolean dislikeState=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ratingBar = (RatingBar) findViewById(R.id.ratingBar1);
        listView=(ListView)findViewById(R.id.listView);
        CommentAdapter adapter=new CommentAdapter();
        listView.setAdapter(adapter);


        likeButton = (Button) findViewById(R.id.likeButton);
        dislikeButton = (Button) findViewById(R.id.dislikeButton);
        writeButton = (Button) findViewById(R.id.writeButton);

        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (likeState) {
                    decrLikeCount();
                } else {
                    incrLikeCount();
                    if (dislikeState == true) {
                        decrdisLikeCount();
                        dislikeState = !dislikeState;
                    }
                }

                likeState = !likeState;
            }

        });
        dislikeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dislikeState) {
                    decrdisLikeCount();
                } else {
                    incrdisLikeCount();
                    if (likeState == true) {
                        decrLikeCount();
                        likeState = !likeState;
                    }
                }
                dislikeState = !dislikeState;
            }

        });

        writeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCommentWriteActivity();
            }

        });
    }

    class CommentAdapter extends BaseAdapter{

        ArrayList<CommentItem> items =new ArrayList<CommentItem>();

        @Override
        public int getCount() {

            return items.size();
        }
        public void addItem(CommentItem item){
            items.add(item);
        }

        @Override
        public Object getItem(int position) {

            return items.get(position);
        }

        @Override
        public long getItemId(int position) {

            return position;
        }

        @Override
        public View getView(int position, View convertview, ViewGroup parent) {

            CommentItemView view =new CommentItemView(getApplicationContext());
            CommentItem item =items.get(position);

            view.setUser(item.getUser());
            view.setcontents(item.getContents());
            return view;
        }
    }


    public void incrLikeCount(){
        likeCount += 1;
        likeCountView.setText(String.valueOf(likeCount));

        likeButton.setBackgroundResource(R.drawable.ic_thumb_up_selected);
    }

    public void decrLikeCount(){
        likeCount -= 1;
        likeCountView.setText(String.valueOf((likeCount)));

        likeButton.setBackgroundResource(R.drawable.thumbs_up_selector);
    }
    public void incrdisLikeCount(){
        dislikeCount +=1;
        dislikeCountView.setText(String.valueOf(dislikeCount));

        dislikeButton.setBackgroundResource(R.drawable.ic_thumb_down_selected);

    }
    public void decrdisLikeCount(){
        dislikeCount -=1;
        dislikeCountView.setText(String.valueOf(dislikeCount));

        dislikeButton.setBackgroundResource(R.drawable.thumbs_down_selector);
    }
    public void showCommentWriteActivity(){
        float rating =ratingBar.getRating();
        Intent intent = new Intent(getApplicationContext(),CommentWriteActivity.class);
        intent.putExtra("rating",rating);
        startActivityForResult(intent,101);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if(requestCode==101){
            if(intent !=null){
                String contents=intent.getStringExtra("contents");

            }
        }

    }
}