package dev.tbsten.memoappcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import dev.tbsten.memoappcompose.composables.Layout
import dev.tbsten.memoappcompose.ui.theme.MemoAppComposeTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {

    super.onCreate(savedInstanceState)
    setContent {
      MemoAppComposeTheme {
        Content()
      }
    }
  }

  @OptIn(ExperimentalMaterial3Api::class)
  @Composable
  fun Content(){
    Layout(title="MemoApp") {
      Text("xxxx")
//      LazyColumn{
//        items(100){
//            Text(" -> $it")
//        }
//      }
    }
  }
}
