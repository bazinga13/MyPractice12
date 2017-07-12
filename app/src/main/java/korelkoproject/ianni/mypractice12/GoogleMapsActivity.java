package korelkoproject.ianni.mypractice12;

import android.app.Activity;
import android.location.Location;
import android.os.Bundle;

import com.google.android.gms.location.LocationListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class GoogleMapsActivity extends Activity implements OnMapReadyCallback,LocationListener {

    private static final double LONGT = 39.074208;
    private static final double LAT   = 21.824312;

    Marker myLocationMarker;
    GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_maps);

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }



    @Override
    public void onMapReady(GoogleMap googleMap) {

        LatLng MY_STANDARD_LOCATION = new LatLng(LONGT,LAT);

        map = googleMap;

        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        map.getUiSettings().setZoomControlsEnabled(true);
        map.moveCamera(CameraUpdateFactory.zoomTo(12));

        myLocationMarker = map.addMarker(new MarkerOptions()
             .position(MY_STANDARD_LOCATION)
             .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE))
             .title("Greece")
             .snippet("Welcome to Greece"));
        myLocationMarker.showInfoWindow();
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(MY_STANDARD_LOCATION,4));


        //=============================================================================

        LatLng LOCATION_A = new LatLng(11.3321,2.3487);

        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        map.getUiSettings().setZoomControlsEnabled(true);
        map.moveCamera(CameraUpdateFactory.zoomTo(12));

        myLocationMarker = map.addMarker(new MarkerOptions()
                .position(LOCATION_A)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
                .title("A"));
        myLocationMarker.showInfoWindow();
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(MY_STANDARD_LOCATION,4));


        //=============================================================================

        LatLng LOCATION_B = new LatLng(12.3321,3.3487);

        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        map.getUiSettings().setZoomControlsEnabled(true);
        map.moveCamera(CameraUpdateFactory.zoomTo(12));

        myLocationMarker = map.addMarker(new MarkerOptions()
                .position(LOCATION_B)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
                .title("B"));

        myLocationMarker.showInfoWindow();
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(MY_STANDARD_LOCATION,4));


        //=============================================================================

        LatLng LOCATION_C = new LatLng(14.3321,1.3487);

        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        map.getUiSettings().setZoomControlsEnabled(true);
        map.moveCamera(CameraUpdateFactory.zoomTo(12));

        myLocationMarker = map.addMarker(new MarkerOptions()
                .position(LOCATION_C)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
                .title("C"));
        myLocationMarker.showInfoWindow();
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(MY_STANDARD_LOCATION,4));

    }


    @Override
    public void onLocationChanged(Location location) {

    }



    private double getDistance(LatLng latLng1, LatLng latLng2)
    {
        double distance;

        Location locationA = new Location("A");
        locationA.setLatitude(latLng1.latitude);
        locationA.setLongitude(latLng1.longitude);


        Location locationB = new Location("B");
        locationB.setLatitude(latLng2.latitude);
        locationB.setLongitude(latLng2.longitude);

        distance = locationA.distanceTo(locationB);

        return distance;
    }


}
