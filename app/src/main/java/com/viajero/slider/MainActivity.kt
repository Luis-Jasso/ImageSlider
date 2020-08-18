package com.viajero.slider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.viewpager2.widget.ViewPager2
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    lateinit var layoutDots: LinearLayout
    lateinit var textInfo: TextView
    lateinit var imageList: ArrayList<Int>
    lateinit var viewPagerSlider: ViewPager2
    private lateinit var adapter: SliderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var buttonSkip = findViewById<Button>(R.id.btnSkip)
        viewPagerSlider = findViewById(R.id.mViewPager2)
        layoutDots = findViewById(R.id.layoutDots)
        textInfo = findViewById(R.id.textInfo)

        imageList = ArrayList()

        imageList.add(R.drawable.img_uno)
        imageList.add(R.drawable.img_dos)
        imageList.add(R.drawable.img_tres)

        adapter = SliderAdapter(this, imageList)
        viewPagerSlider.adapter = adapter
        addDotsLayout()
        setIndicator(0)

        viewPagerSlider.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setIndicator(position)
            }
        })



    }

    private fun setIndicator(position:Int) {
        val childCount = layoutDots.childCount
        for (i in 0 until childCount){
            val imageView = layoutDots[i] as ImageView
            if (i == position){
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.select_dot
                    )
                )
            }else{
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.unselect_dot
                    )
                )
            }
        }
    }

    private fun addDotsLayout() {
        val indicator = arrayOfNulls<ImageView>(adapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
            WRAP_CONTENT,
            WRAP_CONTENT
        )
        layoutParams.setMargins(8, 8, 8, 0)

        for (i in indicator.indices){
            indicator[i] = ImageView(applicationContext)
            indicator[i].apply {
                this?.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.unselect_dot
                    )
                )
                this?.layoutParams = layoutParams
            }
            layoutDots.addView(indicator[i])
        }
    }
}