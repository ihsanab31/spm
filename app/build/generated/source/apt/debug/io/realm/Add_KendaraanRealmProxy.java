package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.RealmObjectSchema;
import io.realm.RealmSchema;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.LinkView;
import io.realm.internal.OsObject;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.SharedRealm;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Add_KendaraanRealmProxy extends com.sumroch.spotme.models.db.Add_Kendaraan
    implements RealmObjectProxy, Add_KendaraanRealmProxyInterface {

    static final class Add_KendaraanColumnInfo extends ColumnInfo {
        long idIndex;
        long j_kendaraanIndex;
        long platIndex;

        Add_KendaraanColumnInfo(SharedRealm realm, Table table) {
            super(3);
            this.idIndex = addColumnDetails(table, "id", RealmFieldType.INTEGER);
            this.j_kendaraanIndex = addColumnDetails(table, "j_kendaraan", RealmFieldType.STRING);
            this.platIndex = addColumnDetails(table, "plat", RealmFieldType.STRING);
        }

        Add_KendaraanColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new Add_KendaraanColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final Add_KendaraanColumnInfo src = (Add_KendaraanColumnInfo) rawSrc;
            final Add_KendaraanColumnInfo dst = (Add_KendaraanColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.j_kendaraanIndex = src.j_kendaraanIndex;
            dst.platIndex = src.platIndex;
        }
    }

    private Add_KendaraanColumnInfo columnInfo;
    private ProxyState<com.sumroch.spotme.models.db.Add_Kendaraan> proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("j_kendaraan");
        fieldNames.add("plat");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    Add_KendaraanRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (Add_KendaraanColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.sumroch.spotme.models.db.Add_Kendaraan>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.idIndex);
    }

    @Override
    public void realmSet$id(int value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'id' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$j_kendaraan() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.j_kendaraanIndex);
    }

    @Override
    public void realmSet$j_kendaraan(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.j_kendaraanIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.j_kendaraanIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.j_kendaraanIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.j_kendaraanIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$plat() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.platIndex);
    }

    @Override
    public void realmSet$plat(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.platIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.platIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.platIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.platIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("Add_Kendaraan")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("Add_Kendaraan");
            realmObjectSchema.add("id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("j_kendaraan", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("plat", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            return realmObjectSchema;
        }
        return realmSchema.get("Add_Kendaraan");
    }

    public static Add_KendaraanColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (!sharedRealm.hasTable("class_Add_Kendaraan")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'Add_Kendaraan' class is missing from the schema for this Realm.");
        }
        Table table = sharedRealm.getTable("class_Add_Kendaraan");
        final long columnCount = table.getColumnCount();
        if (columnCount != 3) {
            if (columnCount < 3) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 3 but was " + columnCount);
            }
            if (allowExtraColumns) {
                RealmLog.debug("Field count is more than expected - expected 3 but was %1$d", columnCount);
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 3 but was " + columnCount);
            }
        }
        Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
        for (long i = 0; i < columnCount; i++) {
            columnTypes.put(table.getColumnName(i), table.getColumnType(i));
        }

        final Add_KendaraanColumnInfo columnInfo = new Add_KendaraanColumnInfo(sharedRealm, table);

        if (!table.hasPrimaryKey()) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'id' in existing Realm file. @PrimaryKey was added.");
        } else {
            if (table.getPrimaryKey() != columnInfo.idIndex) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary Key annotation definition was changed, from field " + table.getColumnName(table.getPrimaryKey()) + " to field id");
            }
        }

        if (!columnTypes.containsKey("id")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'id' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("id") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'id' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.idIndex) && table.findFirstNull(columnInfo.idIndex) != Table.NO_MATCH) {
            throw new IllegalStateException("Cannot migrate an object with null value in field 'id'. Either maintain the same type for primary key field 'id', or remove the object with null value before migration.");
        }
        if (!table.hasSearchIndex(table.getColumnIndex("id"))) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'id' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
        }
        if (!columnTypes.containsKey("j_kendaraan")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'j_kendaraan' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("j_kendaraan") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'j_kendaraan' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.j_kendaraanIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'j_kendaraan' is required. Either set @Required to field 'j_kendaraan' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("plat")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'plat' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("plat") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'plat' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.platIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'plat' is required. Either set @Required to field 'plat' or migrate using RealmObjectSchema.setNullable().");
        }

        return columnInfo;
    }

    public static String getTableName() {
        return "class_Add_Kendaraan";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.sumroch.spotme.models.db.Add_Kendaraan createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.sumroch.spotme.models.db.Add_Kendaraan obj = null;
        if (update) {
            Table table = realm.getTable(com.sumroch.spotme.models.db.Add_Kendaraan.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("id")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.sumroch.spotme.models.db.Add_Kendaraan.class), false, Collections.<String> emptyList());
                    obj = new io.realm.Add_KendaraanRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.Add_KendaraanRealmProxy) realm.createObjectInternal(com.sumroch.spotme.models.db.Add_Kendaraan.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.Add_KendaraanRealmProxy) realm.createObjectInternal(com.sumroch.spotme.models.db.Add_Kendaraan.class, json.getInt("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }
        if (json.has("j_kendaraan")) {
            if (json.isNull("j_kendaraan")) {
                ((Add_KendaraanRealmProxyInterface) obj).realmSet$j_kendaraan(null);
            } else {
                ((Add_KendaraanRealmProxyInterface) obj).realmSet$j_kendaraan((String) json.getString("j_kendaraan"));
            }
        }
        if (json.has("plat")) {
            if (json.isNull("plat")) {
                ((Add_KendaraanRealmProxyInterface) obj).realmSet$plat(null);
            } else {
                ((Add_KendaraanRealmProxyInterface) obj).realmSet$plat((String) json.getString("plat"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.sumroch.spotme.models.db.Add_Kendaraan createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.sumroch.spotme.models.db.Add_Kendaraan obj = new com.sumroch.spotme.models.db.Add_Kendaraan();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
                } else {
                    ((Add_KendaraanRealmProxyInterface) obj).realmSet$id((int) reader.nextInt());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("j_kendaraan")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((Add_KendaraanRealmProxyInterface) obj).realmSet$j_kendaraan(null);
                } else {
                    ((Add_KendaraanRealmProxyInterface) obj).realmSet$j_kendaraan((String) reader.nextString());
                }
            } else if (name.equals("plat")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((Add_KendaraanRealmProxyInterface) obj).realmSet$plat(null);
                } else {
                    ((Add_KendaraanRealmProxyInterface) obj).realmSet$plat((String) reader.nextString());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
        }
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.sumroch.spotme.models.db.Add_Kendaraan copyOrUpdate(Realm realm, com.sumroch.spotme.models.db.Add_Kendaraan object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.sumroch.spotme.models.db.Add_Kendaraan) cachedRealmObject;
        } else {
            com.sumroch.spotme.models.db.Add_Kendaraan realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.sumroch.spotme.models.db.Add_Kendaraan.class);
                long pkColumnIndex = table.getPrimaryKey();
                long rowIndex = table.findFirstLong(pkColumnIndex, ((Add_KendaraanRealmProxyInterface) object).realmGet$id());
                if (rowIndex != Table.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.sumroch.spotme.models.db.Add_Kendaraan.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.Add_KendaraanRealmProxy();
                        cache.put(object, (RealmObjectProxy) realmObject);
                    } finally {
                        objectContext.clear();
                    }
                } else {
                    canUpdate = false;
                }
            }

            if (canUpdate) {
                return update(realm, realmObject, object, cache);
            } else {
                return copy(realm, object, update, cache);
            }
        }
    }

    public static com.sumroch.spotme.models.db.Add_Kendaraan copy(Realm realm, com.sumroch.spotme.models.db.Add_Kendaraan newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.sumroch.spotme.models.db.Add_Kendaraan) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.sumroch.spotme.models.db.Add_Kendaraan realmObject = realm.createObjectInternal(com.sumroch.spotme.models.db.Add_Kendaraan.class, ((Add_KendaraanRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((Add_KendaraanRealmProxyInterface) realmObject).realmSet$j_kendaraan(((Add_KendaraanRealmProxyInterface) newObject).realmGet$j_kendaraan());
            ((Add_KendaraanRealmProxyInterface) realmObject).realmSet$plat(((Add_KendaraanRealmProxyInterface) newObject).realmGet$plat());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.sumroch.spotme.models.db.Add_Kendaraan object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.sumroch.spotme.models.db.Add_Kendaraan.class);
        long tableNativePtr = table.getNativePtr();
        Add_KendaraanColumnInfo columnInfo = (Add_KendaraanColumnInfo) realm.schema.getColumnInfo(com.sumroch.spotme.models.db.Add_Kendaraan.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((Add_KendaraanRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((Add_KendaraanRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((Add_KendaraanRealmProxyInterface) object).realmGet$id());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$j_kendaraan = ((Add_KendaraanRealmProxyInterface)object).realmGet$j_kendaraan();
        if (realmGet$j_kendaraan != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.j_kendaraanIndex, rowIndex, realmGet$j_kendaraan, false);
        }
        String realmGet$plat = ((Add_KendaraanRealmProxyInterface)object).realmGet$plat();
        if (realmGet$plat != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.platIndex, rowIndex, realmGet$plat, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.sumroch.spotme.models.db.Add_Kendaraan.class);
        long tableNativePtr = table.getNativePtr();
        Add_KendaraanColumnInfo columnInfo = (Add_KendaraanColumnInfo) realm.schema.getColumnInfo(com.sumroch.spotme.models.db.Add_Kendaraan.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.sumroch.spotme.models.db.Add_Kendaraan object = null;
        while (objects.hasNext()) {
            object = (com.sumroch.spotme.models.db.Add_Kendaraan) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.NO_MATCH;
                Object primaryKeyValue = ((Add_KendaraanRealmProxyInterface) object).realmGet$id();
                if (primaryKeyValue != null) {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((Add_KendaraanRealmProxyInterface) object).realmGet$id());
                }
                if (rowIndex == Table.NO_MATCH) {
                    rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((Add_KendaraanRealmProxyInterface) object).realmGet$id());
                } else {
                    Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
                }
                cache.put(object, rowIndex);
                String realmGet$j_kendaraan = ((Add_KendaraanRealmProxyInterface)object).realmGet$j_kendaraan();
                if (realmGet$j_kendaraan != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.j_kendaraanIndex, rowIndex, realmGet$j_kendaraan, false);
                }
                String realmGet$plat = ((Add_KendaraanRealmProxyInterface)object).realmGet$plat();
                if (realmGet$plat != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.platIndex, rowIndex, realmGet$plat, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.sumroch.spotme.models.db.Add_Kendaraan object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.sumroch.spotme.models.db.Add_Kendaraan.class);
        long tableNativePtr = table.getNativePtr();
        Add_KendaraanColumnInfo columnInfo = (Add_KendaraanColumnInfo) realm.schema.getColumnInfo(com.sumroch.spotme.models.db.Add_Kendaraan.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((Add_KendaraanRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((Add_KendaraanRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((Add_KendaraanRealmProxyInterface) object).realmGet$id());
        }
        cache.put(object, rowIndex);
        String realmGet$j_kendaraan = ((Add_KendaraanRealmProxyInterface)object).realmGet$j_kendaraan();
        if (realmGet$j_kendaraan != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.j_kendaraanIndex, rowIndex, realmGet$j_kendaraan, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.j_kendaraanIndex, rowIndex, false);
        }
        String realmGet$plat = ((Add_KendaraanRealmProxyInterface)object).realmGet$plat();
        if (realmGet$plat != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.platIndex, rowIndex, realmGet$plat, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.platIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.sumroch.spotme.models.db.Add_Kendaraan.class);
        long tableNativePtr = table.getNativePtr();
        Add_KendaraanColumnInfo columnInfo = (Add_KendaraanColumnInfo) realm.schema.getColumnInfo(com.sumroch.spotme.models.db.Add_Kendaraan.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.sumroch.spotme.models.db.Add_Kendaraan object = null;
        while (objects.hasNext()) {
            object = (com.sumroch.spotme.models.db.Add_Kendaraan) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.NO_MATCH;
                Object primaryKeyValue = ((Add_KendaraanRealmProxyInterface) object).realmGet$id();
                if (primaryKeyValue != null) {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((Add_KendaraanRealmProxyInterface) object).realmGet$id());
                }
                if (rowIndex == Table.NO_MATCH) {
                    rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((Add_KendaraanRealmProxyInterface) object).realmGet$id());
                }
                cache.put(object, rowIndex);
                String realmGet$j_kendaraan = ((Add_KendaraanRealmProxyInterface)object).realmGet$j_kendaraan();
                if (realmGet$j_kendaraan != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.j_kendaraanIndex, rowIndex, realmGet$j_kendaraan, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.j_kendaraanIndex, rowIndex, false);
                }
                String realmGet$plat = ((Add_KendaraanRealmProxyInterface)object).realmGet$plat();
                if (realmGet$plat != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.platIndex, rowIndex, realmGet$plat, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.platIndex, rowIndex, false);
                }
            }
        }
    }

    public static com.sumroch.spotme.models.db.Add_Kendaraan createDetachedCopy(com.sumroch.spotme.models.db.Add_Kendaraan realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.sumroch.spotme.models.db.Add_Kendaraan unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.sumroch.spotme.models.db.Add_Kendaraan)cachedObject.object;
            } else {
                unmanagedObject = (com.sumroch.spotme.models.db.Add_Kendaraan)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.sumroch.spotme.models.db.Add_Kendaraan();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((Add_KendaraanRealmProxyInterface) unmanagedObject).realmSet$id(((Add_KendaraanRealmProxyInterface) realmObject).realmGet$id());
        ((Add_KendaraanRealmProxyInterface) unmanagedObject).realmSet$j_kendaraan(((Add_KendaraanRealmProxyInterface) realmObject).realmGet$j_kendaraan());
        ((Add_KendaraanRealmProxyInterface) unmanagedObject).realmSet$plat(((Add_KendaraanRealmProxyInterface) realmObject).realmGet$plat());
        return unmanagedObject;
    }

    static com.sumroch.spotme.models.db.Add_Kendaraan update(Realm realm, com.sumroch.spotme.models.db.Add_Kendaraan realmObject, com.sumroch.spotme.models.db.Add_Kendaraan newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((Add_KendaraanRealmProxyInterface) realmObject).realmSet$j_kendaraan(((Add_KendaraanRealmProxyInterface) newObject).realmGet$j_kendaraan());
        ((Add_KendaraanRealmProxyInterface) realmObject).realmSet$plat(((Add_KendaraanRealmProxyInterface) newObject).realmGet$plat());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Add_Kendaraan = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{j_kendaraan:");
        stringBuilder.append(realmGet$j_kendaraan() != null ? realmGet$j_kendaraan() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{plat:");
        stringBuilder.append(realmGet$plat() != null ? realmGet$plat() : "null");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Add_KendaraanRealmProxy aAdd_Kendaraan = (Add_KendaraanRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aAdd_Kendaraan.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aAdd_Kendaraan.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aAdd_Kendaraan.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
