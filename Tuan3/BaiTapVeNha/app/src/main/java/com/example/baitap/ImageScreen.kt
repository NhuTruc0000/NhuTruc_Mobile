package com.example.baitap

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.baitap.R
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.TextLinkStyles
@Composable
fun ImageScreen(onBack: () -> Unit) {
    val linkUrl = "https://giaothongvantaitphcm.edu.vn/wp-content/uploads/2025/01/Logo-GTVT.png" // Same URL for the link
    //val linkText = "https://giaothongvantaitphcm.edu.vn/wp-content/uploads/2025/01/Logo-GTVT.png" // Same URL for the link

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(27.dp)
    ) {
        Text(
            text = "< Back",
            color = Color.Blue,
            modifier = Modifier
                .clickable { onBack() }
                .padding(bottom = 16.dp)
        )
        Spacer(modifier = Modifier.height(40.dp))
        // Tiêu đề căn giữa
        Text(
            text = "Images",
            fontWeight = FontWeight.Bold,
            color = Color(0xFF2196F3),
            fontSize = 22.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 8.dp, bottom = 16.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.uth),
            contentDescription = "Jetpack Compose Logo",
            modifier = Modifier
                .width(336.dp)
                .height(189.dp)
        )
        Spacer(modifier = Modifier.height(25.dp))
        //val uriHandler = LocalUriHandler.current
        val annotatedString = buildAnnotatedString {
            pushLink(LinkAnnotation.Url(linkUrl, styles = TextLinkStyles(style = SpanStyle(textDecoration = TextDecoration.Underline, color = Color.Blue))))
            withStyle(
                style = SpanStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily.SansSerif, // Using a generic sans-serif for simplicity here
                    fontWeight = FontWeight.W400,
                    letterSpacing = (-0.02).em
                )
            ) {
                append(linkUrl) // The text of the link could be different from the URL itself
                // e.g., append("Visit GTVT Website")
            }
            pop()
        }
        Text(
            text = annotatedString,
            style = LocalTextStyle.current.merge( // Merge with current theme style or define fully
                TextStyle(
                    textAlign = TextAlign.Center,
                    lineHeight = 1.24.em,

                    )
            ),
            modifier = Modifier
                .width(303.dp)
                .align(Alignment.CenterHorizontally),

            )
        Spacer(modifier = Modifier.height(25.dp))
        Image(
            painter = painterResource(id = R.drawable.img), // Use painterResource
            contentDescription = "Jetpack Compose Logo",
            modifier = Modifier
                .width(336.dp) // Specific width
                .height(189.dp) // Specific height
                .clip(RoundedCornerShape(12.dp)) // Radius 12px

        )
        Spacer(modifier = Modifier.height(25.dp))
        // Chú thích dưới cùng
        Text(
            text = "In app",
            color = Color.Gray,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 24.dp)
        )
    }
}

@Composable
@Preview(showBackground = true)
fun ImageScreenPreview() {
    ImageScreen(onBack = {})
}