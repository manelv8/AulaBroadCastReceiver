package tech.sobre.aulaboradcast;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    ToastReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        receiver = new ToastReceiver();
//        IntentFilter filter = new IntentFilter("tech.sobre.aulaboradcast.TOAST");
        IntentFilter filter = new IntentFilter();
        filter.addAction("tech.sobre.aulaboradcast.TOAST");
        registerReceiver(receiver,filter);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }

    public void sendBraodcast(View view) {
        Intent i = new Intent("tech.sobre.aulaboradcast.TOAST");
        i.putExtra("msg","mensagem enviado por broadcast");
        sendBroadcast(i);

    }
}
