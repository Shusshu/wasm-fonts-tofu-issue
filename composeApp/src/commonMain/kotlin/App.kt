import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import mypackage.MyCustomTypography
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun App() {
    MaterialTheme(
        typography = MyCustomTypography,
    ) {
        TabNavigator(IntroTab) {
            Row() {
                NavigationRail(
                    containerColor = Color.Transparent,
                ) {
                    TabNavigationRailItem(IntroTab)
                    TabNavigationRailItem(IntroTab)
                }
                CurrentTab()
            }
        }
    }
}

@Composable
fun ColumnScope.TabNavigationRailItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current

    NavigationRailItem(
        icon = {
            tab.options.icon?.let { icon ->
                Icon(
                    painter = icon,
                    contentDescription = null
                )
            }
        },
        label = {
            Text(
                text = tab.options.title,
            )
        },
        selected = tabNavigator.current == tab,
        onClick = { tabNavigator.current = tab },
    )
}