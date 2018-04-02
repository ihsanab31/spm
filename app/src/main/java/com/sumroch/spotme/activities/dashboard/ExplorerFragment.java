package com.sumroch.spotme.activities.dashboard;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewAnimator;

import com.directions.route.Route;
import com.directions.route.RouteException;
import com.directions.route.Routing;
import com.directions.route.RoutingListener;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.ui.IconGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.sumroch.spotme.Constant;
import com.sumroch.spotme.R;
import com.sumroch.spotme.activities.bases.BaseFragment;
import com.sumroch.spotme.api.command.DataParkirCommand;
import com.sumroch.spotme.api.interfaces.Callback;
import com.sumroch.spotme.models.db.BaseImageUrl;
import com.sumroch.spotme.models.db.DataParkir;
import com.sumroch.spotme.models.db.Mall;
import com.sumroch.spotme.activities.parkir.MallParkirActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.OnClick;

import static android.graphics.Typeface.BOLD;
import static android.graphics.Typeface.ITALIC;
import static android.text.Spannable.SPAN_EXCLUSIVE_EXCLUSIVE;

/**
 * this class for showing explorer fragment
 *
 * @author Andrian.Lippox
 * @version 1.0.0
 * @since 9/4/17
 */

public class ExplorerFragment extends BaseFragment implements OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {
    public static final String TAG = "ExplorerFragment";
    private static final int LOCATION_PERMISSIONS_REQUEST = 12349;
    private static final long INTERVAL = 60000 * 10; //10minute
    private static final long FASTEST_INTERVAL = 60000 * 10; //10minute
    @BindView(R.id.mall_container)
    View mallContainer;
    @BindView(R.id.rv_mall)
    RecyclerView rvMall;
    @BindView(R.id.mall_animator)
    ViewAnimator mallAnimator;
    private LocationRequest mLocationRequest;
    private GoogleApiClient mGoogleApiClient;
    @Nullable
    private GoogleMap googleMap;
    private MallListAdapter mallListAdapter;
    private Location myLocation;
    private List<Polyline> polylines = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mallListAdapter = new MallListAdapter(new ArrayList<Mall>());
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_explorer;
    }

    @Override
    protected void onBindView() {
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        setupFusedLocation();

        rvMall.setAdapter(mallListAdapter);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rvMall.setLayoutManager(linearLayoutManager);
        rvMall.setHasFixedSize(true);
        rvMall.setNestedScrollingEnabled(false);

        rvMall.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                int index = ((LinearLayoutManager) rvMall.getLayoutManager()).findLastCompletelyVisibleItemPosition();
                if (index >= 0) {
                    Mall mall = mallListAdapter.getData().get(index);
                    googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(mall.getLatitude(), mall.getLongitude()), 15f));
                    getRoute(index);
                }
            }
        });

    }

    @OnClick(R.id.btn_close)
    public void onCloseMallContainer() {
        if (mallContainer.getTranslationY() == 0) {
            mallContainer.animate().translationY(mallAnimator.getHeight());
        } else {
            mallContainer.setVisibility(View.VISIBLE);
            mallContainer.animate().translationY(0);
        }
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        checkPermissionForLocation();
    }

    @Override
    public void onConnectionSuspended(int i) {
        Toast.makeText(getActivity(), "Map connection suspended", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Toast.makeText(getActivity(), connectionResult.getErrorMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;
    }

    @SuppressLint("MissingPermission")
    private void onLocationPermissionGranted() {
        if (googleMap != null) {
            //noinspection MissingPermission (this method will be call after location permission granted)
            googleMap.setMyLocationEnabled(true);
            //noinspection MissingPermission (this method will be call after location permission granted)
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == LOCATION_PERMISSIONS_REQUEST) {
            if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                onLocationPermissionGranted();
            } else {
                Toast.makeText(getActivity(), "Location permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    /**
     * for request permission location
     */
    private void checkPermissionForLocation() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if ((ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) && (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)) {
                requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_PERMISSIONS_REQUEST);
            } else {
                onLocationPermissionGranted();
            }
        } else {
            onLocationPermissionGranted();
        }
    }

    /**
     * for setup fused location
     */
    private void setupFusedLocation() {
        mLocationRequest = LocationRequest.create();
        mLocationRequest.setInterval(INTERVAL);
        mLocationRequest.setFastestInterval(FASTEST_INTERVAL);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        mGoogleApiClient = new GoogleApiClient.Builder(getActivity()).addApi(LocationServices.API)
                .addConnectionCallbacks(this).addOnConnectionFailedListener(this).build();
    }

    @Override
    public void onLocationChanged(Location location) {
        if (googleMap != null && location != null) {
            this.myLocation = location;
            LatLng myLocation = new LatLng(location.getLatitude(), location.getLongitude());
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(myLocation, 15f));
            if (mallListAdapter.getData() == null || mallListAdapter.getData().size() == 0)
                getMallData();
        }

    }

    @Override
    public void onStart() {
        super.onStart();
        mGoogleApiClient.connect();
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mGoogleApiClient.isConnected()) {
            mGoogleApiClient.disconnect();
        }
    }

    private void getMallData() {
        if (Mall.getMall() != null) {
            ((DashboardActivity) getActivity()).showProgressDialog("Load parkir data...");
            ((DashboardActivity) getActivity()).apiExecutor.execute(DataParkirCommand.class, null, new Callback<List<DataParkir>>() {
                @Override
                public void onSuccess(final List<DataParkir> data) {
                    ((DashboardActivity) getActivity()).dismissProgressDialog();
                    mallListAdapter.getData().addAll(Mall.getMall());
                    for (int i = 0; i < mallListAdapter.getData().size(); i++) {
                        Mall mall = mallListAdapter.getData().get(i);
                        for (int j = 0; j < data.size(); j++) {
                            DataParkir dataParkir = data.get(j);
                            if (mall.getId() == dataParkir.getIdMall()) {
                                mallListAdapter.getData().get(i).setAvailableSpace(dataParkir.getAvailable());
                                mallListAdapter.getData().get(i).setNonAvailableSpace(dataParkir.getNonAvailable());
                                mallListAdapter.getData().get(i).setTotalSpace(dataParkir.getJumlah());
                                break;
                            }
                        }
                        addIcon(i);
                    }
                    Mall.saveAll(mallListAdapter.getData());
                    mallListAdapter.notifyDataSetChanged();
                    mallAnimator.setDisplayedChild(1);
                }

                @Override
                public void onFailure(String message) {
                    ((DashboardActivity) getActivity()).dismissProgressDialog();
                    ((DashboardActivity) getActivity()).showMessage(message);
                }
            });
        }
    }


    private void addIcon(int index) {
        final Mall mall = mallListAdapter.getData().get(index);
        LatLng position = new LatLng(mall.getLatitude(), mall.getLongitude());
        final Location mallLocation = new Location("");
        mallLocation.setLatitude(mall.getLatitude());
        mallLocation.setLongitude(mall.getLongitude());
        double distance = myLocation.distanceTo(mallLocation);
        String distanceString = String.format(Locale.ENGLISH, "%.02f", distance / 1000);

        @SuppressLint("InflateParams") View contentView = LayoutInflater.from(getActivity()).inflate(R.layout.view_mall_marker, null, false);
        TextView tvDistance = (TextView) contentView.findViewById(R.id.tv_distance);
        TextView tvMerchantCount = (TextView) contentView.findViewById(R.id.tv_merchant_count);
        tvDistance.setText(String.format("%s Km", distanceString));
        IconGenerator iconFactory = new IconGenerator(getActivity());
        iconFactory.setRotation(0);
        iconFactory.setContentRotation(0);
        iconFactory.setStyle(IconGenerator.STYLE_DEFAULT);
        iconFactory.setBackground(null);
        iconFactory.setContentView(contentView);
        MarkerOptions markerOptions = new MarkerOptions().
                icon(BitmapDescriptorFactory.fromBitmap(iconFactory.makeIcon(""))).
                position(position).
                anchor(iconFactory.getAnchorU(), iconFactory.getAnchorV());

        if (googleMap != null) {
            googleMap.addMarker(markerOptions).setTag(index);
            googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                @Override
                public boolean onMarkerClick(Marker marker) {
                    RecyclerView.SmoothScroller smoothScroller = new
                            LinearSmoothScroller(getActivity()) {
                                @Override
                                protected int getVerticalSnapPreference() {
                                    return LinearSmoothScroller.SNAP_TO_START;
                                }
                            };
                    smoothScroller.setTargetPosition((Integer) marker.getTag());
                    rvMall.getLayoutManager().startSmoothScroll(smoothScroller
                    );
                    return true;
                }
            });
        }
    }

    private CharSequence makeCharSequence() {
        String prefix = "Mixing ";
        String suffix = "different fonts";
        String sequence = prefix + suffix;
        SpannableStringBuilder ssb = new SpannableStringBuilder(sequence);
        ssb.setSpan(new StyleSpan(ITALIC), 0, prefix.length(), SPAN_EXCLUSIVE_EXCLUSIVE);
        ssb.setSpan(new StyleSpan(BOLD), prefix.length(), sequence.length(), SPAN_EXCLUSIVE_EXCLUSIVE);
        return ssb;
    }

    public void getRoute(int index) {
        Mall mall = mallListAdapter.getData().get(index);
        if (mall.getRoutes().isEmpty()) {
            LatLng from = new LatLng(myLocation.getLatitude(), myLocation.getLongitude());
            LatLng to = new LatLng(mall.getLatitude(), mall.getLongitude());
            Routing routing = new Routing.Builder()
                    .key(getString(R.string.google_maps_key))
                    .travelMode(Routing.TravelMode.DRIVING)
                    .withListener(getRoutingListener(index))
                    .waypoints(from, to)
                    .build();
            routing.execute();
        } else {
            drawRoute(mall.getRoutes());
        }
    }

    private RoutingListener getRoutingListener(final int index) {
        final Mall mall = mallListAdapter.getData().get(index);
        return new RoutingListener() {

            @Override
            public void onRoutingFailure(RouteException e) {
//                ((BaseActivity) getActivity()).dismissProgressDialog();
            }

            @Override
            public void onRoutingStart() {
//                ((BaseActivity) getActivity()).showProgressDialog(String.format("Fetching route to %s...", mall.getName()));
            }

            @Override
            public void onRoutingSuccess(ArrayList<Route> routes, int shortestRouteIndex) {
//                ((BaseActivity) getActivity()).dismissProgressDialog();
//                LatLngBounds latLngBounds = new LatLngBounds(new LatLng(myLocation.getLatitude(), myLocation.getLongitude()), new LatLng(mall.getLocationLat(), mall.getLocationLng()));
//                googleMap.animateCamera(CameraUpdateFactory.newLatLngBounds(latLngBounds, 15));
                drawRoute(routes);
                mallListAdapter.getData().get(index).setRoutes(routes);
            }

            @Override
            public void onRoutingCancelled() {
//                ((BaseActivity) getActivity()).dismissProgressDialog();
            }
        };
    }

    private void drawRoute(ArrayList<Route> routes) {
        if (polylines.size() > 0) {
            for (Polyline poly : polylines) {
                poly.remove();
            }
        }

        polylines = new ArrayList<>();
        for (int i = 0; i < routes.size(); i++) {
            PolylineOptions polyOptions = new PolylineOptions();
            polyOptions.color(Color.BLUE);
            polyOptions.width(10 + i * 3);
            polyOptions.addAll(routes.get(i).getPoints());
            Polyline polyline = googleMap.addPolyline(polyOptions);
            polylines.add(polyline);
        }
    }

    private class MallListAdapter extends RecyclerView.Adapter<MallViewHolder> {
        private LayoutInflater inflater;
        private List<Mall> mallList;

        MallListAdapter(List<Mall> mallList) {
            inflater = LayoutInflater.from(getActivity());
            this.mallList = mallList;
        }

        @Override
        public MallViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.list_item_mall, parent, false);
            return new MallViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MallViewHolder holder, final int position) {
            final Mall mall = mallList.get(position);
            holder.tvMallName.setText(mall.getName());
            holder.tvParkingCount.setText(mall.getAvailableSpace());
            String imageUrl = BaseImageUrl.getData().getMall() + mall.getPicture();
            ImageLoader.getInstance().displayImage(imageUrl, holder.ivMallLogo);
            holder.llParkir.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(), MallParkirActivity.class);
                    intent.putExtra(Constant.SELECTED_MALL_INDEX, position);
                    intent.putExtra(Constant.ID, mall.getId());
                    startActivity(intent);
                }
            });
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public int getItemViewType(int position) {
            return position;
        }

        @Override
        public int getItemCount() {
            return mallList.size();
        }

        public List<Mall> getData() {
            if (mallList != null)
                return mallList;
            else
                return new ArrayList<>();
        }
    }   

    private class MallViewHolder extends RecyclerView.ViewHolder {
        TextView tvMallName, tvFollowerCount, tvParkingCount;
        ImageView ivMallLogo, ivMallCover;
        View btnFollow;
        LinearLayout llParkir;

        MallViewHolder(View itemView) {
            super(itemView);
            tvMallName = (TextView) itemView.findViewById(R.id.tv_mall_name);
            tvFollowerCount = (TextView) itemView.findViewById(R.id.tv_follower_count);
            tvParkingCount = (TextView) itemView.findViewById(R.id.tv_parking_count);
            ivMallLogo = (ImageView) itemView.findViewById(R.id.iv_mall_logo);
            ivMallCover = (ImageView) itemView.findViewById(R.id.iv_mall_cover);
            btnFollow = itemView.findViewById(R.id.btn_follow);
            llParkir = (LinearLayout) itemView.findViewById(R.id.ll_parking);
        }
    }
}
