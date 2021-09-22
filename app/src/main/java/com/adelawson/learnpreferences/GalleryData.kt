package com.adelawson.learnpreferences

data class GalleryImage (var imageID:Int)

object SampleImages{
    private val images = arrayListOf(R.drawable.wallpaper_1,R.drawable.wallpaper_3,R.drawable.wallpaper_4)
    private val images_2 = arrayListOf(R.drawable.solid_1,R.drawable.solid_2,R.drawable.solid_3,R.drawable.solid_4,
        R.drawable.solid_5,R.drawable.solid_6,R.drawable.solid_7,R.drawable.solid_8,R.drawable.solid_9,R.drawable.solid_10 )



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
    var list_2:ArrayList<GalleryImage>?= null
        get() {
            if (field!=null)
                return field
            field = ArrayList()
            for(i in images_2.indices){
                val image = images_2[i]
                val imageItem = GalleryImage(image)
                field!!.add(imageItem)
            }
            return field
        }
}