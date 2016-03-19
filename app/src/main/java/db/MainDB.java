package db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Cleiton on 18/03/2016.
 */
public class MainDB extends SQLiteOpenHelper{

    public static final String NAME_DB = "livrosDb";
    public static final Integer VERSAO_DB = 1;

    public MainDB(Context context){
        super(context,NAME_DB,null,VERSAO_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table books(_id integer primary key autoincrement, name text not null,author text not null, publishingCompany text not null, score float)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table livros");
        onCreate(db);

    }
}
