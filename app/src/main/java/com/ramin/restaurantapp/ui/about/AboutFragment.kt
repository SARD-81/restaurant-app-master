package com.ramin.restaurantapp.ui.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.ramin.restaurantapp.databinding.FragmentAboutBinding
import com.ramin.restaurantapp.ui.MainActivity

class AboutFragment : Fragment() {

    private var _binding: FragmentAboutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAboutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupWebView()
    }

    private fun setupWebView() {
        (requireActivity() as? MainActivity)?.supportActionBar?.title = binding.root.context.getString(com.ramin.restaurantapp.R.string.about_title)
        binding.aboutWebView.apply {
            settings.cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK
            webViewClient = WebViewClient()
            loadUrl("file:///android_asset/about.html")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.aboutWebView.destroy()
        _binding = null
    }
}
