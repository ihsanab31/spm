
package com.sumroch.spotme.models.db;

import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.parceler.Generated;
import org.parceler.IdentityCollection;
import org.parceler.InjectionUtil;
import org.parceler.ParcelWrapper;
import org.parceler.ParcelerRuntimeException;

@Generated("org.parceler.ParcelAnnotationProcessor")
@SuppressWarnings({
    "unchecked",
    "deprecation"
})
public class EventItem$$Parcelable
    implements Parcelable, ParcelWrapper<com.sumroch.spotme.models.db.EventItem>
{

    private com.sumroch.spotme.models.db.EventItem eventItem$$0;
    @SuppressWarnings("UnusedDeclaration")
    public final static Creator<EventItem$$Parcelable>CREATOR = new Creator<EventItem$$Parcelable>() {


        @Override
        public EventItem$$Parcelable createFromParcel(android.os.Parcel parcel$$2) {
            return new EventItem$$Parcelable(read(parcel$$2, new IdentityCollection()));
        }

        @Override
        public EventItem$$Parcelable[] newArray(int size) {
            return new EventItem$$Parcelable[size] ;
        }

    }
    ;

    public EventItem$$Parcelable(com.sumroch.spotme.models.db.EventItem eventItem$$2) {
        eventItem$$0 = eventItem$$2;
    }

    @Override
    public void writeToParcel(android.os.Parcel parcel$$0, int flags) {
        write(eventItem$$0, parcel$$0, flags, new IdentityCollection());
    }

    public static void write(com.sumroch.spotme.models.db.EventItem eventItem$$1, android.os.Parcel parcel$$1, int flags$$0, IdentityCollection identityMap$$0) {
        int identity$$0 = identityMap$$0 .getKey(eventItem$$1);
        if (identity$$0 != -1) {
            parcel$$1 .writeInt(identity$$0);
        } else {
            parcel$$1 .writeInt(identityMap$$0 .put(eventItem$$1));
            parcel$$1 .writeString(InjectionUtil.getField(java.lang.String.class, com.sumroch.spotme.models.db.EventItem.class, eventItem$$1, "createdAt"));
            parcel$$1 .writeString(InjectionUtil.getField(java.lang.String.class, com.sumroch.spotme.models.db.EventItem.class, eventItem$$1, "waktuEvent"));
            parcel$$1 .writeString(InjectionUtil.getField(java.lang.String.class, com.sumroch.spotme.models.db.EventItem.class, eventItem$$1, "namaEvent"));
            if (InjectionUtil.getField(java.lang.Integer.class, com.sumroch.spotme.models.db.EventItem.class, eventItem$$1, "id") == null) {
                parcel$$1 .writeInt(-1);
            } else {
                parcel$$1 .writeInt(1);
                parcel$$1 .writeInt(InjectionUtil.getField(java.lang.Integer.class, com.sumroch.spotme.models.db.EventItem.class, eventItem$$1, "id"));
            }
            parcel$$1 .writeString(InjectionUtil.getField(java.lang.String.class, com.sumroch.spotme.models.db.EventItem.class, eventItem$$1, "shortDescription"));
            parcel$$1 .writeString(InjectionUtil.getField(java.lang.String.class, com.sumroch.spotme.models.db.EventItem.class, eventItem$$1, "picture"));
            parcel$$1 .writeString(InjectionUtil.getField(java.lang.String.class, com.sumroch.spotme.models.db.EventItem.class, eventItem$$1, "status"));
            parcel$$1 .writeString(InjectionUtil.getField(java.lang.String.class, com.sumroch.spotme.models.db.EventItem.class, eventItem$$1, "updatedAt"));
        }
    }

    @Override
    public int describeContents() {
        return  0;
    }

    @Override
    public com.sumroch.spotme.models.db.EventItem getParcel() {
        return eventItem$$0;
    }

    public static com.sumroch.spotme.models.db.EventItem read(android.os.Parcel parcel$$3, IdentityCollection identityMap$$1) {
        int identity$$1 = parcel$$3 .readInt();
        if (identityMap$$1 .containsKey(identity$$1)) {
            if (identityMap$$1 .isReserved(identity$$1)) {
                throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
            }
            return identityMap$$1 .get(identity$$1);
        } else {
            com.sumroch.spotme.models.db.EventItem eventItem$$4;
            int reservation$$0 = identityMap$$1 .reserve();
            eventItem$$4 = new com.sumroch.spotme.models.db.EventItem();
            identityMap$$1 .put(reservation$$0, eventItem$$4);
            InjectionUtil.setField(com.sumroch.spotme.models.db.EventItem.class, eventItem$$4, "createdAt", parcel$$3 .readString());
            InjectionUtil.setField(com.sumroch.spotme.models.db.EventItem.class, eventItem$$4, "waktuEvent", parcel$$3 .readString());
            InjectionUtil.setField(com.sumroch.spotme.models.db.EventItem.class, eventItem$$4, "namaEvent", parcel$$3 .readString());
            int int$$0 = parcel$$3 .readInt();
            java.lang.Integer integer$$0;
            if (int$$0 < 0) {
                integer$$0 = null;
            } else {
                integer$$0 = parcel$$3 .readInt();
            }
            InjectionUtil.setField(com.sumroch.spotme.models.db.EventItem.class, eventItem$$4, "id", integer$$0);
            InjectionUtil.setField(com.sumroch.spotme.models.db.EventItem.class, eventItem$$4, "shortDescription", parcel$$3 .readString());
            InjectionUtil.setField(com.sumroch.spotme.models.db.EventItem.class, eventItem$$4, "picture", parcel$$3 .readString());
            InjectionUtil.setField(com.sumroch.spotme.models.db.EventItem.class, eventItem$$4, "status", parcel$$3 .readString());
            InjectionUtil.setField(com.sumroch.spotme.models.db.EventItem.class, eventItem$$4, "updatedAt", parcel$$3 .readString());
            com.sumroch.spotme.models.db.EventItem eventItem$$3 = eventItem$$4;
            identityMap$$1 .put(identity$$1, eventItem$$3);
            return eventItem$$3;
        }
    }

}
