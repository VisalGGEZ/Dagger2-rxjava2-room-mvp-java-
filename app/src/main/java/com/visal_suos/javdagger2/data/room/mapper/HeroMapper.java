package com.visal_suos.javdagger2.data.room.mapper;

import com.visal_suos.javdagger2.data.response.ShortInfoHero;
import com.visal_suos.javdagger2.data.room.entity.Hero;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by v.suos on 2/7/2018.
 */

public class HeroMapper {


    public static List<Hero> map(List<ShortInfoHero> shortInfoHeroes) {
        List<Hero> list = new ArrayList<>();
        for (ShortInfoHero sh : shortInfoHeroes) {
            Hero hero = new Hero(
                    sh.attack_type,
                    sh.img,
                    sh.localized_name,
                    sh.primary_attr
            );
            list.add(hero);
        }
        return list;
    }

    public static List<ShortInfoHero> convert(List<Hero> shortInfoHeroes) {
        List<ShortInfoHero> list = new ArrayList<>();
        for (Hero sh : shortInfoHeroes) {
            ShortInfoHero hero = new ShortInfoHero();
            hero.attack_type = sh.getAttackType();
            hero.img = sh.getImg();
            hero.localized_name = sh.getLocalizedName();
            hero.primary_attr = sh.getPrimaryAttr();
            list.add(hero);
        }
        return list;
    }

}
