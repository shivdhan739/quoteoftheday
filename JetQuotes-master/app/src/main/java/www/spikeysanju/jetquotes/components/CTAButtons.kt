/*
 *
 *  *
 *  *  * MIT License
 *  *  *
 *  *  * Copyright (c) 2020 Sanju S
 *  *  *
 *  *  * Permission is hereby granted, free of charge, to any person obtaining a copy
 *  *  * of this software and associated documentation files (the "Software"), to deal
 *  *  * in the Software without restriction, including without limitation the rights
 *  *  * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  *  * copies of the Software, and to permit persons to whom the Software is
 *  *  * furnished to do so, subject to the following conditions:
 *  *  *
 *  *  * The above copyright notice and this permission notice shall be included in all
 *  *  * copies or substantial portions of the Software.
 *  *  *
 *  *  * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  *  * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  *  * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  *  * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  *  * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  *  * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  *  * SOFTWARE.
 *  *
 *
 */

package www.spikeysanju.jetquotes.components

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import www.spikeysanju.jetquotes.R
import www.spikeysanju.jetquotes.model.Quote
import www.spikeysanju.jetquotes.utils.copyToClipboard
import www.spikeysanju.jetquotes.utils.shareToOthers
import www.spikeysanju.jetquotes.view.viewModel.MainViewModel

@Composable
fun CTAButtons(viewModel: MainViewModel, quote: String, author: String) {
    val context = LocalContext.current
    Box(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .background(MaterialTheme.colors.primaryVariant)
                .align(Alignment.BottomEnd)
                .padding(30.dp, 30.dp, 0.dp, 30.dp)
        ) {


            Button(
                icon = painterResource(id = R.drawable.ic_heart),
                name = stringResource(R.string.text_favourite),
                modifier = Modifier.clickable(onClick = {
                    val quotes = Quote(quote, author)
                    viewModel.insertFavourite(quotes)
                    Toast.makeText(context, "Added to Favourites!", Toast.LENGTH_SHORT).show()
                })
            )

            Spacer(modifier = Modifier.width(30.dp))

            Button(
                icon = painterResource(id = R.drawable.ic_copy),
                name = stringResource(R.string.text_copy),
                modifier = Modifier.clickable(onClick = {
                    context.copyToClipboard(quote.plus("").plus("- $author"))
                    Toast.makeText(context, "Quote Copied!", Toast.LENGTH_SHORT).show()
                })
            )

            Spacer(modifier = Modifier.width(30.dp))

            Button(
                icon = painterResource(id = R.drawable.ic_share),
                name = stringResource(R.string.text_share),
                modifier = Modifier.clickable(onClick = {
                    context.shareToOthers(quote.plus("").plus("- $author"))
                })
            )

            Spacer(modifier = Modifier.width(30.dp))


        }
    }


}