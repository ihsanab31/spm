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

public class MallRealmProxy extends com.sumroch.spotme.models.db.Mall
    implements RealmObjectProxy, MallRealmProxyInterface {

    static final class MallColumnInfo extends ColumnInfo {
        long idIndex;
        long codeIndex;
        long nameIndex;
        long latitudeIndex;
        long longitudeIndex;
        long addressIndex;
        long noteIndex;
        long pictureIndex;
        long userIdIndex;
        long createdAtIndex;
        long updatedAtIndex;
        long deletedAtIndex;
        long descriptionIndex;
        long statusIndex;
        long availableSpaceIndex;
        long nonAvailableSpaceIndex;
        long totalSpaceIndex;
        long savedDistanceIndex;

        MallColumnInfo(SharedRealm realm, Table table) {
            super(18);
            this.idIndex = addColumnDetails(table, "id", RealmFieldType.INTEGER);
            this.codeIndex = addColumnDetails(table, "code", RealmFieldType.STRING);
            this.nameIndex = addColumnDetails(table, "name", RealmFieldType.STRING);
            this.latitudeIndex = addColumnDetails(table, "latitude", RealmFieldType.DOUBLE);
            this.longitudeIndex = addColumnDetails(table, "longitude", RealmFieldType.DOUBLE);
            this.addressIndex = addColumnDetails(table, "address", RealmFieldType.STRING);
            this.noteIndex = addColumnDetails(table, "note", RealmFieldType.STRING);
            this.pictureIndex = addColumnDetails(table, "picture", RealmFieldType.STRING);
            this.userIdIndex = addColumnDetails(table, "userId", RealmFieldType.INTEGER);
            this.createdAtIndex = addColumnDetails(table, "createdAt", RealmFieldType.STRING);
            this.updatedAtIndex = addColumnDetails(table, "updatedAt", RealmFieldType.STRING);
            this.deletedAtIndex = addColumnDetails(table, "deletedAt", RealmFieldType.STRING);
            this.descriptionIndex = addColumnDetails(table, "description", RealmFieldType.STRING);
            this.statusIndex = addColumnDetails(table, "status", RealmFieldType.INTEGER);
            this.availableSpaceIndex = addColumnDetails(table, "availableSpace", RealmFieldType.STRING);
            this.nonAvailableSpaceIndex = addColumnDetails(table, "nonAvailableSpace", RealmFieldType.STRING);
            this.totalSpaceIndex = addColumnDetails(table, "totalSpace", RealmFieldType.STRING);
            this.savedDistanceIndex = addColumnDetails(table, "savedDistance", RealmFieldType.DOUBLE);
        }

        MallColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new MallColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final MallColumnInfo src = (MallColumnInfo) rawSrc;
            final MallColumnInfo dst = (MallColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.codeIndex = src.codeIndex;
            dst.nameIndex = src.nameIndex;
            dst.latitudeIndex = src.latitudeIndex;
            dst.longitudeIndex = src.longitudeIndex;
            dst.addressIndex = src.addressIndex;
            dst.noteIndex = src.noteIndex;
            dst.pictureIndex = src.pictureIndex;
            dst.userIdIndex = src.userIdIndex;
            dst.createdAtIndex = src.createdAtIndex;
            dst.updatedAtIndex = src.updatedAtIndex;
            dst.deletedAtIndex = src.deletedAtIndex;
            dst.descriptionIndex = src.descriptionIndex;
            dst.statusIndex = src.statusIndex;
            dst.availableSpaceIndex = src.availableSpaceIndex;
            dst.nonAvailableSpaceIndex = src.nonAvailableSpaceIndex;
            dst.totalSpaceIndex = src.totalSpaceIndex;
            dst.savedDistanceIndex = src.savedDistanceIndex;
        }
    }

    private MallColumnInfo columnInfo;
    private ProxyState<com.sumroch.spotme.models.db.Mall> proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("code");
        fieldNames.add("name");
        fieldNames.add("latitude");
        fieldNames.add("longitude");
        fieldNames.add("address");
        fieldNames.add("note");
        fieldNames.add("picture");
        fieldNames.add("userId");
        fieldNames.add("createdAt");
        fieldNames.add("updatedAt");
        fieldNames.add("deletedAt");
        fieldNames.add("description");
        fieldNames.add("status");
        fieldNames.add("availableSpace");
        fieldNames.add("nonAvailableSpace");
        fieldNames.add("totalSpace");
        fieldNames.add("savedDistance");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    MallRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (MallColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.sumroch.spotme.models.db.Mall>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.idIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.idIndex);
    }

    @Override
    public void realmSet$id(Integer value) {
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
    public Double realmGet$latitude() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.latitudeIndex)) {
            return null;
        }
        return (double) proxyState.getRow$realm().getDouble(columnInfo.latitudeIndex);
    }

    @Override
    public void realmSet$latitude(Double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.latitudeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setDouble(columnInfo.latitudeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.latitudeIndex);
            return;
        }
        proxyState.getRow$realm().setDouble(columnInfo.latitudeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Double realmGet$longitude() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.longitudeIndex)) {
            return null;
        }
        return (double) proxyState.getRow$realm().getDouble(columnInfo.longitudeIndex);
    }

    @Override
    public void realmSet$longitude(Double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.longitudeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setDouble(columnInfo.longitudeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.longitudeIndex);
            return;
        }
        proxyState.getRow$realm().setDouble(columnInfo.longitudeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$address() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.addressIndex);
    }

    @Override
    public void realmSet$address(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.addressIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.addressIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.addressIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.addressIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$note() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.noteIndex);
    }

    @Override
    public void realmSet$note(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.noteIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.noteIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.noteIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.noteIndex, value);
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
    public Integer realmGet$userId() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.userIdIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.userIdIndex);
    }

    @Override
    public void realmSet$userId(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.userIdIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.userIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.userIdIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.userIdIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$createdAt() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.createdAtIndex);
    }

    @Override
    public void realmSet$createdAt(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.createdAtIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.createdAtIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.createdAtIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.createdAtIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$updatedAt() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.updatedAtIndex);
    }

    @Override
    public void realmSet$updatedAt(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.updatedAtIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.updatedAtIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.updatedAtIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.updatedAtIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$deletedAt() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.deletedAtIndex);
    }

    @Override
    public void realmSet$deletedAt(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.deletedAtIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.deletedAtIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.deletedAtIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.deletedAtIndex, value);
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
    public int realmGet$status() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.statusIndex);
    }

    @Override
    public void realmSet$status(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.statusIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.statusIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$availableSpace() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.availableSpaceIndex);
    }

    @Override
    public void realmSet$availableSpace(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.availableSpaceIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.availableSpaceIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.availableSpaceIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.availableSpaceIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$nonAvailableSpace() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nonAvailableSpaceIndex);
    }

    @Override
    public void realmSet$nonAvailableSpace(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nonAvailableSpaceIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nonAvailableSpaceIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nonAvailableSpaceIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nonAvailableSpaceIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$totalSpace() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.totalSpaceIndex);
    }

    @Override
    public void realmSet$totalSpace(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.totalSpaceIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.totalSpaceIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.totalSpaceIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.totalSpaceIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Double realmGet$savedDistance() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.savedDistanceIndex)) {
            return null;
        }
        return (double) proxyState.getRow$realm().getDouble(columnInfo.savedDistanceIndex);
    }

    @Override
    public void realmSet$savedDistance(Double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.savedDistanceIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setDouble(columnInfo.savedDistanceIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.savedDistanceIndex);
            return;
        }
        proxyState.getRow$realm().setDouble(columnInfo.savedDistanceIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("Mall")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("Mall");
            realmObjectSchema.add("id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("code", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("latitude", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("longitude", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("address", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("note", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("picture", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("userId", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("createdAt", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("updatedAt", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("deletedAt", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("description", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("status", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("availableSpace", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("nonAvailableSpace", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("totalSpace", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("savedDistance", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            return realmObjectSchema;
        }
        return realmSchema.get("Mall");
    }

    public static MallColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (!sharedRealm.hasTable("class_Mall")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'Mall' class is missing from the schema for this Realm.");
        }
        Table table = sharedRealm.getTable("class_Mall");
        final long columnCount = table.getColumnCount();
        if (columnCount != 18) {
            if (columnCount < 18) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 18 but was " + columnCount);
            }
            if (allowExtraColumns) {
                RealmLog.debug("Field count is more than expected - expected 18 but was %1$d", columnCount);
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 18 but was " + columnCount);
            }
        }
        Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
        for (long i = 0; i < columnCount; i++) {
            columnTypes.put(table.getColumnName(i), table.getColumnType(i));
        }

        final MallColumnInfo columnInfo = new MallColumnInfo(sharedRealm, table);

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
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'id' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.idIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"@PrimaryKey field 'id' does not support null values in the existing Realm file. Migrate using RealmObjectSchema.setNullable(), or mark the field as @Required.");
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
        if (!columnTypes.containsKey("latitude")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'latitude' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("latitude") != RealmFieldType.DOUBLE) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Double' for field 'latitude' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.latitudeIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'latitude' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'latitude' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("longitude")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'longitude' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("longitude") != RealmFieldType.DOUBLE) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Double' for field 'longitude' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.longitudeIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'longitude' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'longitude' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("address")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'address' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("address") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'address' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.addressIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'address' is required. Either set @Required to field 'address' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("note")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'note' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("note") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'note' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.noteIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'note' is required. Either set @Required to field 'note' or migrate using RealmObjectSchema.setNullable().");
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
        if (!columnTypes.containsKey("userId")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'userId' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("userId") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'userId' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.userIdIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'userId' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'userId' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("createdAt")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'createdAt' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("createdAt") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'createdAt' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.createdAtIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'createdAt' is required. Either set @Required to field 'createdAt' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("updatedAt")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'updatedAt' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("updatedAt") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'updatedAt' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.updatedAtIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'updatedAt' is required. Either set @Required to field 'updatedAt' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("deletedAt")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'deletedAt' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("deletedAt") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'deletedAt' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.deletedAtIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'deletedAt' is required. Either set @Required to field 'deletedAt' or migrate using RealmObjectSchema.setNullable().");
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
        if (!columnTypes.containsKey("status")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'status' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("status") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'status' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.statusIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'status' does support null values in the existing Realm file. Use corresponding boxed type for field 'status' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("availableSpace")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'availableSpace' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("availableSpace") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'availableSpace' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.availableSpaceIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'availableSpace' is required. Either set @Required to field 'availableSpace' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("nonAvailableSpace")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'nonAvailableSpace' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("nonAvailableSpace") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'nonAvailableSpace' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.nonAvailableSpaceIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'nonAvailableSpace' is required. Either set @Required to field 'nonAvailableSpace' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("totalSpace")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'totalSpace' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("totalSpace") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'totalSpace' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.totalSpaceIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'totalSpace' is required. Either set @Required to field 'totalSpace' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("savedDistance")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'savedDistance' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("savedDistance") != RealmFieldType.DOUBLE) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Double' for field 'savedDistance' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.savedDistanceIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'savedDistance' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'savedDistance' or migrate using RealmObjectSchema.setNullable().");
        }

        return columnInfo;
    }

    public static String getTableName() {
        return "class_Mall";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.sumroch.spotme.models.db.Mall createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.sumroch.spotme.models.db.Mall obj = null;
        if (update) {
            Table table = realm.getTable(com.sumroch.spotme.models.db.Mall.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = Table.NO_MATCH;
            if (json.isNull("id")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.sumroch.spotme.models.db.Mall.class), false, Collections.<String> emptyList());
                    obj = new io.realm.MallRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.MallRealmProxy) realm.createObjectInternal(com.sumroch.spotme.models.db.Mall.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.MallRealmProxy) realm.createObjectInternal(com.sumroch.spotme.models.db.Mall.class, json.getInt("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }
        if (json.has("code")) {
            if (json.isNull("code")) {
                ((MallRealmProxyInterface) obj).realmSet$code(null);
            } else {
                ((MallRealmProxyInterface) obj).realmSet$code((String) json.getString("code"));
            }
        }
        if (json.has("name")) {
            if (json.isNull("name")) {
                ((MallRealmProxyInterface) obj).realmSet$name(null);
            } else {
                ((MallRealmProxyInterface) obj).realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("latitude")) {
            if (json.isNull("latitude")) {
                ((MallRealmProxyInterface) obj).realmSet$latitude(null);
            } else {
                ((MallRealmProxyInterface) obj).realmSet$latitude((double) json.getDouble("latitude"));
            }
        }
        if (json.has("longitude")) {
            if (json.isNull("longitude")) {
                ((MallRealmProxyInterface) obj).realmSet$longitude(null);
            } else {
                ((MallRealmProxyInterface) obj).realmSet$longitude((double) json.getDouble("longitude"));
            }
        }
        if (json.has("address")) {
            if (json.isNull("address")) {
                ((MallRealmProxyInterface) obj).realmSet$address(null);
            } else {
                ((MallRealmProxyInterface) obj).realmSet$address((String) json.getString("address"));
            }
        }
        if (json.has("note")) {
            if (json.isNull("note")) {
                ((MallRealmProxyInterface) obj).realmSet$note(null);
            } else {
                ((MallRealmProxyInterface) obj).realmSet$note((String) json.getString("note"));
            }
        }
        if (json.has("picture")) {
            if (json.isNull("picture")) {
                ((MallRealmProxyInterface) obj).realmSet$picture(null);
            } else {
                ((MallRealmProxyInterface) obj).realmSet$picture((String) json.getString("picture"));
            }
        }
        if (json.has("userId")) {
            if (json.isNull("userId")) {
                ((MallRealmProxyInterface) obj).realmSet$userId(null);
            } else {
                ((MallRealmProxyInterface) obj).realmSet$userId((int) json.getInt("userId"));
            }
        }
        if (json.has("createdAt")) {
            if (json.isNull("createdAt")) {
                ((MallRealmProxyInterface) obj).realmSet$createdAt(null);
            } else {
                ((MallRealmProxyInterface) obj).realmSet$createdAt((String) json.getString("createdAt"));
            }
        }
        if (json.has("updatedAt")) {
            if (json.isNull("updatedAt")) {
                ((MallRealmProxyInterface) obj).realmSet$updatedAt(null);
            } else {
                ((MallRealmProxyInterface) obj).realmSet$updatedAt((String) json.getString("updatedAt"));
            }
        }
        if (json.has("deletedAt")) {
            if (json.isNull("deletedAt")) {
                ((MallRealmProxyInterface) obj).realmSet$deletedAt(null);
            } else {
                ((MallRealmProxyInterface) obj).realmSet$deletedAt((String) json.getString("deletedAt"));
            }
        }
        if (json.has("description")) {
            if (json.isNull("description")) {
                ((MallRealmProxyInterface) obj).realmSet$description(null);
            } else {
                ((MallRealmProxyInterface) obj).realmSet$description((String) json.getString("description"));
            }
        }
        if (json.has("status")) {
            if (json.isNull("status")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'status' to null.");
            } else {
                ((MallRealmProxyInterface) obj).realmSet$status((int) json.getInt("status"));
            }
        }
        if (json.has("availableSpace")) {
            if (json.isNull("availableSpace")) {
                ((MallRealmProxyInterface) obj).realmSet$availableSpace(null);
            } else {
                ((MallRealmProxyInterface) obj).realmSet$availableSpace((String) json.getString("availableSpace"));
            }
        }
        if (json.has("nonAvailableSpace")) {
            if (json.isNull("nonAvailableSpace")) {
                ((MallRealmProxyInterface) obj).realmSet$nonAvailableSpace(null);
            } else {
                ((MallRealmProxyInterface) obj).realmSet$nonAvailableSpace((String) json.getString("nonAvailableSpace"));
            }
        }
        if (json.has("totalSpace")) {
            if (json.isNull("totalSpace")) {
                ((MallRealmProxyInterface) obj).realmSet$totalSpace(null);
            } else {
                ((MallRealmProxyInterface) obj).realmSet$totalSpace((String) json.getString("totalSpace"));
            }
        }
        if (json.has("savedDistance")) {
            if (json.isNull("savedDistance")) {
                ((MallRealmProxyInterface) obj).realmSet$savedDistance(null);
            } else {
                ((MallRealmProxyInterface) obj).realmSet$savedDistance((double) json.getDouble("savedDistance"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.sumroch.spotme.models.db.Mall createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.sumroch.spotme.models.db.Mall obj = new com.sumroch.spotme.models.db.Mall();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MallRealmProxyInterface) obj).realmSet$id(null);
                } else {
                    ((MallRealmProxyInterface) obj).realmSet$id((int) reader.nextInt());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("code")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MallRealmProxyInterface) obj).realmSet$code(null);
                } else {
                    ((MallRealmProxyInterface) obj).realmSet$code((String) reader.nextString());
                }
            } else if (name.equals("name")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MallRealmProxyInterface) obj).realmSet$name(null);
                } else {
                    ((MallRealmProxyInterface) obj).realmSet$name((String) reader.nextString());
                }
            } else if (name.equals("latitude")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MallRealmProxyInterface) obj).realmSet$latitude(null);
                } else {
                    ((MallRealmProxyInterface) obj).realmSet$latitude((double) reader.nextDouble());
                }
            } else if (name.equals("longitude")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MallRealmProxyInterface) obj).realmSet$longitude(null);
                } else {
                    ((MallRealmProxyInterface) obj).realmSet$longitude((double) reader.nextDouble());
                }
            } else if (name.equals("address")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MallRealmProxyInterface) obj).realmSet$address(null);
                } else {
                    ((MallRealmProxyInterface) obj).realmSet$address((String) reader.nextString());
                }
            } else if (name.equals("note")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MallRealmProxyInterface) obj).realmSet$note(null);
                } else {
                    ((MallRealmProxyInterface) obj).realmSet$note((String) reader.nextString());
                }
            } else if (name.equals("picture")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MallRealmProxyInterface) obj).realmSet$picture(null);
                } else {
                    ((MallRealmProxyInterface) obj).realmSet$picture((String) reader.nextString());
                }
            } else if (name.equals("userId")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MallRealmProxyInterface) obj).realmSet$userId(null);
                } else {
                    ((MallRealmProxyInterface) obj).realmSet$userId((int) reader.nextInt());
                }
            } else if (name.equals("createdAt")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MallRealmProxyInterface) obj).realmSet$createdAt(null);
                } else {
                    ((MallRealmProxyInterface) obj).realmSet$createdAt((String) reader.nextString());
                }
            } else if (name.equals("updatedAt")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MallRealmProxyInterface) obj).realmSet$updatedAt(null);
                } else {
                    ((MallRealmProxyInterface) obj).realmSet$updatedAt((String) reader.nextString());
                }
            } else if (name.equals("deletedAt")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MallRealmProxyInterface) obj).realmSet$deletedAt(null);
                } else {
                    ((MallRealmProxyInterface) obj).realmSet$deletedAt((String) reader.nextString());
                }
            } else if (name.equals("description")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MallRealmProxyInterface) obj).realmSet$description(null);
                } else {
                    ((MallRealmProxyInterface) obj).realmSet$description((String) reader.nextString());
                }
            } else if (name.equals("status")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'status' to null.");
                } else {
                    ((MallRealmProxyInterface) obj).realmSet$status((int) reader.nextInt());
                }
            } else if (name.equals("availableSpace")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MallRealmProxyInterface) obj).realmSet$availableSpace(null);
                } else {
                    ((MallRealmProxyInterface) obj).realmSet$availableSpace((String) reader.nextString());
                }
            } else if (name.equals("nonAvailableSpace")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MallRealmProxyInterface) obj).realmSet$nonAvailableSpace(null);
                } else {
                    ((MallRealmProxyInterface) obj).realmSet$nonAvailableSpace((String) reader.nextString());
                }
            } else if (name.equals("totalSpace")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MallRealmProxyInterface) obj).realmSet$totalSpace(null);
                } else {
                    ((MallRealmProxyInterface) obj).realmSet$totalSpace((String) reader.nextString());
                }
            } else if (name.equals("savedDistance")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((MallRealmProxyInterface) obj).realmSet$savedDistance(null);
                } else {
                    ((MallRealmProxyInterface) obj).realmSet$savedDistance((double) reader.nextDouble());
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

    public static com.sumroch.spotme.models.db.Mall copyOrUpdate(Realm realm, com.sumroch.spotme.models.db.Mall object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.sumroch.spotme.models.db.Mall) cachedRealmObject;
        } else {
            com.sumroch.spotme.models.db.Mall realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.sumroch.spotme.models.db.Mall.class);
                long pkColumnIndex = table.getPrimaryKey();
                Number value = ((MallRealmProxyInterface) object).realmGet$id();
                long rowIndex = Table.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstLong(pkColumnIndex, value.longValue());
                }
                if (rowIndex != Table.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.sumroch.spotme.models.db.Mall.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.MallRealmProxy();
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

    public static com.sumroch.spotme.models.db.Mall copy(Realm realm, com.sumroch.spotme.models.db.Mall newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.sumroch.spotme.models.db.Mall) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.sumroch.spotme.models.db.Mall realmObject = realm.createObjectInternal(com.sumroch.spotme.models.db.Mall.class, ((MallRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((MallRealmProxyInterface) realmObject).realmSet$code(((MallRealmProxyInterface) newObject).realmGet$code());
            ((MallRealmProxyInterface) realmObject).realmSet$name(((MallRealmProxyInterface) newObject).realmGet$name());
            ((MallRealmProxyInterface) realmObject).realmSet$latitude(((MallRealmProxyInterface) newObject).realmGet$latitude());
            ((MallRealmProxyInterface) realmObject).realmSet$longitude(((MallRealmProxyInterface) newObject).realmGet$longitude());
            ((MallRealmProxyInterface) realmObject).realmSet$address(((MallRealmProxyInterface) newObject).realmGet$address());
            ((MallRealmProxyInterface) realmObject).realmSet$note(((MallRealmProxyInterface) newObject).realmGet$note());
            ((MallRealmProxyInterface) realmObject).realmSet$picture(((MallRealmProxyInterface) newObject).realmGet$picture());
            ((MallRealmProxyInterface) realmObject).realmSet$userId(((MallRealmProxyInterface) newObject).realmGet$userId());
            ((MallRealmProxyInterface) realmObject).realmSet$createdAt(((MallRealmProxyInterface) newObject).realmGet$createdAt());
            ((MallRealmProxyInterface) realmObject).realmSet$updatedAt(((MallRealmProxyInterface) newObject).realmGet$updatedAt());
            ((MallRealmProxyInterface) realmObject).realmSet$deletedAt(((MallRealmProxyInterface) newObject).realmGet$deletedAt());
            ((MallRealmProxyInterface) realmObject).realmSet$description(((MallRealmProxyInterface) newObject).realmGet$description());
            ((MallRealmProxyInterface) realmObject).realmSet$status(((MallRealmProxyInterface) newObject).realmGet$status());
            ((MallRealmProxyInterface) realmObject).realmSet$availableSpace(((MallRealmProxyInterface) newObject).realmGet$availableSpace());
            ((MallRealmProxyInterface) realmObject).realmSet$nonAvailableSpace(((MallRealmProxyInterface) newObject).realmGet$nonAvailableSpace());
            ((MallRealmProxyInterface) realmObject).realmSet$totalSpace(((MallRealmProxyInterface) newObject).realmGet$totalSpace());
            ((MallRealmProxyInterface) realmObject).realmSet$savedDistance(((MallRealmProxyInterface) newObject).realmGet$savedDistance());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.sumroch.spotme.models.db.Mall object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.sumroch.spotme.models.db.Mall.class);
        long tableNativePtr = table.getNativePtr();
        MallColumnInfo columnInfo = (MallColumnInfo) realm.schema.getColumnInfo(com.sumroch.spotme.models.db.Mall.class);
        long pkColumnIndex = table.getPrimaryKey();
        Object primaryKeyValue = ((MallRealmProxyInterface) object).realmGet$id();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((MallRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((MallRealmProxyInterface) object).realmGet$id());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$code = ((MallRealmProxyInterface)object).realmGet$code();
        if (realmGet$code != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.codeIndex, rowIndex, realmGet$code, false);
        }
        String realmGet$name = ((MallRealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        }
        Double realmGet$latitude = ((MallRealmProxyInterface)object).realmGet$latitude();
        if (realmGet$latitude != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.latitudeIndex, rowIndex, realmGet$latitude, false);
        }
        Double realmGet$longitude = ((MallRealmProxyInterface)object).realmGet$longitude();
        if (realmGet$longitude != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.longitudeIndex, rowIndex, realmGet$longitude, false);
        }
        String realmGet$address = ((MallRealmProxyInterface)object).realmGet$address();
        if (realmGet$address != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.addressIndex, rowIndex, realmGet$address, false);
        }
        String realmGet$note = ((MallRealmProxyInterface)object).realmGet$note();
        if (realmGet$note != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.noteIndex, rowIndex, realmGet$note, false);
        }
        String realmGet$picture = ((MallRealmProxyInterface)object).realmGet$picture();
        if (realmGet$picture != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.pictureIndex, rowIndex, realmGet$picture, false);
        }
        Number realmGet$userId = ((MallRealmProxyInterface)object).realmGet$userId();
        if (realmGet$userId != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.userIdIndex, rowIndex, realmGet$userId.longValue(), false);
        }
        String realmGet$createdAt = ((MallRealmProxyInterface)object).realmGet$createdAt();
        if (realmGet$createdAt != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.createdAtIndex, rowIndex, realmGet$createdAt, false);
        }
        String realmGet$updatedAt = ((MallRealmProxyInterface)object).realmGet$updatedAt();
        if (realmGet$updatedAt != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.updatedAtIndex, rowIndex, realmGet$updatedAt, false);
        }
        String realmGet$deletedAt = ((MallRealmProxyInterface)object).realmGet$deletedAt();
        if (realmGet$deletedAt != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.deletedAtIndex, rowIndex, realmGet$deletedAt, false);
        }
        String realmGet$description = ((MallRealmProxyInterface)object).realmGet$description();
        if (realmGet$description != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.statusIndex, rowIndex, ((MallRealmProxyInterface)object).realmGet$status(), false);
        String realmGet$availableSpace = ((MallRealmProxyInterface)object).realmGet$availableSpace();
        if (realmGet$availableSpace != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.availableSpaceIndex, rowIndex, realmGet$availableSpace, false);
        }
        String realmGet$nonAvailableSpace = ((MallRealmProxyInterface)object).realmGet$nonAvailableSpace();
        if (realmGet$nonAvailableSpace != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nonAvailableSpaceIndex, rowIndex, realmGet$nonAvailableSpace, false);
        }
        String realmGet$totalSpace = ((MallRealmProxyInterface)object).realmGet$totalSpace();
        if (realmGet$totalSpace != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.totalSpaceIndex, rowIndex, realmGet$totalSpace, false);
        }
        Double realmGet$savedDistance = ((MallRealmProxyInterface)object).realmGet$savedDistance();
        if (realmGet$savedDistance != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.savedDistanceIndex, rowIndex, realmGet$savedDistance, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.sumroch.spotme.models.db.Mall.class);
        long tableNativePtr = table.getNativePtr();
        MallColumnInfo columnInfo = (MallColumnInfo) realm.schema.getColumnInfo(com.sumroch.spotme.models.db.Mall.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.sumroch.spotme.models.db.Mall object = null;
        while (objects.hasNext()) {
            object = (com.sumroch.spotme.models.db.Mall) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                Object primaryKeyValue = ((MallRealmProxyInterface) object).realmGet$id();
                long rowIndex = Table.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((MallRealmProxyInterface) object).realmGet$id());
                }
                if (rowIndex == Table.NO_MATCH) {
                    rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((MallRealmProxyInterface) object).realmGet$id());
                } else {
                    Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
                }
                cache.put(object, rowIndex);
                String realmGet$code = ((MallRealmProxyInterface)object).realmGet$code();
                if (realmGet$code != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.codeIndex, rowIndex, realmGet$code, false);
                }
                String realmGet$name = ((MallRealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
                }
                Double realmGet$latitude = ((MallRealmProxyInterface)object).realmGet$latitude();
                if (realmGet$latitude != null) {
                    Table.nativeSetDouble(tableNativePtr, columnInfo.latitudeIndex, rowIndex, realmGet$latitude, false);
                }
                Double realmGet$longitude = ((MallRealmProxyInterface)object).realmGet$longitude();
                if (realmGet$longitude != null) {
                    Table.nativeSetDouble(tableNativePtr, columnInfo.longitudeIndex, rowIndex, realmGet$longitude, false);
                }
                String realmGet$address = ((MallRealmProxyInterface)object).realmGet$address();
                if (realmGet$address != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.addressIndex, rowIndex, realmGet$address, false);
                }
                String realmGet$note = ((MallRealmProxyInterface)object).realmGet$note();
                if (realmGet$note != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.noteIndex, rowIndex, realmGet$note, false);
                }
                String realmGet$picture = ((MallRealmProxyInterface)object).realmGet$picture();
                if (realmGet$picture != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.pictureIndex, rowIndex, realmGet$picture, false);
                }
                Number realmGet$userId = ((MallRealmProxyInterface)object).realmGet$userId();
                if (realmGet$userId != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.userIdIndex, rowIndex, realmGet$userId.longValue(), false);
                }
                String realmGet$createdAt = ((MallRealmProxyInterface)object).realmGet$createdAt();
                if (realmGet$createdAt != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.createdAtIndex, rowIndex, realmGet$createdAt, false);
                }
                String realmGet$updatedAt = ((MallRealmProxyInterface)object).realmGet$updatedAt();
                if (realmGet$updatedAt != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.updatedAtIndex, rowIndex, realmGet$updatedAt, false);
                }
                String realmGet$deletedAt = ((MallRealmProxyInterface)object).realmGet$deletedAt();
                if (realmGet$deletedAt != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.deletedAtIndex, rowIndex, realmGet$deletedAt, false);
                }
                String realmGet$description = ((MallRealmProxyInterface)object).realmGet$description();
                if (realmGet$description != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.statusIndex, rowIndex, ((MallRealmProxyInterface)object).realmGet$status(), false);
                String realmGet$availableSpace = ((MallRealmProxyInterface)object).realmGet$availableSpace();
                if (realmGet$availableSpace != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.availableSpaceIndex, rowIndex, realmGet$availableSpace, false);
                }
                String realmGet$nonAvailableSpace = ((MallRealmProxyInterface)object).realmGet$nonAvailableSpace();
                if (realmGet$nonAvailableSpace != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nonAvailableSpaceIndex, rowIndex, realmGet$nonAvailableSpace, false);
                }
                String realmGet$totalSpace = ((MallRealmProxyInterface)object).realmGet$totalSpace();
                if (realmGet$totalSpace != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.totalSpaceIndex, rowIndex, realmGet$totalSpace, false);
                }
                Double realmGet$savedDistance = ((MallRealmProxyInterface)object).realmGet$savedDistance();
                if (realmGet$savedDistance != null) {
                    Table.nativeSetDouble(tableNativePtr, columnInfo.savedDistanceIndex, rowIndex, realmGet$savedDistance, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.sumroch.spotme.models.db.Mall object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.sumroch.spotme.models.db.Mall.class);
        long tableNativePtr = table.getNativePtr();
        MallColumnInfo columnInfo = (MallColumnInfo) realm.schema.getColumnInfo(com.sumroch.spotme.models.db.Mall.class);
        long pkColumnIndex = table.getPrimaryKey();
        Object primaryKeyValue = ((MallRealmProxyInterface) object).realmGet$id();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((MallRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((MallRealmProxyInterface) object).realmGet$id());
        }
        cache.put(object, rowIndex);
        String realmGet$code = ((MallRealmProxyInterface)object).realmGet$code();
        if (realmGet$code != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.codeIndex, rowIndex, realmGet$code, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.codeIndex, rowIndex, false);
        }
        String realmGet$name = ((MallRealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
        }
        Double realmGet$latitude = ((MallRealmProxyInterface)object).realmGet$latitude();
        if (realmGet$latitude != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.latitudeIndex, rowIndex, realmGet$latitude, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.latitudeIndex, rowIndex, false);
        }
        Double realmGet$longitude = ((MallRealmProxyInterface)object).realmGet$longitude();
        if (realmGet$longitude != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.longitudeIndex, rowIndex, realmGet$longitude, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.longitudeIndex, rowIndex, false);
        }
        String realmGet$address = ((MallRealmProxyInterface)object).realmGet$address();
        if (realmGet$address != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.addressIndex, rowIndex, realmGet$address, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.addressIndex, rowIndex, false);
        }
        String realmGet$note = ((MallRealmProxyInterface)object).realmGet$note();
        if (realmGet$note != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.noteIndex, rowIndex, realmGet$note, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.noteIndex, rowIndex, false);
        }
        String realmGet$picture = ((MallRealmProxyInterface)object).realmGet$picture();
        if (realmGet$picture != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.pictureIndex, rowIndex, realmGet$picture, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.pictureIndex, rowIndex, false);
        }
        Number realmGet$userId = ((MallRealmProxyInterface)object).realmGet$userId();
        if (realmGet$userId != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.userIdIndex, rowIndex, realmGet$userId.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.userIdIndex, rowIndex, false);
        }
        String realmGet$createdAt = ((MallRealmProxyInterface)object).realmGet$createdAt();
        if (realmGet$createdAt != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.createdAtIndex, rowIndex, realmGet$createdAt, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.createdAtIndex, rowIndex, false);
        }
        String realmGet$updatedAt = ((MallRealmProxyInterface)object).realmGet$updatedAt();
        if (realmGet$updatedAt != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.updatedAtIndex, rowIndex, realmGet$updatedAt, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.updatedAtIndex, rowIndex, false);
        }
        String realmGet$deletedAt = ((MallRealmProxyInterface)object).realmGet$deletedAt();
        if (realmGet$deletedAt != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.deletedAtIndex, rowIndex, realmGet$deletedAt, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.deletedAtIndex, rowIndex, false);
        }
        String realmGet$description = ((MallRealmProxyInterface)object).realmGet$description();
        if (realmGet$description != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.descriptionIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.statusIndex, rowIndex, ((MallRealmProxyInterface)object).realmGet$status(), false);
        String realmGet$availableSpace = ((MallRealmProxyInterface)object).realmGet$availableSpace();
        if (realmGet$availableSpace != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.availableSpaceIndex, rowIndex, realmGet$availableSpace, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.availableSpaceIndex, rowIndex, false);
        }
        String realmGet$nonAvailableSpace = ((MallRealmProxyInterface)object).realmGet$nonAvailableSpace();
        if (realmGet$nonAvailableSpace != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nonAvailableSpaceIndex, rowIndex, realmGet$nonAvailableSpace, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nonAvailableSpaceIndex, rowIndex, false);
        }
        String realmGet$totalSpace = ((MallRealmProxyInterface)object).realmGet$totalSpace();
        if (realmGet$totalSpace != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.totalSpaceIndex, rowIndex, realmGet$totalSpace, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.totalSpaceIndex, rowIndex, false);
        }
        Double realmGet$savedDistance = ((MallRealmProxyInterface)object).realmGet$savedDistance();
        if (realmGet$savedDistance != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.savedDistanceIndex, rowIndex, realmGet$savedDistance, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.savedDistanceIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.sumroch.spotme.models.db.Mall.class);
        long tableNativePtr = table.getNativePtr();
        MallColumnInfo columnInfo = (MallColumnInfo) realm.schema.getColumnInfo(com.sumroch.spotme.models.db.Mall.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.sumroch.spotme.models.db.Mall object = null;
        while (objects.hasNext()) {
            object = (com.sumroch.spotme.models.db.Mall) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                Object primaryKeyValue = ((MallRealmProxyInterface) object).realmGet$id();
                long rowIndex = Table.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((MallRealmProxyInterface) object).realmGet$id());
                }
                if (rowIndex == Table.NO_MATCH) {
                    rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((MallRealmProxyInterface) object).realmGet$id());
                }
                cache.put(object, rowIndex);
                String realmGet$code = ((MallRealmProxyInterface)object).realmGet$code();
                if (realmGet$code != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.codeIndex, rowIndex, realmGet$code, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.codeIndex, rowIndex, false);
                }
                String realmGet$name = ((MallRealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
                }
                Double realmGet$latitude = ((MallRealmProxyInterface)object).realmGet$latitude();
                if (realmGet$latitude != null) {
                    Table.nativeSetDouble(tableNativePtr, columnInfo.latitudeIndex, rowIndex, realmGet$latitude, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.latitudeIndex, rowIndex, false);
                }
                Double realmGet$longitude = ((MallRealmProxyInterface)object).realmGet$longitude();
                if (realmGet$longitude != null) {
                    Table.nativeSetDouble(tableNativePtr, columnInfo.longitudeIndex, rowIndex, realmGet$longitude, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.longitudeIndex, rowIndex, false);
                }
                String realmGet$address = ((MallRealmProxyInterface)object).realmGet$address();
                if (realmGet$address != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.addressIndex, rowIndex, realmGet$address, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.addressIndex, rowIndex, false);
                }
                String realmGet$note = ((MallRealmProxyInterface)object).realmGet$note();
                if (realmGet$note != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.noteIndex, rowIndex, realmGet$note, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.noteIndex, rowIndex, false);
                }
                String realmGet$picture = ((MallRealmProxyInterface)object).realmGet$picture();
                if (realmGet$picture != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.pictureIndex, rowIndex, realmGet$picture, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.pictureIndex, rowIndex, false);
                }
                Number realmGet$userId = ((MallRealmProxyInterface)object).realmGet$userId();
                if (realmGet$userId != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.userIdIndex, rowIndex, realmGet$userId.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.userIdIndex, rowIndex, false);
                }
                String realmGet$createdAt = ((MallRealmProxyInterface)object).realmGet$createdAt();
                if (realmGet$createdAt != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.createdAtIndex, rowIndex, realmGet$createdAt, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.createdAtIndex, rowIndex, false);
                }
                String realmGet$updatedAt = ((MallRealmProxyInterface)object).realmGet$updatedAt();
                if (realmGet$updatedAt != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.updatedAtIndex, rowIndex, realmGet$updatedAt, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.updatedAtIndex, rowIndex, false);
                }
                String realmGet$deletedAt = ((MallRealmProxyInterface)object).realmGet$deletedAt();
                if (realmGet$deletedAt != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.deletedAtIndex, rowIndex, realmGet$deletedAt, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.deletedAtIndex, rowIndex, false);
                }
                String realmGet$description = ((MallRealmProxyInterface)object).realmGet$description();
                if (realmGet$description != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.descriptionIndex, rowIndex, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.statusIndex, rowIndex, ((MallRealmProxyInterface)object).realmGet$status(), false);
                String realmGet$availableSpace = ((MallRealmProxyInterface)object).realmGet$availableSpace();
                if (realmGet$availableSpace != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.availableSpaceIndex, rowIndex, realmGet$availableSpace, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.availableSpaceIndex, rowIndex, false);
                }
                String realmGet$nonAvailableSpace = ((MallRealmProxyInterface)object).realmGet$nonAvailableSpace();
                if (realmGet$nonAvailableSpace != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nonAvailableSpaceIndex, rowIndex, realmGet$nonAvailableSpace, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.nonAvailableSpaceIndex, rowIndex, false);
                }
                String realmGet$totalSpace = ((MallRealmProxyInterface)object).realmGet$totalSpace();
                if (realmGet$totalSpace != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.totalSpaceIndex, rowIndex, realmGet$totalSpace, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.totalSpaceIndex, rowIndex, false);
                }
                Double realmGet$savedDistance = ((MallRealmProxyInterface)object).realmGet$savedDistance();
                if (realmGet$savedDistance != null) {
                    Table.nativeSetDouble(tableNativePtr, columnInfo.savedDistanceIndex, rowIndex, realmGet$savedDistance, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.savedDistanceIndex, rowIndex, false);
                }
            }
        }
    }

    public static com.sumroch.spotme.models.db.Mall createDetachedCopy(com.sumroch.spotme.models.db.Mall realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.sumroch.spotme.models.db.Mall unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.sumroch.spotme.models.db.Mall)cachedObject.object;
            } else {
                unmanagedObject = (com.sumroch.spotme.models.db.Mall)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.sumroch.spotme.models.db.Mall();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((MallRealmProxyInterface) unmanagedObject).realmSet$id(((MallRealmProxyInterface) realmObject).realmGet$id());
        ((MallRealmProxyInterface) unmanagedObject).realmSet$code(((MallRealmProxyInterface) realmObject).realmGet$code());
        ((MallRealmProxyInterface) unmanagedObject).realmSet$name(((MallRealmProxyInterface) realmObject).realmGet$name());
        ((MallRealmProxyInterface) unmanagedObject).realmSet$latitude(((MallRealmProxyInterface) realmObject).realmGet$latitude());
        ((MallRealmProxyInterface) unmanagedObject).realmSet$longitude(((MallRealmProxyInterface) realmObject).realmGet$longitude());
        ((MallRealmProxyInterface) unmanagedObject).realmSet$address(((MallRealmProxyInterface) realmObject).realmGet$address());
        ((MallRealmProxyInterface) unmanagedObject).realmSet$note(((MallRealmProxyInterface) realmObject).realmGet$note());
        ((MallRealmProxyInterface) unmanagedObject).realmSet$picture(((MallRealmProxyInterface) realmObject).realmGet$picture());
        ((MallRealmProxyInterface) unmanagedObject).realmSet$userId(((MallRealmProxyInterface) realmObject).realmGet$userId());
        ((MallRealmProxyInterface) unmanagedObject).realmSet$createdAt(((MallRealmProxyInterface) realmObject).realmGet$createdAt());
        ((MallRealmProxyInterface) unmanagedObject).realmSet$updatedAt(((MallRealmProxyInterface) realmObject).realmGet$updatedAt());
        ((MallRealmProxyInterface) unmanagedObject).realmSet$deletedAt(((MallRealmProxyInterface) realmObject).realmGet$deletedAt());
        ((MallRealmProxyInterface) unmanagedObject).realmSet$description(((MallRealmProxyInterface) realmObject).realmGet$description());
        ((MallRealmProxyInterface) unmanagedObject).realmSet$status(((MallRealmProxyInterface) realmObject).realmGet$status());
        ((MallRealmProxyInterface) unmanagedObject).realmSet$availableSpace(((MallRealmProxyInterface) realmObject).realmGet$availableSpace());
        ((MallRealmProxyInterface) unmanagedObject).realmSet$nonAvailableSpace(((MallRealmProxyInterface) realmObject).realmGet$nonAvailableSpace());
        ((MallRealmProxyInterface) unmanagedObject).realmSet$totalSpace(((MallRealmProxyInterface) realmObject).realmGet$totalSpace());
        ((MallRealmProxyInterface) unmanagedObject).realmSet$savedDistance(((MallRealmProxyInterface) realmObject).realmGet$savedDistance());
        return unmanagedObject;
    }

    static com.sumroch.spotme.models.db.Mall update(Realm realm, com.sumroch.spotme.models.db.Mall realmObject, com.sumroch.spotme.models.db.Mall newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((MallRealmProxyInterface) realmObject).realmSet$code(((MallRealmProxyInterface) newObject).realmGet$code());
        ((MallRealmProxyInterface) realmObject).realmSet$name(((MallRealmProxyInterface) newObject).realmGet$name());
        ((MallRealmProxyInterface) realmObject).realmSet$latitude(((MallRealmProxyInterface) newObject).realmGet$latitude());
        ((MallRealmProxyInterface) realmObject).realmSet$longitude(((MallRealmProxyInterface) newObject).realmGet$longitude());
        ((MallRealmProxyInterface) realmObject).realmSet$address(((MallRealmProxyInterface) newObject).realmGet$address());
        ((MallRealmProxyInterface) realmObject).realmSet$note(((MallRealmProxyInterface) newObject).realmGet$note());
        ((MallRealmProxyInterface) realmObject).realmSet$picture(((MallRealmProxyInterface) newObject).realmGet$picture());
        ((MallRealmProxyInterface) realmObject).realmSet$userId(((MallRealmProxyInterface) newObject).realmGet$userId());
        ((MallRealmProxyInterface) realmObject).realmSet$createdAt(((MallRealmProxyInterface) newObject).realmGet$createdAt());
        ((MallRealmProxyInterface) realmObject).realmSet$updatedAt(((MallRealmProxyInterface) newObject).realmGet$updatedAt());
        ((MallRealmProxyInterface) realmObject).realmSet$deletedAt(((MallRealmProxyInterface) newObject).realmGet$deletedAt());
        ((MallRealmProxyInterface) realmObject).realmSet$description(((MallRealmProxyInterface) newObject).realmGet$description());
        ((MallRealmProxyInterface) realmObject).realmSet$status(((MallRealmProxyInterface) newObject).realmGet$status());
        ((MallRealmProxyInterface) realmObject).realmSet$availableSpace(((MallRealmProxyInterface) newObject).realmGet$availableSpace());
        ((MallRealmProxyInterface) realmObject).realmSet$nonAvailableSpace(((MallRealmProxyInterface) newObject).realmGet$nonAvailableSpace());
        ((MallRealmProxyInterface) realmObject).realmSet$totalSpace(((MallRealmProxyInterface) newObject).realmGet$totalSpace());
        ((MallRealmProxyInterface) realmObject).realmSet$savedDistance(((MallRealmProxyInterface) newObject).realmGet$savedDistance());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Mall = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
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
        stringBuilder.append("{latitude:");
        stringBuilder.append(realmGet$latitude() != null ? realmGet$latitude() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{longitude:");
        stringBuilder.append(realmGet$longitude() != null ? realmGet$longitude() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{address:");
        stringBuilder.append(realmGet$address() != null ? realmGet$address() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{note:");
        stringBuilder.append(realmGet$note() != null ? realmGet$note() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{picture:");
        stringBuilder.append(realmGet$picture() != null ? realmGet$picture() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{userId:");
        stringBuilder.append(realmGet$userId() != null ? realmGet$userId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{createdAt:");
        stringBuilder.append(realmGet$createdAt() != null ? realmGet$createdAt() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{updatedAt:");
        stringBuilder.append(realmGet$updatedAt() != null ? realmGet$updatedAt() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{deletedAt:");
        stringBuilder.append(realmGet$deletedAt() != null ? realmGet$deletedAt() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{description:");
        stringBuilder.append(realmGet$description() != null ? realmGet$description() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{status:");
        stringBuilder.append(realmGet$status());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{availableSpace:");
        stringBuilder.append(realmGet$availableSpace() != null ? realmGet$availableSpace() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{nonAvailableSpace:");
        stringBuilder.append(realmGet$nonAvailableSpace() != null ? realmGet$nonAvailableSpace() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{totalSpace:");
        stringBuilder.append(realmGet$totalSpace() != null ? realmGet$totalSpace() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{savedDistance:");
        stringBuilder.append(realmGet$savedDistance() != null ? realmGet$savedDistance() : "null");
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
        MallRealmProxy aMall = (MallRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aMall.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aMall.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aMall.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
