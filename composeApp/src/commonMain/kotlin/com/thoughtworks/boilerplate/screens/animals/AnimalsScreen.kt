package com.thoughtworks.boilerplate.screens.animals

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.thoughtworks.boilerplate.common.components.querying.QueryWrapper
import com.thoughtworks.boilerplate.common.components.scaffold.BaseScaffold
import com.thoughtworks.boilerplate.common.composequery.useQuery
import com.thoughtworks.boilerplate.data.model.Animal
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
            AnimalsContent(data)
        }
    }
}

@Composable
fun AnimalsContent(
    animals: List<Animal>,
) {
    val screenWidth = 360.dp
    val columns = 3

    LazyVerticalGrid(
        columns = GridCells.Fixed(columns)
    ) {
        items(items = animals) { animal ->
//            AsyncImage(
//                modifier = Modifier.size(screenWidth / columns),
//                model = animal.url,
//                contentDescription = null,
//                contentScale = ContentScale.Crop,
//            )
            Text(text = animal.url)
        }
    }
}
