package apportunity.slovarik.view.fragments.dictionary

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import apportunity.slovarik.R
import apportunity.slovarik.model.dbmodel.DictionaryWithWords


class DictionaryAdapter(var itemClickListener: DictionaryFragment):
RecyclerView.Adapter<DictionaryAdapter.DictionaryHolder>() {

    private var dictionaryThemes = emptyList<DictionaryWithWords>()

    class DictionaryHolder(item: View) : RecyclerView.ViewHolder (item){
        var title: TextView = item.findViewById(R.id.themeNameItem)
        var bestResult: TextView = item.findViewById(R.id.bestResultThemeItem)

        fun bind(theme: DictionaryWithWords, clickListener: DictionaryFragment){
            itemView.setOnClickListener {

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DictionaryHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.dictionary_item, parent, false)
        return DictionaryHolder(view)
    }

    override fun getItemCount() = dictionaryThemes.size

    override fun onBindViewHolder(holder: DictionaryHolder, position: Int) {
        val theme = dictionaryThemes[position]
        holder.title.text = theme.dictionaryTheme?.name
        holder.bestResult.text = theme.dictionaryTheme?.bestStats.toString()

        holder.bind(theme, itemClickListener)
    }

    fun setData(themes: List<DictionaryWithWords>){
        this.dictionaryThemes = themes
    }

    interface onItemClickListener{
        fun onItemClick(theme: DictionaryWithWords)
    }

}