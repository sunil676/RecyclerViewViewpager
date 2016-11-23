package com.example;


import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;

public class MainGenerator {

    public static void main(String[] args) throws Exception {
        Schema schema = new Schema(3, "com.sunil.recyclerviewviewpager.daogen");
        addWall(schema);
        addData(schema);
        new DaoGenerator().generateAll(schema, "../RecyclerViewViewpager/app/src/main/java/");
    }

    private static void addData(Schema schema) {
        Entity dataWall = schema.addEntity("DataWall");
        dataWall.addIdProperty();
        dataWall.addIntProperty("name_id").notNull();
        dataWall.addStringProperty("name");
        dataWall.addStringProperty("imageurl");
    }

    private static void addWall(Schema schema) {
        Entity wallToll = schema.addEntity("WallTall");
        wallToll.addIdProperty();
        wallToll.addIntProperty("name_id").notNull();
    }
}
