package com.adelawson.learnpreferences

data class GalleryImage (var imageID:Int)

object SampleImages{
    private val images = arrayListOf(R.drawable.wallpaper_1,R.drawable.wallpaper_3,R.drawable.wallpaper_4)



    var list:ArrayList<GalleryImage>?= null
        get() {
            if (field!=null)
                return field
            field = ArrayList()
            for(i in images.indices){
                val image = images[i]
                val imageItem = GalleryImage(image)
                field!!.add(imageItem)
            }
            return field
        }
}