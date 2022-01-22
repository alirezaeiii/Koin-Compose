package com.android.sample.app.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.android.sample.app.R
import com.android.sample.app.base.BaseFragment
import com.android.sample.app.base.BaseViewModel
import com.android.sample.app.domain.Section
import com.android.sample.app.ui.theme.ComposeTheme
import com.android.sample.app.ui.common.DetailDescriptionText
import com.android.sample.app.ui.common.DetailTitleText
import com.android.sample.app.ui.common.composeView
import com.android.sample.app.viewmodel.SectionViewModel
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class SectionFragment : BaseFragment<Section>() {

    private val args: SectionFragmentArgs by navArgs()

    override val viewModel: BaseViewModel<Section> by viewModel(SectionViewModel::class) {
        parametersOf(args.link)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = composeView {
        ComposeTheme {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            Text(text = stringResource(id = R.string.label_section))
                        },
                        elevation = 8.dp,
                        navigationIcon = {
                            IconButton(onClick = findNavController()::navigateUp) {
                                Icon(Icons.Rounded.ArrowBack, "Back")
                            }
                        }
                    )
                },
                content = {
                    Content()
                })
        }
    }

    @Composable
    override fun SuccessScreen(t: Section) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            DetailTitleText(resourceId = R.string.label_title)
            Spacer(Modifier.height(4.dp))
            DetailDescriptionText(text = t.title)
            Spacer(Modifier.height(8.dp))
            DetailTitleText(resourceId = R.string.label_description)
            Spacer(Modifier.height(4.dp))
            DetailDescriptionText(text = t.description)
        }
    }
}