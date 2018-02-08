package com.visal_suos.javdagger2.data.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by v.suos on 2/6/2018.
 */

public class ShortInfoHero {

    @SerializedName("attack_type")
    public String attack_type;
    @SerializedName("img")
    public String img;
    @SerializedName("localized_name")
    public String localized_name;
    @SerializedName("primary_attr")
    public String primary_attr;
    @SerializedName("roles")
    public List<String> roles;
}
