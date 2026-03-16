package com.example.beyourcoach.presentation.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.beyourcoach.domain.model.Exercise
import com.example.beyourcoach.domain.model.WorkoutLog

@Composable
fun ProWorkoutContent(
    exercises: List<Exercise>,
    onSaveSet: (WorkoutLog) -> Unit
) {
    LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        items(exercises) { exercise ->
            Card(
                modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = exercise.name, style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.primary)
                    Spacer(modifier = Modifier.height(8.dp))

                    // Table Header
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text("Set", modifier = Modifier.weight(1f))
                        Text("kg", modifier = Modifier.weight(2f))
                        Text("Reps", modifier = Modifier.weight(2f))
                        Text("RPE", modifier = Modifier.weight(2f))
                        Spacer(modifier = Modifier.weight(1f))
                    }

                    // Simple input row for new set
                    var weight by remember { mutableStateOf("") }
                    var reps by remember { mutableStateOf("") }
                    var rpe by remember { mutableStateOf("") }

                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text("1", modifier = Modifier.weight(1f))
                        TextField(value = weight, onValueChange = { weight = it }, modifier = Modifier.weight(2f))
                        TextField(value = reps, onValueChange = { reps = it }, modifier = Modifier.weight(2f))
                        TextField(value = rpe, onValueChange = { rpe = it }, modifier = Modifier.weight(2f))
                        IconButton(
                            onClick = {
                                onSaveSet(WorkoutLog(
                                    id = null,
                                    exerciseId = exercise.id ?: 0,
                                    sets = 1,
                                    reps = reps.toIntOrNull() ?: 0,
                                    weight = weight.toDoubleOrNull() ?: 0.0,
                                    rpe = rpe.toIntOrNull() ?: 0
                                ))
                            },
                            modifier = Modifier.weight(1f)
                        ) {
                            Text("+")
                        }
                    }
                }
            }
        }
    }
}
