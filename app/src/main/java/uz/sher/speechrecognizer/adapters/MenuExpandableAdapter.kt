package uz.sher.speechrecognizer.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import uz.sher.speechrecognizer.R
import uz.sher.speechrecognizer.model.analysis_speech.ChildExpandable
import uz.sher.speechrecognizer.model.analysis_speech.ParentExpandable

class MenuExpandableAdapter(
    private val context: Context,
    private val title: MutableList<ParentExpandable>,
    private val subItem: MutableList<MutableList<ChildExpandable>>
):BaseExpandableListAdapter(){
    private var listener:OnUserClickListener?=null
    override fun getGroupCount(): Int {
        return title.size
    }

    override fun getChildrenCount(groupPosition: Int): Int {
     return subItem[groupPosition].size
    }

    override fun getGroup(groupPosition: Int): Any {
        return title[groupPosition]

    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        return subItem[groupPosition][childPosition]
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        var view=convertView
        if(view==null){
            val inflater: LayoutInflater =context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)as LayoutInflater
            view=inflater.inflate(R.layout.expandable_layout,null)
        }
        val textview=view?.findViewById<TextView>(R.id.parentTitle)
        textview!!.text=title[groupPosition].textTitle

        return view!!
    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        var view=convertView
        if(view==null){
            val inflater:LayoutInflater=context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)as LayoutInflater
            view=inflater.inflate(R.layout.child_layout,null)
        }

        val textSubTitle=view?.findViewById<TextView>(R.id.childTitle)
        textSubTitle!!.text=subItem[groupPosition][childPosition].childText

        view!!.setOnClickListener{
          listener?.onUserClickListener(groupPosition,childPosition)
        }

        return view!!
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }
    fun setonUserClickListener(listener:OnUserClickListener){
        this.listener=listener
    }
    interface OnUserClickListener{
        fun onUserClickListener(parentPosition: Int,childPosition: Int)

    }
}