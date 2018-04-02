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

public class PromotionDataRealmProxy extends com.sumroch.spotme.models.db.PromotionData
    implements RealmObjectProxy, PromotionDataRealmProxyInterface {

    static final class PromotionDataColumnInfo extends ColumnInfo {
        long idIndex;
        long beacon_idIndex;
        long promotion_idIndex;
        long created_atIndex;
        long updated_atIndex;
        long promotionIndex;

        PromotionDataColumnInfo(SharedRealm realm, Table table) {
            super(6);
            this.idIndex = addColumnDetails(table, "id", RealmFieldType.STRING);
            this.beacon_idIndex = addColumnDetails(table, "beacon_id", RealmFieldType.STRING);
            this.promotion_idIndex = addColumnDetails(table, "promotion_id", RealmFieldType.STRING);
            this.created_atIndex = addColumnDetails(table, "created_at", RealmFieldType.STRING);
            this.updated_atIndex = addColumnDetails(table, "updated_at", RealmFieldType.STRING);
            this.promotionIndex = addColumnDetails(table, "promotion", RealmFieldType.OBJECT);
        }

        PromotionDataColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new PromotionDataColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final PromotionDataColumnInfo src = (PromotionDataColumnInfo) rawSrc;
            final PromotionDataColumnInfo dst = (PromotionDataColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.beacon_idIndex = src.beacon_idIndex;
            dst.promotion_idIndex = src.promotion_idIndex;
            dst.created_atIndex = src.created_atIndex;
            dst.updated_atIndex = src.updated_atIndex;
            dst.promotionIndex = src.promotionIndex;
        }
    }

    private PromotionDataColumnInfo columnInfo;
    private ProxyState<com.sumroch.spotme.models.db.PromotionData> proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("beacon_id");
        fieldNames.add("promotion_id");
        fieldNames.add("created_at");
        fieldNames.add("updated_at");
        fieldNames.add("promotion");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    PromotionDataRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (PromotionDataColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.sumroch.spotme.models.db.PromotionData>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.idIndex);
    }

    @Override
    public void realmSet$id(String value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'id' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$beacon_id() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.beacon_idIndex);
    }

    @Override
    public void realmSet$beacon_id(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.beacon_idIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.beacon_idIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.beacon_idIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.beacon_idIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$promotion_id() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.promotion_idIndex);
    }

    @Override
    public void realmSet$promotion_id(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.promotion_idIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.promotion_idIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.promotion_idIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.promotion_idIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$created_at() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.created_atIndex);
    }

    @Override
    public void realmSet$created_at(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.created_atIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.created_atIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.created_atIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.created_atIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$updated_at() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.updated_atIndex);
    }

    @Override
    public void realmSet$updated_at(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.updated_atIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.updated_atIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.updated_atIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.updated_atIndex, value);
    }

    @Override
    public com.sumroch.spotme.models.db.Promotion realmGet$promotion() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.promotionIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.sumroch.spotme.models.db.Promotion.class, proxyState.getRow$realm().getLink(columnInfo.promotionIndex), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$promotion(com.sumroch.spotme.models.db.Promotion value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("promotion")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = ((Realm) proxyState.getRealm$realm()).copyToRealm(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.promotionIndex);
                return;
            }
            if (!RealmObject.isValid(value)) {
                throw new IllegalArgumentException("'value' is not a valid managed object.");
            }
            if (((RealmObjectProxy) value).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
                throw new IllegalArgumentException("'value' belongs to a different Realm.");
            }
            row.getTable().setLink(columnInfo.promotionIndex, row.getIndex(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.promotionIndex);
            return;
        }
        if (!(RealmObject.isManaged(value) && RealmObject.isValid(value))) {
            throw new IllegalArgumentException("'value' is not a valid managed object.");
        }
        if (((RealmObjectProxy)value).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
            throw new IllegalArgumentException("'value' belongs to a different Realm.");
        }
        proxyState.getRow$realm().setLink(columnInfo.promotionIndex, ((RealmObjectProxy)value).realmGet$proxyState().getRow$realm().getIndex());
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("PromotionData")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("PromotionData");
            realmObjectSchema.add("id", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("beacon_id", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("promotion_id", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("created_at", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("updated_at", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            if (!realmSchema.contains("Promotion")) {
                PromotionRealmProxy.createRealmObjectSchema(realmSchema);
            }
            realmObjectSchema.add("promotion", RealmFieldType.OBJECT, realmSchema.get("Promotion"));
            return realmObjectSchema;
        }
        return realmSchema.get("PromotionData");
    }

    public static PromotionDataColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (!sharedRealm.hasTable("class_PromotionData")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'PromotionData' class is missing from the schema for this Realm.");
        }
        Table table = sharedRealm.getTable("class_PromotionData");
        final long columnCount = table.getColumnCount();
        if (columnCount != 6) {
            if (columnCount < 6) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 6 but was " + columnCount);
            }
            if (allowExtraColumns) {
                RealmLog.debug("Field count is more than expected - expected 6 but was %1$d", columnCount);
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 6 but was " + columnCount);
            }
        }
        Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
        for (long i = 0; i < columnCount; i++) {
            columnTypes.put(table.getColumnName(i), table.getColumnType(i));
        }

        final PromotionDataColumnInfo columnInfo = new PromotionDataColumnInfo(sharedRealm, table);

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
        if (columnTypes.get("id") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'id' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.idIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"@PrimaryKey field 'id' does not support null values in the existing Realm file. Migrate using RealmObjectSchema.setNullable(), or mark the field as @Required.");
        }
        if (!table.hasSearchIndex(table.getColumnIndex("id"))) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'id' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
        }
        if (!columnTypes.containsKey("beacon_id")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'beacon_id' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("beacon_id") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'beacon_id' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.beacon_idIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'beacon_id' is required. Either set @Required to field 'beacon_id' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("promotion_id")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'promotion_id' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("promotion_id") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'promotion_id' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.promotion_idIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'promotion_id' is required. Either set @Required to field 'promotion_id' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("created_at")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'created_at' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("created_at") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'created_at' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.created_atIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'created_at' is required. Either set @Required to field 'created_at' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("updated_at")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'updated_at' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("updated_at") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'updated_at' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.updated_atIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'updated_at' is required. Either set @Required to field 'updated_at' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("promotion")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'promotion' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("promotion") != RealmFieldType.OBJECT) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Promotion' for field 'promotion'");
        }
        if (!sharedRealm.hasTable("class_Promotion")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing class 'class_Promotion' for field 'promotion'");
        }
        Table table_5 = sharedRealm.getTable("class_Promotion");
        if (!table.getLinkTarget(columnInfo.promotionIndex).hasSameSchema(table_5)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid RealmObject for field 'promotion': '" + table.getLinkTarget(columnInfo.promotionIndex).getName() + "' expected - was '" + table_5.getName() + "'");
        }

        return columnInfo;
    }

    public static String getTableName() {
        return "class_PromotionData";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.sumroch.spotme.models.db.PromotionData createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(1);
        com.sumroch.spotme.models.db.PromotionData obj = null;
        if (update) {
            Table table = realm.getTable(com.sumroch.spotme.models.db.PromotionData.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = Table.NO_MATCH;
            if (json.isNull("id")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.sumroch.spotme.models.db.PromotionData.class), false, Collections.<String> emptyList());
                    obj = new io.realm.PromotionDataRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("promotion")) {
                excludeFields.add("promotion");
            }
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.PromotionDataRealmProxy) realm.createObjectInternal(com.sumroch.spotme.models.db.PromotionData.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.PromotionDataRealmProxy) realm.createObjectInternal(com.sumroch.spotme.models.db.PromotionData.class, json.getString("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }
        if (json.has("beacon_id")) {
            if (json.isNull("beacon_id")) {
                ((PromotionDataRealmProxyInterface) obj).realmSet$beacon_id(null);
            } else {
                ((PromotionDataRealmProxyInterface) obj).realmSet$beacon_id((String) json.getString("beacon_id"));
            }
        }
        if (json.has("promotion_id")) {
            if (json.isNull("promotion_id")) {
                ((PromotionDataRealmProxyInterface) obj).realmSet$promotion_id(null);
            } else {
                ((PromotionDataRealmProxyInterface) obj).realmSet$promotion_id((String) json.getString("promotion_id"));
            }
        }
        if (json.has("created_at")) {
            if (json.isNull("created_at")) {
                ((PromotionDataRealmProxyInterface) obj).realmSet$created_at(null);
            } else {
                ((PromotionDataRealmProxyInterface) obj).realmSet$created_at((String) json.getString("created_at"));
            }
        }
        if (json.has("updated_at")) {
            if (json.isNull("updated_at")) {
                ((PromotionDataRealmProxyInterface) obj).realmSet$updated_at(null);
            } else {
                ((PromotionDataRealmProxyInterface) obj).realmSet$updated_at((String) json.getString("updated_at"));
            }
        }
        if (json.has("promotion")) {
            if (json.isNull("promotion")) {
                ((PromotionDataRealmProxyInterface) obj).realmSet$promotion(null);
            } else {
                com.sumroch.spotme.models.db.Promotion promotionObj = PromotionRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("promotion"), update);
                ((PromotionDataRealmProxyInterface) obj).realmSet$promotion(promotionObj);
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.sumroch.spotme.models.db.PromotionData createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.sumroch.spotme.models.db.PromotionData obj = new com.sumroch.spotme.models.db.PromotionData();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((PromotionDataRealmProxyInterface) obj).realmSet$id(null);
                } else {
                    ((PromotionDataRealmProxyInterface) obj).realmSet$id((String) reader.nextString());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("beacon_id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((PromotionDataRealmProxyInterface) obj).realmSet$beacon_id(null);
                } else {
                    ((PromotionDataRealmProxyInterface) obj).realmSet$beacon_id((String) reader.nextString());
                }
            } else if (name.equals("promotion_id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((PromotionDataRealmProxyInterface) obj).realmSet$promotion_id(null);
                } else {
                    ((PromotionDataRealmProxyInterface) obj).realmSet$promotion_id((String) reader.nextString());
                }
            } else if (name.equals("created_at")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((PromotionDataRealmProxyInterface) obj).realmSet$created_at(null);
                } else {
                    ((PromotionDataRealmProxyInterface) obj).realmSet$created_at((String) reader.nextString());
                }
            } else if (name.equals("updated_at")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((PromotionDataRealmProxyInterface) obj).realmSet$updated_at(null);
                } else {
                    ((PromotionDataRealmProxyInterface) obj).realmSet$updated_at((String) reader.nextString());
                }
            } else if (name.equals("promotion")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((PromotionDataRealmProxyInterface) obj).realmSet$promotion(null);
                } else {
                    com.sumroch.spotme.models.db.Promotion promotionObj = PromotionRealmProxy.createUsingJsonStream(realm, reader);
                    ((PromotionDataRealmProxyInterface) obj).realmSet$promotion(promotionObj);
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

    public static com.sumroch.spotme.models.db.PromotionData copyOrUpdate(Realm realm, com.sumroch.spotme.models.db.PromotionData object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.sumroch.spotme.models.db.PromotionData) cachedRealmObject;
        } else {
            com.sumroch.spotme.models.db.PromotionData realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.sumroch.spotme.models.db.PromotionData.class);
                long pkColumnIndex = table.getPrimaryKey();
                String value = ((PromotionDataRealmProxyInterface) object).realmGet$id();
                long rowIndex = Table.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstString(pkColumnIndex, value);
                }
                if (rowIndex != Table.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.sumroch.spotme.models.db.PromotionData.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.PromotionDataRealmProxy();
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

    public static com.sumroch.spotme.models.db.PromotionData copy(Realm realm, com.sumroch.spotme.models.db.PromotionData newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.sumroch.spotme.models.db.PromotionData) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.sumroch.spotme.models.db.PromotionData realmObject = realm.createObjectInternal(com.sumroch.spotme.models.db.PromotionData.class, ((PromotionDataRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((PromotionDataRealmProxyInterface) realmObject).realmSet$beacon_id(((PromotionDataRealmProxyInterface) newObject).realmGet$beacon_id());
            ((PromotionDataRealmProxyInterface) realmObject).realmSet$promotion_id(((PromotionDataRealmProxyInterface) newObject).realmGet$promotion_id());
            ((PromotionDataRealmProxyInterface) realmObject).realmSet$created_at(((PromotionDataRealmProxyInterface) newObject).realmGet$created_at());
            ((PromotionDataRealmProxyInterface) realmObject).realmSet$updated_at(((PromotionDataRealmProxyInterface) newObject).realmGet$updated_at());

            com.sumroch.spotme.models.db.Promotion promotionObj = ((PromotionDataRealmProxyInterface) newObject).realmGet$promotion();
            if (promotionObj != null) {
                com.sumroch.spotme.models.db.Promotion cachepromotion = (com.sumroch.spotme.models.db.Promotion) cache.get(promotionObj);
                if (cachepromotion != null) {
                    ((PromotionDataRealmProxyInterface) realmObject).realmSet$promotion(cachepromotion);
                } else {
                    ((PromotionDataRealmProxyInterface) realmObject).realmSet$promotion(PromotionRealmProxy.copyOrUpdate(realm, promotionObj, update, cache));
                }
            } else {
                ((PromotionDataRealmProxyInterface) realmObject).realmSet$promotion(null);
            }
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.sumroch.spotme.models.db.PromotionData object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.sumroch.spotme.models.db.PromotionData.class);
        long tableNativePtr = table.getNativePtr();
        PromotionDataColumnInfo columnInfo = (PromotionDataColumnInfo) realm.schema.getColumnInfo(com.sumroch.spotme.models.db.PromotionData.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((PromotionDataRealmProxyInterface) object).realmGet$id();
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
        String realmGet$beacon_id = ((PromotionDataRealmProxyInterface)object).realmGet$beacon_id();
        if (realmGet$beacon_id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.beacon_idIndex, rowIndex, realmGet$beacon_id, false);
        }
        String realmGet$promotion_id = ((PromotionDataRealmProxyInterface)object).realmGet$promotion_id();
        if (realmGet$promotion_id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.promotion_idIndex, rowIndex, realmGet$promotion_id, false);
        }
        String realmGet$created_at = ((PromotionDataRealmProxyInterface)object).realmGet$created_at();
        if (realmGet$created_at != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.created_atIndex, rowIndex, realmGet$created_at, false);
        }
        String realmGet$updated_at = ((PromotionDataRealmProxyInterface)object).realmGet$updated_at();
        if (realmGet$updated_at != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.updated_atIndex, rowIndex, realmGet$updated_at, false);
        }

        com.sumroch.spotme.models.db.Promotion promotionObj = ((PromotionDataRealmProxyInterface) object).realmGet$promotion();
        if (promotionObj != null) {
            Long cachepromotion = cache.get(promotionObj);
            if (cachepromotion == null) {
                cachepromotion = PromotionRealmProxy.insert(realm, promotionObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.promotionIndex, rowIndex, cachepromotion, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.sumroch.spotme.models.db.PromotionData.class);
        long tableNativePtr = table.getNativePtr();
        PromotionDataColumnInfo columnInfo = (PromotionDataColumnInfo) realm.schema.getColumnInfo(com.sumroch.spotme.models.db.PromotionData.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.sumroch.spotme.models.db.PromotionData object = null;
        while (objects.hasNext()) {
            object = (com.sumroch.spotme.models.db.PromotionData) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((PromotionDataRealmProxyInterface) object).realmGet$id();
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
                String realmGet$beacon_id = ((PromotionDataRealmProxyInterface)object).realmGet$beacon_id();
                if (realmGet$beacon_id != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.beacon_idIndex, rowIndex, realmGet$beacon_id, false);
                }
                String realmGet$promotion_id = ((PromotionDataRealmProxyInterface)object).realmGet$promotion_id();
                if (realmGet$promotion_id != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.promotion_idIndex, rowIndex, realmGet$promotion_id, false);
                }
                String realmGet$created_at = ((PromotionDataRealmProxyInterface)object).realmGet$created_at();
                if (realmGet$created_at != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.created_atIndex, rowIndex, realmGet$created_at, false);
                }
                String realmGet$updated_at = ((PromotionDataRealmProxyInterface)object).realmGet$updated_at();
                if (realmGet$updated_at != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.updated_atIndex, rowIndex, realmGet$updated_at, false);
                }

                com.sumroch.spotme.models.db.Promotion promotionObj = ((PromotionDataRealmProxyInterface) object).realmGet$promotion();
                if (promotionObj != null) {
                    Long cachepromotion = cache.get(promotionObj);
                    if (cachepromotion == null) {
                        cachepromotion = PromotionRealmProxy.insert(realm, promotionObj, cache);
                    }
                    table.setLink(columnInfo.promotionIndex, rowIndex, cachepromotion, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.sumroch.spotme.models.db.PromotionData object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.sumroch.spotme.models.db.PromotionData.class);
        long tableNativePtr = table.getNativePtr();
        PromotionDataColumnInfo columnInfo = (PromotionDataColumnInfo) realm.schema.getColumnInfo(com.sumroch.spotme.models.db.PromotionData.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((PromotionDataRealmProxyInterface) object).realmGet$id();
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
        String realmGet$beacon_id = ((PromotionDataRealmProxyInterface)object).realmGet$beacon_id();
        if (realmGet$beacon_id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.beacon_idIndex, rowIndex, realmGet$beacon_id, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.beacon_idIndex, rowIndex, false);
        }
        String realmGet$promotion_id = ((PromotionDataRealmProxyInterface)object).realmGet$promotion_id();
        if (realmGet$promotion_id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.promotion_idIndex, rowIndex, realmGet$promotion_id, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.promotion_idIndex, rowIndex, false);
        }
        String realmGet$created_at = ((PromotionDataRealmProxyInterface)object).realmGet$created_at();
        if (realmGet$created_at != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.created_atIndex, rowIndex, realmGet$created_at, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.created_atIndex, rowIndex, false);
        }
        String realmGet$updated_at = ((PromotionDataRealmProxyInterface)object).realmGet$updated_at();
        if (realmGet$updated_at != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.updated_atIndex, rowIndex, realmGet$updated_at, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.updated_atIndex, rowIndex, false);
        }

        com.sumroch.spotme.models.db.Promotion promotionObj = ((PromotionDataRealmProxyInterface) object).realmGet$promotion();
        if (promotionObj != null) {
            Long cachepromotion = cache.get(promotionObj);
            if (cachepromotion == null) {
                cachepromotion = PromotionRealmProxy.insertOrUpdate(realm, promotionObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.promotionIndex, rowIndex, cachepromotion, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.promotionIndex, rowIndex);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.sumroch.spotme.models.db.PromotionData.class);
        long tableNativePtr = table.getNativePtr();
        PromotionDataColumnInfo columnInfo = (PromotionDataColumnInfo) realm.schema.getColumnInfo(com.sumroch.spotme.models.db.PromotionData.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.sumroch.spotme.models.db.PromotionData object = null;
        while (objects.hasNext()) {
            object = (com.sumroch.spotme.models.db.PromotionData) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((PromotionDataRealmProxyInterface) object).realmGet$id();
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
                String realmGet$beacon_id = ((PromotionDataRealmProxyInterface)object).realmGet$beacon_id();
                if (realmGet$beacon_id != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.beacon_idIndex, rowIndex, realmGet$beacon_id, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.beacon_idIndex, rowIndex, false);
                }
                String realmGet$promotion_id = ((PromotionDataRealmProxyInterface)object).realmGet$promotion_id();
                if (realmGet$promotion_id != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.promotion_idIndex, rowIndex, realmGet$promotion_id, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.promotion_idIndex, rowIndex, false);
                }
                String realmGet$created_at = ((PromotionDataRealmProxyInterface)object).realmGet$created_at();
                if (realmGet$created_at != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.created_atIndex, rowIndex, realmGet$created_at, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.created_atIndex, rowIndex, false);
                }
                String realmGet$updated_at = ((PromotionDataRealmProxyInterface)object).realmGet$updated_at();
                if (realmGet$updated_at != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.updated_atIndex, rowIndex, realmGet$updated_at, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.updated_atIndex, rowIndex, false);
                }

                com.sumroch.spotme.models.db.Promotion promotionObj = ((PromotionDataRealmProxyInterface) object).realmGet$promotion();
                if (promotionObj != null) {
                    Long cachepromotion = cache.get(promotionObj);
                    if (cachepromotion == null) {
                        cachepromotion = PromotionRealmProxy.insertOrUpdate(realm, promotionObj, cache);
                    }
                    Table.nativeSetLink(tableNativePtr, columnInfo.promotionIndex, rowIndex, cachepromotion, false);
                } else {
                    Table.nativeNullifyLink(tableNativePtr, columnInfo.promotionIndex, rowIndex);
                }
            }
        }
    }

    public static com.sumroch.spotme.models.db.PromotionData createDetachedCopy(com.sumroch.spotme.models.db.PromotionData realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.sumroch.spotme.models.db.PromotionData unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.sumroch.spotme.models.db.PromotionData)cachedObject.object;
            } else {
                unmanagedObject = (com.sumroch.spotme.models.db.PromotionData)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.sumroch.spotme.models.db.PromotionData();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((PromotionDataRealmProxyInterface) unmanagedObject).realmSet$id(((PromotionDataRealmProxyInterface) realmObject).realmGet$id());
        ((PromotionDataRealmProxyInterface) unmanagedObject).realmSet$beacon_id(((PromotionDataRealmProxyInterface) realmObject).realmGet$beacon_id());
        ((PromotionDataRealmProxyInterface) unmanagedObject).realmSet$promotion_id(((PromotionDataRealmProxyInterface) realmObject).realmGet$promotion_id());
        ((PromotionDataRealmProxyInterface) unmanagedObject).realmSet$created_at(((PromotionDataRealmProxyInterface) realmObject).realmGet$created_at());
        ((PromotionDataRealmProxyInterface) unmanagedObject).realmSet$updated_at(((PromotionDataRealmProxyInterface) realmObject).realmGet$updated_at());

        // Deep copy of promotion
        ((PromotionDataRealmProxyInterface) unmanagedObject).realmSet$promotion(PromotionRealmProxy.createDetachedCopy(((PromotionDataRealmProxyInterface) realmObject).realmGet$promotion(), currentDepth + 1, maxDepth, cache));
        return unmanagedObject;
    }

    static com.sumroch.spotme.models.db.PromotionData update(Realm realm, com.sumroch.spotme.models.db.PromotionData realmObject, com.sumroch.spotme.models.db.PromotionData newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((PromotionDataRealmProxyInterface) realmObject).realmSet$beacon_id(((PromotionDataRealmProxyInterface) newObject).realmGet$beacon_id());
        ((PromotionDataRealmProxyInterface) realmObject).realmSet$promotion_id(((PromotionDataRealmProxyInterface) newObject).realmGet$promotion_id());
        ((PromotionDataRealmProxyInterface) realmObject).realmSet$created_at(((PromotionDataRealmProxyInterface) newObject).realmGet$created_at());
        ((PromotionDataRealmProxyInterface) realmObject).realmSet$updated_at(((PromotionDataRealmProxyInterface) newObject).realmGet$updated_at());
        com.sumroch.spotme.models.db.Promotion promotionObj = ((PromotionDataRealmProxyInterface) newObject).realmGet$promotion();
        if (promotionObj != null) {
            com.sumroch.spotme.models.db.Promotion cachepromotion = (com.sumroch.spotme.models.db.Promotion) cache.get(promotionObj);
            if (cachepromotion != null) {
                ((PromotionDataRealmProxyInterface) realmObject).realmSet$promotion(cachepromotion);
            } else {
                ((PromotionDataRealmProxyInterface) realmObject).realmSet$promotion(PromotionRealmProxy.copyOrUpdate(realm, promotionObj, true, cache));
            }
        } else {
            ((PromotionDataRealmProxyInterface) realmObject).realmSet$promotion(null);
        }
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("PromotionData = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{beacon_id:");
        stringBuilder.append(realmGet$beacon_id() != null ? realmGet$beacon_id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{promotion_id:");
        stringBuilder.append(realmGet$promotion_id() != null ? realmGet$promotion_id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{created_at:");
        stringBuilder.append(realmGet$created_at() != null ? realmGet$created_at() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{updated_at:");
        stringBuilder.append(realmGet$updated_at() != null ? realmGet$updated_at() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{promotion:");
        stringBuilder.append(realmGet$promotion() != null ? "Promotion" : "null");
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
        PromotionDataRealmProxy aPromotionData = (PromotionDataRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aPromotionData.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aPromotionData.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aPromotionData.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
