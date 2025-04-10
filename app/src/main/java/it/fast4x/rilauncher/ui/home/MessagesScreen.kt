package it.fast4x.rilauncher.ui.home

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import it.fast4x.rilauncher.R
import it.fast4x.rilauncher.enums.MenuTabs
import it.fast4x.rilauncher.typography
import it.fast4x.rilauncher.ui.components.ScaffoldContainer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MessagesScreen(
    navController: NavController
) {
    ScaffoldContainer(
        navController = navController,
        tab = MenuTabs.Messages,
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