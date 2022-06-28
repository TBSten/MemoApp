package dev.tbsten.memoappcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.tbsten.memoappcompose.ui.theme.MemoAppComposeTheme

class TestActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      MemoAppComposeTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
          Test()
        }
      }
    }
  }

  @Composable
  fun Test() {
    Column (modifier = Modifier
      .fillMaxSize()
    ){
//    ColorTest()
//    TypoTest()
//    SpaceTest()
//    ForTest(30)
//    IfTest(condition = true)
//    IfTest(condition = false)
//    DividerTest()
      StateTest()
    }

  }

  @Composable
  fun StateTest(){
    var inputText by remember { mutableStateOf<String>("") }
    var outputText by remember { mutableStateOf<String>("") }

    LaunchedEffect(""){
      Log.d("","effect")
    }
    Log.d("","func")

    Column(
      modifier = Modifier.fillMaxSize(),
      horizontalAlignment = Alignment.CenterHorizontally,
    ){
      OutlinedTextField(
        modifier = Modifier
          .fillMaxWidth()
          .height(100.dp),
        value = inputText,
        onValueChange = {
          inputText = it
        },
        label = { Text("Name") },
        maxLines = 3,
      )
      Button(
        content = { Text("Click") },
        onClick = {
          if(outputText == ""){
            outputText = "名前を入力して下さい"
            return@Button
          }
          outputText = "こんにちは $inputText"
        }
      )
      Text(
        text = outputText,
        style = MaterialTheme.typography.h2
      )
    }
  }


  @Composable
  fun DividerTest(){
    Divider()
    Text(
      text="X".repeat(10),
      style=MaterialTheme.typography.h1
    )
  }

  @Composable
  fun IfTest(condition:Boolean){
    Row {
      Text("IfTest")
      if (condition){
        Text(text = "YES")
      }else{
        Text(text = "No")
      }
    }
  }

  @Composable
  fun ForTest(count:Int){
    Column {
      Text(text = "ForTest")
      Column(modifier = Modifier.padding(start = (8*2).dp)){
        for(i in 1..count){
          Text(text = i.toString())
        }
      }
    }
  }

  @Composable
  fun TypoTest(){
    Column {
      Text(
        text = "h1 text",
        style = MaterialTheme.typography.h1,
      )
      Text(
        text = "h2 text",
        style = MaterialTheme.typography.h2,
      )
      Text(
        text = "body1 text",
        style = MaterialTheme.typography.body1,
      )
      Text(
        text = "overline text",
        style = MaterialTheme.typography.overline,
      )
      Text(
        text = "subtitle1 text",
        style = MaterialTheme.typography.subtitle1,
      )
    }
  }

  @Composable
  fun ColorTest(){
    Text(text = "primary", color = MaterialTheme.colors.primary)
    Text(text = "secondary", color = MaterialTheme.colors.secondary)
  }

  @Composable
  fun SpaceTest(){
    // padding
    Row(modifier = Modifier.padding(8.dp)){
      Text("XXX")
      // Spacer
      Spacer(modifier = Modifier.width(20.dp))
      Text("YYY")
    }
  }

  @Preview(showBackground = true)
  @Composable
  fun DefaultPreview() {
    MemoAppComposeTheme {
      Test()
    }
  }

  @Preview(showBackground = true)
  @Composable
  fun TestPreview(){
    Log.d("","TEST PREVIEW")
    Text(text = "XXX TEST XXX")
  }


}
