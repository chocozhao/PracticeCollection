package firstcode.BroadcastTest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by 赵泳霖 on 2017/9/7.
 */

public class MyBroadcastReceiver2 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle data = getResultExtras(false);
        String info = data.getString("info");
        Toast.makeText(context,"received in AnotherBroadcastReceiver__"+info,Toast.LENGTH_SHORT).show();

    }
}
