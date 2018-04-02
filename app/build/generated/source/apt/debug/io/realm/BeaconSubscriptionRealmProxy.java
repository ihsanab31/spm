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

public class BeaconSubscriptionRealmProxy extends com.sumroch.spotme.models.BeaconSubscription
    implements RealmObjectProxy, BeaconSubscriptionRealmProxyInterface {

    static final class BeaconSubscriptionColumnInfo extends ColumnInfo {
        long beaconIdIndex;
        long uuidIndex;
        long majorIndex;
        long minorIndex;

        BeaconSubscriptionColumnInfo(SharedRealm realm, Table table) {
            super(4);
            this.beaconIdIndex = addColumnDetails(table, "beaconId", RealmFieldType.STRING);
            this.uuidIndex = addColumnDetails(table, "uuid", RealmFieldType.STRING);
            this.majorIndex = addColumnDetails(table, "major", RealmFieldType.INTEGER);
            this.minorIndex = addColumnDetails(table, "minor", RealmFieldType.INTEGER);
        }

        BeaconSubscriptionColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new BeaconSubscriptionColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final BeaconSubscriptionColumnInfo src = (BeaconSubscriptionColumnInfo) rawSrc;
            final BeaconSubscriptionColumnInfo dst = (BeaconSubscriptionColumnInfo) rawDst;
            dst.beaconIdIndex = src.beaconIdIndex;
            dst.uuidIndex = src.uuidIndex;
            dst.majorIndex = src.majorIndex;
            dst.minorIndex = src.minorIndex;
        }
    }

    private BeaconSubscriptionColumnInfo columnInfo;
    private ProxyState<com.sumroch.spotme.models.BeaconSubscription> proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("beaconId");
        fieldNames.add("uuid");
        fieldNames.add("major");
        fieldNames.add("minor");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    BeaconSubscriptionRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (BeaconSubscriptionColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.sumroch.spotme.models.BeaconSubscription>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$beaconId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.beaconIdIndex);
    }

    @Override
    public void realmSet$beaconId(String value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'beaconId' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$uuid() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.uuidIndex);
    }

    @Override
    public void realmSet$uuid(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.uuidIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.uuidIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.uuidIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.uuidIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$major() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.majorIndex);
    }

    @Override
    public void realmSet$major(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.majorIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.majorIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$minor() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.minorIndex);
    }

    @Override
    public void realmSet$minor(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.minorIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.minorIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("BeaconSubscription")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("BeaconSubscription");
            realmObjectSchema.add("beaconId", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("uuid", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("major", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("minor", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            return realmObjectSchema;
        }
        return realmSchema.get("BeaconSubscription");
    }

    public static BeaconSubscriptionColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (!sharedRealm.hasTable("class_BeaconSubscription")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'BeaconSubscription' class is missing from the schema for this Realm.");
        }
        Table table = sharedRealm.getTable("class_BeaconSubscription");
        final long columnCount = table.getColumnCount();
        if (columnCount != 4) {
            if (columnCount < 4) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 4 but was " + columnCount);
            }
            if (allowExtraColumns) {
                RealmLog.debug("Field count is more than expected - expected 4 but was %1$d", columnCount);
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 4 but was " + columnCount);
            }
        }
        Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
        for (long i = 0; i < columnCount; i++) {
            columnTypes.put(table.getColumnName(i), table.getColumnType(i));
        }

        final BeaconSubscriptionColumnInfo columnInfo = new BeaconSubscriptionColumnInfo(sharedRealm, table);

        if (!table.hasPrimaryKey()) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'beaconId' in existing Realm file. @PrimaryKey was added.");
        } else {
            if (table.getPrimaryKey() != columnInfo.beaconIdIndex) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary Key annotation definition was changed, from field " + table.getColumnName(table.getPrimaryKey()) + " to field beaconId");
            }
        }

        if (!columnTypes.containsKey("beaconId")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'beaconId' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("beaconId") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'beaconId' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.beaconIdIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"@PrimaryKey field 'beaconId' does not support null values in the existing Realm file. Migrate using RealmObjectSchema.setNullable(), or mark the field as @Required.");
        }
        if (!table.hasSearchIndex(table.getColumnIndex("beaconId"))) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'beaconId' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
        }
        if (!columnTypes.containsKey("uuid")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'uuid' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("uuid") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'uuid' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.uuidIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'uuid' is required. Either set @Required to field 'uuid' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("major")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'major' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("major") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'major' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.majorIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'major' does support null values in the existing Realm file. Use corresponding boxed type for field 'major' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("minor")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'minor' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("minor") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'minor' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.minorIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'minor' does support null values in the existing Realm file. Use corresponding boxed type for field 'minor' or migrate using RealmObjectSchema.setNullable().");
        }

        return columnInfo;
    }

    public static String getTableName() {
        return "class_BeaconSubscription";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.sumroch.spotme.models.BeaconSubscription createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.sumroch.spotme.models.BeaconSubscription obj = null;
        if (update) {
            Table table = realm.getTable(com.sumroch.spotme.models.BeaconSubscription.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = Table.NO_MATCH;
            if (json.isNull("beaconId")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("beaconId"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.sumroch.spotme.models.BeaconSubscription.class), false, Collections.<String> emptyList());
                    obj = new io.realm.BeaconSubscriptionRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("beaconId")) {
                if (json.isNull("beaconId")) {
                    obj = (io.realm.BeaconSubscriptionRealmProxy) realm.createObjectInternal(com.sumroch.spotme.models.BeaconSubscription.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.BeaconSubscriptionRealmProxy) realm.createObjectInternal(com.sumroch.spotme.models.BeaconSubscription.class, json.getString("beaconId"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'beaconId'.");
            }
        }
        if (json.has("uuid")) {
            if (json.isNull("uuid")) {
                ((BeaconSubscriptionRealmProxyInterface) obj).realmSet$uuid(null);
            } else {
                ((BeaconSubscriptionRealmProxyInterface) obj).realmSet$uuid((String) json.getString("uuid"));
            }
        }
        if (json.has("major")) {
            if (json.isNull("major")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'major' to null.");
            } else {
                ((BeaconSubscriptionRealmProxyInterface) obj).realmSet$major((int) json.getInt("major"));
            }
        }
        if (json.has("minor")) {
            if (json.isNull("minor")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'minor' to null.");
            } else {
                ((BeaconSubscriptionRealmProxyInterface) obj).realmSet$minor((int) json.getInt("minor"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.sumroch.spotme.models.BeaconSubscription createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.sumroch.spotme.models.BeaconSubscription obj = new com.sumroch.spotme.models.BeaconSubscription();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("beaconId")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((BeaconSubscriptionRealmProxyInterface) obj).realmSet$beaconId(null);
                } else {
                    ((BeaconSubscriptionRealmProxyInterface) obj).realmSet$beaconId((String) reader.nextString());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("uuid")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((BeaconSubscriptionRealmProxyInterface) obj).realmSet$uuid(null);
                } else {
                    ((BeaconSubscriptionRealmProxyInterface) obj).realmSet$uuid((String) reader.nextString());
                }
            } else if (name.equals("major")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'major' to null.");
                } else {
                    ((BeaconSubscriptionRealmProxyInterface) obj).realmSet$major((int) reader.nextInt());
                }
            } else if (name.equals("minor")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'minor' to null.");
                } else {
                    ((BeaconSubscriptionRealmProxyInterface) obj).realmSet$minor((int) reader.nextInt());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'beaconId'.");
        }
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.sumroch.spotme.models.BeaconSubscription copyOrUpdate(Realm realm, com.sumroch.spotme.models.BeaconSubscription object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.sumroch.spotme.models.BeaconSubscription) cachedRealmObject;
        } else {
            com.sumroch.spotme.models.BeaconSubscription realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.sumroch.spotme.models.BeaconSubscription.class);
                long pkColumnIndex = table.getPrimaryKey();
                String value = ((BeaconSubscriptionRealmProxyInterface) object).realmGet$beaconId();
                long rowIndex = Table.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstString(pkColumnIndex, value);
                }
                if (rowIndex != Table.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.sumroch.spotme.models.BeaconSubscription.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.BeaconSubscriptionRealmProxy();
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

    public static com.sumroch.spotme.models.BeaconSubscription copy(Realm realm, com.sumroch.spotme.models.BeaconSubscription newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.sumroch.spotme.models.BeaconSubscription) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.sumroch.spotme.models.BeaconSubscription realmObject = realm.createObjectInternal(com.sumroch.spotme.models.BeaconSubscription.class, ((BeaconSubscriptionRealmProxyInterface) newObject).realmGet$beaconId(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((BeaconSubscriptionRealmProxyInterface) realmObject).realmSet$uuid(((BeaconSubscriptionRealmProxyInterface) newObject).realmGet$uuid());
            ((BeaconSubscriptionRealmProxyInterface) realmObject).realmSet$major(((BeaconSubscriptionRealmProxyInterface) newObject).realmGet$major());
            ((BeaconSubscriptionRealmProxyInterface) realmObject).realmSet$minor(((BeaconSubscriptionRealmProxyInterface) newObject).realmGet$minor());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.sumroch.spotme.models.BeaconSubscription object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.sumroch.spotme.models.BeaconSubscription.class);
        long tableNativePtr = table.getNativePtr();
        BeaconSubscriptionColumnInfo columnInfo = (BeaconSubscriptionColumnInfo) realm.schema.getColumnInfo(com.sumroch.spotme.models.BeaconSubscription.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((BeaconSubscriptionRealmProxyInterface) object).realmGet$beaconId();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, primaryKeyValue);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$uuid = ((BeaconSubscriptionRealmProxyInterface)object).realmGet$uuid();
        if (realmGet$uuid != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.uuidIndex, rowIndex, realmGet$uuid, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.majorIndex, rowIndex, ((BeaconSubscriptionRealmProxyInterface)object).realmGet$major(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.minorIndex, rowIndex, ((BeaconSubscriptionRealmProxyInterface)object).realmGet$minor(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.sumroch.spotme.models.BeaconSubscription.class);
        long tableNativePtr = table.getNativePtr();
        BeaconSubscriptionColumnInfo columnInfo = (BeaconSubscriptionColumnInfo) realm.schema.getColumnInfo(com.sumroch.spotme.models.BeaconSubscription.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.sumroch.spotme.models.BeaconSubscription object = null;
        while (objects.hasNext()) {
            object = (com.sumroch.spotme.models.BeaconSubscription) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((BeaconSubscriptionRealmProxyInterface) object).realmGet$beaconId();
                long rowIndex = Table.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
                }
                if (rowIndex == Table.NO_MATCH) {
                    rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, primaryKeyValue);
                } else {
                    Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
                }
                cache.put(object, rowIndex);
                String realmGet$uuid = ((BeaconSubscriptionRealmProxyInterface)object).realmGet$uuid();
                if (realmGet$uuid != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.uuidIndex, rowIndex, realmGet$uuid, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.majorIndex, rowIndex, ((BeaconSubscriptionRealmProxyInterface)object).realmGet$major(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.minorIndex, rowIndex, ((BeaconSubscriptionRealmProxyInterface)object).realmGet$minor(), false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.sumroch.spotme.models.BeaconSubscription object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.sumroch.spotme.models.BeaconSubscription.class);
        long tableNativePtr = table.getNativePtr();
        BeaconSubscriptionColumnInfo columnInfo = (BeaconSubscriptionColumnInfo) realm.schema.getColumnInfo(com.sumroch.spotme.models.BeaconSubscription.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((BeaconSubscriptionRealmProxyInterface) object).realmGet$beaconId();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$uuid = ((BeaconSubscriptionRealmProxyInterface)object).realmGet$uuid();
        if (realmGet$uuid != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.uuidIndex, rowIndex, realmGet$uuid, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.uuidIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.majorIndex, rowIndex, ((BeaconSubscriptionRealmProxyInterface)object).realmGet$major(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.minorIndex, rowIndex, ((BeaconSubscriptionRealmProxyInterface)object).realmGet$minor(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.sumroch.spotme.models.BeaconSubscription.class);
        long tableNativePtr = table.getNativePtr();
        BeaconSubscriptionColumnInfo columnInfo = (BeaconSubscriptionColumnInfo) realm.schema.getColumnInfo(com.sumroch.spotme.models.BeaconSubscription.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.sumroch.spotme.models.BeaconSubscription object = null;
        while (objects.hasNext()) {
            object = (com.sumroch.spotme.models.BeaconSubscription) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((BeaconSubscriptionRealmProxyInterface) object).realmGet$beaconId();
                long rowIndex = Table.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
                }
                if (rowIndex == Table.NO_MATCH) {
                    rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, primaryKeyValue);
                }
                cache.put(object, rowIndex);
                String realmGet$uuid = ((BeaconSubscriptionRealmProxyInterface)object).realmGet$uuid();
                if (realmGet$uuid != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.uuidIndex, rowIndex, realmGet$uuid, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.uuidIndex, rowIndex, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.majorIndex, rowIndex, ((BeaconSubscriptionRealmProxyInterface)object).realmGet$major(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.minorIndex, rowIndex, ((BeaconSubscriptionRealmProxyInterface)object).realmGet$minor(), false);
            }
        }
    }

    public static com.sumroch.spotme.models.BeaconSubscription createDetachedCopy(com.sumroch.spotme.models.BeaconSubscription realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.sumroch.spotme.models.BeaconSubscription unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.sumroch.spotme.models.BeaconSubscription)cachedObject.object;
            } else {
                unmanagedObject = (com.sumroch.spotme.models.BeaconSubscription)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.sumroch.spotme.models.BeaconSubscription();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((BeaconSubscriptionRealmProxyInterface) unmanagedObject).realmSet$beaconId(((BeaconSubscriptionRealmProxyInterface) realmObject).realmGet$beaconId());
        ((BeaconSubscriptionRealmProxyInterface) unmanagedObject).realmSet$uuid(((BeaconSubscriptionRealmProxyInterface) realmObject).realmGet$uuid());
        ((BeaconSubscriptionRealmProxyInterface) unmanagedObject).realmSet$major(((BeaconSubscriptionRealmProxyInterface) realmObject).realmGet$major());
        ((BeaconSubscriptionRealmProxyInterface) unmanagedObject).realmSet$minor(((BeaconSubscriptionRealmProxyInterface) realmObject).realmGet$minor());
        return unmanagedObject;
    }

    static com.sumroch.spotme.models.BeaconSubscription update(Realm realm, com.sumroch.spotme.models.BeaconSubscription realmObject, com.sumroch.spotme.models.BeaconSubscription newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((BeaconSubscriptionRealmProxyInterface) realmObject).realmSet$uuid(((BeaconSubscriptionRealmProxyInterface) newObject).realmGet$uuid());
        ((BeaconSubscriptionRealmProxyInterface) realmObject).realmSet$major(((BeaconSubscriptionRealmProxyInterface) newObject).realmGet$major());
        ((BeaconSubscriptionRealmProxyInterface) realmObject).realmSet$minor(((BeaconSubscriptionRealmProxyInterface) newObject).realmGet$minor());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("BeaconSubscription = proxy[");
        stringBuilder.append("{beaconId:");
        stringBuilder.append(realmGet$beaconId() != null ? realmGet$beaconId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{uuid:");
        stringBuilder.append(realmGet$uuid() != null ? realmGet$uuid() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{major:");
        stringBuilder.append(realmGet$major());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{minor:");
        stringBuilder.append(realmGet$minor());
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
        BeaconSubscriptionRealmProxy aBeaconSubscription = (BeaconSubscriptionRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aBeaconSubscription.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aBeaconSubscription.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aBeaconSubscription.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
