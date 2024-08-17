package com.thoughtworks.composetemplate.screen.animals

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.thoughtworks.composetemplate.R
import com.thoughtworks.composetemplate.common.asyncLoader.AsyncLoadProcessor
import com.thoughtworks.composetemplate.common.asyncLoader.AutoLoadViewModel
import com.thoughtworks.composetemplate.ui.compose.scaffold.BaseScaffold

@Composable
fun AnimalsScreen(
    animalsViewModel: AnimalsViewModel = hiltViewModel(),
) {
    BaseScaffold(title = stringResource(R.string.screen_title_animals)) {
        AsyncLoadProcessor(
            remember { AutoLoadViewModel(animalsViewModel) }
        ) {
            AnimalsContent(animalsViewModel)
        }
    }
}

@Composable
fun AnimalsContent(
    viewModel: AnimalsViewModel,
) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val columns = 3

    LazyVerticalGrid(
        columns = GridCells.Fixed(columns)
    ) {
        items(items = viewModel.data) { animal ->
            AsyncImage(
                modifier = Modifier.size(screenWidth / columns),
                model = animal.url,
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )
        }
    }
}
