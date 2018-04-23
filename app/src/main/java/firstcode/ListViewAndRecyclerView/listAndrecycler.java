//package firstcode.ListViewAndRecyclerView;
//
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//
//import com.example.myapplication.R;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
///**
// * Created by 赵泳霖 on 2017/8/9.
// */
//
//public class listAndrecycler extends AppCompatActivity {
//    private String[] data = {"OKhttp","FirstActivity", "SecondActivity",
//            "ThirdActivity","Recycler", "imageview","itemactivity","TitleLayout"};
//
//    private List<Fruit> fruitList = new ArrayList<>();
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//
//        initFruits();//初始化数据
////        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview_vtem);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);//竖向滚动
//        recyclerView.setLayoutManager(layoutManager);
//        FruitAdapter adapter = new FruitAdapter(fruitList);
//        recyclerView.setAdapter(adapter);
//       /* FruitAdapter adapter = new FruitAdapter(MainActivity.this,
//                R.layout.fruit_item,fruitList);//适配器
//        ListView listView = (ListView) findViewById(R.id.list_vtem);
//        listView.setAdapter(adapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Fruit fruit = fruitList.get(position);
//                Toast.makeText(MainActivity.this,fruit.getName(),Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(MainActivity.this, recyclerview.RecyclerViewActivity.class);
//                startActivity(intent);
//            }
//        });*/
//    }
//
//    private void initFruits() {
//        for (int i = 0;i<2;i++) {
//            Fruit OKhttp = new Fruit("OKhttp",R.drawable.two);
//            fruitList.add(OKhttp);
//            Fruit FirstActivity = new Fruit("FirstActivity",R.drawable.third);
//            fruitList.add(FirstActivity);
//            Fruit SecondActivity = new Fruit("SecondActivity",R.drawable.four);
//            fruitList.add(SecondActivity);
//            Fruit ThirdActivity = new Fruit("ThirdActivity",R.drawable.fives);
//            fruitList.add(ThirdActivity);
//            Fruit Recycler = new Fruit("Recycler",R.drawable.six);
//            fruitList.add(Recycler);
//            Fruit imageview = new Fruit("imageview",R.drawable.seven);
//            fruitList.add(imageview);
//            Fruit itemactivity = new Fruit("itemactivity",R.drawable.eight);
//            fruitList.add(itemactivity);
//            Fruit TitleLayout = new Fruit("TitleLayout",R.drawable.nine);
//            fruitList.add(TitleLayout);
//
//
//        }
//    }
//}
