package br.com.mobflix.designsystem.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.mobflix.ui.theme.Purple40


@Composable
fun Fab(modifier: Modifier = Modifier, onClick: (() -> Unit)) {
    FloatingActionButton(
        modifier = modifier
            .padding(16.dp)
            .clip(RoundedCornerShape(50.dp)),
        onClick = { onClick() },
        containerColor = Purple40,
        contentColor = Color.White,
    ) {
        Icon(
            Icons.Filled.Add,
            "Floating action button.",
            modifier = Modifier.size(30.dp)
        )
    }
}

@Preview
@Composable
fun FabPreview() {
    Fab {
        
    }
}