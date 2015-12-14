package ua.cn.stu.cs.bukovelmap;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MapsActivity extends FragmentActivity {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    /*
    Этот алфавит будем использовать для определения следующей буквы
    в имени маркера. Когда буква использована - ставим true на месте буквы.
    Если все буквы использованы, то нужно обновить все значения на false и
    увеличить значение переменной alphabetNum на 1. Для этого используйте метод
    increaseAlphabetLevel(); .
     */
    private boolean[] alphabet = {
            false, false, false, false,
            false, false, false, false,
            false, false, false, false,
            false, false, false, false,
            false, false, false, false,
            false, false, false, false,
            false, false
    };
    private int alphabetNum = 1;

    private Marker fromMarker = null;

    private static final int CODE_A = 65;
    private static final double START_LATITUDE = 48.36238382902334;
    private static final double START_LONGITUDE = 24.404592029750347;
    private static final float START_ZOOM_LEVEL = 15;
    private static final float DEFAULT_MARKER_COLOR = BitmapDescriptorFactory.HUE_ORANGE;
    private static final float CLICKED_MARKER_COLOR = BitmapDescriptorFactory.HUE_GREEN;
    private static final String PATHFINDER_MODE_WALKING = "walking";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setUpMapIfNeeded();
        GoogleMap.OnMapClickListener mapClickListener = new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                setMarkerOnClick(latLng);
            }
        };
        GoogleMap.OnMarkerClickListener markerClickListener = new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                testMarkerPathFinder(marker);
                return false;
            }
        };
        mMap.setOnMapClickListener(mapClickListener);
        mMap.setOnMarkerClickListener(markerClickListener);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(START_LATITUDE, START_LONGITUDE)));
        mMap.moveCamera(CameraUpdateFactory.zoomTo(START_ZOOM_LEVEL));
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {
        //mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
    }

    private void setMarkerOnClick(LatLng latLng) {
        Marker marker
                = mMap.addMarker(new MarkerOptions().position(latLng).title(getMarkerName()));
        setMarkerColor(marker,DEFAULT_MARKER_COLOR);
    }

    private String getMarkerName() {
        String retVal = null;
        int cnt = -1;
        boolean curCharIsUsed;
        do {
            if (cnt >= alphabet.length) {
                increaseAlphabetLevel();
                cnt = 0;
                break;
            }
            cnt++;
            curCharIsUsed = alphabet[cnt];
        } while (curCharIsUsed);
        alphabet[cnt] = true;
        retVal = String.valueOf((char) (CODE_A + cnt)) + String.valueOf(alphabetNum);
        return retVal;
    }

    private void increaseAlphabetLevel() {
        for (int i = 0; i < alphabet.length; i++) {
            alphabet[i] = true;
        }
        alphabetNum++;
    }

    private void testMarkerPathFinder(Marker marker) {
        setMarkerColor(marker,CLICKED_MARKER_COLOR);
        if (fromMarker == null) {
            fromMarker = marker;
        } else {
            String from =fromMarker.getPosition().latitude + ","
                    + fromMarker.getPosition().longitude;
            String to = marker.getPosition().latitude + ","
                    + marker.getPosition().longitude;
            String directionsUrl = getMapsApiDirectionsUrl(from,to);
            getPathFinderTask().execute(directionsUrl);
            setMarkerColor(fromMarker,DEFAULT_MARKER_COLOR);
            setMarkerColor(marker,DEFAULT_MARKER_COLOR);
            fromMarker = null;
        }
    }

    private String getMapsApiDirectionsUrl(String from, String to) {
        String sensor = "sensor=false";
        String mode = PATHFINDER_MODE_WALKING;
        String params = "origin=" + from +"&destination=" + to + "&" + sensor + "&" + mode;
        String output = "json";
        String url = "https://maps.googleapis.com/maps/api/directions/"
                + output + "?" + params;
        return url;
    }

    private AsyncTask<String, Void, String> getPathFinderTask() {
        return new AsyncTask<String, Void, String>() {
            @Override
            protected String doInBackground(String... url) {
                String data = "";
                try {
                    HttpConnection http = new HttpConnection();
                    data = http.readUrl(url[0]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return data;
            }

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);
                getParserTask().execute(result);
            }
        };
    }

    private AsyncTask<String, Integer, List<List<HashMap<String, String>>>> getParserTask() {
        return new AsyncTask<String, Integer, List<List<HashMap<String, String>>>>() {

            @Override
            protected List<List<HashMap<String, String>>> doInBackground(
                    String... jsonData) {

                JSONObject jObject;
                List<List<HashMap<String, String>>> routes = null;

                try {
                    jObject = new JSONObject(jsonData[0]);
                    PathJSONParser parser = new PathJSONParser();
                    routes = parser.parse(jObject);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return routes;
            }

            @Override
            protected void onPostExecute(List<List<HashMap<String, String>>> routes) {
                ArrayList<LatLng> points = null;
                PolylineOptions polyLineOptions = null;

                // traversing through routes
                for (int i = 0; i < routes.size(); i++) {
                    points = new ArrayList<LatLng>();
                    polyLineOptions = new PolylineOptions();
                    List<HashMap<String, String>> path = routes.get(i);

                    for (int j = 0; j < path.size(); j++) {
                        HashMap<String, String> point = path.get(j);

                        double lat = Double.parseDouble(point.get("lat"));
                        double lng = Double.parseDouble(point.get("lng"));
                        LatLng position = new LatLng(lat, lng);

                        points.add(position);
                    }

                    polyLineOptions.addAll(points);
                    polyLineOptions.width(2);
                    polyLineOptions.color(Color.BLUE);
                }

                mMap.addPolyline(polyLineOptions);
            }
        };
    }

    private void setMarkerColor(Marker marker,float color){
        marker.setIcon(BitmapDescriptorFactory.defaultMarker(color));
    }

}
