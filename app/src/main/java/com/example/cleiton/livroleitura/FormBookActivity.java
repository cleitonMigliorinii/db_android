package com.example.cleiton.livroleitura;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import db.CoreDB;
import vo.BookVO;

public class FormBookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_book);

        final Button button = (Button) findViewById(R.id.btn_insert);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                insertBook();
            }
        });
    }


    public void insertBook(){

        CoreDB coreDB = new CoreDB(this);

        TextView nameBook = (TextView) findViewById(R.id.nameBook);
        TextView authorBook = (TextView) findViewById(R.id.authorBook);
        TextView publishingCompany = (TextView) findViewById(R.id.publishingCompany);
        RatingBar scoreBook = (RatingBar) findViewById(R.id.scoreBook);

        BookVO book = new BookVO();

        book.setName(nameBook.getText().toString());
        book.setAuthor(authorBook.getText().toString());
        book.setPublishingCompany(publishingCompany.getText().toString());
        book.setScore(Double.valueOf(scoreBook.getRating()));

        coreDB.insert(book);

    }

}
