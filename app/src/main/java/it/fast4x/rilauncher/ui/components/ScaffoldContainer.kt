package it.fast4x.rilauncher.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import it.fast4x.rilauncher.R
import it.fast4x.rilauncher.typography
import it.fast4x.rilauncher.ui.home.MenuItems
import kotlinx.coroutines.launch

@Composable
fun ScaffoldContainer(){
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                drawerContainerColor = Color.Black.copy(alpha = 0.5f),
                drawerTonalElevation = 12.dp,
                modifier = Modifier.width(100.dp)
            ) {
                NavigationRail(
                    tabIndex = 0,
                    onTabIndexChanged = { }
                ) { item ->
                    MenuItems(item)
                }
            }
        },
    ) {
        Scaffold(
            floatingActionButton = {
                ExtendedFloatingActionButton(
                    text = { Text("Try swipe left to right") },
                    icon = { Icon(Icons.Filled.Add, contentDescription = "") },
                    onClick = {
                        scope.launch {
                            drawerState.apply {
                                if (isClosed) open() else close()
                            }
                        }
                    }
                )
            }
        ) { contentPadding ->
            // Screen content
            contentPadding.calculateTopPadding()
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black)
            ){
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
    }

}