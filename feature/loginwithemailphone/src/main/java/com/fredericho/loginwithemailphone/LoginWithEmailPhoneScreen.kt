package com.fredericho.loginwithemailphone

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEachIndexed
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.fredericho.composable.TopBar
import com.fredericho.loginwithemailphone.tabs.EmailUsernameTabScreen
import com.fredericho.loginwithemailphone.tabs.PhoneTabScreen
import com.fredericho.theme.Black
import com.fredericho.theme.R
import com.fredericho.theme.SeparatorColor
import com.fredericho.theme.SubTextColor
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginWithEmailPhoneScreen(
    navController: NavController,
    viewModel: LoginWithEmailPhoneViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {
            TopBar(
                title = stringResource(id = R.string.login_or_sign_up),
                actions = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_question_circle),
                        contentDescription = null,
                        modifier = Modifier.padding(end = 16.dp)
                        )
                }
            ) {
                navController.navigateUp()
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            LoginPager(viewModel = viewModel)
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun LoginPager(viewModel: LoginWithEmailPhoneViewModel) {
    val pagerState = rememberPagerState()
    val pages = LoginPages.values().asList()
    val coroutineScope = rememberCoroutineScope()
    LaunchedEffect(key1 = pagerState) {
        snapshotFlow { pagerState.settledPage }.collect{
            viewModel.onTriggerEvent(LoginEmailPhoneEvent.EventPageChange(it))
        }
    }

    TabRow(
        selectedTabIndex = pagerState.currentPage,
        indicator = {
            val modifier = Modifier
                .tabIndicatorOffset(it[pagerState.currentPage])
                .padding(horizontal = 26.dp)
            TabRowDefaults.Indicator(modifier, color = Black)
        },
        divider = {
            Divider(thickness = 0.5.dp, color = SeparatorColor)
        }
    ) {
        pages.fastForEachIndexed { index, item ->
            val isSelected = pagerState.currentPage == index
            Tab(
                selected = isSelected,
                onClick = {
                    coroutineScope.launch { pagerState.animateScrollToPage(index) }
                },
                selectedContentColor = Color.Black,
                unselectedContentColor = SubTextColor,
                text = {
                    Text(
                        text = stringResource(id = item.title),
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            )
        }
    }

    HorizontalPager(
        modifier = Modifier.fillMaxSize(),
        state = pagerState,
        pageCount = pages.size,
        key = { it }
    ) { page ->
        when(page) {
            0 -> PhoneTabScreen(viewModel = viewModel)
            1 -> EmailUsernameTabScreen(viewModel = viewModel)
        }

    }

}