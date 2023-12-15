package br.com.mobflix

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.mobflix.designsystem.pills.CategoryPills
import br.com.mobflix.ui.dimens.dimens
import br.com.mobflix.ui.theme.DarkBackgroundColor
import br.com.mobflix.ui.theme.Green
import br.com.mobflix.ui.theme.LightBlue
import br.com.mobflix.ui.theme.LightRed
import br.com.mobflix.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = DarkBackgroundColor
                ) {
                    PillList()
                }
            }
        }
    }

    @Composable
    fun PillList() {
        val scrollState = rememberScrollState()
        Row(
            modifier = Modifier
                .horizontalScroll(scrollState)
                .padding(MaterialTheme.dimens.medium)
        ) {
            CategoryPills(title = "Front End", color = LightBlue)
            Spacer(modifier = Modifier.width(MaterialTheme.dimens.small))
            CategoryPills(title = "Programação", color = Green)
            Spacer(modifier = Modifier.width(MaterialTheme.dimens.small))
            CategoryPills(title = "Mobile", color = LightRed)
            Spacer(modifier = Modifier.width(MaterialTheme.dimens.small))
            CategoryPills(title = "Front End", color = LightBlue)
            Spacer(modifier = Modifier.width(MaterialTheme.dimens.small))
            CategoryPills(title = "Programação", color = Green)
            Spacer(modifier = Modifier.width(MaterialTheme.dimens.small))
            CategoryPills(title = "Mobile", color = LightRed)
        }
    }

    @Preview
    @Composable
    fun PillListPreview() {
        PillList()
    }
}