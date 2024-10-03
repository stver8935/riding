package com.stver8935.riding.ui.home

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stver8935.riding.R
import com.stver8935.riding.ui.BaseActivity
import com.stver8935.riding.ui.theme.RidingTheme
import com.stver8935.riding.ui.theme.fontTitle
import com.stver8935.riding.ui.theme.uiWhitespaceLarge
import com.stver8935.riding.ui.theme.uiWhitespaceSmall

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RidingTheme {
                MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

//-- study
@Composable
fun MyApp(modifier: Modifier = Modifier){
    var shouldOnBoarding by rememberSaveable { mutableStateOf(true) }
    Surface(modifier){
        if(shouldOnBoarding)
            OnBoardingScreen(onContinueClicked = { shouldOnBoarding = false})
        else
            Greetings()
    }
}

@Composable
fun Greetings(
    modifier: Modifier = Modifier,
    //names: List<String> = listOf("World","Compose")
    names: List<String> = List(1000) {"$it"}
){
    LazyColumn(
        modifier = modifier.padding(dimensionResource(R.dimen.ui_whitespace_small))
    ){
        items(items = names) {
            name ->
            Greeting(name = name)
        }
    }
}

@Composable
private fun Greeting(name: String, modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(false) }

//    val extraPadding = if (expanded) 48.dp else 0.dp

    val colorAnim by animateColorAsState(
        targetValue = if(expanded) Color.Red else Color.Blue,
        animationSpec = keyframes {
            durationMillis = 500
            Color.Blue at 100
        }
    )

    val extraPadding by animateDpAsState(
        if(expanded) uiWhitespaceLarge else uiWhitespaceSmall,
        keyframes {
            durationMillis = 500 // 애니메이션 전체 지속 시간
            if (expanded) {
                100.dp at 100
                300.dp at 300  // 300ms 후에 170dp로 변경
            }else{
                100.dp at 300
                300.dp at 100
            }

        }
    )

    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier.padding(
            vertical = dimensionResource(R.dimen.ui_whitespace_small),
            horizontal = dimensionResource(R.dimen.ui_whitespace_medium)
        )
    ) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = extraPadding)
            ) {
                Text(text = "Hello, ")
                Text(text = name)
            }
            ElevatedButton(
                onClick = { expanded = !expanded }
            ) {
                Text(if (expanded) "Show less" else "Show more")
            }
        }
    }
}

@Composable
fun OnBoardingScreen(
    onContinueClicked: () -> Unit,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("welcome to the Basics Codelab")
        Button(
            modifier = Modifier.padding(vertical = dimensionResource(R.dimen.ui_whitespace_large)),
            onClick = onContinueClicked
        ){
            Text("Continues")
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 320,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "MyAppDarkMode"
)
@Preview(showBackground = true, widthDp = 320)
@Composable
fun GreetingPreview() {
    RidingTheme {
        Greeting(" Hero ")
    }
}


@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnBoardingPreview(){ OnBoardingScreen(onContinueClicked = {}) }


@Preview(
    showBackground = true,
    widthDp = 320,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "MyAppDarkMode"
)
@Preview(showBackground = true)
@Composable
fun MyAppPreView() {
    RidingTheme {
        MyApp(Modifier.fillMaxSize())
    }
}

@Preview
@Composable
fun GreetingsPreView(){
    RidingTheme{
        Greetings()
    }
}