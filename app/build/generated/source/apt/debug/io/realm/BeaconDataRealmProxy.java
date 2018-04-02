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

public class BeaconDataRealmProxy extends com.sumroch.spotme.models.db.BeaconData
    implements RealmObjectProxy, BeaconDataRealmProxyInterface {

    static final class BeaconDataColumnInfo extends ColumnInfo {
        long idIndex;
        long nameIndex;
        long uuidIndex;
        long majorIndex;
        long minorIndex;
        long x_positionIndex;
        long y_positionIndex;
        long positionIndex;
        long created_atIndex;
        long updated_atIndex;
        long promotionDataIndex;

        BeaconDataColumnInfo(SharedRealm realm, Table table) {
            super(11);
            this.idIndex = addColumnDetails(table, "id", RealmFieldType.STRING);
            this.nameIndex = addColumnDetails(table, "name", RealmFieldType.STRING);
            this.uuidIndex = addColumnDetails(table, "uuid", RealmFieldType.STRING);
            this.majorIndex = addColumnDetails(table, "major", RealmFieldType.STRING);
            this.minorIndex = addColumnDetails(table, "minor", RealmFieldType.STRING);
            this.x_positionIndex = addColumnDetails(table, "x_position", RealmFieldType.STRING);
            this.y_positionIndex = addColumnDetails(table, "y_position", RealmFieldType.STRING);
            this.positionIndex = addColumnDetails(table, "position", RealmFieldType.STRING);
            this.created_atIndex = addColumnDetails(table, "created_at", RealmFieldType.STRING);
            this.updated_atIndex = addColumnDetails(table, "updated_at", RealmFieldType.STRING);
            this.promotionDataIndex = addColumnDetails(table, "promotionData", RealmFieldType.LIST);
        }

        BeaconDataColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new BeaconDataColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final BeaconDataColumnInfo src = (BeaconDataColumnInfo) rawSrc;
            final BeaconDataColumnInfo dst = (BeaconDataColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.nameIndex = src.nameIndex;
            dst.uuidIndex = src.uuidIndex;
            dst.majorIndex = src.majorIndex;
            dst.minorIndex = src.minorIndex;
            dst.x_positionIndex = src.x_positionIndex;
            dst.y_positionIndex = src.y_positionIndex;
            dst.positionIndex = src.positionIndex;
            dst.created_atIndex = src.created_atIndex;
            dst.updated_atIndex = src.updated_atIndex;
            dst.promotionDataIndex = src.promotionDataIndex;
        }
    }

    private BeaconDataColumnInfo columnInfo;
    private ProxyState<com.sumroch.spotme.models.db.BeaconData> proxyState;
    private RealmList<com.sumroch.spotme.models.db.PromotionData> promotionDataRealmList;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("name");
        fieldNames.add("uuid");
        fieldNames.add("major");
        fieldNames.add("minor");
        fieldNames.add("x_position");
        fieldNames.add("y_position");
        fieldNames.add("position");
        fieldNames.add("created_at");
        fieldNames.add("updated_at");
        fieldNames.add("promotionData");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    BeaconDataRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (BeaconDataColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.sumroch.spotme.models.db.BeaconData>(this);
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
    public String realmGet$major() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.majorIndex);
    }

    @Override
    public void realmSet$major(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.majorIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.majorIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.majorIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.majorIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$minor() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.minorIndex);
    }

    @Override
    public void realmSet$minor(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.minorIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.minorIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.minorIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.minorIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$x_position() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.x_positionIndex);
    }

    @Override
    public void realmSet$x_position(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.x_positionIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.x_positionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.x_positionIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.x_positionIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$y_position() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.y_positionIndex);
    }

    @Override
    public void realmSet$y_position(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.y_positionIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.y_positionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.y_positionIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.y_positionIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$position() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.positionIndex);
    }

    @Override
    public void realmSet$position(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.positionIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.positionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.positionIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.positionIndex, value);
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
    public RealmList<com.sumroch.spotme.models.db.PromotionData> realmGet$promotionData() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (promotionDataRealmList != null) {
            return promotionDataRealmList;
        } else {
            LinkView linkView = proxyState.getRow$realm().getLinkList(columnInfo.promotionDataIndex);
            promotionDataRealmList = new RealmList<com.sumroch.spotme.models.db.PromotionData>(com.sumroch.spotme.models.db.PromotionData.class, linkView, proxyState.getRealm$realm());
            return promotionDataRealmList;
        }
    }

    @Override
    public void realmSet$promotionData(RealmList<com.sumroch.spotme.models.db.PromotionData> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("promotionData")) {
                return;
            }
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<com.sumroch.spotme.models.db.PromotionData> original = value;
                value = new RealmList<com.sumroch.spotme.models.db.PromotionData>();
                for (com.sumroch.spotme.models.db.PromotionData item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        LinkView links = proxyState.getRow$realm().getLinkList(columnInfo.promotionDataIndex);
        links.clear();
        if (value == null) {
            return;
        }
        for (RealmModel linkedObject : (RealmList<? extends RealmModel>) value) {
            if (!(RealmObject.isManaged(linkedObject) && RealmObject.isValid(linkedObject))) {
                throw new IllegalArgumentException("Each element of 'value' must be a valid managed object.");
            }
            if (((RealmObjectProxy)linkedObject).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
                throw new IllegalArgumentException("Each element of 'value' must belong to the same Realm.");
            }
            links.add(((RealmObjectProxy)linkedObject).realmGet$proxyState().getRow$realm().getIndex());
        }
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("BeaconData")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("BeaconData");
            realmObjectSchema.add("id", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("uuid", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("major", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("minor", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("x_position", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("y_position", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("position", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("created_at", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("updated_at", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            if (!realmSchema.contains("PromotionData")) {
                PromotionDataRealmProxy.createRealmObjectSchema(realmSchema);
            }
            realmObjectSchema.add("promotionData", RealmFieldType.LIST, realmSchema.get("PromotionData"));
            return realmObjectSchema;
        }
        return realmSchema.get("BeaconData");
    }

    public static BeaconDataColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (!sharedRealm.hasTable("class_BeaconData")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'BeaconData' class is missing from the schema for this Realm.");
        }
        Table table = sharedRealm.getTable("class_BeaconData");
        final long columnCount = table.getColumnCount();
        if (columnCount != 11) {
            if (columnCount < 11) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 11 but was " + columnCount);
            }
            if (allowExtraColumns) {
                RealmLog.debug("Field count is more than expected - expected 11 but was %1$d", columnCount);
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 11 but was " + columnCount);
            }
        }
        Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
        for (long i = 0; i < columnCount; i++) {
            columnTypes.put(table.getColumnName(i), table.getColumnType(i));
        }

        final BeaconDataColumnInfo columnInfo = new BeaconDataColumnInfo(sharedRealm, table);

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
        if (!columnTypes.containsKey("name")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'name' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("name") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'name' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.nameIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'name' is required. Either set @Required to field 'name' or migrate using RealmObjectSchema.setNullable().");
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
        if (columnTypes.get("major") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'major' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.majorIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'major' is required. Either set @Required to field 'major' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("minor")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'minor' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("minor") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'minor' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.minorIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'minor' is required. Either set @Required to field 'minor' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("x_position")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'x_position' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("x_position") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'x_position' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.x_positionIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'x_position' is required. Either set @Required to field 'x_position' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("y_position")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'y_position' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("y_position") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'y_position' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.y_positionIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'y_position' is required. Either set @Required to field 'y_position' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("position")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'position' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("position") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'position' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.positionIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'position' is required. Either set @Required to field 'position' or migrate using RealmObjectSchema.setNullable().");
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
        if (!columnTypes.containsKey("promotionData")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'promotionData'");
        }
        if (columnTypes.get("promotionData") != RealmFieldType.LIST) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'PromotionData' for field 'promotionData'");
        }
        if (!sharedRealm.hasTable("class_PromotionData")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing class 'class_PromotionData' for field 'promotionData'");
        }
        Table table_10 = sharedRealm.getTable("class_PromotionData");
        if (!table.getLinkTarget(columnInfo.promotionDataIndex).hasSameSchema(table_10)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid RealmList type for field 'promotionData': '" + table.getLinkTarget(columnInfo.promotionDataIndex).getName() + "' expected - was '" + table_10.getName() + "'");
        }

        return columnInfo;
    }

    public static String getTableName() {
        return "class_BeaconData";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.sumroch.spotme.models.db.BeaconData createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(1);
        com.sumroch.spotme.models.db.BeaconData obj = null;
        if (update) {
            Table table = realm.getTable(com.sumroch.spotme.models.db.BeaconData.class);
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.sumroch.spotme.models.db.BeaconData.class), false, Collections.<String> emptyList());
                    obj = new io.realm.BeaconDataRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("promotionData")) {
                excludeFields.add("promotionData");
            }
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.BeaconDataRealmProxy) realm.createObjectInternal(com.sumroch.spotme.models.db.BeaconData.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.BeaconDataRealmProxy) realm.createObjectInternal(com.sumroch.spotme.models.db.BeaconData.class, json.getString("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }
        if (json.has("name")) {
            if (json.isNull("name")) {
                ((BeaconDataRealmProxyInterface) obj).realmSet$name(null);
            } else {
                ((BeaconDataRealmProxyInterface) obj).realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("uuid")) {
            if (json.isNull("uuid")) {
                ((BeaconDataRealmProxyInterface) obj).realmSet$uuid(null);
            } else {
                ((BeaconDataRealmProxyInterface) obj).realmSet$uuid((String) json.getString("uuid"));
            }
        }
        if (json.has("major")) {
            if (json.isNull("major")) {
                ((BeaconDataRealmProxyInterface) obj).realmSet$major(null);
            } else {
                ((BeaconDataRealmProxyInterface) obj).realmSet$major((String) json.getString("major"));
            }
        }
        if (json.has("minor")) {
            if (json.isNull("minor")) {
                ((BeaconDataRealmProxyInterface) obj).realmSet$minor(null);
            } else {
                ((BeaconDataRealmProxyInterface) obj).realmSet$minor((String) json.getString("minor"));
            }
        }
        if (json.has("x_position")) {
            if (json.isNull("x_position")) {
                ((BeaconDataRealmProxyInterface) obj).realmSet$x_position(null);
            } else {
                ((BeaconDataRealmProxyInterface) obj).realmSet$x_position((String) json.getString("x_position"));
            }
        }
        if (json.has("y_position")) {
            if (json.isNull("y_position")) {
                ((BeaconDataRealmProxyInterface) obj).realmSet$y_position(null);
            } else {
                ((BeaconDataRealmProxyInterface) obj).realmSet$y_position((String) json.getString("y_position"));
            }
        }
        if (json.has("position")) {
            if (json.isNull("position")) {
                ((BeaconDataRealmProxyInterface) obj).realmSet$position(null);
            } else {
                ((BeaconDataRealmProxyInterface) obj).realmSet$position((String) json.getString("position"));
            }
        }
        if (json.has("created_at")) {
            if (json.isNull("created_at")) {
                ((BeaconDataRealmProxyInterface) obj).realmSet$created_at(null);
            } else {
                ((BeaconDataRealmProxyInterface) obj).realmSet$created_at((String) json.getString("created_at"));
            }
        }
        if (json.has("updated_at")) {
            if (json.isNull("updated_at")) {
                ((BeaconDataRealmProxyInterface) obj).realmSet$updated_at(null);
            } else {
                ((BeaconDataRealmProxyInterface) obj).realmSet$updated_at((String) json.getString("updated_at"));
            }
        }
        if (json.has("promotionData")) {
            if (json.isNull("promotionData")) {
                ((BeaconDataRealmProxyInterface) obj).realmSet$promotionData(null);
            } else {
                ((BeaconDataRealmProxyInterface) obj).realmGet$promotionData().clear();
                JSONArray array = json.getJSONArray("promotionData");
                for (int i = 0; i < array.length(); i++) {
                    com.sumroch.spotme.models.db.PromotionData item = PromotionDataRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    ((BeaconDataRealmProxyInterface) obj).realmGet$promotionData().add(item);
                }
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.sumroch.spotme.models.db.BeaconData createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.sumroch.spotme.models.db.BeaconData obj = new com.sumroch.spotme.models.db.BeaconData();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((BeaconDataRealmProxyInterface) obj).realmSet$id(null);
                } else {
                    ((BeaconDataRealmProxyInterface) obj).realmSet$id((String) reader.nextString());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("name")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((BeaconDataRealmProxyInterface) obj).realmSet$name(null);
                } else {
                    ((BeaconDataRealmProxyInterface) obj).realmSet$name((String) reader.nextString());
                }
            } else if (name.equals("uuid")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((BeaconDataRealmProxyInterface) obj).realmSet$uuid(null);
                } else {
                    ((BeaconDataRealmProxyInterface) obj).realmSet$uuid((String) reader.nextString());
                }
            } else if (name.equals("major")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((BeaconDataRealmProxyInterface) obj).realmSet$major(null);
                } else {
                    ((BeaconDataRealmProxyInterface) obj).realmSet$major((String) reader.nextString());
                }
            } else if (name.equals("minor")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((BeaconDataRealmProxyInterface) obj).realmSet$minor(null);
                } else {
                    ((BeaconDataRealmProxyInterface) obj).realmSet$minor((String) reader.nextString());
                }
            } else if (name.equals("x_position")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((BeaconDataRealmProxyInterface) obj).realmSet$x_position(null);
                } else {
                    ((BeaconDataRealmProxyInterface) obj).realmSet$x_position((String) reader.nextString());
                }
            } else if (name.equals("y_position")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((BeaconDataRealmProxyInterface) obj).realmSet$y_position(null);
                } else {
                    ((BeaconDataRealmProxyInterface) obj).realmSet$y_position((String) reader.nextString());
                }
            } else if (name.equals("position")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((BeaconDataRealmProxyInterface) obj).realmSet$position(null);
                } else {
                    ((BeaconDataRealmProxyInterface) obj).realmSet$position((String) reader.nextString());
                }
            } else if (name.equals("created_at")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((BeaconDataRealmProxyInterface) obj).realmSet$created_at(null);
                } else {
                    ((BeaconDataRealmProxyInterface) obj).realmSet$created_at((String) reader.nextString());
                }
            } else if (name.equals("updated_at")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((BeaconDataRealmProxyInterface) obj).realmSet$updated_at(null);
                } else {
                    ((BeaconDataRealmProxyInterface) obj).realmSet$updated_at((String) reader.nextString());
                }
            } else if (name.equals("promotionData")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((BeaconDataRealmProxyInterface) obj).realmSet$promotionData(null);
                } else {
                    ((BeaconDataRealmProxyInterface) obj).realmSet$promotionData(new RealmList<com.sumroch.spotme.models.db.PromotionData>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.sumroch.spotme.models.db.PromotionData item = PromotionDataRealmProxy.createUsingJsonStream(realm, reader);
                        ((BeaconDataRealmProxyInterface) obj).realmGet$promotionData().add(item);
                    }
                    reader.endArray();
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

    public static com.sumroch.spotme.models.db.BeaconData copyOrUpdate(Realm realm, com.sumroch.spotme.models.db.BeaconData object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.sumroch.spotme.models.db.BeaconData) cachedRealmObject;
        } else {
            com.sumroch.spotme.models.db.BeaconData realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.sumroch.spotme.models.db.BeaconData.class);
                long pkColumnIndex = table.getPrimaryKey();
                String value = ((BeaconDataRealmProxyInterface) object).realmGet$id();
                long rowIndex = Table.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstString(pkColumnIndex, value);
                }
                if (rowIndex != Table.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.sumroch.spotme.models.db.BeaconData.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.BeaconDataRealmProxy();
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

    public static com.sumroch.spotme.models.db.BeaconData copy(Realm realm, com.sumroch.spotme.models.db.BeaconData newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.sumroch.spotme.models.db.BeaconData) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.sumroch.spotme.models.db.BeaconData realmObject = realm.createObjectInternal(com.sumroch.spotme.models.db.BeaconData.class, ((BeaconDataRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((BeaconDataRealmProxyInterface) realmObject).realmSet$name(((BeaconDataRealmProxyInterface) newObject).realmGet$name());
            ((BeaconDataRealmProxyInterface) realmObject).realmSet$uuid(((BeaconDataRealmProxyInterface) newObject).realmGet$uuid());
            ((BeaconDataRealmProxyInterface) realmObject).realmSet$major(((BeaconDataRealmProxyInterface) newObject).realmGet$major());
            ((BeaconDataRealmProxyInterface) realmObject).realmSet$minor(((BeaconDataRealmProxyInterface) newObject).realmGet$minor());
            ((BeaconDataRealmProxyInterface) realmObject).realmSet$x_position(((BeaconDataRealmProxyInterface) newObject).realmGet$x_position());
            ((BeaconDataRealmProxyInterface) realmObject).realmSet$y_position(((BeaconDataRealmProxyInterface) newObject).realmGet$y_position());
            ((BeaconDataRealmProxyInterface) realmObject).realmSet$position(((BeaconDataRealmProxyInterface) newObject).realmGet$position());
            ((BeaconDataRealmProxyInterface) realmObject).realmSet$created_at(((BeaconDataRealmProxyInterface) newObject).realmGet$created_at());
            ((BeaconDataRealmProxyInterface) realmObject).realmSet$updated_at(((BeaconDataRealmProxyInterface) newObject).realmGet$updated_at());

            RealmList<com.sumroch.spotme.models.db.PromotionData> promotionDataList = ((BeaconDataRealmProxyInterface) newObject).realmGet$promotionData();
            if (promotionDataList != null) {
                RealmList<com.sumroch.spotme.models.db.PromotionData> promotionDataRealmList = ((BeaconDataRealmProxyInterface) realmObject).realmGet$promotionData();
                for (int i = 0; i < promotionDataList.size(); i++) {
                    com.sumroch.spotme.models.db.PromotionData promotionDataItem = promotionDataList.get(i);
                    com.sumroch.spotme.models.db.PromotionData cachepromotionData = (com.sumroch.spotme.models.db.PromotionData) cache.get(promotionDataItem);
                    if (cachepromotionData != null) {
                        promotionDataRealmList.add(cachepromotionData);
                    } else {
                        promotionDataRealmList.add(PromotionDataRealmProxy.copyOrUpdate(realm, promotionDataList.get(i), update, cache));
                    }
                }
            }

            return realmObject;
        }
    }

    public static long insert(Realm realm, com.sumroch.spotme.models.db.BeaconData object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.sumroch.spotme.models.db.BeaconData.class);
        long tableNativePtr = table.getNativePtr();
        BeaconDataColumnInfo columnInfo = (BeaconDataColumnInfo) realm.schema.getColumnInfo(com.sumroch.spotme.models.db.BeaconData.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((BeaconDataRealmProxyInterface) object).realmGet$id();
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
        String realmGet$name = ((BeaconDataRealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        }
        String realmGet$uuid = ((BeaconDataRealmProxyInterface)object).realmGet$uuid();
        if (realmGet$uuid != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.uuidIndex, rowIndex, realmGet$uuid, false);
        }
        String realmGet$major = ((BeaconDataRealmProxyInterface)object).realmGet$major();
        if (realmGet$major != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.majorIndex, rowIndex, realmGet$major, false);
        }
        String realmGet$minor = ((BeaconDataRealmProxyInterface)object).realmGet$minor();
        if (realmGet$minor != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.minorIndex, rowIndex, realmGet$minor, false);
        }
        String realmGet$x_position = ((BeaconDataRealmProxyInterface)object).realmGet$x_position();
        if (realmGet$x_position != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.x_positionIndex, rowIndex, realmGet$x_position, false);
        }
        String realmGet$y_position = ((BeaconDataRealmProxyInterface)object).realmGet$y_position();
        if (realmGet$y_position != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.y_positionIndex, rowIndex, realmGet$y_position, false);
        }
        String realmGet$position = ((BeaconDataRealmProxyInterface)object).realmGet$position();
        if (realmGet$position != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.positionIndex, rowIndex, realmGet$position, false);
        }
        String realmGet$created_at = ((BeaconDataRealmProxyInterface)object).realmGet$created_at();
        if (realmGet$created_at != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.created_atIndex, rowIndex, realmGet$created_at, false);
        }
        String realmGet$updated_at = ((BeaconDataRealmProxyInterface)object).realmGet$updated_at();
        if (realmGet$updated_at != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.updated_atIndex, rowIndex, realmGet$updated_at, false);
        }

        RealmList<com.sumroch.spotme.models.db.PromotionData> promotionDataList = ((BeaconDataRealmProxyInterface) object).realmGet$promotionData();
        if (promotionDataList != null) {
            long promotionDataNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.promotionDataIndex, rowIndex);
            for (com.sumroch.spotme.models.db.PromotionData promotionDataItem : promotionDataList) {
                Long cacheItemIndexpromotionData = cache.get(promotionDataItem);
                if (cacheItemIndexpromotionData == null) {
                    cacheItemIndexpromotionData = PromotionDataRealmProxy.insert(realm, promotionDataItem, cache);
                }
                LinkView.nativeAdd(promotionDataNativeLinkViewPtr, cacheItemIndexpromotionData);
            }
        }

        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.sumroch.spotme.models.db.BeaconData.class);
        long tableNativePtr = table.getNativePtr();
        BeaconDataColumnInfo columnInfo = (BeaconDataColumnInfo) realm.schema.getColumnInfo(com.sumroch.spotme.models.db.BeaconData.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.sumroch.spotme.models.db.BeaconData object = null;
        while (objects.hasNext()) {
            object = (com.sumroch.spotme.models.db.BeaconData) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((BeaconDataRealmProxyInterface) object).realmGet$id();
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
                String realmGet$name = ((BeaconDataRealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
                }
                String realmGet$uuid = ((BeaconDataRealmProxyInterface)object).realmGet$uuid();
                if (realmGet$uuid != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.uuidIndex, rowIndex, realmGet$uuid, false);
                }
                String realmGet$major = ((BeaconDataRealmProxyInterface)object).realmGet$major();
                if (realmGet$major != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.majorIndex, rowIndex, realmGet$major, false);
                }
                String realmGet$minor = ((BeaconDataRealmProxyInterface)object).realmGet$minor();
                if (realmGet$minor != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.minorIndex, rowIndex, realmGet$minor, false);
                }
                String realmGet$x_position = ((BeaconDataRealmProxyInterface)object).realmGet$x_position();
                if (realmGet$x_position != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.x_positionIndex, rowIndex, realmGet$x_position, false);
                }
                String realmGet$y_position = ((BeaconDataRealmProxyInterface)object).realmGet$y_position();
                if (realmGet$y_position != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.y_positionIndex, rowIndex, realmGet$y_position, false);
                }
                String realmGet$position = ((BeaconDataRealmProxyInterface)object).realmGet$position();
                if (realmGet$position != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.positionIndex, rowIndex, realmGet$position, false);
                }
                String realmGet$created_at = ((BeaconDataRealmProxyInterface)object).realmGet$created_at();
                if (realmGet$created_at != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.created_atIndex, rowIndex, realmGet$created_at, false);
                }
                String realmGet$updated_at = ((BeaconDataRealmProxyInterface)object).realmGet$updated_at();
                if (realmGet$updated_at != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.updated_atIndex, rowIndex, realmGet$updated_at, false);
                }

                RealmList<com.sumroch.spotme.models.db.PromotionData> promotionDataList = ((BeaconDataRealmProxyInterface) object).realmGet$promotionData();
                if (promotionDataList != null) {
                    long promotionDataNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.promotionDataIndex, rowIndex);
                    for (com.sumroch.spotme.models.db.PromotionData promotionDataItem : promotionDataList) {
                        Long cacheItemIndexpromotionData = cache.get(promotionDataItem);
                        if (cacheItemIndexpromotionData == null) {
                            cacheItemIndexpromotionData = PromotionDataRealmProxy.insert(realm, promotionDataItem, cache);
                        }
                        LinkView.nativeAdd(promotionDataNativeLinkViewPtr, cacheItemIndexpromotionData);
                    }
                }

            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.sumroch.spotme.models.db.BeaconData object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.sumroch.spotme.models.db.BeaconData.class);
        long tableNativePtr = table.getNativePtr();
        BeaconDataColumnInfo columnInfo = (BeaconDataColumnInfo) realm.schema.getColumnInfo(com.sumroch.spotme.models.db.BeaconData.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((BeaconDataRealmProxyInterface) object).realmGet$id();
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
        String realmGet$name = ((BeaconDataRealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
        }
        String realmGet$uuid = ((BeaconDataRealmProxyInterface)object).realmGet$uuid();
        if (realmGet$uuid != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.uuidIndex, rowIndex, realmGet$uuid, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.uuidIndex, rowIndex, false);
        }
        String realmGet$major = ((BeaconDataRealmProxyInterface)object).realmGet$major();
        if (realmGet$major != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.majorIndex, rowIndex, realmGet$major, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.majorIndex, rowIndex, false);
        }
        String realmGet$minor = ((BeaconDataRealmProxyInterface)object).realmGet$minor();
        if (realmGet$minor != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.minorIndex, rowIndex, realmGet$minor, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.minorIndex, rowIndex, false);
        }
        String realmGet$x_position = ((BeaconDataRealmProxyInterface)object).realmGet$x_position();
        if (realmGet$x_position != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.x_positionIndex, rowIndex, realmGet$x_position, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.x_positionIndex, rowIndex, false);
        }
        String realmGet$y_position = ((BeaconDataRealmProxyInterface)object).realmGet$y_position();
        if (realmGet$y_position != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.y_positionIndex, rowIndex, realmGet$y_position, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.y_positionIndex, rowIndex, false);
        }
        String realmGet$position = ((BeaconDataRealmProxyInterface)object).realmGet$position();
        if (realmGet$position != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.positionIndex, rowIndex, realmGet$position, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.positionIndex, rowIndex, false);
        }
        String realmGet$created_at = ((BeaconDataRealmProxyInterface)object).realmGet$created_at();
        if (realmGet$created_at != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.created_atIndex, rowIndex, realmGet$created_at, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.created_atIndex, rowIndex, false);
        }
        String realmGet$updated_at = ((BeaconDataRealmProxyInterface)object).realmGet$updated_at();
        if (realmGet$updated_at != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.updated_atIndex, rowIndex, realmGet$updated_at, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.updated_atIndex, rowIndex, false);
        }

        long promotionDataNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.promotionDataIndex, rowIndex);
        LinkView.nativeClear(promotionDataNativeLinkViewPtr);
        RealmList<com.sumroch.spotme.models.db.PromotionData> promotionDataList = ((BeaconDataRealmProxyInterface) object).realmGet$promotionData();
        if (promotionDataList != null) {
            for (com.sumroch.spotme.models.db.PromotionData promotionDataItem : promotionDataList) {
                Long cacheItemIndexpromotionData = cache.get(promotionDataItem);
                if (cacheItemIndexpromotionData == null) {
                    cacheItemIndexpromotionData = PromotionDataRealmProxy.insertOrUpdate(realm, promotionDataItem, cache);
                }
                LinkView.nativeAdd(promotionDataNativeLinkViewPtr, cacheItemIndexpromotionData);
            }
        }

        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.sumroch.spotme.models.db.BeaconData.class);
        long tableNativePtr = table.getNativePtr();
        BeaconDataColumnInfo columnInfo = (BeaconDataColumnInfo) realm.schema.getColumnInfo(com.sumroch.spotme.models.db.BeaconData.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.sumroch.spotme.models.db.BeaconData object = null;
        while (objects.hasNext()) {
            object = (com.sumroch.spotme.models.db.BeaconData) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((BeaconDataRealmProxyInterface) object).realmGet$id();
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
                String realmGet$name = ((BeaconDataRealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
                }
                String realmGet$uuid = ((BeaconDataRealmProxyInterface)object).realmGet$uuid();
                if (realmGet$uuid != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.uuidIndex, rowIndex, realmGet$uuid, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.uuidIndex, rowIndex, false);
                }
                String realmGet$major = ((BeaconDataRealmProxyInterface)object).realmGet$major();
                if (realmGet$major != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.majorIndex, rowIndex, realmGet$major, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.majorIndex, rowIndex, false);
                }
                String realmGet$minor = ((BeaconDataRealmProxyInterface)object).realmGet$minor();
                if (realmGet$minor != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.minorIndex, rowIndex, realmGet$minor, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.minorIndex, rowIndex, false);
                }
                String realmGet$x_position = ((BeaconDataRealmProxyInterface)object).realmGet$x_position();
                if (realmGet$x_position != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.x_positionIndex, rowIndex, realmGet$x_position, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.x_positionIndex, rowIndex, false);
                }
                String realmGet$y_position = ((BeaconDataRealmProxyInterface)object).realmGet$y_position();
                if (realmGet$y_position != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.y_positionIndex, rowIndex, realmGet$y_position, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.y_positionIndex, rowIndex, false);
                }
                String realmGet$position = ((BeaconDataRealmProxyInterface)object).realmGet$position();
                if (realmGet$position != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.positionIndex, rowIndex, realmGet$position, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.positionIndex, rowIndex, false);
                }
                String realmGet$created_at = ((BeaconDataRealmProxyInterface)object).realmGet$created_at();
                if (realmGet$created_at != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.created_atIndex, rowIndex, realmGet$created_at, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.created_atIndex, rowIndex, false);
                }
                String realmGet$updated_at = ((BeaconDataRealmProxyInterface)object).realmGet$updated_at();
                if (realmGet$updated_at != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.updated_atIndex, rowIndex, realmGet$updated_at, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.updated_atIndex, rowIndex, false);
                }

                long promotionDataNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.promotionDataIndex, rowIndex);
                LinkView.nativeClear(promotionDataNativeLinkViewPtr);
                RealmList<com.sumroch.spotme.models.db.PromotionData> promotionDataList = ((BeaconDataRealmProxyInterface) object).realmGet$promotionData();
                if (promotionDataList != null) {
                    for (com.sumroch.spotme.models.db.PromotionData promotionDataItem : promotionDataList) {
                        Long cacheItemIndexpromotionData = cache.get(promotionDataItem);
                        if (cacheItemIndexpromotionData == null) {
                            cacheItemIndexpromotionData = PromotionDataRealmProxy.insertOrUpdate(realm, promotionDataItem, cache);
                        }
                        LinkView.nativeAdd(promotionDataNativeLinkViewPtr, cacheItemIndexpromotionData);
                    }
                }

            }
        }
    }

    public static com.sumroch.spotme.models.db.BeaconData createDetachedCopy(com.sumroch.spotme.models.db.BeaconData realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.sumroch.spotme.models.db.BeaconData unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.sumroch.spotme.models.db.BeaconData)cachedObject.object;
            } else {
                unmanagedObject = (com.sumroch.spotme.models.db.BeaconData)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.sumroch.spotme.models.db.BeaconData();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((BeaconDataRealmProxyInterface) unmanagedObject).realmSet$id(((BeaconDataRealmProxyInterface) realmObject).realmGet$id());
        ((BeaconDataRealmProxyInterface) unmanagedObject).realmSet$name(((BeaconDataRealmProxyInterface) realmObject).realmGet$name());
        ((BeaconDataRealmProxyInterface) unmanagedObject).realmSet$uuid(((BeaconDataRealmProxyInterface) realmObject).realmGet$uuid());
        ((BeaconDataRealmProxyInterface) unmanagedObject).realmSet$major(((BeaconDataRealmProxyInterface) realmObject).realmGet$major());
        ((BeaconDataRealmProxyInterface) unmanagedObject).realmSet$minor(((BeaconDataRealmProxyInterface) realmObject).realmGet$minor());
        ((BeaconDataRealmProxyInterface) unmanagedObject).realmSet$x_position(((BeaconDataRealmProxyInterface) realmObject).realmGet$x_position());
        ((BeaconDataRealmProxyInterface) unmanagedObject).realmSet$y_position(((BeaconDataRealmProxyInterface) realmObject).realmGet$y_position());
        ((BeaconDataRealmProxyInterface) unmanagedObject).realmSet$position(((BeaconDataRealmProxyInterface) realmObject).realmGet$position());
        ((BeaconDataRealmProxyInterface) unmanagedObject).realmSet$created_at(((BeaconDataRealmProxyInterface) realmObject).realmGet$created_at());
        ((BeaconDataRealmProxyInterface) unmanagedObject).realmSet$updated_at(((BeaconDataRealmProxyInterface) realmObject).realmGet$updated_at());

        // Deep copy of promotionData
        if (currentDepth == maxDepth) {
            ((BeaconDataRealmProxyInterface) unmanagedObject).realmSet$promotionData(null);
        } else {
            RealmList<com.sumroch.spotme.models.db.PromotionData> managedpromotionDataList = ((BeaconDataRealmProxyInterface) realmObject).realmGet$promotionData();
            RealmList<com.sumroch.spotme.models.db.PromotionData> unmanagedpromotionDataList = new RealmList<com.sumroch.spotme.models.db.PromotionData>();
            ((BeaconDataRealmProxyInterface) unmanagedObject).realmSet$promotionData(unmanagedpromotionDataList);
            int nextDepth = currentDepth + 1;
            int size = managedpromotionDataList.size();
            for (int i = 0; i < size; i++) {
                com.sumroch.spotme.models.db.PromotionData item = PromotionDataRealmProxy.createDetachedCopy(managedpromotionDataList.get(i), nextDepth, maxDepth, cache);
                unmanagedpromotionDataList.add(item);
            }
        }
        return unmanagedObject;
    }

    static com.sumroch.spotme.models.db.BeaconData update(Realm realm, com.sumroch.spotme.models.db.BeaconData realmObject, com.sumroch.spotme.models.db.BeaconData newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((BeaconDataRealmProxyInterface) realmObject).realmSet$name(((BeaconDataRealmProxyInterface) newObject).realmGet$name());
        ((BeaconDataRealmProxyInterface) realmObject).realmSet$uuid(((BeaconDataRealmProxyInterface) newObject).realmGet$uuid());
        ((BeaconDataRealmProxyInterface) realmObject).realmSet$major(((BeaconDataRealmProxyInterface) newObject).realmGet$major());
        ((BeaconDataRealmProxyInterface) realmObject).realmSet$minor(((BeaconDataRealmProxyInterface) newObject).realmGet$minor());
        ((BeaconDataRealmProxyInterface) realmObject).realmSet$x_position(((BeaconDataRealmProxyInterface) newObject).realmGet$x_position());
        ((BeaconDataRealmProxyInterface) realmObject).realmSet$y_position(((BeaconDataRealmProxyInterface) newObject).realmGet$y_position());
        ((BeaconDataRealmProxyInterface) realmObject).realmSet$position(((BeaconDataRealmProxyInterface) newObject).realmGet$position());
        ((BeaconDataRealmProxyInterface) realmObject).realmSet$created_at(((BeaconDataRealmProxyInterface) newObject).realmGet$created_at());
        ((BeaconDataRealmProxyInterface) realmObject).realmSet$updated_at(((BeaconDataRealmProxyInterface) newObject).realmGet$updated_at());
        RealmList<com.sumroch.spotme.models.db.PromotionData> promotionDataList = ((BeaconDataRealmProxyInterface) newObject).realmGet$promotionData();
        RealmList<com.sumroch.spotme.models.db.PromotionData> promotionDataRealmList = ((BeaconDataRealmProxyInterface) realmObject).realmGet$promotionData();
        promotionDataRealmList.clear();
        if (promotionDataList != null) {
            for (int i = 0; i < promotionDataList.size(); i++) {
                com.sumroch.spotme.models.db.PromotionData promotionDataItem = promotionDataList.get(i);
                com.sumroch.spotme.models.db.PromotionData cachepromotionData = (com.sumroch.spotme.models.db.PromotionData) cache.get(promotionDataItem);
                if (cachepromotionData != null) {
                    promotionDataRealmList.add(cachepromotionData);
                } else {
                    promotionDataRealmList.add(PromotionDataRealmProxy.copyOrUpdate(realm, promotionDataList.get(i), true, cache));
                }
            }
        }
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("BeaconData = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{uuid:");
        stringBuilder.append(realmGet$uuid() != null ? realmGet$uuid() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{major:");
        stringBuilder.append(realmGet$major() != null ? realmGet$major() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{minor:");
        stringBuilder.append(realmGet$minor() != null ? realmGet$minor() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{x_position:");
        stringBuilder.append(realmGet$x_position() != null ? realmGet$x_position() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{y_position:");
        stringBuilder.append(realmGet$y_position() != null ? realmGet$y_position() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{position:");
        stringBuilder.append(realmGet$position() != null ? realmGet$position() : "null");
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
        stringBuilder.append("{promotionData:");
        stringBuilder.append("RealmList<PromotionData>[").append(realmGet$promotionData().size()).append("]");
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
        BeaconDataRealmProxy aBeaconData = (BeaconDataRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aBeaconData.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aBeaconData.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aBeaconData.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
