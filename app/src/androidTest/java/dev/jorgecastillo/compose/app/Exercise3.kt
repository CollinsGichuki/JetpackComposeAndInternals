package dev.jorgecastillo.compose.app

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.printToLog
import dev.jorgecastillo.compose.app.ui.composables.SocialNetworkUser
import dev.jorgecastillo.compose.app.ui.theme.ComposeAndInternalsTheme
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Rule
import org.junit.Test

/**
 * ### Exercise 3 👩🏾‍💻
 *
 * This UI test runs the [SocialNetworkUser] Composable within an empty Activity and asserts over
 * the value of the displayed name, location, text of the button, and button click interaction.
 *
 * To complete this exercise:
 *
 * 1. Use the Text Composable twice, one for the name and another one for the location.
 * 2. Use the Column Composable to align the two texts vertically, the one below the other.
 * 3. Use a Row to align horizontally the two buttons (already aligned vertically) with a new Button
 *    that you must add. Add the "Follow" text to the Button.
 * 4. Add a click listener to the button that calls the provided callback for it.
 * 5. Run the test.
 */
class Exercise3Test {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun text_displayed_and_centered_within_the_box() {
        // Becomes true once the follow button is clicked in order to assert later
        var isClicked = false

        // Start the app
        composeTestRule.setContent {
            ComposeAndInternalsTheme {
                SocialNetworkUser("John Doe", "New York City") {
                    isClicked = true
                }
            }
        }

        composeTestRule.onNodeWithText("John Doe").assertIsDisplayed()
        composeTestRule.onNodeWithText("New York City").assertIsDisplayed()
        composeTestRule.onNodeWithText("Follow").assertIsDisplayed().performClick()
        assertThat(isClicked, `is`(true))
        composeTestRule.onRoot().printToLog("Exercise 2")
    }
}
