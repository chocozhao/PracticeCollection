package com.example.uitest.Networktest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.uitest.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.xml.parsers.SAXParserFactory;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * 使用网络技术
 */

public class NetworkTestActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView responseText;
    private Button sendRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_networktest);

        sendRequest = (Button) findViewById(R.id.send_request);
        responseText = (TextView) findViewById(R.id.response_text);
        sendRequest.setOnClickListener(this);
//        Button sendOkhttp = (Button) findViewById(R.id.send_Okhttp);
//        sendOkhttp.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.send_request) {
            sendRequestWithOkhttp();
            //sendRequestWithHttpURLConnection();



        }
    }

    private void sendRequestWithOkhttp() {
        //开启新线程做耗时操作
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();//创建一个OkHttpClient实例
                    Request request = new Request.Builder()
                            .url("http://192.168.50.2/get_data.json")//设置目标网络地址
                            .build();//创建一个Request对象
                    Response response = client.newCall(request).execute();//发送请求获取服务器返回对象
                    String responseData = response.body().string();
                    //返回数据
                    //showResponse(responseData);
                    //解析XML
                    //parseXMLWithPull(responseData);
                    //parseXMLWithSAX(responseData);
                    //parseJSONWithJSONObject(responseData);
                    //parseJSONWithGSON(responseData);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }).start();
    }

    private void parseJSONWithGSON(String responseData) {
        StringBuilder builder = new StringBuilder();
        Gson gson = new Gson();
        List<App> appList = gson.fromJson(responseData, new TypeToken<List<App>>() {}.getType());
        for (App app : appList) {
            Log.d("MainAcivity", "id is " + app.getId());
            Log.d("MainAcivity", "name is " + app.getName());
            Log.d("MainAcivity", "version is " + app.getVersion());
            builder.append("id" + app.getId() + "\n")
                    .append("name" + app.getName() + "\n")
                    .append("version" + app.getVersion() + "\n")
                    .append("__________________\n");
        }
    }

    private void parseJSONWithJSONObject(String responseData) {
        StringBuilder builder = new StringBuilder();
        try {
            JSONArray jsonArray = new JSONArray(responseData);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String id = jsonObject.getString("id");
                String name = jsonObject.getString("name");
                String version = jsonObject.getString("version");
                Log.d("NetworkTestActivity", "id is " + id);
                Log.d("NetworkTestActivity", "name is " + name);
                Log.d("NetworkTestActivity", "version is " + version);
                builder.append("id" + id + "\n")
                        .append("name" + name + "\n")
                        .append("version" + version + "\n")
                        .append("__________________\n");
            }
            showResponse(builder.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void parseXMLWithSAX(String responseData) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            XMLReader xmlReader = factory.newSAXParser().getXMLReader();
            ContentHandler handler = new ContentHandler();
            //将Contenthandler的实例设置到XMLReader上
            xmlReader.setContentHandler(handler);
            //开始执行解析
            xmlReader.parse(new InputSource(new StringReader(responseData)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parseXMLWithPull(String responseData) {
        StringBuilder builder = new StringBuilder();
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();//创建工厂
            XmlPullParser xmlPullParser = factory.newPullParser();//创建xmlPullparser实例
            xmlPullParser.setInput(new StringReader(responseData));
            int eventType = xmlPullParser.getEventType();
            String id = "";
            String name = "";
            String version = "";
            while (eventType != XmlPullParser.END_DOCUMENT) {
                String nodeName = xmlPullParser.getName();//获取当前的节点名字
                switch (eventType) {
                    //开始解析某个节点
                    case XmlPullParser.START_TAG: {
                        if ("id".equals(nodeName)) {
                            id = xmlPullParser.nextText();
                        } else if ("name".equals(nodeName)) {
                            name = xmlPullParser.nextText();
                        } else if ("version".equals(nodeName)) {
                            version = xmlPullParser.nextText();
                        }
                        break;
                    }
                    case XmlPullParser.END_TAG: {
                        //完成解析某个节点
                        if ("app".equals(nodeName)) {
                            Log.d("NetworkTestActivity", "id is " + id);
                            Log.d("NetworkTestActivity", "name is " + name);
                            Log.d("NetworkTestActivity", "version is " + version);
                            Log.d("NetworkTestActivity", "-------------");
                            builder.append("id" + id + "\n")
                                    .append("name" + name + "\n")
                                    .append("version" + version + "\n")
                                    .append("__________________\n");
                        }
                        break;
                    }
                    default:
                        break;
                }
                eventType = xmlPullParser.next();//获取下一个解析事件
            }
            showResponse(builder.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendRequestWithHttpURLConnection() {
        // 开启线程来发起网络
        new Thread(new Runnable() {
            @Override
            public void run() {

                HttpURLConnection connection = null;
                BufferedReader reader = null;
                try {
                    URL url = new URL("https://www.baidu.com");//获取目标网络地址
                    connection = (HttpURLConnection) url.openConnection();//打开网络连接
                    connection.setRequestMethod("GET");//设置请求的方法
//                    connection.setRequestMethod("POST");
                    connection.setConnectTimeout(8000);//连接时间
                    connection.setReadTimeout(8000);//读取时间
                    InputStream in = connection.getInputStream();//获取服务器返回的输入流
//                    DataOutputStream out = new DataOutputStream(connection.getOutputStream());
//                    out.writeBytes("username=admin&passwpord=123456");
                    //下面对获取到的输入流进行读取
                    reader = new BufferedReader(new InputStreamReader(in));//读取服务器返回的输入流
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    showResponse(response.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (reader != null) {
                        try {
                            reader.close();//如果读取的是空的，关流
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (connection != null) {
                        connection.disconnect();//如果连接是空，关闭HTTP的连接
                    }
                }
            }
        }).start();

    }

    private void showResponse(final String response) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //在这里进行UI操作，将结果显示到界面上
                responseText.setText(response);
            }
        });
    }
}
