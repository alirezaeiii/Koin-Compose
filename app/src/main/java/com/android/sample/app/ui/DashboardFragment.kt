package com.android.sample.app.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.fragment.findNavController
import com.android.sample.app.R
import com.android.sample.app.base.BaseFragment
import com.android.sample.app.base.BaseViewModel
import com.android.sample.app.domain.Dashboard
import com.android.sample.app.ui.theme.ComposeTheme
import com.android.sample.app.ui.common.composeView
import com.android.sample.app.viewmodel.DashboardViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class DashboardFragment : BaseFragment<Dashboard>() {

    override val viewModel: BaseViewModel<Dashboard> by viewModel(DashboardViewModel::class)

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
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier.fillMaxSize()
                            ) {
                                Text(text = stringResource(id = R.string.label_dashboard))
                            }
                        },
                        elevation = 8.dp,
                        modifier = Modifier.clip(
                            RoundedCornerShape(bottomStart = 18.dp, bottomEnd = 18.dp)
                        )
                    )
                },
                content = {
                    Content()
                })
        }
    }

    @Composable
    override fun SuccessScreen(t: Dashboard) {
        VerticalCollection(t) { link ->
            val destination =
                DashboardFragmentDirections.actionDashboardFragmentToSectionFragment(link)
            findNavController().navigate(destination)
        }
    }
}