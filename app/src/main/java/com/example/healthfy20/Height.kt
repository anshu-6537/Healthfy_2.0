package com.example.healthfy20

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_height.*

class Height : AppCompatActivity() {

    val WIDTH_SCALE_RATIO = 10
    val HEIGHT_SCALE_RATIO = 10
    var heightstart=0
    var heightend=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_height)


        //Toast.makeText(this,"heightactivity",Toast.LENGTH_SHORT).show()

        val img = findViewById<ImageView>(R.id.height_image)

        var previousProcess = 0

        heightseekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                heighttext.text=progress.toString()
                val diff: Int = progress - previousProcess
                scaleImage(img, diff)
                previousProcess = progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                if(seekBar !=null)
                {
                    heightstart = seekBar.progress
                }
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                if(seekBar !=null)
                {
                    heightend = seekBar.progress
                    previousProcess=seekBar.progress
                }


                Toast.makeText(this@Height,"height increades by %${heightend-heightstart}", Toast.LENGTH_SHORT).show()
            }

        })


        var weightstart=0
        var weightend=0
        weightseekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                weighttext.text=progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                if(seekBar !=null)
                {
                    weightstart=seekBar.progress
                }
            }



            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                if(seekBar !=null)
                {
                    weightend=seekBar.progress
                }

                Toast.makeText(this@Height,"weight increades by %${weightend-weightstart}", Toast.LENGTH_SHORT).show()
            }

        })


        //Toast.makeText(this,heightend.toString(),Toast.LENGTH_SHORT).show()
        val click_me = findViewById<Button>(R.id.enter)
        //Toast.makeText(this,,Toast.LENGTH_SHORT).show()
        click_me.setOnClickListener {
            val intent = Intent(this,HomePage3::class.java)

            intent.putExtra("heightvalue", heightend.toString())
            intent.putExtra("weightvalue", weightend.toString())

            startActivity(intent)
        }
    }
    fun scaleImage(img: ImageView, scale: Int) {
        var bitmap = (img.drawable as BitmapDrawable).bitmap
        var width = bitmap.width.toFloat()
        var height = bitmap.height.toFloat()
        width += scale * WIDTH_SCALE_RATIO
        height += scale * HEIGHT_SCALE_RATIO
        bitmap = Bitmap.createScaledBitmap(
            bitmap, width.toInt(), height.toInt(),
            true
        )
        img.setImageBitmap(bitmap)
    }
}