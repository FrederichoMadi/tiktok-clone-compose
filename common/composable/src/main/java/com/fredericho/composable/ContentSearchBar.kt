package com.fredericho.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TextFieldDefaults.OutlinedBorderContainerBox
import androidx.compose.material3.TextFieldDefaults.TextFieldDecorationBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.fredericho.theme.OverlayWhiteColor
import com.fredericho.theme.R
import com.fredericho.theme.TikTokTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentSearchBar(
    onClickNav: () -> Unit,
    onClickSearch: () -> Unit,
    placeholder: String = "",
    readOnly: Boolean = true,
    marginHorizontal: Dp = 16.dp,
    marginTop: Dp = 8.dp
) {
    val textFieldColors = TextFieldDefaults.outlinedTextFieldColors(
        unfocusedBorderColor = OverlayWhiteColor,
        containerColor = Color.Transparent,
        textColor = Color.White,
        placeholderColor = Color.White
    )

    val shape = RoundedCornerShape(8.dp)
    val interactionSource = remember {
        MutableInteractionSource()
    }

    Row(
        modifier = Modifier
            .padding(horizontal = marginHorizontal)
            .padding(top = marginTop),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_arrow_back),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .size(18.dp)
                .clickable {
                    onClickNav()
                }
        )

        BasicTextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(38.dp)
                .clickable { onClickSearch() },
            value = "",
            onValueChange = {},
            singleLine = true,
            readOnly = readOnly,
            decorationBox = {
                TextFieldDecorationBox(
                    value = "",
                    innerTextField = { /*TODO*/ },
                    enabled = true,
                    singleLine = true,
                    leadingIcon = {
                        Icon(
                            painterResource(id = R.drawable.ic_search),
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(14.dp)
                        )
                    },
                    colors = textFieldColors,
                    shape = shape,
                    trailingIcon = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(10.dp),
                            modifier = Modifier.padding(end = 8.dp)
                        ) {
                            Divider(
                                modifier = Modifier
                                    .width(1.dp)
                                    .height(16.dp),
                                color = OverlayWhiteColor
                            )
                            Text(
                                text = stringResource(id = R.string.search),
                                style = MaterialTheme.typography.labelLarge,
                                color = Color.White
                            )
                        }
                    },
                    placeholder = {
                        Text(
                            text = placeholder,
                            style = MaterialTheme.typography.labelLarge,
                        )
                    },
                    visualTransformation = VisualTransformation.None,
                    interactionSource = interactionSource,
                    contentPadding = PaddingValues(4.dp),
                    container = {
                        OutlinedBorderContainerBox(
                            interactionSource = interactionSource,
                            colors = textFieldColors,
                            shape = shape,
                            focusedBorderThickness = 1.dp,
                            unfocusedBorderThickness = 1.dp,
                            enabled = true,
                            isError = false,
                        )
                    }
                )
            }
        )
    }
}