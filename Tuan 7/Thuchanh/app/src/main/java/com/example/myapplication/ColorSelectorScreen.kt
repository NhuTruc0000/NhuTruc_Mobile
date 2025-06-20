package com.example.myapplication

@Composable
fun ColorSelectorScreen(viewModel: ColorViewModel) {
    val bgColor by viewModel.currentColor.collectAsState()

    val colors = listOf(
        0xFFFFCDD2.toInt(), // đỏ nhạt
        0xFFBBDEFB.toInt(), // xanh nhạt
        0xFFC8E6C9.toInt()  // xanh lá nhạt
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(bgColor))
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Chọn màu nền:", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(16.dp))

        Row(horizontalArrangement = Arrangement.SpaceEvenly) {
            colors.forEach { color ->
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Color(color))
                        .clickable { viewModel.setColor(color) }
                        .border(2.dp, if (color == bgColor) Color.Black else Color.Transparent, CircleShape)
                )
                Spacer(modifier = Modifier.width(16.dp))
            }
        }
    }
}
