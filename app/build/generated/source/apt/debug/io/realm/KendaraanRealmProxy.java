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

public class KendaraanRealmProxy extends com.sumroch.spotme.models.db.Kendaraan
    implements RealmObjectProxy, KendaraanRealmProxyInterface {

    static final class KendaraanColumnInfo extends ColumnInfo {
        long idIndex;
        long platNomorIndex;
        long jenisKendaraanIndex;
        long warnaIndex;
        long idUserIndex;
        long createdAtIndex;
        long updatedAtIndex;

        KendaraanColumnInfo(SharedRealm realm, Table table) {
            super(7);
            this.idIndex = addColumnDetails(table, "id", RealmFieldType.INTEGER);
            this.platNomorIndex = addColumnDetails(table, "platNomor", RealmFieldType.STRING);
            this.jenisKendaraanIndex = addColumnDetails(table, "jenisKendaraan", RealmFieldType.STRING);
            this.warnaIndex = addColumnDetails(table, "warna", RealmFieldType.STRING);
            this.idUserIndex = addColumnDetails(table, "idUser", RealmFieldType.INTEGER);
            this.createdAtIndex = addColumnDetails(table, "createdAt", RealmFieldType.STRING);
            this.updatedAtIndex = addColumnDetails(table, "updatedAt", RealmFieldType.STRING);
        }

        KendaraanColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new KendaraanColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final KendaraanColumnInfo src = (KendaraanColumnInfo) rawSrc;
            final KendaraanColumnInfo dst = (KendaraanColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.platNomorIndex = src.platNomorIndex;
            dst.jenisKendaraanIndex = src.jenisKendaraanIndex;
            dst.warnaIndex = src.warnaIndex;
            dst.idUserIndex = src.idUserIndex;
            dst.createdAtIndex = src.createdAtIndex;
            dst.updatedAtIndex = src.updatedAtIndex;
        }
    }

    private KendaraanColumnInfo columnInfo;
    private ProxyState<com.sumroch.spotme.models.db.Kendaraan> proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("platNomor");
        fieldNames.add("jenisKendaraan");
        fieldNames.add("warna");
        fieldNames.add("idUser");
        fieldNames.add("createdAt");
        fieldNames.add("updatedAt");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    KendaraanRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (KendaraanColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.sumroch.spotme.models.db.Kendaraan>(this);
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
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.idIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.idIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.idIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.idIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$platNomor() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.platNomorIndex);
    }

    @Override
    public void realmSet$platNomor(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.platNomorIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.platNomorIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.platNomorIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.platNomorIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$jenisKendaraan() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.jenisKendaraanIndex);
    }

    @Override
    public void realmSet$jenisKendaraan(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.jenisKendaraanIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.jenisKendaraanIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.jenisKendaraanIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.jenisKendaraanIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$warna() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.warnaIndex);
    }

    @Override
    public void realmSet$warna(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.warnaIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.warnaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.warnaIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.warnaIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$idUser() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.idUserIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.idUserIndex);
    }

    @Override
    public void realmSet$idUser(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.idUserIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.idUserIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.idUserIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.idUserIndex, value);
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

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("Kendaraan")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("Kendaraan");
            realmObjectSchema.add("id", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("platNomor", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("jenisKendaraan", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("warna", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("idUser", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("createdAt", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("updatedAt", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            return realmObjectSchema;
        }
        return realmSchema.get("Kendaraan");
    }

    public static KendaraanColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (!sharedRealm.hasTable("class_Kendaraan")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'Kendaraan' class is missing from the schema for this Realm.");
        }
        Table table = sharedRealm.getTable("class_Kendaraan");
        final long columnCount = table.getColumnCount();
        if (columnCount != 7) {
            if (columnCount < 7) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 7 but was " + columnCount);
            }
            if (allowExtraColumns) {
                RealmLog.debug("Field count is more than expected - expected 7 but was %1$d", columnCount);
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 7 but was " + columnCount);
            }
        }
        Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
        for (long i = 0; i < columnCount; i++) {
            columnTypes.put(table.getColumnName(i), table.getColumnType(i));
        }

        final KendaraanColumnInfo columnInfo = new KendaraanColumnInfo(sharedRealm, table);

        if (table.hasPrimaryKey()) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary Key defined for field " + table.getColumnName(table.getPrimaryKey()) + " was removed.");
        }

        if (!columnTypes.containsKey("id")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'id' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("id") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'id' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.idIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'id' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'id' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("platNomor")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'platNomor' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("platNomor") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'platNomor' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.platNomorIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'platNomor' is required. Either set @Required to field 'platNomor' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("jenisKendaraan")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'jenisKendaraan' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("jenisKendaraan") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'jenisKendaraan' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.jenisKendaraanIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'jenisKendaraan' is required. Either set @Required to field 'jenisKendaraan' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("warna")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'warna' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("warna") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'warna' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.warnaIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'warna' is required. Either set @Required to field 'warna' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("idUser")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'idUser' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("idUser") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'idUser' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.idUserIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'idUser' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'idUser' or migrate using RealmObjectSchema.setNullable().");
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

        return columnInfo;
    }

    public static String getTableName() {
        return "class_Kendaraan";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.sumroch.spotme.models.db.Kendaraan createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.sumroch.spotme.models.db.Kendaraan obj = realm.createObjectInternal(com.sumroch.spotme.models.db.Kendaraan.class, true, excludeFields);
        if (json.has("id")) {
            if (json.isNull("id")) {
                ((KendaraanRealmProxyInterface) obj).realmSet$id(null);
            } else {
                ((KendaraanRealmProxyInterface) obj).realmSet$id((int) json.getInt("id"));
            }
        }
        if (json.has("platNomor")) {
            if (json.isNull("platNomor")) {
                ((KendaraanRealmProxyInterface) obj).realmSet$platNomor(null);
            } else {
                ((KendaraanRealmProxyInterface) obj).realmSet$platNomor((String) json.getString("platNomor"));
            }
        }
        if (json.has("jenisKendaraan")) {
            if (json.isNull("jenisKendaraan")) {
                ((KendaraanRealmProxyInterface) obj).realmSet$jenisKendaraan(null);
            } else {
                ((KendaraanRealmProxyInterface) obj).realmSet$jenisKendaraan((String) json.getString("jenisKendaraan"));
            }
        }
        if (json.has("warna")) {
            if (json.isNull("warna")) {
                ((KendaraanRealmProxyInterface) obj).realmSet$warna(null);
            } else {
                ((KendaraanRealmProxyInterface) obj).realmSet$warna((String) json.getString("warna"));
            }
        }
        if (json.has("idUser")) {
            if (json.isNull("idUser")) {
                ((KendaraanRealmProxyInterface) obj).realmSet$idUser(null);
            } else {
                ((KendaraanRealmProxyInterface) obj).realmSet$idUser((int) json.getInt("idUser"));
            }
        }
        if (json.has("createdAt")) {
            if (json.isNull("createdAt")) {
                ((KendaraanRealmProxyInterface) obj).realmSet$createdAt(null);
            } else {
                ((KendaraanRealmProxyInterface) obj).realmSet$createdAt((String) json.getString("createdAt"));
            }
        }
        if (json.has("updatedAt")) {
            if (json.isNull("updatedAt")) {
                ((KendaraanRealmProxyInterface) obj).realmSet$updatedAt(null);
            } else {
                ((KendaraanRealmProxyInterface) obj).realmSet$updatedAt((String) json.getString("updatedAt"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.sumroch.spotme.models.db.Kendaraan createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        com.sumroch.spotme.models.db.Kendaraan obj = new com.sumroch.spotme.models.db.Kendaraan();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((KendaraanRealmProxyInterface) obj).realmSet$id(null);
                } else {
                    ((KendaraanRealmProxyInterface) obj).realmSet$id((int) reader.nextInt());
                }
            } else if (name.equals("platNomor")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((KendaraanRealmProxyInterface) obj).realmSet$platNomor(null);
                } else {
                    ((KendaraanRealmProxyInterface) obj).realmSet$platNomor((String) reader.nextString());
                }
            } else if (name.equals("jenisKendaraan")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((KendaraanRealmProxyInterface) obj).realmSet$jenisKendaraan(null);
                } else {
                    ((KendaraanRealmProxyInterface) obj).realmSet$jenisKendaraan((String) reader.nextString());
                }
            } else if (name.equals("warna")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((KendaraanRealmProxyInterface) obj).realmSet$warna(null);
                } else {
                    ((KendaraanRealmProxyInterface) obj).realmSet$warna((String) reader.nextString());
                }
            } else if (name.equals("idUser")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((KendaraanRealmProxyInterface) obj).realmSet$idUser(null);
                } else {
                    ((KendaraanRealmProxyInterface) obj).realmSet$idUser((int) reader.nextInt());
                }
            } else if (name.equals("createdAt")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((KendaraanRealmProxyInterface) obj).realmSet$createdAt(null);
                } else {
                    ((KendaraanRealmProxyInterface) obj).realmSet$createdAt((String) reader.nextString());
                }
            } else if (name.equals("updatedAt")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((KendaraanRealmProxyInterface) obj).realmSet$updatedAt(null);
                } else {
                    ((KendaraanRealmProxyInterface) obj).realmSet$updatedAt((String) reader.nextString());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.sumroch.spotme.models.db.Kendaraan copyOrUpdate(Realm realm, com.sumroch.spotme.models.db.Kendaraan object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.sumroch.spotme.models.db.Kendaraan) cachedRealmObject;
        } else {
            return copy(realm, object, update, cache);
        }
    }

    public static com.sumroch.spotme.models.db.Kendaraan copy(Realm realm, com.sumroch.spotme.models.db.Kendaraan newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.sumroch.spotme.models.db.Kendaraan) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.sumroch.spotme.models.db.Kendaraan realmObject = realm.createObjectInternal(com.sumroch.spotme.models.db.Kendaraan.class, false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((KendaraanRealmProxyInterface) realmObject).realmSet$id(((KendaraanRealmProxyInterface) newObject).realmGet$id());
            ((KendaraanRealmProxyInterface) realmObject).realmSet$platNomor(((KendaraanRealmProxyInterface) newObject).realmGet$platNomor());
            ((KendaraanRealmProxyInterface) realmObject).realmSet$jenisKendaraan(((KendaraanRealmProxyInterface) newObject).realmGet$jenisKendaraan());
            ((KendaraanRealmProxyInterface) realmObject).realmSet$warna(((KendaraanRealmProxyInterface) newObject).realmGet$warna());
            ((KendaraanRealmProxyInterface) realmObject).realmSet$idUser(((KendaraanRealmProxyInterface) newObject).realmGet$idUser());
            ((KendaraanRealmProxyInterface) realmObject).realmSet$createdAt(((KendaraanRealmProxyInterface) newObject).realmGet$createdAt());
            ((KendaraanRealmProxyInterface) realmObject).realmSet$updatedAt(((KendaraanRealmProxyInterface) newObject).realmGet$updatedAt());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.sumroch.spotme.models.db.Kendaraan object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.sumroch.spotme.models.db.Kendaraan.class);
        long tableNativePtr = table.getNativePtr();
        KendaraanColumnInfo columnInfo = (KendaraanColumnInfo) realm.schema.getColumnInfo(com.sumroch.spotme.models.db.Kendaraan.class);
        long rowIndex = OsObject.createRow(realm.sharedRealm, table);
        cache.put(object, rowIndex);
        Number realmGet$id = ((KendaraanRealmProxyInterface)object).realmGet$id();
        if (realmGet$id != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id.longValue(), false);
        }
        String realmGet$platNomor = ((KendaraanRealmProxyInterface)object).realmGet$platNomor();
        if (realmGet$platNomor != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.platNomorIndex, rowIndex, realmGet$platNomor, false);
        }
        String realmGet$jenisKendaraan = ((KendaraanRealmProxyInterface)object).realmGet$jenisKendaraan();
        if (realmGet$jenisKendaraan != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.jenisKendaraanIndex, rowIndex, realmGet$jenisKendaraan, false);
        }
        String realmGet$warna = ((KendaraanRealmProxyInterface)object).realmGet$warna();
        if (realmGet$warna != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.warnaIndex, rowIndex, realmGet$warna, false);
        }
        Number realmGet$idUser = ((KendaraanRealmProxyInterface)object).realmGet$idUser();
        if (realmGet$idUser != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.idUserIndex, rowIndex, realmGet$idUser.longValue(), false);
        }
        String realmGet$createdAt = ((KendaraanRealmProxyInterface)object).realmGet$createdAt();
        if (realmGet$createdAt != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.createdAtIndex, rowIndex, realmGet$createdAt, false);
        }
        String realmGet$updatedAt = ((KendaraanRealmProxyInterface)object).realmGet$updatedAt();
        if (realmGet$updatedAt != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.updatedAtIndex, rowIndex, realmGet$updatedAt, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.sumroch.spotme.models.db.Kendaraan.class);
        long tableNativePtr = table.getNativePtr();
        KendaraanColumnInfo columnInfo = (KendaraanColumnInfo) realm.schema.getColumnInfo(com.sumroch.spotme.models.db.Kendaraan.class);
        com.sumroch.spotme.models.db.Kendaraan object = null;
        while (objects.hasNext()) {
            object = (com.sumroch.spotme.models.db.Kendaraan) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = OsObject.createRow(realm.sharedRealm, table);
                cache.put(object, rowIndex);
                Number realmGet$id = ((KendaraanRealmProxyInterface)object).realmGet$id();
                if (realmGet$id != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id.longValue(), false);
                }
                String realmGet$platNomor = ((KendaraanRealmProxyInterface)object).realmGet$platNomor();
                if (realmGet$platNomor != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.platNomorIndex, rowIndex, realmGet$platNomor, false);
                }
                String realmGet$jenisKendaraan = ((KendaraanRealmProxyInterface)object).realmGet$jenisKendaraan();
                if (realmGet$jenisKendaraan != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.jenisKendaraanIndex, rowIndex, realmGet$jenisKendaraan, false);
                }
                String realmGet$warna = ((KendaraanRealmProxyInterface)object).realmGet$warna();
                if (realmGet$warna != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.warnaIndex, rowIndex, realmGet$warna, false);
                }
                Number realmGet$idUser = ((KendaraanRealmProxyInterface)object).realmGet$idUser();
                if (realmGet$idUser != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.idUserIndex, rowIndex, realmGet$idUser.longValue(), false);
                }
                String realmGet$createdAt = ((KendaraanRealmProxyInterface)object).realmGet$createdAt();
                if (realmGet$createdAt != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.createdAtIndex, rowIndex, realmGet$createdAt, false);
                }
                String realmGet$updatedAt = ((KendaraanRealmProxyInterface)object).realmGet$updatedAt();
                if (realmGet$updatedAt != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.updatedAtIndex, rowIndex, realmGet$updatedAt, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.sumroch.spotme.models.db.Kendaraan object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.sumroch.spotme.models.db.Kendaraan.class);
        long tableNativePtr = table.getNativePtr();
        KendaraanColumnInfo columnInfo = (KendaraanColumnInfo) realm.schema.getColumnInfo(com.sumroch.spotme.models.db.Kendaraan.class);
        long rowIndex = OsObject.createRow(realm.sharedRealm, table);
        cache.put(object, rowIndex);
        Number realmGet$id = ((KendaraanRealmProxyInterface)object).realmGet$id();
        if (realmGet$id != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.idIndex, rowIndex, false);
        }
        String realmGet$platNomor = ((KendaraanRealmProxyInterface)object).realmGet$platNomor();
        if (realmGet$platNomor != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.platNomorIndex, rowIndex, realmGet$platNomor, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.platNomorIndex, rowIndex, false);
        }
        String realmGet$jenisKendaraan = ((KendaraanRealmProxyInterface)object).realmGet$jenisKendaraan();
        if (realmGet$jenisKendaraan != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.jenisKendaraanIndex, rowIndex, realmGet$jenisKendaraan, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.jenisKendaraanIndex, rowIndex, false);
        }
        String realmGet$warna = ((KendaraanRealmProxyInterface)object).realmGet$warna();
        if (realmGet$warna != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.warnaIndex, rowIndex, realmGet$warna, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.warnaIndex, rowIndex, false);
        }
        Number realmGet$idUser = ((KendaraanRealmProxyInterface)object).realmGet$idUser();
        if (realmGet$idUser != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.idUserIndex, rowIndex, realmGet$idUser.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.idUserIndex, rowIndex, false);
        }
        String realmGet$createdAt = ((KendaraanRealmProxyInterface)object).realmGet$createdAt();
        if (realmGet$createdAt != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.createdAtIndex, rowIndex, realmGet$createdAt, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.createdAtIndex, rowIndex, false);
        }
        String realmGet$updatedAt = ((KendaraanRealmProxyInterface)object).realmGet$updatedAt();
        if (realmGet$updatedAt != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.updatedAtIndex, rowIndex, realmGet$updatedAt, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.updatedAtIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.sumroch.spotme.models.db.Kendaraan.class);
        long tableNativePtr = table.getNativePtr();
        KendaraanColumnInfo columnInfo = (KendaraanColumnInfo) realm.schema.getColumnInfo(com.sumroch.spotme.models.db.Kendaraan.class);
        com.sumroch.spotme.models.db.Kendaraan object = null;
        while (objects.hasNext()) {
            object = (com.sumroch.spotme.models.db.Kendaraan) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = OsObject.createRow(realm.sharedRealm, table);
                cache.put(object, rowIndex);
                Number realmGet$id = ((KendaraanRealmProxyInterface)object).realmGet$id();
                if (realmGet$id != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.idIndex, rowIndex, false);
                }
                String realmGet$platNomor = ((KendaraanRealmProxyInterface)object).realmGet$platNomor();
                if (realmGet$platNomor != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.platNomorIndex, rowIndex, realmGet$platNomor, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.platNomorIndex, rowIndex, false);
                }
                String realmGet$jenisKendaraan = ((KendaraanRealmProxyInterface)object).realmGet$jenisKendaraan();
                if (realmGet$jenisKendaraan != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.jenisKendaraanIndex, rowIndex, realmGet$jenisKendaraan, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.jenisKendaraanIndex, rowIndex, false);
                }
                String realmGet$warna = ((KendaraanRealmProxyInterface)object).realmGet$warna();
                if (realmGet$warna != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.warnaIndex, rowIndex, realmGet$warna, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.warnaIndex, rowIndex, false);
                }
                Number realmGet$idUser = ((KendaraanRealmProxyInterface)object).realmGet$idUser();
                if (realmGet$idUser != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.idUserIndex, rowIndex, realmGet$idUser.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.idUserIndex, rowIndex, false);
                }
                String realmGet$createdAt = ((KendaraanRealmProxyInterface)object).realmGet$createdAt();
                if (realmGet$createdAt != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.createdAtIndex, rowIndex, realmGet$createdAt, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.createdAtIndex, rowIndex, false);
                }
                String realmGet$updatedAt = ((KendaraanRealmProxyInterface)object).realmGet$updatedAt();
                if (realmGet$updatedAt != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.updatedAtIndex, rowIndex, realmGet$updatedAt, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.updatedAtIndex, rowIndex, false);
                }
            }
        }
    }

    public static com.sumroch.spotme.models.db.Kendaraan createDetachedCopy(com.sumroch.spotme.models.db.Kendaraan realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.sumroch.spotme.models.db.Kendaraan unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.sumroch.spotme.models.db.Kendaraan)cachedObject.object;
            } else {
                unmanagedObject = (com.sumroch.spotme.models.db.Kendaraan)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.sumroch.spotme.models.db.Kendaraan();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((KendaraanRealmProxyInterface) unmanagedObject).realmSet$id(((KendaraanRealmProxyInterface) realmObject).realmGet$id());
        ((KendaraanRealmProxyInterface) unmanagedObject).realmSet$platNomor(((KendaraanRealmProxyInterface) realmObject).realmGet$platNomor());
        ((KendaraanRealmProxyInterface) unmanagedObject).realmSet$jenisKendaraan(((KendaraanRealmProxyInterface) realmObject).realmGet$jenisKendaraan());
        ((KendaraanRealmProxyInterface) unmanagedObject).realmSet$warna(((KendaraanRealmProxyInterface) realmObject).realmGet$warna());
        ((KendaraanRealmProxyInterface) unmanagedObject).realmSet$idUser(((KendaraanRealmProxyInterface) realmObject).realmGet$idUser());
        ((KendaraanRealmProxyInterface) unmanagedObject).realmSet$createdAt(((KendaraanRealmProxyInterface) realmObject).realmGet$createdAt());
        ((KendaraanRealmProxyInterface) unmanagedObject).realmSet$updatedAt(((KendaraanRealmProxyInterface) realmObject).realmGet$updatedAt());
        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Kendaraan = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{platNomor:");
        stringBuilder.append(realmGet$platNomor() != null ? realmGet$platNomor() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{jenisKendaraan:");
        stringBuilder.append(realmGet$jenisKendaraan() != null ? realmGet$jenisKendaraan() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{warna:");
        stringBuilder.append(realmGet$warna() != null ? realmGet$warna() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{idUser:");
        stringBuilder.append(realmGet$idUser() != null ? realmGet$idUser() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{createdAt:");
        stringBuilder.append(realmGet$createdAt() != null ? realmGet$createdAt() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{updatedAt:");
        stringBuilder.append(realmGet$updatedAt() != null ? realmGet$updatedAt() : "null");
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
        KendaraanRealmProxy aKendaraan = (KendaraanRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aKendaraan.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aKendaraan.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aKendaraan.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
