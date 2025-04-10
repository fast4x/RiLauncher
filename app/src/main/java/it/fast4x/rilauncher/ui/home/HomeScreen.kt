package it.fast4x.rilauncher.ui.home

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import it.fast4x.rilauncher.R
import it.fast4x.rilauncher.tabIndex
import it.fast4x.rilauncher.typography
import it.fast4x.rilauncher.ui.components.ScaffoldContainer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {

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