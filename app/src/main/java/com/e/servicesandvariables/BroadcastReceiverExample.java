package com.e.servicesandvariables;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.widget.Toast;

class BroadcastReceiverExample extends BroadcastReceiver {

    private NotificationManagerCompat notificationManagerCompat;
    Context context;

    public BroadcastReceiverExample(Context context){
        this.context=context;
    }

    public BroadcastReceiverExample() {

    }

    @Override
    public void onReceive(Context context, Intent intent) {

        boolean noConnectivity;
        notificationManagerCompat=NotificationManagerCompat.from(context);
        if(ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())){
            noConnectivity=intent.getBooleanExtra(
                    ConnectivityManager.EXTRA_NO_CONNECTIVITY,false);

            if(noConnectivity){
                Toast.makeText(context,"Disconnected",Toast.LENGTH_LONG).show();

            }

            else{
                Toast.makeText(context,"Connected",Toast.LENGTH_LONG).show();

            }



        }
    }
}
