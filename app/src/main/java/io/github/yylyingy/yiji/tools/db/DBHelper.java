package io.github.yylyingy.yiji.tools.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Yangyl on 2016/12/19.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static final String CREATE_RECORD_SQL =
            "CREATE TABLE RECORD(" +
                    "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "MONEY FLOAT," +
                    "CURRENCY VARCHAR ," +
                    "TAG INTEGER(3)," +
                    "TIME VARCHAR(16)," +
                    "REMARK text," +
                    "USER_ID text," +
                    "OBJECT_ID text," +
                    "IS_UPLOADED integer" +
                    ");";
    public static final String CREATE_TAG_SQL =
            "CREATE TABLE TAG" +
                    "(" +
                    "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "NAME VARCHAR" +
                    "WEIGHT INTEGER" +
                    ");";
    /**
     * Create a helper object to create, open, and/or manage a database.
     * This method always returns very quickly.  The database is not actually
     * created or opened until one of {@link #getWritableDatabase} or
     * {@link #getReadableDatabase} is called.
     *
     * @param context to use to open or create the database
     * @param name    of the database file, or null for an in-memory database
     * @param factory to use for creating cursor objects, or null for the default
     * @param version number of the database (starting at 1); if the database is older,
     *                {@link #onUpgrade} will be used to upgrade the database; if the database is
     *                newer, {@link #onDowngrade} will be used to downgrade the database
     */
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    /**
     * Called when the database is created for the first time. This is where the
     * creation of tables and the initial population of the tables should happen.
     *
     * @param db The database.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    /**
     * Called when the database needs to be upgraded. The implementation
     * should use this method to drop tables, add tables, or do anything else it
     * needs to upgrade to the new schema version.
     * <p>
     * <p>
     * The SQLite ALTER TABLE documentation can be found
     * <a href="http://sqlite.org/lang_altertable.html">here</a>. If you add new columns
     * you can use ALTER TABLE to insert them into a live table. If you rename or remove columns
     * you can use ALTER TABLE to rename the old table, then create the new table and then
     * populate the new table with the contents of the old table.
     * </p><p>
     * This method executes within a transaction.  If an exception is thrown, all changes
     * will automatically be rolled back.
     * </p>
     *
     * @param db         The database.
     * @param oldVersion The old database version.
     * @param newVersion The new database version.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
