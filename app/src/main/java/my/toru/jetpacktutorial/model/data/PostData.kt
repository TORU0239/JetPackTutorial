package my.toru.jetpacktutorial.model.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PostData(val userId:String,
                    val id:String,
                    val title:String,
                    val body:String):Parcelable