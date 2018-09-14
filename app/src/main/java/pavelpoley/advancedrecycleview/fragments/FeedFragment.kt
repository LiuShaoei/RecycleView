package pavelpoley.advancedrecycleview.fragments


import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_feed.view.*
import pavelpoley.advancedrecycleview.R
import pavelpoley.advancedrecycleview.adapters.FeedAdapter
import pavelpoley.advancedrecycleview.model.FeedModel


class FeedFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_feed, container, false)

        var list = getDummyList()

        view.rv_main.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)

        view.rv_main.adapter = FeedAdapter(context as FragmentActivity,list)

        var h = Handler()
        h.postDelayed(Runnable {
            kotlin.run {
                list.add(FeedModel("我是刘召伟","你是谁"))
                view.rv_main.adapter.notifyDataSetChanged()
            }
        },5000)

        return view
    }

    private fun getDummyList(): ArrayList<FeedModel> {
        var list = ArrayList<FeedModel>()

        for (i in 1..10) {
            list.add(FeedModel("Dummy item " + i,"lzw"+i))
        }

        return list
    }


}
