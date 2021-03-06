package com.github.kumaraman21.intellijbehave.highlighter;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;

import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import javax.swing.*;
import java.util.Map;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class StoryColorsAndFontsPage implements ColorSettingsPage {

    @NotNull
    public String getDisplayName() {
        return "JBehave";
    }

    @Nullable
    public Icon getIcon() {
        return null;//IntelliJBehaveIcons.ICON_16x16;
    }

    @NotNull
    public AttributesDescriptor[] getAttributeDescriptors() {
        return ATTRS;
    }

    private static final AttributesDescriptor[] ATTRS = new AttributesDescriptor[]{
            new AttributesDescriptor("Story description", StorySyntaxHighlighter.STORY_DESCRIPTION),//
            new AttributesDescriptor("GivenStories keyword", StorySyntaxHighlighter.GIVEN_STORIES_TYPE),//
            new AttributesDescriptor("GivenStories text", StorySyntaxHighlighter.GIVEN_STORIES_TEXT),//
            new AttributesDescriptor("Scenario keyword", StorySyntaxHighlighter.SCENARIO_TYPE),//
            new AttributesDescriptor("Scenario text", StorySyntaxHighlighter.SCENARIO_TEXT),//
            new AttributesDescriptor("Lifecycle keyword", StorySyntaxHighlighter.LIFECYCLE_TYPE),//
            new AttributesDescriptor("Lifecycle outcome text", StorySyntaxHighlighter.LIFECYCLE_TEXT), //
            new AttributesDescriptor("Step keyword", StorySyntaxHighlighter.STEP_TYPE),//
            new AttributesDescriptor("Step text", StorySyntaxHighlighter.STEP_TEXT), //
            new AttributesDescriptor("Table delimiter", StorySyntaxHighlighter.TABLE_DELIM),
            new AttributesDescriptor("Table cell", StorySyntaxHighlighter.TABLE_CELL),//
            new AttributesDescriptor("Meta keyword", StorySyntaxHighlighter.META_TYPE),//
            new AttributesDescriptor("Meta key", StorySyntaxHighlighter.META_KEY),//
            new AttributesDescriptor("Meta text", StorySyntaxHighlighter.META_TEXT), //
            new AttributesDescriptor("Line comment", StorySyntaxHighlighter.LINE_COMMENT),//
            new AttributesDescriptor("Bad Character", StorySyntaxHighlighter.BAD_CHARACTER)
    };

    @NotNull
    public ColorDescriptor[] getColorDescriptors() {
        return new ColorDescriptor[0];
    }

    @NotNull
    public SyntaxHighlighter getHighlighter() {
        return new StorySyntaxHighlighter();
    }

    @NonNls
    @NotNull
    public String getDemoText() {
        return "Narrative: \n" + //
                "In order to play a game\n" + //
                "As a player\n" + //
                "I want to be able to create and manage my account\n" + //
                "\n" + //
                "GivenStories:\t/stories/open_the_browser.story\n" + //
                "\n" + //
                "Scenario: An unknown user cannot be logged\n" + //
                "\n" + //
                "Meta:\n" + //
                "@author mccallum\n" + //
                "@skip\n" + //
                "\n" + //
                "GivenStories:\t/stories/create_user.story{#weird}\n" + //
                "\n" + //
                "Given i am the user with nickname: \"weird\"\n" + //
                "When i try to login using the password \"soweird\"\n" + //
                "!-- TODO: Then i get an error message of type \"Wrong Credentials\"\n" + //
                "\n" + //
                "\n" + //
                "Scenario: A known user cannot be logged using a wrong password\n" + //
                "\n" + //
                "Given the following existing users:\n" + //
                "| nickname | password |\n" + //
                "|   Travis |   PacMan |\n" + //
                "Given i am the user with nickname: \"Travis\"\n" + //
                "When i try to login using the password \"McCallum\"\n" + //
                "Then i get an error message of type \"Wrong Credentials\"\n" + //
                "\n" + //
                "Scenario: Using Lifecycle in a scenario\n" + //
                "\n" + //
                "Lifecycle:\n" + //
                "Before:\n" + //
                "Given a step that is executed before each scenario\n" + //
                "After:\n" + //
                "Outcome: ANY\n" + //
                "Given a step that is executed after each scenario regardless of outcome\n" + //
                "Outcome: SUCCESS\n" + //
                "Given a step that is executed after each successful scenario\n" + //
                "Outcome: FAILURE\n" + //
                "Given a step that is executed after each failed scenario";
    }

    @Nullable
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }
}
