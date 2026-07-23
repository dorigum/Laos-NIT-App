package la.gov.nit.nit;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final int DB_VERSION = 1;

    public DBHelper(Context context) {
        super(context, "nitdb", null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String tableSql = "create table tbyouth( id integer primary key autoincrement, name, surname, phone, ethnic)";
        db.execSQL(tableSql);

        db.execSQL("insert into tbyouth(name, surname, phone, ethnic) " +
                "values ('kaka','kiki','02022933788','lao')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        if(newV == DB_VERSION ){
            db.execSQL("drop table tbyouth");
            onCreate(db);
        }
    }
}
