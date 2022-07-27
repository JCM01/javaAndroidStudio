package com.lm2a.expr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private CommentsDataSource datasource;
    private static final String TAG = "MyTag";

    String breakLine = "\\n";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button a = findViewById(R.id.add);
        Button d = findViewById(R.id.delete);
        Button all = findViewById(R.id.all);

        TextView tvList = findViewById(R.id.tv_list);

        datasource = new CommentsDataSource(this);
        datasource.open();

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addOne();
            }
        });

        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Comment> values = datasource.getAllComments();
                datasource.deleteComment(values.get(0));
            }
        });

        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Comment> values = datasource.getAllComments();
                String l = getLista(values);
                tvList.setText(l);
            }
        });

    }

    public void addTen(){
        for(int i=0; i<10; ++i) {
            String c = getAComment();
            datasource.createComment(c);
        }
    }

    public void addOne(){
            String c = getAComment();
            datasource.createComment(c);
    }

    public String getAComment(){
        String[] comments = new String[] { "Cool", "Very nice", "Hate it" };
        int nextInt = new Random().nextInt(3);
        return comments[nextInt];
    }

    public String getLista(List<Comment> comments){
        String commentList = "";
        for(Comment c: comments){
            commentList = commentList + c.getId()+" - "+c.getComment()+breakLine;
        }
        return commentList.replace("\\n", "\n");
    }
}