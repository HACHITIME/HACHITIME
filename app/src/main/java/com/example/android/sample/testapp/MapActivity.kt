package com.example.android.sample.testapp

import android.Manifest
import android.app.ActivityOptions
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
import android.widget.Toast
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import kotlinx.android.synthetic.main.toolbar.*
import java.io.BufferedReader
import java.io.InputStreamReader


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
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        tytle.text = "Map"

        school_btn.setOnClickListener {
            val intent = Intent(this, FacilityListActivity::class.java)
            // 同一アクティビティ開始時、古い方を終了させる
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(
                intent,
                ActivityOptions.makeSceneTransitionAnimation(this).toBundle()
            )
        }

        map_btn.setOnClickListener {
            val intent = Intent(this, MapActivity::class.java)
            // 同一アクティビティ開始時、古い方を終了させる
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(
                intent,
                ActivityOptions.makeSceneTransitionAnimation(this).toBundle()
            )
        }

        stamp_btn.setOnClickListener {
            val intent = Intent(this, StampActivity::class.java)
            // 同一アクティビティ開始時、古い方を終了させる
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(
                intent,
                ActivityOptions.makeSceneTransitionAnimation(this).toBundle()
            )
        }

        info_btn.setOnClickListener {
            val intent = Intent(this, CampusInfoActivity::class.java)
            // 同一アクティビティ開始時、古い方を終了させる
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(
                intent,
                ActivityOptions.makeSceneTransitionAnimation(this).toBundle()
            )
        }

        bus_btn.setOnClickListener {
            val intent = Intent(this, BustimeActivity::class.java)
            // 同一アクティビティ開始時、古い方を終了させる
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
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

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val builder = CameraPosition.Builder()
        // 地図の倍率を指定。
        builder.zoom(17f)
        // 地図の表示位置を指定。
        builder.target(LatLng(35.625760, 139.3416947))
        // 地図の回転角を指定。
        builder.bearing(145f)//(345F)

        val assetManager = resources.assets //アセット呼び出し
        val inputStream = assetManager.open("googlemapStyle.json") //Jsonファイル
        val bufferedReader = BufferedReader(InputStreamReader(inputStream))
        val str: String = bufferedReader.readText() //データ

        mMap.setMapStyle(MapStyleOptions(str))

        // map is a GoogleMap object
        mMap.isMyLocationEnabled = true

        val position = builder.build()
        // CameraPositionから、CameraUpdateを生成。
        val update = CameraUpdateFactory.newCameraPosition(position)

        // 回転角を地図に反映させる。
        mMap.moveCamera(update)

        //----------------------------------------------------------
        //Lat下げると右上、上げると左下
        //Lng下げると右下、上げると左上
        //Lat下げてLng上げると上
        //Lat上げてLng下げると下
        //両方下げると右、両方上げると左
        //----------------------------------------------------------
        val kenkyutoA = LatLng(35.62535, 139.342350000005)
        mMap.addMarker(MarkerOptions().position(kenkyutoA).title("研究棟A")
            .infoWindowAnchor(30F,30F).icon(BitmapDescriptorFactory.fromResource(R.drawable.googlemap_kenkyuto_a)))

        val kenkyutoB = LatLng(35.625, 139.34170100000105)
        mMap.addMarker(MarkerOptions().position(kenkyutoB).title("研究棟B")
            .infoWindowAnchor(30F,30F).icon(BitmapDescriptorFactory.fromResource(R.drawable.googlemap_kenkyuto_b)))

        val kenkyutoC = LatLng(35.624902, 139.343619)
        mMap.addMarker(MarkerOptions().position(kenkyutoC).title("研究棟C")
            .infoWindowAnchor(30F,30F).icon(BitmapDescriptorFactory.fromResource(R.drawable.googlemap_kenkyuto_c)))

        val kogitoA = LatLng(35.625735, 139.342700000005)
        mMap.addMarker(MarkerOptions().position(kogitoA).title("講義棟A")
            .infoWindowAnchor(30F,30F).icon(BitmapDescriptorFactory.fromResource(R.drawable.googlemap_kogito_a)))

        val kogitoB = LatLng(35.624867, 139.34111000000005)
        mMap.addMarker(MarkerOptions().position(kogitoB).title("講義棟B")
            .infoWindowAnchor(30F,30F).icon(BitmapDescriptorFactory.fromResource(R.drawable.googlemap_kogito_b)))

        val kogitoC = LatLng(35.6244367, 139.34150200000005)
        mMap.addMarker(MarkerOptions().position(kogitoC).title("講義棟C")
            .infoWindowAnchor(30F,30F).icon(BitmapDescriptorFactory.fromResource(R.drawable.googlemap_kogito_c)))

        val kogitoD = LatLng(35.624865, 139.342700000005)
        mMap.addMarker(MarkerOptions().position(kogitoD).title("講義棟D")
            .infoWindowAnchor(30F,30F).icon(BitmapDescriptorFactory.fromResource(R.drawable.googlemap_kogito_d)))

        val kogitoE = LatLng(35.6245867, 139.34215050000005)
        mMap.addMarker(MarkerOptions().position(kogitoE).title("講義棟E")
            .infoWindowAnchor(30F,30F).icon(BitmapDescriptorFactory.fromResource(R.drawable.googlemap_kogito_e)))

        val kogijikkento = LatLng(35.62528, 139.343011200005)
        mMap.addMarker(MarkerOptions().position(kogijikkento).title("講義実験棟")
            .infoWindowAnchor(30F,30F).icon(BitmapDescriptorFactory.fromResource(R.drawable.googlemap_kogihikkento)))

        val jikkentoA = LatLng(35.625565, 139.343800)
        mMap.addMarker(MarkerOptions().position(jikkentoA).title("実験棟A")
            .infoWindowAnchor(30F,30F).icon(BitmapDescriptorFactory.fromResource(R.drawable.googlemap_jikkento_a)))

        val jikkentoB = LatLng(35.624789, 139.340125)
        mMap.addMarker(MarkerOptions().position(jikkentoB).title("実験棟B")
            .infoWindowAnchor(30F,30F).icon(BitmapDescriptorFactory.fromResource(R.drawable.googlemap_jikkento_b)))

        val katayanagihole = LatLng(35.624421, 139.342737)
        mMap.addMarker(MarkerOptions().position(katayanagihole).title("片柳記念ホール")
            .infoWindowAnchor(30F,30F).icon(BitmapDescriptorFactory.fromResource(R.drawable.googlemap_katayanagihole)))

        val mediahole = LatLng(35.624251, 139.34039)
        mMap.addMarker(MarkerOptions().position(mediahole).title("メディアホール")
            .infoWindowAnchor(30F,30F).icon(BitmapDescriptorFactory.fromResource(R.drawable.googlemap_mediahole)))

        val honbuto = LatLng(35.6264399, 139.33926)
        mMap.addMarker(MarkerOptions().position(honbuto).title("本部棟")
            .infoWindowAnchor(30F,30F).icon(BitmapDescriptorFactory.fromResource(R.drawable.googlemap_honbuto)))

        val taikukan = LatLng(35.6259002, 139.344937)
        mMap.addMarker(MarkerOptions().position(taikukan).title("体育館")
            .infoWindowAnchor(30F,30F).icon(BitmapDescriptorFactory.fromResource(R.drawable.googlemap_taikukan)))

        val koseito = LatLng(35.626114, 139.342083)
        mMap.addMarker(MarkerOptions().position(koseito).title("厚生棟")
            .infoWindowAnchor(30F,30F).icon(BitmapDescriptorFactory.fromResource(R.drawable.googlemap_koseito)))

        val toshokanto = LatLng(35.625487, 139.34098)
        mMap.addMarker(MarkerOptions().position(toshokanto).title("図書館棟")
            .infoWindowAnchor(30F,30F).icon(BitmapDescriptorFactory.fromResource(R.drawable.googlemap_toshokanto)))

        val katayanagikenkyujo = LatLng(35.627699, 139.339898)
        mMap.addMarker(MarkerOptions().position(katayanagikenkyujo).title("片柳研究所")
            .infoWindowAnchor(30F,30F).icon(BitmapDescriptorFactory.fromResource(R.drawable.googlemap_katayanagikenkyujo)))

        val bizyutsukan = LatLng(35.625526, 139.339987)
        mMap.addMarker(MarkerOptions().position(bizyutsukan).title("鴻稜美術館")
            .infoWindowAnchor(30F,30F).icon(BitmapDescriptorFactory.fromResource(R.drawable.googlemap_bizyutsukan)))

        val monozkurikobo = LatLng(35.623355, 139.34100)
        mMap.addMarker(MarkerOptions().position(monozkurikobo).title("ものづくり工房")
            .infoWindowAnchor(30F,30F).icon(BitmapDescriptorFactory.fromResource(R.drawable.googlemap_monozkurikobo)))

        mMap!!.setOnMarkerClickListener { marker ->
            val dialog = MapActivityDialog()
            val args = Bundle()
            dialog.arguments = args
            args.putString("marker_title",marker.title)
            //現在地を変数に入れる
            var mylat = mMap.myLocation.latitude
            var mylng = mMap.myLocation.longitude

            //クリックしたマーカーの座標を入れる
            var fMarkerLat = marker.position.latitude
            var fMarkerLng = marker.position.longitude

            //結果を配列に入れる
            var results = FloatArray(3)
            Location.distanceBetween(mylat, mylng, fMarkerLat, fMarkerLng, results)
            var results_0 = results[0]
            args.putFloat("stamp_result",results_0)

            //args.putString("syutoku", syutoku[desain])
            dialog.show(supportFragmentManager, "simple")
            false
        }
    }
}