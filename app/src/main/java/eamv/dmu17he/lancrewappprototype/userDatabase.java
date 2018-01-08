package eamv.dmu17he.lancrewappprototype;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
/**
 * Created by hkkrestlessPC on 06-01-2018.
 */


@Database(entities = {userDBEntity.class}, version = 1)
public abstract class userDatabase extends RoomDatabase
{
    //singleton
    private static userDatabase dbInstance;
    //the Data access objects
    public abstract userDAO uDAO();

    public static userDatabase getDatabase(Context context)
    {
        if(dbInstance==null)
        {
            //allow mainThreadQueries should be removed later (a specified thread should be used instead of main on android devices)
            dbInstance = Room.databaseBuilder(context, userDatabase.class, "userDatabase").allowMainThreadQueries().build();
        }
        return dbInstance;
    }

    public static void destroyInstance()
    {
        dbInstance=null;
    }
}
