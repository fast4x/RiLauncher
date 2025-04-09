package it.fast4x.rilauncher.ui.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import it.fast4x.rilauncher.R
import it.fast4x.rilauncher.tabIndex
import it.fast4x.rilauncher.typography
import it.fast4x.rilauncher.ui.components.ScaffoldContainer
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(){

//    val sheetState = rememberModalBottomSheetState()
//    val scope = rememberCoroutineScope()
//    var showBottomSheet by remember { mutableStateOf(false) }
//    Scaffold(
//        floatingActionButton = {
//            ExtendedFloatingActionButton(
//                text = { Text("Show bottom sheet") },
//                icon = { Icon(Icons.Filled.Add, contentDescription = "") },
//                onClick = {
//                    showBottomSheet = true
//                }
//            )
//        }
//    ) { contentPadding ->
//        // Screen content
//        contentPadding.calculateTopPadding()
//
//        if (showBottomSheet) {
//            ModalBottomSheet(
//                onDismissRequest = {
//                    showBottomSheet = false
//                },
//                sheetState = sheetState
//            ) {
//                // Sheet content
//                Button(onClick = {
//                    scope.launch { sheetState.hide() }.invokeOnCompletion {
//                        if (!sheetState.isVisible) {
//                            showBottomSheet = false
//                        }
//                    }
//                }) {
//                    Text("Hide bottom sheet")
//                }
//            }
//        }
//    }

    ScaffoldContainer(
        tabIndex = tabIndex()
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            fontStyle = typography().xxxl.fontStyle,
            fontSize = typography().xxxl.fontSize,
            fontWeight = typography().xxxl.fontWeight,
            fontFamily = typography().xxxl.fontFamily,
            letterSpacing = typography().xxxl.letterSpacing,
            color = Color.White,
            modifier = Modifier.align(Alignment.Center)
        )
    }



}