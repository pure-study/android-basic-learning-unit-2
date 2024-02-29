package me.will.tiptime

import androidx.compose.ui.test.isToggleable
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import me.will.tiptime.ui.theme.TipTimeTheme
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat

class TipUITests {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun calculate_20_percent_tip_no_roundup() {
        composeTestRule.setContent {
            TipTimeTheme {
                TipTimeApp()
            }
        }
        composeTestRule.onNodeWithText("Bill Amount").performTextInput("10")
        composeTestRule.onNodeWithText("Tip Percentage").performTextInput("20")

        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        composeTestRule
            .onNodeWithText("Tip Amount: $expectedTip")
            .assertExists("No node with expected text was found.")
    }

    @Test
    fun calculate_20_percent_tip_with_roundup() {
        composeTestRule.setContent {
            TipTimeTheme {
                TipTimeApp()
            }
        }
        composeTestRule.onNodeWithText("Bill Amount").performTextInput("11")
        composeTestRule.onNodeWithText("Tip Percentage").performTextInput("20")
        composeTestRule.onNode(isToggleable()).performClick()

        val expectedTip = NumberFormat.getCurrencyInstance().format(3)
        composeTestRule
            .onNodeWithText("Tip Amount: $expectedTip")
            .assertExists("No node with expected text was found.")
    }
}