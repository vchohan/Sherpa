package com.delaware.data.sherpa

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class SearchFragment : Fragment() {

    companion object {
        fun newInstance() = SearchFragment()
    }

    var mListener: OnButtonClickedListenter? = null
    interface OnButtonClickedListenter{
        fun onButtonClicked()
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mListener = context as? OnButtonClickedListenter
        if (mListener == null) {
            throw ClassCastException("$context must implement OnButtonCLickedListener")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.search_fragment_v2, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val textView = view.findViewById<TextView>(R.id.button)
        textView.setOnClickListener(View.OnClickListener {
            mListener!!.onButtonClicked()
        })
    }
}
