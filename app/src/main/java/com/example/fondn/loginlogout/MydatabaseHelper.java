package com.example.fondn.loginlogout;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;


public class MydatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Sagor";
    public static final String TABLE_NAME = "user_detrails";
    public static final String EMAIL = "email";
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String USER_NAME = "user_name";
    public static final String PASSWORD = "password";
    public static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+"("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+NAME+" TEXT(255),"+EMAIL+" TEXT ,"+USER_NAME+" TEXT,"+PASSWORD+" TEXT);";
    public static final int Verstion = 1;
    private static final String DROP_TABLE = "drop table if exists "+TABLE_NAME;
    Context c;
    public MydatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, Verstion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
            db.execSQL(CREATE_TABLE);
            //Toast.makeText(c, "Oncreate called", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
          //  Toast.makeText(c, "Oncreate not failed", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(DROP_TABLE);
            onCreate(db);

    }

    public long insertData(UserData userData){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put(NAME,userData.getName());
        c.put(EMAIL,userData.getEmail());
        c.put(USER_NAME,userData.getUsername());
        c.put(PASSWORD,userData.getPasword());
        long rowID = database.insert(TABLE_NAME,null,c);
        return rowID;

    }

   public Boolean findpasswordanduserName(String userNameP,String passowrdP){
        SQLiteDatabase database = this.getReadableDatabase();
       Cursor cursor = database.rawQuery("select * from "+TABLE_NAME,null);
       Boolean result = false;

       if(cursor.getCount()==0){
           Toast.makeText(c, "No Data Found", Toast.LENGTH_SHORT).show();
       }else{
           while (cursor.moveToNext()){
               String useName = cursor.getString(3);
               String pass = cursor.getString(4);

               if(useName.equals(userNameP) && pass.equals(passowrdP)){
                   result = true;
                   break;
               }
           }

       }

   return result;
    }
}
