package br.com.mobflix.designsystem.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.mobflix.R
import br.com.mobflix.ui.theme.DarkBlue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomEditText(
    modifier: Modifier = Modifier,
    headerTitle: String,
    placeHolderText: String,
    onValueChange: (String) -> Unit = {}
) {
    val inputValue = remember { mutableStateOf(TextFieldValue()) }
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "${headerTitle.uppercase()}:",
            modifier = modifier.padding(horizontal = 16.dp),
            color = Color.White,
            fontFamily = FontFamily(Font(R.font.roboto_bold)),
            fontSize = 14.sp
        )
        TextField(
            value = inputValue.value,
            onValueChange = {
                inputValue.value = it
                onValueChange(it.text)
            },
            modifier = Modifier
                .padding(all = 16.dp)
                .clip(RoundedCornerShape(10.dp))
                .fillMaxWidth(),
            placeholder = {
                Text(
                    text = placeHolderText,
                    color = Color.Gray
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = DarkBlue,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                textColor = Color.White
            ),
            textStyle = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview
@Composable
fun CustomEditTextPreview() {
    CustomEditText(
        headerTitle = "url",
        placeHolderText = "Ex: N3h5A0oAzsk"
    )
}