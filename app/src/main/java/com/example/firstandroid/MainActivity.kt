package com.example.firstandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstandroid.ui.theme.FirstAndroidTheme
import java.text.NumberFormat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FirstAndroidTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {


                    MyApp()
                }
            }
        }
    }
}


@Composable
fun TipTextAndFiled(modifier: Modifier = Modifier) {
    var billAmount by remember { mutableStateOf("") }

    var percent by remember { mutableStateOf("") }

    val amount = billAmount.toDoubleOrNull() ?: 0.0
    val percentage = percent.toDoubleOrNull() ?: 0.0
    val tip = calculateTip(amount, percentage)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 30.dp)
            .verticalScroll(
                rememberScrollState()
            )
            .safeDrawingPadding()
    ) {
        Text(
            text = stringResource(R.string.calculate_tip),
            fontSize = 18.sp
        )

        //bill amount filed
        TextFiledWithIcon(
            amount= billAmount,
            label = stringResource(R.string.bill_amount),
            onValueChanged = { billAmount = it },
            modifier = modifier
        )

        //percentage filed
        TextFiledWithIcon(
            amount= percent,
            label = stringResource(R.string.tip_percent),
            onValueChanged = { percent = it },
            modifier = modifier
        )

        Spacer(modifier = modifier.height(50.dp))

        Text(
            text = stringResource(R.string.tip_amount, tip),
            style = MaterialTheme.typography.displaySmall

        )

    }
}

@Composable
private fun TextFiledWithIcon(
    amount: String,
    label: String,
    onValueChanged: (String) -> Unit,
    modifier: Modifier
) {

    TextField(
        value = amount,
        label = { Text(text = label) },
        onValueChange = onValueChanged,
        modifier = modifier.padding(all = 8.dp)
    )
}

private fun calculateTip(amount: Double, tipPercent: Double ): String {
    val tip = tipPercent / 100 * amount

    return NumberFormat.getCurrencyInstance().format(tip)
}

@Preview(showBackground = true)
@Composable
fun MyApp() {
    FirstAndroidTheme {

        TipTextAndFiled()
    }
}