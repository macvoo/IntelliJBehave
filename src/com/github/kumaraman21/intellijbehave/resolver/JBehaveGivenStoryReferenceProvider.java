package com.github.kumaraman21.intellijbehave.resolver;

import com.github.kumaraman21.intellijbehave.parser.JBehaveGivenStory;
import com.github.kumaraman21.intellijbehave.parser.JBehaveStep;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.PsiReferenceProvider;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

public class JBehaveGivenStoryReferenceProvider extends PsiReferenceProvider {
    @NotNull
    @Override
    public PsiReference[] getReferencesByElement(@NotNull PsiElement element, @NotNull ProcessingContext context) {
        if (element instanceof JBehaveGivenStory) {
            final JBehaveGivenStory givenStory = (JBehaveGivenStory) element;

            return new PsiReference[]{new GivenStoryPsiReference(givenStory, TextRange.from(0, element.getTextLength()))};
        }

        return PsiReference.EMPTY_ARRAY;
    }
}
