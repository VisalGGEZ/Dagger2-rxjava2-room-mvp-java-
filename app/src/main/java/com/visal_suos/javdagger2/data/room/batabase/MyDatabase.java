package com.visal_suos.javdagger2.data.room.batabase;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomDatabase;

import com.visal_suos.javdagger2.data.room.dao.HeroDao;
import com.visal_suos.javdagger2.data.room.entity.Hero;

/**
 * Created by v.suos on 2/7/2018.
 */
@Database(entities = {Hero.class}, version = 1, exportSchema = false)
public abstract class MyDatabase extends RoomDatabase{

    public abstract HeroDao heroDao();

    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }
}

