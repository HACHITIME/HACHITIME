package com.example.android.sample.testapp

import android.Manifest
import android.annotation.SuppressLint
import android.app.ActivityOptions
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.provider.Settings
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_bustime.*
import kotlinx.android.synthetic.main.map_hopup.*
import kotlinx.android.synthetic.main.toolbar.*
import kotlinx.android.synthetic.main.activity_main.*

class SchoolInfoWindowAdapter(private val context: Context) : GoogleMap.InfoWindowAdapter {
    override fun getInfoContents(marker: Marker): View? = null
    override fun getInfoWindow(marker: Marker): View? = setupWindow(marker)

    private fun setupWindow(marker: Marker): View =
        LayoutInflater.from(context).inflate(R.layout.map_hopup, null, false).apply {
            //val station = marker.tag as Station

            //findViewById<ImageView>(R.id.ImageViewArea).setImageResource(station.imageResId)
            findViewById<TextView>(R.id.Facility_Name).text = marker.title
            //findViewById<TextView>(R.id.textSnippet).text = marker.snippet
        }
}

class MapActivity : AppCompatActivity(),OnMapReadyCallback,LocationListener{


    private lateinit var mMap: GoogleMap

    private var locationManager: LocationManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                1000
            )
        } else {
            locationStart()
            locationManager!!.requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                1000, 50f, this
            )

        }

        setContentView(R.layout.activity_map)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        //------------------------------------------------------------------------------
        //setContentView(R.layout.campasinfo)
        //setContentView(R.layout.toolbar)
        tytle.text = "Map"

        school_btn.setOnClickListener {
            val intent = Intent(this, FacilityListActivity::class.java)
            startActivity(
                intent,
                ActivityOptions.makeSceneTransitionAnimation(this).toBundle()
            )
        }

        map_btn.setOnClickListener {
            val intent = Intent(this, MapActivity::class.java)
            startActivity(
                intent,
                ActivityOptions.makeSceneTransitionAnimation(this).toBundle()
            )
        }

        stamp_btn.setOnClickListener {
            val intent = Intent(this, StampActivity::class.java)
            startActivity(
                intent,
                ActivityOptions.makeSceneTransitionAnimation(this).toBundle()
            )
        }

        info_btn.setOnClickListener {
            val intent = Intent(this, InfoActivity::class.java)
            startActivity(
                intent,
                ActivityOptions.makeSceneTransitionAnimation(this).toBundle()
            )
        }

        bus_btn.setOnClickListener {
            val intent = Intent(this, BustimeActivity::class.java)
            startActivity(
                intent,
                ActivityOptions.makeSceneTransitionAnimation(this).toBundle()
            )
        }

        modol_btn.setOnClickListener {
            super.onBackPressed()
        }


    }


    private fun locationStart() {
        Log.d("debug", "locationStart()")

        // LocationManager インスタンス生成
        locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager

        if (locationManager != null && locationManager!!.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            Log.d("debug", "location manager Enabled")
        } else {
            // GPSを設定するように促す
            val settingsIntent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
            startActivity(settingsIntent)
            Log.d("debug", "not gpsEnable, startActivity")
        }
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                1000
            )
            Log.d("debug", "checkSelfPermission false")
            return
        }
        locationManager!!.requestLocationUpdates(
            LocationManager.GPS_PROVIDER,
            1000, 50f, this
        )
    }

    // 結果の受け取り
    /**
     * Android Quickstart:
     * https://developers.google.com/sheets/api/quickstart/android
     *
     * Respond to requests for permissions at runtime for API 23 and above.
     * @param requestCode The request code passed in
     * requestPermissions(android.app.Activity, String, int, String[])
     * @param permissions The requested permissions. Never null.
     * @param grantResults The grant results for the corresponding permissions
     * which is either PERMISSION_GRANTED or PERMISSION_DENIED. Never null.
     */


    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<String>, grantResults: IntArray
    ) {
        if (requestCode == 1000) {
            // 使用が許可された
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Log.d("debug", "checkSelfPermission true")
                locationStart()
            } else {
                // それでも拒否された時の対応
                val toast = Toast.makeText(
                    this,
                    "これ以上なにもできません", Toast.LENGTH_SHORT
                )
                toast.show()
            }
        }
    }

    override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {}
    override fun onLocationChanged(location: Location) {}
    override fun onProviderEnabled(provider: String) {}
    override fun onProviderDisabled(provider: String) {}

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */


    @SuppressLint("WrongViewCast")
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val builder = CameraPosition.Builder()
        // 地図の倍率を指定。
        builder.zoom(17f)
        // 地図の表示位置を指定。
        builder.target(LatLng(35.625760, 139.3416947))
        // 地図の傾きを指定。
        // builder.tilt(50f)
        // 地図の回転角を指定。
        builder.bearing(145f)//(345F)

        // map is a GoogleMap object
        mMap.isMyLocationEnabled = true

        val position = builder.build()
        // CameraPositionから、CameraUpdateを生成。
        val update = CameraUpdateFactory.newCameraPosition(position)

        // 回転角を地図に反映させる。
        mMap.moveCamera(update)
        //Add a marker in Sydney and move the camera
        //val school = LatLng(35.625760, 139.3416947)
        //val addMarker = mMap.addMarker(MarkerOptions().position(school).title("Marker in School"))

        val kenkyutoA = LatLng(35.62535, 139.342350000005)
        mMap.addMarker(MarkerOptions().position(kenkyutoA).title("Marker 研究棟A"))

        val kenkyutoB = LatLng(35.625, 139.34180090000005)
        mMap.addMarker(MarkerOptions().position(kenkyutoB).title("研究棟B"))

        val kenkyutoC = LatLng(35.624902, 139.343719)
        mMap.addMarker(MarkerOptions().position(kenkyutoC).title("Marker 研究棟C"))

        val kogitoA = LatLng(35.625735, 139.342700000005)
        mMap.addMarker(MarkerOptions().position(kogitoA).title("Marker 講義棟A"))

        val kogitoB = LatLng(35.624867, 139.34111000000005)
        mMap.addMarker(MarkerOptions().position(kogitoB).title("Marker 講義棟B"))

        val kogitoC = LatLng(35.6244367, 139.34160200000005)
        mMap.addMarker(MarkerOptions().position(kogitoC).title("Marker 講義棟C"))

        val kogitoD = LatLng(35.624865, 139.342700000005)
        mMap.addMarker(MarkerOptions().position(kogitoD).title("Marker 講義棟D"))

        val kogitoE = LatLng(35.6245867, 139.34223080000005)
        mMap.addMarker(MarkerOptions().position(kogitoE).title("Marker 講義棟E"))

        val kogijikkento = LatLng(35.62528, 139.343011200005)
        mMap.addMarker(MarkerOptions().position(kogijikkento).title("Marker 講義実験棟"))

        val jikkentoA = LatLng(35.625465, 139.343910)
        mMap.addMarker(MarkerOptions().position(jikkentoA).title("Marker 実験棟A"))

        val jikkentoB = LatLng(35.624779, 139.340235)
        mMap.addMarker(MarkerOptions().position(jikkentoB).title("Marker 実験棟B"))

        val katayanagihole = LatLng(35.624421, 139.342737)
        mMap.addMarker(MarkerOptions().position(katayanagihole).title("Marker 片柳記念ホール"))

        val mediahole = LatLng(35.624251, 139.34039)
        mMap.addMarker(MarkerOptions().position(mediahole).title("Marker メディアホール"))

        val honbuto = LatLng(35.626309, 139.33933)
        mMap.addMarker(MarkerOptions().position(honbuto).title("Marker 本部棟"))

        val taikukan = LatLng(35.6257002, 139.345037)
        mMap.addMarker(MarkerOptions().position(taikukan).title("Marker 体育館"))

        val koseito = LatLng(35.626004, 139.342093)
        mMap.addMarker(MarkerOptions().position(koseito).title("Marker 厚生棟"))

        val toshokanto = LatLng(35.625377, 139.34096)
        mMap.addMarker(MarkerOptions().position(toshokanto).title("Marker 図書館棟"))

        val katayanagikenkyujo = LatLng(35.627699, 139.339898)
        mMap.addMarker(MarkerOptions().position(katayanagikenkyujo).title("Marker 片柳研究所"))

        val tenjito = LatLng(35.625526, 139.339987)
        mMap.addMarker(MarkerOptions().position(tenjito).title("Marker 展示棟"))
        val monozkurikobo = LatLng(35.623355, 139.34100)
        mMap.addMarker(MarkerOptions().position(monozkurikobo).title("Marker ものづくり工房"))


        mMap!!.setOnMarkerClickListener { marker ->
            AlertDialog.Builder(this@MapActivity)
                .setTitle(marker.title)
                .setView(R.layout.map_hopup)
                .show()
            false
        }
        // override fun onMarkerClick(p0: Marker?) = false{

        //}
        //mMap.addMarker(MarkerOptions().position().title())

        //mMap.setOnMarkerClickListener(object : GoogleMap.OnMarkerClickListener {
        //    override fun onMarkerClick(p0: Marker?): Boolean {}
        //})


    }

}

