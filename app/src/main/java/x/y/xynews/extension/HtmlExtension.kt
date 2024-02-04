package x.y.xynews.extension

import android.text.method.ScrollingMovementMethod
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Scroller
import android.widget.TextView
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.HtmlCompat

@Composable
fun Html(text: String) {
    AndroidView(factory = { context ->
        TextView(context).apply {
            setText(HtmlCompat.fromHtml(text, HtmlCompat.FROM_HTML_MODE_LEGACY))
            isVerticalScrollBarEnabled = true
            movementMethod = ScrollingMovementMethod.getInstance()
        }
    })
}

@Composable
fun WebViewPage(url: String) {

    val context = LocalContext.current

    AndroidView(factory = { ctx ->
        WebView(ctx).apply {
            webViewClient = WebViewClient()
            loadUrl(url)
        }
    })
}