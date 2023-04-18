package ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    var messageText by remember {
        mutableStateOf("")
    }
    Scaffold(topBar = {
        TopAppBar(
            navigationIcon = {
                IconButton(onClick = { navController.navigateBack() }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                }
            },
            title = { Text("KipushiToujour 🔥") }
        )
    }
    ) {
        Row(modifier = Modifier.fillMaxSize().padding(it)) {
            LazyColumn(
                modifier = Modifier.fillMaxWidth().weight(3.4f),
                contentPadding = PaddingValues(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(20) {
                    ConversationItem(modifier = Modifier, onClick = { })
                    Spacer(modifier = Modifier.height(8.dp))
                    Divider(modifier = Modifier.width(2.dp))
                }
            }

            Divider(modifier = Modifier.size(1.dp).weight(0.2f))

            Column(modifier = Modifier.fillMaxWidth().weight(6.4f).background(Color.LightGray)) {
                LazyColumn(
                    modifier = Modifier.padding(8.dp).weight(1f),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    item {
                        MessageItem()
                    }
                    item {
                        MessageItem()
                    }

                    item {
                        MessageItem(isSentByMe = true)
                    }

                    item {
                        MessageItem()
                    }

                    item {
                        MessageItem(isSentByMe = true)
                    }

                    item {
                        MessageItem()
                    }

                    item {
                        MessageItem(isSentByMe = true)
                    }

                    item {
                        MessageItem(isSentByMe = true)
                    }

                    item {
                        MessageItem(isSentByMe = true)
                    }

                    item {
                        MessageItem(isSentByMe = true)
                    }

                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(8.dp)
                        .zIndex(10f),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    OutlinedTextField(
                        shape = RoundedCornerShape(32.dp),
                        value = messageText,
                        onValueChange = { value -> messageText = value },
                        placeholder = {
                            Text(text = "Message")
                        },
                        modifier = Modifier.weight(1f).padding(2.dp)
                    )
                    FloatingActionButton(onClick = {}, modifier = Modifier.size(56.dp)) {
                        Icon(
                            imageVector = Icons.Default.Send,
                            contentDescription = null,
                        )
                    }
                }
            }
        }
    }
}