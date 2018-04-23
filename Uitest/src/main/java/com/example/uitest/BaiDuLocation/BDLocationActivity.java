package com.example.uitest.BaiDuLocation;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.example.uitest.R;

import java.util.ArrayList;
import java.util.List;

public class BDLocationActivity extends Activity {
    private LocationClient mLocationClinet;
    private TextView position_text_view;
    private MapView mapView;
    private BaiduMap baiduMap;
    private boolean isFirstLocate = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLocationClinet = new LocationClient(getApplicationContext());
        mLocationClinet.registerLocationListener(new MyLocationListener());
        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.activity_bdlocation);

        position_text_view = findViewById(R.id.position_text_view);
        mapView = findViewById(R.id.bmapView);
        baiduMap = mapView.getMap();
        baiduMap.setMyLocationEnabled(true);
        
        //获取权限，将权限存到集合
        List<String> permissionList = new ArrayList<>();
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.READ_PHONE_STATE);
        }
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if (!permissionList.isEmpty()) {
            String[] permissions = permissionList.toArray(new String[permissionList.size()]);
            ActivityCompat.requestPermissions(this, permissions, 1);
        } else {
            requestLocation();
        }

        initLocation();
    }
//在规定时间更新定位
    private void initLocation() {
        LocationClientOption locationClientOption = new LocationClientOption();
        locationClientOption.setScanSpan(5000);
        locationClientOption.setIsNeedAddress(true);//获取当前位置的详细地址
        locationClientOption.setLocationMode(LocationClientOption.LocationMode.Device_Sensors);
        mLocationClinet.setLocOption(locationClientOption);
    }

    private void navigateTo(BDLocation bdLocation) {
        if(isFirstLocate) {
            LatLng ll = new LatLng(bdLocation.getLongitude(), bdLocation.getLongitude());
            MapStatusUpdate update = MapStatusUpdateFactory.newLatLng(ll);
            baiduMap.animateMapStatus(update);//将更新的参数传入对象当中
            update = MapStatusUpdateFactory.zoomTo(16f);
            baiduMap.animateMapStatus(update);
            isFirstLocate = false;//防止animateMapStatus的多次调用
        }
        MyLocationData.Builder locationBuilder = new MyLocationData.Builder();
        locationBuilder.latitude(bdLocation.getLatitude());
        locationBuilder.longitude(bdLocation.getLongitude());
        MyLocationData locationData = locationBuilder.build();
        baiduMap.setMyLocationData(locationData);
    }

    private void requestLocation() {
        mLocationClinet.start();//开始定位
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0) {
                    for (int result : grantResults) {
                        if (result != PackageManager.PERMISSION_GRANTED) {
                            Toast.makeText(BDLocationActivity.this, "同意权限使用", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                } else {
                    Toast.makeText(BDLocationActivity.this, "权限得到同意", Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
                default:
                    break;
        }

    }

    public class MyLocationListener implements BDLocationListener{
        @Override
        public void onReceiveLocation(BDLocation bdLocation) {
//            StringBuilder stringBuilder = new StringBuilder();
//            stringBuilder.append("纬度：").append(bdLocation.getLatitude()).append("\n");
//            stringBuilder.append("经度：").append(bdLocation.getLatitude()).append("\n");
//            stringBuilder.append("国家：").append(bdLocation.getCountry()).append("\n");
//            stringBuilder.append("省：").append(bdLocation.getProvince()).append("\n");
//            stringBuilder.append("市：").append(bdLocation.getCity()).append("\n");
//            stringBuilder.append("区：").append(bdLocation.getDistrict()).append("\n");
//            stringBuilder.append("街道：").append(bdLocation.getStreet()).append("\n");
//            stringBuilder.append("定位方式:");
//            if(bdLocation.getLocType() == BDLocation.TypeGpsLocation) {
//                stringBuilder.append("GPS");
//            }else if(bdLocation.getLocType() == BDLocation.TypeNetWorkLocation) {
//                stringBuilder.append("网络");
//            }
//            position_text_view.setText(stringBuilder);
            if(bdLocation.getLocType() == BDLocation.TypeNetWorkLocation || bdLocation.getLocType() == BDLocation.TypeGpsLocation) {
                navigateTo(bdLocation);
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    //活动被摧毁停止定位
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLocationClinet.stop();
        mapView.onDestroy();
        baiduMap.setMyLocationEnabled(false);
    }
}
