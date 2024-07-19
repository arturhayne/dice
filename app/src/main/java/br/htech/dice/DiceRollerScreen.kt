package br.htech.dice

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import br.htech.dice.model.DieFace
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@Composable
fun DiceRollerApp(diceViewModel: DiceViewModel = viewModel()) {
    DiceWithButtonAndImage(diceViewModel.diceResult) { diceViewModel.rollDice() }
}


@Composable
fun DiceWithButtonAndImage(dieFace: StateFlow<DieFace>, rollDice: () -> Unit) {
    val result by dieFace.collectAsState()

    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painterResource(id = result.resource), contentDescription = "dice")
        Text(text = result.number.toString())
        Button(onClick = { rollDice() }) {
            Text(text = "Rolar dado")
        }
    }
}

@Preview
@Composable
fun screenPreview() {
    val fakeDieFace = MutableStateFlow(DieFace.ONE)
    val fakeRollDice: () -> Unit = {
        fakeDieFace.value = DieFace.values().random()
    }
    DiceWithButtonAndImage(dieFace = fakeDieFace, rollDice = fakeRollDice)
}