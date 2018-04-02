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

public class HistoryParkirRealmProxy extends com.sumroch.spotme.models.db.HistoryParkir
    implements RealmObjectProxy, HistoryParkirRealmProxyInterface {

    static final class HistoryParkirColumnInfo extends ColumnInfo {
        long idParkirIndex;
        long namaMallIndex;
        long nameUserIndex;
        long platNomorIndex;
        long jenisKendaraanIndex;
        long nomorLantaiIndex;
        long nomorBlokIndex;
        long hargaPerjamIndex;
        long waktuMasukIndex;
        long waktuKeluarIndex;
        long statusIndex;
        long totalHargaIndex;

        HistoryParkirColumnInfo(SharedRealm realm, Table table) {
            super(12);
            this.idParkirIndex = addColumnDetails(table, "idParkir", RealmFieldType.STRING);
            this.namaMallIndex = addColumnDetails(table, "namaMall", RealmFieldType.STRING);
            this.nameUserIndex = addColumnDetails(table, "nameUser", RealmFieldType.STRING);
            this.platNomorIndex = addColumnDetails(table, "platNomor", RealmFieldType.STRING);
            this.jenisKendaraanIndex = addColumnDetails(table, "jenisKendaraan", RealmFieldType.STRING);
            this.nomorLantaiIndex = addColumnDetails(table, "nomorLantai", RealmFieldType.STRING);
            this.nomorBlokIndex = addColumnDetails(table, "nomorBlok", RealmFieldType.STRING);
            this.hargaPerjamIndex = addColumnDetails(table, "hargaPerjam", RealmFieldType.INTEGER);
            this.waktuMasukIndex = addColumnDetails(table, "waktuMasuk", RealmFieldType.STRING);
            this.waktuKeluarIndex = addColumnDetails(table, "waktuKeluar", RealmFieldType.STRING);
            this.statusIndex = addColumnDetails(table, "status", RealmFieldType.STRING);
            this.totalHargaIndex = addColumnDetails(table, "totalHarga", RealmFieldType.INTEGER);
        }

        HistoryParkirColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new HistoryParkirColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final HistoryParkirColumnInfo src = (HistoryParkirColumnInfo) rawSrc;
            final HistoryParkirColumnInfo dst = (HistoryParkirColumnInfo) rawDst;
            dst.idParkirIndex = src.idParkirIndex;
            dst.namaMallIndex = src.namaMallIndex;
            dst.nameUserIndex = src.nameUserIndex;
            dst.platNomorIndex = src.platNomorIndex;
            dst.jenisKendaraanIndex = src.jenisKendaraanIndex;
            dst.nomorLantaiIndex = src.nomorLantaiIndex;
            dst.nomorBlokIndex = src.nomorBlokIndex;
            dst.hargaPerjamIndex = src.hargaPerjamIndex;
            dst.waktuMasukIndex = src.waktuMasukIndex;
            dst.waktuKeluarIndex = src.waktuKeluarIndex;
            dst.statusIndex = src.statusIndex;
            dst.totalHargaIndex = src.totalHargaIndex;
        }
    }

    private HistoryParkirColumnInfo columnInfo;
    private ProxyState<com.sumroch.spotme.models.db.HistoryParkir> proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("idParkir");
        fieldNames.add("namaMall");
        fieldNames.add("nameUser");
        fieldNames.add("platNomor");
        fieldNames.add("jenisKendaraan");
        fieldNames.add("nomorLantai");
        fieldNames.add("nomorBlok");
        fieldNames.add("hargaPerjam");
        fieldNames.add("waktuMasuk");
        fieldNames.add("waktuKeluar");
        fieldNames.add("status");
        fieldNames.add("totalHarga");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    HistoryParkirRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (HistoryParkirColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.sumroch.spotme.models.db.HistoryParkir>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$idParkir() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.idParkirIndex);
    }

    @Override
    public void realmSet$idParkir(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.idParkirIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.idParkirIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.idParkirIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.idParkirIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$namaMall() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.namaMallIndex);
    }

    @Override
    public void realmSet$namaMall(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.namaMallIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.namaMallIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.namaMallIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.namaMallIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$nameUser() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nameUserIndex);
    }

    @Override
    public void realmSet$nameUser(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nameUserIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nameUserIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nameUserIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nameUserIndex, value);
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
    public String realmGet$nomorLantai() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nomorLantaiIndex);
    }

    @Override
    public void realmSet$nomorLantai(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nomorLantaiIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nomorLantaiIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nomorLantaiIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nomorLantaiIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$nomorBlok() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nomorBlokIndex);
    }

    @Override
    public void realmSet$nomorBlok(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nomorBlokIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nomorBlokIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nomorBlokIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nomorBlokIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$hargaPerjam() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.hargaPerjamIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.hargaPerjamIndex);
    }

    @Override
    public void realmSet$hargaPerjam(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.hargaPerjamIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.hargaPerjamIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.hargaPerjamIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.hargaPerjamIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$waktuMasuk() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.waktuMasukIndex);
    }

    @Override
    public void realmSet$waktuMasuk(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.waktuMasukIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.waktuMasukIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.waktuMasukIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.waktuMasukIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$waktuKeluar() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.waktuKeluarIndex);
    }

    @Override
    public void realmSet$waktuKeluar(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.waktuKeluarIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.waktuKeluarIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.waktuKeluarIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.waktuKeluarIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$status() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.statusIndex);
    }

    @Override
    public void realmSet$status(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.statusIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.statusIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.statusIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.statusIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$totalHarga() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.totalHargaIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.totalHargaIndex);
    }

    @Override
    public void realmSet$totalHarga(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.totalHargaIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.totalHargaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.totalHargaIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.totalHargaIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("HistoryParkir")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("HistoryParkir");
            realmObjectSchema.add("idParkir", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("namaMall", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("nameUser", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("platNomor", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("jenisKendaraan", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("nomorLantai", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("nomorBlok", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("hargaPerjam", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("waktuMasuk", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("waktuKeluar", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("status", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("totalHarga", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            return realmObjectSchema;
        }
        return realmSchema.get("HistoryParkir");
    }

    public static HistoryParkirColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (!sharedRealm.hasTable("class_HistoryParkir")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'HistoryParkir' class is missing from the schema for this Realm.");
        }
        Table table = sharedRealm.getTable("class_HistoryParkir");
        final long columnCount = table.getColumnCount();
        if (columnCount != 12) {
            if (columnCount < 12) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 12 but was " + columnCount);
            }
            if (allowExtraColumns) {
                RealmLog.debug("Field count is more than expected - expected 12 but was %1$d", columnCount);
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 12 but was " + columnCount);
            }
        }
        Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
        for (long i = 0; i < columnCount; i++) {
            columnTypes.put(table.getColumnName(i), table.getColumnType(i));
        }

        final HistoryParkirColumnInfo columnInfo = new HistoryParkirColumnInfo(sharedRealm, table);

        if (table.hasPrimaryKey()) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary Key defined for field " + table.getColumnName(table.getPrimaryKey()) + " was removed.");
        }

        if (!columnTypes.containsKey("idParkir")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'idParkir' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("idParkir") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'idParkir' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.idParkirIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'idParkir' is required. Either set @Required to field 'idParkir' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("namaMall")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'namaMall' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("namaMall") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'namaMall' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.namaMallIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'namaMall' is required. Either set @Required to field 'namaMall' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("nameUser")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'nameUser' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("nameUser") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'nameUser' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.nameUserIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'nameUser' is required. Either set @Required to field 'nameUser' or migrate using RealmObjectSchema.setNullable().");
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
        if (!columnTypes.containsKey("nomorLantai")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'nomorLantai' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("nomorLantai") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'nomorLantai' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.nomorLantaiIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'nomorLantai' is required. Either set @Required to field 'nomorLantai' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("nomorBlok")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'nomorBlok' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("nomorBlok") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'nomorBlok' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.nomorBlokIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'nomorBlok' is required. Either set @Required to field 'nomorBlok' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("hargaPerjam")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'hargaPerjam' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("hargaPerjam") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'hargaPerjam' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.hargaPerjamIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'hargaPerjam' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'hargaPerjam' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("waktuMasuk")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'waktuMasuk' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("waktuMasuk") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'waktuMasuk' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.waktuMasukIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'waktuMasuk' is required. Either set @Required to field 'waktuMasuk' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("waktuKeluar")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'waktuKeluar' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("waktuKeluar") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'waktuKeluar' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.waktuKeluarIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'waktuKeluar' is required. Either set @Required to field 'waktuKeluar' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("status")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'status' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("status") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'status' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.statusIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'status' is required. Either set @Required to field 'status' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("totalHarga")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'totalHarga' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("totalHarga") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'totalHarga' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.totalHargaIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'totalHarga' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'totalHarga' or migrate using RealmObjectSchema.setNullable().");
        }

        return columnInfo;
    }

    public static String getTableName() {
        return "class_HistoryParkir";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.sumroch.spotme.models.db.HistoryParkir createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.sumroch.spotme.models.db.HistoryParkir obj = realm.createObjectInternal(com.sumroch.spotme.models.db.HistoryParkir.class, true, excludeFields);
        if (json.has("idParkir")) {
            if (json.isNull("idParkir")) {
                ((HistoryParkirRealmProxyInterface) obj).realmSet$idParkir(null);
            } else {
                ((HistoryParkirRealmProxyInterface) obj).realmSet$idParkir((String) json.getString("idParkir"));
            }
        }
        if (json.has("namaMall")) {
            if (json.isNull("namaMall")) {
                ((HistoryParkirRealmProxyInterface) obj).realmSet$namaMall(null);
            } else {
                ((HistoryParkirRealmProxyInterface) obj).realmSet$namaMall((String) json.getString("namaMall"));
            }
        }
        if (json.has("nameUser")) {
            if (json.isNull("nameUser")) {
                ((HistoryParkirRealmProxyInterface) obj).realmSet$nameUser(null);
            } else {
                ((HistoryParkirRealmProxyInterface) obj).realmSet$nameUser((String) json.getString("nameUser"));
            }
        }
        if (json.has("platNomor")) {
            if (json.isNull("platNomor")) {
                ((HistoryParkirRealmProxyInterface) obj).realmSet$platNomor(null);
            } else {
                ((HistoryParkirRealmProxyInterface) obj).realmSet$platNomor((String) json.getString("platNomor"));
            }
        }
        if (json.has("jenisKendaraan")) {
            if (json.isNull("jenisKendaraan")) {
                ((HistoryParkirRealmProxyInterface) obj).realmSet$jenisKendaraan(null);
            } else {
                ((HistoryParkirRealmProxyInterface) obj).realmSet$jenisKendaraan((String) json.getString("jenisKendaraan"));
            }
        }
        if (json.has("nomorLantai")) {
            if (json.isNull("nomorLantai")) {
                ((HistoryParkirRealmProxyInterface) obj).realmSet$nomorLantai(null);
            } else {
                ((HistoryParkirRealmProxyInterface) obj).realmSet$nomorLantai((String) json.getString("nomorLantai"));
            }
        }
        if (json.has("nomorBlok")) {
            if (json.isNull("nomorBlok")) {
                ((HistoryParkirRealmProxyInterface) obj).realmSet$nomorBlok(null);
            } else {
                ((HistoryParkirRealmProxyInterface) obj).realmSet$nomorBlok((String) json.getString("nomorBlok"));
            }
        }
        if (json.has("hargaPerjam")) {
            if (json.isNull("hargaPerjam")) {
                ((HistoryParkirRealmProxyInterface) obj).realmSet$hargaPerjam(null);
            } else {
                ((HistoryParkirRealmProxyInterface) obj).realmSet$hargaPerjam((int) json.getInt("hargaPerjam"));
            }
        }
        if (json.has("waktuMasuk")) {
            if (json.isNull("waktuMasuk")) {
                ((HistoryParkirRealmProxyInterface) obj).realmSet$waktuMasuk(null);
            } else {
                ((HistoryParkirRealmProxyInterface) obj).realmSet$waktuMasuk((String) json.getString("waktuMasuk"));
            }
        }
        if (json.has("waktuKeluar")) {
            if (json.isNull("waktuKeluar")) {
                ((HistoryParkirRealmProxyInterface) obj).realmSet$waktuKeluar(null);
            } else {
                ((HistoryParkirRealmProxyInterface) obj).realmSet$waktuKeluar((String) json.getString("waktuKeluar"));
            }
        }
        if (json.has("status")) {
            if (json.isNull("status")) {
                ((HistoryParkirRealmProxyInterface) obj).realmSet$status(null);
            } else {
                ((HistoryParkirRealmProxyInterface) obj).realmSet$status((String) json.getString("status"));
            }
        }
        if (json.has("totalHarga")) {
            if (json.isNull("totalHarga")) {
                ((HistoryParkirRealmProxyInterface) obj).realmSet$totalHarga(null);
            } else {
                ((HistoryParkirRealmProxyInterface) obj).realmSet$totalHarga((int) json.getInt("totalHarga"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.sumroch.spotme.models.db.HistoryParkir createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        com.sumroch.spotme.models.db.HistoryParkir obj = new com.sumroch.spotme.models.db.HistoryParkir();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("idParkir")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((HistoryParkirRealmProxyInterface) obj).realmSet$idParkir(null);
                } else {
                    ((HistoryParkirRealmProxyInterface) obj).realmSet$idParkir((String) reader.nextString());
                }
            } else if (name.equals("namaMall")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((HistoryParkirRealmProxyInterface) obj).realmSet$namaMall(null);
                } else {
                    ((HistoryParkirRealmProxyInterface) obj).realmSet$namaMall((String) reader.nextString());
                }
            } else if (name.equals("nameUser")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((HistoryParkirRealmProxyInterface) obj).realmSet$nameUser(null);
                } else {
                    ((HistoryParkirRealmProxyInterface) obj).realmSet$nameUser((String) reader.nextString());
                }
            } else if (name.equals("platNomor")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((HistoryParkirRealmProxyInterface) obj).realmSet$platNomor(null);
                } else {
                    ((HistoryParkirRealmProxyInterface) obj).realmSet$platNomor((String) reader.nextString());
                }
            } else if (name.equals("jenisKendaraan")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((HistoryParkirRealmProxyInterface) obj).realmSet$jenisKendaraan(null);
                } else {
                    ((HistoryParkirRealmProxyInterface) obj).realmSet$jenisKendaraan((String) reader.nextString());
                }
            } else if (name.equals("nomorLantai")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((HistoryParkirRealmProxyInterface) obj).realmSet$nomorLantai(null);
                } else {
                    ((HistoryParkirRealmProxyInterface) obj).realmSet$nomorLantai((String) reader.nextString());
                }
            } else if (name.equals("nomorBlok")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((HistoryParkirRealmProxyInterface) obj).realmSet$nomorBlok(null);
                } else {
                    ((HistoryParkirRealmProxyInterface) obj).realmSet$nomorBlok((String) reader.nextString());
                }
            } else if (name.equals("hargaPerjam")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((HistoryParkirRealmProxyInterface) obj).realmSet$hargaPerjam(null);
                } else {
                    ((HistoryParkirRealmProxyInterface) obj).realmSet$hargaPerjam((int) reader.nextInt());
                }
            } else if (name.equals("waktuMasuk")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((HistoryParkirRealmProxyInterface) obj).realmSet$waktuMasuk(null);
                } else {
                    ((HistoryParkirRealmProxyInterface) obj).realmSet$waktuMasuk((String) reader.nextString());
                }
            } else if (name.equals("waktuKeluar")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((HistoryParkirRealmProxyInterface) obj).realmSet$waktuKeluar(null);
                } else {
                    ((HistoryParkirRealmProxyInterface) obj).realmSet$waktuKeluar((String) reader.nextString());
                }
            } else if (name.equals("status")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((HistoryParkirRealmProxyInterface) obj).realmSet$status(null);
                } else {
                    ((HistoryParkirRealmProxyInterface) obj).realmSet$status((String) reader.nextString());
                }
            } else if (name.equals("totalHarga")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((HistoryParkirRealmProxyInterface) obj).realmSet$totalHarga(null);
                } else {
                    ((HistoryParkirRealmProxyInterface) obj).realmSet$totalHarga((int) reader.nextInt());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.sumroch.spotme.models.db.HistoryParkir copyOrUpdate(Realm realm, com.sumroch.spotme.models.db.HistoryParkir object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.sumroch.spotme.models.db.HistoryParkir) cachedRealmObject;
        } else {
            return copy(realm, object, update, cache);
        }
    }

    public static com.sumroch.spotme.models.db.HistoryParkir copy(Realm realm, com.sumroch.spotme.models.db.HistoryParkir newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.sumroch.spotme.models.db.HistoryParkir) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.sumroch.spotme.models.db.HistoryParkir realmObject = realm.createObjectInternal(com.sumroch.spotme.models.db.HistoryParkir.class, false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((HistoryParkirRealmProxyInterface) realmObject).realmSet$idParkir(((HistoryParkirRealmProxyInterface) newObject).realmGet$idParkir());
            ((HistoryParkirRealmProxyInterface) realmObject).realmSet$namaMall(((HistoryParkirRealmProxyInterface) newObject).realmGet$namaMall());
            ((HistoryParkirRealmProxyInterface) realmObject).realmSet$nameUser(((HistoryParkirRealmProxyInterface) newObject).realmGet$nameUser());
            ((HistoryParkirRealmProxyInterface) realmObject).realmSet$platNomor(((HistoryParkirRealmProxyInterface) newObject).realmGet$platNomor());
            ((HistoryParkirRealmProxyInterface) realmObject).realmSet$jenisKendaraan(((HistoryParkirRealmProxyInterface) newObject).realmGet$jenisKendaraan());
            ((HistoryParkirRealmProxyInterface) realmObject).realmSet$nomorLantai(((HistoryParkirRealmProxyInterface) newObject).realmGet$nomorLantai());
            ((HistoryParkirRealmProxyInterface) realmObject).realmSet$nomorBlok(((HistoryParkirRealmProxyInterface) newObject).realmGet$nomorBlok());
            ((HistoryParkirRealmProxyInterface) realmObject).realmSet$hargaPerjam(((HistoryParkirRealmProxyInterface) newObject).realmGet$hargaPerjam());
            ((HistoryParkirRealmProxyInterface) realmObject).realmSet$waktuMasuk(((HistoryParkirRealmProxyInterface) newObject).realmGet$waktuMasuk());
            ((HistoryParkirRealmProxyInterface) realmObject).realmSet$waktuKeluar(((HistoryParkirRealmProxyInterface) newObject).realmGet$waktuKeluar());
            ((HistoryParkirRealmProxyInterface) realmObject).realmSet$status(((HistoryParkirRealmProxyInterface) newObject).realmGet$status());
            ((HistoryParkirRealmProxyInterface) realmObject).realmSet$totalHarga(((HistoryParkirRealmProxyInterface) newObject).realmGet$totalHarga());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.sumroch.spotme.models.db.HistoryParkir object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.sumroch.spotme.models.db.HistoryParkir.class);
        long tableNativePtr = table.getNativePtr();
        HistoryParkirColumnInfo columnInfo = (HistoryParkirColumnInfo) realm.schema.getColumnInfo(com.sumroch.spotme.models.db.HistoryParkir.class);
        long rowIndex = OsObject.createRow(realm.sharedRealm, table);
        cache.put(object, rowIndex);
        String realmGet$idParkir = ((HistoryParkirRealmProxyInterface)object).realmGet$idParkir();
        if (realmGet$idParkir != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.idParkirIndex, rowIndex, realmGet$idParkir, false);
        }
        String realmGet$namaMall = ((HistoryParkirRealmProxyInterface)object).realmGet$namaMall();
        if (realmGet$namaMall != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.namaMallIndex, rowIndex, realmGet$namaMall, false);
        }
        String realmGet$nameUser = ((HistoryParkirRealmProxyInterface)object).realmGet$nameUser();
        if (realmGet$nameUser != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameUserIndex, rowIndex, realmGet$nameUser, false);
        }
        String realmGet$platNomor = ((HistoryParkirRealmProxyInterface)object).realmGet$platNomor();
        if (realmGet$platNomor != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.platNomorIndex, rowIndex, realmGet$platNomor, false);
        }
        String realmGet$jenisKendaraan = ((HistoryParkirRealmProxyInterface)object).realmGet$jenisKendaraan();
        if (realmGet$jenisKendaraan != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.jenisKendaraanIndex, rowIndex, realmGet$jenisKendaraan, false);
        }
        String realmGet$nomorLantai = ((HistoryParkirRealmProxyInterface)object).realmGet$nomorLantai();
        if (realmGet$nomorLantai != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nomorLantaiIndex, rowIndex, realmGet$nomorLantai, false);
        }
        String realmGet$nomorBlok = ((HistoryParkirRealmProxyInterface)object).realmGet$nomorBlok();
        if (realmGet$nomorBlok != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nomorBlokIndex, rowIndex, realmGet$nomorBlok, false);
        }
        Number realmGet$hargaPerjam = ((HistoryParkirRealmProxyInterface)object).realmGet$hargaPerjam();
        if (realmGet$hargaPerjam != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.hargaPerjamIndex, rowIndex, realmGet$hargaPerjam.longValue(), false);
        }
        String realmGet$waktuMasuk = ((HistoryParkirRealmProxyInterface)object).realmGet$waktuMasuk();
        if (realmGet$waktuMasuk != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.waktuMasukIndex, rowIndex, realmGet$waktuMasuk, false);
        }
        String realmGet$waktuKeluar = ((HistoryParkirRealmProxyInterface)object).realmGet$waktuKeluar();
        if (realmGet$waktuKeluar != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.waktuKeluarIndex, rowIndex, realmGet$waktuKeluar, false);
        }
        String realmGet$status = ((HistoryParkirRealmProxyInterface)object).realmGet$status();
        if (realmGet$status != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.statusIndex, rowIndex, realmGet$status, false);
        }
        Number realmGet$totalHarga = ((HistoryParkirRealmProxyInterface)object).realmGet$totalHarga();
        if (realmGet$totalHarga != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.totalHargaIndex, rowIndex, realmGet$totalHarga.longValue(), false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.sumroch.spotme.models.db.HistoryParkir.class);
        long tableNativePtr = table.getNativePtr();
        HistoryParkirColumnInfo columnInfo = (HistoryParkirColumnInfo) realm.schema.getColumnInfo(com.sumroch.spotme.models.db.HistoryParkir.class);
        com.sumroch.spotme.models.db.HistoryParkir object = null;
        while (objects.hasNext()) {
            object = (com.sumroch.spotme.models.db.HistoryParkir) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = OsObject.createRow(realm.sharedRealm, table);
                cache.put(object, rowIndex);
                String realmGet$idParkir = ((HistoryParkirRealmProxyInterface)object).realmGet$idParkir();
                if (realmGet$idParkir != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.idParkirIndex, rowIndex, realmGet$idParkir, false);
                }
                String realmGet$namaMall = ((HistoryParkirRealmProxyInterface)object).realmGet$namaMall();
                if (realmGet$namaMall != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.namaMallIndex, rowIndex, realmGet$namaMall, false);
                }
                String realmGet$nameUser = ((HistoryParkirRealmProxyInterface)object).realmGet$nameUser();
                if (realmGet$nameUser != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameUserIndex, rowIndex, realmGet$nameUser, false);
                }
                String realmGet$platNomor = ((HistoryParkirRealmProxyInterface)object).realmGet$platNomor();
                if (realmGet$platNomor != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.platNomorIndex, rowIndex, realmGet$platNomor, false);
                }
                String realmGet$jenisKendaraan = ((HistoryParkirRealmProxyInterface)object).realmGet$jenisKendaraan();
                if (realmGet$jenisKendaraan != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.jenisKendaraanIndex, rowIndex, realmGet$jenisKendaraan, false);
                }
                String realmGet$nomorLantai = ((HistoryParkirRealmProxyInterface)object).realmGet$nomorLantai();
                if (realmGet$nomorLantai != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nomorLantaiIndex, rowIndex, realmGet$nomorLantai, false);
                }
                String realmGet$nomorBlok = ((HistoryParkirRealmProxyInterface)object).realmGet$nomorBlok();
                if (realmGet$nomorBlok != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nomorBlokIndex, rowIndex, realmGet$nomorBlok, false);
                }
                Number realmGet$hargaPerjam = ((HistoryParkirRealmProxyInterface)object).realmGet$hargaPerjam();
                if (realmGet$hargaPerjam != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.hargaPerjamIndex, rowIndex, realmGet$hargaPerjam.longValue(), false);
                }
                String realmGet$waktuMasuk = ((HistoryParkirRealmProxyInterface)object).realmGet$waktuMasuk();
                if (realmGet$waktuMasuk != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.waktuMasukIndex, rowIndex, realmGet$waktuMasuk, false);
                }
                String realmGet$waktuKeluar = ((HistoryParkirRealmProxyInterface)object).realmGet$waktuKeluar();
                if (realmGet$waktuKeluar != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.waktuKeluarIndex, rowIndex, realmGet$waktuKeluar, false);
                }
                String realmGet$status = ((HistoryParkirRealmProxyInterface)object).realmGet$status();
                if (realmGet$status != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.statusIndex, rowIndex, realmGet$status, false);
                }
                Number realmGet$totalHarga = ((HistoryParkirRealmProxyInterface)object).realmGet$totalHarga();
                if (realmGet$totalHarga != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.totalHargaIndex, rowIndex, realmGet$totalHarga.longValue(), false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.sumroch.spotme.models.db.HistoryParkir object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.sumroch.spotme.models.db.HistoryParkir.class);
        long tableNativePtr = table.getNativePtr();
        HistoryParkirColumnInfo columnInfo = (HistoryParkirColumnInfo) realm.schema.getColumnInfo(com.sumroch.spotme.models.db.HistoryParkir.class);
        long rowIndex = OsObject.createRow(realm.sharedRealm, table);
        cache.put(object, rowIndex);
        String realmGet$idParkir = ((HistoryParkirRealmProxyInterface)object).realmGet$idParkir();
        if (realmGet$idParkir != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.idParkirIndex, rowIndex, realmGet$idParkir, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.idParkirIndex, rowIndex, false);
        }
        String realmGet$namaMall = ((HistoryParkirRealmProxyInterface)object).realmGet$namaMall();
        if (realmGet$namaMall != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.namaMallIndex, rowIndex, realmGet$namaMall, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.namaMallIndex, rowIndex, false);
        }
        String realmGet$nameUser = ((HistoryParkirRealmProxyInterface)object).realmGet$nameUser();
        if (realmGet$nameUser != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameUserIndex, rowIndex, realmGet$nameUser, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameUserIndex, rowIndex, false);
        }
        String realmGet$platNomor = ((HistoryParkirRealmProxyInterface)object).realmGet$platNomor();
        if (realmGet$platNomor != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.platNomorIndex, rowIndex, realmGet$platNomor, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.platNomorIndex, rowIndex, false);
        }
        String realmGet$jenisKendaraan = ((HistoryParkirRealmProxyInterface)object).realmGet$jenisKendaraan();
        if (realmGet$jenisKendaraan != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.jenisKendaraanIndex, rowIndex, realmGet$jenisKendaraan, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.jenisKendaraanIndex, rowIndex, false);
        }
        String realmGet$nomorLantai = ((HistoryParkirRealmProxyInterface)object).realmGet$nomorLantai();
        if (realmGet$nomorLantai != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nomorLantaiIndex, rowIndex, realmGet$nomorLantai, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nomorLantaiIndex, rowIndex, false);
        }
        String realmGet$nomorBlok = ((HistoryParkirRealmProxyInterface)object).realmGet$nomorBlok();
        if (realmGet$nomorBlok != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nomorBlokIndex, rowIndex, realmGet$nomorBlok, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nomorBlokIndex, rowIndex, false);
        }
        Number realmGet$hargaPerjam = ((HistoryParkirRealmProxyInterface)object).realmGet$hargaPerjam();
        if (realmGet$hargaPerjam != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.hargaPerjamIndex, rowIndex, realmGet$hargaPerjam.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.hargaPerjamIndex, rowIndex, false);
        }
        String realmGet$waktuMasuk = ((HistoryParkirRealmProxyInterface)object).realmGet$waktuMasuk();
        if (realmGet$waktuMasuk != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.waktuMasukIndex, rowIndex, realmGet$waktuMasuk, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.waktuMasukIndex, rowIndex, false);
        }
        String realmGet$waktuKeluar = ((HistoryParkirRealmProxyInterface)object).realmGet$waktuKeluar();
        if (realmGet$waktuKeluar != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.waktuKeluarIndex, rowIndex, realmGet$waktuKeluar, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.waktuKeluarIndex, rowIndex, false);
        }
        String realmGet$status = ((HistoryParkirRealmProxyInterface)object).realmGet$status();
        if (realmGet$status != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.statusIndex, rowIndex, realmGet$status, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.statusIndex, rowIndex, false);
        }
        Number realmGet$totalHarga = ((HistoryParkirRealmProxyInterface)object).realmGet$totalHarga();
        if (realmGet$totalHarga != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.totalHargaIndex, rowIndex, realmGet$totalHarga.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.totalHargaIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.sumroch.spotme.models.db.HistoryParkir.class);
        long tableNativePtr = table.getNativePtr();
        HistoryParkirColumnInfo columnInfo = (HistoryParkirColumnInfo) realm.schema.getColumnInfo(com.sumroch.spotme.models.db.HistoryParkir.class);
        com.sumroch.spotme.models.db.HistoryParkir object = null;
        while (objects.hasNext()) {
            object = (com.sumroch.spotme.models.db.HistoryParkir) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = OsObject.createRow(realm.sharedRealm, table);
                cache.put(object, rowIndex);
                String realmGet$idParkir = ((HistoryParkirRealmProxyInterface)object).realmGet$idParkir();
                if (realmGet$idParkir != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.idParkirIndex, rowIndex, realmGet$idParkir, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.idParkirIndex, rowIndex, false);
                }
                String realmGet$namaMall = ((HistoryParkirRealmProxyInterface)object).realmGet$namaMall();
                if (realmGet$namaMall != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.namaMallIndex, rowIndex, realmGet$namaMall, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.namaMallIndex, rowIndex, false);
                }
                String realmGet$nameUser = ((HistoryParkirRealmProxyInterface)object).realmGet$nameUser();
                if (realmGet$nameUser != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameUserIndex, rowIndex, realmGet$nameUser, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.nameUserIndex, rowIndex, false);
                }
                String realmGet$platNomor = ((HistoryParkirRealmProxyInterface)object).realmGet$platNomor();
                if (realmGet$platNomor != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.platNomorIndex, rowIndex, realmGet$platNomor, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.platNomorIndex, rowIndex, false);
                }
                String realmGet$jenisKendaraan = ((HistoryParkirRealmProxyInterface)object).realmGet$jenisKendaraan();
                if (realmGet$jenisKendaraan != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.jenisKendaraanIndex, rowIndex, realmGet$jenisKendaraan, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.jenisKendaraanIndex, rowIndex, false);
                }
                String realmGet$nomorLantai = ((HistoryParkirRealmProxyInterface)object).realmGet$nomorLantai();
                if (realmGet$nomorLantai != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nomorLantaiIndex, rowIndex, realmGet$nomorLantai, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.nomorLantaiIndex, rowIndex, false);
                }
                String realmGet$nomorBlok = ((HistoryParkirRealmProxyInterface)object).realmGet$nomorBlok();
                if (realmGet$nomorBlok != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nomorBlokIndex, rowIndex, realmGet$nomorBlok, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.nomorBlokIndex, rowIndex, false);
                }
                Number realmGet$hargaPerjam = ((HistoryParkirRealmProxyInterface)object).realmGet$hargaPerjam();
                if (realmGet$hargaPerjam != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.hargaPerjamIndex, rowIndex, realmGet$hargaPerjam.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.hargaPerjamIndex, rowIndex, false);
                }
                String realmGet$waktuMasuk = ((HistoryParkirRealmProxyInterface)object).realmGet$waktuMasuk();
                if (realmGet$waktuMasuk != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.waktuMasukIndex, rowIndex, realmGet$waktuMasuk, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.waktuMasukIndex, rowIndex, false);
                }
                String realmGet$waktuKeluar = ((HistoryParkirRealmProxyInterface)object).realmGet$waktuKeluar();
                if (realmGet$waktuKeluar != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.waktuKeluarIndex, rowIndex, realmGet$waktuKeluar, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.waktuKeluarIndex, rowIndex, false);
                }
                String realmGet$status = ((HistoryParkirRealmProxyInterface)object).realmGet$status();
                if (realmGet$status != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.statusIndex, rowIndex, realmGet$status, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.statusIndex, rowIndex, false);
                }
                Number realmGet$totalHarga = ((HistoryParkirRealmProxyInterface)object).realmGet$totalHarga();
                if (realmGet$totalHarga != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.totalHargaIndex, rowIndex, realmGet$totalHarga.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.totalHargaIndex, rowIndex, false);
                }
            }
        }
    }

    public static com.sumroch.spotme.models.db.HistoryParkir createDetachedCopy(com.sumroch.spotme.models.db.HistoryParkir realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.sumroch.spotme.models.db.HistoryParkir unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.sumroch.spotme.models.db.HistoryParkir)cachedObject.object;
            } else {
                unmanagedObject = (com.sumroch.spotme.models.db.HistoryParkir)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.sumroch.spotme.models.db.HistoryParkir();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((HistoryParkirRealmProxyInterface) unmanagedObject).realmSet$idParkir(((HistoryParkirRealmProxyInterface) realmObject).realmGet$idParkir());
        ((HistoryParkirRealmProxyInterface) unmanagedObject).realmSet$namaMall(((HistoryParkirRealmProxyInterface) realmObject).realmGet$namaMall());
        ((HistoryParkirRealmProxyInterface) unmanagedObject).realmSet$nameUser(((HistoryParkirRealmProxyInterface) realmObject).realmGet$nameUser());
        ((HistoryParkirRealmProxyInterface) unmanagedObject).realmSet$platNomor(((HistoryParkirRealmProxyInterface) realmObject).realmGet$platNomor());
        ((HistoryParkirRealmProxyInterface) unmanagedObject).realmSet$jenisKendaraan(((HistoryParkirRealmProxyInterface) realmObject).realmGet$jenisKendaraan());
        ((HistoryParkirRealmProxyInterface) unmanagedObject).realmSet$nomorLantai(((HistoryParkirRealmProxyInterface) realmObject).realmGet$nomorLantai());
        ((HistoryParkirRealmProxyInterface) unmanagedObject).realmSet$nomorBlok(((HistoryParkirRealmProxyInterface) realmObject).realmGet$nomorBlok());
        ((HistoryParkirRealmProxyInterface) unmanagedObject).realmSet$hargaPerjam(((HistoryParkirRealmProxyInterface) realmObject).realmGet$hargaPerjam());
        ((HistoryParkirRealmProxyInterface) unmanagedObject).realmSet$waktuMasuk(((HistoryParkirRealmProxyInterface) realmObject).realmGet$waktuMasuk());
        ((HistoryParkirRealmProxyInterface) unmanagedObject).realmSet$waktuKeluar(((HistoryParkirRealmProxyInterface) realmObject).realmGet$waktuKeluar());
        ((HistoryParkirRealmProxyInterface) unmanagedObject).realmSet$status(((HistoryParkirRealmProxyInterface) realmObject).realmGet$status());
        ((HistoryParkirRealmProxyInterface) unmanagedObject).realmSet$totalHarga(((HistoryParkirRealmProxyInterface) realmObject).realmGet$totalHarga());
        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("HistoryParkir = proxy[");
        stringBuilder.append("{idParkir:");
        stringBuilder.append(realmGet$idParkir() != null ? realmGet$idParkir() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{namaMall:");
        stringBuilder.append(realmGet$namaMall() != null ? realmGet$namaMall() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{nameUser:");
        stringBuilder.append(realmGet$nameUser() != null ? realmGet$nameUser() : "null");
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
        stringBuilder.append("{nomorLantai:");
        stringBuilder.append(realmGet$nomorLantai() != null ? realmGet$nomorLantai() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{nomorBlok:");
        stringBuilder.append(realmGet$nomorBlok() != null ? realmGet$nomorBlok() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{hargaPerjam:");
        stringBuilder.append(realmGet$hargaPerjam() != null ? realmGet$hargaPerjam() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{waktuMasuk:");
        stringBuilder.append(realmGet$waktuMasuk() != null ? realmGet$waktuMasuk() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{waktuKeluar:");
        stringBuilder.append(realmGet$waktuKeluar() != null ? realmGet$waktuKeluar() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{status:");
        stringBuilder.append(realmGet$status() != null ? realmGet$status() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{totalHarga:");
        stringBuilder.append(realmGet$totalHarga() != null ? realmGet$totalHarga() : "null");
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
        HistoryParkirRealmProxy aHistoryParkir = (HistoryParkirRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aHistoryParkir.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aHistoryParkir.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aHistoryParkir.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
