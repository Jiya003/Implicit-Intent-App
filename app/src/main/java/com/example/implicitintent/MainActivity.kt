package com.example.implicitintent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.CallLog
import android.provider.MediaStore
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.implicitintent.ui.theme.ImplicitIntentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        setContentView(R.layout.layout_activity)

        val openURLButton = findViewById<Button>(R.id.openGoogle)

        openURLButton.setOnClickListener {
            val intent1 = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
            startActivity(intent1)
        }

        val openCameraButton: Button = findViewById(R.id.openCamera)
        openCameraButton.setOnClickListener {
            val intent2 = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent2)
        }

        val openCallLogsButton: Button=findViewById(R.id.openCallLogs)
        openCallLogsButton.setOnClickListener{
            val intent3=Intent(Intent.ACTION_VIEW)
            intent3.type=CallLog.Calls.CONTENT_TYPE
            startActivity(intent3)
        }

        val openDialerButton: Button=findViewById(R.id.openDialer)
        openDialerButton.setOnClickListener{
            val intent4=Intent(Intent.ACTION_DIAL)
            startActivity(intent4)
        }

        val openWhatsappButton: Button=findViewById(R.id.openWhatsapp)
        openWhatsappButton.setOnClickListener{
            val intent5=Intent(Intent.ACTION_SEND)
            intent5.type="text/plain"
            intent5.setPackage("com.whatsapp")
            intent5.putExtra(Intent.EXTRA_TEXT,"Hey there!")
            startActivity(intent5)
        }

        val openGalleryButton: Button=findViewById(R.id.openGallery)
        openGalleryButton.setOnClickListener{
            val intent6=Intent(Intent.ACTION_VIEW)
            intent6.type="image/*"
            startActivity(intent6)
        }

        val openText: Button=findViewById(R.id.openText)
        openText.setOnClickListener{
            val intent7=Intent(Intent.ACTION_VIEW)
            intent7.type="text/plain"
            intent7.putExtra(Intent.EXTRA_TEXT,"Hey there!")
            startActivity(intent7)
        }


    }
}

