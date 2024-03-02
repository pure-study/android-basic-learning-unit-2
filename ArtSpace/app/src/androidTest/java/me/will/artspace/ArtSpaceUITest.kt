package me.will.artspace

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import me.will.artspace.ui.theme.ArtSpaceTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ArtSpaceUITest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun beforeEach() {
        composeTestRule.setContent {
            ArtSpaceTheme {
                ArtSpaceApp()
            }
        }
    }

    @Test
    fun next_single_click() {
        composeTestRule.onNodeWithText("Artwork 01 Title").assertExists("No node with the 1st artwork was found.")
        composeTestRule.onNodeWithText("Next").performClick()

        composeTestRule.onNodeWithText("Artwork 02 Title").assertExists("No node with the 2nd artwork was found.")
        composeTestRule.onNodeWithText("Artist 02 (2007)").assertExists("No node with the 2nd Artist was found.")
    }

    @Test
    fun previous_single_click() {
        composeTestRule.onNodeWithText("Artwork 01 Title").assertExists("No node with the 1st artwork was found.")
        composeTestRule.onNodeWithText("Previous").performClick()

        composeTestRule.onNodeWithText("Artwork 04 Title").assertExists("No node with the 4th artwork was found.")
        composeTestRule.onNodeWithText("Artist 04 (2007)").assertExists("No node with the 4th Artist was found.")
    }

    @Test
    fun next_click_multiple_times() {
        composeTestRule.onNodeWithText("Artwork 01 Title").assertExists("No node with the 1st artwork was found.")
        // click the first time and expect the original UI is indeed changed
        composeTestRule.onNodeWithText("Next").performClick()
        composeTestRule.onNodeWithText("Artwork 01 Title").assertDoesNotExist()

        // click 3 more times, and expect the artwork should go back the original first one
        composeTestRule.onNodeWithText("Next").performClick().performClick().performClick()
        composeTestRule.onNodeWithText("Artwork 01 Title").assertExists("No node with the 2nd artwork was found.")
        composeTestRule.onNodeWithText("Artist 01 (2007)").assertExists("No node with the 2nd Artist was found.")
    }

    @Test
    fun previous_click_multiple_times() {
        composeTestRule.onNodeWithText("Artwork 01 Title").assertExists("No node with the 1st artwork was found.")
        // click the first time and expect the original UI is indeed changed
        composeTestRule.onNodeWithText("Previous").performClick()
        composeTestRule.onNodeWithText("Artwork 01 Title").assertDoesNotExist()

        // click 3 more times, and expect the artwork should go back the original first one
        composeTestRule.onNodeWithText("Previous").performClick().performClick().performClick()
        composeTestRule.onNodeWithText("Artwork 01 Title").assertExists("No node with the 4th artwork was found.")
        composeTestRule.onNodeWithText("Artist 01 (2007)").assertExists("No node with the 4th Artist was found.")
    }
}