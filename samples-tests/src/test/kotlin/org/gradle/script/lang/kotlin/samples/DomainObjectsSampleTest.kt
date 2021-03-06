package org.gradle.script.lang.kotlin.samples

import org.gradle.script.lang.kotlin.fixtures.containsMultiLineString

import org.junit.Assert.assertThat
import org.junit.Test

import java.io.File


class DomainObjectsSampleTest : AbstractSampleTest("domain-objects") {

    @Test
    fun `books task list all books and their path`() {
        assertThat(
            build("books").output,
            containsMultiLineString("""
                developerGuide -> src${File.separator}docs${File.separator}developerGuide
                quickStart -> src${File.separator}docs${File.separator}quick-start
                userGuide -> src${File.separator}docs${File.separator}userGuide
            """))
    }
}
