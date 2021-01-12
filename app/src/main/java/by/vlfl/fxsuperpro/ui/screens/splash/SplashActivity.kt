package by.vlfl.fxsuperpro.ui.screens.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.vlfl.fxsuperpro.R
import by.vlfl.fxsuperpro.ui.screens.start.AuthorizationActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_FxSuperPro)
        super.onCreate(savedInstanceState)

        startActivity(Intent(this, AuthorizationActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
        })
        finishAffinity()
    }
}