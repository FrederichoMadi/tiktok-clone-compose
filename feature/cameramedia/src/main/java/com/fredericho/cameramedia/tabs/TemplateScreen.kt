package com.fredericho.cameramedia.tabs

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.fredericho.cameramedia.CameraMediaEvent
import com.fredericho.cameramedia.CameraMediaViewModel
import com.fredericho.composable.CustomButton
import com.fredericho.core.extension.LargeSpace
import com.fredericho.core.extension.MediumSpace
import com.fredericho.core.extension.SmallSpace
import com.fredericho.core.extension.Space
import com.fredericho.data.model.TemplateModel
import com.fredericho.theme.SubTextColor
import kotlin.math.absoluteValue

@Composable
fun TemplateScreen(
    navController: NavController,
    viewModel: CameraMediaViewModel,
) {
    val viewState by viewModel.viewState.collectAsState()

    LaunchedEffect(key1 = Unit) {
        viewModel.onTriggerEvent(CameraMediaEvent.EventFetchTemplate)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconButton(
            onClick = {
                navController.navigateUp()
            },
            modifier = Modifier
                .align(Alignment.Start)
                .padding(top = 20.dp, start = 6.dp)
        ) {
            Icon(
                painter = painterResource(id = com.fredericho.theme.R.drawable.ic_cancel),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(28.dp)
            )
        }

        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            viewState?.templates?.let {
                TemplatePager(templates = it)
            }
        }
        CustomButton(
            buttonText = stringResource(id = com.fredericho.theme.R.string.upload_photos),
            shape = RoundedCornerShape(24.dp),
            modifier = Modifier.fillMaxWidth(0.65f)
        ) {}
        LargeSpace()
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ColumnScope.TemplatePager(templates: List<TemplateModel>) {
    val pagerState = rememberPagerState()

    val currentItem by remember {
        derivedStateOf {
            pagerState.settledPage
        }
    }

    Text(text = templates[currentItem].name, style = MaterialTheme.typography.displayMedium)
    6.dp.Space()
    Text(
        text = templates[currentItem].hint,
        style = MaterialTheme.typography.labelLarge,
        color = SubTextColor,
    )
    MediumSpace()
    HorizontalPager(
        pageCount = templates.size,
        contentPadding = PaddingValues(64.dp),
        state = pagerState,
        modifier = Modifier.weight(1f)
    ) {
        SingleTemplateCard(page = it, pagerState = pagerState, item = templates[it])
    }
    SmallSpace()
    Text(
        text = "${currentItem.plus(1)}/${templates.size}",
        color = SubTextColor,
        style = MaterialTheme.typography.labelMedium,
    )
    SmallSpace()
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SingleTemplateCard(
    page: Int,
    pagerState: PagerState,
    item: TemplateModel
) {
    val pageOffset =
        ((pagerState.currentPage - page) + (pagerState.currentPageOffsetFraction)).absoluteValue
    Card(
        modifier = Modifier
            .graphicsLayer {
                lerp(
                    start = 0.82f,
                    stop = 1f,
                    fraction = 1f - pageOffset.coerceIn(0f, 1f)
                ).also {
                    scaleX = it
                    scaleY = it
                }
            },
        shape = RoundedCornerShape(12.dp)
    ) {
        Box(
            modifier = Modifier
                .blur(if (pagerState.settledPage == page) 0.dp else 60.dp)
        ) {
            AsyncImage(
                model = item.parseMediaLink(),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
            )
        }
    }
}