package com.ilyes.newsapp.ui.presentation.onboarding

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.ilyes.newsapp.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int,
)
val pages = listOf(
    Page(
        title = "Stay Informed on Global News",
        description = "Get in-depth coverage of current events, local news, and analysis from trusted sources around the world.",
        image = R.drawable.gaza,
    ),

    Page(
        title = "Deeper into Your Interests",
        description = "Follow your favorite sports teams, celebrities, and hobbies. Discover personalized news feeds tailored to your interests.",
        image = R.drawable.foootbal,
    ),
    Page(
        title = "Stay Ahead of the Curve",
        description = "Explore the latest advances in technology, science, and innovation. Uncover stories that shape our future.",
        image = R.drawable.tech,
    ),
)