package com.zen.droidparts.db.accessors;

import com.zen.droidparts.db.DbFeildType;
import com.zen.droidparts.db.FieldType;
import com.zen.droidparts.db.manipulators.StringFeildManipulator;

/**
 * Created with IntelliJ IDEA.
 * User: dimson
 * Date: 14.06.13
 * Time: 23:42
 * To change this template use File | Settings | File Templates.
 */
public abstract class StringAccessor<OBJ_TYPE> extends FieldAccessor<OBJ_TYPE, String> {
    private static StringFeildManipulator manipulator = new StringFeildManipulator();

    @Override
    public StringFeildManipulator getFieldManipulator(){
        return manipulator;
    }

    @Override
    public FieldType getType() {
        return FieldType.STRING;
    }

    @Override
    public DbFeildType getDbType(){
        return DbFeildType.STRING;
    }
}