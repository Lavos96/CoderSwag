package com.kowalczyk.michal.coderswag.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.kowalczyk.michal.coderswag.Model.Category
import com.kowalczyk.michal.coderswag.R

class CategoryAdapter(val context: Context, val categories: List<Category>): BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val categoryView:View
        val holder:ViewHolder

        //jesli convertview jest pusty to go zainicjuj
        if(convertView==null) {
            //LayoutInflater przerabia ten pliczek xml zeby mogl z niego korzystac prz tworzeniu listview
            categoryView=LayoutInflater.from(context).inflate(R.layout.category_list_item,null)
            //stworzenie ViewHoldera po to zeby obliczenia nie robily sie po kazdym przewiniecu listy
            //
            holder=ViewHolder()
            //przypisanie do categoryView holdera categoryView z orginalnego widoku(categoryView ktory przy pomocy LayoutInflatera
            // przerobil plik xml category_list_item na swoj uzytek)
            holder.categoryImage=categoryView.findViewById(R.id.categoryImage)
            holder.categoryName=categoryView.findViewById(R.id.categoryName)

            //nadanie unikatowego id (taga) dla categoryView ktory bedzie rowny holderowi
            categoryView.tag=holder
        }else{
            holder=convertView.tag as ViewHolder
            categoryView=convertView
        }

        val category=categories[position]
        //pobranie id konkretnego jednego elementy ListView
        val resourceId=context.resources.getIdentifier(category.image,"drawable",context.packageName)
        holder.categoryImage?.setImageResource(resourceId)

        holder.categoryName?.text=category.title

        return categoryView
    }

    override fun getItem(position: Int): Any {
       return categories[position]
    }

    override fun getItemId(position: Int): Long {
       return 0
    }

    override fun getCount(): Int {
       return categories.count()
    }
//stworzenie klasy ViewHoldera pozwala ona ponownie uzywac te elementy ListView ktore juz byly wczesniej wczytane
    //jest on robiony zeby za kazdym razem sie nie musialo od nowa generowac
    private class ViewHolder{
    //w tym pliku xml (widoku) jest obrazek categoryImage oraz text categoryName
        var categoryImage:ImageView?=null
        var categoryName:TextView?=null
    }
}