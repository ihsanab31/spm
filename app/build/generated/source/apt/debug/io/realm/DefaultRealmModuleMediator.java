package io.realm;


import android.util.JsonReader;
import io.realm.RealmObjectSchema;
import io.realm.internal.ColumnInfo;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.RealmProxyMediator;
import io.realm.internal.Row;
import io.realm.internal.SharedRealm;
import io.realm.internal.Table;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@io.realm.annotations.RealmModule
class DefaultRealmModuleMediator extends RealmProxyMediator {

    private static final Set<Class<? extends RealmModel>> MODEL_CLASSES;
    static {
        Set<Class<? extends RealmModel>> modelClasses = new HashSet<Class<? extends RealmModel>>();
        modelClasses.add(com.sumroch.spotme.models.db.PromotionData.class);
        modelClasses.add(com.sumroch.spotme.models.BeaconSubscription.class);
        modelClasses.add(com.sumroch.spotme.models.db.Kendaraan.class);
        modelClasses.add(com.sumroch.spotme.models.db.Profile.class);
        modelClasses.add(com.sumroch.spotme.models.Deals.class);
        modelClasses.add(com.sumroch.spotme.models.db.HistoryParkir.class);
        modelClasses.add(com.sumroch.spotme.models.db.BeaconData.class);
        modelClasses.add(com.sumroch.spotme.models.db.Add_Kendaraan.class);
        modelClasses.add(com.sumroch.spotme.models.BeaconDeals.class);
        modelClasses.add(com.sumroch.spotme.models.db.BaseImageUrl.class);
        modelClasses.add(com.sumroch.spotme.models.db.Mall.class);
        modelClasses.add(com.sumroch.spotme.models.db.Promotion.class);
        MODEL_CLASSES = Collections.unmodifiableSet(modelClasses);
    }

    @Override
    public RealmObjectSchema createRealmObjectSchema(Class<? extends RealmModel> clazz, RealmSchema realmSchema) {
        checkClass(clazz);

        if (clazz.equals(com.sumroch.spotme.models.db.PromotionData.class)) {
            return io.realm.PromotionDataRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(com.sumroch.spotme.models.BeaconSubscription.class)) {
            return io.realm.BeaconSubscriptionRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(com.sumroch.spotme.models.db.Kendaraan.class)) {
            return io.realm.KendaraanRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(com.sumroch.spotme.models.db.Profile.class)) {
            return io.realm.ProfileRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(com.sumroch.spotme.models.Deals.class)) {
            return io.realm.DealsRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(com.sumroch.spotme.models.db.HistoryParkir.class)) {
            return io.realm.HistoryParkirRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(com.sumroch.spotme.models.db.BeaconData.class)) {
            return io.realm.BeaconDataRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(com.sumroch.spotme.models.db.Add_Kendaraan.class)) {
            return io.realm.Add_KendaraanRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(com.sumroch.spotme.models.BeaconDeals.class)) {
            return io.realm.BeaconDealsRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(com.sumroch.spotme.models.db.BaseImageUrl.class)) {
            return io.realm.BaseImageUrlRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(com.sumroch.spotme.models.db.Mall.class)) {
            return io.realm.MallRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(com.sumroch.spotme.models.db.Promotion.class)) {
            return io.realm.PromotionRealmProxy.createRealmObjectSchema(realmSchema);
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public ColumnInfo validateTable(Class<? extends RealmModel> clazz, SharedRealm sharedRealm, boolean allowExtraColumns) {
        checkClass(clazz);

        if (clazz.equals(com.sumroch.spotme.models.db.PromotionData.class)) {
            return io.realm.PromotionDataRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(com.sumroch.spotme.models.BeaconSubscription.class)) {
            return io.realm.BeaconSubscriptionRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(com.sumroch.spotme.models.db.Kendaraan.class)) {
            return io.realm.KendaraanRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(com.sumroch.spotme.models.db.Profile.class)) {
            return io.realm.ProfileRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(com.sumroch.spotme.models.Deals.class)) {
            return io.realm.DealsRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(com.sumroch.spotme.models.db.HistoryParkir.class)) {
            return io.realm.HistoryParkirRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(com.sumroch.spotme.models.db.BeaconData.class)) {
            return io.realm.BeaconDataRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(com.sumroch.spotme.models.db.Add_Kendaraan.class)) {
            return io.realm.Add_KendaraanRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(com.sumroch.spotme.models.BeaconDeals.class)) {
            return io.realm.BeaconDealsRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(com.sumroch.spotme.models.db.BaseImageUrl.class)) {
            return io.realm.BaseImageUrlRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(com.sumroch.spotme.models.db.Mall.class)) {
            return io.realm.MallRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(com.sumroch.spotme.models.db.Promotion.class)) {
            return io.realm.PromotionRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public List<String> getFieldNames(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(com.sumroch.spotme.models.db.PromotionData.class)) {
            return io.realm.PromotionDataRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.sumroch.spotme.models.BeaconSubscription.class)) {
            return io.realm.BeaconSubscriptionRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.sumroch.spotme.models.db.Kendaraan.class)) {
            return io.realm.KendaraanRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.sumroch.spotme.models.db.Profile.class)) {
            return io.realm.ProfileRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.sumroch.spotme.models.Deals.class)) {
            return io.realm.DealsRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.sumroch.spotme.models.db.HistoryParkir.class)) {
            return io.realm.HistoryParkirRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.sumroch.spotme.models.db.BeaconData.class)) {
            return io.realm.BeaconDataRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.sumroch.spotme.models.db.Add_Kendaraan.class)) {
            return io.realm.Add_KendaraanRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.sumroch.spotme.models.BeaconDeals.class)) {
            return io.realm.BeaconDealsRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.sumroch.spotme.models.db.BaseImageUrl.class)) {
            return io.realm.BaseImageUrlRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.sumroch.spotme.models.db.Mall.class)) {
            return io.realm.MallRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.sumroch.spotme.models.db.Promotion.class)) {
            return io.realm.PromotionRealmProxy.getFieldNames();
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public String getTableName(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(com.sumroch.spotme.models.db.PromotionData.class)) {
            return io.realm.PromotionDataRealmProxy.getTableName();
        }
        if (clazz.equals(com.sumroch.spotme.models.BeaconSubscription.class)) {
            return io.realm.BeaconSubscriptionRealmProxy.getTableName();
        }
        if (clazz.equals(com.sumroch.spotme.models.db.Kendaraan.class)) {
            return io.realm.KendaraanRealmProxy.getTableName();
        }
        if (clazz.equals(com.sumroch.spotme.models.db.Profile.class)) {
            return io.realm.ProfileRealmProxy.getTableName();
        }
        if (clazz.equals(com.sumroch.spotme.models.Deals.class)) {
            return io.realm.DealsRealmProxy.getTableName();
        }
        if (clazz.equals(com.sumroch.spotme.models.db.HistoryParkir.class)) {
            return io.realm.HistoryParkirRealmProxy.getTableName();
        }
        if (clazz.equals(com.sumroch.spotme.models.db.BeaconData.class)) {
            return io.realm.BeaconDataRealmProxy.getTableName();
        }
        if (clazz.equals(com.sumroch.spotme.models.db.Add_Kendaraan.class)) {
            return io.realm.Add_KendaraanRealmProxy.getTableName();
        }
        if (clazz.equals(com.sumroch.spotme.models.BeaconDeals.class)) {
            return io.realm.BeaconDealsRealmProxy.getTableName();
        }
        if (clazz.equals(com.sumroch.spotme.models.db.BaseImageUrl.class)) {
            return io.realm.BaseImageUrlRealmProxy.getTableName();
        }
        if (clazz.equals(com.sumroch.spotme.models.db.Mall.class)) {
            return io.realm.MallRealmProxy.getTableName();
        }
        if (clazz.equals(com.sumroch.spotme.models.db.Promotion.class)) {
            return io.realm.PromotionRealmProxy.getTableName();
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E newInstance(Class<E> clazz, Object baseRealm, Row row, ColumnInfo columnInfo, boolean acceptDefaultValue, List<String> excludeFields) {
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        try {
            objectContext.set((BaseRealm) baseRealm, row, columnInfo, acceptDefaultValue, excludeFields);
            checkClass(clazz);

            if (clazz.equals(com.sumroch.spotme.models.db.PromotionData.class)) {
                return clazz.cast(new io.realm.PromotionDataRealmProxy());
            }
            if (clazz.equals(com.sumroch.spotme.models.BeaconSubscription.class)) {
                return clazz.cast(new io.realm.BeaconSubscriptionRealmProxy());
            }
            if (clazz.equals(com.sumroch.spotme.models.db.Kendaraan.class)) {
                return clazz.cast(new io.realm.KendaraanRealmProxy());
            }
            if (clazz.equals(com.sumroch.spotme.models.db.Profile.class)) {
                return clazz.cast(new io.realm.ProfileRealmProxy());
            }
            if (clazz.equals(com.sumroch.spotme.models.Deals.class)) {
                return clazz.cast(new io.realm.DealsRealmProxy());
            }
            if (clazz.equals(com.sumroch.spotme.models.db.HistoryParkir.class)) {
                return clazz.cast(new io.realm.HistoryParkirRealmProxy());
            }
            if (clazz.equals(com.sumroch.spotme.models.db.BeaconData.class)) {
                return clazz.cast(new io.realm.BeaconDataRealmProxy());
            }
            if (clazz.equals(com.sumroch.spotme.models.db.Add_Kendaraan.class)) {
                return clazz.cast(new io.realm.Add_KendaraanRealmProxy());
            }
            if (clazz.equals(com.sumroch.spotme.models.BeaconDeals.class)) {
                return clazz.cast(new io.realm.BeaconDealsRealmProxy());
            }
            if (clazz.equals(com.sumroch.spotme.models.db.BaseImageUrl.class)) {
                return clazz.cast(new io.realm.BaseImageUrlRealmProxy());
            }
            if (clazz.equals(com.sumroch.spotme.models.db.Mall.class)) {
                return clazz.cast(new io.realm.MallRealmProxy());
            }
            if (clazz.equals(com.sumroch.spotme.models.db.Promotion.class)) {
                return clazz.cast(new io.realm.PromotionRealmProxy());
            }
            throw getMissingProxyClassException(clazz);
        } finally {
            objectContext.clear();
        }
    }

    @Override
    public Set<Class<? extends RealmModel>> getModelClasses() {
        return MODEL_CLASSES;
    }

    @Override
    public <E extends RealmModel> E copyOrUpdate(Realm realm, E obj, boolean update, Map<RealmModel, RealmObjectProxy> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(com.sumroch.spotme.models.db.PromotionData.class)) {
            return clazz.cast(io.realm.PromotionDataRealmProxy.copyOrUpdate(realm, (com.sumroch.spotme.models.db.PromotionData) obj, update, cache));
        }
        if (clazz.equals(com.sumroch.spotme.models.BeaconSubscription.class)) {
            return clazz.cast(io.realm.BeaconSubscriptionRealmProxy.copyOrUpdate(realm, (com.sumroch.spotme.models.BeaconSubscription) obj, update, cache));
        }
        if (clazz.equals(com.sumroch.spotme.models.db.Kendaraan.class)) {
            return clazz.cast(io.realm.KendaraanRealmProxy.copyOrUpdate(realm, (com.sumroch.spotme.models.db.Kendaraan) obj, update, cache));
        }
        if (clazz.equals(com.sumroch.spotme.models.db.Profile.class)) {
            return clazz.cast(io.realm.ProfileRealmProxy.copyOrUpdate(realm, (com.sumroch.spotme.models.db.Profile) obj, update, cache));
        }
        if (clazz.equals(com.sumroch.spotme.models.Deals.class)) {
            return clazz.cast(io.realm.DealsRealmProxy.copyOrUpdate(realm, (com.sumroch.spotme.models.Deals) obj, update, cache));
        }
        if (clazz.equals(com.sumroch.spotme.models.db.HistoryParkir.class)) {
            return clazz.cast(io.realm.HistoryParkirRealmProxy.copyOrUpdate(realm, (com.sumroch.spotme.models.db.HistoryParkir) obj, update, cache));
        }
        if (clazz.equals(com.sumroch.spotme.models.db.BeaconData.class)) {
            return clazz.cast(io.realm.BeaconDataRealmProxy.copyOrUpdate(realm, (com.sumroch.spotme.models.db.BeaconData) obj, update, cache));
        }
        if (clazz.equals(com.sumroch.spotme.models.db.Add_Kendaraan.class)) {
            return clazz.cast(io.realm.Add_KendaraanRealmProxy.copyOrUpdate(realm, (com.sumroch.spotme.models.db.Add_Kendaraan) obj, update, cache));
        }
        if (clazz.equals(com.sumroch.spotme.models.BeaconDeals.class)) {
            return clazz.cast(io.realm.BeaconDealsRealmProxy.copyOrUpdate(realm, (com.sumroch.spotme.models.BeaconDeals) obj, update, cache));
        }
        if (clazz.equals(com.sumroch.spotme.models.db.BaseImageUrl.class)) {
            return clazz.cast(io.realm.BaseImageUrlRealmProxy.copyOrUpdate(realm, (com.sumroch.spotme.models.db.BaseImageUrl) obj, update, cache));
        }
        if (clazz.equals(com.sumroch.spotme.models.db.Mall.class)) {
            return clazz.cast(io.realm.MallRealmProxy.copyOrUpdate(realm, (com.sumroch.spotme.models.db.Mall) obj, update, cache));
        }
        if (clazz.equals(com.sumroch.spotme.models.db.Promotion.class)) {
            return clazz.cast(io.realm.PromotionRealmProxy.copyOrUpdate(realm, (com.sumroch.spotme.models.db.Promotion) obj, update, cache));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public void insert(Realm realm, RealmModel object, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

        if (clazz.equals(com.sumroch.spotme.models.db.PromotionData.class)) {
            io.realm.PromotionDataRealmProxy.insert(realm, (com.sumroch.spotme.models.db.PromotionData) object, cache);
        } else if (clazz.equals(com.sumroch.spotme.models.BeaconSubscription.class)) {
            io.realm.BeaconSubscriptionRealmProxy.insert(realm, (com.sumroch.spotme.models.BeaconSubscription) object, cache);
        } else if (clazz.equals(com.sumroch.spotme.models.db.Kendaraan.class)) {
            io.realm.KendaraanRealmProxy.insert(realm, (com.sumroch.spotme.models.db.Kendaraan) object, cache);
        } else if (clazz.equals(com.sumroch.spotme.models.db.Profile.class)) {
            io.realm.ProfileRealmProxy.insert(realm, (com.sumroch.spotme.models.db.Profile) object, cache);
        } else if (clazz.equals(com.sumroch.spotme.models.Deals.class)) {
            io.realm.DealsRealmProxy.insert(realm, (com.sumroch.spotme.models.Deals) object, cache);
        } else if (clazz.equals(com.sumroch.spotme.models.db.HistoryParkir.class)) {
            io.realm.HistoryParkirRealmProxy.insert(realm, (com.sumroch.spotme.models.db.HistoryParkir) object, cache);
        } else if (clazz.equals(com.sumroch.spotme.models.db.BeaconData.class)) {
            io.realm.BeaconDataRealmProxy.insert(realm, (com.sumroch.spotme.models.db.BeaconData) object, cache);
        } else if (clazz.equals(com.sumroch.spotme.models.db.Add_Kendaraan.class)) {
            io.realm.Add_KendaraanRealmProxy.insert(realm, (com.sumroch.spotme.models.db.Add_Kendaraan) object, cache);
        } else if (clazz.equals(com.sumroch.spotme.models.BeaconDeals.class)) {
            io.realm.BeaconDealsRealmProxy.insert(realm, (com.sumroch.spotme.models.BeaconDeals) object, cache);
        } else if (clazz.equals(com.sumroch.spotme.models.db.BaseImageUrl.class)) {
            io.realm.BaseImageUrlRealmProxy.insert(realm, (com.sumroch.spotme.models.db.BaseImageUrl) object, cache);
        } else if (clazz.equals(com.sumroch.spotme.models.db.Mall.class)) {
            io.realm.MallRealmProxy.insert(realm, (com.sumroch.spotme.models.db.Mall) object, cache);
        } else if (clazz.equals(com.sumroch.spotme.models.db.Promotion.class)) {
            io.realm.PromotionRealmProxy.insert(realm, (com.sumroch.spotme.models.db.Promotion) object, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insert(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(com.sumroch.spotme.models.db.PromotionData.class)) {
                io.realm.PromotionDataRealmProxy.insert(realm, (com.sumroch.spotme.models.db.PromotionData) object, cache);
            } else if (clazz.equals(com.sumroch.spotme.models.BeaconSubscription.class)) {
                io.realm.BeaconSubscriptionRealmProxy.insert(realm, (com.sumroch.spotme.models.BeaconSubscription) object, cache);
            } else if (clazz.equals(com.sumroch.spotme.models.db.Kendaraan.class)) {
                io.realm.KendaraanRealmProxy.insert(realm, (com.sumroch.spotme.models.db.Kendaraan) object, cache);
            } else if (clazz.equals(com.sumroch.spotme.models.db.Profile.class)) {
                io.realm.ProfileRealmProxy.insert(realm, (com.sumroch.spotme.models.db.Profile) object, cache);
            } else if (clazz.equals(com.sumroch.spotme.models.Deals.class)) {
                io.realm.DealsRealmProxy.insert(realm, (com.sumroch.spotme.models.Deals) object, cache);
            } else if (clazz.equals(com.sumroch.spotme.models.db.HistoryParkir.class)) {
                io.realm.HistoryParkirRealmProxy.insert(realm, (com.sumroch.spotme.models.db.HistoryParkir) object, cache);
            } else if (clazz.equals(com.sumroch.spotme.models.db.BeaconData.class)) {
                io.realm.BeaconDataRealmProxy.insert(realm, (com.sumroch.spotme.models.db.BeaconData) object, cache);
            } else if (clazz.equals(com.sumroch.spotme.models.db.Add_Kendaraan.class)) {
                io.realm.Add_KendaraanRealmProxy.insert(realm, (com.sumroch.spotme.models.db.Add_Kendaraan) object, cache);
            } else if (clazz.equals(com.sumroch.spotme.models.BeaconDeals.class)) {
                io.realm.BeaconDealsRealmProxy.insert(realm, (com.sumroch.spotme.models.BeaconDeals) object, cache);
            } else if (clazz.equals(com.sumroch.spotme.models.db.BaseImageUrl.class)) {
                io.realm.BaseImageUrlRealmProxy.insert(realm, (com.sumroch.spotme.models.db.BaseImageUrl) object, cache);
            } else if (clazz.equals(com.sumroch.spotme.models.db.Mall.class)) {
                io.realm.MallRealmProxy.insert(realm, (com.sumroch.spotme.models.db.Mall) object, cache);
            } else if (clazz.equals(com.sumroch.spotme.models.db.Promotion.class)) {
                io.realm.PromotionRealmProxy.insert(realm, (com.sumroch.spotme.models.db.Promotion) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(com.sumroch.spotme.models.db.PromotionData.class)) {
                    io.realm.PromotionDataRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.sumroch.spotme.models.BeaconSubscription.class)) {
                    io.realm.BeaconSubscriptionRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.sumroch.spotme.models.db.Kendaraan.class)) {
                    io.realm.KendaraanRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.sumroch.spotme.models.db.Profile.class)) {
                    io.realm.ProfileRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.sumroch.spotme.models.Deals.class)) {
                    io.realm.DealsRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.sumroch.spotme.models.db.HistoryParkir.class)) {
                    io.realm.HistoryParkirRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.sumroch.spotme.models.db.BeaconData.class)) {
                    io.realm.BeaconDataRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.sumroch.spotme.models.db.Add_Kendaraan.class)) {
                    io.realm.Add_KendaraanRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.sumroch.spotme.models.BeaconDeals.class)) {
                    io.realm.BeaconDealsRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.sumroch.spotme.models.db.BaseImageUrl.class)) {
                    io.realm.BaseImageUrlRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.sumroch.spotme.models.db.Mall.class)) {
                    io.realm.MallRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.sumroch.spotme.models.db.Promotion.class)) {
                    io.realm.PromotionRealmProxy.insert(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, RealmModel obj, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(com.sumroch.spotme.models.db.PromotionData.class)) {
            io.realm.PromotionDataRealmProxy.insertOrUpdate(realm, (com.sumroch.spotme.models.db.PromotionData) obj, cache);
        } else if (clazz.equals(com.sumroch.spotme.models.BeaconSubscription.class)) {
            io.realm.BeaconSubscriptionRealmProxy.insertOrUpdate(realm, (com.sumroch.spotme.models.BeaconSubscription) obj, cache);
        } else if (clazz.equals(com.sumroch.spotme.models.db.Kendaraan.class)) {
            io.realm.KendaraanRealmProxy.insertOrUpdate(realm, (com.sumroch.spotme.models.db.Kendaraan) obj, cache);
        } else if (clazz.equals(com.sumroch.spotme.models.db.Profile.class)) {
            io.realm.ProfileRealmProxy.insertOrUpdate(realm, (com.sumroch.spotme.models.db.Profile) obj, cache);
        } else if (clazz.equals(com.sumroch.spotme.models.Deals.class)) {
            io.realm.DealsRealmProxy.insertOrUpdate(realm, (com.sumroch.spotme.models.Deals) obj, cache);
        } else if (clazz.equals(com.sumroch.spotme.models.db.HistoryParkir.class)) {
            io.realm.HistoryParkirRealmProxy.insertOrUpdate(realm, (com.sumroch.spotme.models.db.HistoryParkir) obj, cache);
        } else if (clazz.equals(com.sumroch.spotme.models.db.BeaconData.class)) {
            io.realm.BeaconDataRealmProxy.insertOrUpdate(realm, (com.sumroch.spotme.models.db.BeaconData) obj, cache);
        } else if (clazz.equals(com.sumroch.spotme.models.db.Add_Kendaraan.class)) {
            io.realm.Add_KendaraanRealmProxy.insertOrUpdate(realm, (com.sumroch.spotme.models.db.Add_Kendaraan) obj, cache);
        } else if (clazz.equals(com.sumroch.spotme.models.BeaconDeals.class)) {
            io.realm.BeaconDealsRealmProxy.insertOrUpdate(realm, (com.sumroch.spotme.models.BeaconDeals) obj, cache);
        } else if (clazz.equals(com.sumroch.spotme.models.db.BaseImageUrl.class)) {
            io.realm.BaseImageUrlRealmProxy.insertOrUpdate(realm, (com.sumroch.spotme.models.db.BaseImageUrl) obj, cache);
        } else if (clazz.equals(com.sumroch.spotme.models.db.Mall.class)) {
            io.realm.MallRealmProxy.insertOrUpdate(realm, (com.sumroch.spotme.models.db.Mall) obj, cache);
        } else if (clazz.equals(com.sumroch.spotme.models.db.Promotion.class)) {
            io.realm.PromotionRealmProxy.insertOrUpdate(realm, (com.sumroch.spotme.models.db.Promotion) obj, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(com.sumroch.spotme.models.db.PromotionData.class)) {
                io.realm.PromotionDataRealmProxy.insertOrUpdate(realm, (com.sumroch.spotme.models.db.PromotionData) object, cache);
            } else if (clazz.equals(com.sumroch.spotme.models.BeaconSubscription.class)) {
                io.realm.BeaconSubscriptionRealmProxy.insertOrUpdate(realm, (com.sumroch.spotme.models.BeaconSubscription) object, cache);
            } else if (clazz.equals(com.sumroch.spotme.models.db.Kendaraan.class)) {
                io.realm.KendaraanRealmProxy.insertOrUpdate(realm, (com.sumroch.spotme.models.db.Kendaraan) object, cache);
            } else if (clazz.equals(com.sumroch.spotme.models.db.Profile.class)) {
                io.realm.ProfileRealmProxy.insertOrUpdate(realm, (com.sumroch.spotme.models.db.Profile) object, cache);
            } else if (clazz.equals(com.sumroch.spotme.models.Deals.class)) {
                io.realm.DealsRealmProxy.insertOrUpdate(realm, (com.sumroch.spotme.models.Deals) object, cache);
            } else if (clazz.equals(com.sumroch.spotme.models.db.HistoryParkir.class)) {
                io.realm.HistoryParkirRealmProxy.insertOrUpdate(realm, (com.sumroch.spotme.models.db.HistoryParkir) object, cache);
            } else if (clazz.equals(com.sumroch.spotme.models.db.BeaconData.class)) {
                io.realm.BeaconDataRealmProxy.insertOrUpdate(realm, (com.sumroch.spotme.models.db.BeaconData) object, cache);
            } else if (clazz.equals(com.sumroch.spotme.models.db.Add_Kendaraan.class)) {
                io.realm.Add_KendaraanRealmProxy.insertOrUpdate(realm, (com.sumroch.spotme.models.db.Add_Kendaraan) object, cache);
            } else if (clazz.equals(com.sumroch.spotme.models.BeaconDeals.class)) {
                io.realm.BeaconDealsRealmProxy.insertOrUpdate(realm, (com.sumroch.spotme.models.BeaconDeals) object, cache);
            } else if (clazz.equals(com.sumroch.spotme.models.db.BaseImageUrl.class)) {
                io.realm.BaseImageUrlRealmProxy.insertOrUpdate(realm, (com.sumroch.spotme.models.db.BaseImageUrl) object, cache);
            } else if (clazz.equals(com.sumroch.spotme.models.db.Mall.class)) {
                io.realm.MallRealmProxy.insertOrUpdate(realm, (com.sumroch.spotme.models.db.Mall) object, cache);
            } else if (clazz.equals(com.sumroch.spotme.models.db.Promotion.class)) {
                io.realm.PromotionRealmProxy.insertOrUpdate(realm, (com.sumroch.spotme.models.db.Promotion) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(com.sumroch.spotme.models.db.PromotionData.class)) {
                    io.realm.PromotionDataRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.sumroch.spotme.models.BeaconSubscription.class)) {
                    io.realm.BeaconSubscriptionRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.sumroch.spotme.models.db.Kendaraan.class)) {
                    io.realm.KendaraanRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.sumroch.spotme.models.db.Profile.class)) {
                    io.realm.ProfileRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.sumroch.spotme.models.Deals.class)) {
                    io.realm.DealsRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.sumroch.spotme.models.db.HistoryParkir.class)) {
                    io.realm.HistoryParkirRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.sumroch.spotme.models.db.BeaconData.class)) {
                    io.realm.BeaconDataRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.sumroch.spotme.models.db.Add_Kendaraan.class)) {
                    io.realm.Add_KendaraanRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.sumroch.spotme.models.BeaconDeals.class)) {
                    io.realm.BeaconDealsRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.sumroch.spotme.models.db.BaseImageUrl.class)) {
                    io.realm.BaseImageUrlRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.sumroch.spotme.models.db.Mall.class)) {
                    io.realm.MallRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.sumroch.spotme.models.db.Promotion.class)) {
                    io.realm.PromotionRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public <E extends RealmModel> E createOrUpdateUsingJsonObject(Class<E> clazz, Realm realm, JSONObject json, boolean update)
        throws JSONException {
        checkClass(clazz);

        if (clazz.equals(com.sumroch.spotme.models.db.PromotionData.class)) {
            return clazz.cast(io.realm.PromotionDataRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.sumroch.spotme.models.BeaconSubscription.class)) {
            return clazz.cast(io.realm.BeaconSubscriptionRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.sumroch.spotme.models.db.Kendaraan.class)) {
            return clazz.cast(io.realm.KendaraanRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.sumroch.spotme.models.db.Profile.class)) {
            return clazz.cast(io.realm.ProfileRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.sumroch.spotme.models.Deals.class)) {
            return clazz.cast(io.realm.DealsRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.sumroch.spotme.models.db.HistoryParkir.class)) {
            return clazz.cast(io.realm.HistoryParkirRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.sumroch.spotme.models.db.BeaconData.class)) {
            return clazz.cast(io.realm.BeaconDataRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.sumroch.spotme.models.db.Add_Kendaraan.class)) {
            return clazz.cast(io.realm.Add_KendaraanRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.sumroch.spotme.models.BeaconDeals.class)) {
            return clazz.cast(io.realm.BeaconDealsRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.sumroch.spotme.models.db.BaseImageUrl.class)) {
            return clazz.cast(io.realm.BaseImageUrlRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.sumroch.spotme.models.db.Mall.class)) {
            return clazz.cast(io.realm.MallRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.sumroch.spotme.models.db.Promotion.class)) {
            return clazz.cast(io.realm.PromotionRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createUsingJsonStream(Class<E> clazz, Realm realm, JsonReader reader)
        throws IOException {
        checkClass(clazz);

        if (clazz.equals(com.sumroch.spotme.models.db.PromotionData.class)) {
            return clazz.cast(io.realm.PromotionDataRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.sumroch.spotme.models.BeaconSubscription.class)) {
            return clazz.cast(io.realm.BeaconSubscriptionRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.sumroch.spotme.models.db.Kendaraan.class)) {
            return clazz.cast(io.realm.KendaraanRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.sumroch.spotme.models.db.Profile.class)) {
            return clazz.cast(io.realm.ProfileRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.sumroch.spotme.models.Deals.class)) {
            return clazz.cast(io.realm.DealsRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.sumroch.spotme.models.db.HistoryParkir.class)) {
            return clazz.cast(io.realm.HistoryParkirRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.sumroch.spotme.models.db.BeaconData.class)) {
            return clazz.cast(io.realm.BeaconDataRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.sumroch.spotme.models.db.Add_Kendaraan.class)) {
            return clazz.cast(io.realm.Add_KendaraanRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.sumroch.spotme.models.BeaconDeals.class)) {
            return clazz.cast(io.realm.BeaconDealsRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.sumroch.spotme.models.db.BaseImageUrl.class)) {
            return clazz.cast(io.realm.BaseImageUrlRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.sumroch.spotme.models.db.Mall.class)) {
            return clazz.cast(io.realm.MallRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.sumroch.spotme.models.db.Promotion.class)) {
            return clazz.cast(io.realm.PromotionRealmProxy.createUsingJsonStream(realm, reader));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createDetachedCopy(E realmObject, int maxDepth, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) realmObject.getClass().getSuperclass();

        if (clazz.equals(com.sumroch.spotme.models.db.PromotionData.class)) {
            return clazz.cast(io.realm.PromotionDataRealmProxy.createDetachedCopy((com.sumroch.spotme.models.db.PromotionData) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.sumroch.spotme.models.BeaconSubscription.class)) {
            return clazz.cast(io.realm.BeaconSubscriptionRealmProxy.createDetachedCopy((com.sumroch.spotme.models.BeaconSubscription) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.sumroch.spotme.models.db.Kendaraan.class)) {
            return clazz.cast(io.realm.KendaraanRealmProxy.createDetachedCopy((com.sumroch.spotme.models.db.Kendaraan) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.sumroch.spotme.models.db.Profile.class)) {
            return clazz.cast(io.realm.ProfileRealmProxy.createDetachedCopy((com.sumroch.spotme.models.db.Profile) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.sumroch.spotme.models.Deals.class)) {
            return clazz.cast(io.realm.DealsRealmProxy.createDetachedCopy((com.sumroch.spotme.models.Deals) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.sumroch.spotme.models.db.HistoryParkir.class)) {
            return clazz.cast(io.realm.HistoryParkirRealmProxy.createDetachedCopy((com.sumroch.spotme.models.db.HistoryParkir) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.sumroch.spotme.models.db.BeaconData.class)) {
            return clazz.cast(io.realm.BeaconDataRealmProxy.createDetachedCopy((com.sumroch.spotme.models.db.BeaconData) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.sumroch.spotme.models.db.Add_Kendaraan.class)) {
            return clazz.cast(io.realm.Add_KendaraanRealmProxy.createDetachedCopy((com.sumroch.spotme.models.db.Add_Kendaraan) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.sumroch.spotme.models.BeaconDeals.class)) {
            return clazz.cast(io.realm.BeaconDealsRealmProxy.createDetachedCopy((com.sumroch.spotme.models.BeaconDeals) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.sumroch.spotme.models.db.BaseImageUrl.class)) {
            return clazz.cast(io.realm.BaseImageUrlRealmProxy.createDetachedCopy((com.sumroch.spotme.models.db.BaseImageUrl) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.sumroch.spotme.models.db.Mall.class)) {
            return clazz.cast(io.realm.MallRealmProxy.createDetachedCopy((com.sumroch.spotme.models.db.Mall) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.sumroch.spotme.models.db.Promotion.class)) {
            return clazz.cast(io.realm.PromotionRealmProxy.createDetachedCopy((com.sumroch.spotme.models.db.Promotion) realmObject, 0, maxDepth, cache));
        }
        throw getMissingProxyClassException(clazz);
    }

}
