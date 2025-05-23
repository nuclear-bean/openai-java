// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads.runs.steps

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileSearchToolCallDeltaTest {

    @Test
    fun create() {
        val fileSearchToolCallDelta =
            FileSearchToolCallDelta.builder()
                .fileSearch(JsonValue.from(mapOf<String, Any>()))
                .index(0L)
                .id("id")
                .build()

        assertThat(fileSearchToolCallDelta._fileSearch())
            .isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(fileSearchToolCallDelta.index()).isEqualTo(0L)
        assertThat(fileSearchToolCallDelta.id()).contains("id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val fileSearchToolCallDelta =
            FileSearchToolCallDelta.builder()
                .fileSearch(JsonValue.from(mapOf<String, Any>()))
                .index(0L)
                .id("id")
                .build()

        val roundtrippedFileSearchToolCallDelta =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fileSearchToolCallDelta),
                jacksonTypeRef<FileSearchToolCallDelta>(),
            )

        assertThat(roundtrippedFileSearchToolCallDelta).isEqualTo(fileSearchToolCallDelta)
    }
}
