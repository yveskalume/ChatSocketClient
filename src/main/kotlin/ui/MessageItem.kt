package ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MessageItem(isSentByMe: Boolean = false) {
    val arrangement = if (isSentByMe) {
        Arrangement.End
    } else {
        Arrangement.Start
    }

    val color = if (isSentByMe) {
        Color.White
    } else {
        Color.Green
    }

    Row(modifier = Modifier.fillMaxWidth().wrapContentHeight(), horizontalArrangement = arrangement) {
        Card(
            modifier = Modifier.fillMaxWidth(0.5f),
            shape = RoundedCornerShape(8.dp),
            backgroundColor = color
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(0.5f)
                    .padding(16.dp)
                    .wrapContentHeight()
            ) {
                Text("Bonjour le monde", color = Color.Black)
            }
        }

    }
}