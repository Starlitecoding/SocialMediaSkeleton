package kz.starlitecoding.postsapp.Pages.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kz.starlitecoding.postsapp.R
import kz.starlitecoding.postsapp.ui.theme.PostsAppTheme
import kz.starlitecoding.postsapp.ui.theme.fontFamily

@Composable
fun PostCard(
    modifier: Modifier = Modifier
        .background(color = Color.White)
        .padding(horizontal = 16.dp, vertical = 8.dp),

    ) {
    Card(
        modifier
            .height(165.dp)
            .fillMaxWidth()
            .clickable(onClick = { Unit }),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)

    ) {
        Column(modifier.padding(16.dp)) {
            Text(
                text = "Post Title",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF000000),
                fontFamily = fontFamily
            )

            Spacer(modifier.height(4.dp))

            Text(
                text = stringResource(R.string.lorem),
                fontSize = 16.sp,
                color = Color(0xFF979797),
                fontFamily = fontFamily
            )
        }
    }
}


@Preview
@Composable
fun cardPreview() {
    PostsAppTheme {
        PostCard()
    }
}
