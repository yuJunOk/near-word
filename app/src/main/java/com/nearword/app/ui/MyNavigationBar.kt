package com.nearword.app.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nearword.app.R

@Composable
public fun MyNavigationBar(selected: Int, onSelected: (Int) -> Unit) {
    Row (Modifier.background(MaterialTheme.colorScheme.background)){
        TabItem(if (selected == 0) R.drawable.ic_launcher_foreground else R.drawable.ic_launcher_background, "示例1",
            if (selected == 0) Color.Green else Color.Black,
            Modifier.weight(1f).clickable {
                onSelected(0)
            })
        TabItem(if (selected == 1) R.drawable.ic_launcher_foreground else R.drawable.ic_launcher_background, "示例2",
            if (selected == 1) Color.Green else Color.Black,
            Modifier.weight(1f).clickable {
                onSelected(1)
            })
        TabItem(if (selected == 2) R.drawable.ic_launcher_foreground else R.drawable.ic_launcher_background, "示例3",
            if (selected == 2) Color.Green else Color.Black,
            Modifier.weight(1f).clickable {
                onSelected(2)
            })
        TabItem(if (selected == 3) R.drawable.ic_launcher_foreground else R.drawable.ic_launcher_background, "示例4",
            if (selected == 3) Color.Green else Color.Black,
            Modifier.weight(1f).clickable {
                onSelected(3)
            })
    }
}

@Composable
private fun TabItem(@DrawableRes iconId: Int, title: String, tint: Color, modifier: Modifier = Modifier) {
    Column(modifier.padding(top = 10.dp, bottom = 6.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(painterResource(iconId), title, Modifier.size(24.dp), tint = tint)
        Text(title, fontSize = 11.sp, color = tint)
    }
}

@Preview
@Composable
private fun ShowBar(){
    MyNavigationBar(1) {

    }
}

@Preview
@Composable
private fun ShowTabItem(){
    TabItem(R.drawable.ic_launcher_foreground, "示例", MaterialTheme.colorScheme.error)
}