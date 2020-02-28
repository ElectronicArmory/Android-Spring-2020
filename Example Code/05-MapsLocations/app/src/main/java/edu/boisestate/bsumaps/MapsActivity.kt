package edu.boisestate.bsumaps

import android.Manifest
import android.content.pm.PackageManager
import android.location.Criteria
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        val permissionCheck =
            ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)

        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            // Get location
            startReportingLocations()
        }
        else {
            requestPermissions()
        }
    }

    private fun requestPermissions(){
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 444)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if( grantResults[0] == PackageManager.PERMISSION_GRANTED){
            startReportingLocations()
        }
    }

    private fun startReportingLocations(){
        val locationManager:LocationManager = this.getSystemService(android.content.Context.LOCATION_SERVICE) as LocationManager

        // Retrieve a list of location providers that have fine accuracy, no monetary cost, etc
        val criteria = Criteria()
        criteria.accuracy = Criteria.ACCURACY_FINE
        criteria.isCostAllowed = false

        val providerName = locationManager.getBestProvider(criteria, true)

        if (providerName != null) {
            val permission = ContextCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)

            if (permission != PackageManager.PERMISSION_GRANTED) {
                Log.i("BSU", "Permission to denied")
                requestPermissions()
            }
            else {
                locationManager.requestLocationUpdates(providerName, 15000, 1000.0f, locationListener)
            }
        }
    }


    private var locationListener:LocationListener = object : LocationListener {
        override fun onLocationChanged(provider: Location?) {

            if(provider != null  ) {
                Log.d("BSU", "${provider.latitude}, ${provider.longitude}")
                val currentLocationLatLng = LatLng(provider.latitude, provider.longitude)
                mMap.addMarker(MarkerOptions().position(currentLocationLatLng).title("Current Location"))
                mMap.moveCamera(CameraUpdateFactory.newLatLng(currentLocationLatLng))
            }
        }

        override fun onStatusChanged(p0: String?, p1: Int, p2: Bundle?) {
            Log.d("BSU", "${p0}, ${p1}")
        }

        override fun onProviderEnabled(p0: String?) {

        }

        override fun onProviderDisabled(p0: String?) {

        }
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }
}
