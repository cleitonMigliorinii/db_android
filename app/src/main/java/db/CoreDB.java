package db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import vo.BookVO;

/**
 * Created by Cleiton on 18/03/2016.
 */
public class CoreDB {

    private SQLiteDatabase db;


    public CoreDB(Context context){

        MainDB mainDB = new MainDB(context);
        db = mainDB.getWritableDatabase();

    }


    public void insert(BookVO book){

        ContentValues values = new ContentValues();
        values.put("name",book.getName());
        values.put("author",book.getAuthor());
        values.put("publishingCompany",book.getPublishingCompany());
        values.put("score",book.getScore());

        db.insert("books",null,values);

    }

    public List<BookVO> getBook(){
        List<BookVO> listBooks = new ArrayList<BookVO>();

        String[] colunas = new String[]{"_id","name","author","publishingCompany","score"};
        Cursor cursor = db.query("books",colunas,null,null,null,null,null);

        if(cursor.getCount() > 0){
            cursor.moveToFirst();

            do{

                BookVO book = new BookVO();

                book.setId(cursor.getLong(0));
                book.setName(cursor.getString(1));
                book.setAuthor(cursor.getString(2));
                book.setPublishingCompany(cursor.getString(3));
                book.setScore(cursor.getDouble(4));

                listBooks.add(book);

            }while (cursor.moveToNext());


        }

        return listBooks;
    }

}
