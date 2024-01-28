package x.y.xynews.ui.compose.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigation
import x.y.xynews.ui.compose.screen.account.AccountScreen
import x.y.xynews.ui.compose.screen.account.aboutus.AboutUsScreen
import x.y.xynews.ui.compose.screen.account.history.HistoryScreen
import x.y.xynews.ui.compose.screen.account.policy.PolicyScreen
import x.y.xynews.ui.compose.screen.account.star.StarScreen
import x.y.xynews.ui.compose.screen.news.NewsDetailScreen
import x.y.xynews.ui.compose.screen.news.NewsListScreen
import x.y.xynews.viewmodel.MainActivityViewModel

@Composable
fun BottomBar(
    navController: NavHostController, modifier: Modifier = Modifier
) {
    val screens = listOf(
        Destinations.News, Destinations.Account
    )

    NavigationBar(
        modifier = modifier
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        screens.forEach { screen ->

            NavigationBarItem(
                label = {
                    Text(text = screen.title!!,color = Color.Black)
                },
                icon = {
                    Icon(imageVector = screen.icon!!, contentDescription = "")
                },
                selected = currentRoute == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }

                },
                colors = NavigationBarItemDefaults.colors(
                    unselectedTextColor = Color.Gray, selectedTextColor = Color.White
                ),
            )
        }
    }

}

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = Destinations.News.route) {

//        newsNavigationGraph(navController)
//
//        accountNavigationGraph(navController)

        composable(Destinations.News.route) {
            NewsListScreen(navController)
        }
        composable(Destinations.NewsDetail.route) { backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry(Destinations.News.route)
            }
            val parentViewModel = hiltViewModel<MainActivityViewModel>(parentEntry)
            NewsDetailScreen(navController, parentViewModel)
        }

        composable(Destinations.Account.route) {
            AccountScreen(navController)
        }

        composable(Destinations.History.route) {
            HistoryScreen(navController)
        }

        composable(Destinations.Star.route) {
            StarScreen(navController)
        }

        composable(Destinations.Policy.route) {
            PolicyScreen(navController)
        }
        composable(Destinations.AboutUs.route) {
            AboutUsScreen(navController)
        }
    }
}

fun NavGraphBuilder.newsNavigationGraph(navController: NavHostController) {
    navigation(startDestination = Destinations.News.route, route = NEWS_ROUTE) {
        composable(Destinations.News.route) {
            NewsListScreen(navController)
        }
        composable(Destinations.NewsDetail.route) { backStackEntry ->
            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry(Destinations.News.route)
            }
            val parentViewModel = hiltViewModel<MainActivityViewModel>(parentEntry)
            NewsDetailScreen(navController, parentViewModel)
        }
    }
}

fun NavGraphBuilder.accountNavigationGraph(navController: NavHostController) {
    navigation(startDestination = Destinations.Account.route, route = ACCOUNT_ROUTE) {
        composable(Destinations.Account.route) {
            AccountScreen(navController)
        }

        composable(Destinations.History.route) {
            HistoryScreen(navController)
        }

        composable(Destinations.Star.route) {
            StarScreen(navController)
        }

        composable(Destinations.Policy.route) {
            PolicyScreen(navController)
        }
    }
}