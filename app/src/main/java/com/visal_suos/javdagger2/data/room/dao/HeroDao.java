package com.visal_suos.javdagger2.data.room.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.visal_suos.javdagger2.data.response.ShortInfoHero;
import com.visal_suos.javdagger2.data.room.entity.Hero;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;


/**
 * Created by v.suos on 2/7/2018.
 */
@Dao
public interface HeroDao {

    @Query("SELECT * FROM hero")
    Maybe<List<Hero>> getAll();

    @Query("SELECT COUNT(*) FROM hero")
    long count();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long[] insert(Hero... heroes);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long[] insertAsList(List<Hero> heroes);
}
