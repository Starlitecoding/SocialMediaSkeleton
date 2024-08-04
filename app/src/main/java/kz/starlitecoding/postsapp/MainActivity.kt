package kz.starlitecoding.postsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kz.starlitecoding.postsapp.Pages.navBar.CustomBottomNavigationBar
import kz.starlitecoding.postsapp.Pages.components.PostCard
import kz.starlitecoding.postsapp.ui.theme.PostsAppTheme

class MainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PostsAppTheme {
                MainScreen(viewModel = mainViewModel)
            }
        }
    }
}

@Composable
fun MainScreen(viewModel: MainViewModel) {
    val navController = rememberNavController()
    val selectedIndex by viewModel.selectedIndex.collectAsState()

    Scaffold(
        bottomBar = {
            CustomBottomNavigationBar(selectedIndex) { index ->
                viewModel.onTabSelected(index)
                when (index) {
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
    PostsAppTheme {
        MainScreen(viewModel = MainViewModel())
    }
}