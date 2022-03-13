package com.tolgakurucay.kotlincatchthekenny

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random as Random1

class MainActivity : AppCompatActivity() {

var imageArray=ArrayList<ImageView>()
var score:Int=0
    var handler=Handler()
    var runnable=Runnable{}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startTime()



            imageArray.add(imageView1)
            imageArray.add(imageView2)
            imageArray.add(imageView3)
            imageArray.add(imageView4)
            imageArray.add(imageView5)
            imageArray.add(imageView6)
            imageArray.add(imageView7)
            imageArray.add(imageView8)
            imageArray.add(imageView9)
            imageArray.add(imageView10)
            imageArray.add(imageView11)
            imageArray.add(imageView12)
            imageArray.add(imageView13)
            imageArray.add(imageView14)
            imageArray.add(imageView15)
            imageArray.add(imageView16)


hideImages()





    }


    fun startTime()
    {
        object :CountDownTimer(30000,1000)
        {
            override fun onFinish() {

                textViewTime.text="Finish Game"
                handler.removeCallbacks(runnable)
                for (image in imageArray)
                {
                    image.visibility=View.INVISIBLE
                }
                val alert = AlertDialog.Builder(this@MainActivity)
                alert.setTitle("Game Over")
                alert.setMessage("Restart the game?")
                alert.setPositiveButton("Yes"){
                    dialog,which->//restart
                    val intent=intent
                    finish()
                    startActivity(intent)
                }
                alert.setNegativeButton("No"){
                    dialog,which->Toast.makeText(this@MainActivity,"Game Over",Toast.LENGTH_LONG).show()
                }
                alert.show()
            }

            override fun onTick(p0: Long) {
                textViewTime.text="Time : ${p0/1000}"

            }
        }.start()


    }


    fun increaseScore(view: View)
    {
        score+=1
        textViewScore.text="Score : ${score.toString()}"
    }

    fun hideImages()
    {
        runnable=object :Runnable{
            override fun run() {
                for(image in imageArray)
                {
                    image.visibility=View.INVISIBLE
                }
                val random= Random()
                val randomIndex=random.nextInt(16)
                imageArray[randomIndex].visibility=View.VISIBLE
                handler.postDelayed(runnable,450)

            }
        }
        handler.post(runnable)



    }







    }
