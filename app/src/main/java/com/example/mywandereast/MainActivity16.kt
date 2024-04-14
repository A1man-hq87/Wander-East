package com.example.mywandereast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.PopupMenu
import android.widget.Toast
import com.google.android.gms.common.api.Status
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.widget.AutocompleteSupportFragment
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener

class MainActivity16 : AppCompatActivity(), OnMapReadyCallback {

    //create a recall for google map and search also map type
    private var mGoogleMap : GoogleMap? = null
    private lateinit var autocompleteFragment: AutocompleteSupportFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main16)

        //set places search with google api
        //Places.initialize(applicationContext,"AIzaSyBGXVCu6OQP8oKuDb7k0SSDBoY-aWa8NYQ")
        Places.initialize(applicationContext,getString(R.string.google_map_Api_Key))
        autocompleteFragment = supportFragmentManager.findFragmentById(R.id.autocomplete_fragment)
                as AutocompleteSupportFragment
        autocompleteFragment.setPlaceFields(
            listOf(
                Place.Field.ID,
                Place.Field.ADDRESS,
                Place.Field.LAT_LNG
            )
        )
        //define for search functions
        autocompleteFragment.setOnPlaceSelectedListener(object : PlaceSelectionListener {
            override fun onError(p0: Status) {
                Toast.makeText(this@MainActivity16, "some error in search", Toast.LENGTH_LONG)
                    .show()
            }

            override fun onPlaceSelected(place: Place) {
                val add = place.address
                val id = place.id
                val latLng = place.latLng!!
                val marker = addMarker(latLng)
                marker.title = "$add"
                marker.snippet = "$id"
                zoomOnMap(latLng)
            }

        })

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.mapFragment) as SupportMapFragment
        mapFragment.getMapAsync(this)
        val mapOptionButton: ImageButton = findViewById(R.id.mapOptionsMenu)
        val popupMenu = PopupMenu(this, mapOptionButton)

        popupMenu.menuInflater.inflate(R.menu.map_options, popupMenu.menu)
        popupMenu.setOnMenuItemClickListener { menuItem ->
            changeMap(menuItem.itemId)
            true
        }

        mapOptionButton.setOnClickListener {
            popupMenu.show()
        }

    }

    private fun zoomOnMap(latLng: LatLng)
    {
        //12f = amount of zoom level
        val newLatLngZoom = CameraUpdateFactory.newLatLngZoom(latLng, 12f)
        mGoogleMap?.animateCamera(newLatLngZoom)
    }
    //references map type from google
    private fun changeMap(itemId: Int) {
        when(itemId)
        {
            R.id.normal_map -> mGoogleMap?.mapType = GoogleMap.MAP_TYPE_NORMAL
            R.id.hybrid_map_map -> mGoogleMap?.mapType = GoogleMap.MAP_TYPE_HYBRID
            R.id.satellite_map -> mGoogleMap?.mapType = GoogleMap.MAP_TYPE_SATELLITE
            R.id.terrain_map -> mGoogleMap?.mapType = GoogleMap.MAP_TYPE_TERRAIN
        }
    }
    override fun onMapReady(googleMap: GoogleMap) {
        mGoogleMap = googleMap


        // add marker
        addMarker(LatLng(13.123, 12.123))

        //add dragable marker
        addDraggableMarker(LatLng(12.456, 14.765))

        //add customize cutom marker
        addCustomMarker(R.drawable.flag_marker, LatLng(13.999, 12.456))

        mGoogleMap?.setOnMapClickListener {
            mGoogleMap?.clear()
            addMarker(it)
        }

        mGoogleMap?.setOnMapClickListener {
            addCustomMarker(R.drawable.flag_marker, it)
        }

        mGoogleMap?.setOnMarkerClickListener {marker->
            marker.remove()
            false
        }

    }

    private fun  addMarker(position:LatLng):Marker
    {

        //add simple marker
        val marker = mGoogleMap?.addMarker(MarkerOptions()
            .position(position)
            .title("Marker")
        )

        return marker!!
    }

    private fun addDraggableMarker(position:LatLng)
    {
        //add dragable marker
        mGoogleMap?.addMarker(MarkerOptions()
            .position(position)
            .title("Drag Marker")
            .draggable(true)
        )
    }

    private fun addCustomMarker(icon:Int, position:LatLng)
    {
        mGoogleMap?.addMarker(MarkerOptions()
            .position(position)
            .title("Custom marker")
            .icon(BitmapDescriptorFactory.fromResource(icon))
        )
    }

    }


