package com.example.beyourcoach.presentation.ui.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import com.example.beyourcoach.domain.model.UserMode

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopBar(
    currentMode: UserMode,
    onToggleMode: () -> Unit
) {
    TopAppBar(
        title = { Text(text = "Be Your Coach") },
        actions = {
            Text(text = "LITE")
            Switch(
                checked = currentMode == UserMode.PRO,
                onCheckedChange = { onToggleMode() }
            )
            Text(text = "PRO")
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.surface,
            titleContentColor = MaterialTheme.colorScheme.primary
        )
    )
}
