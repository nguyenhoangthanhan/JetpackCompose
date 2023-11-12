package com.nguyenhoangthanhan.newsinshort.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.nguyenhoangthanhan.newsinshort.R
import com.nguyenhoangthanhan.newsinshort.data.entity.Article
import com.nguyenhoangthanhan.newsinshort.data.entity.NewsResponse
import com.nguyenhoangthanhan.newsinshort.data.entity.Source
import com.nguyenhoangthanhan.newsinshort.ui.theme.Purple40

@Composable
fun Loader() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        CircularProgressIndicator(
            modifier = Modifier
                .size(60.dp)
                .padding(10.dp),
            color = Purple40
        )
    }
}

@Composable
fun NewList(response: NewsResponse) {
    LazyColumn {
        items(response.articles) { article ->
            NormalTextComponent(textValue = article.title ?: "NA")
        }
    }
}

@Composable
fun NormalTextComponent(textValue: String) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(8.dp),
        text = textValue,
        style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily.Monospace,
            color = Purple40
        )
    )
}

@Composable
fun HeadingTextComponent(textValue: String, centerAligned: Boolean = false) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(8.dp),
        text = textValue,
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium
        ),
        textAlign = if (centerAligned) TextAlign.Center else TextAlign.Start
    )
}

@Composable
fun NewRowComponent(page: Int, article: Article) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
            .background(Color.White)
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp),
            model = article.urlToImage,
            contentDescription = "",
            contentScale = ContentScale.Crop,
            placeholder = painterResource(id = R.drawable.icon_image),
            error = painterResource(id = R.drawable.icon_image),
        )

        Spacer(modifier = Modifier.size(20.dp))

        HeadingTextComponent(textValue = article.title ?: "")

        Spacer(modifier = Modifier.size(10.dp))

        NormalTextComponent(textValue = article.description ?: "")

        Spacer(modifier = Modifier.weight(1f))

        AuthorDetailComponent(
            authorName = article.author,
            sourceName = article.source?.name
        )
    }
}

@Preview
@Composable
fun NewRowComponentPreview() {
    NewRowComponent(
        page = 11, article =
        (Article(
            Source("1", "name"),
            "author demo",
            "title demo",
            "description demo",
            "url demo",
            "https://www.reuters.com/resizer/YnvkTDGZl4VvXle_E_G-0vjDe3M=/1200x628/smart/filters:quality(80)/cloudfront-us-east-2.images.arcpublishing.com/reuters/SJNCMPUGS5JNXJPEVARQ557K3I.jpg",
            "publishat demo",
            "content demo"
        ))
    )
}

@Composable
fun AuthorDetailComponent(authorName: String? = "", sourceName: String? = "") {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 12.dp, end = 12.dp, bottom = 24.dp)
    ) {

        authorName?.let { Text(text = it) }

        Spacer(modifier = Modifier.weight(1f))

        sourceName?.let { Text(text = it) }

    }
}

@Composable
fun EmptyStateComponent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(
                id = R.drawable.icon_no_connection_blue
            ),
            contentDescription = null
        )

        HeadingTextComponent(
            textValue = stringResource(R.string.no_news_as_of_now_please_check_in_some_time),
            centerAligned = true
        )
    }
}

@Preview
@Composable
fun EmptyStateComponentPreview() {
    EmptyStateComponent()
}