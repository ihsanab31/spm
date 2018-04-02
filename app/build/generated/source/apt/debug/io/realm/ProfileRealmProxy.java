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

public class ProfileRealmProxy extends com.sumroch.spotme.models.db.Profile
    implements RealmObjectProxy, ProfileRealmProxyInterface {

    static final class ProfileColumnInfo extends ColumnInfo {
        long tokenIndex;
        long idIndex;
        long nameIndex;
        long emailIndex;
        long passwordIndex;
        long roleIndex;
        long rememberTokenIndex;
        long createdAtIndex;
        long updatedAtIndex;
        long usernameIndex;
        long dobIndex;
        long jenisKelaminIndex;
        long noHpIndex;
        long photoIndex;
        long idSurveyInterestIndex;

        ProfileColumnInfo(SharedRealm realm, Table table) {
            super(15);
            this.tokenIndex = addColumnDetails(table, "token", RealmFieldType.STRING);
            this.idIndex = addColumnDetails(table, "id", RealmFieldType.INTEGER);
            this.nameIndex = addColumnDetails(table, "name", RealmFieldType.STRING);
            this.emailIndex = addColumnDetails(table, "email", RealmFieldType.STRING);
            this.passwordIndex = addColumnDetails(table, "password", RealmFieldType.STRING);
            this.roleIndex = addColumnDetails(table, "role", RealmFieldType.INTEGER);
            this.rememberTokenIndex = addColumnDetails(table, "rememberToken", RealmFieldType.STRING);
            this.createdAtIndex = addColumnDetails(table, "createdAt", RealmFieldType.STRING);
            this.updatedAtIndex = addColumnDetails(table, "updatedAt", RealmFieldType.STRING);
            this.usernameIndex = addColumnDetails(table, "username", RealmFieldType.STRING);
            this.dobIndex = addColumnDetails(table, "dob", RealmFieldType.STRING);
            this.jenisKelaminIndex = addColumnDetails(table, "jenisKelamin", RealmFieldType.STRING);
            this.noHpIndex = addColumnDetails(table, "noHp", RealmFieldType.STRING);
            this.photoIndex = addColumnDetails(table, "photo", RealmFieldType.STRING);
            this.idSurveyInterestIndex = addColumnDetails(table, "idSurveyInterest", RealmFieldType.STRING);
        }

        ProfileColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new ProfileColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final ProfileColumnInfo src = (ProfileColumnInfo) rawSrc;
            final ProfileColumnInfo dst = (ProfileColumnInfo) rawDst;
            dst.tokenIndex = src.tokenIndex;
            dst.idIndex = src.idIndex;
            dst.nameIndex = src.nameIndex;
            dst.emailIndex = src.emailIndex;
            dst.passwordIndex = src.passwordIndex;
            dst.roleIndex = src.roleIndex;
            dst.rememberTokenIndex = src.rememberTokenIndex;
            dst.createdAtIndex = src.createdAtIndex;
            dst.updatedAtIndex = src.updatedAtIndex;
            dst.usernameIndex = src.usernameIndex;
            dst.dobIndex = src.dobIndex;
            dst.jenisKelaminIndex = src.jenisKelaminIndex;
            dst.noHpIndex = src.noHpIndex;
            dst.photoIndex = src.photoIndex;
            dst.idSurveyInterestIndex = src.idSurveyInterestIndex;
        }
    }

    private ProfileColumnInfo columnInfo;
    private ProxyState<com.sumroch.spotme.models.db.Profile> proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("token");
        fieldNames.add("id");
        fieldNames.add("name");
        fieldNames.add("email");
        fieldNames.add("password");
        fieldNames.add("role");
        fieldNames.add("rememberToken");
        fieldNames.add("createdAt");
        fieldNames.add("updatedAt");
        fieldNames.add("username");
        fieldNames.add("dob");
        fieldNames.add("jenisKelamin");
        fieldNames.add("noHp");
        fieldNames.add("photo");
        fieldNames.add("idSurveyInterest");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    ProfileRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (ProfileColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.sumroch.spotme.models.db.Profile>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$token() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.tokenIndex);
    }

    @Override
    public void realmSet$token(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.tokenIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.tokenIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.tokenIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.tokenIndex, value);
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
    public String realmGet$email() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.emailIndex);
    }

    @Override
    public void realmSet$email(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.emailIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.emailIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.emailIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.emailIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$password() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.passwordIndex);
    }

    @Override
    public void realmSet$password(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.passwordIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.passwordIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.passwordIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.passwordIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$role() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.roleIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.roleIndex);
    }

    @Override
    public void realmSet$role(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.roleIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.roleIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.roleIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.roleIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$rememberToken() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.rememberTokenIndex);
    }

    @Override
    public void realmSet$rememberToken(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.rememberTokenIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.rememberTokenIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.rememberTokenIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.rememberTokenIndex, value);
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
    public String realmGet$username() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.usernameIndex);
    }

    @Override
    public void realmSet$username(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.usernameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.usernameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.usernameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.usernameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$dob() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.dobIndex);
    }

    @Override
    public void realmSet$dob(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.dobIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.dobIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.dobIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.dobIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$jenisKelamin() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.jenisKelaminIndex);
    }

    @Override
    public void realmSet$jenisKelamin(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.jenisKelaminIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.jenisKelaminIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.jenisKelaminIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.jenisKelaminIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$noHp() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.noHpIndex);
    }

    @Override
    public void realmSet$noHp(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.noHpIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.noHpIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.noHpIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.noHpIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$photo() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.photoIndex);
    }

    @Override
    public void realmSet$photo(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.photoIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.photoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.photoIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.photoIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$idSurveyInterest() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.idSurveyInterestIndex);
    }

    @Override
    public void realmSet$idSurveyInterest(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.idSurveyInterestIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.idSurveyInterestIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.idSurveyInterestIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.idSurveyInterestIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("Profile")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("Profile");
            realmObjectSchema.add("token", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("email", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("password", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("role", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("rememberToken", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("createdAt", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("updatedAt", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("username", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("dob", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("jenisKelamin", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("noHp", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("photo", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("idSurveyInterest", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            return realmObjectSchema;
        }
        return realmSchema.get("Profile");
    }

    public static ProfileColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (!sharedRealm.hasTable("class_Profile")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'Profile' class is missing from the schema for this Realm.");
        }
        Table table = sharedRealm.getTable("class_Profile");
        final long columnCount = table.getColumnCount();
        if (columnCount != 15) {
            if (columnCount < 15) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 15 but was " + columnCount);
            }
            if (allowExtraColumns) {
                RealmLog.debug("Field count is more than expected - expected 15 but was %1$d", columnCount);
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 15 but was " + columnCount);
            }
        }
        Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
        for (long i = 0; i < columnCount; i++) {
            columnTypes.put(table.getColumnName(i), table.getColumnType(i));
        }

        final ProfileColumnInfo columnInfo = new ProfileColumnInfo(sharedRealm, table);

        if (!table.hasPrimaryKey()) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'id' in existing Realm file. @PrimaryKey was added.");
        } else {
            if (table.getPrimaryKey() != columnInfo.idIndex) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary Key annotation definition was changed, from field " + table.getColumnName(table.getPrimaryKey()) + " to field id");
            }
        }

        if (!columnTypes.containsKey("token")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'token' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("token") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'token' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.tokenIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'token' is required. Either set @Required to field 'token' or migrate using RealmObjectSchema.setNullable().");
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
        if (!columnTypes.containsKey("name")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'name' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("name") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'name' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.nameIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'name' is required. Either set @Required to field 'name' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("email")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'email' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("email") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'email' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.emailIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'email' is required. Either set @Required to field 'email' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("password")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'password' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("password") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'password' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.passwordIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'password' is required. Either set @Required to field 'password' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("role")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'role' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("role") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'role' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.roleIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'role' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'role' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("rememberToken")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'rememberToken' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("rememberToken") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'rememberToken' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.rememberTokenIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'rememberToken' is required. Either set @Required to field 'rememberToken' or migrate using RealmObjectSchema.setNullable().");
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
        if (!columnTypes.containsKey("username")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'username' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("username") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'username' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.usernameIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'username' is required. Either set @Required to field 'username' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("dob")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'dob' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("dob") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'dob' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.dobIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'dob' is required. Either set @Required to field 'dob' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("jenisKelamin")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'jenisKelamin' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("jenisKelamin") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'jenisKelamin' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.jenisKelaminIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'jenisKelamin' is required. Either set @Required to field 'jenisKelamin' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("noHp")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'noHp' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("noHp") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'noHp' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.noHpIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'noHp' is required. Either set @Required to field 'noHp' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("photo")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'photo' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("photo") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'photo' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.photoIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'photo' is required. Either set @Required to field 'photo' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("idSurveyInterest")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'idSurveyInterest' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("idSurveyInterest") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'idSurveyInterest' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.idSurveyInterestIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'idSurveyInterest' is required. Either set @Required to field 'idSurveyInterest' or migrate using RealmObjectSchema.setNullable().");
        }

        return columnInfo;
    }

    public static String getTableName() {
        return "class_Profile";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.sumroch.spotme.models.db.Profile createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.sumroch.spotme.models.db.Profile obj = null;
        if (update) {
            Table table = realm.getTable(com.sumroch.spotme.models.db.Profile.class);
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.sumroch.spotme.models.db.Profile.class), false, Collections.<String> emptyList());
                    obj = new io.realm.ProfileRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.ProfileRealmProxy) realm.createObjectInternal(com.sumroch.spotme.models.db.Profile.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.ProfileRealmProxy) realm.createObjectInternal(com.sumroch.spotme.models.db.Profile.class, json.getInt("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }
        if (json.has("token")) {
            if (json.isNull("token")) {
                ((ProfileRealmProxyInterface) obj).realmSet$token(null);
            } else {
                ((ProfileRealmProxyInterface) obj).realmSet$token((String) json.getString("token"));
            }
        }
        if (json.has("name")) {
            if (json.isNull("name")) {
                ((ProfileRealmProxyInterface) obj).realmSet$name(null);
            } else {
                ((ProfileRealmProxyInterface) obj).realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("email")) {
            if (json.isNull("email")) {
                ((ProfileRealmProxyInterface) obj).realmSet$email(null);
            } else {
                ((ProfileRealmProxyInterface) obj).realmSet$email((String) json.getString("email"));
            }
        }
        if (json.has("password")) {
            if (json.isNull("password")) {
                ((ProfileRealmProxyInterface) obj).realmSet$password(null);
            } else {
                ((ProfileRealmProxyInterface) obj).realmSet$password((String) json.getString("password"));
            }
        }
        if (json.has("role")) {
            if (json.isNull("role")) {
                ((ProfileRealmProxyInterface) obj).realmSet$role(null);
            } else {
                ((ProfileRealmProxyInterface) obj).realmSet$role((int) json.getInt("role"));
            }
        }
        if (json.has("rememberToken")) {
            if (json.isNull("rememberToken")) {
                ((ProfileRealmProxyInterface) obj).realmSet$rememberToken(null);
            } else {
                ((ProfileRealmProxyInterface) obj).realmSet$rememberToken((String) json.getString("rememberToken"));
            }
        }
        if (json.has("createdAt")) {
            if (json.isNull("createdAt")) {
                ((ProfileRealmProxyInterface) obj).realmSet$createdAt(null);
            } else {
                ((ProfileRealmProxyInterface) obj).realmSet$createdAt((String) json.getString("createdAt"));
            }
        }
        if (json.has("updatedAt")) {
            if (json.isNull("updatedAt")) {
                ((ProfileRealmProxyInterface) obj).realmSet$updatedAt(null);
            } else {
                ((ProfileRealmProxyInterface) obj).realmSet$updatedAt((String) json.getString("updatedAt"));
            }
        }
        if (json.has("username")) {
            if (json.isNull("username")) {
                ((ProfileRealmProxyInterface) obj).realmSet$username(null);
            } else {
                ((ProfileRealmProxyInterface) obj).realmSet$username((String) json.getString("username"));
            }
        }
        if (json.has("dob")) {
            if (json.isNull("dob")) {
                ((ProfileRealmProxyInterface) obj).realmSet$dob(null);
            } else {
                ((ProfileRealmProxyInterface) obj).realmSet$dob((String) json.getString("dob"));
            }
        }
        if (json.has("jenisKelamin")) {
            if (json.isNull("jenisKelamin")) {
                ((ProfileRealmProxyInterface) obj).realmSet$jenisKelamin(null);
            } else {
                ((ProfileRealmProxyInterface) obj).realmSet$jenisKelamin((String) json.getString("jenisKelamin"));
            }
        }
        if (json.has("noHp")) {
            if (json.isNull("noHp")) {
                ((ProfileRealmProxyInterface) obj).realmSet$noHp(null);
            } else {
                ((ProfileRealmProxyInterface) obj).realmSet$noHp((String) json.getString("noHp"));
            }
        }
        if (json.has("photo")) {
            if (json.isNull("photo")) {
                ((ProfileRealmProxyInterface) obj).realmSet$photo(null);
            } else {
                ((ProfileRealmProxyInterface) obj).realmSet$photo((String) json.getString("photo"));
            }
        }
        if (json.has("idSurveyInterest")) {
            if (json.isNull("idSurveyInterest")) {
                ((ProfileRealmProxyInterface) obj).realmSet$idSurveyInterest(null);
            } else {
                ((ProfileRealmProxyInterface) obj).realmSet$idSurveyInterest((String) json.getString("idSurveyInterest"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.sumroch.spotme.models.db.Profile createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.sumroch.spotme.models.db.Profile obj = new com.sumroch.spotme.models.db.Profile();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("token")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProfileRealmProxyInterface) obj).realmSet$token(null);
                } else {
                    ((ProfileRealmProxyInterface) obj).realmSet$token((String) reader.nextString());
                }
            } else if (name.equals("id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProfileRealmProxyInterface) obj).realmSet$id(null);
                } else {
                    ((ProfileRealmProxyInterface) obj).realmSet$id((int) reader.nextInt());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("name")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProfileRealmProxyInterface) obj).realmSet$name(null);
                } else {
                    ((ProfileRealmProxyInterface) obj).realmSet$name((String) reader.nextString());
                }
            } else if (name.equals("email")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProfileRealmProxyInterface) obj).realmSet$email(null);
                } else {
                    ((ProfileRealmProxyInterface) obj).realmSet$email((String) reader.nextString());
                }
            } else if (name.equals("password")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProfileRealmProxyInterface) obj).realmSet$password(null);
                } else {
                    ((ProfileRealmProxyInterface) obj).realmSet$password((String) reader.nextString());
                }
            } else if (name.equals("role")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProfileRealmProxyInterface) obj).realmSet$role(null);
                } else {
                    ((ProfileRealmProxyInterface) obj).realmSet$role((int) reader.nextInt());
                }
            } else if (name.equals("rememberToken")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProfileRealmProxyInterface) obj).realmSet$rememberToken(null);
                } else {
                    ((ProfileRealmProxyInterface) obj).realmSet$rememberToken((String) reader.nextString());
                }
            } else if (name.equals("createdAt")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProfileRealmProxyInterface) obj).realmSet$createdAt(null);
                } else {
                    ((ProfileRealmProxyInterface) obj).realmSet$createdAt((String) reader.nextString());
                }
            } else if (name.equals("updatedAt")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProfileRealmProxyInterface) obj).realmSet$updatedAt(null);
                } else {
                    ((ProfileRealmProxyInterface) obj).realmSet$updatedAt((String) reader.nextString());
                }
            } else if (name.equals("username")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProfileRealmProxyInterface) obj).realmSet$username(null);
                } else {
                    ((ProfileRealmProxyInterface) obj).realmSet$username((String) reader.nextString());
                }
            } else if (name.equals("dob")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProfileRealmProxyInterface) obj).realmSet$dob(null);
                } else {
                    ((ProfileRealmProxyInterface) obj).realmSet$dob((String) reader.nextString());
                }
            } else if (name.equals("jenisKelamin")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProfileRealmProxyInterface) obj).realmSet$jenisKelamin(null);
                } else {
                    ((ProfileRealmProxyInterface) obj).realmSet$jenisKelamin((String) reader.nextString());
                }
            } else if (name.equals("noHp")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProfileRealmProxyInterface) obj).realmSet$noHp(null);
                } else {
                    ((ProfileRealmProxyInterface) obj).realmSet$noHp((String) reader.nextString());
                }
            } else if (name.equals("photo")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProfileRealmProxyInterface) obj).realmSet$photo(null);
                } else {
                    ((ProfileRealmProxyInterface) obj).realmSet$photo((String) reader.nextString());
                }
            } else if (name.equals("idSurveyInterest")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProfileRealmProxyInterface) obj).realmSet$idSurveyInterest(null);
                } else {
                    ((ProfileRealmProxyInterface) obj).realmSet$idSurveyInterest((String) reader.nextString());
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

    public static com.sumroch.spotme.models.db.Profile copyOrUpdate(Realm realm, com.sumroch.spotme.models.db.Profile object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.sumroch.spotme.models.db.Profile) cachedRealmObject;
        } else {
            com.sumroch.spotme.models.db.Profile realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.sumroch.spotme.models.db.Profile.class);
                long pkColumnIndex = table.getPrimaryKey();
                Number value = ((ProfileRealmProxyInterface) object).realmGet$id();
                long rowIndex = Table.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstLong(pkColumnIndex, value.longValue());
                }
                if (rowIndex != Table.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.sumroch.spotme.models.db.Profile.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.ProfileRealmProxy();
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

    public static com.sumroch.spotme.models.db.Profile copy(Realm realm, com.sumroch.spotme.models.db.Profile newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.sumroch.spotme.models.db.Profile) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.sumroch.spotme.models.db.Profile realmObject = realm.createObjectInternal(com.sumroch.spotme.models.db.Profile.class, ((ProfileRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((ProfileRealmProxyInterface) realmObject).realmSet$token(((ProfileRealmProxyInterface) newObject).realmGet$token());
            ((ProfileRealmProxyInterface) realmObject).realmSet$name(((ProfileRealmProxyInterface) newObject).realmGet$name());
            ((ProfileRealmProxyInterface) realmObject).realmSet$email(((ProfileRealmProxyInterface) newObject).realmGet$email());
            ((ProfileRealmProxyInterface) realmObject).realmSet$password(((ProfileRealmProxyInterface) newObject).realmGet$password());
            ((ProfileRealmProxyInterface) realmObject).realmSet$role(((ProfileRealmProxyInterface) newObject).realmGet$role());
            ((ProfileRealmProxyInterface) realmObject).realmSet$rememberToken(((ProfileRealmProxyInterface) newObject).realmGet$rememberToken());
            ((ProfileRealmProxyInterface) realmObject).realmSet$createdAt(((ProfileRealmProxyInterface) newObject).realmGet$createdAt());
            ((ProfileRealmProxyInterface) realmObject).realmSet$updatedAt(((ProfileRealmProxyInterface) newObject).realmGet$updatedAt());
            ((ProfileRealmProxyInterface) realmObject).realmSet$username(((ProfileRealmProxyInterface) newObject).realmGet$username());
            ((ProfileRealmProxyInterface) realmObject).realmSet$dob(((ProfileRealmProxyInterface) newObject).realmGet$dob());
            ((ProfileRealmProxyInterface) realmObject).realmSet$jenisKelamin(((ProfileRealmProxyInterface) newObject).realmGet$jenisKelamin());
            ((ProfileRealmProxyInterface) realmObject).realmSet$noHp(((ProfileRealmProxyInterface) newObject).realmGet$noHp());
            ((ProfileRealmProxyInterface) realmObject).realmSet$photo(((ProfileRealmProxyInterface) newObject).realmGet$photo());
            ((ProfileRealmProxyInterface) realmObject).realmSet$idSurveyInterest(((ProfileRealmProxyInterface) newObject).realmGet$idSurveyInterest());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.sumroch.spotme.models.db.Profile object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.sumroch.spotme.models.db.Profile.class);
        long tableNativePtr = table.getNativePtr();
        ProfileColumnInfo columnInfo = (ProfileColumnInfo) realm.schema.getColumnInfo(com.sumroch.spotme.models.db.Profile.class);
        long pkColumnIndex = table.getPrimaryKey();
        Object primaryKeyValue = ((ProfileRealmProxyInterface) object).realmGet$id();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((ProfileRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((ProfileRealmProxyInterface) object).realmGet$id());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$token = ((ProfileRealmProxyInterface)object).realmGet$token();
        if (realmGet$token != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.tokenIndex, rowIndex, realmGet$token, false);
        }
        String realmGet$name = ((ProfileRealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        }
        String realmGet$email = ((ProfileRealmProxyInterface)object).realmGet$email();
        if (realmGet$email != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.emailIndex, rowIndex, realmGet$email, false);
        }
        String realmGet$password = ((ProfileRealmProxyInterface)object).realmGet$password();
        if (realmGet$password != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.passwordIndex, rowIndex, realmGet$password, false);
        }
        Number realmGet$role = ((ProfileRealmProxyInterface)object).realmGet$role();
        if (realmGet$role != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.roleIndex, rowIndex, realmGet$role.longValue(), false);
        }
        String realmGet$rememberToken = ((ProfileRealmProxyInterface)object).realmGet$rememberToken();
        if (realmGet$rememberToken != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.rememberTokenIndex, rowIndex, realmGet$rememberToken, false);
        }
        String realmGet$createdAt = ((ProfileRealmProxyInterface)object).realmGet$createdAt();
        if (realmGet$createdAt != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.createdAtIndex, rowIndex, realmGet$createdAt, false);
        }
        String realmGet$updatedAt = ((ProfileRealmProxyInterface)object).realmGet$updatedAt();
        if (realmGet$updatedAt != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.updatedAtIndex, rowIndex, realmGet$updatedAt, false);
        }
        String realmGet$username = ((ProfileRealmProxyInterface)object).realmGet$username();
        if (realmGet$username != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.usernameIndex, rowIndex, realmGet$username, false);
        }
        String realmGet$dob = ((ProfileRealmProxyInterface)object).realmGet$dob();
        if (realmGet$dob != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.dobIndex, rowIndex, realmGet$dob, false);
        }
        String realmGet$jenisKelamin = ((ProfileRealmProxyInterface)object).realmGet$jenisKelamin();
        if (realmGet$jenisKelamin != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.jenisKelaminIndex, rowIndex, realmGet$jenisKelamin, false);
        }
        String realmGet$noHp = ((ProfileRealmProxyInterface)object).realmGet$noHp();
        if (realmGet$noHp != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.noHpIndex, rowIndex, realmGet$noHp, false);
        }
        String realmGet$photo = ((ProfileRealmProxyInterface)object).realmGet$photo();
        if (realmGet$photo != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.photoIndex, rowIndex, realmGet$photo, false);
        }
        String realmGet$idSurveyInterest = ((ProfileRealmProxyInterface)object).realmGet$idSurveyInterest();
        if (realmGet$idSurveyInterest != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.idSurveyInterestIndex, rowIndex, realmGet$idSurveyInterest, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.sumroch.spotme.models.db.Profile.class);
        long tableNativePtr = table.getNativePtr();
        ProfileColumnInfo columnInfo = (ProfileColumnInfo) realm.schema.getColumnInfo(com.sumroch.spotme.models.db.Profile.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.sumroch.spotme.models.db.Profile object = null;
        while (objects.hasNext()) {
            object = (com.sumroch.spotme.models.db.Profile) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                Object primaryKeyValue = ((ProfileRealmProxyInterface) object).realmGet$id();
                long rowIndex = Table.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((ProfileRealmProxyInterface) object).realmGet$id());
                }
                if (rowIndex == Table.NO_MATCH) {
                    rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((ProfileRealmProxyInterface) object).realmGet$id());
                } else {
                    Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
                }
                cache.put(object, rowIndex);
                String realmGet$token = ((ProfileRealmProxyInterface)object).realmGet$token();
                if (realmGet$token != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.tokenIndex, rowIndex, realmGet$token, false);
                }
                String realmGet$name = ((ProfileRealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
                }
                String realmGet$email = ((ProfileRealmProxyInterface)object).realmGet$email();
                if (realmGet$email != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.emailIndex, rowIndex, realmGet$email, false);
                }
                String realmGet$password = ((ProfileRealmProxyInterface)object).realmGet$password();
                if (realmGet$password != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.passwordIndex, rowIndex, realmGet$password, false);
                }
                Number realmGet$role = ((ProfileRealmProxyInterface)object).realmGet$role();
                if (realmGet$role != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.roleIndex, rowIndex, realmGet$role.longValue(), false);
                }
                String realmGet$rememberToken = ((ProfileRealmProxyInterface)object).realmGet$rememberToken();
                if (realmGet$rememberToken != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.rememberTokenIndex, rowIndex, realmGet$rememberToken, false);
                }
                String realmGet$createdAt = ((ProfileRealmProxyInterface)object).realmGet$createdAt();
                if (realmGet$createdAt != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.createdAtIndex, rowIndex, realmGet$createdAt, false);
                }
                String realmGet$updatedAt = ((ProfileRealmProxyInterface)object).realmGet$updatedAt();
                if (realmGet$updatedAt != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.updatedAtIndex, rowIndex, realmGet$updatedAt, false);
                }
                String realmGet$username = ((ProfileRealmProxyInterface)object).realmGet$username();
                if (realmGet$username != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.usernameIndex, rowIndex, realmGet$username, false);
                }
                String realmGet$dob = ((ProfileRealmProxyInterface)object).realmGet$dob();
                if (realmGet$dob != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.dobIndex, rowIndex, realmGet$dob, false);
                }
                String realmGet$jenisKelamin = ((ProfileRealmProxyInterface)object).realmGet$jenisKelamin();
                if (realmGet$jenisKelamin != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.jenisKelaminIndex, rowIndex, realmGet$jenisKelamin, false);
                }
                String realmGet$noHp = ((ProfileRealmProxyInterface)object).realmGet$noHp();
                if (realmGet$noHp != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.noHpIndex, rowIndex, realmGet$noHp, false);
                }
                String realmGet$photo = ((ProfileRealmProxyInterface)object).realmGet$photo();
                if (realmGet$photo != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.photoIndex, rowIndex, realmGet$photo, false);
                }
                String realmGet$idSurveyInterest = ((ProfileRealmProxyInterface)object).realmGet$idSurveyInterest();
                if (realmGet$idSurveyInterest != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.idSurveyInterestIndex, rowIndex, realmGet$idSurveyInterest, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.sumroch.spotme.models.db.Profile object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.sumroch.spotme.models.db.Profile.class);
        long tableNativePtr = table.getNativePtr();
        ProfileColumnInfo columnInfo = (ProfileColumnInfo) realm.schema.getColumnInfo(com.sumroch.spotme.models.db.Profile.class);
        long pkColumnIndex = table.getPrimaryKey();
        Object primaryKeyValue = ((ProfileRealmProxyInterface) object).realmGet$id();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((ProfileRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((ProfileRealmProxyInterface) object).realmGet$id());
        }
        cache.put(object, rowIndex);
        String realmGet$token = ((ProfileRealmProxyInterface)object).realmGet$token();
        if (realmGet$token != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.tokenIndex, rowIndex, realmGet$token, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.tokenIndex, rowIndex, false);
        }
        String realmGet$name = ((ProfileRealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
        }
        String realmGet$email = ((ProfileRealmProxyInterface)object).realmGet$email();
        if (realmGet$email != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.emailIndex, rowIndex, realmGet$email, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.emailIndex, rowIndex, false);
        }
        String realmGet$password = ((ProfileRealmProxyInterface)object).realmGet$password();
        if (realmGet$password != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.passwordIndex, rowIndex, realmGet$password, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.passwordIndex, rowIndex, false);
        }
        Number realmGet$role = ((ProfileRealmProxyInterface)object).realmGet$role();
        if (realmGet$role != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.roleIndex, rowIndex, realmGet$role.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.roleIndex, rowIndex, false);
        }
        String realmGet$rememberToken = ((ProfileRealmProxyInterface)object).realmGet$rememberToken();
        if (realmGet$rememberToken != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.rememberTokenIndex, rowIndex, realmGet$rememberToken, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.rememberTokenIndex, rowIndex, false);
        }
        String realmGet$createdAt = ((ProfileRealmProxyInterface)object).realmGet$createdAt();
        if (realmGet$createdAt != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.createdAtIndex, rowIndex, realmGet$createdAt, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.createdAtIndex, rowIndex, false);
        }
        String realmGet$updatedAt = ((ProfileRealmProxyInterface)object).realmGet$updatedAt();
        if (realmGet$updatedAt != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.updatedAtIndex, rowIndex, realmGet$updatedAt, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.updatedAtIndex, rowIndex, false);
        }
        String realmGet$username = ((ProfileRealmProxyInterface)object).realmGet$username();
        if (realmGet$username != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.usernameIndex, rowIndex, realmGet$username, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.usernameIndex, rowIndex, false);
        }
        String realmGet$dob = ((ProfileRealmProxyInterface)object).realmGet$dob();
        if (realmGet$dob != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.dobIndex, rowIndex, realmGet$dob, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.dobIndex, rowIndex, false);
        }
        String realmGet$jenisKelamin = ((ProfileRealmProxyInterface)object).realmGet$jenisKelamin();
        if (realmGet$jenisKelamin != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.jenisKelaminIndex, rowIndex, realmGet$jenisKelamin, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.jenisKelaminIndex, rowIndex, false);
        }
        String realmGet$noHp = ((ProfileRealmProxyInterface)object).realmGet$noHp();
        if (realmGet$noHp != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.noHpIndex, rowIndex, realmGet$noHp, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.noHpIndex, rowIndex, false);
        }
        String realmGet$photo = ((ProfileRealmProxyInterface)object).realmGet$photo();
        if (realmGet$photo != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.photoIndex, rowIndex, realmGet$photo, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.photoIndex, rowIndex, false);
        }
        String realmGet$idSurveyInterest = ((ProfileRealmProxyInterface)object).realmGet$idSurveyInterest();
        if (realmGet$idSurveyInterest != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.idSurveyInterestIndex, rowIndex, realmGet$idSurveyInterest, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.idSurveyInterestIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.sumroch.spotme.models.db.Profile.class);
        long tableNativePtr = table.getNativePtr();
        ProfileColumnInfo columnInfo = (ProfileColumnInfo) realm.schema.getColumnInfo(com.sumroch.spotme.models.db.Profile.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.sumroch.spotme.models.db.Profile object = null;
        while (objects.hasNext()) {
            object = (com.sumroch.spotme.models.db.Profile) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                Object primaryKeyValue = ((ProfileRealmProxyInterface) object).realmGet$id();
                long rowIndex = Table.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((ProfileRealmProxyInterface) object).realmGet$id());
                }
                if (rowIndex == Table.NO_MATCH) {
                    rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((ProfileRealmProxyInterface) object).realmGet$id());
                }
                cache.put(object, rowIndex);
                String realmGet$token = ((ProfileRealmProxyInterface)object).realmGet$token();
                if (realmGet$token != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.tokenIndex, rowIndex, realmGet$token, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.tokenIndex, rowIndex, false);
                }
                String realmGet$name = ((ProfileRealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
                }
                String realmGet$email = ((ProfileRealmProxyInterface)object).realmGet$email();
                if (realmGet$email != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.emailIndex, rowIndex, realmGet$email, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.emailIndex, rowIndex, false);
                }
                String realmGet$password = ((ProfileRealmProxyInterface)object).realmGet$password();
                if (realmGet$password != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.passwordIndex, rowIndex, realmGet$password, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.passwordIndex, rowIndex, false);
                }
                Number realmGet$role = ((ProfileRealmProxyInterface)object).realmGet$role();
                if (realmGet$role != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.roleIndex, rowIndex, realmGet$role.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.roleIndex, rowIndex, false);
                }
                String realmGet$rememberToken = ((ProfileRealmProxyInterface)object).realmGet$rememberToken();
                if (realmGet$rememberToken != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.rememberTokenIndex, rowIndex, realmGet$rememberToken, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.rememberTokenIndex, rowIndex, false);
                }
                String realmGet$createdAt = ((ProfileRealmProxyInterface)object).realmGet$createdAt();
                if (realmGet$createdAt != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.createdAtIndex, rowIndex, realmGet$createdAt, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.createdAtIndex, rowIndex, false);
                }
                String realmGet$updatedAt = ((ProfileRealmProxyInterface)object).realmGet$updatedAt();
                if (realmGet$updatedAt != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.updatedAtIndex, rowIndex, realmGet$updatedAt, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.updatedAtIndex, rowIndex, false);
                }
                String realmGet$username = ((ProfileRealmProxyInterface)object).realmGet$username();
                if (realmGet$username != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.usernameIndex, rowIndex, realmGet$username, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.usernameIndex, rowIndex, false);
                }
                String realmGet$dob = ((ProfileRealmProxyInterface)object).realmGet$dob();
                if (realmGet$dob != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.dobIndex, rowIndex, realmGet$dob, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.dobIndex, rowIndex, false);
                }
                String realmGet$jenisKelamin = ((ProfileRealmProxyInterface)object).realmGet$jenisKelamin();
                if (realmGet$jenisKelamin != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.jenisKelaminIndex, rowIndex, realmGet$jenisKelamin, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.jenisKelaminIndex, rowIndex, false);
                }
                String realmGet$noHp = ((ProfileRealmProxyInterface)object).realmGet$noHp();
                if (realmGet$noHp != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.noHpIndex, rowIndex, realmGet$noHp, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.noHpIndex, rowIndex, false);
                }
                String realmGet$photo = ((ProfileRealmProxyInterface)object).realmGet$photo();
                if (realmGet$photo != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.photoIndex, rowIndex, realmGet$photo, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.photoIndex, rowIndex, false);
                }
                String realmGet$idSurveyInterest = ((ProfileRealmProxyInterface)object).realmGet$idSurveyInterest();
                if (realmGet$idSurveyInterest != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.idSurveyInterestIndex, rowIndex, realmGet$idSurveyInterest, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.idSurveyInterestIndex, rowIndex, false);
                }
            }
        }
    }

    public static com.sumroch.spotme.models.db.Profile createDetachedCopy(com.sumroch.spotme.models.db.Profile realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.sumroch.spotme.models.db.Profile unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.sumroch.spotme.models.db.Profile)cachedObject.object;
            } else {
                unmanagedObject = (com.sumroch.spotme.models.db.Profile)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.sumroch.spotme.models.db.Profile();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((ProfileRealmProxyInterface) unmanagedObject).realmSet$token(((ProfileRealmProxyInterface) realmObject).realmGet$token());
        ((ProfileRealmProxyInterface) unmanagedObject).realmSet$id(((ProfileRealmProxyInterface) realmObject).realmGet$id());
        ((ProfileRealmProxyInterface) unmanagedObject).realmSet$name(((ProfileRealmProxyInterface) realmObject).realmGet$name());
        ((ProfileRealmProxyInterface) unmanagedObject).realmSet$email(((ProfileRealmProxyInterface) realmObject).realmGet$email());
        ((ProfileRealmProxyInterface) unmanagedObject).realmSet$password(((ProfileRealmProxyInterface) realmObject).realmGet$password());
        ((ProfileRealmProxyInterface) unmanagedObject).realmSet$role(((ProfileRealmProxyInterface) realmObject).realmGet$role());
        ((ProfileRealmProxyInterface) unmanagedObject).realmSet$rememberToken(((ProfileRealmProxyInterface) realmObject).realmGet$rememberToken());
        ((ProfileRealmProxyInterface) unmanagedObject).realmSet$createdAt(((ProfileRealmProxyInterface) realmObject).realmGet$createdAt());
        ((ProfileRealmProxyInterface) unmanagedObject).realmSet$updatedAt(((ProfileRealmProxyInterface) realmObject).realmGet$updatedAt());
        ((ProfileRealmProxyInterface) unmanagedObject).realmSet$username(((ProfileRealmProxyInterface) realmObject).realmGet$username());
        ((ProfileRealmProxyInterface) unmanagedObject).realmSet$dob(((ProfileRealmProxyInterface) realmObject).realmGet$dob());
        ((ProfileRealmProxyInterface) unmanagedObject).realmSet$jenisKelamin(((ProfileRealmProxyInterface) realmObject).realmGet$jenisKelamin());
        ((ProfileRealmProxyInterface) unmanagedObject).realmSet$noHp(((ProfileRealmProxyInterface) realmObject).realmGet$noHp());
        ((ProfileRealmProxyInterface) unmanagedObject).realmSet$photo(((ProfileRealmProxyInterface) realmObject).realmGet$photo());
        ((ProfileRealmProxyInterface) unmanagedObject).realmSet$idSurveyInterest(((ProfileRealmProxyInterface) realmObject).realmGet$idSurveyInterest());
        return unmanagedObject;
    }

    static com.sumroch.spotme.models.db.Profile update(Realm realm, com.sumroch.spotme.models.db.Profile realmObject, com.sumroch.spotme.models.db.Profile newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((ProfileRealmProxyInterface) realmObject).realmSet$token(((ProfileRealmProxyInterface) newObject).realmGet$token());
        ((ProfileRealmProxyInterface) realmObject).realmSet$name(((ProfileRealmProxyInterface) newObject).realmGet$name());
        ((ProfileRealmProxyInterface) realmObject).realmSet$email(((ProfileRealmProxyInterface) newObject).realmGet$email());
        ((ProfileRealmProxyInterface) realmObject).realmSet$password(((ProfileRealmProxyInterface) newObject).realmGet$password());
        ((ProfileRealmProxyInterface) realmObject).realmSet$role(((ProfileRealmProxyInterface) newObject).realmGet$role());
        ((ProfileRealmProxyInterface) realmObject).realmSet$rememberToken(((ProfileRealmProxyInterface) newObject).realmGet$rememberToken());
        ((ProfileRealmProxyInterface) realmObject).realmSet$createdAt(((ProfileRealmProxyInterface) newObject).realmGet$createdAt());
        ((ProfileRealmProxyInterface) realmObject).realmSet$updatedAt(((ProfileRealmProxyInterface) newObject).realmGet$updatedAt());
        ((ProfileRealmProxyInterface) realmObject).realmSet$username(((ProfileRealmProxyInterface) newObject).realmGet$username());
        ((ProfileRealmProxyInterface) realmObject).realmSet$dob(((ProfileRealmProxyInterface) newObject).realmGet$dob());
        ((ProfileRealmProxyInterface) realmObject).realmSet$jenisKelamin(((ProfileRealmProxyInterface) newObject).realmGet$jenisKelamin());
        ((ProfileRealmProxyInterface) realmObject).realmSet$noHp(((ProfileRealmProxyInterface) newObject).realmGet$noHp());
        ((ProfileRealmProxyInterface) realmObject).realmSet$photo(((ProfileRealmProxyInterface) newObject).realmGet$photo());
        ((ProfileRealmProxyInterface) realmObject).realmSet$idSurveyInterest(((ProfileRealmProxyInterface) newObject).realmGet$idSurveyInterest());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Profile = proxy[");
        stringBuilder.append("{token:");
        stringBuilder.append(realmGet$token() != null ? realmGet$token() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{email:");
        stringBuilder.append(realmGet$email() != null ? realmGet$email() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{password:");
        stringBuilder.append(realmGet$password() != null ? realmGet$password() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{role:");
        stringBuilder.append(realmGet$role() != null ? realmGet$role() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{rememberToken:");
        stringBuilder.append(realmGet$rememberToken() != null ? realmGet$rememberToken() : "null");
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
        stringBuilder.append("{username:");
        stringBuilder.append(realmGet$username() != null ? realmGet$username() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{dob:");
        stringBuilder.append(realmGet$dob() != null ? realmGet$dob() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{jenisKelamin:");
        stringBuilder.append(realmGet$jenisKelamin() != null ? realmGet$jenisKelamin() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{noHp:");
        stringBuilder.append(realmGet$noHp() != null ? realmGet$noHp() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{photo:");
        stringBuilder.append(realmGet$photo() != null ? realmGet$photo() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{idSurveyInterest:");
        stringBuilder.append(realmGet$idSurveyInterest() != null ? realmGet$idSurveyInterest() : "null");
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
        ProfileRealmProxy aProfile = (ProfileRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aProfile.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aProfile.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aProfile.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
