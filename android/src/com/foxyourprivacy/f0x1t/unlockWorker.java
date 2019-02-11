package com.foxyourprivacy.f0x1t;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import com.foxyourprivacy.f0x1t.activities.ClassListActivity;
import com.foxyourprivacy.f0x1t.activities.Home;

import androidx.work.Worker;
import androidx.work.WorkerParameters;


public class unlockWorker extends Worker {
    public unlockWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        ValueKeeper v = ValueKeeper.getInstance();
        if (!v.valueKeeperAlreadyRefreshed) {
            v.reviveInstance(getApplicationContext());
        }
        DBHandler db = new DBHandler(getApplicationContext());
        String lessonName = db.unlockDaily();

        if (v.isNotificationsWanted()) {
            createNotificationChannel();
            NotificationCompat.Builder mBuilder =
                    new NotificationCompat.Builder(getApplicationContext(), getApplicationContext().getString(R.string.notification_channel_id))
                            .setSmallIcon(R.mipmap.literature)
                            .setContentTitle(getApplicationContext().getString(R.string.newLessonAvailable))
                            .setContentText(lessonName);

            Intent resultIntent = new Intent(getApplicationContext(), ClassListActivity.class);

            // The stack builder object will contain an artificial back stack for the
            // started Activity.
            // This ensures that navigating backward from the Activity leads out of
            // your application to the Home screen.
            TaskStackBuilder stackBuilder = TaskStackBuilder.create(getApplicationContext());
            // Adds the back stack for the Intent (but not the Intent itself)
            stackBuilder.addParentStack(Home.class);
            // Adds the Intent that starts the Activity to the top of the stack
            stackBuilder.addNextIntent(resultIntent);
            PendingIntent resultPendingIntent =
                    stackBuilder.getPendingIntent(
                            0,
                            PendingIntent.FLAG_UPDATE_CURRENT
                    );
            mBuilder.setContentIntent(resultPendingIntent);

            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getApplicationContext());
            notificationManager.notify(1, mBuilder.build());


        }

        return Result.success();

    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(getApplicationContext().getString(R.string.notification_channel_id), "FoxIT", importance);
            channel.setDescription(getApplicationContext().getString(R.string.unlocked_lesson));
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getApplicationContext().getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

}