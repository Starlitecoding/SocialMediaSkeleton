package kz.starlitecoding.posts.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kz.starlitecoding.posts.ui.Pages.components.PostCard
import kz.starlitecoding.posts.ui.Pages.navBar.CustomBottomNavigationBar
import kz.starlitecoding.posts.ui.theme.PostsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PostsTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    var selectedIndex by remember { mutableStateOf(0) }


    Scaffold(
        bottomBar = {
            CustomBottomNavigationBar(selectedIndex) {
                selectedIndex = it
                when (it) {
                    0 -> navController.navigate("home")
                    1 -> navController.navigate("albums")
                    2 -> navController.navigate("users")
                    3 -> navController.navigate("profile")
                }
            }
        }
    ) { innerPadding ->
        NavHost(navController, startDestination = "home", Modifier.padding(innerPadding)) {
            composable("home") { PostsScreen() }
            composable("albums") { AlbumsScreen() }
            composable("users") { UsersScreen() }
            composable("profile") { ProfileScreen() }
        }
    }
}

@Composable
fun PostsScreen() {

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        )
        {
            items(10) { PostCard() }

        }

    }
}

@Composable
fun AlbumsScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Albums Screen")
    }
}

@Composable
fun UsersScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Users Screen")
    }
}

@Composable
fun ProfileScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Profile Screen")
    }
}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PostsTheme {
        MainScreen()
    }
}