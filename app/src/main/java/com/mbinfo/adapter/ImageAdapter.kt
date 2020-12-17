package com.mbinfo.adapter

import android.content.Context
import android.content.ContextWrapper
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mbinfo.mykot.R
import com.mbinfo.oumodel.RasterSize
import kotlinx.android.synthetic.main.item_pics.view.*
import kotlinx.coroutines.*
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream
import java.net.URL
import java.util.*


class ImageAdapter(var icons: MutableList<RasterSize>) :
    RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {
    private var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = ImageViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_pics, parent, false)

    )


    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        for (fruit in icons.get(position).formats) {
            print("$fruit ")
            val url: String = fruit.previewUrl
           context = holder.itemView.context
            try {
                // using for loop
                Glide.with(holder.itemView.getContext()).load(fruit.previewUrl)
                    .into(holder.image);


            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        holder.txt.setOnClickListener(View.OnClickListener {
            Toast.makeText(context, "image save to storage", Toast.LENGTH_SHORT).show()
            for (fruit in icons.get(position).formats) {
                print("$fruit ")
                val url: String = fruit.previewUrl
                val myURL = URL(url)
                // async task to get / download bitmap from url
                val result: Deferred<Bitmap?> = GlobalScope.async {
                    myURL.toBitmap()
                }
                GlobalScope.launch(Dispatchers.Main) {
                    // get the downloaded bitmap
                    val bitmap: Bitmap? = result.await()

                    // if downloaded then saved it to internal storage
                    bitmap?.apply {
                        // get saved bitmap internal storage uri
                        val savedUri: Uri? = saveToInternalStorage(context!!)

                    }
                }
            }

        })

    }
    fun Bitmap.saveToInternalStorage(context: Context):Uri? {


                // get the context wrapper instance
        val wrapper = ContextWrapper(context)

        // initializing a new file
        // bellow line return a directory in internal storage
        var file = wrapper.getDir("images", Context.MODE_PRIVATE)

        // create a file to save the image
        file = File(file, "${UUID.randomUUID()}.png")

        return try {
            // get the file output stream
            val stream: OutputStream = FileOutputStream(file)

            // compress bitmap
            compress(Bitmap.CompressFormat.PNG, 100, stream)

            // flush the stream
            stream.flush()

            // close stream
            stream.close()

            // return the saved image uri
            Uri.parse(file.absolutePath)
        } catch (e: IOException) { // catch the exception
            e.printStackTrace()
            null
        }

    }
    override fun getItemCount() = icons.size

    class ImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image = view.ivImage
        val down = view.download
        val txt = view.txt


    }
}

 fun URL.toBitmap():Bitmap? {
     return try {
BitmapFactory.decodeStream(openStream())
     }catch (e: IOException) {
null

     }
}


