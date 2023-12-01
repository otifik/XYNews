package x.y.xynews.extension

import android.content.Context
import android.widget.Toast

fun shortToast(context: Context, content: String) = Toast.makeText(context, content, Toast.LENGTH_SHORT).show()