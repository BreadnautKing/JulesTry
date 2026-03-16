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
import com.example.beyourcoach.presentation.viewmodel.WorkoutInputState

@Composable
fun ProWorkoutContent(
    exercises: List<Exercise>,
    inputs: Map<Long, WorkoutInputState>,
    onInputChange: (Long, String, String, String) -> Unit,
    onSaveSet: (WorkoutLog) -> Unit
) {
    LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        items(exercises) { exercise ->
            val inputState = inputs[exercise.id] ?: WorkoutInputState()

            Card(
                modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = exercise.name, style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.primary)
                    Spacer(modifier = Modifier.height(8.dp))

                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text("Set", modifier = Modifier.weight(1f))
                        Text("kg", modifier = Modifier.weight(2f))
                        Text("Reps", modifier = Modifier.weight(2f))
                        Text("RPE", modifier = Modifier.weight(2f))
                        Spacer(modifier = Modifier.weight(1f))
                    }

                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text("1", modifier = Modifier.weight(1f))
                        TextField(
                            value = inputState.weight,
                            onValueChange = { onInputChange(exercise.id ?: 0, it, inputState.reps, inputState.rpe) },
                            modifier = Modifier.weight(2f)
                        )
                        TextField(
                            value = inputState.reps,
                            onValueChange = { onInputChange(exercise.id ?: 0, inputState.weight, it, inputState.rpe) },
                            modifier = Modifier.weight(2f)
                        )
                        TextField(
                            value = inputState.rpe,
                            onValueChange = { onInputChange(exercise.id ?: 0, inputState.weight, inputState.reps, it) },
                            modifier = Modifier.weight(2f)
                        )
                        IconButton(
                            onClick = {
                                onSaveSet(WorkoutLog(
                                    id = null,
                                    exerciseId = exercise.id ?: 0,
                                    sets = 1,
                                    reps = inputState.reps.toIntOrNull() ?: 0,
                                    weight = inputState.weight.toDoubleOrNull() ?: 0.0,
                                    rpe = inputState.rpe.toIntOrNull() ?: 0
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
