package ru.nsu.geochat.modules.activity.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_create.view.*
import ru.nsu.geochat.R
import ru.nsu.geochat.models.Chat

class CreateFragment: Fragment(), ICreateView {

    private lateinit var presenter: ICreatePresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_create, container, false)

        view.createButton.setOnClickListener {
            if (view.titleField.text.isNotEmpty()) {
                presenter.createChat(Chat(id = "",
                    title = view.titleField.text.toString(),
                    description = view.descriptionField.text.toString(),
                    destination = view.destinationBar.progress.toString(),
                    lastAuthor = "",
                    lastMessage = ""))
            } else {
                Toast.makeText(context, "Description must be not empty", Toast.LENGTH_SHORT).show()
            }
        }

        view.textViewBar.text = view.destinationBar.progress.toString()
        view.destinationBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                //Nothing to do
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
               //Nothing to do
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                view.textViewBar.text = seekBar?.progress.toString()
            }

        })

        return view
    }

    override fun onChatCreated() {
        activity?.finish()
    }

    override fun onError() {
        Toast.makeText(context, "Error while creating", Toast.LENGTH_SHORT).show()
    }

    override fun setPresenter(presenter: ICreatePresenter) {
        this.presenter = presenter
    }
}