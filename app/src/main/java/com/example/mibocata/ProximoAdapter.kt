package com.example.mibocataa

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.mibocata.R

class ProximoAdapter(
    private val context: Context,
    private val bocadillos: Map<String, List<String>>
) : BaseAdapter() {

    private val dias = bocadillos.keys.toList()

    override fun getCount(): Int {
        return dias.size
    }

    override fun getItem(position: Int): Any {
        val dia = dias[position]
        return bocadillos[dia] ?: listOf<String>()
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.item_proximo, parent, false)



        val dia = dias[position]
        val listaBocadillos = bocadillos[dia]

        val fechaTextView: TextView = view.findViewById(R.id.dia)
        fechaTextView.text = dia

        val bocadilloTextView: TextView = view.findViewById(R.id.descripcion)
        bocadilloTextView.text = listaBocadillos?.joinToString("\n") ?: "No disponible"



        return view
    }
}