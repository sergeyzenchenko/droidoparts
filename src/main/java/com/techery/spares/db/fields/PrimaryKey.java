package com.techery.spares.db.fields;

import com.techery.spares.db.accessors.IntAccessor;

/**
 * Created with IntelliJ IDEA.
 * User: dimson
 * Date: 15.06.13
 * Time: 00:34
 * To change this template use File | Settings | File Templates.
 */
public class PrimaryKey extends  Field {

    public PrimaryKey(IntAccessor<?> accessor){
        super("_id", accessor);
        isPrimaryKey = true;
        setAutoincrement(true);
    }
}
