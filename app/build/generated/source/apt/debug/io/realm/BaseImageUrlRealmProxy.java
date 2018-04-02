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

public class BaseImageUrlRealmProxy extends com.sumroch.spotme.models.db.BaseImageUrl
    implements RealmObjectProxy, BaseImageUrlRealmProxyInterface {

    static final class BaseImageUrlColumnInfo extends ColumnInfo {
        long userIndex;
        long mallIndex;
        long eventIndex;
        long promotionIndex;

        BaseImageUrlColumnInfo(SharedRealm realm, Table table) {
            super(4);
            this.userIndex = addColumnDetails(table, "user", RealmFieldType.STRING);
            this.mallIndex = addColumnDetails(table, "mall", RealmFieldType.STRING);
            this.eventIndex = addColumnDetails(table, "event", RealmFieldType.STRING);
            this.promotionIndex = addColumnDetails(table, "promotion", RealmFieldType.STRING);
        }

        BaseImageUrlColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new BaseImageUrlColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final BaseImageUrlColumnInfo src = (BaseImageUrlColumnInfo) rawSrc;
            final BaseImageUrlColumnInfo dst = (BaseImageUrlColumnInfo) rawDst;
            dst.userIndex = src.userIndex;
            dst.mallIndex = src.mallIndex;
            dst.eventIndex = src.eventIndex;
            dst.promotionIndex = src.promotionIndex;
        }
    }

    private BaseImageUrlColumnInfo columnInfo;
    private ProxyState<com.sumroch.spotme.models.db.BaseImageUrl> proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("user");
        fieldNames.add("mall");
        fieldNames.add("event");
        fieldNames.add("promotion");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    BaseImageUrlRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (BaseImageUrlColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.sumroch.spotme.models.db.BaseImageUrl>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$user() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.userIndex);
    }

    @Override
    public void realmSet$user(String value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'user' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$mall() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.mallIndex);
    }

    @Override
    public void realmSet$mall(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.mallIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.mallIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.mallIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.mallIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$event() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.eventIndex);
    }

    @Override
    public void realmSet$event(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.eventIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.eventIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.eventIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.eventIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$promotion() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.promotionIndex);
    }

    @Override
    public void realmSet$promotion(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.promotionIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.promotionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.promotionIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.promotionIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("BaseImageUrl")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("BaseImageUrl");
            realmObjectSchema.add("user", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("mall", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("event", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("promotion", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            return realmObjectSchema;
        }
        return realmSchema.get("BaseImageUrl");
    }

    public static BaseImageUrlColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (!sharedRealm.hasTable("class_BaseImageUrl")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'BaseImageUrl' class is missing from the schema for this Realm.");
        }
        Table table = sharedRealm.getTable("class_BaseImageUrl");
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

        final BaseImageUrlColumnInfo columnInfo = new BaseImageUrlColumnInfo(sharedRealm, table);

        if (!table.hasPrimaryKey()) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'user' in existing Realm file. @PrimaryKey was added.");
        } else {
            if (table.getPrimaryKey() != columnInfo.userIndex) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary Key annotation definition was changed, from field " + table.getColumnName(table.getPrimaryKey()) + " to field user");
            }
        }

        if (!columnTypes.containsKey("user")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'user' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("user") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'user' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.userIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"@PrimaryKey field 'user' does not support null values in the existing Realm file. Migrate using RealmObjectSchema.setNullable(), or mark the field as @Required.");
        }
        if (!table.hasSearchIndex(table.getColumnIndex("user"))) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'user' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
        }
        if (!columnTypes.containsKey("mall")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'mall' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("mall") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'mall' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.mallIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'mall' is required. Either set @Required to field 'mall' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("event")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'event' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("event") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'event' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.eventIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'event' is required. Either set @Required to field 'event' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("promotion")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'promotion' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("promotion") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'promotion' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.promotionIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'promotion' is required. Either set @Required to field 'promotion' or migrate using RealmObjectSchema.setNullable().");
        }

        return columnInfo;
    }

    public static String getTableName() {
        return "class_BaseImageUrl";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.sumroch.spotme.models.db.BaseImageUrl createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.sumroch.spotme.models.db.BaseImageUrl obj = null;
        if (update) {
            Table table = realm.getTable(com.sumroch.spotme.models.db.BaseImageUrl.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = Table.NO_MATCH;
            if (json.isNull("user")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("user"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.sumroch.spotme.models.db.BaseImageUrl.class), false, Collections.<String> emptyList());
                    obj = new io.realm.BaseImageUrlRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("user")) {
                if (json.isNull("user")) {
                    obj = (io.realm.BaseImageUrlRealmProxy) realm.createObjectInternal(com.sumroch.spotme.models.db.BaseImageUrl.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.BaseImageUrlRealmProxy) realm.createObjectInternal(com.sumroch.spotme.models.db.BaseImageUrl.class, json.getString("user"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'user'.");
            }
        }
        if (json.has("mall")) {
            if (json.isNull("mall")) {
                ((BaseImageUrlRealmProxyInterface) obj).realmSet$mall(null);
            } else {
                ((BaseImageUrlRealmProxyInterface) obj).realmSet$mall((String) json.getString("mall"));
            }
        }
        if (json.has("event")) {
            if (json.isNull("event")) {
                ((BaseImageUrlRealmProxyInterface) obj).realmSet$event(null);
            } else {
                ((BaseImageUrlRealmProxyInterface) obj).realmSet$event((String) json.getString("event"));
            }
        }
        if (json.has("promotion")) {
            if (json.isNull("promotion")) {
                ((BaseImageUrlRealmProxyInterface) obj).realmSet$promotion(null);
            } else {
                ((BaseImageUrlRealmProxyInterface) obj).realmSet$promotion((String) json.getString("promotion"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.sumroch.spotme.models.db.BaseImageUrl createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.sumroch.spotme.models.db.BaseImageUrl obj = new com.sumroch.spotme.models.db.BaseImageUrl();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("user")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((BaseImageUrlRealmProxyInterface) obj).realmSet$user(null);
                } else {
                    ((BaseImageUrlRealmProxyInterface) obj).realmSet$user((String) reader.nextString());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("mall")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((BaseImageUrlRealmProxyInterface) obj).realmSet$mall(null);
                } else {
                    ((BaseImageUrlRealmProxyInterface) obj).realmSet$mall((String) reader.nextString());
                }
            } else if (name.equals("event")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((BaseImageUrlRealmProxyInterface) obj).realmSet$event(null);
                } else {
                    ((BaseImageUrlRealmProxyInterface) obj).realmSet$event((String) reader.nextString());
                }
            } else if (name.equals("promotion")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((BaseImageUrlRealmProxyInterface) obj).realmSet$promotion(null);
                } else {
                    ((BaseImageUrlRealmProxyInterface) obj).realmSet$promotion((String) reader.nextString());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'user'.");
        }
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.sumroch.spotme.models.db.BaseImageUrl copyOrUpdate(Realm realm, com.sumroch.spotme.models.db.BaseImageUrl object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.sumroch.spotme.models.db.BaseImageUrl) cachedRealmObject;
        } else {
            com.sumroch.spotme.models.db.BaseImageUrl realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.sumroch.spotme.models.db.BaseImageUrl.class);
                long pkColumnIndex = table.getPrimaryKey();
                String value = ((BaseImageUrlRealmProxyInterface) object).realmGet$user();
                long rowIndex = Table.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstString(pkColumnIndex, value);
                }
                if (rowIndex != Table.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.sumroch.spotme.models.db.BaseImageUrl.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.BaseImageUrlRealmProxy();
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

    public static com.sumroch.spotme.models.db.BaseImageUrl copy(Realm realm, com.sumroch.spotme.models.db.BaseImageUrl newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.sumroch.spotme.models.db.BaseImageUrl) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.sumroch.spotme.models.db.BaseImageUrl realmObject = realm.createObjectInternal(com.sumroch.spotme.models.db.BaseImageUrl.class, ((BaseImageUrlRealmProxyInterface) newObject).realmGet$user(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((BaseImageUrlRealmProxyInterface) realmObject).realmSet$mall(((BaseImageUrlRealmProxyInterface) newObject).realmGet$mall());
            ((BaseImageUrlRealmProxyInterface) realmObject).realmSet$event(((BaseImageUrlRealmProxyInterface) newObject).realmGet$event());
            ((BaseImageUrlRealmProxyInterface) realmObject).realmSet$promotion(((BaseImageUrlRealmProxyInterface) newObject).realmGet$promotion());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.sumroch.spotme.models.db.BaseImageUrl object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.sumroch.spotme.models.db.BaseImageUrl.class);
        long tableNativePtr = table.getNativePtr();
        BaseImageUrlColumnInfo columnInfo = (BaseImageUrlColumnInfo) realm.schema.getColumnInfo(com.sumroch.spotme.models.db.BaseImageUrl.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((BaseImageUrlRealmProxyInterface) object).realmGet$user();
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
        String realmGet$mall = ((BaseImageUrlRealmProxyInterface)object).realmGet$mall();
        if (realmGet$mall != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.mallIndex, rowIndex, realmGet$mall, false);
        }
        String realmGet$event = ((BaseImageUrlRealmProxyInterface)object).realmGet$event();
        if (realmGet$event != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.eventIndex, rowIndex, realmGet$event, false);
        }
        String realmGet$promotion = ((BaseImageUrlRealmProxyInterface)object).realmGet$promotion();
        if (realmGet$promotion != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.promotionIndex, rowIndex, realmGet$promotion, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.sumroch.spotme.models.db.BaseImageUrl.class);
        long tableNativePtr = table.getNativePtr();
        BaseImageUrlColumnInfo columnInfo = (BaseImageUrlColumnInfo) realm.schema.getColumnInfo(com.sumroch.spotme.models.db.BaseImageUrl.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.sumroch.spotme.models.db.BaseImageUrl object = null;
        while (objects.hasNext()) {
            object = (com.sumroch.spotme.models.db.BaseImageUrl) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((BaseImageUrlRealmProxyInterface) object).realmGet$user();
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
                String realmGet$mall = ((BaseImageUrlRealmProxyInterface)object).realmGet$mall();
                if (realmGet$mall != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.mallIndex, rowIndex, realmGet$mall, false);
                }
                String realmGet$event = ((BaseImageUrlRealmProxyInterface)object).realmGet$event();
                if (realmGet$event != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.eventIndex, rowIndex, realmGet$event, false);
                }
                String realmGet$promotion = ((BaseImageUrlRealmProxyInterface)object).realmGet$promotion();
                if (realmGet$promotion != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.promotionIndex, rowIndex, realmGet$promotion, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.sumroch.spotme.models.db.BaseImageUrl object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.sumroch.spotme.models.db.BaseImageUrl.class);
        long tableNativePtr = table.getNativePtr();
        BaseImageUrlColumnInfo columnInfo = (BaseImageUrlColumnInfo) realm.schema.getColumnInfo(com.sumroch.spotme.models.db.BaseImageUrl.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((BaseImageUrlRealmProxyInterface) object).realmGet$user();
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
        String realmGet$mall = ((BaseImageUrlRealmProxyInterface)object).realmGet$mall();
        if (realmGet$mall != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.mallIndex, rowIndex, realmGet$mall, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.mallIndex, rowIndex, false);
        }
        String realmGet$event = ((BaseImageUrlRealmProxyInterface)object).realmGet$event();
        if (realmGet$event != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.eventIndex, rowIndex, realmGet$event, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.eventIndex, rowIndex, false);
        }
        String realmGet$promotion = ((BaseImageUrlRealmProxyInterface)object).realmGet$promotion();
        if (realmGet$promotion != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.promotionIndex, rowIndex, realmGet$promotion, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.promotionIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.sumroch.spotme.models.db.BaseImageUrl.class);
        long tableNativePtr = table.getNativePtr();
        BaseImageUrlColumnInfo columnInfo = (BaseImageUrlColumnInfo) realm.schema.getColumnInfo(com.sumroch.spotme.models.db.BaseImageUrl.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.sumroch.spotme.models.db.BaseImageUrl object = null;
        while (objects.hasNext()) {
            object = (com.sumroch.spotme.models.db.BaseImageUrl) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((BaseImageUrlRealmProxyInterface) object).realmGet$user();
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
                String realmGet$mall = ((BaseImageUrlRealmProxyInterface)object).realmGet$mall();
                if (realmGet$mall != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.mallIndex, rowIndex, realmGet$mall, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.mallIndex, rowIndex, false);
                }
                String realmGet$event = ((BaseImageUrlRealmProxyInterface)object).realmGet$event();
                if (realmGet$event != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.eventIndex, rowIndex, realmGet$event, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.eventIndex, rowIndex, false);
                }
                String realmGet$promotion = ((BaseImageUrlRealmProxyInterface)object).realmGet$promotion();
                if (realmGet$promotion != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.promotionIndex, rowIndex, realmGet$promotion, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.promotionIndex, rowIndex, false);
                }
            }
        }
    }

    public static com.sumroch.spotme.models.db.BaseImageUrl createDetachedCopy(com.sumroch.spotme.models.db.BaseImageUrl realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.sumroch.spotme.models.db.BaseImageUrl unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.sumroch.spotme.models.db.BaseImageUrl)cachedObject.object;
            } else {
                unmanagedObject = (com.sumroch.spotme.models.db.BaseImageUrl)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.sumroch.spotme.models.db.BaseImageUrl();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((BaseImageUrlRealmProxyInterface) unmanagedObject).realmSet$user(((BaseImageUrlRealmProxyInterface) realmObject).realmGet$user());
        ((BaseImageUrlRealmProxyInterface) unmanagedObject).realmSet$mall(((BaseImageUrlRealmProxyInterface) realmObject).realmGet$mall());
        ((BaseImageUrlRealmProxyInterface) unmanagedObject).realmSet$event(((BaseImageUrlRealmProxyInterface) realmObject).realmGet$event());
        ((BaseImageUrlRealmProxyInterface) unmanagedObject).realmSet$promotion(((BaseImageUrlRealmProxyInterface) realmObject).realmGet$promotion());
        return unmanagedObject;
    }

    static com.sumroch.spotme.models.db.BaseImageUrl update(Realm realm, com.sumroch.spotme.models.db.BaseImageUrl realmObject, com.sumroch.spotme.models.db.BaseImageUrl newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((BaseImageUrlRealmProxyInterface) realmObject).realmSet$mall(((BaseImageUrlRealmProxyInterface) newObject).realmGet$mall());
        ((BaseImageUrlRealmProxyInterface) realmObject).realmSet$event(((BaseImageUrlRealmProxyInterface) newObject).realmGet$event());
        ((BaseImageUrlRealmProxyInterface) realmObject).realmSet$promotion(((BaseImageUrlRealmProxyInterface) newObject).realmGet$promotion());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("BaseImageUrl = proxy[");
        stringBuilder.append("{user:");
        stringBuilder.append(realmGet$user() != null ? realmGet$user() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{mall:");
        stringBuilder.append(realmGet$mall() != null ? realmGet$mall() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{event:");
        stringBuilder.append(realmGet$event() != null ? realmGet$event() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{promotion:");
        stringBuilder.append(realmGet$promotion() != null ? realmGet$promotion() : "null");
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
        BaseImageUrlRealmProxy aBaseImageUrl = (BaseImageUrlRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aBaseImageUrl.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aBaseImageUrl.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aBaseImageUrl.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
