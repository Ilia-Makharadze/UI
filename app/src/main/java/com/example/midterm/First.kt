package com.example.midterm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout

class First : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val submitButton: Button = view.findViewById(R.id.button4)
        submitButton.setOnClickListener {
            val dialog = SubmitLeaveDialogFragment()
            dialog.show(parentFragmentManager, "SubmitLeaveDialog")
        }

        val tabLayout = view.findViewById<TabLayout>(R.id.tabLayout)

        tabLayout.addTab(tabLayout.newTab().setText("Review"))
        tabLayout.addTab(tabLayout.newTab().setText("Approved"))
        tabLayout.addTab(tabLayout.newTab().setText("Rejected"))

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                when (tab.position) {
                    0 -> updateBottomContent("Review")
                    1 -> updateBottomContent("Approved")
                    2 -> updateBottomContent("Rejected")
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }

    private fun updateBottomContent(status: String) {
        val borderLayout = view?.findViewById<LinearLayout>(R.id.border2)

        val title = borderLayout?.findViewById<TextView>(R.id.textView5)
        val subtitle = borderLayout?.findViewById<TextView>(R.id.textView9)
        val icon = borderLayout?.findViewById<TextView>(R.id.textView10)
        val hint = borderLayout?.findViewById<TextView>(R.id.textView11)

        when (status) {
            "Review" -> {
                title?.text = "Pending Leave"
                subtitle?.text = "Waiting for approval"
                hint?.text = "Please wait until manager approves your leave."
            }
            "Approved" -> {
                title?.text = "Approved Leave"
                subtitle?.text = "You're all set!"
                hint?.text = "Enjoy your time off."
            }
            "Rejected" -> {
                title?.text = "Rejected Leave"
                subtitle?.text = "Leave request was denied"
                hint?.text = "Try contacting HR for further details or resubmit."
            }
        }
    }
}
