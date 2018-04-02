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

public class PromotionRealmProxy extends com.sumroch.spotme.models.db.Promotion
    implements RealmObjectProxy, PromotionRealmProxyInterface {

    static final class PromotionColumnInfo extends ColumnInfo {
        long idIndex;
        long titleIndex;
        long short_descriptionIndex;
        long contentIndex;
        long pictureIndex;
        long urlIndex;
        long expiredIndex;
        long created_atIndex;
        long updated_atIndex;
        long discountIndex;

        PromotionColumnInfo(SharedRealm realm, Table table) {
            super(10);
            this.idIndex = addColumnDetails(table, "id", RealmFieldType.STRING);
            this.titleIndex = addColumnDetails(table, "title", RealmFieldType.STRING);
            this.short_descriptionIndex = addColumnDetails(table, "short_description", RealmFieldType.STRING);
            this.contentIndex = addColumnDetails(table, "content", RealmFieldType.STRING);
            this.pictureIndex = addColumnDetails(table, "picture", RealmFieldType.STRING);
            this.urlIndex = addColumnDetails(table, "url", RealmFieldType.STRING);
            this.expiredIndex = addColumnDetails(table, "expired", RealmFieldType.STRING);
            this.created_atIndex = addColumnDetails(table, "created_at", RealmFieldType.STRING);
            this.updated_atIndex = addColumnDetails(table, "updated_at", RealmFieldType.STRING);
            this.discountIndex = addColumnDetails(table, "discount", RealmFieldType.FLOAT);
        }

        PromotionColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new PromotionColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final PromotionColumnInfo src = (PromotionColumnInfo) rawSrc;
            final PromotionColumnInfo dst = (PromotionColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.titleIndex = src.titleIndex;
            dst.short_descriptionIndex = src.short_descriptionIndex;
            dst.contentIndex = src.contentIndex;
            dst.pictureIndex = src.pictureIndex;
            dst.urlIndex = src.urlIndex;
            dst.expiredIndex = src.expiredIndex;
            dst.created_atIndex = src.created_atIndex;
            dst.updated_atIndex = src.updated_atIndex;
            dst.discountIndex = src.discountIndex;
        }
    }

    private PromotionColumnInfo columnInfo;
    private ProxyState<com.sumroch.spotme.models.db.Promotion> proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("title");
        fieldNames.add("short_description");
        fieldNames.add("content");
        fieldNames.add("picture");
        fieldNames.add("url");
        fieldNames.add("expired");
        fieldNames.add("created_at");
        fieldNames.add("updated_at");
        fieldNames.add("discount");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    PromotionRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (PromotionColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.sumroch.spotme.models.db.Promotion>(this);
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
    public String realmGet$title() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.titleIndex);
    }

    @Override
    public void realmSet$title(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.titleIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.titleIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.titleIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.titleIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$short_description() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.short_descriptionIndex);
    }

    @Override
    public void realmSet$short_description(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.short_descriptionIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.short_descriptionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.short_descriptionIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.short_descriptionIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$content() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.contentIndex);
    }

    @Override
    public void realmSet$content(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.contentIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.contentIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.contentIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.contentIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$picture() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.pictureIndex);
    }

    @Override
    public void realmSet$picture(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.pictureIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.pictureIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.pictureIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.pictureIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$url() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.urlIndex);
    }

    @Override
    public void realmSet$url(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.urlIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.urlIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.urlIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.urlIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$expired() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.expiredIndex);
    }

    @Override
    public void realmSet$expired(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.expiredIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.expiredIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.expiredIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.expiredIndex, value);
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
    @SuppressWarnings("cast")
    public float realmGet$discount() {
        proxyState.getRealm$realm().checkIfValid();
        return (float) proxyState.getRow$realm().getFloat(columnInfo.discountIndex);
    }

    @Override
    public void realmSet$discount(float value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setFloat(columnInfo.discountIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setFloat(columnInfo.discountIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("Promotion")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("Promotion");
            realmObjectSchema.add("id", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("title", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("short_description", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("content", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("picture", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("url", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("expired", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("created_at", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("updated_at", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("discount", RealmFieldType.FLOAT, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            return realmObjectSchema;
        }
        return realmSchema.get("Promotion");
    }

    public static PromotionColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (!sharedRealm.hasTable("class_Promotion")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'Promotion' class is missing from the schema for this Realm.");
        }
        Table table = sharedRealm.getTable("class_Promotion");
        final long columnCount = table.getColumnCount();
        if (columnCount != 10) {
            if (columnCount < 10) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 10 but was " + columnCount);
            }
            if (allowExtraColumns) {
                RealmLog.debug("Field count is more than expected - expected 10 but was %1$d", columnCount);
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 10 but was " + columnCount);
            }
        }
        Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
        for (long i = 0; i < columnCount; i++) {
            columnTypes.put(table.getColumnName(i), table.getColumnType(i));
        }

        final PromotionColumnInfo columnInfo = new PromotionColumnInfo(sharedRealm, table);

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
        if (!columnTypes.containsKey("title")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'title' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("title") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'title' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.titleIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'title' is required. Either set @Required to field 'title' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("short_description")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'short_description' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("short_description") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'short_description' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.short_descriptionIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'short_description' is required. Either set @Required to field 'short_description' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("content")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'content' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("content") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'content' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.contentIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'content' is required. Either set @Required to field 'content' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("picture")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'picture' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("picture") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'picture' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.pictureIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'picture' is required. Either set @Required to field 'picture' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("url")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'url' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("url") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'url' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.urlIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'url' is required. Either set @Required to field 'url' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("expired")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'expired' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("expired") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'expired' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.expiredIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'expired' is required. Either set @Required to field 'expired' or migrate using RealmObjectSchema.setNullable().");
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
        if (!columnTypes.containsKey("discount")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'discount' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("discount") != RealmFieldType.FLOAT) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'float' for field 'discount' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.discountIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'discount' does support null values in the existing Realm file. Use corresponding boxed type for field 'discount' or migrate using RealmObjectSchema.setNullable().");
        }

        return columnInfo;
    }

    public static String getTableName() {
        return "class_Promotion";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.sumroch.spotme.models.db.Promotion createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.sumroch.spotme.models.db.Promotion obj = null;
        if (update) {
            Table table = realm.getTable(com.sumroch.spotme.models.db.Promotion.class);
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.sumroch.spotme.models.db.Promotion.class), false, Collections.<String> emptyList());
                    obj = new io.realm.PromotionRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.PromotionRealmProxy) realm.createObjectInternal(com.sumroch.spotme.models.db.Promotion.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.PromotionRealmProxy) realm.createObjectInternal(com.sumroch.spotme.models.db.Promotion.class, json.getString("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }
        if (json.has("title")) {
            if (json.isNull("title")) {
                ((PromotionRealmProxyInterface) obj).realmSet$title(null);
            } else {
                ((PromotionRealmProxyInterface) obj).realmSet$title((String) json.getString("title"));
            }
        }
        if (json.has("short_description")) {
            if (json.isNull("short_description")) {
                ((PromotionRealmProxyInterface) obj).realmSet$short_description(null);
            } else {
                ((PromotionRealmProxyInterface) obj).realmSet$short_description((String) json.getString("short_description"));
            }
        }
        if (json.has("content")) {
            if (json.isNull("content")) {
                ((PromotionRealmProxyInterface) obj).realmSet$content(null);
            } else {
                ((PromotionRealmProxyInterface) obj).realmSet$content((String) json.getString("content"));
            }
        }
        if (json.has("picture")) {
            if (json.isNull("picture")) {
                ((PromotionRealmProxyInterface) obj).realmSet$picture(null);
            } else {
                ((PromotionRealmProxyInterface) obj).realmSet$picture((String) json.getString("picture"));
            }
        }
        if (json.has("url")) {
            if (json.isNull("url")) {
                ((PromotionRealmProxyInterface) obj).realmSet$url(null);
            } else {
                ((PromotionRealmProxyInterface) obj).realmSet$url((String) json.getString("url"));
            }
        }
        if (json.has("expired")) {
            if (json.isNull("expired")) {
                ((PromotionRealmProxyInterface) obj).realmSet$expired(null);
            } else {
                ((PromotionRealmProxyInterface) obj).realmSet$expired((String) json.getString("expired"));
            }
        }
        if (json.has("created_at")) {
            if (json.isNull("created_at")) {
                ((PromotionRealmProxyInterface) obj).realmSet$created_at(null);
            } else {
                ((PromotionRealmProxyInterface) obj).realmSet$created_at((String) json.getString("created_at"));
            }
        }
        if (json.has("updated_at")) {
            if (json.isNull("updated_at")) {
                ((PromotionRealmProxyInterface) obj).realmSet$updated_at(null);
            } else {
                ((PromotionRealmProxyInterface) obj).realmSet$updated_at((String) json.getString("updated_at"));
            }
        }
        if (json.has("discount")) {
            if (json.isNull("discount")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'discount' to null.");
            } else {
                ((PromotionRealmProxyInterface) obj).realmSet$discount((float) json.getDouble("discount"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.sumroch.spotme.models.db.Promotion createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.sumroch.spotme.models.db.Promotion obj = new com.sumroch.spotme.models.db.Promotion();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((PromotionRealmProxyInterface) obj).realmSet$id(null);
                } else {
                    ((PromotionRealmProxyInterface) obj).realmSet$id((String) reader.nextString());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("title")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((PromotionRealmProxyInterface) obj).realmSet$title(null);
                } else {
                    ((PromotionRealmProxyInterface) obj).realmSet$title((String) reader.nextString());
                }
            } else if (name.equals("short_description")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((PromotionRealmProxyInterface) obj).realmSet$short_description(null);
                } else {
                    ((PromotionRealmProxyInterface) obj).realmSet$short_description((String) reader.nextString());
                }
            } else if (name.equals("content")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((PromotionRealmProxyInterface) obj).realmSet$content(null);
                } else {
                    ((PromotionRealmProxyInterface) obj).realmSet$content((String) reader.nextString());
                }
            } else if (name.equals("picture")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((PromotionRealmProxyInterface) obj).realmSet$picture(null);
                } else {
                    ((PromotionRealmProxyInterface) obj).realmSet$picture((String) reader.nextString());
                }
            } else if (name.equals("url")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((PromotionRealmProxyInterface) obj).realmSet$url(null);
                } else {
                    ((PromotionRealmProxyInterface) obj).realmSet$url((String) reader.nextString());
                }
            } else if (name.equals("expired")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((PromotionRealmProxyInterface) obj).realmSet$expired(null);
                } else {
                    ((PromotionRealmProxyInterface) obj).realmSet$expired((String) reader.nextString());
                }
            } else if (name.equals("created_at")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((PromotionRealmProxyInterface) obj).realmSet$created_at(null);
                } else {
                    ((PromotionRealmProxyInterface) obj).realmSet$created_at((String) reader.nextString());
                }
            } else if (name.equals("updated_at")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((PromotionRealmProxyInterface) obj).realmSet$updated_at(null);
                } else {
                    ((PromotionRealmProxyInterface) obj).realmSet$updated_at((String) reader.nextString());
                }
            } else if (name.equals("discount")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'discount' to null.");
                } else {
                    ((PromotionRealmProxyInterface) obj).realmSet$discount((float) reader.nextDouble());
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

    public static com.sumroch.spotme.models.db.Promotion copyOrUpdate(Realm realm, com.sumroch.spotme.models.db.Promotion object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.sumroch.spotme.models.db.Promotion) cachedRealmObject;
        } else {
            com.sumroch.spotme.models.db.Promotion realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.sumroch.spotme.models.db.Promotion.class);
                long pkColumnIndex = table.getPrimaryKey();
                String value = ((PromotionRealmProxyInterface) object).realmGet$id();
                long rowIndex = Table.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstString(pkColumnIndex, value);
                }
                if (rowIndex != Table.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.sumroch.spotme.models.db.Promotion.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.PromotionRealmProxy();
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

    public static com.sumroch.spotme.models.db.Promotion copy(Realm realm, com.sumroch.spotme.models.db.Promotion newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.sumroch.spotme.models.db.Promotion) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.sumroch.spotme.models.db.Promotion realmObject = realm.createObjectInternal(com.sumroch.spotme.models.db.Promotion.class, ((PromotionRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((PromotionRealmProxyInterface) realmObject).realmSet$title(((PromotionRealmProxyInterface) newObject).realmGet$title());
            ((PromotionRealmProxyInterface) realmObject).realmSet$short_description(((PromotionRealmProxyInterface) newObject).realmGet$short_description());
            ((PromotionRealmProxyInterface) realmObject).realmSet$content(((PromotionRealmProxyInterface) newObject).realmGet$content());
            ((PromotionRealmProxyInterface) realmObject).realmSet$picture(((PromotionRealmProxyInterface) newObject).realmGet$picture());
            ((PromotionRealmProxyInterface) realmObject).realmSet$url(((PromotionRealmProxyInterface) newObject).realmGet$url());
            ((PromotionRealmProxyInterface) realmObject).realmSet$expired(((PromotionRealmProxyInterface) newObject).realmGet$expired());
            ((PromotionRealmProxyInterface) realmObject).realmSet$created_at(((PromotionRealmProxyInterface) newObject).realmGet$created_at());
            ((PromotionRealmProxyInterface) realmObject).realmSet$updated_at(((PromotionRealmProxyInterface) newObject).realmGet$updated_at());
            ((PromotionRealmProxyInterface) realmObject).realmSet$discount(((PromotionRealmProxyInterface) newObject).realmGet$discount());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.sumroch.spotme.models.db.Promotion object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.sumroch.spotme.models.db.Promotion.class);
        long tableNativePtr = table.getNativePtr();
        PromotionColumnInfo columnInfo = (PromotionColumnInfo) realm.schema.getColumnInfo(com.sumroch.spotme.models.db.Promotion.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((PromotionRealmProxyInterface) object).realmGet$id();
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
        String realmGet$title = ((PromotionRealmProxyInterface)object).realmGet$title();
        if (realmGet$title != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
        }
        String realmGet$short_description = ((PromotionRealmProxyInterface)object).realmGet$short_description();
        if (realmGet$short_description != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.short_descriptionIndex, rowIndex, realmGet$short_description, false);
        }
        String realmGet$content = ((PromotionRealmProxyInterface)object).realmGet$content();
        if (realmGet$content != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.contentIndex, rowIndex, realmGet$content, false);
        }
        String realmGet$picture = ((PromotionRealmProxyInterface)object).realmGet$picture();
        if (realmGet$picture != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.pictureIndex, rowIndex, realmGet$picture, false);
        }
        String realmGet$url = ((PromotionRealmProxyInterface)object).realmGet$url();
        if (realmGet$url != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.urlIndex, rowIndex, realmGet$url, false);
        }
        String realmGet$expired = ((PromotionRealmProxyInterface)object).realmGet$expired();
        if (realmGet$expired != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.expiredIndex, rowIndex, realmGet$expired, false);
        }
        String realmGet$created_at = ((PromotionRealmProxyInterface)object).realmGet$created_at();
        if (realmGet$created_at != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.created_atIndex, rowIndex, realmGet$created_at, false);
        }
        String realmGet$updated_at = ((PromotionRealmProxyInterface)object).realmGet$updated_at();
        if (realmGet$updated_at != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.updated_atIndex, rowIndex, realmGet$updated_at, false);
        }
        Table.nativeSetFloat(tableNativePtr, columnInfo.discountIndex, rowIndex, ((PromotionRealmProxyInterface)object).realmGet$discount(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.sumroch.spotme.models.db.Promotion.class);
        long tableNativePtr = table.getNativePtr();
        PromotionColumnInfo columnInfo = (PromotionColumnInfo) realm.schema.getColumnInfo(com.sumroch.spotme.models.db.Promotion.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.sumroch.spotme.models.db.Promotion object = null;
        while (objects.hasNext()) {
            object = (com.sumroch.spotme.models.db.Promotion) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((PromotionRealmProxyInterface) object).realmGet$id();
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
                String realmGet$title = ((PromotionRealmProxyInterface)object).realmGet$title();
                if (realmGet$title != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
                }
                String realmGet$short_description = ((PromotionRealmProxyInterface)object).realmGet$short_description();
                if (realmGet$short_description != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.short_descriptionIndex, rowIndex, realmGet$short_description, false);
                }
                String realmGet$content = ((PromotionRealmProxyInterface)object).realmGet$content();
                if (realmGet$content != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.contentIndex, rowIndex, realmGet$content, false);
                }
                String realmGet$picture = ((PromotionRealmProxyInterface)object).realmGet$picture();
                if (realmGet$picture != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.pictureIndex, rowIndex, realmGet$picture, false);
                }
                String realmGet$url = ((PromotionRealmProxyInterface)object).realmGet$url();
                if (realmGet$url != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.urlIndex, rowIndex, realmGet$url, false);
                }
                String realmGet$expired = ((PromotionRealmProxyInterface)object).realmGet$expired();
                if (realmGet$expired != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.expiredIndex, rowIndex, realmGet$expired, false);
                }
                String realmGet$created_at = ((PromotionRealmProxyInterface)object).realmGet$created_at();
                if (realmGet$created_at != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.created_atIndex, rowIndex, realmGet$created_at, false);
                }
                String realmGet$updated_at = ((PromotionRealmProxyInterface)object).realmGet$updated_at();
                if (realmGet$updated_at != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.updated_atIndex, rowIndex, realmGet$updated_at, false);
                }
                Table.nativeSetFloat(tableNativePtr, columnInfo.discountIndex, rowIndex, ((PromotionRealmProxyInterface)object).realmGet$discount(), false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.sumroch.spotme.models.db.Promotion object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.sumroch.spotme.models.db.Promotion.class);
        long tableNativePtr = table.getNativePtr();
        PromotionColumnInfo columnInfo = (PromotionColumnInfo) realm.schema.getColumnInfo(com.sumroch.spotme.models.db.Promotion.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((PromotionRealmProxyInterface) object).realmGet$id();
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
        String realmGet$title = ((PromotionRealmProxyInterface)object).realmGet$title();
        if (realmGet$title != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.titleIndex, rowIndex, false);
        }
        String realmGet$short_description = ((PromotionRealmProxyInterface)object).realmGet$short_description();
        if (realmGet$short_description != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.short_descriptionIndex, rowIndex, realmGet$short_description, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.short_descriptionIndex, rowIndex, false);
        }
        String realmGet$content = ((PromotionRealmProxyInterface)object).realmGet$content();
        if (realmGet$content != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.contentIndex, rowIndex, realmGet$content, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.contentIndex, rowIndex, false);
        }
        String realmGet$picture = ((PromotionRealmProxyInterface)object).realmGet$picture();
        if (realmGet$picture != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.pictureIndex, rowIndex, realmGet$picture, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.pictureIndex, rowIndex, false);
        }
        String realmGet$url = ((PromotionRealmProxyInterface)object).realmGet$url();
        if (realmGet$url != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.urlIndex, rowIndex, realmGet$url, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.urlIndex, rowIndex, false);
        }
        String realmGet$expired = ((PromotionRealmProxyInterface)object).realmGet$expired();
        if (realmGet$expired != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.expiredIndex, rowIndex, realmGet$expired, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.expiredIndex, rowIndex, false);
        }
        String realmGet$created_at = ((PromotionRealmProxyInterface)object).realmGet$created_at();
        if (realmGet$created_at != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.created_atIndex, rowIndex, realmGet$created_at, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.created_atIndex, rowIndex, false);
        }
        String realmGet$updated_at = ((PromotionRealmProxyInterface)object).realmGet$updated_at();
        if (realmGet$updated_at != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.updated_atIndex, rowIndex, realmGet$updated_at, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.updated_atIndex, rowIndex, false);
        }
        Table.nativeSetFloat(tableNativePtr, columnInfo.discountIndex, rowIndex, ((PromotionRealmProxyInterface)object).realmGet$discount(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.sumroch.spotme.models.db.Promotion.class);
        long tableNativePtr = table.getNativePtr();
        PromotionColumnInfo columnInfo = (PromotionColumnInfo) realm.schema.getColumnInfo(com.sumroch.spotme.models.db.Promotion.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.sumroch.spotme.models.db.Promotion object = null;
        while (objects.hasNext()) {
            object = (com.sumroch.spotme.models.db.Promotion) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((PromotionRealmProxyInterface) object).realmGet$id();
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
                String realmGet$title = ((PromotionRealmProxyInterface)object).realmGet$title();
                if (realmGet$title != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.titleIndex, rowIndex, realmGet$title, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.titleIndex, rowIndex, false);
                }
                String realmGet$short_description = ((PromotionRealmProxyInterface)object).realmGet$short_description();
                if (realmGet$short_description != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.short_descriptionIndex, rowIndex, realmGet$short_description, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.short_descriptionIndex, rowIndex, false);
                }
                String realmGet$content = ((PromotionRealmProxyInterface)object).realmGet$content();
                if (realmGet$content != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.contentIndex, rowIndex, realmGet$content, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.contentIndex, rowIndex, false);
                }
                String realmGet$picture = ((PromotionRealmProxyInterface)object).realmGet$picture();
                if (realmGet$picture != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.pictureIndex, rowIndex, realmGet$picture, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.pictureIndex, rowIndex, false);
                }
                String realmGet$url = ((PromotionRealmProxyInterface)object).realmGet$url();
                if (realmGet$url != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.urlIndex, rowIndex, realmGet$url, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.urlIndex, rowIndex, false);
                }
                String realmGet$expired = ((PromotionRealmProxyInterface)object).realmGet$expired();
                if (realmGet$expired != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.expiredIndex, rowIndex, realmGet$expired, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.expiredIndex, rowIndex, false);
                }
                String realmGet$created_at = ((PromotionRealmProxyInterface)object).realmGet$created_at();
                if (realmGet$created_at != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.created_atIndex, rowIndex, realmGet$created_at, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.created_atIndex, rowIndex, false);
                }
                String realmGet$updated_at = ((PromotionRealmProxyInterface)object).realmGet$updated_at();
                if (realmGet$updated_at != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.updated_atIndex, rowIndex, realmGet$updated_at, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.updated_atIndex, rowIndex, false);
                }
                Table.nativeSetFloat(tableNativePtr, columnInfo.discountIndex, rowIndex, ((PromotionRealmProxyInterface)object).realmGet$discount(), false);
            }
        }
    }

    public static com.sumroch.spotme.models.db.Promotion createDetachedCopy(com.sumroch.spotme.models.db.Promotion realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.sumroch.spotme.models.db.Promotion unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.sumroch.spotme.models.db.Promotion)cachedObject.object;
            } else {
                unmanagedObject = (com.sumroch.spotme.models.db.Promotion)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.sumroch.spotme.models.db.Promotion();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((PromotionRealmProxyInterface) unmanagedObject).realmSet$id(((PromotionRealmProxyInterface) realmObject).realmGet$id());
        ((PromotionRealmProxyInterface) unmanagedObject).realmSet$title(((PromotionRealmProxyInterface) realmObject).realmGet$title());
        ((PromotionRealmProxyInterface) unmanagedObject).realmSet$short_description(((PromotionRealmProxyInterface) realmObject).realmGet$short_description());
        ((PromotionRealmProxyInterface) unmanagedObject).realmSet$content(((PromotionRealmProxyInterface) realmObject).realmGet$content());
        ((PromotionRealmProxyInterface) unmanagedObject).realmSet$picture(((PromotionRealmProxyInterface) realmObject).realmGet$picture());
        ((PromotionRealmProxyInterface) unmanagedObject).realmSet$url(((PromotionRealmProxyInterface) realmObject).realmGet$url());
        ((PromotionRealmProxyInterface) unmanagedObject).realmSet$expired(((PromotionRealmProxyInterface) realmObject).realmGet$expired());
        ((PromotionRealmProxyInterface) unmanagedObject).realmSet$created_at(((PromotionRealmProxyInterface) realmObject).realmGet$created_at());
        ((PromotionRealmProxyInterface) unmanagedObject).realmSet$updated_at(((PromotionRealmProxyInterface) realmObject).realmGet$updated_at());
        ((PromotionRealmProxyInterface) unmanagedObject).realmSet$discount(((PromotionRealmProxyInterface) realmObject).realmGet$discount());
        return unmanagedObject;
    }

    static com.sumroch.spotme.models.db.Promotion update(Realm realm, com.sumroch.spotme.models.db.Promotion realmObject, com.sumroch.spotme.models.db.Promotion newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((PromotionRealmProxyInterface) realmObject).realmSet$title(((PromotionRealmProxyInterface) newObject).realmGet$title());
        ((PromotionRealmProxyInterface) realmObject).realmSet$short_description(((PromotionRealmProxyInterface) newObject).realmGet$short_description());
        ((PromotionRealmProxyInterface) realmObject).realmSet$content(((PromotionRealmProxyInterface) newObject).realmGet$content());
        ((PromotionRealmProxyInterface) realmObject).realmSet$picture(((PromotionRealmProxyInterface) newObject).realmGet$picture());
        ((PromotionRealmProxyInterface) realmObject).realmSet$url(((PromotionRealmProxyInterface) newObject).realmGet$url());
        ((PromotionRealmProxyInterface) realmObject).realmSet$expired(((PromotionRealmProxyInterface) newObject).realmGet$expired());
        ((PromotionRealmProxyInterface) realmObject).realmSet$created_at(((PromotionRealmProxyInterface) newObject).realmGet$created_at());
        ((PromotionRealmProxyInterface) realmObject).realmSet$updated_at(((PromotionRealmProxyInterface) newObject).realmGet$updated_at());
        ((PromotionRealmProxyInterface) realmObject).realmSet$discount(((PromotionRealmProxyInterface) newObject).realmGet$discount());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Promotion = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{title:");
        stringBuilder.append(realmGet$title() != null ? realmGet$title() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{short_description:");
        stringBuilder.append(realmGet$short_description() != null ? realmGet$short_description() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{content:");
        stringBuilder.append(realmGet$content() != null ? realmGet$content() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{picture:");
        stringBuilder.append(realmGet$picture() != null ? realmGet$picture() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{url:");
        stringBuilder.append(realmGet$url() != null ? realmGet$url() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{expired:");
        stringBuilder.append(realmGet$expired() != null ? realmGet$expired() : "null");
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
        stringBuilder.append("{discount:");
        stringBuilder.append(realmGet$discount());
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
        PromotionRealmProxy aPromotion = (PromotionRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aPromotion.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aPromotion.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aPromotion.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
