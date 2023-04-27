package dev.yingke.android.nationalparklocations

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import dev.yingke.android.nationalparklocations.`interface`.NPSApi
import dev.yingke.android.nationalparklocations.`interface`.NPSApiHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * An activity that displays a Google map with a marker (pin) to indicate a particular location.
 */
// [START maps_marker_on_map_ready]
class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    private var parkNameLocations = HashMap<String, Pair<Double, Double>>()

    // [START_EXCLUDE]
    // [START maps_marker_get_map_async]
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Retrieve the content view that renders the map.
        setContentView(R.layout.activity_maps)

        // Get the SupportMapFragment and request notification when the map is ready to be used.
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as? SupportMapFragment
        mapFragment?.getMapAsync(this)
    }
    // [END maps_marker_get_map_async]
    // [END_EXCLUDE]

    // [START maps_marker_on_map_ready_add_marker]
    override fun onMapReady(googleMap: GoogleMap) {
        val npsApi = NPSApiHelper.getInstance().create(NPSApi::class.java)

        // launching a new routine
        GlobalScope.launch {
            val parksList = npsApi.getNationalParks().body()?.data

            parksList!!.forEach { nationalPark ->
                if (nationalPark.latitude != "" && nationalPark.longitude != "" && nationalPark.designation == "National Park") {
                    parkNameLocations[nationalPark.name] = Pair(
                        nationalPark.latitude.toDouble(), nationalPark.longitude.toDouble()
                    )
                }
            }

            Log.i("derrick", parkNameLocations.toString())

            withContext(Dispatchers.Main) {
                parkNameLocations.forEach { (nationalParkName, locationPair) ->
                    googleMap.addMarker(
                        MarkerOptions()
                            .position(LatLng(locationPair.first,locationPair.second))
                            .title(nationalParkName)
                    )
                }
            }
        }

        // [START_EXCLUDE silent]
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(LatLng(47.6062, -122.3321)))
        // [END_EXCLUDE]
    }
    // [END maps_marker_on_map_ready_add_marker]
}
// [END maps_marker_on_map_ready]