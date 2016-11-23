package com.sunil.recyclerviewviewpager.manager;

import android.content.Context;

import com.sunil.recyclerviewviewpager.MainApplication;
import com.sunil.recyclerviewviewpager.daogen.DaoSession;
import com.sunil.recyclerviewviewpager.daogen.DataWall;
import com.sunil.recyclerviewviewpager.daogen.DataWallDao;
import com.sunil.recyclerviewviewpager.daogen.WallTall;
import com.sunil.recyclerviewviewpager.daogen.WallTallDao;

import java.util.List;

/**
 * Created by kuliza-195 on 11/22/16.
 */

public class WallTallManager {

    public static WallTall load(Context ctx, long id) {
        return getWallDao(ctx).load(id);
    }

    public static List<WallTall> loadAll(Context ctx) {
        return getWallDao(ctx).loadAll();
    }

    public static long insertOrReplace(Context ctx, WallTall dataWall) {
        return getWallDao(ctx).insertOrReplace(dataWall);
    }

    public static void remove(Context ctx, WallTall wallTall) {
        getWallDao(ctx).delete(wallTall);
    }

    public static void removeAll(Context ctx) {
        getWallDao(ctx).deleteAll();
    }

    private static WallTallDao getWallDao(Context c) {
        // get the data DAO
        DaoSession daoSession = ((MainApplication) MainApplication.getAppContext()).getDaoSession();
        WallTallDao datawallDao = daoSession.getWallTallDao();
        return datawallDao ;
    }
}
