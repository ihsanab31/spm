package com.sumroch.spotme.models.db;

import com.sumroch.spotme.R;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 0878253827096
 * on Sunday, 19-11-2017
 * ------------------------------
 * This class for
 */

@Data
@NoArgsConstructor
public class GridMenu {

    private long id;
    private int title;
    private int icon;
    private int notificationSize;
    private boolean enable = true;

    public GridMenu(int title, int icon) {
        this.title = title;
        this.icon = icon;
    }

    public GridMenu(int title, int icon, boolean enable) {
        this.title = title;
        this.icon = icon;
        this.enable = enable;
    }

    public GridMenu(int title, int icon, int notificationSize) {
        this.title = title;
        this.icon = icon;
        this.notificationSize = notificationSize;
    }

    public static List<GridMenu> getDummyGridMenuData() {
        List<GridMenu> gridMenuList = new ArrayList<>();

        gridMenuList.add(new GridMenu(R.string.label_parkir, R.drawable.ic_parking_sign));
        gridMenuList.add(new GridMenu(R.string.label_promosi, R.drawable.ic_promotion));
        gridMenuList.add(new GridMenu(R.string.label_menu_member, R.drawable.ic_card));
        gridMenuList.add(new GridMenu(R.string.label_explorer, R.drawable.ic_explore));
        gridMenuList.add(new GridMenu(R.string.label_menu_event, R.drawable.ic_calendar, 3));
        gridMenuList.add(new GridMenu(R.string.label_navigasi, R.drawable.ic_navigation,false));
        gridMenuList.add(new GridMenu(R.string.label_belanja, R.drawable.ic_cart, false));
        gridMenuList.add(new GridMenu(R.string.label_uang, R.drawable.ic_coins, false));
//       gridMenuList.add(new GridMenu(R.string.label_market, R.drawable.ic_fruit, false));
//       gridMenuList.add(new GridMenu(R.string.label_belanja, R.drawable.ic_chef, false));


        return gridMenuList;
    }
}
