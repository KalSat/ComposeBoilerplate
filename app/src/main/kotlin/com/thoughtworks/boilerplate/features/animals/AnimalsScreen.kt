package com.thoughtworks.boilerplate.features.animals

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.thoughtworks.boilerplate.R
import com.thoughtworks.boilerplate.components.querying.QueryWrapper
import com.thoughtworks.boilerplate.components.scaffold.BaseScaffold
import com.thoughtworks.boilerplate.shared.composequery.useQuery

@Composable
fun AnimalsScreen(repository: AnimalRepository = AnimalRepository()) {
    val result = useQuery(arrayOf("animals"), repository::getAnimals)

    BaseScaffold(title = stringResource(R.string.screen_title_animals)) {
        QueryWrapper(result) { data ->
            AnimalsContent(data)
        }
    }
}

@Composable
fun AnimalsContent(animals: List<Animal>) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val columns = 3

    LazyVerticalGrid(
        columns = GridCells.Fixed(columns),
    ) {
        items(items = animals) { animal ->
            AsyncImage(
                modifier = Modifier.size(screenWidth / columns),
                model = animal.url,
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )
        }
    }
}
