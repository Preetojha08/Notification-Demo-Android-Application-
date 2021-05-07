package com.example.mytabnotification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mytabnotification.R;

public class MainActivity extends AppCompatActivity {

    Button notification_btn,bigimgnotification_btn,longtvnotification_btn;
    final String CHANNEL_ID = "normal_notification";
    final String CHANNEL_ID_IMG = "big_picture_style_notification";
    final String CHANNEL_ID_TEXT = "big_text_style_notification";

    final int NOTIFICATION_ID = 01;
    final int NOTIFICATION_IMG_ID = 02;
    final int NOTIFICATION_ID_TEXT = 03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notification_btn=(Button)findViewById(R.id.button_normal_notification);
        bigimgnotification_btn=(Button)findViewById(R.id.button_image_notification);
        longtvnotification_btn=(Button)findViewById(R.id.button_longtext_notification);


        notification_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createNotificationChannel();

                NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID);
                builder.setSmallIcon(R.drawable.ic_android_black_24dp);
                builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_android_black_24dp));
                builder.setContentTitle("Name of the Notification");
                builder.setContentText("Here is a Message of Normal Notification");
                builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);

                NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(getApplicationContext());
                notificationManagerCompat.notify(NOTIFICATION_ID, builder.build());
            }
        });

        bigimgnotification_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createNotificationChannelIMG();

                Bitmap bigPicture = BitmapFactory.decodeResource(getResources(), R.drawable.mind);
                NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID_IMG);

                builder.setSmallIcon(R.drawable.ic_android_black_24dp);
                builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_android_black_24dp));
                builder.setContentTitle("Mind Picture From Pixabay");
                builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bigPicture));
                builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
                NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(getApplicationContext());
                notificationManagerCompat.notify(NOTIFICATION_IMG_ID, builder.build());
            }
        });

        longtvnotification_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createNotificationChannelTEXT();

                NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID_TEXT);
                builder.setSmallIcon(R.drawable.ic_android_black_24dp);
                builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_android_black_24dp));
                builder.setContentTitle("Preet Ojha");
                builder.setStyle(new NotificationCompat.BigTextStyle().bigText("You are only here to learn the Android." +
                        "This Application will help you to learn all basic and important things in Android. " +
                        "Don't hurry and don't worry soon you will become an Android Developer."));
                builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
                NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(getApplicationContext());
                notificationManagerCompat.notify(NOTIFICATION_ID_TEXT, builder.build());
            }
        });
    }

    private void createNotificationChannel(){

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){

            CharSequence name = "Normal Notification";
            String description = "Include all the normal notification";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID,name,importance);
            notificationChannel.setDescription(description);

            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);

        }
    }

    private void createNotificationChannelIMG(){

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){

            CharSequence name = "BigPictureStyle Notification";
            String description = "Include all the BigPictureStyle notification";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID_IMG,name,importance);
            notificationChannel.setDescription(description);

            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    private void createNotificationChannelTEXT(){

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){

            CharSequence name = "BigTextStyle Notification";
            String description = "Include all the BigTextStyle notification";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID_TEXT,name,importance);
            notificationChannel.setDescription(description);

            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);

        }
    }
}