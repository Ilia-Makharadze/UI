package com.example.midterm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup



class DialogFragment : Fragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireContext())
            .setTitle("Submit Leave")
            .setMessage("Are you sure you want to submit a leave?")
            .setPositiveButton("Yes") { dialog, _ ->
                Toast.makeText(requireContext(), "Leave submitted!", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }
            .create()
    }

}