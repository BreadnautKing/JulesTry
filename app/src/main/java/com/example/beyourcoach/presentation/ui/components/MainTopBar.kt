package com.example.beyourcoach.presentation.ui.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.beyourcoach.R
import com.example.beyourcoach.domain.model.UserMode

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopBar(
    currentMode: UserMode,
    onToggleMode: () -> Unit
) {
    TopAppBar(
        title = { Text(text = stringResource(id = R.string.app_name)) },
        actions = {
            Text(text = stringResource(id = R.string.lite))
            Switch(
                checked = currentMode == UserMode.PRO,
                onCheckedChange = { onToggleMode() }
            )
            Text(text = stringResource(id = R.string.pro))
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.surface,
            titleContentColor = MaterialTheme.colorScheme.primary
        )
    )
}
