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

public class BeaconDealsRealmProxy extends com.sumroch.spotme.models.BeaconDeals
    implements RealmObjectProxy, BeaconDealsRealmProxyInterface {

    static final class BeaconDealsColumnInfo extends ColumnInfo {
        long idIndex;
        long beaconSubscriptionIndex;
        long dealsIndex;
        long detectedTimeIndex;
        long readIndex;

        BeaconDealsColumnInfo(SharedRealm realm, Table table) {
            super(5);
            this.idIndex = addColumnDetails(table, "id", RealmFieldType.STRING);
            this.beaconSubscriptionIndex = addColumnDetails(table, "beaconSubscription", RealmFieldType.OBJECT);
            this.dealsIndex = addColumnDetails(table, "deals", RealmFieldType.OBJECT);
            this.detectedTimeIndex = addColumnDetails(table, "detectedTime", RealmFieldType.INTEGER);
            this.readIndex = addColumnDetails(table, "read", RealmFieldType.BOOLEAN);
        }

        BeaconDealsColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new BeaconDealsColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final BeaconDealsColumnInfo src = (BeaconDealsColumnInfo) rawSrc;
            final BeaconDealsColumnInfo dst = (BeaconDealsColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.beaconSubscriptionIndex = src.beaconSubscriptionIndex;
            dst.dealsIndex = src.dealsIndex;
            dst.detectedTimeIndex = src.detectedTimeIndex;
            dst.readIndex = src.readIndex;
        }
    }

    private BeaconDealsColumnInfo columnInfo;
    private ProxyState<com.sumroch.spotme.models.BeaconDeals> proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("beaconSubscription");
        fieldNames.add("deals");
        fieldNames.add("detectedTime");
        fieldNames.add("read");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    BeaconDealsRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (BeaconDealsColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.sumroch.spotme.models.BeaconDeals>(this);
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
    public com.sumroch.spotme.models.BeaconSubscription realmGet$beaconSubscription() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.beaconSubscriptionIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.sumroch.spotme.models.BeaconSubscription.class, proxyState.getRow$realm().getLink(columnInfo.beaconSubscriptionIndex), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$beaconSubscription(com.sumroch.spotme.models.BeaconSubscription value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("beaconSubscription")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = ((Realm) proxyState.getRealm$realm()).copyToRealm(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.beaconSubscriptionIndex);
                return;
            }
            if (!RealmObject.isValid(value)) {
                throw new IllegalArgumentException("'value' is not a valid managed object.");
            }
            if (((RealmObjectProxy) value).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
                throw new IllegalArgumentException("'value' belongs to a different Realm.");
            }
            row.getTable().setLink(columnInfo.beaconSubscriptionIndex, row.getIndex(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.beaconSubscriptionIndex);
            return;
        }
        if (!(RealmObject.isManaged(value) && RealmObject.isValid(value))) {
            throw new IllegalArgumentException("'value' is not a valid managed object.");
        }
        if (((RealmObjectProxy)value).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
            throw new IllegalArgumentException("'value' belongs to a different Realm.");
        }
        proxyState.getRow$realm().setLink(columnInfo.beaconSubscriptionIndex, ((RealmObjectProxy)value).realmGet$proxyState().getRow$realm().getIndex());
    }

    @Override
    public com.sumroch.spotme.models.Deals realmGet$deals() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.dealsIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.sumroch.spotme.models.Deals.class, proxyState.getRow$realm().getLink(columnInfo.dealsIndex), false, Collections.<String>emptyList());
    }

    @Override
    public void realmSet$deals(com.sumroch.spotme.models.Deals value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("deals")) {
                return;
            }
            if (value != null && !RealmObject.isManaged(value)) {
                value = ((Realm) proxyState.getRealm$realm()).copyToRealm(value);
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                // Table#nullifyLink() does not support default value. Just using Row.
                row.nullifyLink(columnInfo.dealsIndex);
                return;
            }
            if (!RealmObject.isValid(value)) {
                throw new IllegalArgumentException("'value' is not a valid managed object.");
            }
            if (((RealmObjectProxy) value).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
                throw new IllegalArgumentException("'value' belongs to a different Realm.");
            }
            row.getTable().setLink(columnInfo.dealsIndex, row.getIndex(), ((RealmObjectProxy) value).realmGet$proxyState().getRow$realm().getIndex(), true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.dealsIndex);
            return;
        }
        if (!(RealmObject.isManaged(value) && RealmObject.isValid(value))) {
            throw new IllegalArgumentException("'value' is not a valid managed object.");
        }
        if (((RealmObjectProxy)value).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
            throw new IllegalArgumentException("'value' belongs to a different Realm.");
        }
        proxyState.getRow$realm().setLink(columnInfo.dealsIndex, ((RealmObjectProxy)value).realmGet$proxyState().getRow$realm().getIndex());
    }

    @Override
    @SuppressWarnings("cast")
    public long realmGet$detectedTime() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.detectedTimeIndex);
    }

    @Override
    public void realmSet$detectedTime(long value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.detectedTimeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.detectedTimeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$read() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.readIndex);
    }

    @Override
    public void realmSet$read(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.readIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.readIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("BeaconDeals")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("BeaconDeals");
            realmObjectSchema.add("id", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
            if (!realmSchema.contains("BeaconSubscription")) {
                BeaconSubscriptionRealmProxy.createRealmObjectSchema(realmSchema);
            }
            realmObjectSchema.add("beaconSubscription", RealmFieldType.OBJECT, realmSchema.get("BeaconSubscription"));
            if (!realmSchema.contains("Deals")) {
                DealsRealmProxy.createRealmObjectSchema(realmSchema);
            }
            realmObjectSchema.add("deals", RealmFieldType.OBJECT, realmSchema.get("Deals"));
            realmObjectSchema.add("detectedTime", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("read", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            return realmObjectSchema;
        }
        return realmSchema.get("BeaconDeals");
    }

    public static BeaconDealsColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (!sharedRealm.hasTable("class_BeaconDeals")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'BeaconDeals' class is missing from the schema for this Realm.");
        }
        Table table = sharedRealm.getTable("class_BeaconDeals");
        final long columnCount = table.getColumnCount();
        if (columnCount != 5) {
            if (columnCount < 5) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 5 but was " + columnCount);
            }
            if (allowExtraColumns) {
                RealmLog.debug("Field count is more than expected - expected 5 but was %1$d", columnCount);
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 5 but was " + columnCount);
            }
        }
        Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
        for (long i = 0; i < columnCount; i++) {
            columnTypes.put(table.getColumnName(i), table.getColumnType(i));
        }

        final BeaconDealsColumnInfo columnInfo = new BeaconDealsColumnInfo(sharedRealm, table);

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
        if (!columnTypes.containsKey("beaconSubscription")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'beaconSubscription' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("beaconSubscription") != RealmFieldType.OBJECT) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'BeaconSubscription' for field 'beaconSubscription'");
        }
        if (!sharedRealm.hasTable("class_BeaconSubscription")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing class 'class_BeaconSubscription' for field 'beaconSubscription'");
        }
        Table table_1 = sharedRealm.getTable("class_BeaconSubscription");
        if (!table.getLinkTarget(columnInfo.beaconSubscriptionIndex).hasSameSchema(table_1)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid RealmObject for field 'beaconSubscription': '" + table.getLinkTarget(columnInfo.beaconSubscriptionIndex).getName() + "' expected - was '" + table_1.getName() + "'");
        }
        if (!columnTypes.containsKey("deals")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'deals' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("deals") != RealmFieldType.OBJECT) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Deals' for field 'deals'");
        }
        if (!sharedRealm.hasTable("class_Deals")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing class 'class_Deals' for field 'deals'");
        }
        Table table_2 = sharedRealm.getTable("class_Deals");
        if (!table.getLinkTarget(columnInfo.dealsIndex).hasSameSchema(table_2)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid RealmObject for field 'deals': '" + table.getLinkTarget(columnInfo.dealsIndex).getName() + "' expected - was '" + table_2.getName() + "'");
        }
        if (!columnTypes.containsKey("detectedTime")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'detectedTime' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("detectedTime") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'long' for field 'detectedTime' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.detectedTimeIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'detectedTime' does support null values in the existing Realm file. Use corresponding boxed type for field 'detectedTime' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("read")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'read' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("read") != RealmFieldType.BOOLEAN) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'boolean' for field 'read' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.readIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'read' does support null values in the existing Realm file. Use corresponding boxed type for field 'read' or migrate using RealmObjectSchema.setNullable().");
        }

        return columnInfo;
    }

    public static String getTableName() {
        return "class_BeaconDeals";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.sumroch.spotme.models.BeaconDeals createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(2);
        com.sumroch.spotme.models.BeaconDeals obj = null;
        if (update) {
            Table table = realm.getTable(com.sumroch.spotme.models.BeaconDeals.class);
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.sumroch.spotme.models.BeaconDeals.class), false, Collections.<String> emptyList());
                    obj = new io.realm.BeaconDealsRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("beaconSubscription")) {
                excludeFields.add("beaconSubscription");
            }
            if (json.has("deals")) {
                excludeFields.add("deals");
            }
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.BeaconDealsRealmProxy) realm.createObjectInternal(com.sumroch.spotme.models.BeaconDeals.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.BeaconDealsRealmProxy) realm.createObjectInternal(com.sumroch.spotme.models.BeaconDeals.class, json.getString("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }
        if (json.has("beaconSubscription")) {
            if (json.isNull("beaconSubscription")) {
                ((BeaconDealsRealmProxyInterface) obj).realmSet$beaconSubscription(null);
            } else {
                com.sumroch.spotme.models.BeaconSubscription beaconSubscriptionObj = BeaconSubscriptionRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("beaconSubscription"), update);
                ((BeaconDealsRealmProxyInterface) obj).realmSet$beaconSubscription(beaconSubscriptionObj);
            }
        }
        if (json.has("deals")) {
            if (json.isNull("deals")) {
                ((BeaconDealsRealmProxyInterface) obj).realmSet$deals(null);
            } else {
                com.sumroch.spotme.models.Deals dealsObj = DealsRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("deals"), update);
                ((BeaconDealsRealmProxyInterface) obj).realmSet$deals(dealsObj);
            }
        }
        if (json.has("detectedTime")) {
            if (json.isNull("detectedTime")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'detectedTime' to null.");
            } else {
                ((BeaconDealsRealmProxyInterface) obj).realmSet$detectedTime((long) json.getLong("detectedTime"));
            }
        }
        if (json.has("read")) {
            if (json.isNull("read")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'read' to null.");
            } else {
                ((BeaconDealsRealmProxyInterface) obj).realmSet$read((boolean) json.getBoolean("read"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.sumroch.spotme.models.BeaconDeals createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.sumroch.spotme.models.BeaconDeals obj = new com.sumroch.spotme.models.BeaconDeals();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((BeaconDealsRealmProxyInterface) obj).realmSet$id(null);
                } else {
                    ((BeaconDealsRealmProxyInterface) obj).realmSet$id((String) reader.nextString());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("beaconSubscription")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((BeaconDealsRealmProxyInterface) obj).realmSet$beaconSubscription(null);
                } else {
                    com.sumroch.spotme.models.BeaconSubscription beaconSubscriptionObj = BeaconSubscriptionRealmProxy.createUsingJsonStream(realm, reader);
                    ((BeaconDealsRealmProxyInterface) obj).realmSet$beaconSubscription(beaconSubscriptionObj);
                }
            } else if (name.equals("deals")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((BeaconDealsRealmProxyInterface) obj).realmSet$deals(null);
                } else {
                    com.sumroch.spotme.models.Deals dealsObj = DealsRealmProxy.createUsingJsonStream(realm, reader);
                    ((BeaconDealsRealmProxyInterface) obj).realmSet$deals(dealsObj);
                }
            } else if (name.equals("detectedTime")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'detectedTime' to null.");
                } else {
                    ((BeaconDealsRealmProxyInterface) obj).realmSet$detectedTime((long) reader.nextLong());
                }
            } else if (name.equals("read")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'read' to null.");
                } else {
                    ((BeaconDealsRealmProxyInterface) obj).realmSet$read((boolean) reader.nextBoolean());
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

    public static com.sumroch.spotme.models.BeaconDeals copyOrUpdate(Realm realm, com.sumroch.spotme.models.BeaconDeals object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.sumroch.spotme.models.BeaconDeals) cachedRealmObject;
        } else {
            com.sumroch.spotme.models.BeaconDeals realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.sumroch.spotme.models.BeaconDeals.class);
                long pkColumnIndex = table.getPrimaryKey();
                String value = ((BeaconDealsRealmProxyInterface) object).realmGet$id();
                long rowIndex = Table.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstString(pkColumnIndex, value);
                }
                if (rowIndex != Table.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.sumroch.spotme.models.BeaconDeals.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.BeaconDealsRealmProxy();
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

    public static com.sumroch.spotme.models.BeaconDeals copy(Realm realm, com.sumroch.spotme.models.BeaconDeals newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.sumroch.spotme.models.BeaconDeals) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.sumroch.spotme.models.BeaconDeals realmObject = realm.createObjectInternal(com.sumroch.spotme.models.BeaconDeals.class, ((BeaconDealsRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);

            com.sumroch.spotme.models.BeaconSubscription beaconSubscriptionObj = ((BeaconDealsRealmProxyInterface) newObject).realmGet$beaconSubscription();
            if (beaconSubscriptionObj != null) {
                com.sumroch.spotme.models.BeaconSubscription cachebeaconSubscription = (com.sumroch.spotme.models.BeaconSubscription) cache.get(beaconSubscriptionObj);
                if (cachebeaconSubscription != null) {
                    ((BeaconDealsRealmProxyInterface) realmObject).realmSet$beaconSubscription(cachebeaconSubscription);
                } else {
                    ((BeaconDealsRealmProxyInterface) realmObject).realmSet$beaconSubscription(BeaconSubscriptionRealmProxy.copyOrUpdate(realm, beaconSubscriptionObj, update, cache));
                }
            } else {
                ((BeaconDealsRealmProxyInterface) realmObject).realmSet$beaconSubscription(null);
            }

            com.sumroch.spotme.models.Deals dealsObj = ((BeaconDealsRealmProxyInterface) newObject).realmGet$deals();
            if (dealsObj != null) {
                com.sumroch.spotme.models.Deals cachedeals = (com.sumroch.spotme.models.Deals) cache.get(dealsObj);
                if (cachedeals != null) {
                    ((BeaconDealsRealmProxyInterface) realmObject).realmSet$deals(cachedeals);
                } else {
                    ((BeaconDealsRealmProxyInterface) realmObject).realmSet$deals(DealsRealmProxy.copyOrUpdate(realm, dealsObj, update, cache));
                }
            } else {
                ((BeaconDealsRealmProxyInterface) realmObject).realmSet$deals(null);
            }
            ((BeaconDealsRealmProxyInterface) realmObject).realmSet$detectedTime(((BeaconDealsRealmProxyInterface) newObject).realmGet$detectedTime());
            ((BeaconDealsRealmProxyInterface) realmObject).realmSet$read(((BeaconDealsRealmProxyInterface) newObject).realmGet$read());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.sumroch.spotme.models.BeaconDeals object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.sumroch.spotme.models.BeaconDeals.class);
        long tableNativePtr = table.getNativePtr();
        BeaconDealsColumnInfo columnInfo = (BeaconDealsColumnInfo) realm.schema.getColumnInfo(com.sumroch.spotme.models.BeaconDeals.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((BeaconDealsRealmProxyInterface) object).realmGet$id();
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

        com.sumroch.spotme.models.BeaconSubscription beaconSubscriptionObj = ((BeaconDealsRealmProxyInterface) object).realmGet$beaconSubscription();
        if (beaconSubscriptionObj != null) {
            Long cachebeaconSubscription = cache.get(beaconSubscriptionObj);
            if (cachebeaconSubscription == null) {
                cachebeaconSubscription = BeaconSubscriptionRealmProxy.insert(realm, beaconSubscriptionObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.beaconSubscriptionIndex, rowIndex, cachebeaconSubscription, false);
        }

        com.sumroch.spotme.models.Deals dealsObj = ((BeaconDealsRealmProxyInterface) object).realmGet$deals();
        if (dealsObj != null) {
            Long cachedeals = cache.get(dealsObj);
            if (cachedeals == null) {
                cachedeals = DealsRealmProxy.insert(realm, dealsObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.dealsIndex, rowIndex, cachedeals, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.detectedTimeIndex, rowIndex, ((BeaconDealsRealmProxyInterface)object).realmGet$detectedTime(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.readIndex, rowIndex, ((BeaconDealsRealmProxyInterface)object).realmGet$read(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.sumroch.spotme.models.BeaconDeals.class);
        long tableNativePtr = table.getNativePtr();
        BeaconDealsColumnInfo columnInfo = (BeaconDealsColumnInfo) realm.schema.getColumnInfo(com.sumroch.spotme.models.BeaconDeals.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.sumroch.spotme.models.BeaconDeals object = null;
        while (objects.hasNext()) {
            object = (com.sumroch.spotme.models.BeaconDeals) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((BeaconDealsRealmProxyInterface) object).realmGet$id();
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

                com.sumroch.spotme.models.BeaconSubscription beaconSubscriptionObj = ((BeaconDealsRealmProxyInterface) object).realmGet$beaconSubscription();
                if (beaconSubscriptionObj != null) {
                    Long cachebeaconSubscription = cache.get(beaconSubscriptionObj);
                    if (cachebeaconSubscription == null) {
                        cachebeaconSubscription = BeaconSubscriptionRealmProxy.insert(realm, beaconSubscriptionObj, cache);
                    }
                    table.setLink(columnInfo.beaconSubscriptionIndex, rowIndex, cachebeaconSubscription, false);
                }

                com.sumroch.spotme.models.Deals dealsObj = ((BeaconDealsRealmProxyInterface) object).realmGet$deals();
                if (dealsObj != null) {
                    Long cachedeals = cache.get(dealsObj);
                    if (cachedeals == null) {
                        cachedeals = DealsRealmProxy.insert(realm, dealsObj, cache);
                    }
                    table.setLink(columnInfo.dealsIndex, rowIndex, cachedeals, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.detectedTimeIndex, rowIndex, ((BeaconDealsRealmProxyInterface)object).realmGet$detectedTime(), false);
                Table.nativeSetBoolean(tableNativePtr, columnInfo.readIndex, rowIndex, ((BeaconDealsRealmProxyInterface)object).realmGet$read(), false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.sumroch.spotme.models.BeaconDeals object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.sumroch.spotme.models.BeaconDeals.class);
        long tableNativePtr = table.getNativePtr();
        BeaconDealsColumnInfo columnInfo = (BeaconDealsColumnInfo) realm.schema.getColumnInfo(com.sumroch.spotme.models.BeaconDeals.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((BeaconDealsRealmProxyInterface) object).realmGet$id();
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

        com.sumroch.spotme.models.BeaconSubscription beaconSubscriptionObj = ((BeaconDealsRealmProxyInterface) object).realmGet$beaconSubscription();
        if (beaconSubscriptionObj != null) {
            Long cachebeaconSubscription = cache.get(beaconSubscriptionObj);
            if (cachebeaconSubscription == null) {
                cachebeaconSubscription = BeaconSubscriptionRealmProxy.insertOrUpdate(realm, beaconSubscriptionObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.beaconSubscriptionIndex, rowIndex, cachebeaconSubscription, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.beaconSubscriptionIndex, rowIndex);
        }

        com.sumroch.spotme.models.Deals dealsObj = ((BeaconDealsRealmProxyInterface) object).realmGet$deals();
        if (dealsObj != null) {
            Long cachedeals = cache.get(dealsObj);
            if (cachedeals == null) {
                cachedeals = DealsRealmProxy.insertOrUpdate(realm, dealsObj, cache);
            }
            Table.nativeSetLink(tableNativePtr, columnInfo.dealsIndex, rowIndex, cachedeals, false);
        } else {
            Table.nativeNullifyLink(tableNativePtr, columnInfo.dealsIndex, rowIndex);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.detectedTimeIndex, rowIndex, ((BeaconDealsRealmProxyInterface)object).realmGet$detectedTime(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.readIndex, rowIndex, ((BeaconDealsRealmProxyInterface)object).realmGet$read(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.sumroch.spotme.models.BeaconDeals.class);
        long tableNativePtr = table.getNativePtr();
        BeaconDealsColumnInfo columnInfo = (BeaconDealsColumnInfo) realm.schema.getColumnInfo(com.sumroch.spotme.models.BeaconDeals.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.sumroch.spotme.models.BeaconDeals object = null;
        while (objects.hasNext()) {
            object = (com.sumroch.spotme.models.BeaconDeals) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((BeaconDealsRealmProxyInterface) object).realmGet$id();
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

                com.sumroch.spotme.models.BeaconSubscription beaconSubscriptionObj = ((BeaconDealsRealmProxyInterface) object).realmGet$beaconSubscription();
                if (beaconSubscriptionObj != null) {
                    Long cachebeaconSubscription = cache.get(beaconSubscriptionObj);
                    if (cachebeaconSubscription == null) {
                        cachebeaconSubscription = BeaconSubscriptionRealmProxy.insertOrUpdate(realm, beaconSubscriptionObj, cache);
                    }
                    Table.nativeSetLink(tableNativePtr, columnInfo.beaconSubscriptionIndex, rowIndex, cachebeaconSubscription, false);
                } else {
                    Table.nativeNullifyLink(tableNativePtr, columnInfo.beaconSubscriptionIndex, rowIndex);
                }

                com.sumroch.spotme.models.Deals dealsObj = ((BeaconDealsRealmProxyInterface) object).realmGet$deals();
                if (dealsObj != null) {
                    Long cachedeals = cache.get(dealsObj);
                    if (cachedeals == null) {
                        cachedeals = DealsRealmProxy.insertOrUpdate(realm, dealsObj, cache);
                    }
                    Table.nativeSetLink(tableNativePtr, columnInfo.dealsIndex, rowIndex, cachedeals, false);
                } else {
                    Table.nativeNullifyLink(tableNativePtr, columnInfo.dealsIndex, rowIndex);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.detectedTimeIndex, rowIndex, ((BeaconDealsRealmProxyInterface)object).realmGet$detectedTime(), false);
                Table.nativeSetBoolean(tableNativePtr, columnInfo.readIndex, rowIndex, ((BeaconDealsRealmProxyInterface)object).realmGet$read(), false);
            }
        }
    }

    public static com.sumroch.spotme.models.BeaconDeals createDetachedCopy(com.sumroch.spotme.models.BeaconDeals realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.sumroch.spotme.models.BeaconDeals unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.sumroch.spotme.models.BeaconDeals)cachedObject.object;
            } else {
                unmanagedObject = (com.sumroch.spotme.models.BeaconDeals)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.sumroch.spotme.models.BeaconDeals();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((BeaconDealsRealmProxyInterface) unmanagedObject).realmSet$id(((BeaconDealsRealmProxyInterface) realmObject).realmGet$id());

        // Deep copy of beaconSubscription
        ((BeaconDealsRealmProxyInterface) unmanagedObject).realmSet$beaconSubscription(BeaconSubscriptionRealmProxy.createDetachedCopy(((BeaconDealsRealmProxyInterface) realmObject).realmGet$beaconSubscription(), currentDepth + 1, maxDepth, cache));

        // Deep copy of deals
        ((BeaconDealsRealmProxyInterface) unmanagedObject).realmSet$deals(DealsRealmProxy.createDetachedCopy(((BeaconDealsRealmProxyInterface) realmObject).realmGet$deals(), currentDepth + 1, maxDepth, cache));
        ((BeaconDealsRealmProxyInterface) unmanagedObject).realmSet$detectedTime(((BeaconDealsRealmProxyInterface) realmObject).realmGet$detectedTime());
        ((BeaconDealsRealmProxyInterface) unmanagedObject).realmSet$read(((BeaconDealsRealmProxyInterface) realmObject).realmGet$read());
        return unmanagedObject;
    }

    static com.sumroch.spotme.models.BeaconDeals update(Realm realm, com.sumroch.spotme.models.BeaconDeals realmObject, com.sumroch.spotme.models.BeaconDeals newObject, Map<RealmModel, RealmObjectProxy> cache) {
        com.sumroch.spotme.models.BeaconSubscription beaconSubscriptionObj = ((BeaconDealsRealmProxyInterface) newObject).realmGet$beaconSubscription();
        if (beaconSubscriptionObj != null) {
            com.sumroch.spotme.models.BeaconSubscription cachebeaconSubscription = (com.sumroch.spotme.models.BeaconSubscription) cache.get(beaconSubscriptionObj);
            if (cachebeaconSubscription != null) {
                ((BeaconDealsRealmProxyInterface) realmObject).realmSet$beaconSubscription(cachebeaconSubscription);
            } else {
                ((BeaconDealsRealmProxyInterface) realmObject).realmSet$beaconSubscription(BeaconSubscriptionRealmProxy.copyOrUpdate(realm, beaconSubscriptionObj, true, cache));
            }
        } else {
            ((BeaconDealsRealmProxyInterface) realmObject).realmSet$beaconSubscription(null);
        }
        com.sumroch.spotme.models.Deals dealsObj = ((BeaconDealsRealmProxyInterface) newObject).realmGet$deals();
        if (dealsObj != null) {
            com.sumroch.spotme.models.Deals cachedeals = (com.sumroch.spotme.models.Deals) cache.get(dealsObj);
            if (cachedeals != null) {
                ((BeaconDealsRealmProxyInterface) realmObject).realmSet$deals(cachedeals);
            } else {
                ((BeaconDealsRealmProxyInterface) realmObject).realmSet$deals(DealsRealmProxy.copyOrUpdate(realm, dealsObj, true, cache));
            }
        } else {
            ((BeaconDealsRealmProxyInterface) realmObject).realmSet$deals(null);
        }
        ((BeaconDealsRealmProxyInterface) realmObject).realmSet$detectedTime(((BeaconDealsRealmProxyInterface) newObject).realmGet$detectedTime());
        ((BeaconDealsRealmProxyInterface) realmObject).realmSet$read(((BeaconDealsRealmProxyInterface) newObject).realmGet$read());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("BeaconDeals = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{beaconSubscription:");
        stringBuilder.append(realmGet$beaconSubscription() != null ? "BeaconSubscription" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{deals:");
        stringBuilder.append(realmGet$deals() != null ? "Deals" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{detectedTime:");
        stringBuilder.append(realmGet$detectedTime());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{read:");
        stringBuilder.append(realmGet$read());
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
        BeaconDealsRealmProxy aBeaconDeals = (BeaconDealsRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aBeaconDeals.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aBeaconDeals.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aBeaconDeals.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
