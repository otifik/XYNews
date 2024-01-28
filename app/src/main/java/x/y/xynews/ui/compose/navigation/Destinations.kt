package x.y.xynews.ui.compose.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Description
import androidx.compose.ui.graphics.vector.ImageVector


const val NEWS_ROUTE = "newsRoute"
const val ACCOUNT_ROUTE = "accountRoute"
sealed class Destinations(
    val route: String,
    val title: String? = null,
    val icon: ImageVector? = null
) {
    object News : Destinations(
        route = "news",
        title = "新闻",
        icon = Icons.Outlined.Description
    )

    object Account : Destinations(
        route = "account",
        title = "个人中心",
        icon = Icons.Outlined.AccountCircle
    )

    object NewsDetail : Destinations(
        route = "newsDetail",
        title = null,
        icon = null
    )

    object History : Destinations(
        route = "history",
        title = null,
        icon = null
    )

    object Star : Destinations(
        route = "star",
        title = null,
        icon = null
    )

    object Info : Destinations(
        route = "info",
        title = null,
        icon = null
    )

    object Password : Destinations(
        route = "password",
        title = null,
        icon = null
    )

    object Policy : Destinations(
        route = "policy",
        title = null,
        icon = null
    )

    object AboutUs : Destinations(
        route = "aboutUs",
        title = null,
        icon = null
    )
}