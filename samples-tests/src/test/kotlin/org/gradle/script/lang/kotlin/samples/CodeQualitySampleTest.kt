package org.gradle.script.lang.kotlin.samples

import org.gradle.testkit.runner.TaskOutcome

import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.assertThat

import org.junit.Test


class CodeQualitySampleTest : AbstractSampleTest("code-quality") {

    @Test
    fun `code quality plugins are properly configured`() {

        val result = build("build")

        val successfulTasks = listOf(
            ":checkstyleMain",
            ":checkstyleTest",
            ":findbugsMain",
            ":findbugsTest",
            ":pmdMain",
            ":pmdTest",
            ":jdependMain",
            ":jdependTest",
            ":jacocoTestCoverageVerification")

        successfulTasks.forEach { taskName ->
            assertThat(result.task(taskName).outcome, equalTo(TaskOutcome.SUCCESS))
        }
    }
}
