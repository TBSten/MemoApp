package dev.tbsten.memoappcompose.composables

import android.util.Log
import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Layout(
  title :String ,
  children:@Composable ()->Unit,
){
  val decayAnimationSpec = rememberSplineBasedDecay<Float>()
  val scrollBehavior = remember(decayAnimationSpec) {
    TopAppBarDefaults.exitUntilCollapsedScrollBehavior(decayAnimationSpec)
  }

  Scaffold(
    modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
    topBar = {
      LargeTopAppBar(
        title = {
          Text(text = title)
        },
        navigationIcon = {
          IconButton(onClick = {}) {
            Icon(Icons.Filled.Menu, contentDescription = "Menu")
          }
        },
        actions = {
          IconButton(onClick = {}) {
            Icon(Icons.Filled.Edit, contentDescription = "Edit")
          }
        },
        scrollBehavior = scrollBehavior
      )
    }
  ) {
    LazyColumn(
      modifier = Modifier.fillMaxSize(),
      contentPadding = it,
    ) {
      item{
        Column{
          children()
        }
      }
    }
  }
}

