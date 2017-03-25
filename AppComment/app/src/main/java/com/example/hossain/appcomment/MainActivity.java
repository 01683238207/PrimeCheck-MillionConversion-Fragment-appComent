package com.example.hossain.appcomment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1, btn2, btn3, btn4,btn5;
    EditText et1,et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initButton();
        initListener();
    }

    private void initListener() {
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
    }


    private void initButton() {
        btn1 = (Button) findViewById(R.id.svbt_1);
        btn2 = (Button) findViewById(R.id.delbt_2);
        btn3 = (Button) findViewById(R.id.showbt_3);
    }

    @Override
    public void onClick(View v) {
        DatabaseCon databaseCon;
        switch (v.getId()) {
            case R.id.svbt_1:
                et1=(EditText)findViewById(R.id.et_1);
                String s=et1.getText().toString();
                try {
                    databaseCon = new DatabaseCon(getApplicationContext());
                    SQLiteDatabase database = databaseCon.getWritableDatabase();
                    ContentValues values=new ContentValues();
                    values.put("cname",s);
                    database.insert("commenttab",null,values);
                    database.close();
                    databaseCon.close();
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.delbt_2:
                et2=(EditText)findViewById(R.id.et_2);
                String s2=et2.getText().toString();
                databaseCon = new DatabaseCon(getApplicationContext());
                SQLiteDatabase database = databaseCon.getReadableDatabase();
                database.delete("commenttab","cid=?",new String[]{s2});
                database.close();
                databaseCon.close();

                break;
            case R.id.showbt_3:
                TextView tv= (TextView) findViewById(R.id.tv);
                String s1=" ";
                try {
                    databaseCon = new DatabaseCon(getApplicationContext());
                    database = databaseCon.getReadableDatabase();
                    Cursor cursor=database.query("commenttab",null,null,null,null,null,null);
                    if(cursor.moveToFirst()){
                        do{
                            s1+=cursor.getInt(0)+" : "+cursor.getString(1)+" \n";
                        }while (cursor.moveToNext());
                    }
                    cursor.close();
                    database.close();
                    databaseCon.close();

                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
                }
                tv.setText(" "+s1);
                break;
        }
    }

    public class DatabaseCon extends SQLiteOpenHelper {
        private static final String DBName = "comments.db";
        private static final int DBVersion = 1;
        private static final String DB_Create_Table = "create table commenttab(cid integer primary key autoincrement,cname text not null)";

        public DatabaseCon(Context context) {
            super(context, DBName, null, DBVersion);
        }


        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DB_Create_Table);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("Drop table if exists commenttab");
            onCreate(db);
        }
    }

}
