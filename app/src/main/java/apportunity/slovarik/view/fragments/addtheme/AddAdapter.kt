package apportunity.slovarik.view.fragments.addtheme

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import apportunity.slovarik.R
import apportunity.slovarik.model.dbmodel.DictionaryWordModel

class AddAdapter(val wordOfTheme: List<DictionaryWordModel>) :
    RecyclerView.Adapter<AddAdapter.AddHolder>() {

    class AddHolder(item: View) : RecyclerView.ViewHolder(item) {
        var native: TextView = item.findViewById(R.id.nativeWordsColumnName)
        var transcription: TextView = item.findViewById(R.id.transcriptionColumnName)
        var translation: TextView = item.findViewById(R.id.translationColumnName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.learn_item, parent, false)
        return AddHolder(view)
    }

    override fun getItemCount() = wordOfTheme.size

    override fun onBindViewHolder(holder: AddHolder, position: Int) {
        var word = wordOfTheme[position]
        holder.native.text = word.russian
        holder.transcription.text = word.transcription
        holder.translation.text = word.english
    }

}