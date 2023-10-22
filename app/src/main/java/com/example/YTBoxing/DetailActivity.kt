package com.example.YTBoxing


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Button
import android.content.Intent
import com.example.YTBoxing.data.Datasource


class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "Detail of Boxers"
        setContentView(R.layout.activity_detail)

        val NamaBoxerText = intent.getStringExtra("affirmationText")
        val imageResourceId = intent.getIntExtra("imageResourceId", 0)

        val datasource = Datasource()
        val affirmations = datasource.loadAffirmations()

        // Here, you can access the additional text from the Affirmation object
        val additionalText = getString(affirmations[3].additionalText) // Change the index as needed

        //me-Tampilkan ke XML
        val detailImage = findViewById<ImageView>(R.id.detail_image)
        val detailText = findViewById<TextView>(R.id.detail_text)
        val additionalTextView = findViewById<TextView>(R.id.additional_text)

        detailText.text = NamaBoxerText
        detailImage.setImageResource(imageResourceId)
        additionalTextView.text = additionalText

        val backButton = findViewById<Button>(R.id.back_to_main_button)

        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}

