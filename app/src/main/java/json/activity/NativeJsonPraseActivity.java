package json.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myapplication.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import json.bean.DataInfo;
import json.bean.ShopInfo;


public class NativeJsonPraseActivity extends Activity implements View.OnClickListener {

    private TextView tv_title;
    private Button bt_native_tojavaobject;
    private Button bt_native_tojavalist;
    private Button bt_native_complex;
    private Button bt_native_special;
    private TextView tv_native_orignal;
    private TextView tv_native_last;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_native_json_prase);

        initview();

        initListener();
    }

    private void initListener() {
        bt_native_tojavalist.setOnClickListener(this);
        bt_native_tojavaobject.setOnClickListener(this);
        bt_native_complex.setOnClickListener(this);
        bt_native_special.setOnClickListener(this);
        tv_native_orignal.setOnClickListener(this);
        tv_native_last.setOnClickListener(this);
    }

    private void initview() {
        //修改头部布局
        tv_title = (TextView) findViewById(R.id.title_title);
        tv_title.setText("解析json");
        //获取操作对象
        bt_native_tojavaobject = (Button) findViewById(R.id.bt_native_tojavaobject);
        bt_native_tojavalist = (Button) findViewById(R.id.bt_native_tojavalist);
        bt_native_complex = (Button) findViewById(R.id.bt_native_complex);
        bt_native_special = (Button) findViewById(R.id.bt_native_special);
        tv_native_orignal = (TextView) findViewById(R.id.tv_native_orignal);
        tv_native_last = (TextView) findViewById(R.id.tv_native_last);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_native_tojavaobject:
                //将json格式字符串转换成java对象
                jsonTojavaobjectNative();
                break;
            case R.id.bt_native_tojavalist:
                //将json格式字符串转换成java对象list
                jsonTojavaListByNative();
                break;
            case R.id.bt_native_complex:
                //复杂解析json
                jsonTojavaOfComplex();
                break;
            case R.id.bt_native_special:
                //特殊解析json

                break;
        }

    }

    private void jsonTojavaOfComplex() {
        //创建或者获取数据
        String json = "\n" +
                "    \"data\": {\n" +
                "        \"count\": 5,\n" +
                "        \"trailers\": [\n" +
                "            {\n" +
                "                \"coverImg\": \"http://img5.mtime.cn/mg/2017/11/13/105245.83405580_120X90X4.jpg\",\n" +
                "                \"hightUrl\": \"http://vfx.mtime.cn/Video/2017/11/13/mp4/171113105102992015.mp4\",\n" +
                "                \"id\": 68379,\n" +
                "                \"movieId\": 232881,\n" +
                "                \"movieName\": \"《拓星者》先行版预告\",\n" +
                "                \"rating\": -1,\n" +
                "                \"summary\": \"国产科幻 外星荒漠挣扎求生\",\n" +
                "                \"type\": [\n" +
                "                    \"动作\",\n" +
                "                    \"科幻\",\n" +
                "                    \"冒险\"\n" +
                "                ],\n" +
                "                \"url\": \"http://vfx.mtime.cn/Video/2017/11/13/mp4/171113105102992015.mp4\",\n" +
                "                \"videoLength\": 78,\n" +
                "                \"videoTitle\": \"拓星者 先行版预告\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"coverImg\": \"http://img5.mtime.cn/mg/2017/11/08/093909.60048379_120X90X4.jpg\",\n" +
                "                \"hightUrl\": \"http://vfx.mtime.cn/Video/2017/11/08/mp4/171108093937333122.mp4\",\n" +
                "                \"id\": 68309,\n" +
                "                \"movieId\": 240443,\n" +
                "                \"movieName\": \"《比得兔》中文预告\",\n" +
                "                \"rating\": -1,\n" +
                "                \"summary\": \"比得兔与农场主斗智斗勇\",\n" +
                "                \"type\": [\n" +
                "                    \"动画\",\n" +
                "                    \"冒险\",\n" +
                "                    \"喜剧\",\n" +
                "                    \"家庭\",\n" +
                "                    \"奇幻\"\n" +
                "                ],\n" +
                "                \"url\": \"http://vfx.mtime.cn/Video/2017/11/08/mp4/171108093937333122.mp4\",\n" +
                "                \"videoLength\": 133,\n" +
                "                \"videoTitle\": \"比得兔 中文版剧场预告片\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"coverImg\": \"http://img5.mtime.cn/mg/2017/06/30/111434.76339580.jpg\",\n" +
                "                \"hightUrl\": \"http://vfx.mtime.cn/Video/2017/11/14/mp4/171114092423896713.mp4\",\n" +
                "                \"id\": 68391,\n" +
                "                \"movieId\": 227232,\n" +
                "                \"movieName\": \"《勇敢者的游戏》预告\",\n" +
                "                \"rating\": -1,\n" +
                "                \"summary\": \"问题学生意外闯入冒险游戏\",\n" +
                "                \"type\": [\n" +
                "                    \"动作\",\n" +
                "                    \"冒险\",\n" +
                "                    \"喜剧\",\n" +
                "                    \"家庭\",\n" +
                "                    \"奇幻\"\n" +
                "                ],\n" +
                "                \"url\": \"http://vfx.mtime.cn/Video/2017/11/14/mp4/171114092423896713.mp4\",\n" +
                "                \"videoLength\": 96,\n" +
                "                \"videoTitle\": \"勇敢者游戏：决战丛林 \"身陷兽群\"预告片\"\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "}";
        //解析json

        DataInfo dataInfo = new DataInfo();
        try {
            JSONObject jsonObject = new JSONObject(json);
            //第一层解析
            JSONObject data = jsonObject.optJSONObject("data");
            //第一层封装
            DataInfo.DataBean dataBean = new DataInfo.DataBean();
            dataInfo.setData(dataBean);


            //第二层解析
            int count = data.optInt("count");
            JSONArray trailers = data.optJSONArray("trailers");
            //第二层封装
            dataBean.setCount(count);
            List<DataInfo.DataBean.TrailersBean> trailersBean = new ArrayList<>();
            dataBean.setTrailers(trailersBean);


            //第三层解析
            for (int i = 0; i < trailers.length(); i++) {
                JSONObject jsonObject1 = trailers.optJSONObject(i);

                if (jsonObject1 != null) {

                    String coverImg = jsonObject1.optString("coverImg");
                    String hightUrl = jsonObject1.optString("hightUrl");
                    int id = jsonObject1.optInt("id");
                    int movieId = jsonObject1.optInt("movieId");
                    String movieName = jsonObject1.optString("movieName");
                    int rating = jsonObject1.optInt("rating");
                    String summary = jsonObject1.optString("summary");
                    String url = jsonObject1.optString("url");
                    int videoLength = jsonObject1.optInt("videoLength");
                    String videoTitle = jsonObject1.optString("videoTitle");


                    //第三层封装
                    DataInfo.DataBean.TrailersBean bean = new DataInfo.DataBean.TrailersBean();
                    bean.setCoverImg(coverImg);
                    bean.setHightUrl(hightUrl);
                    bean.setId(id);
                    bean.setMovieId(movieId);
                    bean.setMovieName(movieName);
                    bean.setRating(rating);
                    bean.setSummary(summary);
                    bean.setUrl(url);
                    bean.setVideoLength(videoLength);
                    bean.setVideoTitle(videoTitle);
                    trailersBean.add(bean);

                    //第四层解析
                    JSONArray type = jsonObject1.optJSONArray("type");
                    for (int j = 0; j < type.length() ; j++) {
                        JSONObject jsonObject2 = type.optJSONObject(i);

                        if (jsonObject2 != null) {
                            String one = jsonObject2.optString("[0]");
                            String two = jsonObject2.optString("[1]");
                            String three = jsonObject2.optString("[2]");
                        }
                        //第四层封装
                       // List<DataInfo.DataBean.TrailersBean> trailersBean = new ArrayList<>();



                    }


                }

            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
        //显示数据
        tv_native_orignal.setText(json);
        tv_native_last.setText(dataInfo.toString());
    }

    //将json格式字符串转换成java对象list
    private void jsonTojavaListByNative() {
        //获取或创建json数据。
        String json = "[{\"id\":68379,\"movieName\":\"《拓星者》先行版预告\",\"coverImg\":\"http://img5.mtime.cn/mg/2017/11/13/105245.83405580_120X90X4.jpg\",\"movieId\":232881,\"url\":\"http://vfx.mtime.cn/Video/2017/11/13/mp4/171113105102992015.mp4\",\"hightUrl\":\"http://vfx.mtime.cn/Video/2017/11/13/mp4/171113105102992015.mp4\",\"videoTitle\":\"拓星者 先行版预告\",\"videoLength\":78,\"rating\":-1,\"type\":[\"动作\",\"科幻\",\"冒险\"],\"summary\":\"国产科幻 外星荒漠挣扎求生\"},{\"id\":68309,\"movieName\":\"《比得兔》中文预告\",\"coverImg\":\"http://img5.mtime.cn/mg/2017/11/08/093909.60048379_120X90X4.jpg\",\"movieId\":240443,\"url\":\"http://vfx.mtime.cn/Video/2017/11/08/mp4/171108093937333122.mp4\",\"hightUrl\":\"http://vfx.mtime.cn/Video/2017/11/08/mp4/171108093937333122.mp4\",\"videoTitle\":\"比得兔 中文版剧场预告片\",\"videoLength\":133,\"rating\":-1,\"type\":[\"动画\",\"冒险\",\"喜剧\",\"家庭\",\"奇幻\"],\"summary\":\"比得兔与农场主斗智斗勇\"}]";
        //解析json数据
        List<ShopInfo> shops = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(json);

            for (int i = 0; i < jsonArray.length() ; i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                if (jsonObject != null) {
                    int id = jsonObject.optInt("id");
                    String movieName = jsonObject.optString("movieName");
                    String coverImg = jsonObject.optString("coverImg");
                    int movieId = jsonObject.optInt("movieId");
                    String url = jsonObject.optString("url");
                    String hightUrl = jsonObject.optString("hightUrl");
                    int videoTitle = jsonObject.optInt("videoTitle");
                    String optString = jsonObject.optString("rating");
                    String type = jsonObject.optString("type");
                    String summary = jsonObject.optString("summary");

                    //封装Java对象
                    ShopInfo shopInfo = new ShopInfo(id, movieName, coverImg, movieId, url, hightUrl, summary, optString, videoTitle, type);

                    shops.add(shopInfo);

                }


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        //显示数据
        tv_native_orignal.setText(json);
        tv_native_last.setText(shops.toString());
    }



    //将json格式字符串转换成java对象
    private void jsonTojavaobjectNative() {
        //创建json对象
        String json = "{\"id\":1," +
                "\"movieName\":\"《拓星者》先行版预告\"," +
                "\"coverImg\":\"http://img5.mtime.cn/mg/2017/11/13/105245.83405580_120X90X4.jpg\"," +
                "\"movieId\":232881," +
                "\"url\":\"http://vfx.mtime.cn/Video/2017/11/13/mp4/171113105102992015.mp4\"," +
                "\"hightUrl\":\"http://vfx.mtime.cn/Video/2017/11/13/mp4/171113105102992015.mp4\"," +
                "\"videoTitle\":\"拓星者 先行版预告\"," +
                "\"videoLength\":78," +
                "\"rating\":-1," +
                "\"type\":[\"动作\",\"科幻\",\"冒险\"]," +
                "\"summary\":\"国产科幻 外星荒漠挣扎求生\"}," +
                " \"coverImg\": \"http://img5.mtime.cn/mg/2017/11/08/093909.60048379_120X90X4.jpg\",\n" +
                "\"hightUrl\": \"http://vfx.mtime.cn/Video/2017/11/08/mp4/171108093937333122.mp4\",\n" +
                "\"id\":2,\n" +
                "\"movieId\": 240443,\n" +
                "\"movieName\": \"《比得兔》中文预告\",\n" +
                "\"rating\": -1,\n" +
                "\"summary\": \"比得兔与农场主斗智斗勇\",\n" +
                "\"type\": [\n" +
                "\"动画\",\n" +
                "\"冒险\",\n" +
                "\"喜剧\",\n" +
                "\"家庭\",\n" +
                "\"奇幻\"\n" +
                "],\n" +
                "\"url\": \"http://vfx.mtime.cn/Video/2017/11/08/mp4/171108093937333122.mp4\",\n" +
                "\"videoLength\": 133,\n" +
                "\"videoTitle\": \"比得兔 中文版剧场预告片\"";
        ShopInfo shopInfo = null;
        //解析json
        try {
            JSONObject jsonObject = new JSONObject(json);
            int id = jsonObject.optInt("id");
            String movieName = jsonObject.optString("movieName");
            String coverImg = jsonObject.optString("coverImg");
            int movieId = jsonObject.optInt("movieId");
            String url = jsonObject.optString("url");
            String hightUrl = jsonObject.optString("hightUrl");
            int videoTitle = jsonObject.optInt("videoTitle");
            String optString = jsonObject.optString("rating");
            String type = jsonObject.optString("type");
            String summary = jsonObject.optString("summary");
            //封装Java对象
            shopInfo = new ShopInfo(id, movieName, coverImg, movieId, url, hightUrl, summary, optString, videoTitle, type);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        //显示数据
        tv_native_orignal.setText(json);
        tv_native_last.setText(shopInfo.toString());
    }
}
