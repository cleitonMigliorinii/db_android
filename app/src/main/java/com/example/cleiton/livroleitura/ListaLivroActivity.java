package com.example.cleiton.livroleitura;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;

import db.CoreDB;
import vo.BookVO;

public class ListaLivroActivity extends ListActivity {

    private ListView listBook;
    private ArrayAdapter<BookVO> adpBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_lista_livro);

        CoreDB coreDB = new CoreDB(this);
        listBook =  (ListView) findViewById(R.id.listBook);

        setListAdapter(new BookAdapter(this,coreDB.getBook()));

//        final Button button = (Button) findViewById(R.id.btn_new_book);
//        button.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                startFormBook(v);
//            }
//        });



    }


    public void startFormBook(View view) {

        Intent secondActivity = new Intent(this, FormBookActivity.class);
        startActivity(secondActivity);
    }
}
