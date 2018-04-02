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

public class DealsRealmProxy extends com.sumroch.spotme.models.Deals
    implements RealmObjectProxy, DealsRealmProxyInterface {

    static final class DealsColumnInfo extends ColumnInfo {
        long idIndex;
        long codeIndex;
        long nameIndex;
        long descriptionIndex;
        long pictureIndex;
        long priceIndex;
        long discountIndex;
        long stockIndex;
        long viewerIndex;
        long likersCountIndex;

        DealsColumnInfo(SharedRealm realm, Table table) {
            super(10);
            this.idIndex = addColumnDetails(table, "id", RealmFieldType.INTEGER);
            this.codeIndex = addColumnDetails(table, "code", RealmFieldType.STRING);
            this.nameIndex = addColumnDetails(table, "name", RealmFieldType.STRING);
            this.descriptionIndex = addColumnDetails(table, "description", RealmFieldType.STRING);
            this.pictureIndex = addColumnDetails(table, "picture", RealmFieldType.STRING);
            this.priceIndex = addColumnDetails(table, "price", RealmFieldType.DOUBLE);
            this.discountIndex = addColumnDetails(table, "discount", RealmFieldType.DOUBLE);
            this.stockIndex = addColumnDetails(table, "stock", RealmFieldType.INTEGER);
            this.viewerIndex = addColumnDetails(table, "viewer", RealmFieldType.INTEGER);
            this.likersCountIndex = addColumnDetails(table, "likersCount", RealmFieldType.INTEGER);
        }

        DealsColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new DealsColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final DealsColumnInfo src = (DealsColumnInfo) rawSrc;
            final DealsColumnInfo dst = (DealsColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.codeIndex = src.codeIndex;
            dst.nameIndex = src.nameIndex;
            dst.descriptionIndex = src.descriptionIndex;
            dst.pictureIndex = src.pictureIndex;
            dst.priceIndex = src.priceIndex;
            dst.discountIndex = src.discountIndex;
            dst.stockIndex = src.stockIndex;
            dst.viewerIndex = src.viewerIndex;
            dst.likersCountIndex = src.likersCountIndex;
        }
    }

    private DealsColumnInfo columnInfo;
    private ProxyState<com.sumroch.spotme.models.Deals> proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("code");
        fieldNames.add("name");
        fieldNames.add("description");
        fieldNames.add("picture");
        fieldNames.add("price");
        fieldNames.add("discount");
        fieldNames.add("stock");
        fieldNames.add("viewer");
        fieldNames.add("likersCount");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    DealsRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (DealsColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.sumroch.spotme.models.Deals>(this);
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
    public String realmGet$code() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.codeIndex);
    }

    @Override
    public void realmSet$code(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.codeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.codeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.codeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.codeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$name() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nameIndex);
    }

    @Override
    public void realmSet$name(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$description() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.descriptionIndex);
    }

    @Override
    public void realmSet$description(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.descriptionIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.descriptionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.descriptionIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.descriptionIndex, value);
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
    public double realmGet$price() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.priceIndex);
    }

    @Override
    public void realmSet$price(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.priceIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.priceIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$discount() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.discountIndex);
    }

    @Override
    public void realmSet$discount(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.discountIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.discountIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$stock() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.stockIndex);
    }

    @Override
    public void realmSet$stock(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.stockIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.stockIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$viewer() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.viewerIndex);
    }

    @Override
    public void realmSet$viewer(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.viewerIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.viewerIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$likersCount() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.likersCountIndex);
    }

    @Override
    public void realmSet$likersCount(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.likersCountIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.likersCountIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("Deals")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("Deals");
            realmObjectSchema.add("id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("code", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("description", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("picture", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("price", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("discount", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("stock", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("viewer", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("likersCount", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            return realmObjectSchema;
        }
        return realmSchema.get("Deals");
    }

    public static DealsColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (!sharedRealm.hasTable("class_Deals")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'Deals' class is missing from the schema for this Realm.");
        }
        Table table = sharedRealm.getTable("class_Deals");
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

        final DealsColumnInfo columnInfo = new DealsColumnInfo(sharedRealm, table);

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
        if (!columnTypes.containsKey("code")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'code' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("code") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'code' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.codeIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'code' is required. Either set @Required to field 'code' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("name")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'name' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("name") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'name' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.nameIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'name' is required. Either set @Required to field 'name' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("description")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'description' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("description") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'description' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.descriptionIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'description' is required. Either set @Required to field 'description' or migrate using RealmObjectSchema.setNullable().");
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
        if (!columnTypes.containsKey("price")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'price' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("price") != RealmFieldType.DOUBLE) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'double' for field 'price' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.priceIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'price' does support null values in the existing Realm file. Use corresponding boxed type for field 'price' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("discount")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'discount' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("discount") != RealmFieldType.DOUBLE) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'double' for field 'discount' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.discountIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'discount' does support null values in the existing Realm file. Use corresponding boxed type for field 'discount' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("stock")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'stock' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("stock") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'stock' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.stockIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'stock' does support null values in the existing Realm file. Use corresponding boxed type for field 'stock' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("viewer")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'viewer' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("viewer") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'viewer' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.viewerIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'viewer' does support null values in the existing Realm file. Use corresponding boxed type for field 'viewer' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("likersCount")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'likersCount' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("likersCount") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'likersCount' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.likersCountIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'likersCount' does support null values in the existing Realm file. Use corresponding boxed type for field 'likersCount' or migrate using RealmObjectSchema.setNullable().");
        }

        return columnInfo;
    }

    public static String getTableName() {
        return "class_Deals";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.sumroch.spotme.models.Deals createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.sumroch.spotme.models.Deals obj = null;
        if (update) {
            Table table = realm.getTable(com.sumroch.spotme.models.Deals.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("id")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.sumroch.spotme.models.Deals.class), false, Collections.<String> emptyList());
                    obj = new io.realm.DealsRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.DealsRealmProxy) realm.createObjectInternal(com.sumroch.spotme.models.Deals.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.DealsRealmProxy) realm.createObjectInternal(com.sumroch.spotme.models.Deals.class, json.getInt("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }
        if (json.has("code")) {
            if (json.isNull("code")) {
                ((DealsRealmProxyInterface) obj).realmSet$code(null);
            } else {
                ((DealsRealmProxyInterface) obj).realmSet$code((String) json.getString("code"));
            }
        }
        if (json.has("name")) {
            if (json.isNull("name")) {
                ((DealsRealmProxyInterface) obj).realmSet$name(null);
            } else {
                ((DealsRealmProxyInterface) obj).realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("description")) {
            if (json.isNull("description")) {
                ((DealsRealmProxyInterface) obj).realmSet$description(null);
            } else {
                ((DealsRealmProxyInterface) obj).realmSet$description((String) json.getString("description"));
            }
        }
        if (json.has("picture")) {
            if (json.isNull("picture")) {
                ((DealsRealmProxyInterface) obj).realmSet$picture(null);
            } else {
                ((DealsRealmProxyInterface) obj).realmSet$picture((String) json.getString("picture"));
            }
        }
        if (json.has("price")) {
            if (json.isNull("price")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'price' to null.");
            } else {
                ((DealsRealmProxyInterface) obj).realmSet$price((double) json.getDouble("price"));
            }
        }
        if (json.has("discount")) {
            if (json.isNull("discount")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'discount' to null.");
            } else {
                ((DealsRealmProxyInterface) obj).realmSet$discount((double) json.getDouble("discount"));
            }
        }
        if (json.has("stock")) {
            if (json.isNull("stock")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'stock' to null.");
            } else {
                ((DealsRealmProxyInterface) obj).realmSet$stock((int) json.getInt("stock"));
            }
        }
        if (json.has("viewer")) {
            if (json.isNull("viewer")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'viewer' to null.");
            } else {
                ((DealsRealmProxyInterface) obj).realmSet$viewer((int) json.getInt("viewer"));
            }
        }
        if (json.has("likersCount")) {
            if (json.isNull("likersCount")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'likersCount' to null.");
            } else {
                ((DealsRealmProxyInterface) obj).realmSet$likersCount((int) json.getInt("likersCount"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.sumroch.spotme.models.Deals createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.sumroch.spotme.models.Deals obj = new com.sumroch.spotme.models.Deals();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
                } else {
                    ((DealsRealmProxyInterface) obj).realmSet$id((int) reader.nextInt());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("code")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((DealsRealmProxyInterface) obj).realmSet$code(null);
                } else {
                    ((DealsRealmProxyInterface) obj).realmSet$code((String) reader.nextString());
                }
            } else if (name.equals("name")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((DealsRealmProxyInterface) obj).realmSet$name(null);
                } else {
                    ((DealsRealmProxyInterface) obj).realmSet$name((String) reader.nextString());
                }
            } else if (name.equals("description")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((DealsRealmProxyInterface) obj).realmSet$description(null);
                } else {
                    ((DealsRealmProxyInterface) obj).realmSet$description((String) reader.nextString());
                }
            } else if (name.equals("picture")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((DealsRealmProxyInterface) obj).realmSet$picture(null);
                } else {
                    ((DealsRealmProxyInterface) obj).realmSet$picture((String) reader.nextString());
                }
            } else if (name.equals("price")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'price' to null.");
                } else {
                    ((DealsRealmProxyInterface) obj).realmSet$price((double) reader.nextDouble());
                }
            } else if (name.equals("discount")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'discount' to null.");
                } else {
                    ((DealsRealmProxyInterface) obj).realmSet$discount((double) reader.nextDouble());
                }
            } else if (name.equals("stock")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'stock' to null.");
                } else {
                    ((DealsRealmProxyInterface) obj).realmSet$stock((int) reader.nextInt());
                }
            } else if (name.equals("viewer")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'viewer' to null.");
                } else {
                    ((DealsRealmProxyInterface) obj).realmSet$viewer((int) reader.nextInt());
                }
            } else if (name.equals("likersCount")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'likersCount' to null.");
                } else {
                    ((DealsRealmProxyInterface) obj).realmSet$likersCount((int) reader.nextInt());
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

    public static com.sumroch.spotme.models.Deals copyOrUpdate(Realm realm, com.sumroch.spotme.models.Deals object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.sumroch.spotme.models.Deals) cachedRealmObject;
        } else {
            com.sumroch.spotme.models.Deals realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.sumroch.spotme.models.Deals.class);
                long pkColumnIndex = table.getPrimaryKey();
                long rowIndex = table.findFirstLong(pkColumnIndex, ((DealsRealmProxyInterface) object).realmGet$id());
                if (rowIndex != Table.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.sumroch.spotme.models.Deals.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.DealsRealmProxy();
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

    public static com.sumroch.spotme.models.Deals copy(Realm realm, com.sumroch.spotme.models.Deals newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.sumroch.spotme.models.Deals) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.sumroch.spotme.models.Deals realmObject = realm.createObjectInternal(com.sumroch.spotme.models.Deals.class, ((DealsRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((DealsRealmProxyInterface) realmObject).realmSet$code(((DealsRealmProxyInterface) newObject).realmGet$code());
            ((DealsRealmProxyInterface) realmObject).realmSet$name(((DealsRealmProxyInterface) newObject).realmGet$name());
            ((DealsRealmProxyInterface) realmObject).realmSet$description(((DealsRealmProxyInterface) newObject).realmGet$description());
            ((DealsRealmProxyInterface) realmObject).realmSet$picture(((DealsRealmProxyInterface) newObject).realmGet$picture());
            ((DealsRealmProxyInterface) realmObject).realmSet$price(((DealsRealmProxyInterface) newObject).realmGet$price());
            ((DealsRealmProxyInterface) realmObject).realmSet$discount(((DealsRealmProxyInterface) newObject).realmGet$discount());
            ((DealsRealmProxyInterface) realmObject).realmSet$stock(((DealsRealmProxyInterface) newObject).realmGet$stock());
            ((DealsRealmProxyInterface) realmObject).realmSet$viewer(((DealsRealmProxyInterface) newObject).realmGet$viewer());
            ((DealsRealmProxyInterface) realmObject).realmSet$likersCount(((DealsRealmProxyInterface) newObject).realmGet$likersCount());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.sumroch.spotme.models.Deals object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.sumroch.spotme.models.Deals.class);
        long tableNativePtr = table.getNativePtr();
        DealsColumnInfo columnInfo = (DealsColumnInfo) realm.schema.getColumnInfo(com.sumroch.spotme.models.Deals.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((DealsRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((DealsRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((DealsRealmProxyInterface) object).realmGet$id());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$code = ((DealsRealmProxyInterface)object).realmGet$code();
        if (realmGet$code != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.codeIndex, rowIndex, realmGet$code, false);
        }
        String realmGet$name = ((DealsRealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        }
        String realmGet$description = ((DealsRealmProxyInterface)object).realmGet$description();
        if (realmGet$description != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
        }
        String realmGet$picture = ((DealsRealmProxyInterface)object).realmGet$picture();
        if (realmGet$picture != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.pictureIndex, rowIndex, realmGet$picture, false);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.priceIndex, rowIndex, ((DealsRealmProxyInterface)object).realmGet$price(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.discountIndex, rowIndex, ((DealsRealmProxyInterface)object).realmGet$discount(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.stockIndex, rowIndex, ((DealsRealmProxyInterface)object).realmGet$stock(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.viewerIndex, rowIndex, ((DealsRealmProxyInterface)object).realmGet$viewer(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.likersCountIndex, rowIndex, ((DealsRealmProxyInterface)object).realmGet$likersCount(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.sumroch.spotme.models.Deals.class);
        long tableNativePtr = table.getNativePtr();
        DealsColumnInfo columnInfo = (DealsColumnInfo) realm.schema.getColumnInfo(com.sumroch.spotme.models.Deals.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.sumroch.spotme.models.Deals object = null;
        while (objects.hasNext()) {
            object = (com.sumroch.spotme.models.Deals) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.NO_MATCH;
                Object primaryKeyValue = ((DealsRealmProxyInterface) object).realmGet$id();
                if (primaryKeyValue != null) {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((DealsRealmProxyInterface) object).realmGet$id());
                }
                if (rowIndex == Table.NO_MATCH) {
                    rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((DealsRealmProxyInterface) object).realmGet$id());
                } else {
                    Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
                }
                cache.put(object, rowIndex);
                String realmGet$code = ((DealsRealmProxyInterface)object).realmGet$code();
                if (realmGet$code != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.codeIndex, rowIndex, realmGet$code, false);
                }
                String realmGet$name = ((DealsRealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
                }
                String realmGet$description = ((DealsRealmProxyInterface)object).realmGet$description();
                if (realmGet$description != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
                }
                String realmGet$picture = ((DealsRealmProxyInterface)object).realmGet$picture();
                if (realmGet$picture != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.pictureIndex, rowIndex, realmGet$picture, false);
                }
                Table.nativeSetDouble(tableNativePtr, columnInfo.priceIndex, rowIndex, ((DealsRealmProxyInterface)object).realmGet$price(), false);
                Table.nativeSetDouble(tableNativePtr, columnInfo.discountIndex, rowIndex, ((DealsRealmProxyInterface)object).realmGet$discount(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.stockIndex, rowIndex, ((DealsRealmProxyInterface)object).realmGet$stock(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.viewerIndex, rowIndex, ((DealsRealmProxyInterface)object).realmGet$viewer(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.likersCountIndex, rowIndex, ((DealsRealmProxyInterface)object).realmGet$likersCount(), false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.sumroch.spotme.models.Deals object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.sumroch.spotme.models.Deals.class);
        long tableNativePtr = table.getNativePtr();
        DealsColumnInfo columnInfo = (DealsColumnInfo) realm.schema.getColumnInfo(com.sumroch.spotme.models.Deals.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((DealsRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((DealsRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((DealsRealmProxyInterface) object).realmGet$id());
        }
        cache.put(object, rowIndex);
        String realmGet$code = ((DealsRealmProxyInterface)object).realmGet$code();
        if (realmGet$code != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.codeIndex, rowIndex, realmGet$code, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.codeIndex, rowIndex, false);
        }
        String realmGet$name = ((DealsRealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
        }
        String realmGet$description = ((DealsRealmProxyInterface)object).realmGet$description();
        if (realmGet$description != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.descriptionIndex, rowIndex, false);
        }
        String realmGet$picture = ((DealsRealmProxyInterface)object).realmGet$picture();
        if (realmGet$picture != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.pictureIndex, rowIndex, realmGet$picture, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.pictureIndex, rowIndex, false);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.priceIndex, rowIndex, ((DealsRealmProxyInterface)object).realmGet$price(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.discountIndex, rowIndex, ((DealsRealmProxyInterface)object).realmGet$discount(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.stockIndex, rowIndex, ((DealsRealmProxyInterface)object).realmGet$stock(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.viewerIndex, rowIndex, ((DealsRealmProxyInterface)object).realmGet$viewer(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.likersCountIndex, rowIndex, ((DealsRealmProxyInterface)object).realmGet$likersCount(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.sumroch.spotme.models.Deals.class);
        long tableNativePtr = table.getNativePtr();
        DealsColumnInfo columnInfo = (DealsColumnInfo) realm.schema.getColumnInfo(com.sumroch.spotme.models.Deals.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.sumroch.spotme.models.Deals object = null;
        while (objects.hasNext()) {
            object = (com.sumroch.spotme.models.Deals) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.NO_MATCH;
                Object primaryKeyValue = ((DealsRealmProxyInterface) object).realmGet$id();
                if (primaryKeyValue != null) {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((DealsRealmProxyInterface) object).realmGet$id());
                }
                if (rowIndex == Table.NO_MATCH) {
                    rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((DealsRealmProxyInterface) object).realmGet$id());
                }
                cache.put(object, rowIndex);
                String realmGet$code = ((DealsRealmProxyInterface)object).realmGet$code();
                if (realmGet$code != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.codeIndex, rowIndex, realmGet$code, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.codeIndex, rowIndex, false);
                }
                String realmGet$name = ((DealsRealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
                }
                String realmGet$description = ((DealsRealmProxyInterface)object).realmGet$description();
                if (realmGet$description != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.descriptionIndex, rowIndex, false);
                }
                String realmGet$picture = ((DealsRealmProxyInterface)object).realmGet$picture();
                if (realmGet$picture != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.pictureIndex, rowIndex, realmGet$picture, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.pictureIndex, rowIndex, false);
                }
                Table.nativeSetDouble(tableNativePtr, columnInfo.priceIndex, rowIndex, ((DealsRealmProxyInterface)object).realmGet$price(), false);
                Table.nativeSetDouble(tableNativePtr, columnInfo.discountIndex, rowIndex, ((DealsRealmProxyInterface)object).realmGet$discount(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.stockIndex, rowIndex, ((DealsRealmProxyInterface)object).realmGet$stock(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.viewerIndex, rowIndex, ((DealsRealmProxyInterface)object).realmGet$viewer(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.likersCountIndex, rowIndex, ((DealsRealmProxyInterface)object).realmGet$likersCount(), false);
            }
        }
    }

    public static com.sumroch.spotme.models.Deals createDetachedCopy(com.sumroch.spotme.models.Deals realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.sumroch.spotme.models.Deals unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.sumroch.spotme.models.Deals)cachedObject.object;
            } else {
                unmanagedObject = (com.sumroch.spotme.models.Deals)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.sumroch.spotme.models.Deals();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((DealsRealmProxyInterface) unmanagedObject).realmSet$id(((DealsRealmProxyInterface) realmObject).realmGet$id());
        ((DealsRealmProxyInterface) unmanagedObject).realmSet$code(((DealsRealmProxyInterface) realmObject).realmGet$code());
        ((DealsRealmProxyInterface) unmanagedObject).realmSet$name(((DealsRealmProxyInterface) realmObject).realmGet$name());
        ((DealsRealmProxyInterface) unmanagedObject).realmSet$description(((DealsRealmProxyInterface) realmObject).realmGet$description());
        ((DealsRealmProxyInterface) unmanagedObject).realmSet$picture(((DealsRealmProxyInterface) realmObject).realmGet$picture());
        ((DealsRealmProxyInterface) unmanagedObject).realmSet$price(((DealsRealmProxyInterface) realmObject).realmGet$price());
        ((DealsRealmProxyInterface) unmanagedObject).realmSet$discount(((DealsRealmProxyInterface) realmObject).realmGet$discount());
        ((DealsRealmProxyInterface) unmanagedObject).realmSet$stock(((DealsRealmProxyInterface) realmObject).realmGet$stock());
        ((DealsRealmProxyInterface) unmanagedObject).realmSet$viewer(((DealsRealmProxyInterface) realmObject).realmGet$viewer());
        ((DealsRealmProxyInterface) unmanagedObject).realmSet$likersCount(((DealsRealmProxyInterface) realmObject).realmGet$likersCount());
        return unmanagedObject;
    }

    static com.sumroch.spotme.models.Deals update(Realm realm, com.sumroch.spotme.models.Deals realmObject, com.sumroch.spotme.models.Deals newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((DealsRealmProxyInterface) realmObject).realmSet$code(((DealsRealmProxyInterface) newObject).realmGet$code());
        ((DealsRealmProxyInterface) realmObject).realmSet$name(((DealsRealmProxyInterface) newObject).realmGet$name());
        ((DealsRealmProxyInterface) realmObject).realmSet$description(((DealsRealmProxyInterface) newObject).realmGet$description());
        ((DealsRealmProxyInterface) realmObject).realmSet$picture(((DealsRealmProxyInterface) newObject).realmGet$picture());
        ((DealsRealmProxyInterface) realmObject).realmSet$price(((DealsRealmProxyInterface) newObject).realmGet$price());
        ((DealsRealmProxyInterface) realmObject).realmSet$discount(((DealsRealmProxyInterface) newObject).realmGet$discount());
        ((DealsRealmProxyInterface) realmObject).realmSet$stock(((DealsRealmProxyInterface) newObject).realmGet$stock());
        ((DealsRealmProxyInterface) realmObject).realmSet$viewer(((DealsRealmProxyInterface) newObject).realmGet$viewer());
        ((DealsRealmProxyInterface) realmObject).realmSet$likersCount(((DealsRealmProxyInterface) newObject).realmGet$likersCount());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Deals = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{code:");
        stringBuilder.append(realmGet$code() != null ? realmGet$code() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{description:");
        stringBuilder.append(realmGet$description() != null ? realmGet$description() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{picture:");
        stringBuilder.append(realmGet$picture() != null ? realmGet$picture() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{price:");
        stringBuilder.append(realmGet$price());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{discount:");
        stringBuilder.append(realmGet$discount());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{stock:");
        stringBuilder.append(realmGet$stock());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{viewer:");
        stringBuilder.append(realmGet$viewer());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{likersCount:");
        stringBuilder.append(realmGet$likersCount());
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
        DealsRealmProxy aDeals = (DealsRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aDeals.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aDeals.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aDeals.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
