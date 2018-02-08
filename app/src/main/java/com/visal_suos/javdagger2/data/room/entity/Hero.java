package com.visal_suos.javdagger2.data.room.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by v.suos on 2/7/2018.
 */
@Entity(tableName = "hero")
public class Hero {

    @PrimaryKey(autoGenerate = true)
    private int uid;

    @ColumnInfo(name = "attack_type")
    private String attackType;

    @ColumnInfo(name = "img")
    private String img;

    @ColumnInfo(name = "localized_name")
    private String localizedName;

    @ColumnInfo(name = "primary_attr")
    private String primaryAttr;

    public Hero(String attackType, String img, String localizedName, String primaryAttr) {
        this.attackType = attackType;
        this.img = img;
        this.localizedName = localizedName;
        this.primaryAttr = primaryAttr;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getAttackType() {
        return attackType;
    }

    public void setAttackType(String attackType) {
        this.attackType = attackType;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getLocalizedName() {
        return localizedName;
    }

    public void setLocalizedName(String localizedName) {
        this.localizedName = localizedName;
    }

    public String getPrimaryAttr() {
        return primaryAttr;
    }

    public void setPrimaryAttr(String primaryAttr) {
        this.primaryAttr = primaryAttr;
    }
}
