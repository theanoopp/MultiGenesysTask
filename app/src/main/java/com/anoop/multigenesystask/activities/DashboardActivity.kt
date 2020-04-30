package com.anoop.multigenesystask.activities

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.anoop.multigenesystask.R
import com.anoop.multigenesystask.adapters.BranchAdapter
import com.anoop.multigenesystask.adapters.SubjectAdapter
import com.anoop.multigenesystask.adapters.UniversityAdapter
import com.anoop.multigenesystask.glide.GlideApp
import com.anoop.multigenesystask.pojo.Branch
import com.anoop.multigenesystask.pojo.home.Data
import com.jama.carouselview.CarouselView
import com.jama.carouselview.enums.IndicatorAnimationType
import com.jama.carouselview.enums.OffsetType
import kotlinx.android.synthetic.main.activity_dashboard.*
import java.util.*


class DashboardActivity : AppCompatActivity() {

    private lateinit var homeData: Data

    private lateinit var branchData: Branch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        homeData = intent.getParcelableExtra("homeData")
        branchData = intent.getParcelableExtra("branchData")

        val c: Calendar = Calendar.getInstance()

        when (c.get(Calendar.HOUR_OF_DAY)) {
            in 0..11 -> greeting_text.text = "Good Morning,"
            in 12..15 -> greeting_text.text = "Good Afternoon,"
            in 16..23 -> greeting_text.text = "Good Evening,"
        }

        name_text.text = homeData.profile.name

        val carouselView = findViewById<CarouselView>(R.id.imageSlider)

        carouselView.apply {
            size = homeData.ads.size
            resource = R.layout.image_slider_layout_item
            autoPlay = true
            indicatorAnimationType = IndicatorAnimationType.THIN_WORM
            carouselOffset = OffsetType.CENTER
            setCarouselViewListener { view, position ->
                val imageView = view.findViewById<ImageView>(R.id.iv_auto_image_slider)
                GlideApp.with(this@DashboardActivity).load(homeData.ads[position].url).into(imageView)

            }
            show()
        }

        subject_list.setHasFixedSize(true)
        subject_list.layoutManager = GridLayoutManager(this,2)
        subject_list.recycledViewPool.setMaxRecycledViews(1, 0)
        subject_list.adapter = SubjectAdapter(homeData.subjects, this@DashboardActivity)

        branch_list.setHasFixedSize(true)
        branch_list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        branch_list.recycledViewPool.setMaxRecycledViews(1, 0)
        branch_list.adapter = BranchAdapter(branchData.data, this@DashboardActivity)


        universities_list.setHasFixedSize(true)
        universities_list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        universities_list.recycledViewPool.setMaxRecycledViews(1, 0)
        universities_list.adapter = UniversityAdapter(homeData.universities, this@DashboardActivity)

    }
}
