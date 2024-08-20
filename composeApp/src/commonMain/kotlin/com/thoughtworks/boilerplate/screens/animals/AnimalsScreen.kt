package com.thoughtworks.boilerplate.screens.animals

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil3.compose.AsyncImage
import com.thoughtworks.boilerplate.common.components.querying.QueryWrapper
import com.thoughtworks.boilerplate.common.components.scaffold.BaseScaffold
import com.thoughtworks.boilerplate.common.composequery.useQuery
import composeboilerplate.composeapp.generated.resources.Res
import composeboilerplate.composeapp.generated.resources.screen_title_animals
import org.jetbrains.compose.resources.stringResource

@Composable
fun AnimalsScreen(
    repository: AnimalRepository = AnimalRepository(),
) {
    val result = useQuery(arrayOf("animals"), repository::getAnimals)

    BaseScaffold(title = stringResource(Res.string.screen_title_animals)) {
        QueryWrapper(result) { data ->
            LazyVerticalGrid(
                columns = GridCells.Fixed(3)
            ) {
                items(items = data) { animal ->
                    AsyncImage(
                        modifier = Modifier.aspectRatio(ratio = 1f).fillMaxWidth(),
                        model = animal.url,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                    )
                }
            }
        }
    }
}

