//package dev.jorgecastillo.compose.app
//
//import androidx.compose.ui.test.assertTextEquals
//import androidx.compose.ui.test.junit4.createComposeRule
//import androidx.compose.ui.test.onNodeWithTag
//import androidx.compose.ui.test.onNodeWithText
//import androidx.compose.ui.test.onRoot
//import androidx.compose.ui.test.performClick
//import androidx.compose.ui.test.printToLog
//import dev.jorgecastillo.compose.app.ui.theme.ComposeAndInternalsTheme
//import org.junit.Rule
//import org.junit.Test
//
///**
// * ### Exercise 👩🏾‍💻
// *
// * This is a UI test. It runs the NameGenerator composable within an empty Activity, and asserts
// * over the value of the name. The name Composable is referenced using a test tag since Composables
// * do not support ids (see the [NameGenerator] implementation).
// *
// * The test asserts over the name text, then clicks the button, asserts again, and so on. Until all
// * the names have been verified. After each name change, we print the name to log so you can use
// * logs as a reference to see the name updates.
// *
// * To complete this exercise:
// *
// * 1. Create a mutable state to represent the name (String) in `NameGenerator`.
// * 2. Default the state value to the first generated name (`repo.next()` to generate a name).
// * 2. Make the name text Composable read from the state just created.
// * 3. Update the name on button click. (`repo.next()` to generate a new name).
// *
// */
//class NameGeneratorTest {
//
//    @get:Rule
//    val composeTestRule = createComposeRule()
//
//    @Test
//    fun text_always_reflects_the_most_fresh_state() {
//        // Start the app
//        composeTestRule.setContent {
//            ComposeAndInternalsTheme {
//                NameGenerator(NameRepository())
//            }
//        }
//
//        // Assert for the names from the repo in order: "Jane Smith", "Aleesha Salgado",
//        // "Alayna Bradley", "Zunaira English", "Cassandra Higgins", then starts again from the
//        // beginning.
//        composeTestRule.onNodeWithTag("name").assertTextEquals("Jane Smith")
//        composeTestRule.onRoot().printToLog("TEST")
//        composeTestRule.onNodeWithText("Generate").performClick()
//
//        composeTestRule.onNodeWithTag("name").assertTextEquals("Aleesha Salgado")
//        composeTestRule.onRoot().printToLog("TEST")
//        composeTestRule.onNodeWithText("Generate").performClick()
//
//        composeTestRule.onNodeWithTag("name").assertTextEquals("Alayna Bradley")
//        composeTestRule.onRoot().printToLog("TEST")
//        composeTestRule.onNodeWithText("Generate").performClick()
//
//        composeTestRule.onNodeWithTag("name").assertTextEquals("Zunaira English")
//        composeTestRule.onRoot().printToLog("TEST")
//        composeTestRule.onNodeWithText("Generate").performClick()
//
//        composeTestRule.onNodeWithTag("name").assertTextEquals("Cassandra Higgins")
//        composeTestRule.onRoot().printToLog("TEST")
//        composeTestRule.onNodeWithText("Generate").performClick()
//
//        composeTestRule.onNodeWithTag("name").assertTextEquals("Jane Smith")
//        composeTestRule.onRoot().printToLog("TEST")
//    }
//}
