package com.sunil.recyclerviewviewpager.manager;

import android.content.Context;

import com.sunil.recyclerviewviewpager.MainApplication;
import com.sunil.recyclerviewviewpager.daogen.DaoSession;
import com.sunil.recyclerviewviewpager.daogen.DataWall;
import com.sunil.recyclerviewviewpager.daogen.DataWallDao;

import java.util.List;

/**
 * Created by kuliza-195 on 11/22/16.
 */

public class DataManager {

    public static DataWall load(Context ctx, long id) {
        return getDataDao(ctx).load(id);
    }

    public static List<DataWall> loadAll(Context ctx) {
        return getDataDao(ctx).loadAll();
    }

    public static List<DataWall> loadByQuery(Context ctx, int nameId) {
        List<DataWall> dataModels = getDataDao(ctx).queryBuilder()
                .where(DataWallDao.Properties.Name_id.eq(nameId))
                .list();
        return dataModels;
    }

    public static long insertOrReplace(Context ctx, DataWall dataWall) {
        return getDataDao(ctx).insertOrReplace(dataWall);
    }

    public static void remove(Context ctx, DataWall datawall) {
        getDataDao(ctx).delete(datawall);
    }

    public static void removeAll(Context ctx) {
        getDataDao(ctx).deleteAll();
    }

    private static DataWallDao getDataDao(Context c) {
        // get the data DAO
        DaoSession daoSession = ((MainApplication) MainApplication.getAppContext()).getDaoSession();
        DataWallDao datawallDao = daoSession.getDataWallDao();
        return datawallDao ;
    }
}
