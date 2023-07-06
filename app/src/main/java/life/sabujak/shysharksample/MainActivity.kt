package life.sabujak.shysharksample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import life.sabujak.shyshark.ShySharkLayoutManager.Companion.SWIPE_BOTTOM
import life.sabujak.shyshark.ShySharkLayoutManager.Companion.SWIPE_LEFT
import life.sabujak.shyshark.ShySharkLayoutManager.Companion.SWIPE_RIGHT
import life.sabujak.shyshark.ShySharkLayoutManager.Companion.SWIPE_TOP
import life.sabujak.shyshark.ShySharkView
import life.sabujak.shyshark.listener.OnSwipeListener

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<ShySharkView>(R.id.recyclerView)

        recyclerView.adapter = SimpleAdapter(
            arrayListOf(
                R.drawable.shyshark_1,
                R.drawable.shyshark_2,
                R.drawable.shyshark_3,
                R.drawable.shyshark_4,
                R.drawable.shyshark_5,
                R.drawable.shyshark_6,
                R.drawable.shyshark_7,
                R.drawable.shyshark_8,
                R.drawable.shyshark_9
            )
        )
        recyclerView.setOnSwipeListener(object :
            OnSwipeListener {
            override fun onSwiped(position: Int, direction: Int) {
                when (direction) {
                    SWIPE_LEFT -> {
                        println("swiped LEFT!! $position")
                    }
                    SWIPE_RIGHT -> {
                        println("swiped RIGHT $position")
                    }
                    SWIPE_TOP -> {
                        println("swiped TOP $position")
                    }
                    SWIPE_BOTTOM -> {
                        println("swiped BOTTOM $position")
                    }
                }
            }

            override fun onChangeHorizontalDrag(direction: Int, percent: Float) {
                println("changeHorizontalDrag $direction $percent")
            }

            override fun onChangeVerticalDrag(direction: Int, percent: Float) {
                println("changeVerticalDrag $direction $percent")
            }
        })

        val fabMainGood = findViewById<FloatingActionButton>(R.id.fab_main_good)
        fabMainGood.setOnClickListener {
            recyclerView.performSwipe(SWIPE_RIGHT)
        }

        val fabMainBad = findViewById<FloatingActionButton>(R.id.fab_main_bad)
        fabMainBad.setOnClickListener {
            recyclerView.performSwipe(SWIPE_LEFT)
        }

        val fabMainNext = findViewById<FloatingActionButton>(R.id.fab_main_next)
        fabMainNext.setOnClickListener {
            recyclerView.nextView()
        }

        val fabMainPrevious = findViewById<FloatingActionButton>(R.id.fab_main_previous)
        fabMainPrevious.setOnClickListener {
            recyclerView.previousView()
        }
    }
}
