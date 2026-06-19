package gr.dimvai.quickestreminderever

import android.app.PendingIntent
import android.content.Intent
import android.service.quicksettings.TileService

class QuickestTileService : TileService() {

    override fun onClick() {
        super.onClick()

        val intent = Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
        }

        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        startActivityAndCollapse(pendingIntent)
    }
}
