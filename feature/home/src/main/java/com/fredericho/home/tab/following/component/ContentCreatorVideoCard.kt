package com.fredericho.home.tab.following.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import androidx.media3.exoplayer.ExoPlayer
import coil.compose.AsyncImage
import com.fredericho.composable.VideoPlayer
import com.fredericho.core.extension.Space
import com.fredericho.data.model.ContentCreatorFollowingModel
import com.fredericho.theme.R
import com.fredericho.theme.White
import com.fredericho.theme.WhiteAlpha95
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CreatorCard(
    page: Int,
    pagertState: PagerState,
    item: ContentCreatorFollowingModel,
    onClickFollow: (userId: Long) -> Unit,
    onClickUser: (userId: Long) -> Unit,
) {
    val pagerOffset =
        ((pagertState.currentPage - page) + (pagertState.currentPageOffsetFraction)).absoluteValue
    Card(
        modifier = Modifier
            .graphicsLayer {
                lerp(
                    start = 0.9f,
                    stop = 1f,
                    fraction = 1f - pagerOffset.coerceIn(0f, 1f)
                ).also { scale ->
                    scaleX = scale
                    scaleY = scale
                }
            },
        shape = RoundedCornerShape(8.dp)
    ) {
        Box(modifier = Modifier
            .drawWithCache {
                onDrawWithContent {
                    drawContent()
                    val color: Color = lerp(
                        Color.Black.copy(alpha = 0.59f),
                        Color.Transparent,
                        fraction = 1f - pagerOffset.coerceIn(0f, 1f)
                    )
                    drawRect(color)
                }
            }
            .height(340.dp)
        ) {
            VideoPlayer(
                video = item.coverVideo,
                pagerState = pagertState,
                pageIndex = page,
                onSingleTap = {
                    onClickUser(item.userModel.userId)
                },
                onDoubleTap = { exoPlayer: ExoPlayer, offset: Offset -> },
                onVideoDispose = {},
                onVideoGoBackground = {},
            )

            Icon(
                painterResource(id = R.drawable.ic_cancel),
                contentDescription = null,
                tint = Color.Gray,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(12.dp)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                AsyncImage(
                    model = item.userModel.profilePic,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(bottom = 4.dp)
                        .size(70.dp)
                        .border(
                            BorderStroke(
                                width = 1.dp,
                                color = White
                            ),
                            shape = CircleShape
                        )
                        .clip(shape = CircleShape)
                )

                Text(
                    text = item.userModel.fullName,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.White
                )
                Text(
                    text = "@${item.userModel.uniqueUserName}",
                    style = MaterialTheme.typography.labelMedium,
                    color = WhiteAlpha95
                )
                Button(onClick = {
                    onClickFollow(item.userModel.userId)
                }, modifier = Modifier
                    .padding(top = 2.dp)
                    .padding(horizontal = 36.dp)
                    .fillMaxWidth(),
                    shape = RoundedCornerShape(2.dp)
                    ) {
                    Text(text = stringResource(id = R.string.follow))
                }
                12.dp.Space()
            }
            20.dp.Space()
        }
    }
}